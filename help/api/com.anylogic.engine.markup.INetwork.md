# INetwork

## Package
`com.anylogic.engine.markup`

## Interface
`INetwork<N extends INode<N,P>,P extends IPath<N>>`

## Type Parameters
- `N` - network node, an instance of INode
- `P` - network path, an instance of IPath

## All Superinterfaces
`IRouteProvider<ShortestPathData<N,P>>`, `Serializable`

## All Known Implementing Classes
`AbstractNetwork`, `ConveyorNetwork`, `GISNetwork`, `Network`

## Description
Basic interface of network for agent movement based on markup elements.

## Author
AnyLogic North America, LLC https://anylogic.com

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `void` | `add(N n)` | Adds node to network. |
| `void` | `add(P p)` | Adds relation to network. |
| `Class<? extends ExtAgentWithSpatialMetrics>` | `getCompatibleAgentExtensionClass()` | This method is internal and shouldn't be called by user. It may be removed/renamed in future. |
| `double` | `getDistance(Point source, Point target, ShortestPathData<N,P> data)` | Calculates the distance between two points using the network paths. |
| `double` | `getDistance(Point source, Point target, ShortestPathData<N,P> data, LengthUnits units)` | Calculates the distance between two points using the network paths. |
| `double` | `getDistance(Point source, Point target, N from, N to, ShortestPathData<N,P> data)` | Calculates the distance between two points using the network paths. |
| `double` | `getDistance(Point source, Point target, N from, N to, ShortestPathData<N,P> data, LengthUnits units)` | Calculates the distance between two points using the network paths. |
| `double` | `getDistance(Point source, Point target, N from, P to, double toOffset, ShortestPathData<N,P> data)` | Calculates the distance between two points using the network paths. |
| `double` | `getDistance(Point source, Point target, N from, P to, double toOffset, ShortestPathData<N,P> data, LengthUnits units)` | Calculates the distance between two points using the network paths. |
| `double` | `getDistance(Point source, Point target, P from, double fromOffset, N to, ShortestPathData<N,P> data)` | Calculates the distance between two points using the network paths. |
| `double` | `getDistance(Point source, Point target, P from, double fromOffset, N to, ShortestPathData<N,P> data, LengthUnits units)` | Calculates the distance between two points using the network paths. |
| `double` | `getDistance(Point source, Point target, P from, double fromOffset, P to, double toOffset, ShortestPathData<N,P> data)` | Calculates the distance between two points using the network paths. |
| `double` | `getDistance(Point source, Point target, P from, double fromOffset, P to, double toOffset, ShortestPathData<N,P> data, LengthUnits units)` | Calculates the distance between two points using the network paths. |
| `double` | `getDistance(N from, N to, ShortestPathData<N,P> data)` | Calculates the distance from source object in the network to the target object. |
| `double` | `getDistance(N from, N to, ShortestPathData<N,P> data, LengthUnits units)` | Calculates the distance from source object in the network to the target object. |
| `double` | `getDistance(N from, P to, double toOffset, ShortestPathData<N,P> data)` | Calculates the distance from source object in the network to the target object. |
| `double` | `getDistance(N from, P to, double toOffset, ShortestPathData<N,P> data, LengthUnits units)` | Calculates the distance from source object in the network to the target object. |
| `double` | `getDistance(P from, double fromOffset, N to, ShortestPathData<N,P> data)` | Calculates the distance from source object in the network to the target object. |
| `double` | `getDistance(P from, double fromOffset, N to, ShortestPathData<N,P> data, LengthUnits units)` | Calculates the distance from source object in the network to the target object. |
| `double` | `getDistance(P from, double fromOffset, P to, double toOffset, ShortestPathData<N,P> data)` | Calculates the distance from source object in the network to the target object. |
| `double` | `getDistance(P from, double fromOffset, P to, double toOffset, ShortestPathData<N,P> data, LengthUnits units)` | Calculates the distance from source object in the network to the target object. |
| `INetworkMarkupElement` | `getNearestNetworkElement(double x, double y, double z, Point out)` | Looking for the closest markup element in this network to the given coordinates. |
| `INetworkMarkupElement` | `getNearestNetworkElement(Point givenPoint, Point out)` | Looking for the closest markup element in this network to the given point. |
| `N` | `getNearestNode(Point p)` | Looking for the closest node in this network to the given point. |
| `N` | `getNode(int index)` | |
| `int` | `getNodeCount()` | Amount of nodes in this network. |
| `P` | `getPath(int index)` | |
| `int` | `getPathCount()` | Amount of paths in this network. |
| `double` | `getPlainDistance(Point firstPoint, Point secondPoint)` | Straight line distance between two points. |
| `double` | `getPlainDistance(Point firstPoint, Point secondPoint, LengthUnits units)` | Straight line distance between two points in given units of length. |
| `Position` | `getPosition(ShortestPathData<N,P> data, double reverseOffset, LengthUnits units, Position out)` | Calculates current position on the shortest path through network by the given offset |
| `Position` | `getPosition(ShortestPathData<N,P> data, double reverseOffset, Position out)` | Calculates current position on the shortest path through network by the given offset |
| `List<INetwork<?,?>>` | `getRelatedNetworks()` | |
| `Agent` | `getSpace()` | Returns the space where the markup element is defined |
| `List<N>` | `nodes()` | |
| `List<P>` | `paths()` | |
| `List<NetworkPort>` | `ports()` | |

