double onRunInitialised()
{/*ALCODESTART::1789547667834*/
source.inject(numDumpTrucks);
DumpTruck t = p_dumpTrucks.get(0);
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

Node findNodeById(String nodeId)
{/*ALCODESTART::1789689972207*/
a_Node node = findANodeById(nodeId);
return node != null ? node.v_PointNode : null;
/*ALCODEEND*/}

LoadingPoint selectLoadingPoint()
{/*ALCODESTART::1789711385731*/
double bestScore = -1;
List<LoadingPoint> candidates = new ArrayList<>();
for (LoadingPoint lp : p_loadingPoints) {
    if (lp.amount <= 0) continue;
    double score = lp.amount / (lp.assignedTrucks + 1);
    if (score > bestScore + 1e-9) {
        bestScore = score;
        candidates.clear();
        candidates.add(lp);
    } else if (Math.abs(score - bestScore) < 1e-9) {
        candidates.add(lp);
    }
}
if (candidates.isEmpty()) {
    logger.info("selectLoadingPoint: no candidates left, all depleted");
    return null;
}
LoadingPoint chosen = candidates.get(uniform_discr(0, candidates.size() - 1));
chosen.assignedTrucks++;
logger.info("selectLoadingPoint: chose {} (amount={}, assignedTrucks={}, score={})",
    chosen.id, chosen.amount, chosen.assignedTrucks, bestScore);
return chosen;
/*ALCODEEND*/}

