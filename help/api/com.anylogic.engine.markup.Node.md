# Class Node

## Package
`com.anylogic.engine.markup`

## Inheritance Hierarchy
```
java.lang.Object
  com.anylogic.engine.markup.AbstractMarkup
    com.anylogic.engine.markup.MarkupShape
      com.anylogic.engine.markup.NetworkMarkupElement
        com.anylogic.engine.markup.Node
```

## All Implemented Interfaces
`AggregatableAnimationElement`, `AnimationStaticLocationProvider`, `HasLevel`, `IMarkupLibraryDescriptor`, `INetworkMarkupElement`, `INode<Node,Path>`, `LevelElement`, `LevelMarkup`, `com.anylogic.engine.markup.material_handling.IMaterialMarkupLibraryDescriptor`, `com.anylogic.engine.markup.material_handling.INodeDescriptor<Agent>`, `SVGElement`, `Serializable`

## Direct Known Subclasses
`AreaNode`, `NetworkPortImpl`, `PointNode`

## Class Declaration
```java
public abstract class Node
extends NetworkMarkupElement
implements INode<Node,Path>, com.anylogic.engine.markup.material_handling.INodeDescriptor<Agent>, LevelMarkup
```

Implementation of INode for network in continuous space.

**Author:** AnyLogic North America, LLC https://anylogic.com