## Methods inherited from interface com.anylogic.engine.IRouteProvider
`getDistance`, `getLength`, `getPathData`, `getPositionAtOffset`

## Method Details

### add
```java
void add(N n)
```
Adds node to network. Don't call this method when network has been initialized.

**Parameters:**  
`n` - network node, instance of INode

### add
```java
void add(P p)
```
Adds relation to network. Don't call this method when network has been initialized.

**Parameters:**  
`p` - network path, instance of IPath

### getNearestNode
```java
N getNearestNode(Point p)
```
Looking for the closest node in this network to the given point.

**Parameters:**  
`p` - the given point

**Returns:**  
nearest node

### getNearestNetworkElement
```java
INetworkMarkupElement getNearestNetworkElement(double x,
                                              double y,
                                              double z,
                                              Point out)
```
Looking for the closest markup element in this network to the given coordinates.

**Parameters:**  
`x` - the x given coordinate  
`y` - the y given coordinate  
`z` - the z given coordinate  
`out` - the point in this markup element nearest to the given coordinates

**Returns:**  
nearest markup element

### getNearestNetworkElement
```java
INetworkMarkupElement getNearestNetworkElement(Point givenPoint,
                                              Point out)
```
Looking for the closest markup element in this network to the given point.

**Parameters:**  
`givenPoint` - the given point  
`out` - the point in this markup element nearest to the given point

**Returns:**  
nearest markup element

### getNode
```java
N getNode(int index)
```

### getNodeCount
```java
int getNodeCount()
```
Amount of nodes in this network.

**Returns:**  
amount of nodes

### getPath
```java
P getPath(int index)
```

### getPathCount
```java
int getPathCount()
```
Amount of paths in this network.

**Returns:**  
amount of paths

### ports
```java
List<NetworkPort> ports()
```

**Returns:**  
all ports of this network

### nodes
```java
List<N> nodes()
```

**Returns:**  
all nodes of this network

### paths
```java
List<P> paths()
```

**Returns:**  
all paths of this network

### getRelatedNetworks
```java
@AnyLogicInternalAPI
List<INetwork<?,?>> getRelatedNetworks()
```

**Returns:**  
list of related networks

### getDistance
```java
double getDistance(N from,
                   N to,
                   ShortestPathData<N,P> data)
```
Calculates the distance from source object in the network to the target object. Source and target points can be extracted from source and target objects in the following ways:
- From network node - extracted point is a connection point of the node and the path, that will be used to calculate distance
- From path and offset - extracted point lies at the certain distance (offset) from the start of the path

**Parameters:**  
`from` - from node  
`to` - to node  
`data` - output object to write to, may be null

**Returns:**  
distance between two points in the network

### getDistance
```java
double getDistance(N from,
                   N to,
                   ShortestPathData<N,P> data,
                   LengthUnits units)
```
Calculates the distance from source object in the network to the target object. Source and target points can be extracted from source and target objects in the following ways:
- From network node - extracted point is a connection point of the node and the path, that will be used to calculate distance
- From path and offset - extracted point lies at the certain distance (offset) from the start of the path

**Parameters:**  
`from` - source node  
`to` - target node  
`data` - output object to write to, may be null  
`units` - length units

