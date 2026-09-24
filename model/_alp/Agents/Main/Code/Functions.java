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

double tryAssignLoadingPoint(LoadingPoint lp)
{/*ALCODESTART::1789952755771*/
if (lp == null || lp.occupied) return;
for (DumpTruck waiting : loadingQueue) {
    if (waiting.currentLoadingPoint == lp) {
        lp.occupied = true;
        loadingQueue.release(waiting);
        return;
    }
}
/*ALCODEEND*/}

double distanceToSegment(double px,double py,double pz,a_Edge.VertexPoint v1,a_Edge.VertexPoint v2)
{/*ALCODESTART::1790146141046*/
double dx = v2.x - v1.x;
double dy = v2.y - v1.y;
double dz = v2.z - v1.z;
double lengthSq = dx*dx + dy*dy + dz*dz;

double t = lengthSq > 0 ? ((px - v1.x) * dx + (py - v1.y) * dy + (pz - v1.z) * dz) / lengthSq : 0;
t = Math.max(0, Math.min(1, t)); // clamp to the segment's own endpoints

double closestX = v1.x + t * dx;
double closestY = v1.y + t * dy;
double closestZ = v1.z + t * dz;

double ddx = px - closestX, ddy = py - closestY, ddz = pz - closestZ;
return Math.sqrt(ddx*ddx + ddy*ddy + ddz*ddz);
/*ALCODEEND*/}

a_Edge.VertexPoint[] findNearestSegment(a_Edge edge,double x,double y,double z)
{/*ALCODESTART::1790146275341*/
a_Node startNode = findANodeById(edge.startNodeId);
a_Node endNode = findANodeById(edge.endNodeId);
if (startNode == null || endNode == null) return null;

List<a_Edge.VertexPoint> points = new ArrayList<>();
points.add(new a_Edge.VertexPoint(startNode.x, startNode.y, startNode.z));
if (edge.vertices != null) points.addAll(edge.vertices);
points.add(new a_Edge.VertexPoint(endNode.x, endNode.y, endNode.z));

double bestDist = Double.MAX_VALUE;
a_Edge.VertexPoint[] best = null;

for (int i = 0; i < points.size() - 1; i++) {
    a_Edge.VertexPoint p1 = points.get(i);
    a_Edge.VertexPoint p2 = points.get(i + 1);
    double d = distanceToSegment(x, y, z, p1, p2);
    if (d < bestDist) {
        bestDist = d;
        best = new a_Edge.VertexPoint[]{ p1, p2 };
    }
}
return best;
/*ALCODEEND*/}

double calculateGrade(a_Edge.VertexPoint v1,a_Edge.VertexPoint v2)
{/*ALCODESTART::1790153278786*/
double horizontalDist = Math.sqrt(Math.pow(v2.x - v1.x, 2) + Math.pow(v2.y - v1.y, 2));
if (horizontalDist == 0) return 0;
return 100.0 * (v2.z - v1.z) / horizontalDist;
/*ALCODEEND*/}

double computeTargetSpeedKmh(DumpTruck truck,double grade)
{/*ALCODESTART::1790153327114*/
double clampedGrade = Math.max(-15, Math.min(20, grade));
boolean loaded = (truck.currentTask == Task.TO_DUMP || truck.currentTask == Task.DUMP);
return loaded
    ? gradePctMaxSpeedKmhLoaded(clampedGrade)
    : gradePctMaxSpeedKmhEmpty(clampedGrade);
/*ALCODEEND*/}

double updateTruckSpeed(DumpTruck truck)
{/*ALCODESTART::1790153390664*/
if (!truck.isMoving()) return; // nothing to update while stationary (loading, dumping, waiting)

Path nearestPath = p_Network.v_Network.getNearestPath(truck, null);
if (nearestPath == null) return;

a_Edge edge = p_Network.pathToEdge.get(nearestPath);
if (edge == null) return;

a_Edge.VertexPoint[] segment = findNearestSegment(edge, truck.getX(), truck.getY(), truck.getZ());
if (segment == null) return;

double grade = calculateGrade(segment[0], segment[1]);
double targetSpeedKmh = computeTargetSpeedKmh(truck, grade);

truck.setSpeed(targetSpeedKmh, KPH);
/*ALCODEEND*/}

