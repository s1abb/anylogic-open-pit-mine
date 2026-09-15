void completeShipLoading()
{/*ALCODESTART::1435013436114*/
for (ShipRequest request : completedRequests) {
	main.shipLoading.stopDelay(request.ship);
	shipRequests.remove(request);
}
completedRequests.clear();
checkUnloading();
main.rescheduleAll();
/*ALCODEEND*/}