**Returns:**  
distance between two points in the network

### getDistance
```java
double getDistance(N from,
                   P to,
                   double toOffset,
                   ShortestPathData<N,P> data)
```
Calculates the distance from source object in the network to the target object. Source and target points can be extracted from source and target objects in the following ways:
- From network node - extracted point is a connection point of the node and the path, that will be used to calculate distance
- From path and offset - extracted point lies at the certain distance (offset) from the start of the path

**Parameters:**  
`from` - source node  
`to` - target path  
`toOffset` - offset on the target path  
`data` - output object to write to, may be null

**Returns:**  
distance between two points in the network

### getDistance
```java
double getDistance(N from,
                   P to,
                   double toOffset,
                   ShortestPathData<N,P> data,
                   LengthUnits units)
```
Calculates the distance from source object in the network to the target object. Source and target points can be extracted from source and target objects in the following ways:
- From network node - extracted point is a connection point of the node and the path, that will be used to calculate distance
- From path and offset - extracted point lies at the certain distance (offset) from the start of the path

**Parameters:**  
`from` - source node  
`to` - target path  
`toOffset` - offset on the target path  
`data` - output object to write to, may be null  
`units` - length units

**Returns:**  
distance between two points in the network

### getDistance
```java
double getDistance(P from,
                   double fromOffset,
                   N to,
                   ShortestPathData<N,P> data)
```
Calculates the distance from source object in the network to the target object. Source and target points can be extracted from source and target objects in the following ways:
- From network node - extracted point is a connection point of the node and the path, that will be used to calculate distance
- From path and offset - extracted point lies at the certain distance (offset) from the start of the path

**Parameters:**  
`from` - source path  
`fromOffset` - offset on the source path  
`to` - target node  
`data` - output object to write to, may be null

**Returns:**  
distance between two points in the network

### getDistance
```java
double getDistance(P from,
                   double fromOffset,
                   N to,
                   ShortestPathData<N,P> data,
                   LengthUnits units)
```
Calculates the distance from source object in the network to the target object. Source and target points can be extracted from source and target objects in the following ways:
- From network node - extracted point is a connection point of the node and the path, that will be used to calculate distance
- From path and offset - extracted point lies at the certain distance (offset) from the start of the path

**Parameters:**  
`from` - source path  
`fromOffset` - offset on the source path  
`to` - target node  
`data` - output object to write to, may be null  
`units` - length units

**Returns:**  
distance between two points in the network

### getDistance
```java
double getDistance(P from,
                   double fromOffset,
                   P to,
                   double toOffset,
                   ShortestPathData<N,P> data)
```
Calculates the distance from source object in the network to the target object. Source and target points can be extracted from source and target objects in the following ways:
- From network node - extracted point is a connection point of the node and the path, that will be used to calculate distance
- From path and offset - extracted point lies at the certain distance (offset) from the start of the path

**Parameters:**  
`from` - source path  
`fromOffset` - offset on the source path  
`to` - target path  
`toOffset` - offset on the target path  
`data` - output object to write to, may be null

**Returns:**  
distance between two points in the network

### getDistance
```java
double getDistance(P from,
                   double fromOffset,
                   P to,
                   double toOffset,
                   ShortestPathData<N,P> data,
                   LengthUnits units)
```
Calculates the distance from source object in the network to the target object. Source and target points can be extracted from source and target objects in the following ways:
- From network node - extracted point is a connection point of the node and the path, that will be used to calculate distance
- From path and offset - extracted point lies at the certain distance (offset) from the start of the path

**Parameters:**  
`from` - source path  
`fromOffset` - offset on the source path  
`to` - target path  
`toOffset` - offset on the target path  
`data` - output object to write to, may be null  
`units` - length units

**Returns:**  
distance between two points in the network

### getDistance
```java
double getDistance(Point source,
                   Point target,
                   N from,
                   N to,
                   ShortestPathData<N,P> data)
```
Calculates the distance between two points using the network paths. Source and target points do not have to belong to the network. You have two options in terms of 'connecting' the source point to the network start point and the network end point to the target point, namely:
- Specifying the network node. The network point will lie at the connection point of the node and the path, that will be used to calculate distance
- Specifying the path and the offset. The network point will lie at the certain distance (offset) from the start of this path

