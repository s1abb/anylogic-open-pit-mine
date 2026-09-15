void loaded()
{/*ALCODESTART::1438782665837*/
if (!currentBatch.orders.isEmpty() && ((Silo)currentBatch.orders.get(0).toSilo).equals(this)) {
	reserved -= currentBatch.size;
	main.scheduler.completeOrder(currentBatch);
}
amountBeforeLoading = 0;
/*ALCODEEND*/}

