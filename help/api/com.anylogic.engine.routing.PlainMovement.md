# Class PlainMovement

## Inheritance Hierarchy
```
java.lang.Object
  com.anylogic.engine.routing.PlainMovement
```

## All Implemented Interfaces
`IMovement`, `Serializable`

## Class Declaration
```java
public class PlainMovement
extends Object
implements IMovement
```

## Description
Represents a straight-line movement in a routing system.

**See Also:** [Serialized Form](#)

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `PlainMovement(Agent space, Point source, Point target)` | Constructor with space, source, and target |
| `PlainMovement(INetwork<?,?> network, Point source, Point target)` | Constructor with network, source, and target |
| `PlainMovement(INetworkMarkupElement networkElement, Point source, Point target)` | Constructor with network element, source, and target |
| `PlainMovement(Level level, Point source, Point target)` | Constructor with level, source, and target |

## Method Summary

| Modifier and Type | Method | Description |
|------------------|--------|-------------|
| `boolean` | `contains(IRouteLocation location)` | Checks if this movement contains the given location |
| `double` | `distance(LengthUnits units)` | Gets the distance of this movement |
| `boolean` | `equals(Object obj)` | Compares this movement with another object for equality |
| `Level` | `getLevel()` | Gets the level of this movement |
| `IRouteLocation` | `getLocationAtOffset(double offset, LengthUnits units, IRouteLocation out)` | Gets the location at the specified offset |
| `INetwork<?,?>` | `getNetwork()` | Gets the network of this movement |
| `INetworkMarkupElement` | `getNetworkElement()` | Gets the network element of this movement |
| `Position` | `getNormal()` | Gets the normal vector of this movement |
| `Position` | `getSource()` | Gets the source position of this movement |
| `Agent` | `getSpace()` | Gets the space of this movement |
| `Position` | `getTarget()` | Gets the target position of this movement |
| `MovementType` | `getType()` | Gets the type of this movement |
| `int` | `hashCode()` | Returns the hash code for this movement |
| `String` | `toString()` | Returns a string representation of this movement |

## Methods inherited from class java.lang.Object
`getClass`, `notify`, `notifyAll`, `wait`, `wait`, `wait`

## Methods inherited from interface com.anylogic.engine.routing.IMovement
`getLocationAtOffset`, `isMovingForward`

## Constructor Details

### `PlainMovement(Level level, Point source, Point target)`
- **Description**: Constructor with level, source, and target
- **Parameters**:
  - `level`: The level
  - `source`: The source point
  - `target`: The target point

### `PlainMovement(INetwork<?,?> network, Point source, Point target)`
- **Description**: Constructor with network, source, and target
- **Parameters**:
  - `network`: The network
  - `source`: The source point
  - `target`: The target point

### `PlainMovement(INetworkMarkupElement networkElement, Point source, Point target)`
- **Description**: Constructor with network element, source, and target
- **Parameters**:
  - `networkElement`: The network element
  - `source`: The source point
  - `target`: The target point

### `PlainMovement(Agent space, Point source, Point target)`
- **Description**: Constructor with space, source, and target
- **Parameters**:
  - `space`: The space
  - `source`: The source point
  - `target`: The target point

## Method Details

### `getSpace()`
- **Type**: `public Agent`
- **Description**: Gets the space of this movement
- **Specified by**: `getSpace` in interface `IMovement`
- **Returns**: The space of this movement

### `getLevel()`
- **Type**: `public Level`
- **Description**: Gets the level of this movement
- **Specified by**: `getLevel` in interface `IMovement`
- **Returns**: The level of this movement

### `getSource()`
- **Type**: `public Position`
- **Description**: Gets the source position of this movement
- **Returns**: The source position of this movement

### `getTarget()`
- **Type**: `public Position`
- **Description**: Gets the target position of this movement
- **Returns**: The target position of this movement

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

### `toString()`
- **Type**: `public String`
- **Description**: Returns a string representation of this movement
- **Overrides**: `toString` in class `Object`
- **Returns**: A string representation of this movement

### `getNormal()`
- **Type**: `public Position`
- **Annotation**: `@AnyLogicInternalAPI`
- **Description**: Gets the normal vector of this movement
- **Returns**: The normal vector of this movement

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