**Parameters:**  
`source` - source point  
`target` - target point  
`from` - network starting node  
`to` - network end node  
`data` - output object to write into, may be null

**Returns:**  
the distance between two points if traveling using network

### getDistance
```java
double getDistance(Point source,
                   Point target,
                   N from,
                   N to,
                   ShortestPathData<N,P> data,
                   LengthUnits units)
```
Calculates the distance between two points using the network paths. Source and target points do not have to belong to the network. You have two options in terms of 'connecting' the source point to the network start point and the network end point to the target point, namely:
- Specifying the network node. The network point will lie at the connection point of the node and the path, that will be used to calculate distance
- Specifying the path and the offset. The network point will lie at the certain distance (offset) from the start of this path

**Parameters:**  
`source` - source point  
`target` - target point  
`from` - network starting node  
`to` - network end node  
`data` - output object to write into, may be null  
`units` - length units

**Returns:**  
the distance between two points if traveling using network

### getDistance
```java
double getDistance(Point source,
                   Point target,
                   N from,
                   P to,
                   double toOffset,
                   ShortestPathData<N,P> data)
```
Calculates the distance between two points using the network paths. Source and target points do not have to belong to the network. You have two options in terms of 'connecting' the source point to the network start point and the network end point to the target point, namely:
- Specifying the network node. The network point will lie at the connection point of the node and the path, that will be used to calculate distance
- Specifying the path and the offset. The network point will lie at the certain distance (offset) from the start of this path

**Parameters:**  
`source` - source point  
`target` - target point  
`from` - network starting node  
`to` - network end path  
`toOffset` - offset on the network end path  
`data` - output object to write into, may be null

**Returns:**  
the distance between two points if traveling using network

### getDistance
```java
double getDistance(Point source,
                   Point target,
                   N from,
                   P to,
                   double toOffset,
                   ShortestPathData<N,P> data,
                   LengthUnits units)
```
Calculates the distance between two points using the network paths. Source and target points do not have to belong to the network. You have two options in terms of 'connecting' the source point to the network start point and the network end point to the target point, namely:
- Specifying the network node. The network point will lie at the connection point of the node and the path, that will be used to calculate distance
- Specifying the path and the offset. The network point will lie at the certain distance (offset) from the start of this path

**Parameters:**  
`source` - source point  
`target` - target point  
`from` - network starting node  
`to` - network end path  
`toOffset` - offset on the network end path  
`data` - output object to write into, may be null  
`units` - length units

**Returns:**  
the distance between two points if traveling using network

### getDistance
```java
double getDistance(Point source,
                   Point target,
                   P from,
                   double fromOffset,
                   N to,
                   ShortestPathData<N,P> data)
```
Calculates the distance between two points using the network paths. Source and target points do not have to belong to the network. You have two options in terms of 'connecting' the source point to the network start point and the network end point to the target point, namely:
- Specifying the network node. The network point will lie at the connection point of the node and the path, that will be used to calculate distance
- Specifying the path and the offset. The network point will lie at the certain distance (offset) from the start of this path

**Parameters:**  
`source` - source point  
`target` - target point  
`from` - network starting path  
`fromOffset` - offset on the network starting path  
`to` - network end node  
`data` - output object to write into, may be null

**Returns:**  
the distance between two points if traveling using network

### getDistance
```java
double getDistance(Point source,
                   Point target,
                   P from,
                   double fromOffset,
                   N to,
                   ShortestPathData<N,P> data,
                   LengthUnits units)
```
Calculates the distance between two points using the network paths. Source and target points do not have to belong to the network. You have two options in terms of 'connecting' the source point to the network start point and the network end point to the target point, namely:
- Specifying the network node. The network point will lie at the connection point of the node and the path, that will be used to calculate distance
- Specifying the path and the offset. The network point will lie at the certain distance (offset) from the start of this path

**Parameters:**  
`source` - source point  
`target` - target point  
`from` - network starting path  
`fromOffset` - offset on the network starting path  
`to` - network end node  
`data` - output object to write into, may be null  
`units` - length units

**Returns:**  
the distance between two points if traveling using network

