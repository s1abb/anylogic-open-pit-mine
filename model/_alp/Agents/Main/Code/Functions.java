double onRunInitialised()
{/*ALCODESTART::1789547667834*/
traceln("onRunInitialised() called");
source.inject(numDumpTrucks);
traceln("Trucks in population after inject: " + p_dumpTrucks.size());
DumpTruck t = p_dumpTrucks.get(0);
traceln("First truck at: " + t.getX() + ", " + t.getY() + ", " + t.getZ());
/*ALCODEEND*/}

ResourcePool[][] buildLoadingPointResourceSets()
{/*ALCODESTART::1789548528511*/
List<ResourcePool[]> sets = new ArrayList<>();
for (LoadingPoint lp : p_loadingPoints) {
    if (lp.pool != null) {
        sets.add(new ResourcePool[]{ lp.pool });
    }
}
return sets.toArray(new ResourcePool[0][]);
/*ALCODEEND*/}

a_Node findANodeById(String nodeId)
{/*ALCODESTART::1789608877713*/
return p_Network.p_Nodes.stream()
    .filter(n -> n.id.equals(nodeId))
    .findFirst()
    .orElse(null);
/*ALCODEEND*/}

ResourcePool[][] buildDumpingPointResourceSets()
{/*ALCODESTART::1789634291281*/
List<ResourcePool[]> sets = new ArrayList<>();
for (DumpingPoint dp : p_dumpingPoints) {
    if (dp.pool != null) {
        sets.add(new ResourcePool[]{ dp.pool });
    }
}
return sets.toArray(new ResourcePool[0][]);
/*ALCODEEND*/}

double loadTaskMatrix(String csvFilePath)
{/*ALCODESTART::1789634749929*/
taskMatrix = new Task[TaskEvent.values().length][2];
try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
    CSVParser parser = CSVParser.parse(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
    for (CSVRecord record : parser) {
        TaskEvent event = TaskEvent.valueOf(record.get("event"));
        boolean shift = Boolean.parseBoolean(record.get("shiftActive"));
        Task task = Task.valueOf(record.get("nextTask"));
        taskMatrix[event.ordinal()][shift ? 1 : 0] = task;
    }
} catch (IOException e) {
    logger.error("Error loading task matrix: {}", e.getMessage(), e);
    traceln("Error loading task matrix: " + e.getMessage());
}
/*ALCODEEND*/}

Task nextTask(TaskEvent event,boolean shift)
{/*ALCODESTART::1789688464665*/
return taskMatrix[event.ordinal()][shift ? 1 : 0];
/*ALCODEEND*/}

