# IPath

## Package
`com.anylogic.engine.markup`

## Interface
`IPath<N extends INode>`

## Type Parameters
- `N` - network node based on com.anylogic.engine.markup.INode interface

## All Superinterfaces
`AnimationMovingLocationProvider`, `AnimationStaticLocationProvider`, `INetworkMarkupElement`, `Serializable`

## All Known Implementing Classes
`ConveyorPath`, `GISRoute`, `Path`

## Description
This is the basic interface for implementation connection between nodes inside network.

## Author
AnyLogic North America, LLC https://anylogic.com

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `Point` | `getEndPoint()` | Returns the location of the end point |
| `Point` | `getEndPoint(Point out)` | Returns the location of the end point |
| `Position` | `getEndPosition(Position out)` | Returns the end position |
| `Color` | `getLineColor()` | Returns the line color of the markup element, or null if markup element has no line color or has textured line (in this case getLineTexture() should be used instead) |
| `Texture` | `getLineTexture()` | Returns the line texture of the markup element, if the markup element has line texture |
| `double` | `getLineWidth()` | Returns the line width of the markup element. |
| `String` | `getName()` | If the markup shape is declared as field in an agent class, e.g. |
| `N` | `getOtherNode(N n)` | If the given node is source of this path, returns path's target, otherwise returns source. |
| `default INode<?,?>` | `getPathEnd(PathEndType type)` | |
| `Position` | `getPositionAtOffset(double offset, LengthUnits units, Position out)` | Returns the point (+rotations) located on the markup element with the given offset distance calculated from start point. |
| `Position` | `getPositionAtOffset(double offset, Position out)` | Returns the point (+rotations) located on the markup element with the given offset distance calculated from start point. |
| `IMarkupSegment` | `getSegment(int index)` | Returns the segment by its index |
| `int` | `getSegmentCount()` | Returns the number of segments |
| `N` | `getSource()` | Returns source node of this path. |
| `Point` | `getStartPoint()` | Returns the location of the start point |
| `Point` | `getStartPoint(Point out)` | Returns the location of the start point |
| `Position` | `getStartPosition(Position out)` | Returns the start position |
| `N` | `getTarget()` | Returns target node of this path. |
| `boolean` | `isBidirectional()` | Returns the 'bidirectional' property (true by default). |
| `Iterator<? extends IMarkupSegment>` | `iterator()` | Returns iterator over segments of the path |
| `void` | `setBidirectional(boolean bidirectional)` | Sets the 'bidirectional' property (true by default). |
| `void` | `setLineColor(Paint lineColor)` | Sets the line color (or Texture) of the markup element. |
| `void` | `setLineWidth(double width)` | Sets the line width of the markup element, 0 means thinnest possible |
| `void` | `setSource(N node)` | Sets source node of this path. |
| `void` | `setTarget(N node)` | Sets source node of this path. |

## Methods inherited from interface com.anylogic.engine.markup.AnimationMovingLocationProvider
`getPosition`, `length`, `length`

## Methods inherited from interface com.anylogic.engine.markup.AnimationStaticLocationProvider
`getPosition`, `getSpace`

## Methods inherited from interface com.anylogic.engine.markup.INetworkMarkupElement
`contains`, `getNearestPoint`, `getNetwork`, `getSpace`, `randomPointInside`, `randomPointInside`, `randomPointInside`, `randomPointInside`

## Method Details

### getPathEnd
```java
default INode<?,?> getPathEnd(PathEndType type)
```

### getSource
```java
N getSource()
```
Returns source node of this path.

**Returns:**  
instance of com.anylogic.engine.markup.INode interface

### setSource
```java
void setSource(N node)
```
Sets source node of this path. This method should be called before initialize() method.

**Parameters:**  
`node` - instance of com.anylogic.engine.markup.INode interface

### getTarget
```java
N getTarget()
```
Returns target node of this path.

**Returns:**  
instance of com.anylogic.engine.markup.INode interface

### setTarget
```java
void setTarget(N node)
```
Sets source node of this path. This method should be called before initialize() method.

**Parameters:**  
`node` - instance of com.anylogic.engine.markup.INode interface

### getStartPoint
```java
Point getStartPoint()
```
Returns the location of the start point

**Returns:**  
the Point object with coordinates of the first point

### getStartPoint
```java
Point getStartPoint(Point out)
```
Returns the location of the start point

