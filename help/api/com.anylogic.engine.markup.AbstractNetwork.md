# AbstractNetwork

## Package
`com.anylogic.engine.markup`

## Class
`AbstractNetwork<N extends INode<N,P>,P extends IPath<N>,Owner>`

## Inheritance
```
java.lang.Object
  └── com.anylogic.engine.markup.AbstractMarkupAggregator<Owner>
       └── com.anylogic.engine.markup.AbstractNetwork<N,P,Owner>
```

## All Implemented Interfaces
`IRouteProvider<ShortestPathData<N,P>>`, `INetwork<N,P>`, `Serializable`

## Direct Known Subclasses
`ConveyorNetwork`, `GISNetwork`, `Network`

## Access
`@AnyLogicInternalAPI`
`public abstract class AbstractNetwork<N extends INode<N,P>,P extends IPath<N>,Owner> extends AbstractMarkupAggregator<Owner> implements INetwork<N,P>`

## See Also
Serialized Form

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `AbstractNetwork(Owner owner, String name)` | |
| `AbstractNetwork(Owner owner, String name, boolean isPublic, boolean visible)` | |

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `void` | `add(N n)` | Adds node to network. |
| `void` | `add(P p)` | Adds relation to network. |
| `double` | `getDistance(Point startPoint, Point endPoint)` | Creates a route from one point to another and calculates its length. |
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
| `double` | `getLength(ShortestPathData<N,P> pathData)` | Retrieves length of the specified route. |
| `INetworkMarkupElement` | `getNearestNetworkElement(double x, double y, double z, Point out)` | Looking for the closest markup element in this network to the given coordinates. |
| `INetworkMarkupElement` | `getNearestNetworkElement(Agent agent, Point out)` | Looking for the closest markup element in this network to the given agent. |
| `INetworkMarkupElement` | `getNearestNetworkElement(Point givenPoint, Point out)` | Looking for the closest markup element in this network to the given point. |
| `N` | `getNearestNode(double x, double y, double z, Point out)` | Looking for the closest node in this network to the given coordinates. |
| `N` | `getNearestNode(Agent agent, Point out)` | Looking for the closest node in this network to the given agent. |
| `N` | `getNearestNode(Point givenPoint)` | Looking for the closest node in this network to the given point. |
| `N` | `getNearestNode(Point givenPoint, Point out)` | Looking for the closest node in this network to the given point. |
| `P` | `getNearestPath(double x, double y, double z, Point out)` | Looking for the closest path in this network to the given coordinates. |
| `P` | `getNearestPath(Agent agent, Point out)` | Looking for the closest path in this network to the given agent. |
| `P` | `getNearestPath(Point givenPoint, Point out)` | Looking for the closest path in this network to the given point. |
| `N` | `getNode(int index)` | |
| `int` | `getNodeCount()` | Amount of nodes in this network. |
| `P` | `getPath(int index)` | |
| `int` | `getPathCount()` | Amount of paths in this network. |
| `ShortestPathData<N,P>` | `getPathData(Point startPoint, Point endPoint, ShortestPathData<N,P> out)` | Retrieves the route data an agent will use to calculate the route length and determine its position on the route by calling IRouteProvider.getLength(IPathData) and IRouteProvider.getPositionAtOffset(IPathData, double, Position) respectively. |
| `abstract double` | `getPlainDistance(Point firstPoint, Point secondPoint)` | Straight line distance between two points. |
| `double` | `getPlainDistance(Point firstPoint, Point secondPoint, LengthUnits units)` | Straight line distance between two points in given units of length. |
| `Position` | `getPosition(ShortestPathData<N,P> data, double offset, LengthUnits units, Position out)` | Calculates current position on the shortest path through network by the given offset |
| `Position` | `getPosition(ShortestPathData<N,P> data, double offset, Position out)` | Calculates current position on the shortest path through network by the given offset |
| `Position` | `getPositionAtOffset(ShortestPathData<N,P> pathData, double offset, Position out)` | Retrieves agent's position on the route. |
| `List<INetwork<?,?>>` | `getRelatedNetworks()` | |
| `List<N>` | `nodes()` | |
| `List<P>` | `paths()` | |
| `List<NetworkPort>` | `ports()` | |

