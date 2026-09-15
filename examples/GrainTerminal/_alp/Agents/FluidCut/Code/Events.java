void changeBatch()
{/*ALCODESTART::1432113661264*/
times.remove(0); 
batches.remove(0);
if (batches.size() > 0) {
	fluidConvert.setBatchOut(batches.get(0), 
							 main.getColor(batches.get(0).type));
	self.restart(times.get(0));
} else {
	main.rescheduleAll();	
}
/*ALCODEEND*/}