### getDistance
```java
double getDistance(Point source,
                   Point target,
                   P from,
                   double fromOffset,
                   P to,
                   double toOffset,
                   ShortestPathData<N,P> data)
```
Calculates the distance between two points using the network paths. Source and target points do not have to belong to the network. You have two options in terms of 'connecting' the source point to the network start point and the network end point to the target point, namely:
- Specifying the network node. The network point will lie at the connection point of the node and the path, that will be used to calculate distance
- Specifying the path and the offset. The network point will lie at the certain distance (offset) from the start of this path

**Parameters:**  
`source` - source point  
`target` - target point  
`from` - network starting path  
`fromOffset` - offset on the network starting path  
`to` - network end path  
`toOffset` - offset on the network end path  
`data` - output object to write into, may be null

**Returns:**  
the distance between two points if traveling using network

### getDistance
```java
double getDistance(Point source,
                   Point target,
                   P from,
                   double fromOffset,
                   P to,
                   double toOffset,
                   ShortestPathData<N,P> data,
                   LengthUnits units)
```
Calculates the distance between two points using the network paths. Source and target points do not have to belong to the network. You have two options in terms of 'connecting' the source point to the network start point and the network end point to the target point, namely:
- Specifying the network node. The network point will lie at the connection point of the node and the path, that will be used to calculate distance
- Specifying the path and the offset. The network point will lie at the certain distance (offset) from the start of this path

**Parameters:**  
`source` - source point  
`target` - target point  
`from` - network starting path  
`fromOffset` - offset on the network starting path  
`to` - network end path  
`toOffset` - offset on the network end path  
`data` - output object to write into, may be null  
`units` - length units

**Returns:**  
the distance between two points if traveling using network

### getDistance
```java
double getDistance(Point source,
                   Point target,
                   ShortestPathData<N,P> data)
```
Calculates the distance between two points using the network paths. Source and target points do not have to belong to the network. Network starting and and points will be chosen as network closest points to the source and target points respectively.

**Parameters:**  
`source` - source point  
`target` - target point  
`data` - data output object to write into, may be null

**Returns:**  
the distance between two points if traveling using network

### getDistance
```java
double getDistance(Point source,
                   Point target,
                   ShortestPathData<N,P> data,
                   LengthUnits units)
```
Calculates the distance between two points using the network paths. Source and target points do not have to belong to the network. Network starting and and points will be chosen as network closest points to the source and target points respectively.

**Parameters:**  
`source` - source point  
`target` - target point  
`data` - data output object to write into, may be null  
`units` - length units

**Returns:**  
the distance between two points if traveling using network

### getPlainDistance
```java
double getPlainDistance(Point firstPoint,
                        Point secondPoint)
```
Straight line distance between two points.

**Parameters:**  
`firstPoint` -  
`secondPoint` -  

**Returns:**  
distance between two points

### getPlainDistance
```java
double getPlainDistance(Point firstPoint,
                        Point secondPoint,
                        LengthUnits units)
```
Straight line distance between two points in given units of length.

**Parameters:**  
`firstPoint` -  
`secondPoint` -  
`units` - unit of length

**Returns:**  
distance between two points

### getPosition
```java
Position getPosition(ShortestPathData<N,P> data,
                     double reverseOffset,
                     Position out)
```
Calculates current position on the shortest path through network by the given offset

**Parameters:**  
`data` - shortest path data, see #getDistance(Node, Node, ShortestPathData) methods  
`reverseOffset` - offset from the end of route  
`out` - the Position object to use for output, may be null

**Returns:**  
the position on the shortest path

### getPosition
```java
Position getPosition(ShortestPathData<N,P> data,
                     double reverseOffset,
                     LengthUnits units,
                     Position out)
```
Calculates current position on the shortest path through network by the given offset

**Parameters:**  
`data` - shortest path data, see #getDistance(Node, Node, ShortestPathData) methods  
`reverseOffset` - offset from the end of route  
`units` - the units of length  
`out` - the Position object to use for output, may be null

**Returns:**  
the position on the shortest path

**Since:**  
7.1

### getSpace
```java
Agent getSpace()
```
Returns the space where the markup element is defined

**Returns:**  
the space associated with this element

### getCompatibleAgentExtensionClass
```java
@AnyLogicInternalAPI
Class<? extends ExtAgentWithSpatialMetrics> getCompatibleAgentExtensionClass()
```
This method is internal and shouldn't be called by user.
It may be removed/renamed in future.