## Methods inherited from class com.anylogic.engine.markup.AbstractMarkupAggregator
`elementsInternal`, `error`, `getName`, `getOwner`, `initializeInternal`, `isVisible`, `onAggregatorVisibilityChanged`, `setVisible`

## Methods inherited from class java.lang.Object
`equals`, `getClass`, `hashCode`, `notify`, `notifyAll`, `toString`, `wait`, `wait`, `wait`

## Methods inherited from interface com.anylogic.engine.markup.INetwork
`getCompatibleAgentExtensionClass`, `getSpace`

## Constructor Details

### AbstractNetwork
```java
public AbstractNetwork(Owner owner,
                       String name)
```

### AbstractNetwork
```java
public AbstractNetwork(Owner owner,
                       String name,
                       boolean isPublic,
                       boolean visible)
```

## Method Details

### add
```java
public void add(N n)
```
Description copied from interface: INetwork  
Adds node to network. Don't call this method when network has been initialized.

**Specified by:**  
`add` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

**Parameters:**  
`n` - network node, instance of INode

### add
```java
public void add(P p)
```
Description copied from interface: INetwork  
Adds relation to network. Don't call this method when network has been initialized.

**Specified by:**  
`add` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

**Parameters:**  
`p` - network path, instance of IPath

### getNode
```java
public N getNode(int index)
```
**Specified by:**  
`getNode` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

### getNodeCount
```java
public int getNodeCount()
```
Description copied from interface: INetwork  
Amount of nodes in this network.

**Specified by:**  
`getNodeCount` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

**Returns:**  
amount of nodes

### getPath
```java
public P getPath(int index)
```
**Specified by:**  
`getPath` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

### getPathCount
```java
public int getPathCount()
```
Description copied from interface: INetwork  
Amount of paths in this network.

**Specified by:**  
`getPathCount` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

**Returns:**  
amount of paths

### ports
```java
public List<NetworkPort> ports()
```
**Specified by:**  
`ports` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

**Returns:**  
all ports of this network

### nodes
```java
public List<N> nodes()
```
**Specified by:**  
`nodes` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

**Returns:**  
all nodes of this network

### paths
```java
public List<P> paths()
```
**Specified by:**  
`paths` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

**Returns:**  
all paths of this network

### getRelatedNetworks
```java
@AnyLogicInternalAPI
public List<INetwork<?,?>> getRelatedNetworks()
```
**Specified by:**  
`getRelatedNetworks` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

**Returns:**  
list of related networks

### getDistance
```java
public double getDistance(N from,
                          N to,
                          ShortestPathData<N,P> data)
```
Description copied from interface: INetwork  
Calculates the distance from source object in the network to the target object. Source and target points can be extracted from source and target objects in the following ways:
- From network node - extracted point is a connection point of the node and the path, that will be used to calculate distance
- From path and offset - extracted point lies at the certain distance (offset) from the start of the path

**Specified by:**  
`getDistance` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

**Parameters:**  
`from` - from node  
`to` - to node  
`data` - output object to write to, may be null

**Returns:**  
distance between two points in the network

### getDistance
```java
public double getDistance(N from,
                          N to,
                          ShortestPathData<N,P> data,
                          LengthUnits units)
```
Description copied from interface: INetwork  
Calculates the distance from source object in the network to the target object. Source and target points can be extracted from source and target objects in the following ways:
- From network node - extracted point is a connection point of the node and the path, that will be used to calculate distance
- From path and offset - extracted point lies at the certain distance (offset) from the start of the path

**Specified by:**  
`getDistance` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

**Parameters:**  
`from` - source node  
`to` - target node  
`data` - output object to write to, may be null  
`units` - length units

**Returns:**  
distance between two points in the network

### getDistance
```java
public double getDistance(N from,
                          P to,
                          double toOffset,
                          ShortestPathData<N,P> data)
```
Description copied from interface: INetwork  
Calculates the distance from source object in the network to the target object. Source and target points can be extracted from source and target objects in the following ways:
- From network node - extracted point is a connection point of the node and the path, that will be used to calculate distance
- From path and offset - extracted point lies at the certain distance (offset) from the start of the path

**Specified by:**  
`getDistance` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

**Parameters:**  
`from` - source node  
`to` - target path  
`toOffset` - offset on the target path  
`data` - output object to write to, may be null

