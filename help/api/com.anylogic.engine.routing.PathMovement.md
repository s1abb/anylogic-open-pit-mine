# Class PathMovement

## Inheritance Hierarchy
```
java.lang.Object
  com.anylogic.engine.routing.PathMovement
```

## All Implemented Interfaces
`IMovement`, `Serializable`

## Class Declaration
```java
public class PathMovement
extends Object
implements IMovement
```

## Description
Represents movement along a path in a network.

**See Also:** [Serialized Form](#)

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `PathMovement(INetworkMarkupElement networkElement, IPath<?> path, double sourceOffset, double targetOffset, LengthUnits units)` | Constructor with network element, path, and offsets |
| `PathMovement(INetworkMarkupElement networkElement, IPath<?> path, double sourceOffset, double targetOffset, PathMovementDirection direction, LengthUnits units)` | Constructor with network element, path, offsets, and direction |
| `PathMovement(IPath<?> path, double sourceOffset, double targetOffset, LengthUnits units)` | Constructor with path and offsets |

## Method Summary

| Modifier and Type | Method | Description |
|------------------|--------|-------------|
| `boolean` | `contains(IRouteLocation location)` | Checks if this movement contains the given location |
| `double` | `distance(LengthUnits units)` | Gets the distance of this movement |
| `boolean` | `equals(Object obj)` | Compares this movement with another object for equality |
| `PathMovementDirection` | `getDirection()` | Gets the direction of this movement |
| `Level` | `getLevel()` | Gets the level of this movement |
| `IRouteLocation` | `getLocationAtOffset(double offset, LengthUnits units, IRouteLocation out)` | Gets the location at the specified offset |
| `INetwork<?,?>` | `getNetwork()` | Gets the network of this movement |
| `INetworkMarkupElement` | `getNetworkElement()` | Gets the network element of this movement |
| `IPath<?>` | `getPath()` | Gets the path of this movement |
| `double` | `getSourceOffset(LengthUnits units)` | Gets the source offset of this movement |
| `Agent` | `getSpace()` | Gets the space of this movement |
| `double` | `getTargetOffset(LengthUnits units)` | Gets the target offset of this movement |
| `MovementType` | `getType()` | Gets the type of this movement |
| `int` | `hashCode()` | Returns the hash code for this movement |
| `boolean` | `isMovingForward()` | Checks if this movement is moving forward |
| `String` | `toString()` | Returns a string representation of this movement |

## Methods inherited from class java.lang.Object
`getClass`, `notify`, `notifyAll`, `wait`, `wait`, `wait`

## Methods inherited from interface com.anylogic.engine.routing.IMovement
`getLocationAtOffset`

## Constructor Details

### `PathMovement(IPath<?> path, double sourceOffset, double targetOffset, LengthUnits units)`
- **Description**: Constructor with path and offsets
- **Parameters**:
  - `path`: The path to move along
  - `sourceOffset`: The source offset
  - `targetOffset`: The target offset
  - `units`: The length units for offsets

### `PathMovement(INetworkMarkupElement networkElement, IPath<?> path, double sourceOffset, double targetOffset, LengthUnits units)`
- **Description**: Constructor with network element, path, and offsets
- **Parameters**:
  - `networkElement`: The network element
  - `path`: The path to move along
  - `sourceOffset`: The source offset
  - `targetOffset`: The target offset
  - `units`: The length units for offsets

### `PathMovement(INetworkMarkupElement networkElement, IPath<?> path, double sourceOffset, double targetOffset, PathMovementDirection direction, LengthUnits units)`
- **Annotation**: `@AnyLogicInternalAPI`
- **Description**: Constructor with network element, path, offsets, and direction
- **Parameters**:
  - `networkElement`: The network element
  - `path`: The path to move along
  - `sourceOffset`: The source offset
  - `targetOffset`: The target offset
  - `direction`: The movement direction
  - `units`: The length units for offsets

## Method Details

### `getLevel()`
- **Type**: `public Level`
- **Description**: Gets the level of this movement
- **Specified by**: `getLevel` in interface `IMovement`
- **Returns**: The level of this movement

### `getPath()`
- **Type**: `public IPath<?>`
- **Description**: Gets the path of this movement
- **Returns**: The path of this movement

### `getSourceOffset(LengthUnits units)`
- **Type**: `public double`
- **Description**: Gets the source offset of this movement
- **Parameters**:
  - `units`: The length units for the result
- **Returns**: The source offset in the specified units

### `getTargetOffset(LengthUnits units)`
- **Type**: `public double`
- **Description**: Gets the target offset of this movement
- **Parameters**:
  - `units`: The length units for the result
- **Returns**: The target offset in the specified units

### `getSpace()`
- **Type**: `public Agent`
- **Description**: Gets the space of this movement
- **Specified by**: `getSpace` in interface `IMovement`
- **Returns**: The space of this movement

### `getNetworkElement()`
- **Type**: `public INetworkMarkupElement`
- **Description**: Gets the network element of this movement
- **Specified by**: `getNetworkElement` in interface `IMovement`
- **Returns**: The network element of this movement

### `getNetwork()`
- **Type**: `public INetwork<?,?>`
- **Description**: Gets the network of this movement
- **Specified by**: `getNetwork` in interface `IMovement`
- **Returns**: The network of this movement

### `getType()`
- **Type**: `public MovementType`
- **Description**: Gets the type of this movement
- **Specified by**: `getType` in interface `IMovement`
- **Returns**: The type of this movement

### `distance(LengthUnits units)`
- **Type**: `public double`
- **Description**: Gets the distance of this movement
- **Specified by**: `distance` in interface `IMovement`
- **Parameters**:
  - `units`: The length units for the result
- **Returns**: The distance in the specified units

### `getDirection()`
- **Type**: `public PathMovementDirection`
- **Description**: Gets the direction of this movement
- **Returns**: The direction of this movement

### `isMovingForward()`
- **Type**: `public boolean`
- **Description**: Checks if this movement is moving forward
- **Specified by**: `isMovingForward` in interface `IMovement`
- **Returns**: True if this movement is moving forward, false otherwise

### `toString()`
- **Type**: `public String`
- **Description**: Returns a string representation of this movement
- **Overrides**: `toString` in class `Object`
- **Returns**: A string representation of this movement

### `getLocationAtOffset(double offset, LengthUnits units, IRouteLocation out)`
- **Type**: `public IRouteLocation`
- **Annotation**: `@AnyLogicInternalAPI`
- **Description**: Gets the location at the specified offset
- **Specified by**: `getLocationAtOffset` in interface `IMovement`
- **Parameters**:
  - `offset`: The offset
  - `units`: The length units for the offset
  - `out`: The output location object
- **Returns**: The location at the specified offset

### `contains(IRouteLocation location)`
- **Type**: `public boolean`
- **Description**: Checks if this movement contains the given location
- **Specified by**: `contains` in interface `IMovement`
- **Parameters**:
  - `location`: The location to check
- **Returns**: True if this movement contains the given location, false otherwise

### `hashCode()`
- **Type**: `public int`
- **Description**: Returns the hash code for this movement
- **Overrides**: `hashCode` in class `Object`
- **Returns**: The hash code for this movement

### `equals(Object obj)`
- **Type**: `public boolean`
- **Description**: Compares this movement with another object for equality
- **Overrides**: `equals` in class `Object`
- **Parameters**:
  - `obj`: The object to compare with
- **Returns**: True if this movement is equal to the given object, false otherwise
