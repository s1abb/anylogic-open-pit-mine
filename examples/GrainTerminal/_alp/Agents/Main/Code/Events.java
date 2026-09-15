void connectInConveyors()
{/*ALCODESTART::1430939249540*/
for (int i = 0; i < silos.size(); i++ ) {
	if ((i % silosPerRow) != (silosPerRow - 1)) silos.get(i).loadExit.connect(silos.get(i+1).loadEnter);
}

int nas = autoSilos.size() /2;
for (int k = 0; k < 2*nas; k++) {
	if ((k % nas) != (nas-1)) autoSilos.get(k).loadExit.connect(autoSilos.get(k+1).loadEnter); 
}

/*ALCODEEND*/}

void connectOutConveyors()
{/*ALCODESTART::1431426275000*/
for (int i = 0; i < silos.size(); i++ ) {
	if ((i % silosPerRow) != (silosPerRow - 1)) 
		silos.get(i).unloadExit.connect(silos.get(i+1).unloadEnter);
}

int nas = autoSilos.size()/2;
for (int j = 0; j < 2*nas; j++ ) {
	if ((j % nas) != (nas - 1)) 
		autoSilos.get(j).unloadExit.connect(autoSilos.get(j+1).unloadEnter);
}
/*ALCODEEND*/}

void shipArrival()
{/*ALCODESTART::1527771557232*/
shipSource.inject( numberOfShips );
/*ALCODEEND*/}