**Returns:**  
distance between two points in the network

### getDistance
```java
public double getDistance(N from,
                          P to,
                          double toOffset,
                          ShortestPathData<N,P> data,
                          LengthUnits units)
```
Description copied from interface: INetwork  
Calculates the distance from source object in the network to the target object. Source and target points can be extracted from source and target objects in the following ways:
- From network node - extracted point is a connection point of the node and the path, that will be used to calculate distance
- From path and offset - extracted point lies at the certain distance (offset) from the start of the path

**Specified by:**  
`getDistance` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

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
public double getDistance(P from,
                          double fromOffset,
                          N to,
                          ShortestPathData<N,P> data)
```
Description copied from interface: INetwork  
Calculates the distance from source object in the network to the target object. Source and target points can be extracted from source and target objects in the following ways:
- From network node - extracted point is a connection point of the node and the path, that will be used to calculate distance
- From path and offset - extracted point lies at the certain distance (offset) from the start of the path

**Specified by:**  
`getDistance` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

**Parameters:**  
`from` - source path  
`fromOffset` - offset on the source path  
`to` - target node  
`data` - output object to write to, may be null

**Returns:**  
distance between two points in the network

### getDistance
```java
public double getDistance(P from,
                          double fromOffset,
                          N to,
                          ShortestPathData<N,P> data,
                          LengthUnits units)
```
Description copied from interface: INetwork  
Calculates the distance from source object in the network to the target object. Source and target points can be extracted from source and target objects in the following ways:
- From network node - extracted point is a connection point of the node and the path, that will be used to calculate distance
- From path and offset - extracted point lies at the certain distance (offset) from the start of the path

**Specified by:**  
`getDistance` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

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
public double getDistance(P from,
                          double fromOffset,
                          P to,
                          double toOffset,
                          ShortestPathData<N,P> data)
```
Description copied from interface: INetwork  
Calculates the distance from source object in the network to the target object. Source and target points can be extracted from source and target objects in the following ways:
- From network node - extracted point is a connection point of the node and the path, that will be used to calculate distance
- From path and offset - extracted point lies at the certain distance (offset) from the start of the path

**Specified by:**  
`getDistance` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

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
public double getDistance(P from,
                          double fromOffset,
                          P to,
                          double toOffset,
                          ShortestPathData<N,P> data,
                          LengthUnits units)
```
Description copied from interface: INetwork  
Calculates the distance from source object in the network to the target object. Source and target points can be extracted from source and target objects in the following ways:
- From network node - extracted point is a connection point of the node and the path, that will be used to calculate distance
- From path and offset - extracted point lies at the certain distance (offset) from the start of the path

**Specified by:**  
`getDistance` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

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
public double getDistance(Point source,
                          Point target,
                          N from,
                          N to,
                          ShortestPathData<N,P> data)
```
Description copied from interface: INetwork  
Calculates the distance between two points using the network paths. Source and target points do not have to belong to the network. You have two options in terms of 'connecting' the source point to the network start point and the network end point to the target point, namely:
- Specifying the network node. The network point will lie at the connection point of the node and the path, that will be used to calculate distance
- Specifying the path and the offset. The network point will lie at the certain distance (offset) from the start of this path

**Specified by:**  
`getDistance` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

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
public double getDistance(Point source,
                          Point target,
                          N from,
                          N to,
                          ShortestPathData<N,P> data,
                          LengthUnits units)
```
Description copied from interface: INetwork  
Calculates the distance between two points using the network paths. Source and target points do not have to belong to the network. You have two options in terms of 'connecting' the source point to the network start point and the network end point to the target point, namely:
- Specifying the network node. The network point will lie at the connection point of the node and the path, that will be used to calculate distance
- Specifying the path and the offset. The network point will lie at the certain distance (offset) from the start of this path

**Specified by:**  
`getDistance` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

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
public double getDistance(Point source,
                          Point target,
                          N from,
                          P to,
                          double toOffset,
                          ShortestPathData<N,P> data)
```
Description copied from interface: INetwork  
Calculates the distance between two points using the network paths. Source and target points do not have to belong to the network. You have two options in terms of 'connecting' the source point to the network start point and the network end point to the target point, namely:
- Specifying the network node. The network point will lie at the connection point of the node and the path, that will be used to calculate distance
- Specifying the path and the offset. The network point will lie at the certain distance (offset) from the start of this path

