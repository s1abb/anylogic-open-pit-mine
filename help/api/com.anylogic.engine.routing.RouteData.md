# Class RouteData

## Inheritance Hierarchy
```
java.lang.Object
  com.anylogic.engine.routing.RouteData
```

## All Implemented Interfaces
`Serializable`, `Iterable<IMovement>`

## Class Declaration
```java
public class RouteData
extends Object
implements Serializable, Iterable<IMovement>
```

## Description
Represents a route consisting of a sequence of movements in a routing system.

**See Also:** [Serialized Form](#)
## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `RouteData(IMovement... movements)` | Constructor with movements array |
| `RouteData(RouteData routeData)` | Constructor with another route data |
| `RouteData(Collection<? extends IMovement> movements)` | Constructor with movements collection |
## Method Summary

| Modifier and Type | Method | Description |
|------------------|--------|-------------|
| `void` | `add(RouteData routeData)` | Adds all movements from another route data |
| `void` | `addMovement(int index, IMovement movement)` | Adds a movement at the specified index |
| `void` | `addMovement(IMovement movement)` | Adds a movement to the end of the route |
| `void` | `addMovements(IMovement... movements)` | Adds multiple movements to the end of the route |
| `void` | `addMovements(Collection<? extends IMovement> movements)` | Adds a collection of movements to the end of the route |
| `void` | `addNodeTransferMovement(INode<?,?> node, IPath<?> sourcePath, IPath<?> targetPath)` | Adds a node transfer movement |
| `void` | `addPathMovement(IPath<?> path, boolean forward)` | Adds a path movement with direction |
| `void` | `addPathMovement(IPath<?> path, double sourceOffset, double targetOffset, LengthUnits units)` | Adds a path movement with offsets |
| `void` | `addPlainMovement(Agent space, Point source, Point target)` | Adds a plain movement with space |
| `void` | `addPlainMovement(INetworkMarkupElement networkElement, Point source, Point target)` | Adds a plain movement with network element |
| `void` | `addPortMovement(MarkupPort source, MarkupPort target)` | Adds a port movement |
| `boolean` | `contains(INode<?,?> node)` | Checks if this route contains the given node |
| `boolean` | `contains(IPath<?> path)` | Checks if this route contains the given path |
| `static IMovement` | `createNodeTransferMovement(INode<?,?> node, IPath<?> sourcePath, IPath<?> targetPath)` | Creates a node transfer movement |
| `static IMovement` | `createPathMovement(IPath<?> path, boolean forward)` | Creates a path movement with direction |
| `static IMovement` | `createPathMovement(IPath<?> path, double sourceOffset, double targetOffset, LengthUnits units)` | Creates a path movement with offsets |
| `static IMovement` | `createPlainMovement(Agent space, Point source, Point target)` | Creates a plain movement with space |
| `static IMovement` | `createPlainMovement(INetworkMarkupElement networkElement, Point source, Point target)` | Creates a plain movement with network element |
| `static IMovement` | `createPortMovement(MarkupPort source, MarkupPort target)` | Creates a port movement |
| `double` | `distance(LengthUnits units)` | Gets the total distance of this route |
| `static RouteData` | `findShortestRoute(Collection<RouteData> collection, LengthUnits units)` | Finds the shortest route from a collection |
| `IMovement` | `getFirstMovement()` | Gets the first movement of this route |
| `IMovement` | `getLastMovement()` | Gets the last movement of this route |
| `IRouteLocation` | `getLocationAtOffset(double offset, LengthUnits units)` | Gets the location at the specified offset |
| `IRouteLocation` | `getLocationAtOffset(double offset, LengthUnits units, IRouteLocation out)` | Gets the location at the specified offset with output parameter |
| `IMovement` | `getMovement(int index)` | Gets the movement at the specified index |
| `List<IMovement>` | `getMovements()` | Gets all movements of this route |
| `IRouteLocation` | `getSourceLocation()` | Gets the source location of this route |
| `IRouteLocation` | `getTargetLocation()` | Gets the target location of this route |
| `boolean` | `isEmpty()` | Checks if this route is empty |
| `Iterator<IMovement>` | `iterator()` | Returns an iterator over the movements of this route |
| `double` | `recalculateDistance()` | Recalculates the total distance of this route |
| `void` | `removeFirstMovement()` | Removes the first movement from this route |
| `void` | `removeLastMovement()` | Removes the last movement from this route |
| `void` | `removeMovement(int index)` | Removes the movement at the specified index |
| `boolean` | `removeMovement(IMovement movement)` | Removes the specified movement from this route |
| `int` | `size()` | Gets the number of movements in this route |
| `String` | `toString()` | Returns a string representation of this route |
## Methods inherited from class java.lang.Object
`equals`, `getClass`, `hashCode`, `notify`, `notifyAll`, `wait`, `wait`, `wait`

## Methods inherited from interface java.lang.Iterable
`forEach`, `spliterator`
## Constructor Details

### `RouteData(RouteData routeData)`
- **Description**: Constructor with another route data
- **Parameters**:
  - `routeData`: The route data to copy

### `RouteData(IMovement... movements)`
- **Description**: Constructor with movements array
- **Parameters**:
  - `movements`: The movements to add

### `RouteData(Collection<? extends IMovement> movements)`
- **Description**: Constructor with movements collection
- **Parameters**:
  - `movements`: The movements to add
## Method Details

### `isEmpty()`
- **Type**: `public boolean`
- **Description**: Checks if this route is empty
- **Returns**: True if this route is empty, false otherwise

### `size()`
- **Type**: `public int`
- **Description**: Gets the number of movements in this route
- **Returns**: The number of movements in this route

### `recalculateDistance()`
- **Type**: `public double`
- **Annotation**: `@AnyLogicInternalAPI`
- **Description**: Recalculates the total distance of this route
- **Returns**: The total distance of this route

### `getMovement(int index)`
- **Type**: `public IMovement`
- **Description**: Gets the movement at the specified index
- **Parameters**:
  - `index`: The index
- **Returns**: The movement at the specified index

### `getFirstMovement()`
- **Type**: `public IMovement`
- **Description**: Gets the first movement of this route
- **Returns**: The first movement of this route

### `getLastMovement()`
- **Type**: `public IMovement`
- **Description**: Gets the last movement of this route
- **Returns**: The last movement of this route

### `getMovements()`
- **Type**: `public List<IMovement>`
- **Description**: Gets all movements of this route
- **Returns**: All movements of this route

### `addMovement(IMovement movement)`
- **Type**: `public void`
- **Description**: Adds a movement to the end of the route
- **Parameters**:
  - `movement`: The movement to add

### `addMovement(int index, IMovement movement)`
- **Type**: `public void`
- **Description**: Adds a movement at the specified index
- **Parameters**:
  - `index`: The index
  - `movement`: The movement to add

### `addMovements(IMovement... movements)`
- **Type**: `public void`
- **Description**: Adds multiple movements to the end of the route
- **Parameters**:
  - `movements`: The movements to add

### `addMovements(Collection<? extends IMovement> movements)`
- **Type**: `public void`
- **Description**: Adds a collection of movements to the end of the route
- **Parameters**:
  - `movements`: The movements to add

### `add(RouteData routeData)`
- **Type**: `public void`
- **Description**: Adds all movements from another route data
- **Parameters**:
  - `routeData`: The route data to add

### `distance(LengthUnits units)`
- **Type**: `public double`
- **Description**: Gets the total distance of this route
- **Parameters**:
  - `units`: The length units for the result
- **Returns**: The total distance in the specified units

### `contains(INode<?,?> node)`
- **Type**: `public boolean`
- **Description**: Checks if this route contains the given node
- **Parameters**:
  - `node`: The node to check
- **Returns**: True if this route contains the given node, false otherwise

### `contains(IPath<?> path)`
- **Type**: `public boolean`
- **Description**: Checks if this route contains the given path
- **Parameters**:
  - `path`: The path to check
- **Returns**: True if this route contains the given path, false otherwise

### `addPlainMovement(INetworkMarkupElement networkElement, Point source, Point target)`
- **Type**: `public void`
- **Description**: Adds a plain movement with network element
- **Parameters**:
  - `networkElement`: The network element
  - `source`: The source point
  - `target`: The target point

### `addPlainMovement(Agent space, Point source, Point target)`
- **Type**: `public void`
- **Annotation**: `@AnyLogicInternalAPI`
- **Description**: Adds a plain movement with space
- **Parameters**:
  - `space`: The space
  - `source`: The source point
  - `target`: The target point

### `addPathMovement(IPath<?> path, boolean forward)`
- **Type**: `public void`
- **Description**: Adds a path movement with direction
- **Parameters**:
  - `path`: The path
  - `forward`: True for forward direction, false for backward direction

### `addPathMovement(IPath<?> path, double sourceOffset, double targetOffset, LengthUnits units)`
- **Type**: `public void`
- **Description**: Adds a path movement with offsets
- **Parameters**:
  - `path`: The path
  - `sourceOffset`: The source offset
  - `targetOffset`: The target offset
  - `units`: The length units for the offsets

### `addNodeTransferMovement(INode<?,?> node, IPath<?> sourcePath, IPath<?> targetPath)`
- **Type**: `public void`
- **Description**: Adds a node transfer movement
- **Parameters**:
  - `node`: The node
  - `sourcePath`: The source path
  - `targetPath`: The target path

### `addPortMovement(MarkupPort source, MarkupPort target)`
- **Type**: `public void`
- **Description**: Adds a port movement
- **Parameters**:
  - `source`: The source port
  - `target`: The target port

### `createPlainMovement(INetworkMarkupElement networkElement, Point source, Point target)`
- **Type**: `public static IMovement`
- **Description**: Creates a plain movement with network element
- **Parameters**:
  - `networkElement`: The network element
  - `source`: The source point
  - `target`: The target point
- **Returns**: The created movement

### `createPlainMovement(Agent space, Point source, Point target)`
- **Type**: `public static IMovement`
- **Annotation**: `@AnyLogicInternalAPI`
- **Description**: Creates a plain movement with space
- **Parameters**:
  - `space`: The space
  - `source`: The source point
  - `target`: The target point
- **Returns**: The created movement

### `createPathMovement(IPath<?> path, boolean forward)`
- **Type**: `public static IMovement`
- **Description**: Creates a path movement with direction
- **Parameters**:
  - `path`: The path
  - `forward`: True for forward direction, false for backward direction
- **Returns**: The created movement

### `createPathMovement(IPath<?> path, double sourceOffset, double targetOffset, LengthUnits units)`
- **Type**: `public static IMovement`
- **Description**: Creates a path movement with offsets
- **Parameters**:
  - `path`: The path
  - `sourceOffset`: The source offset
  - `targetOffset`: The target offset
  - `units`: The length units for the offsets
- **Returns**: The created movement

### `createPortMovement(MarkupPort source, MarkupPort target)`
- **Type**: `public static IMovement`
- **Description**: Creates a port movement
- **Parameters**:
  - `source`: The source port
  - `target`: The target port
- **Returns**: The created movement

### `createNodeTransferMovement(INode<?,?> node, IPath<?> sourcePath, IPath<?> targetPath)`
- **Type**: `public static IMovement`
- **Description**: Creates a node transfer movement
- **Parameters**:
  - `node`: The node
  - `sourcePath`: The source path
  - `targetPath`: The target path
- **Returns**: The created movement

### `removeMovement(IMovement movement)`
- **Type**: `public boolean`
- **Description**: Removes the specified movement from this route
- **Parameters**:
  - `movement`: The movement to remove
- **Returns**: True if the movement was removed, false otherwise

### `removeMovement(int index)`
- **Type**: `public void`
- **Description**: Removes the movement at the specified index
- **Parameters**:
  - `index`: The index

### `removeFirstMovement()`
- **Type**: `public void`
- **Description**: Removes the first movement from this route

### `removeLastMovement()`
- **Type**: `public void`
- **Description**: Removes the last movement from this route

### `getSourceLocation()`
- **Type**: `public IRouteLocation`
- **Description**: Gets the source location of this route
- **Returns**: The source location of this route

### `getTargetLocation()`
- **Type**: `public IRouteLocation`
- **Description**: Gets the target location of this route
- **Returns**: The target location of this route

### `toString()`
- **Type**: `public String`
- **Description**: Returns a string representation of this route
- **Overrides**: `toString` in class `Object`
- **Returns**: A string representation of this route

### `getLocationAtOffset(double offset, LengthUnits units)`
- **Type**: `public IRouteLocation`
- **Annotation**: `@AnyLogicInternalAPI`
- **Description**: Gets the location at the specified offset
- **Parameters**:
  - `offset`: The offset
  - `units`: The length units for the offset
- **Returns**: The location at the specified offset

### `getLocationAtOffset(double offset, LengthUnits units, IRouteLocation out)`
- **Type**: `public IRouteLocation`
- **Annotation**: `@AnyLogicInternalAPI`
- **Description**: Gets the location at the specified offset with output parameter
- **Parameters**:
  - `offset`: The offset
  - `units`: The length units for the offset
  - `out`: The output location object
- **Returns**: The location at the specified offset

### `findShortestRoute(Collection<RouteData> collection, LengthUnits units)`
- **Type**: `public static RouteData`
- **Description**: Finds the shortest route from a collection
- **Parameters**:
  - `collection`: The collection of routes
  - `units`: The length units for comparison
- **Returns**: The shortest route

### `iterator()`
- **Type**: `public Iterator<IMovement>`
- **Description**: Returns an iterator over the movements of this route
- **Specified by**: `iterator` in interface `Iterable<IMovement>`
- **Returns**: An iterator over the movements of this route