**Parameters:**  
`out` - output object to write to, may be null

**Returns:**  
the Point object with coordinates of the first point

### getEndPoint
```java
Point getEndPoint()
```
Returns the location of the end point

**Returns:**  
the Point object with coordinates of the last point

### getEndPoint
```java
Point getEndPoint(Point out)
```
Returns the location of the end point

**Parameters:**  
`out` - output object to write to, may be null

**Returns:**  
the Point object with coordinates of the last point

### isBidirectional
```java
boolean isBidirectional()
```
Returns the 'bidirectional' property (true by default).

**Returns:**  
true for paths which allow movements in both directions, false for paths which allow movements from source to target only

### setBidirectional
```java
void setBidirectional(boolean bidirectional)
```
Sets the 'bidirectional' property (true by default).

**Parameters:**  
`bidirectional` - true for paths which allow movements in both directions, false for paths which allow movements from source to target only

**See Also:**  
`isBidirectional()`

### getSegmentCount
```java
int getSegmentCount()
```
Returns the number of segments

**Returns:**  
the number of segments

### getSegment
```java
IMarkupSegment getSegment(int index)
```
Returns the segment by its index

**Parameters:**  
`index` - the segment index, [0 .. getSegmentCount() - 1]

**Returns:**  
the segment

### iterator
```java
Iterator<? extends IMarkupSegment> iterator()
```
Returns iterator over segments of the path

### getOtherNode
```java
N getOtherNode(N n)
```
If the given node is source of this path, returns path's target, otherwise returns source. Note that this function doesn't check that the given is either source or target: this is the responsibility of user calling this function. The ordinal use case is calling this method for some path connected to some node.

**Parameters:**  
`n` - the node (one of the path endings)

**Returns:**  
the node of the other end of this path

### getName
```java
String getName()
```
If the markup shape is declared as field in an agent class, e.g. if it was drawn in the graphical editor, returns the name of the field, otherwise returns the string #UNKNOWN_NAME. For replicated shapes returns the name of the field with the index of the shape in square brackets.

This method is designed to be used for debug/development purposes only. It has a very inefficient implementation

**Returns:**  
the name of the corresponding field or #UNKNOWN_NAME

### getPositionAtOffset
```java
Position getPositionAtOffset(double offset,
                            Position out)
```
Returns the point (+rotations) located on the markup element with the given offset distance calculated from start point.

**Parameters:**  
`offset` - offset, non-negative value, should be less or equal to the full length.  
`out` - output object to write to, may be null

**Returns:**  
the Position object with coordinates of the point with the given offset and orientation along markup element line at this point

### getPositionAtOffset
```java
Position getPositionAtOffset(double offset,
                            LengthUnits units,
                            Position out)
```
Returns the point (+rotations) located on the markup element with the given offset distance calculated from start point.

**Parameters:**  
`offset` - offset, non-negative value, should be less or equal to the full length.  
`units` - the length units  
`out` - output object to write to, may be null

**Returns:**  
the Position object with coordinates of the point with the given offset and orientation along markup element line at this point

**Since:**  
7.1

### getStartPosition
```java
Position getStartPosition(Position out)
```
Returns the start position

**Parameters:**  
`out` - output object to write to, may be null

**Returns:**  
the Position object with coordinates of the first position

### getEndPosition
```java
Position getEndPosition(Position out)
```
Returns the end position

**Parameters:**  
`out` - output object to write to, may be null

**Returns:**  
the Position object with coordinates of the last position

### getLineColor
```java
Color getLineColor()
```
Returns the line color of the markup element, or null if markup element has no line color or has textured line (in this case getLineTexture() should be used instead)

**Returns:**  
the line color of the markup element

### setLineColor
```java
void setLineColor(Paint lineColor)
```
Sets the line color (or Texture) of the markup element.

**Parameters:**  
`lineColor` - the new line color, null = do not draw the markup element line

### getLineTexture
```java
Texture getLineTexture()
```
Returns the line texture of the markup element, if the markup element has line texture

**Returns:**  
the line texture of the markup element

### getLineWidth
```java
double getLineWidth()
```
Returns the line width of the markup element.

**Returns:**  
the line width of the markup element

### setLineWidth
```java
void setLineWidth(double width)
```
Sets the line width of the markup element, 0 means thinnest possible

**Parameters:**  
`width` - the new line width of the markup element