**Specified by:**  
`getDistance` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

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
public double getDistance(Point source,
                          Point target,
                          N from,
                          P to,
                          double toOffset,
                          ShortestPathData<N,P> data,
                          LengthUnits units)
```
Description copied from interface: INetwork  
Calculates the distance between two points using the network paths. Source and target points do not have to belong to the network. You have two options in terms of 'connecting' the source point to the network start point and the network end point to the target point, namely:
- Specifying the network node. The network point will lie at the connection point of the node and the path, that will be used to calculate distance
- Specifying the path and the offset. The network point will lie at the certain distance (offset) from the start of this path

**Specified by:**  
`getDistance` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

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
public double getDistance(Point source,
                          Point target,
                          P from,
                          double fromOffset,
                          N to,
                          ShortestPathData<N,P> data)
```
Description copied from interface: INetwork  
Calculates the distance between two points using the network paths. Source and target points do not have to belong to the network. You have two options in terms of 'connecting' the source point to the network start point and the network end point to the target point, namely:
- Specifying the network node. The network point will lie at the connection point of the node and the path, that will be used to calculate distance
- Specifying the path and the offset. The network point will lie at the certain distance (offset) from the start of this path

**Specified by:**  
`getDistance` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

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
public double getDistance(Point source,
                          Point target,
                          P from,
                          double fromOffset,
                          N to,
                          ShortestPathData<N,P> data,
                          LengthUnits units)
```
Description copied from interface: INetwork  
Calculates the distance between two points using the network paths. Source and target points do not have to belong to the network. You have two options in terms of 'connecting' the source point to the network start point and the network end point to the target point, namely:
- Specifying the network node. The network point will lie at the connection point of the node and the path, that will be used to calculate distance
- Specifying the path and the offset. The network point will lie at the certain distance (offset) from the start of this path

**Specified by:**  
`getDistance` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

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
public double getDistance(Point source,
                          Point target,
                          P from,
                          double fromOffset,
                          P to,
                          double toOffset,
                          ShortestPathData<N,P> data)
```
Description copied from interface: INetwork  
Calculates the distance between two points using the network paths. Source and target points do not have to belong to the network. You have two options in terms of 'connecting' the source point to the network start point and the network end point to the target point, namely:
- Specifying the network node. The network point will lie at the connection point of the node and the path, that will be used to calculate distance
- Specifying the path and the offset. The network point will lie at the certain distance (offset) from the start of this path

**Specified by:**  
`getDistance` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

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
public double getDistance(Point source,
                          Point target,
                          P from,
                          double fromOffset,
                          P to,
                          double toOffset,
                          ShortestPathData<N,P> data,
                          LengthUnits units)
```
Description copied from interface: INetwork  
Calculates the distance between two points using the network paths. Source and target points do not have to belong to the network. You have two options in terms of 'connecting' the source point to the network start point and the network end point to the target point, namely:
- Specifying the network node. The network point will lie at the connection point of the node and the path, that will be used to calculate distance
- Specifying the path and the offset. The network point will lie at the certain distance (offset) from the start of this path

**Specified by:**  
`getDistance` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

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
public double getDistance(Point source,
                          Point target,
                          ShortestPathData<N,P> data)
```
Description copied from interface: INetwork  
Calculates the distance between two points using the network paths. Source and target points do not have to belong to the network. Network starting and and points will be chosen as network closest points to the source and target points respectively.

**Specified by:**  
`getDistance` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>>`

**Parameters:**  
`source` - source point  
`target` - target point  
`data` - data output object to write into, may be null

**Returns:**  
the distance between two points if traveling using network

### getDistance
```java
public double getDistance(Point source,
                          Point target,
                          ShortestPathData<N,P> data,
                          LengthUnits units)
```
Description copied from interface: INetwork  
Calculates the distance between two points using the network paths. Source and target points do not have to belong to the network. Network starting and and points will be chosen as network closest points to the source and target points respectively.

**Specified by:**  
`getDistance` in interface `INetwork<N extends INode<N,P>,P extends IPath<N>
