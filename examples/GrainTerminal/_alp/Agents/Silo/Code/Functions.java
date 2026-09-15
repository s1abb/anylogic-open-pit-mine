double freeSpace()
{/*ALCODESTART::1430142636805*/
return capacity - silo.amount() - reserved;
/*ALCODEEND*/}

boolean isFull()
{/*ALCODESTART::1430391365102*/
return freeSpace() == 0;
/*ALCODEEND*/}

double findDirection(BulkBatch batch)
{/*ALCODESTART::1430817513940*/
fluidSelectOutput.set_selectOutput1(!batch.orders.get(0).toSilo.equals(this));
/*ALCODEEND*/}

boolean isEmpty()
{/*ALCODESTART::1430974860654*/
return silo.isEmpty();
/*ALCODEEND*/}

double unload(Order order)
{/*ALCODESTART::1431434437194*/
amountBeforeUnloading = silo.amount();
activeUnloadingOrder = order;
fluidConvertOut.setBatchOut(setOutputBatch());
siloValve.dispense(order.size, CUBIC_METER);
/*ALCODEEND*/}

FluidEnter getOutEnter()
{/*ALCODESTART::1431436166352*/
if (id < main.silos.size() / 2) 
	return main.leftUnloadEnter;
else return main.rightUnloadEnter;
/*ALCODEEND*/}

boolean canUnload(int type)
{/*ALCODESTART::1431511298745*/
if (isEmpty() || (currentBulkType != type)) return false;
return availableForUnload() > 1.0;
/*ALCODEEND*/}

double reservedForUnload()
{/*ALCODESTART::1431598616849*/
double res = 0;
for (Order order : unloadOrders) res+= order.size;
return res;
/*ALCODEEND*/}

double removeOrder(Order order)
{/*ALCODESTART::1431599152486*/
main.storageTanks.get(id).setColor(main.siloColor);
amountBeforeUnloading = 0;
unloadOrders.remove(activeUnloadingOrder);
activeUnloadingOrder = null;
/*ALCODEEND*/}

double availableForUnload()
{/*ALCODESTART::1431599553851*/
return max(silo.amount() - reservedForUnload(), 0);
/*ALCODEEND*/}

double utilizationTotal()
{/*ALCODESTART::1435142626469*/
return silo.utilizationTotal();
/*ALCODEEND*/}

BulkBatch setOutputBatch()
{/*ALCODESTART::1439201391068*/
BulkBatch outputBatch = new BulkBatch(0, 0);
if (activeUnloadingOrder != null) {
	outputBatch =  new BulkBatch(currentBulkType, activeUnloadingOrder.size);
	outputBatch.orders.add(activeUnloadingOrder);
	outputBatch.orders.get(0).batch = outputBatch;
}
return outputBatch;	
/*ALCODEEND*/}

int getRow()
{/*ALCODESTART::1440080019384*/
return id / main.silosPerRow;
/*ALCODEEND*/}

double loadingAmount()
{/*ALCODESTART::1440568169537*/
if (silo.currentRateIn() == 0) return 0;
return silo.amount() - amountBeforeLoading;
/*ALCODEEND*/}

double unloadingAmount()
{/*ALCODESTART::1440569285018*/
double amount = 0;
for (Order order : unloadOrders) {
	if (order == activeUnloadingOrder)
		continue;
	
	amount += order.size;
}

if (activeUnloadingOrder != null) {
	amount += activeUnloadingOrder.size - (amountBeforeUnloading - silo.amount());
}

/*
if (silo.currentRateOut() == 0 && 
	(activeUnloadingOrder != null)) 
	return activeUnloadingOrder.size;
if (silo.currentRateOut() != 0) 
	return amountBeforeUnloading - silo.amount();
return 0;*/

return amount;
/*ALCODEEND*/}

String toString()
{/*ALCODESTART::1440956668392*/
return "Silo[" + id + "]: type: " + currentBulkType + ", free: " + freeSpace(); 
/*ALCODEEND*/}

