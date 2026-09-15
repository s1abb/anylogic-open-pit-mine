String toString()
{/*ALCODESTART::1434305377970*/
return "BulkBatch, type: " + type + ", size: " + size + ", row: " + row() + " order: " + orders + ", inProgress: " + inProgress;
/*ALCODEEND*/}

int routingTo()
{/*ALCODESTART::1439463202779*/
if (orders.isEmpty()) return 0;

String tag = orders.get(0).toTag;
if(tag.equals("left") || tag.equals("pier1")) return 1;
if(tag.equals("right") || tag.equals("pier2")) return 2;

return 0;
/*ALCODEEND*/}

int row()
{/*ALCODESTART::1440079834749*/
if (orders.isEmpty()) return -1;
if ((Silo)(orders.get(0).toSilo) == null) return -1;
return ((Silo)(orders.get(0).toSilo)).getRow();
/*ALCODEEND*/}

