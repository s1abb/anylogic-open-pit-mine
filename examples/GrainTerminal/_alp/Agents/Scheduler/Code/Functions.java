double spaceInRow(int row,int batchType)
{/*ALCODESTART::1431265135740*/
double space = 0;
for (int i = 0; i < main.silosPerRow; i++ ) {
	Silo s = main.silos.get(main.silosPerRow*row + i);
	if (batchType == s.currentBulkType || s.isEmpty()) space += s.freeSpace();
}
return space;
/*ALCODEEND*/}

double completeOrder(BulkBatch batch)
{/*ALCODESTART::1431270535354*/
if (batch.orders.get(0).fromSilo != null ) {
	AutoSilo autoSilo = (AutoSilo)batch.orders.get(0).fromSilo;
	autoSilo.siloValve.close();
	autoSilo.isUnloading = false;
}

boolean removed = leftLoadOrders.remove(batch.orders.get(0));
removed |= rightLoadOrders.remove(batch.orders.get(0));

batch.orders.clear();

checkUnloading();
main.rescheduleAll();
/*ALCODEEND*/}

boolean enoughToUnload(ShipRequest request)
{/*ALCODESTART::1431430453983*/
for (int type = 0; type < main.numOfTypes; type++) {
	double size = request.getTotalSizeForType(type);
	
	if (size == 0)
		continue;
	
	double space = 0;
	for(Silo silo : main.silos) {
		if (!silo.canUnload(type)) continue;
		if (!isSiloLoading(silo))
			space += silo.availableForUnload();
	}
	if (size > space)
		return false;
}

return true;
/*ALCODEEND*/}

boolean isSiloLoading(Silo silo)
{/*ALCODESTART::1431430669078*/
if (silo.getRow() < main.nRows / 2) {
	for (Order order : leftLoadOrders)
		if (((Silo)order.toSilo).equals(silo)) return true;
} else {
	for (Order order : rightLoadOrders)
		if(((Silo)order.toSilo).equals(silo)) return true;
}
return false;
/*ALCODEEND*/}

double completeUnloadOrder(BulkBatch batch)
{/*ALCODESTART::1431439878214*/
Order order = batch.orders.get(0);
((Silo)order.fromSilo).removeOrder(order);

ordersInProgress.remove(order);
unloadOrders.remove(order);

double waitTime = 0;
for (ShipRequest request : shipRequests) {
    if (!request.orders.contains(order))
		continue;
	
	boolean removed = request.orders.remove(order);
    if (request.isProcessed())
    	completedRequests.add(request);
}

waitTime = 0.1;

if (waitTime > 0 && 
	(completeShipLoading.getRest() < waitTime || 
     completeShipLoading.getRest() == Double.POSITIVE_INFINITY))
	completeShipLoading.restart(waitTime);
/*ALCODEEND*/}

boolean isSiloUnloading(Silo silo)
{/*ALCODESTART::1431508085107*/
for (Order order : unloadOrders)
	if (((Silo)order.fromSilo).equals(silo)) return true;
return false;
/*ALCODEEND*/}

ArrayList<Silo> findSilos(int batchType,double batchSize,String fromTag,boolean checkLoading)
{/*ALCODESTART::1432131021556*/
currentSilos.clear();
double size = findSilosOnSide(batchType, batchSize, fromTag, leftLoadOrders, 
								0, main.silosPerRow*main.nRows / 2, checkLoading);
if (size == 0) return currentSilos;
size = findSilosOnSide(batchType, size, fromTag, rightLoadOrders, 
						main.silosPerRow*main.nRows/2, main.silosPerRow*main.nRows,
						checkLoading);
if (size == 0) return currentSilos;
else return new ArrayList<>();
/*ALCODEEND*/}

ArrayList<Order> schedule(BulkBatch batch,String fromTag)
{/*ALCODESTART::1432131021558*/
ArrayList<Silo> silos = new ArrayList<>();
silos.addAll(findSilos(batch.type, batch.size, fromTag, false));
currentSilos.clear();

if (silos.isEmpty()) {
	return new ArrayList<>();
}

ArrayList<Order> orders = new ArrayList<>();	
double bS = batch.size;

for (Silo s : silos) {	
	double reserve = min(s.freeSpace(), bS);
	if (reserve < main.eps) continue;
	if (s.isEmpty()) s.currentBulkType = batch.type;
	
	bS -= reserve;
	s.reserved += reserve;
	
	BulkBatch newBatch = new BulkBatch(batch.type, reserve);
	
	Order order = new Order(newBatch, null, s, fromTag, "");	
	order.size = newBatch.size;
	order.type = newBatch.type;
	orders.add(order);
	newBatch.orders.add(order);
	if (newBatch.row() < main.nRows / 2) {
		leftLoadOrders.add(order);
		order.set_toTag("left");
	} else {
		rightLoadOrders.add(order);
		order.set_toTag("right");
	}
}

return orders;
/*ALCODEEND*/}

