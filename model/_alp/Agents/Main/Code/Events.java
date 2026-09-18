void shiftBreakStart()
{/*ALCODESTART::1789701542943*/
shiftActive = true;
logger.info("Shift break started");
/*ALCODEEND*/}

void shiftBreakEnd()
{/*ALCODESTART::1789701736234*/
shiftActive = false;

for (DumpTruck t : p_dumpTrucks) {
    if (t.currentTask == Task.WAIT_AT_HOME) {
        t.currentTask = nextTask(TaskEvent.HOME_ARRIVAL, shiftActive);
    }
}

hold.recalculateConditions();
logger.info("Shift break ended");
/*ALCODEEND*/}

