boolean schedule(BulkBatch batch)
{/*ALCODESTART::1432128973049*/
batch.inProgress = true;

for (Order order : batch.orders) {
	batches.add(order.batch);
	times.add(order.batch.size / main.maxRate);
}
fluidConvert.setBatchOut(batches.get(0), 
						 main.getColor(batches.get(0).type));
changeBatch.restart(times.get(0));
return true;
/*ALCODEEND*/}

BulkBatch getOutputBatch()
{/*ALCODESTART::1434929352450*/
if (batches.size() > 0)
	return batches.get(0);
return new BulkBatch(0, 0);
/*ALCODEEND*/}

