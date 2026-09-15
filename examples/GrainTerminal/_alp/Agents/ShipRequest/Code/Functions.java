boolean isProcessed()
{/*ALCODESTART::1434492095857*/
return unloading && orders.isEmpty();
/*ALCODEEND*/}

String toString()
{/*ALCODESTART::1434494600213*/
String s =  "Unloading: " + unloading + ", Destination: " + destination;
s += " [";
for (int i = 0; i < sizes.length; i++)
  s += "(" + types[i] + "," + sizes[i] + ") ";
s += "]. Orders: " + orders;

return s;
/*ALCODEEND*/}

double getTotalSizeForType(int type)
{/*ALCODESTART::1440622969644*/
double sz = 0;
for (int i = 0; i < types.length; i++)
  if (types[i] == type)
  	sz += sizes[i];
return sz;
/*ALCODEEND*/}

