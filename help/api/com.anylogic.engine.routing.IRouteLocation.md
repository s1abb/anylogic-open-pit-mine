# Interface IRouteLocation

## All Superinterfaces
`Serializable`

## All Known Implementing Classes
`PathRouteLocation`, `XYZRouteLocation`

## Interface Declaration
```java
@AnyLogicInternalAPI
public interface IRouteLocation
extends Serializable
```

## Description
Represents a location in a routing system.

## Method Summary

| Modifier and Type | Method | Description |
|------------------|--------|-------------|
| `Level` | `getLevel()` | Gets the level of this location |
| `INetwork<?,?>` | `getNetwork()` | Gets the network of this location |
| `INetworkMarkupElement` | `getNetworkElement()` | Gets the network element of this location |
| `Position` | `getPosition()` | Gets the position of this location |
| `Agent` | `getSpace()` | Gets the space of this location |

## Method Details

### `getSpace()`
- **Type**: `Agent`
- **Description**: Gets the space of this location
- **Returns**: The space of this location

### `getPosition()`
- **Type**: `Position`
- **Description**: Gets the position of this location
- **Returns**: The position of this location

### `getLevel()`
- **Type**: `Level`
- **Description**: Gets the level of this location
- **Returns**: The level of this location

### `getNetwork()`
- **Type**: `INetwork<?,?>`
- **Description**: Gets the network of this location
- **Returns**: The network of this location

### `getNetworkElement()`
- **Type**: `INetworkMarkupElement`
- **Description**: Gets the network element of this location
- **Returns**: The network element of this location
