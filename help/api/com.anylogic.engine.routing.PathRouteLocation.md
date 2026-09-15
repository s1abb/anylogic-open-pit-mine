# Class PathRouteLocation

## Inheritance Hierarchy
```
java.lang.Object
  com.anylogic.engine.routing.PathRouteLocation
```

## All Implemented Interfaces
`IRouteLocation`, `Serializable`

## Class Declaration
```java
@AnyLogicInternalAPI
public class PathRouteLocation
extends Object
implements IRouteLocation
```

## Description
Represents a location on a path in a routing system.

**See Also:** [Serialized Form](#)

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `PathRouteLocation(INetworkMarkupElement element, IPath<?> path, double offset, LengthUnits units)` | Constructor with network element, path, and offset |
| `PathRouteLocation(INetworkMarkupElement element, IPath<?> path, double offset, LengthUnits units, PathMovementDirection direction)` | Constructor with network element, path, offset, and direction |
| `PathRouteLocation(IPath<?> path, double offset, LengthUnits units)` | Constructor with path and offset |
| `PathRouteLocation(IPath<?> path, double offset, LengthUnits units, PathMovementDirection direction)` | Constructor with path, offset, and direction |

## Method Summary

| Modifier and Type | Method | Description |
|------------------|--------|-------------|
| `boolean` | `equals(Object obj)` | Compares this location with another object for equality |
| `PathMovementDirection` | `getDirection()` | Gets the direction of this location |
| `Level` | `getLevel()` | Gets the level of this location |
| `INetwork<?,?>` | `getNetwork()` | Gets the network of this location |
| `INetworkMarkupElement` | `getNetworkElement()` | Gets the network element of this location |
| `double` | `getOffset(LengthUnits units)` | Gets the offset of this location |
| `IPath<?>` | `getPath()` | Gets the path of this location |
| `Position` | `getPosition()` | Gets the position of this location |
| `Agent` | `getSpace()` | Gets the space of this location |
| `int` | `hashCode()` | Returns the hash code for this location |
| `String` | `toString()` | Returns a string representation of this location |

## Methods inherited from class java.lang.Object
`getClass`, `notify`, `notifyAll`, `wait`, `wait`, `wait`

## Constructor Details

### `PathRouteLocation(IPath<?> path, double offset, LengthUnits units)`
- **Description**: Constructor with path and offset
- **Parameters**:
  - `path`: The path
  - `offset`: The offset
  - `units`: The length units for the offset

### `PathRouteLocation(IPath<?> path, double offset, LengthUnits units, PathMovementDirection direction)`
- **Description**: Constructor with path, offset, and direction
- **Parameters**:
  - `path`: The path
  - `offset`: The offset
  - `units`: The length units for the offset
  - `direction`: The movement direction

### `PathRouteLocation(INetworkMarkupElement element, IPath<?> path, double offset, LengthUnits units)`
- **Description**: Constructor with network element, path, and offset
- **Parameters**:
  - `element`: The network element
  - `path`: The path
  - `offset`: The offset
  - `units`: The length units for the offset

### `PathRouteLocation(INetworkMarkupElement element, IPath<?> path, double offset, LengthUnits units, PathMovementDirection direction)`
- **Description**: Constructor with network element, path, offset, and direction
- **Parameters**:
  - `element`: The network element
  - `path`: The path
  - `offset`: The offset
  - `units`: The length units for the offset
  - `direction`: The movement direction

## Method Details

### `getSpace()`
- **Type**: `public Agent`
- **Description**: Gets the space of this location
- **Specified by**: `getSpace` in interface `IRouteLocation`
- **Returns**: The space of this location

### `getPosition()`
- **Type**: `public Position`
- **Description**: Gets the position of this location
- **Specified by**: `getPosition` in interface `IRouteLocation`
- **Returns**: The position of this location

### `getLevel()`
- **Type**: `public Level`
- **Description**: Gets the level of this location
- **Specified by**: `getLevel` in interface `IRouteLocation`
- **Returns**: The level of this location

### `getNetwork()`
- **Type**: `public INetwork<?,?>`
- **Description**: Gets the network of this location
- **Specified by**: `getNetwork` in interface `IRouteLocation`
- **Returns**: The network of this location

### `getNetworkElement()`
- **Type**: `public INetworkMarkupElement`
- **Description**: Gets the network element of this location
- **Specified by**: `getNetworkElement` in interface `IRouteLocation`
- **Returns**: The network element of this location

### `getPath()`
- **Type**: `public IPath<?>`
- **Description**: Gets the path of this location
- **Returns**: The path of this location

### `getOffset(LengthUnits units)`
- **Type**: `public double`
- **Description**: Gets the offset of this location
- **Parameters**:
  - `units`: The length units for the result
- **Returns**: The offset in the specified units

### `getDirection()`
- **Type**: `public PathMovementDirection`
- **Description**: Gets the direction of this location
- **Returns**: The direction of this location

### `toString()`
- **Type**: `public String`
- **Description**: Returns a string representation of this location
- **Overrides**: `toString` in class `Object`
- **Returns**: A string representation of this location

### `hashCode()`
- **Type**: `public int`
- **Description**: Returns the hash code for this location
- **Overrides**: `hashCode` in class `Object`
- **Returns**: The hash code for this location

### `equals(Object obj)`
- **Type**: `public boolean`
- **Description**: Compares this location with another object for equality
- **Overrides**: `equals` in class `Object`
- **Parameters**:
  - `obj`: The object to compare with
- **Returns**: True if this location is equal to the given object, false otherwise
