# Interface IRouteProvider&lt;T extends IPathData&gt;

## Type Parameters
- `T` - a route data an agent will use to calculate a route length and determine its position on a route

## All Superinterfaces
Serializable

## All Known Subinterfaces
IGISRouteProvider, INetwork&lt;N,P&gt;

## All Known Implementing Classes
AbstractGISRouteProvider, AbstractGISRouteProviderWithCache, AbstractNetwork, AnyLogicOnlineRouteProvider, BRouterOSMRouteProvider, ConveyorNetwork, GISNetwork, GraphHopperRouteProvider, JSONRouteProvider, Network, PlainGISRouteProvider, YoursOSMRouteProvider

```java
public interface IRouteProvider<T extends IPathData> extends Serializable
```

This is a base interface to create a route for an agent. Route provider has several implementations: network, straight movement, specific movement in GIS space such as movement by roads.

**Author:** AnyLogic North America, LLC https://anylogic.com

**See Also:** IPathDataAgent

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `double` | `getDistance(Point startPoint, Point endPoint)` | Creates a route from one point to another and calculates its length |
| `double` | `getLength(T pathData)` | Retrieves length of the specified route |
| `T` | `getPathData(Point startPoint, Point endPoint, T out)` | Retrieves the route data an agent will use to calculate the route length and determine its position on the route |
| `Position` | `getPositionAtOffset(T pathData, double reverseOffset, Position out)` | Retrieves agent's position on the route |

## Method Details

### getPathData
```java
T getPathData(Point startPoint, Point endPoint, T out)
```

Retrieves the route data an agent will use to calculate the route length and determine its position on the route by calling getLength(IPathData) and getPositionAtOffset(IPathData, double, Position) respectively.

**Parameters:**
- `startPoint` - Start point of the route
- `endPoint` - End point of the route
- `out` - This parameter was added to prevent creating additional instances of route data objects; could be null

**Returns:** the route data to move an agent between specified points

**See Also:** IPathData

### getPositionAtOffset
```java
Position getPositionAtOffset(T pathData, double reverseOffset, Position out)
```

Retrieves agent's position on the route.

**Parameters:**
- `pathData` - The route data of moving agent
- `reverseOffset` - The distance that agent should pass to reach the end of the route
- `out` - This parameter was added to prevent creating additional instances; could be null

**Returns:** Agent's position on the route

**See Also:** Position, IPathData

### getDistance
```java
double getDistance(Point startPoint, Point endPoint)
```

Creates a route from one point to another and calculates its length. Uses route provider to create a route.

**Parameters:**
- `startPoint` - Start point of a route
- `endPoint` - End point of a route

**Returns:** length of a route from one point to another

### getLength
```java
double getLength(T pathData)
```

Retrieves length of the specified route.

**Parameters:**
- `pathData` - the route data

**Returns:** length of the specified route
