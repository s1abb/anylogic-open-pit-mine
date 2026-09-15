void loaded()
{/*ALCODESTART::1438955599952*/
isLoading = false;
if (silo.amount() >= main.autoSiloThr)
	main.rescheduleTrucks();
/*ALCODEEND*/}

