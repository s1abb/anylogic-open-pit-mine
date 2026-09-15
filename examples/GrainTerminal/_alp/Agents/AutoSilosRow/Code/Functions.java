double initialize()
{/*ALCODESTART::1434917128826*/
int n = main.autoSilos.size()/2;

int idStart = (id == 0 ? 0 : n);
int idEnd = (id == 0 ? n : 2*n);

for(int i = idStart; i < idEnd; i++)
	autoSilos.add(main.autoSilos.get(i));
/*ALCODEEND*/}

AutoSilo findSiloToLoad(int type,double size)
{/*ALCODESTART::1434919610039*/
for (AutoSilo autoSilo : autoSilos) {
	if (autoSilo.isUnloading || autoSilo.isLoading) continue;
	
	if (autoSilo.currentBulkType == type && autoSilo.freeSpace() >= size)
		return autoSilo;
}

for (AutoSilo autoSilo : autoSilos) {
	if (autoSilo.isUnloading || autoSilo.isLoading) continue;
	
	if (autoSilo.isEmpty())
		return autoSilo;
}

return null;
/*ALCODEEND*/}

double load(Truck truck)
{/*ALCODESTART::1434920584724*/
AutoSilo destination = findSiloToLoad(truck.grainType, truck.capacity);
truck.order = new Order(null, null, destination, "", "");
destination.currentBulkType = truck.grainType;
destination.isLoading = true;
truck.exit.connect(autoSilos.get(0).loadEnter);
/*ALCODEEND*/}