**See Also:** [Serialized Form](#)

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `Node()` | Default constructor |
| `Node(Agent owner)` | Constructor with owner |
| `Node(Agent owner, ShapeDrawMode drawMode, boolean isPublic, Paint fillColor, PathEnd<Path>... pathEnds)` | **Deprecated.** Deprecated in version 8.4, will be removed in the future releases |
| `Node(Agent owner, ShapeDrawMode drawMode, boolean isPublic, Paint fillColor, boolean limitSpeed, double maxSpeedInMPS, PathEnd<Path>... pathEnds)` | **Deprecated.** Deprecated in version 8.4, will be removed in the future releases |

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `void` | `addConnection(Path path, PathEndType type)` | Adds a connection to the node |
| `final Class<? extends ExtAgentWithSpatialMetrics>` | `getCompatibleAgentExtensionClass()` | This method is internal and shouldn't be called by user |
| `final Path` | `getConnection(int index)` | Returns connection of this node with another node by index |
| `final int` | `getConnectionsCount()` | Amount of the node's connections to other nodes |
| `Color` | `getFillColor()` | Returns the fill color of the shape |
| `Texture` | `getFillTexture()` | Returns the fill texture of the shape |
| `abstract Color` | `getLineColor()` | Returns the line color of the markup element |
| `abstract Texture` | `getLineTexture()` | Returns the line texture of the markup element |
| `com.anylogic.engine.markup.material_handling.INodeDescriptor<Agent>` | `getMaterialLibraryDescriptor()` | Gets the material library descriptor |
| `double` | `getMaxSpeed(SpeedUnits units)` | Returns max allowed speed in this node in specified speed units |
| `int` | `getNumberOfTransporters()` | Returns the number of path-guided transporters inside node |
| `final double` | `getTransferDistance(Path path1, Path path2)` | Gets the transfer distance between two paths |
| `Position` | `getTransferPositionByPercent(Path path1, Path path2, double percent, Position out)` | Gets the transfer position by percent |
| `Agent` | `getTransporter(int index)` | Returns the path-guided transporter with specified index |
| `List<Agent>` | `getTransporters()` | Returns the list of path-guided transporters inside the node |
| `abstract double` | `getZ()` | Returns the z coordinate of the node |
| `boolean` | `isLimitSpeed()` | Return true if speed is limited in this node, false otherwise |
| `void` | `setFillColor(Color fillColor)` | Sets the fill color of the shape |
| `void` | `setFillColor(Paint fillColor)` | Sets the fill color (or Texture) of the shape |
| `void` | `setLimitSpeed(boolean limitSpeed)` | Enables speed limit in this node if the argument is true, disables it if the argument is false |
| `abstract void` | `setLineColor(Color lineColor)` | Sets the line color of the markup element |
| `abstract void` | `setLineColor(Paint lineColor)` | Sets the line color (or Texture) of the markup element |
| `void` | `setMaxSpeed(double maxSpeed, SpeedUnits units)` | Sets the maximum allowed speed in specified units |

## Methods inherited from class com.anylogic.engine.markup.NetworkMarkupElement
`getDrawMode`, `getLevel`, `getNearestPoint`, `getNearestPoint`, `getNearestPoint`, `getNearestPoint`, `getNearestPoint`, `getNetwork`, `setLevel`

## Methods inherited from class com.anylogic.engine.markup.MarkupShape
`contains`, `error`, `getFullName`, `getOutsideLevelZ`, `getPresentable`, `getSpace`, `initialize`, `isClickHandled`, `isPublic`, `onClick`, `remove`, `setDrawMode`, `setOwner`

## Methods inherited from class com.anylogic.engine.markup.AbstractMarkup
`discardOwner`, `executeUserAction`, `findSVGElement`, `getName`, `getSVGId`, `initializeInternal`, `isVisible`, `onAggregatorInitialized`, `onAggregatorVisibilityChanged`, `removeSVGFromOwner`, `resetSVGState`, `setVisible`, `updateDynamicProperties`, `updateDynamicPropertiesStructural`, `updateSVGProperties`

## Methods inherited from class java.lang.Object
`equals`, `getClass`, `hashCode`, `notify`, `notifyAll`, `toString`, `wait`, `wait`, `wait`

## Methods inherited from interface com.anylogic.engine.markup.AggregatableAnimationElement
`initializeInternal`, `onAggregatorVisibilityChanged`, `postInitialize`

## Methods inherited from interface com.anylogic.engine.markup.AnimationStaticLocationProvider
`getPosition`, `getSpace`

## Methods inherited from interface com.anylogic.engine.markup.HasLevel
`getLevel`

## Methods inherited from interface com.anylogic.engine.markup.material_handling.IMaterialMarkupLibraryDescriptor
`getMarkup`, `setMarkup`

## Methods inherited from interface com.anylogic.engine.markup.INetworkMarkupElement
`contains`, `getNearestPoint`, `getNetwork`, `getSpace`, `randomPointInside`, `randomPointInside`, `randomPointInside`, `randomPointInside`

## Methods inherited from interface com.anylogic.engine.markup.INode
`getName`

## Methods inherited from interface com.anylogic.engine.markup.LevelElement
`setLevel`

## Constructor Details

### `Node()`
```java
public Node()
```
Default constructor

### `Node(Agent owner)`
```java
public Node(Agent owner)
```
Constructor with owner

### `Node(Agent owner, ShapeDrawMode drawMode, boolean isPublic, Paint fillColor, PathEnd<Path>... pathEnds)`
```java
@SafeVarargs
@Deprecated
public Node(Agent owner,
           ShapeDrawMode drawMode,
           boolean isPublic,
           Paint fillColor,
           PathEnd<Path>... pathEnds)
```
**Deprecated.**
Deprecated in version 8.4, will be removed in the future releases

**Parameters:**
- `owner` - The owner agent
- `drawMode` - The draw mode
- `isPublic` - Whether the node is public
- `fillColor` - The fill color
- `pathEnds` - The path ends

### `Node(Agent owner, ShapeDrawMode drawMode, boolean isPublic, Paint fillColor, boolean limitSpeed, double maxSpeedInMPS, PathEnd<Path>... pathEnds)`
```java
@SafeVarargs
@Deprecated
public Node(Agent owner,
           ShapeDrawMode drawMode,
           boolean isPublic,
           Paint fillColor,
           boolean limitSpeed,
           double maxSpeedInMPS,
           PathEnd<Path>... pathEnds)
```
**Deprecated.**
Deprecated in version 8.4, will be removed in the future releases

**Parameters:**
- `owner` - The owner agent
- `drawMode` - The draw mode
- `isPublic` - Whether the node is public
- `fillColor` - The fill color
- `limitSpeed` - Whether to limit speed
- `maxSpeedInMPS` - The maximum speed in meters per second
- `pathEnds` - The path ends

## Method Details

### `getMaterialLibraryDescriptor()`
```java
@AnyLogicInternalAPI
public com.anylogic.engine.markup.material_handling.INodeDescriptor<Agent> getMaterialLibraryDescriptor()
```
Gets the material library descriptor

### `addConnection(Path path, PathEndType type)`
```java
public void addConnection(Path path,
                         PathEndType type)
```
**Specified by:**
`addConnection` in interface `INode<Node,Path>`

### `isLimitSpeed()`
```java
public boolean isLimitSpeed()
```
Return true if speed is limited in this node, false otherwise

### `setLimitSpeed(boolean limitSpeed)`
```java
public void setLimitSpeed(boolean limitSpeed)
```
Enables speed limit in this node if the argument is true, disables it if the argument is false. The element should be uninitialized.

**Parameters:**
- `limitSpeed` - argument flag

### `getMaxSpeed(SpeedUnits units)`
```java
public double getMaxSpeed(SpeedUnits units)
```
Returns max allowed speed in this node in specified speed units

**Parameters:**
- `units` - speed units

**Returns:**
Max speed

### `setMaxSpeed(double maxSpeed, SpeedUnits units)`
```java
public void setMaxSpeed(double maxSpeed,
                       SpeedUnits units)
```
Sets the maximum allowed speed in specified units

**Parameters:**
- `maxSpeed` - new max speed
- `units` - speed units

### `getZ()`
```java
public abstract double getZ()
```
Returns the z coordinate of the node.

**Returns:**
The z coordinate of the node

### `getConnectionsCount()`
```java
public final int getConnectionsCount()
```
**Description copied from interface: INode**

Amount of the node's connections to other nodes.

**Specified by:**
`getConnectionsCount` in interface `INode<Node,Path>`

**Returns:**
Number of connections

### `getConnection(int index)`
```java
public final Path getConnection(int index)
```
**Description copied from interface: INode**

Returns connection of this node with another node by index.

**Specified by:**
`getConnection` in interface `INode<Node,Path>`

**Parameters:**
- `index` - the index of required connection in range (0, this.getConnectionsCount() - 1)

**Returns:**
Instance of com.anylogic.engine.markup.IPath interface

### `getTransferDistance(Path path1, Path path2)`
```java
@AnyLogicInternalAPI
public final double getTransferDistance(Path path1,
                                       Path path2)
```
**Specified by:**
`getTransferDistance` in interface `INode<Node,Path>`

### `setLineColor(Color lineColor)`
```java
public abstract void setLineColor(Color lineColor)
```
Sets the line color of the markup element.

**Parameters:**
- `lineColor` - the new line color, null = do not draw the markup element line

### `setLineColor(Paint lineColor)`
```java
public abstract void setLineColor(Paint lineColor)
```
Sets the line color (or Texture) of the markup element.

**Specified by:**
`setLineColor` in interface `INode<Node,Path>`

**Parameters:**
- `lineColor` - the new line color, null = do not draw the markup element line

### `getLineColor()`
```java
public abstract Color getLineColor()
```
Returns the line color of the markup element, or null if markup element has no line color or has textured line (in this case getLineTexture() should be used instead)

**Specified by:**
`getLineColor` in interface `INode<Node,Path>`

**Returns:**
The line color of the markup element

### `getLineTexture()`
```java
public abstract Texture getLineTexture()
```
Returns the line texture of the markup element, if the markup element has line texture

**Specified by:**
`getLineTexture` in interface `INode<Node,Path>`

**Returns:**
The line texture of the markup element

### `setFillColor(Color fillColor)`
```java
public void setFillColor(Color fillColor)
```
Sets the fill color of the shape.

**Parameters:**
- `fillColor` - the new fill color, null = do not fill the shape

### `setFillColor(Paint fillColor)`
```java
public void setFillColor(Paint fillColor)
```
Sets the fill color (or Texture) of the shape.

**Specified by:**
`setFillColor` in interface `INode<Node,Path>`

**Parameters:**
- `fillColor` - the new fill color, null = do not fill the shape

### `getFillColor()`
```java
public Color getFillColor()
```
Returns the fill color of the shape, or null if shape has no fill color or has textured fill (in this case getFillTexture() should be used instead)

**Specified by:**
`getFillColor` in interface `INode<Node,Path>`

**Returns:**
The fill color of the shape

### `getFillTexture()`
```java
public Texture getFillTexture()
```
Returns the fill texture of the shape, if the shape has fill texture

**Specified by:**
`getFillTexture` in interface `INode<Node,Path>`

**Returns:**
The fill texture of the shape

### `getTransferPositionByPercent(Path path1, Path path2, double percent, Position out)`
```java
@AnyLogicInternalAPI
public Position getTransferPositionByPercent(Path path1,
                                            Path path2,
                                            double percent,
                                            Position out)
```
**Specified by:**
`getTransferPositionByPercent` in interface `INode<Node,Path>`

### `getCompatibleAgentExtensionClass()`
```java
@AnyLogicInternalAPI
public final Class<? extends ExtAgentWithSpatialMetrics> getCompatibleAgentExtensionClass()
```
**Description copied from interface: INode**

This method is internal and shouldn't be called by user.
It may be removed/renamed in future.

**Specified by:**
`getCompatibleAgentExtensionClass` in interface `INode<Node,Path>`

### `getTransporters()`
```java
public List<Agent> getTransporters()
```
Returns the list of path-guided transporters inside the node which is a part of a network.

**Specified by:**
`getTransporters` in interface `com.anylogic.engine.markup.material_handling.INodeDescriptor<Agent>`

**Returns:**
List of path-guided transporters inside node.

### `getNumberOfTransporters()`
```java
public int getNumberOfTransporters()
```
Returns the number of path-guided transporters inside node which is a part of a network.

**Specified by:**
`getNumberOfTransporters` in interface `com.anylogic.engine.markup.material_handling.INodeDescriptor<Agent>`

**Returns:**
Number of path-guided transporters inside the node.

### `getTransporter(int index)`
```java
public Agent getTransporter(int index)
```
Returns the path-guided transporter with specified index inside the node which is a part of a network.

**Specified by:**
`getTransporter` in interface `com.anylogic.engine.markup.material_handling.INodeDescriptor<Agent>`

**Returns:**
Path-guided transporter with a specified index.
