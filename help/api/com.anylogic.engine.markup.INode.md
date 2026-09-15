# INode

## Package
`com.anylogic.engine.markup`

## Interface
`INode<N extends INode<N,P>,P extends IPath<N>>`

## Type Parameters
- `N` - network node, an instance of INode
- `P` - network path, an instance of IPath

## All Superinterfaces
`AnimationStaticLocationProvider`, `INetworkMarkupElement`, `Serializable`

## All Known Implementing Classes
`AreaNode`, `ConveyorCustomStation`, `ConveyorNode`, `ConveyorPointNode`, `ConveyorPortImpl`, `ConveyorTransferTable`, `ConveyorTransitionalNode`, `ConveyorTurnStation`, `ConveyorTurntable`, `GISNode`, `GISPoint`, `GISRegion`, `NetworkPortImpl`, `Node`, `PointNode`, `PolygonalNode`, `QueueArea`, `RectangularNode`

## Description
Basic interface for network node.

## Author
AnyLogic North America, LLC https://anylogic.com

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `void` | `addConnection(P path, PathEndType type)` | |
| `Class<? extends ExtAgentWithSpatialMetrics>` | `getCompatibleAgentExtensionClass()` | This method is internal and shouldn't be called by user. It may be removed/renamed in future. |
| `P` | `getConnection(int index)` | Returns connection of this node with another node by index. |
| `int` | `getConnectionsCount()` | Amount of the node's connections to other nodes. |
| `Color` | `getFillColor()` | Returns the fill color of the shape, or null if shape has no fill color or has textured fill (in this case getFillTexture() should be used instead) |
| `Texture` | `getFillTexture()` | Returns the fill texture of the shape, if the shape has fill texture |
| `Color` | `getLineColor()` | Returns the line color of the markup element, or null if markup element has no line color or has textured line (in this case getLineTexture() should be used instead) |
| `Texture` | `getLineTexture()` | Returns the line texture of the markup element, if the markup element has line texture |
| `String` | `getName()` | |
| `double` | `getTransferDistance(P path1, P path2)` | |
| `Position` | `getTransferPositionByPercent(P path1, P path2, double percent, Position out)` | |
| `void` | `setFillColor(Paint color)` | Sets the fill color (or Texture) of the shape. |
| `void` | `setLineColor(Paint lineColor)` | Sets the line color (or Texture) of the markup element. |

## Methods inherited from interface com.anylogic.engine.markup.AnimationStaticLocationProvider
`getPosition`, `getSpace`

## Methods inherited from interface com.anylogic.engine.markup.INetworkMarkupElement
`contains`, `getNearestPoint`, `getNetwork`, `getSpace`, `randomPointInside`, `randomPointInside`, `randomPointInside`, `randomPointInside`

## Method Details

### getConnectionsCount
```java
int getConnectionsCount()
```
Amount of the node's connections to other nodes.

**Returns:**  
number of connections

### getConnection
```java
P getConnection(int index)
```
Returns connection of this node with another node by index.

**Parameters:**  
`index` - the index of required connection in range (0, this.getConnectionsCount() - 1)

**Returns:**  
instance of com.anylogic.engine.markup.IPath interface

### addConnection
```java
void addConnection(P path,
                  PathEndType type)
```

### getTransferDistance
```java
@AnyLogicInternalAPI
double getTransferDistance(P path1,
                          P path2)
```

### getTransferPositionByPercent
```java
@AnyLogicInternalAPI
Position getTransferPositionByPercent(P path1,
                                     P path2,
                                     double percent,
                                     Position out)
```

### getName
```java
String getName()
```

### setLineColor
```java
void setLineColor(Paint lineColor)
```
Sets the line color (or Texture) of the markup element.

**Parameters:**  
`lineColor` - the new line color, null = do not draw the markup element line

### getLineColor
```java
Color getLineColor()
```
Returns the line color of the markup element, or null if markup element has no line color or has textured line (in this case getLineTexture() should be used instead)

**Returns:**  
the line color of the markup element

### getLineTexture
```java
Texture getLineTexture()
```
Returns the line texture of the markup element, if the markup element has line texture

**Returns:**  
the line texture of the markup element

### getFillColor
```java
Color getFillColor()
```
Returns the fill color of the shape, or null if shape has no fill color or has textured fill (in this case getFillTexture() should be used instead)

**Returns:**  
the fill color of the shape

### getFillTexture
```java
Texture getFillTexture()
```
Returns the fill texture of the shape, if the shape has fill texture

**Returns:**  
the fill texture of the shape

### setFillColor
```java
void setFillColor(Paint color)
```
Sets the fill color (or Texture) of the shape.

**Parameters:**  
`fillColor` - the new fill color, null = do not fill the shape

### getCompatibleAgentExtensionClass
```java
@AnyLogicInternalAPI
Class<? extends ExtAgentWithSpatialMetrics> getCompatibleAgentExtensionClass()
```
This method is internal and shouldn't be called by user.
It may be removed/renamed in future.
