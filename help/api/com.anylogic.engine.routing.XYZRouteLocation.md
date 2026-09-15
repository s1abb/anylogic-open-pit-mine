# Class XYZRouteLocation

## Inheritance Hierarchy
```
java.lang.Object
  com.anylogic.engine.routing.XYZRouteLocation
```

## All Implemented Interfaces
`IRouteLocation`, `Serializable`

## Class Declaration
```java
@AnyLogicInternalAPI
public class XYZRouteLocation
extends Object
implements IRouteLocation
```

## Description
Represents a location in 3D space in a routing system.

**See Also:** [Serialized Form](#)

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `XYZRouteLocation(Agent space, Level level, INetwork<?,?> network, INetworkMarkupElement networkElement, Position position)` | Full constructor with all parameters |
| `XYZRouteLocation(Agent space, Position position)` | Constructor with space and position |
| `XYZRouteLocation(INetwork<?,?> network, Position position)` | Constructor with network and position |
| `XYZRouteLocation(INetworkMarkupElement networkElement, Position position)` | Constructor with network element and position |
| `XYZRouteLocation(Level level, Position position)` | Constructor with level and position |

## Method Summary

| Modifier and Type | Method | Description |
|------------------|--------|-------------|
| `boolean` | `equals(Object obj)` | Compares this location with another object for equality |
| `Level` | `getLevel()` | Gets the level of this location |
| `INetwork<?,?>` | `getNetwork()` | Gets the network of this location |
| `INetworkMarkupElement` | `getNetworkElement()` | Gets the network element of this location |
| `Position` | `getPosition()` | Gets the position of this location |
| `Agent` | `getSpace()` | Gets the space of this location |
| `int` | `hashCode()` | Returns the hash code for this location |
| `String` | `toString()` | Returns a string representation of this location |

## Methods inherited from class java.lang.Object
`getClass`, `notify`, `notifyAll`, `wait`, `wait`, `wait`

## Constructor Details

### `XYZRouteLocation(Agent space, Position position)`
- **Description**: Constructor with space and position
- **Parameters**:
  - `space`: The space
  - `position`: The position

### `XYZRouteLocation(Level level, Position position)`
- **Description**: Constructor with level and position
- **Parameters**:
  - `level`: The level
  - `position`: The position

### `XYZRouteLocation(INetwork<?,?> network, Position position)`
- **Description**: Constructor with network and position
- **Parameters**:
  - `network`: The network
  - `position`: The position

### `XYZRouteLocation(INetworkMarkupElement networkElement, Position position)`
- **Description**: Constructor with network element and position
- **Parameters**:
  - `networkElement`: The network element
  - `position`: The position

### `XYZRouteLocation(Agent space, Level level, INetwork<?,?> network, INetworkMarkupElement networkElement, Position position)`
- **Annotation**: `@AnyLogicInternalAPI`
- **Description**: Full constructor with all parameters
- **Parameters**:
  - `space`: The space
  - `level`: The level
  - `network`: The network
  - `networkElement`: The network element
  - `position`: The position

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
