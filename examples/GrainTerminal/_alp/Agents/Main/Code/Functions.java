double rescheduleTrucks()
{/*ALCODESTART::1431278665404*/
for (AutoSilo autoSilo : autoSilos)
	if (autoSilo.isUnloading) return;


for (AutoSilo autoSilo : autoSilos) {
	if (autoSilo.isLoading) continue;
	if (autoSilo.isEmpty()) continue;
	if (autoSilo.amount() < autoSiloThr) continue;
	
	BulkBatch batch = new BulkBatch(autoSilo.currentBulkType,
									autoSilo.amount());
									
	ArrayList<Order> orders = scheduler.schedule(batch, "auto");
		
	for (Order order : orders)
		order.fromSilo = autoSilo;
	
	if (!orders.isEmpty()) {
		autoSilo.orders.addAll(orders);
		autoSilo.isUnloading = true;
		if (autoSilo.id < autoSilos.size() / 2)
			autoSilos.get(autoSilos.size() / 2 - 1).unloadExit.connect(autoEnter);
		else
			autoSilos.get(autoSilos.size() - 1).unloadExit.connect(autoEnter);	
		autoSilo.unload();
		autoValve.open();
		return;
	} else autoSilo.siloValve.close();
}
/*ALCODEEND*/}

double rescheduleTrain()
{/*ALCODESTART::1431278669662*/
if(trainUnloadingGrain.size() == 0) return;

Train train = trainUnloadingGrain.get(0);
if (train.isUnloading()) return;

BulkBatch batch = (BulkBatch)train.trainSilo.getBatch(0);
if (batch.inProgress) return;

ArrayList<Order> orders = scheduler.schedule(batch, "train");

if (orders.isEmpty()) return;

batch.orders.addAll(orders);
trainValve.dispense(batch.size);
/*ALCODEEND*/}

double rescheduleAll()
{/*ALCODESTART::1431278692791*/
if(trainUnloadingGrain.size() > 0) {
	Train train = trainUnloadingGrain.get(0);
	if(!train.isUnloading())
		rescheduleTrain();
}
rescheduleTrucks();
//checkAuto();
exitHold.recalculateConditions();
/*ALCODEEND*/}

Color getColor(int type)
{/*ALCODESTART::1431416519803*/
return batchColors[type];
/*ALCODEEND*/}

double checkAll()
{/*ALCODESTART::1432387256769*/
scheduler.checkUnloading();
rescheduleAll();
/*ALCODEEND*/}

boolean findRowToUnload(Truck truck,AutoSilosRow row)
{/*ALCODESTART::1434917950752*/
return row.findSiloToLoad(truck.grainType, truck.capacity) != null;
/*ALCODEEND*/}

boolean isAbleToUnloadInstantly(Truck truck)
{/*ALCODESTART::1434963807673*/
if (rows.idle() == 0) return false;
if ( findFirst( parkingLotReservations.values(), nReserved -> nReserved > 0 ) != null  )
	return false;
return isAbleToUnload(truck);
/*ALCODEEND*/}

boolean isAbleToUnload(Truck truck)
{/*ALCODESTART::1434965219748*/
for (AutoSilosRow aSR : autoSilosRows) {
	if( aSR.isIdle() && findRowToUnload(truck, aSR))
		return true;		
}
return false;
/*ALCODEEND*/}

Pier initializePiers()
{/*ALCODESTART::1439897389808*/
int n = piers.size();

int nMin = 0;
if (n == 1)	nMin = 5;

Pier pier = new Pier("pier" + (n + 1),  piersConveyors.get(nMin), 
				piersConveyors.get(nMin + 1), piersConveyors.get(nMin + 2), 
				piersConveyors.get(nMin + 3), piersConveyors.get(nMin + 4));

return pier;
/*ALCODEEND*/}

boolean anyCanGoToUnload()
{/*ALCODESTART::1440501965926*/
if (seizeRow1.queue.size() == 0) 
	return true;

for (Truck auto : seizeRow1.queue) {
	if (canGoToUnload(auto))
		return true;
}

return false;
/*ALCODEEND*/}

boolean canGoToUnload(Truck truck)
{/*ALCODESTART::1440502601790*/
for (AutoSilosRow aSR : autoSilosRows) {
	if(findRowToUnload(truck, aSR))
		return true;		
}
return false;
/*ALCODEEND*/}

double navigate(ViewArea viewArea)
{/*ALCODESTART::1505810592825*/
selectedViewArea = viewArea;
viewArea.navigateTo();
groupMainMenu.setPos( viewArea.getX(), viewArea.getY() );
/*ALCODEEND*/}

double getUnreservedSize(int type)
{/*ALCODESTART::1527776403940*/
double grainSize = scheduler.amountInSilos(type) - scheduler.amountOfUnloading(type);
for ( Ship ship : filter( ships, s -> ( s.request != null ) && !s.request.unloading ) ) 
	grainSize -= ship.request.getTotalSizeForType(type);

return grainSize;
/*ALCODEEND*/}

double releaseParkingPlace(Truck car)
{/*ALCODESTART::1543584280685*/
parkingLotReservations.put(car.parkingLot, parkingLotReservations.get(car.parkingLot) - 1 );
/*ALCODEEND*/}

boolean getParkPlace(Truck truck)
{/*ALCODESTART::1543584312851*/
int nReserved = 0;
for ( ParkingLot parking : parkingLotReservations.keySet() ) {
	nReserved = parkingLotReservations.get( parking );
	if ( nReserved < parking.nSpaces() ) {
		truck.parkingLot = parking;
		parkingLotReservations.put(parking, ++nReserved);
		return true;
	}	
}
return false;
/*ALCODEEND*/}

double parkingReservationsInitialize()
{/*ALCODESTART::1543584383418*/
parkingLotReservations.put(parkingLot, 0);
parkingLotReservations.put(parkingLot1, 0);
parkingLotReservations.put(parkingLot2, 0);
parkingLotReservations.put(parkingLot3, 0);
/*ALCODEEND*/}

