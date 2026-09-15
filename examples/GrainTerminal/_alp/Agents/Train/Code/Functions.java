double unload()
{/*ALCODESTART::1439300793847*/
main.rescheduleTrain();
grainExit.connect(main.trainEnter);
valve.open();
/*ALCODEEND*/}

boolean isUnloading()
{/*ALCODESTART::1439302834236*/
return trainSilo.amount() < capacity;
/*ALCODEEND*/}

