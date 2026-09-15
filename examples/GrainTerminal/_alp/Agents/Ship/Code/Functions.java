double getFullness(int index)
{/*ALCODESTART::1439889936932*/
if (pier == null) return 1.0;

int idx = index;
if (pier.name.equals("pier1")) idx = 4 - index;

Tank bilge = bilges.get(idx);
return bilge.amount()  / bilge.capacity;
/*ALCODEEND*/}

Color getGrainColor(int index)
{/*ALCODESTART::1439889936934*/
Color emptyColor = new Color(100, 0, 0);

if (pier == null) return emptyColor;

int idx = index;
if (pier.name.equals("pier1")) idx = 4 - index;

Tank bilge = bilges.get(idx);
if (bilge.isEmpty()) return emptyColor;
int type = ((BulkBatch)bilge.getBatch(0)).type;
return main.getColor(type);
/*ALCODEEND*/}

double changeVisibility(boolean value)
{/*ALCODESTART::1439889936936*/
rectangle2.setVisible(value);
for (int i = 0; i < bilge.size(); i++)
	bilge.get(i).setVisible(value);
rectangle3.setVisible(value);
object3d.setVisible(value);
/*ALCODEEND*/}

ShipRequest newRequest()
{/*ALCODESTART::1440408559273*/
ShipRequest request = new ShipRequest("", false);
request.types = new int[main.numOfTypes + 1];
request.sizes = new double[main.numOfTypes + 1];

double[] unreservedSizes = new double[main.numOfTypes];
for ( int type = 0; type < main.numOfTypes; type++ )
	unreservedSizes[type] = main.getUnreservedSize(type);

//double initialSize;
double requestedAmount = 0;
int requestedType = 0;
request.ship = this;

for (int i = 0; i < main.numOfTypes + 1; i++) {
	
	if ( i < main.numOfTypes )
		requestedType = i;
	else
		requestedType = uniform_discr(main.numOfTypes-1);
	
	requestedAmount = uniform_discr(main.bilgeCapacity / 3, 
									 main.bilgeCapacity);
									 

	if ( unreservedSizes[requestedType] < requestedAmount ) {
		//seek for a type with max volume in case there is not enough desirable type
		int maxVolType = getTypeWithMaxSize(unreservedSizes, requestedAmount);	
			
		if ( maxVolType != -1 ) 								
			requestedType = maxVolType;

		//there is no grain type with required size - order as much as available of initial type
		else 
			requestedAmount = unreservedSizes[requestedType];	
	}
	
	request.types[i] = requestedType;		
	request.sizes[i] = requestedAmount;								 
	unreservedSizes[requestedType] -= requestedAmount;
}

return request;
/*ALCODEEND*/}

double loadedAmount(int type)
{/*ALCODESTART::1440571501976*/
double amount = 0;
for (Tank bilge : bilges) {
	if(!bilge.isEmpty() && ((BulkBatch)bilge.getBatch(0)).type == type)
		amount += bilge.amount();
}
return amount;
/*ALCODEEND*/}

int getTypeWithMaxSize(double[] nonReservedSizes,double requestedAmount)
{/*ALCODESTART::1527854196914*/
int maxSizeType = -1;
double curMaxSize = 0;

for (int type = 0; type < main.numOfTypes; type++) {
	if ( ( curMaxSize < nonReservedSizes[type] ) && ( nonReservedSizes[type] > requestedAmount ) ){
		curMaxSize = nonReservedSizes[type];
		maxSizeType = type;
	}
}	

return maxSizeType;
/*ALCODEEND*/}

