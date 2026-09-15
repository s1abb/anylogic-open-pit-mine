double connectToShip(Ship ship)
{/*ALCODESTART::1439885503957*/
if (ship == null) return;

for (int i = 0; i < bilgeExits.size(); i++) {
	FluidExit exit = bilgeExits.get(i);
	FluidEnter enter = ship.bilgeEnters.get(i);
	exit.connect(enter);	
}


/*ALCODEEND*/}

double route(int index,BulkBatch batch)
{/*ALCODESTART::1439888660896*/
if (ship == null) return;

FluidSelectOutput fSO = junctions.get(index);
fSO.set_selectOutput1(index != batch.orders.get(0).targetBilge);//!ship.canLoad(index, batch));

/*ALCODEEND*/}

double disconnectFromShip()
{/*ALCODESTART::1440339910367*/
for (int i = 0; i < bilgeExits.size(); i++) {
	FluidExit exit = bilgeExits.get(i);
	exit.disconnect();	
}
ship = null;
/*ALCODEEND*/}

double loadedAmount(int type)
{/*ALCODESTART::1440571584287*/
if (ship == null) return 0;
return ship.loadedAmount(type);
/*ALCODEEND*/}

