# PointNode

## Package
`com.anylogic.engine.markup`

## Class
`PointNode`

## Inheritance
```
java.lang.Object
  └── com.anylogic.engine.markup.AbstractMarkup
       └── com.anylogic.engine.markup.MarkupShape
            └── com.anylogic.engine.markup.NetworkMarkupElement
                 └── com.anylogic.engine.markup.Node
                      └── com.anylogic.engine.markup.PointNode
```

## All Implemented Interfaces
`AbstractPositionalMarkup`, `AggregatableAnimationElement`, `AnimationStaticLocationProvider`, `HasLevel`, `IMarkupLibraryDescriptor`, `INetworkMarkupElement`, `INode<Node,Path>`, `LevelElement`, `LevelMarkup`, `com.anylogic.engine.markup.material_handling.IMaterialMarkupLibraryDescriptor`, `com.anylogic.engine.markup.material_handling.INodeDescriptor<Agent>`, `SVGElement`, `UsdElement`, `Serializable`

## See Also
Serialized Form

## Field Summary
Fields inherited from interface com.anylogic.engine.presentation.UsdElement:
`ID_NOT_SET`

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `PointNode()` | |
| `PointNode(Agent owner)` | |
| `PointNode(Agent owner, double x, double y, double z)` | |
| `PointNode(Agent owner, ShapeDrawMode drawMode, boolean isPublic, double x, double y, double z)` | Deprecated. Deprecated in version 8.4, will be removed in the future releases |
| `PointNode(Agent owner, ShapeDrawMode drawMode, boolean isPublic, double x, double y, double z, double radius, Paint fillColor)` | Deprecated. Deprecated in version 8.4, will be removed in the future releases |
| `PointNode(Agent owner, ShapeDrawMode drawMode, boolean isPublic, double x, double y, double z, double radius, Paint fillColor, boolean limitSpeed, double maxSpeedInMPS, PathEnd<Path>[] pathends)` | This method is internal and shouldn't be called by user. It may be removed/renamed in future. It is public due to technical reasons. |
| `PointNode(Agent owner, ShapeDrawMode drawMode, boolean isPublic, double x, double y, double z, double radius, Paint fillColor, boolean limitSpeed, double maxSpeedInMPS, PathEnd<Path>[] pathends, PathConnector<Path,Node>... connectors)` | Deprecated. Deprecated in version 8.4, will be removed in the future releases |
| `PointNode(Agent owner, ShapeDrawMode drawMode, boolean isPublic, double x, double y, double z, double radius, Paint fillColor, PathEnd<Path>[] pathEnds, PathConnector<Path,Node>... connectors)` | Deprecated. Deprecated in version 8.4, will be removed in the future releases |
| `PointNode(Agent owner, ShapeDrawMode drawMode, boolean isPublic, double x, double y, double z, PathEnd<Path>[] pathEnds, PathConnector<Path,Node>... connectors)` | Deprecated. Deprecated in version 8.4, will be removed in the future releases |

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `void` | `addConnector(PathConnector<Path,Node> connector)` | Adds internal path connector to the inside of this node. |
| `boolean` | `contains(double px, double py)` | Test if the shape contains the point with the given coordinates (relative to this shape's container, i.e. |
| `BoundingRectangle` | `getBoundingRectangle()` | |
| `Collection<Path>` | `getConnectedExternalPaths(Path path)` | |
| `Collection<Path>` | `getConnectedInternalPaths(Path path)` | |
| `PathConnector<Path,Node>` | `getConnector(Path path1, Path path2)` | Return a connection between two paths inside the node. |
| `List<PathConnector<Path,Node>>` | `getConnectors()` | |
| `Color` | `getLineColor()` | The same as Node.getFillColor() |
| `Texture` | `getLineTexture()` | The same as Node.getFillTexture() |
| `double` | `getNearestPoint(double x, double y, double z, Point output)` | Calculates (using the output object) the point in this space markup element nearest to the given (x, y, z) point. |
| `double` | `getNearestPoint(double x, double y, Point output)` | Calculates (using the output object) the point in this space markup element nearest to the given (x, y) point. |
| `Position` | `getPosition(int index, int totalNumber, Position out)` | Returns the item position with the given index. In case of any wrong argument returns zero-index position (position for index=0 with totalNumber=1). |
| `double` | `getRadius()` | Returns the radius of this point node |
| `Position` | `getTransferPositionByPercent(Path path1, Path path2, double percent, Position out)` | |
| `double` | `getX()` | Returns the x coordinate |
| `Point` | `getXYZ()` | Returns (x, y, z) coordinates of this node |
| `Point` | `getXYZ(Point out)` | Returns (x, y, z) coordinates of this node |
| `double` | `getY()` | Returns the y coordinate |
| `double` | `getZ()` | Returns the z coordinate of the node. |
| `Point` | `randomPointInside(Random rng, Point out)` | Returns the randomly chosen point inside/along the given space markup element. |
| `void` | `setLineColor(Color lineColor)` | The same as Node.setFillColor(Color) |
| `void` | `setLineColor(Paint lineColor)` | The same as Node.setFillColor(Paint) |
| `void` | `setPos(double x, double y)` | Sets coordinates of the point node |
| `void` | `setPos(double x, double y, double z)` | Sets coordinates of the point node |
| `void` | `setRadius(double radius)` | Sets the radius of this point node. |

## Methods inherited from class com.anylogic.engine.markup.Node
`addConnection`, `getCompatibleAgentExtensionClass`, `getConnection`, `getConnectionsCount`, `getFillColor`, `getFillTexture`, `getMaterialLibraryDescriptor`, `getMaxSpeed`, `getNumberOfTransporters`, `getTransferDistance`, `getTransporter`, `getTransporters`, `isLimitSpeed`, `setFillColor`, `setFillColor`, `setLimitSpeed`, `setMaxSpeed`

## Methods inherited from class com.anylogic.engine.markup.NetworkMarkupElement
`getDrawMode`, `getLevel`, `getNearestPoint`, `getNearestPoint`, `getNearestPoint`, `getNetwork`, `setLevel`

## Methods inherited from class com.anylogic.engine.markup.MarkupShape
`error`, `getFullName`, `getOutsideLevelZ`, `getPresentable`, `getSpace`, `initialize`, `isClickHandled`, `isPublic`, `onClick`, `remove`, `setDrawMode`, `setOwner`

## Methods inherited from class com.anylogic.engine.markup.AbstractMarkup
`discardOwner`, `executeUserAction`, `findSVGElement`, `getName`, `getOrGenerateUSDId`, `getSVGId`, `initializeInternal`, `isVisible`, `onAggregatorInitialized`, `onAggregatorVisibilityChanged`, `removeSVGFromOwner`, `resetSVGState`, `setVisible`, `updateDynamicProperties`, `updateDynamicPropertiesStructural`, `updateSVGProperties`

## Methods inherited from class java.lang.Object
`equals`, `getClass`, `hashCode`, `notify`, `notifyAll`, `toString`, `wait`, `wait`, `wait`

## Methods inherited from interface com.anylogic.engine.markup.AbstractPositionalMarkup
`getRotation`, `getSpace`, `isVisible`

## Methods inherited from interface com.anylogic.engine.markup.AggregatableAnimationElement
`initializeInternal`, `onAggregatorVisibilityChanged`, `postInitialize`

## Methods inherited from interface com.anylogic.engine.markup.AnimationStaticLocationProvider
`getSpace`

## Methods inherited from interface com.anylogic.engine.markup.HasLevel
`getLevel`

## Methods inherited from interface com.anylogic.engine.markup.material_handling.IMaterialMarkupLibraryDescriptor
`getMarkup`, `setMarkup`

## Methods inherited from interface com.anylogic.engine.markup.INetworkMarkupElement
`getNearestPoint`, `getNetwork`, `getSpace`, `randomPointInside`, `randomPointInside`, `randomPointInside`

## Methods inherited from interface com.anylogic.engine.markup.INode
`getName`

## Methods inherited from interface com.anylogic.engine.markup.LevelElement
`setLevel`

## Methods inherited from interface com.anylogic.engine.presentation.SVGElement
`executeUserAction`, `findSVGElement`, `getSVGId`, `removeSVGFromOwner`, `resetSVGState`, `updateSVGProperties`

## Methods inherited from interface com.anylogic.engine.presentation.UsdElement
`getOrGenerateUSDId`

## Constructor Details

### PointNode
```java
public PointNode()
```

### PointNode
```java
public PointNode(Agent owner)
```

### PointNode
```java
public PointNode(Agent owner,
                 double x,
                 double y,
                 double z)
```

### PointNode
```java
@Deprecated
public PointNode(Agent owner,
                 ShapeDrawMode drawMode,
                 boolean isPublic,
                 double x,
                 double y,
                 double z)
```
Deprecated. Deprecated in version 8.4, will be removed in the future releases

**Parameters:**  
`owner` -  
`drawMode` -  
`isPublic` -  
`x` -  
`y` -  
`z` -  

### PointNode
```java
@Deprecated
public PointNode(Agent owner,
                 ShapeDrawMode drawMode,
                 boolean isPublic,
                 double x,
                 double y,
                 double z,
                 double radius,
                 Paint fillColor)
```
Deprecated. Deprecated in version 8.4, will be removed in the future releases

**Parameters:**  
`owner` -  
`drawMode` -  
`isPublic` -  
`x` -  
`y` -  
`z` -  
`radius` -  
`fillColor` -  

### PointNode
```java
@SafeVarargs
@Deprecated
public PointNode(Agent owner,
                 ShapeDrawMode drawMode,
                 boolean isPublic,
                 double x,
                 double y,
                 double z,
                 PathEnd<Path>[] pathEnds,
                 PathConnector<Path,Node>... connectors)
```
Deprecated. Deprecated in version 8.4, will be removed in the future releases

**Parameters:**  
`owner` -  
`drawMode` -  
`isPublic` -  
`x` -  
`y` -  
`z` -  
`pathEnds` -  
`connectors` -  

### PointNode
```java
@SafeVarargs
@Deprecated
public PointNode(Agent owner,
                 ShapeDrawMode drawMode,
                 boolean isPublic,
                 double x,
                 double y,
                 double z,
                 double radius,
                 Paint fillColor,
                 PathEnd<Path>[] pathEnds,
                 PathConnector<Path,Node>... connectors)
```
Deprecated. Deprecated in version 8.4, will be removed in the future releases

**Parameters:**  
`owner` -  
`drawMode` -  
`isPublic` -  
`x` -  
`y` -  
`z` -  
`radius` -  
`fillColor` -  
`pathEnds` -  
`connectors` -  

### PointNode
```java
@AnyLogicInternalCodegenAPI
public PointNode(Agent owner,
                 ShapeDrawMode drawMode,
                 boolean isPublic,
                 double x,
                 double y,
                 double z,
                 double radius,
                 Paint fillColor,
                 boolean limitSpeed,
                 double maxSpeedInMPS,
                 PathEnd<Path>[] pathends)
```
This method is internal and shouldn't be called by user. It may be removed/renamed in future. It is public due to technical reasons.

### PointNode
```java
@SafeVarargs
@Deprecated
public PointNode(Agent owner,
                 ShapeDrawMode drawMode,
                 boolean isPublic,
                 double x,
                 double y,
                 double z,
                 double radius,
                 Paint fillColor,
                 boolean limitSpeed,
                 double maxSpeedInMPS,
                 PathEnd<Path>[] pathends,
                 PathConnector<Path,Node>... connectors)
```
Deprecated. Deprecated in version 8.4, will be removed in the future releases

**Parameters:**  
`owner` -  
`drawMode` -  
`isPublic` -  
`x` -  
`y` -  
`z` -  
`radius` -  
`fillColor` -  
`limitSpeed` -  
`maxSpeedInMPS` -  
`pathends` -  
`connectors` -  

## Method Details

### getConnectors
```java
@AnyLogicInternalAPI
public List<PathConnector<Path,Node>> getConnectors()
```

### addConnector
```java
public void addConnector(PathConnector<Path,Node> connector)
```
Adds internal path connector to the inside of this node.

**Parameters:**  
`connector` - path connector

### getRadius
```java
public double getRadius()
```
Returns the radius of this point node

### setRadius
```java
public void setRadius(double radius)
```
Sets the radius of this point node. The element should be uninitialized

**Parameters:**  
`radius` - new radius

### getConnector
```java
public PathConnector<Path,Node> getConnector(Path path1,
                                           Path path2)
```
Return a connection between two paths inside the node. If the connection is bidirectional, you need to check the movement direction. It could be done by comparing your path1 with PathConnector.getStartPath(), in case of equality the movement is straight and reverse otherwise.

**Parameters:**  
`path1` - a path connected to the node by its end point, or optionally with its start point if is bidirectional  
`path2` - a path connected to the node by its start point, or optionally with its end point if is bidirectional

**Returns:**  
a connector between two paths

### getConnectedExternalPaths
```java
@AnyLogicInternalAPI
public Collection<Path> getConnectedExternalPaths(Path path)
```

### getConnectedInternalPaths
```java
@AnyLogicInternalAPI
public Collection<Path> getConnectedInternalPaths(Path path)
```

### randomPointInside
```java
public Point randomPointInside(Random rng,
                              Point out)
```
Description copied from interface: INetworkMarkupElement  
Returns the randomly chosen point inside/along the given space markup element. This method utilises the given Random Number Generator.

**Specified by:**  
`randomPointInside` in interface `INetworkMarkupElement`

**Parameters:**  
`rng` - the random number generator.  
`out` - output object to write to, may be null

**Returns:**  
the randomly chosen point

### getX
```java
public double getX()
```
Returns the x coordinate

**Specified by:**  
`getX` in interface `AbstractPositionalMarkup`

**Returns:**  
the x coordinate

### getY
```java
public double getY()
```
Returns the y coordinate

**Specified by:**  
`getY` in interface `AbstractPositionalMarkup`

**Returns:**  
the y coordinate

### getZ
```java
public double getZ()
```
Description copied from class: Node  
Returns the z coordinate of the node.

**Specified by:**  
`getZ` in interface `AbstractPositionalMarkup`

**Specified by:**  
`getZ` in class `Node`

**Returns:**  
the z coordinate of the node

### setPos
```java
public void setPos(double x,
                  double y)
```
Sets coordinates of the point node

**Parameters:**  
`x` - the value of x coordinate  
`y` - the value of y coordinate

### setPos
```java
public void setPos(double x,
                  double y,
                  double z)
```
Sets coordinates of the point node

**Parameters:**  
`x` - the value of x coordinate  
`y` - the value of y coordinate  
`z` - the value of z coordinate

### getXYZ
```java
public Point getXYZ()
```
Returns (x, y, z) coordinates of this node

**Returns:**  
the Point object with (x, y, z) coordinates of this node

### getXYZ
```java
public Point getXYZ(Point out)
```
Returns (x, y, z) coordinates of this node

**Returns:**  
the Point object with (x, y, z) coordinates of this node

### setLineColor
```java
public void setLineColor(Color lineColor)
```
The same as Node.setFillColor(Color)

**Specified by:**  
`setLineColor` in class `Node`

**Parameters:**  
`lineColor` - the new line color, null = do not draw the markup element line

### setLineColor
```java
public void setLineColor(Paint lineColor)
```
The same as Node.setFillColor(Paint)

**Specified by:**  
`setLineColor` in interface `INode<Node,Path>`

**Specified by:**  
`setLineColor` in class `Node`

**Parameters:**  
`lineColor` - the new line color, null = do not draw the markup element line

### getLineColor
```java
public Color getLineColor()
```
The same as Node.getFillColor()

**Specified by:**  
`getLineColor` in interface `INode<Node,Path>`

**Specified by:**  
`getLineColor` in class `Node`

**Returns:**  
the line color of the markup element

### getLineTexture
```java
public Texture getLineTexture()
```
The same as Node.getFillTexture()

**Specified by:**  
`getLineTexture` in interface `INode<Node,Path>`

**Specified by:**  
`getLineTexture` in class `Node`

**Returns:**  
the line texture of the markup element

### getNearestPoint
```java
public double getNearestPoint(double x,
                             double y,
                             Point output)
```
Description copied from class: NetworkMarkupElement  
Calculates (using the output object) the point in this space markup element nearest to the given (x, y) point. Returns the square of distance to the point (in the XY-projection). All the calculations are performed in the horizontal projection (z-coordinates aren't used, as if all of the z coordinates were zero).

**Specified by:**  
`getNearestPoint` in class `NetworkMarkupElement`

**Parameters:**  
`x` - x coordinate of the point  
`y` - y coordinate of the point  
`output` - the output point to write result to. Note that output.z is left unchanged.

**Returns:**  
the square of distance to the nearest point in the horizontal (XY) projection

### getNearestPoint
```java
public double getNearestPoint(double x,
                             double y,
                             double z,
                             Point output)
```
Description copied from class: NetworkMarkupElement  
Calculates (using the output object) the point in this space markup element nearest to the given (x, y, z) point. Returns the square of distance to the point.

**Specified by:**  
`getNearestPoint` in class `NetworkMarkupElement`

**Parameters:**  
`x` - x coordinate of the point  
`y` - y coordinate of the point  
`z` - z coordinate of the point  
`output` - the output point to write result to.

**Returns:**  
the square of distance to the nearest point

### contains
```java
public boolean contains(double px,
                       double py)
```
Description copied from class: MarkupShape  
Test if the shape contains the point with the given coordinates (relative to this shape's container, i.e. in the same system with the coordinates of this shape, x and y)

**Specified by:**  
`contains` in interface `INetworkMarkupElement`

**Specified by:**  
`contains` in class `MarkupShape`

**Parameters:**  
`px` - the x coordinate relative to this shape's container  
`py` - the y coordinate relative to this shape's container

**Returns:**  
true if the shape contains the point with the given coordinates

### getPosition
```java
public Position getPosition(int index,
                           int totalNumber,
                           Position out)
```
Description copied from interface: AnimationStaticLocationProvider  
Returns the item position with the given index.
In case of any wrong argument returns zero-index position (position for index=0 with totalNumber=1).

**Specified by:**  
`getPosition` in interface `AnimationStaticLocationProvider`

**Parameters:**  
`index` - the index of some item positions, should be not negative and less than totalNumber  
`totalNumber` - the total number of item positions, should be positive  
`out` - output object to write to, may be null

**Returns:**  
the Position object with coordinates of the requested item position

### getTransferPositionByPercent
```java
public Position getTransferPositionByPercent(Path path1,
                                            Path path2,
                                            double percent,
                                            Position out)
```
**Specified by:**  
`getTransferPositionByPercent` in interface `INode<Node,Path>`

**Overrides:**  
`getTransferPositionByPercent` in class `Node`

### getBoundingRectangle
```java
@AnyLogicInternalAPI
public BoundingRectangle getBoundingRectangle()
