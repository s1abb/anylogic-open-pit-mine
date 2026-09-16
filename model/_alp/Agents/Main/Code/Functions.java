double onRunInitialised()
{/*ALCODESTART::1789547667834*/
traceln("onRunInitialised() called");
source.inject(numDumpTrucks);
traceln("Trucks in population after inject: " + p_dumpTrucks.size());
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

