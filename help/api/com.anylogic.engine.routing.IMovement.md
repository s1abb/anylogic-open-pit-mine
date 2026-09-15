# Interface IMovement

## All Superinterfaces
`Serializable`

## All Known Implementing Classes
`PathMovement`, `PlainMovement`, `PortMovement`

## Interface Declaration
```java
public interface IMovement
extends Serializable
```

## Description
Represents a movement in a routing system.

## Method Summary

| Modifier and Type | Method | Description |
|------------------|--------|-------------|
| `boolean` | `contains(IRouteLocation location)` | Checks if this movement contains the given location |
| `double` | `distance(LengthUnits units)` | Gets the distance of this movement |
| `Level` | `getLevel()` | Gets the level of this movement |
| `default IRouteLocation` | `getLocationAtOffset(double offset, LengthUnits units)` | Gets the location at the specified offset |
| `IRouteLocation` | `getLocationAtOffset(double offset, LengthUnits units, IRouteLocation out)` | Gets the location at the specified offset with output parameter |
| `INetwork<?,?>` | `getNetwork()` | Gets the network of this movement |
| `INetworkMarkupElement` | `getNetworkElement()` | Gets the network element of this movement |
| `Agent` | `getSpace()` | Gets the space of this movement |
| `MovementType` | `getType()` | Gets the type of this movement |
| `default boolean` | `isMovingForward()` | Checks if this movement is moving forward |

## Method Details

### `getSpace()`
- **Type**: `Agent`
- **Description**: Gets the space of this movement
- **Returns**: The space of this movement

### `getLevel()`
- **Type**: `Level`
- **Description**: Gets the level of this movement
- **Returns**: The level of this movement

### `getNetworkElement()`
- **Type**: `INetworkMarkupElement`
- **Description**: Gets the network element of this movement
- **Returns**: The network element of this movement

### `getNetwork()`
- **Type**: `INetwork<?,?>`
- **Description**: Gets the network of this movement
- **Returns**: The network of this movement

### `getType()`
- **Type**: `MovementType`
- **Description**: Gets the type of this movement
- **Returns**: The type of this movement

### `distance(LengthUnits units)`
- **Type**: `double`
- **Description**: Gets the distance of this movement
- **Parameters**:
  - `units`: The length units for the result
- **Returns**: The distance in the specified units

### `getLocationAtOffset(double offset, LengthUnits units)`
- **Type**: `default IRouteLocation`
- **Annotation**: `@AnyLogicInternalAPI`
- **Description**: Gets the location at the specified offset
- **Parameters**:
  - `offset`: The offset
  - `units`: The length units for the offset
- **Returns**: The location at the specified offset

### `getLocationAtOffset(double offset, LengthUnits units, IRouteLocation out)`
- **Type**: `IRouteLocation`
- **Annotation**: `@AnyLogicInternalAPI`
- **Description**: Gets the location at the specified offset with output parameter
- **Parameters**:
  - `offset`: The offset
  - `units`: The length units for the offset
  - `out`: The output location object
- **Returns**: The location at the specified offset

### `contains(IRouteLocation location)`
- **Type**: `boolean`
- **Annotation**: `@AnyLogicInternalAPI`
- **Description**: Checks if this movement contains the given location
- **Parameters**:
  - `location`: The location to check
- **Returns**: True if this movement contains the given location, false otherwise

### `isMovingForward()`
- **Type**: `default boolean`
- **Description**: Checks if this movement is moving forward
- **Returns**: True if this movement is moving forward, false otherwise