double checkRequests()
{/*ALCODESTART::1432312208959*/
int N = min(shipRequests.size(), 2);
for (int k = 0; k < N; k++) {
	ShipRequest request = shipRequests.get(k);
	
	if (!enoughToUnload(request)) continue;
	if (request.unloading) continue;

	for (int i = 0; i < request.types.length; i++) {
		double size = request.sizes[i];
		int type = request.types[i];

		for (Silo silo : main.silos) {	
			if (!silo.canUnload(type)) continue;
		
			if(!isSiloLoading(silo)) {
				double reserve = min(silo.availableForUnload(), 
									 min(size, main.bilgeCapacity));
				if (reserve <= 1.0) continue;
				size -= reserve;
			
				Order order = new Order(null, silo, null, "", request.destination);
				order.size = reserve;
				order.type = type;
				order.targetBilge = i;
				
				if (silo.getIndex() < main.silos.size() / 2) order.set_fromTag("left");
				else order.set_fromTag("right");
				silo.unloadOrders.add(order);
				main.storageTanks.get(silo.id).setColor(main.unloadingSiloColor);
				unloadOrders.add(order);
				request.orders.add(order);		
			}
		}
	}
	request.unloading = true;
}
/*ALCODEEND*/}

boolean checkUnloading()
{/*ALCODESTART::1432386216551*/
checkRequests();

for (int i = 0; i < unloadOrders.size(); i++) {
	Order order = unloadOrders.get(i);

	if (ordersInProgress.contains(order)) continue;
	
	if ((ordersInProgress.size() == 0) ||
		(ordersInProgress.size() == 1 && isSimultaneously(order))) {
		ordersInProgress.add(order);
		((Silo)order.fromSilo).unload(order);
		return true;
	} else continue;
}
return false;
/*ALCODEEND*/}

double amountOfLoading(int type)
{/*ALCODESTART::1432509813086*/
double amount = 0;

for (Order order : leftLoadOrders) {
	if (order.batch.type == type) { 
		Silo silo = (Silo)order.toSilo;
		amount += (order.batch.size - silo.loadingAmount());
	}
}

for (Order order : rightLoadOrders) {
	if (order.batch.type == type) { 
		Silo silo = (Silo)order.toSilo;
		amount += (order.batch.size - silo.loadingAmount());
	}
}

return amount;
/*ALCODEEND*/}

double amountInSilos(int type)
{/*ALCODESTART::1432509813088*/
double amount = 0;

for (Silo silo : main.silos) {
	if (silo.currentBulkType == type) 
		amount += silo.silo.amount();
}

return amount;
/*ALCODEEND*/}

double amountOfUnloading(int type)
{/*ALCODESTART::1432509813090*/
double amount = 0;

for (Silo silo : main.silos) {
	if (silo.isEmpty() || silo.currentBulkType != type)
		continue;
	
	amount += silo.unloadingAmount();
}

return amount;
/*ALCODEEND*/}

boolean isSimultaneously(Order order)
{/*ALCODESTART::1434907507727*/
Order currentOrder  = ordersInProgress.get(0);

if (currentOrder.fromTag.equals(order.fromTag))
	return false;

if (currentOrder.toTag.equals(order.toTag))
	return false;

return true;
/*ALCODEEND*/}

double findSilosOnSide(int batchType,double batchSize,String fromTag,LinkedHashSet<Order> orderList,int startSilo,int endSilo,boolean checkLoading)
{/*ALCODESTART::1440597753653*/
for (Order o: orderList) {
	if (!o.fromTag.equals(fromTag))
		return batchSize;
}

double bS = batchSize;

// First, try to fill-in the single non-empty silo
for (int i = startSilo; i < endSilo; i++) {
	Silo s = main.silos.get(i);

	if (isSiloUnloading(s))
		continue;
	
	if (!s.isEmpty() && 
		s.currentBulkType == batchType && 
		s.freeSpace() >= bS) {
		currentSilos.add(s);
		return 0;
	}
}


for (int i = startSilo; i < endSilo; i++) {
	Silo s = main.silos.get(i);
	
	if (isSiloUnloading(s))
		continue;
	
	if (!s.isEmpty() && s.currentBulkType != batchType)
		continue;

	double reserve = min(s.freeSpace(), bS);
	if (reserve < main.eps) continue;
	currentSilos.add(s);
	bS -= reserve;
	if (bS < main.eps) return 0;
}
return bS;
/*ALCODEEND*/}

boolean checkInvariants()
{/*ALCODESTART::1440954512559*/
String tag = "";
double[] capacities = new double[main.silos.size()];
for (int i = 0; i < main.silos.size(); i++)
	capacities[i] = main.silos.get(i).freeSpace();

for (Order o: leftLoadOrders) {
	if (tag.equals("")) tag = o.fromTag;
	
	// Invariant 1: we need to unload from a single source on side
	if (!tag.equals(o.fromTag))
		return false;
		
	// Invariant 2: everything must fit
	
}

return false;
/*ALCODEEND*/}

