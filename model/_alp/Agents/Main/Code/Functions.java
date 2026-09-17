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

