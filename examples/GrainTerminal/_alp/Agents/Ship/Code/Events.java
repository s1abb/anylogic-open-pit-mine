void completeOrder()
{/*ALCODESTART::1439889936996*/
if (!currentBatch.orders.isEmpty())
	main.scheduler.completeUnloadOrder(currentBatch);
/*ALCODEEND*/}

