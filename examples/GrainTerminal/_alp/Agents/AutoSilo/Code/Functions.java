boolean isFull()
{/*ALCODESTART::1434914514298*/
return freeSpace() == 0;
/*ALCODEEND*/}

double findDirection(BulkBatch batch)
{/*ALCODESTART::1434914514300*/
fluidSelectOutput.set_selectOutput1(!batch.orders.get(0).toSilo.equals(this));
/*ALCODEEND*/}

boolean isEmpty()
{/*ALCODESTART::1434914514302*/
return silo.isEmpty();
/*ALCODEEND*/}

FluidEnter getOutEnter()
{/*ALCODESTART::1434914514304*/
if (id < main.silos.size() / 2) 
	return main.leftUnloadEnter;
else return main.rightUnloadEnter;
/*ALCODEEND*/}

double freeSpace()
{/*ALCODESTART::1434919923226*/
return silo.capacity - silo.amount();
/*ALCODEEND*/}

double amount()
{/*ALCODESTART::1434924606297*/
return ceil(silo.amount());
/*ALCODEEND*/}

double unload()
{/*ALCODESTART::1439211939512*/
fluidConvertOut.setBatchOut(setOutputBatch());
siloValve.dispense(amount());
/*ALCODEEND*/}

BulkBatch setOutputBatch()
{/*ALCODESTART::1439214789821*/
BulkBatch outputBatch = new BulkBatch(0, 0);
if (!isEmpty()) {
	outputBatch = new BulkBatch(currentBulkType, amount());
	outputBatch.orders.addAll(orders);
	orders.clear();
}
return outputBatch;	
/*ALCODEEND*/}

