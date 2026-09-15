# Class Path

## Inheritance Hierarchy
```
java.lang.Object
  com.anylogic.engine.markup.AbstractMarkup
    com.anylogic.engine.markup.MarkupShape
      com.anylogic.engine.markup.NetworkMarkupElement
        com.anylogic.engine.markup.Path
```

## All Implemented Interfaces
`AggregatableAnimationElement`, `AnimationMovingLocationProvider`, `AnimationStaticLocationProvider`, `HasLevel`, `IMarkupLibraryDescriptor`, `INetworkMarkupElement`, `IPath<Node>`, `com.anylogic.engine.markup.material_handling.IMaterialMarkupLibraryDescriptor`, `com.anylogic.engine.markup.material_handling.IPathDescriptor<Agent>`, `SVGElement`, `UsdElement`, `Serializable`, `Iterable<MarkupSegment>`

## Class Declaration
```java
public class Path
extends NetworkMarkupElement
implements IPath<Node>, Iterable<MarkupSegment>, com.anylogic.engine.markup.material_handling.IPathDescriptor<Agent>
```

## Description
Implementation of IPath for network in continuous space.

**Author:** AnyLogic North America, LLC https://anylogic.com

**See Also:** [Serialized Form](#)
## Field Summary

### Fields inherited from interface com.anylogic.engine.presentation.UsdElement
`ID_NOT_SET`

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `Path()` | Default constructor |
| `Path(Agent owner)` | Constructor with owner |
| `Path(Agent owner, ShapeDrawMode drawMode, boolean isPublic, boolean bidirectional, boolean isLimitSpeed, double maxSpeedInMPS, boolean limitNumberOfTransporters, int maxNumberOfTransporters, PathDrawingType drawingType, Paint color, double lineWidth, MarkupSegment... segments)` | **Deprecated.** Deprecated in version 8.4, will be removed in the future releases |
| `Path(Agent owner, ShapeDrawMode drawMode, boolean isPublic, boolean bidirectional, boolean isLimitSpeed, double maxSpeedInMPS, boolean limitNumberOfTransporters, int maxNumberOfTransporters, PathDrawingType drawingType, Paint color, double lineWidth, Node source, Node target, MarkupSegment... segments)` | **Deprecated.** Deprecated in version 8.4, will be removed in the future releases |
| `Path(Agent owner, ShapeDrawMode drawMode, boolean isPublic, boolean bidirectional, PathDrawingType drawingType, Paint color, double lineWidth, MarkupSegment... segments)` | **Deprecated.** Deprecated in version 8.4, will be removed in the future releases |
## Method Summary

| Modifier and Type | Method | Description |
|------------------|--------|-------------|
| `void` | `addSegment(MarkupSegment segment)` | Adds segment to this markup element |
| `void` | `arcTo(double x, double y, double z, double startAngle, double endAngle, double ratioStartToEnd)` | Adds arc segment with two circular arcs (available for markup elements created with no-argument constructor) |
| `boolean` | `contains(double px, double py)` | Test if the shape contains the point with the given coordinates |
| `boolean` | `contains(double px, double py, double distance)` | Test if the shape contains the point with the given coordinates using the given tolerance |
| `boolean` | `containsSq(double px, double py, double squareDistance)` | Test if the shape contains the point with the given coordinates using the given tolerance |
| `NetworkPort` | `createPort(PathEndType endType)` | Creates and returns a Network Port located on specified path's end |
| `NetworkPort` | `createPort(PathEndType endType, NetworkPort pairedPort)` | Creates and returns a Network Port located on specified path's end and pairs created port with specified one |
| `BoundingRectangle` | `getBoundingRectangle()` | Gets the bounding rectangle for this path |
| `PathDrawingType` | `getDrawingType()` | Returns the drawing type of this path |
| `Point` | `getEndPoint()` | Returns the location of the end point |
| `Point` | `getEndPoint(Point out)` | Returns the location of the end point |
| `Position` | `getEndPosition()` | Returns the end position |
| `Position` | `getEndPosition(Position out)` | Returns the end position |
| `Color` | `getLineColor()` | Returns the color of the path, or null if path has no color or has texture |
| `Texture` | `getLineTexture()` | Returns the texture of the path, if the path has it |
| `double` | `getLineWidth()` | Returns the width of the path |
| `double` | `getLineWidth(LengthUnits units)` | Returns line width in specified units |
| `int` | `getMaxNumberOfTransporters()` | Returns the maximum allowed number of transporters on this path |
| `double` | `getMaxSpeed(SpeedUnits units)` | Returns max allowed speed on this path in specified speed units |
| `double` | `getNearestPoint(double x, double y, double z, Point out)` | Calculates the point in this space markup element nearest to the given (x, y, z) point |
| `double` | `getNearestPoint(double x, double y, Point out)` | Calculates the point in this space markup element nearest to the given (x, y) point |
| `double` | `getNearestPointOnRay(double x1, double y1, double x2, double y2, LengthUnits units, Point out)` | Calculates the intersection point between this element and the given ray |
| `double` | `getNearestPointOnRay(double x1, double y1, double x2, double y2, Point out)` | Calculates the intersection point between this element and the given ray |
| `int` | `getNumberOfTransporters()` | Returns the number of transporters currently located on this path |
| `Node` | `getOtherNode(Node n)` | If the given node is source of this path, returns path's target, otherwise returns source |
| `Point` | `getPointAtOffset(double offset, LengthUnits units, Point out)` | Returns the point located on the markup element with the given offset distance |
| `Point` | `getPointAtOffset(double offset, Point out)` | Returns the point located on the markup element with the given offset distance |
| `Position` | `getPosition(double value, double maxValue, Position out)` | Returns position with offset corresponding to the given value |
| `Position` | `getPosition(int index, int totalNumber, Position out)` | Returns the item position with the given index |
| `Position` | `getPositionAtOffset(double offset, LengthUnits units, Position out)` | Returns the point (+rotations) located on the markup element with the given offset distance |
| `Position` | `getPositionAtOffset(double offset, Position out)` | Returns the point (+rotations) located on the markup element with the given offset distance |
| `MarkupSegment` | `getSegment(int index)` | Returns the segment by its index |
| `int` | `getSegmentCount()` | Returns the number of segments |
| `Node` | `getSource()` | Returns source node of this path |
| `Point` | `getStartPoint()` | Returns the location of the start point |
| `Point` | `getStartPoint(Point out)` | Returns the location of the start point |
| `Position` | `getStartPosition()` | Returns the start position |
| `Position` | `getStartPosition(Position out)` | Returns the start position |
| `Node` | `getTarget()` | Returns target node of this path |
| `Agent` | `getTransporter(int index)` | Returns the transporter with the specified index |
| `List<Agent>` | `getTransporters()` | Returns the list of all transporters currently located on this path |
| `boolean` | `isBidirectional()` | Returns the 'bidirectional' property (true by default) |
| `boolean` | `isLimitNumberOfTransporters()` | Returns true if the number of transporters is limited on this path |
| `boolean` | `isLimitSpeed()` | Returns true if speed is limited on this path |
| `Iterator<MarkupSegment>` | `iterator()` | Creates and returns read-only iterator over segments |
| `double` | `length()` | Returns the length of the markup element, calculated in 3D space |
| `double` | `length(LengthUnits units)` | Returns the length of the markup element, calculated in 3D space |
| `void` | `lineTo(double x, double y, double z)` | Adds line segment (available for markup elements created with no-argument constructor) |
| `Point` | `randomPointInside(Random rng, Point out)` | Returns the randomly chosen point inside/along the given space markup element |
| `Position` | `randomPositionInside(Random rng, Position out)` | Returns the randomly chosen position along the path |
| `void` | `setBidirectional(boolean bidirectional)` | Sets the 'bidirectional' property (true by default) |
| `void` | `setDrawingType(PathDrawingType drawingType)` | Sets the drawing type of this path |
| `void` | `setLimitNumberOfTransporters(boolean limitNumberOfTransporters)` | Enables limiting the number of transporters on this path |
| `void` | `setLimitSpeed(boolean limitSpeed)` | Enables speed limit on this path |
| `void` | `setLineColor(Color color)` | Sets the color of the path |
| `void` | `setLineColor(Paint color)` | Sets the color (or Texture) of the path |
| `void` | `setLineWidth(double widthInPixels)` | Sets the width of the path, 0 means thinnest possible |
| `void` | `setLineWidth(double lineWidth, LengthUnits units)` | Sets line width in specified units |
| `void` | `setMaxNumberOfTransporters(int maxNumberOfTransporters)` | Sets the maximum allowed number of transporters on this path |
| `void` | `setMaxSpeed(double maxSpeed, SpeedUnits units)` | Sets the maximum allowed speed in specified units |
| `void` | `setSource(Node node)` | Sets source node of this path |
| `void` | `setTarget(Node node)` | Sets target node of this path |
| `void` | `startDrawing(double x, double y, double z)` | Starts drawing (available for markup elements created with no-argument constructor) |
| `Path3D` | `toPath3D()` | Converts this markup element to Path3D interface |
## Methods inherited from class com.anylogic.engine.markup.NetworkMarkupElement
`getDrawMode`, `getLevel`, `getNearestPoint`, `getNearestPoint`, `getNearestPoint`, `getNetwork`, `setLevel`

## Methods inherited from class com.anylogic.engine.markup.MarkupShape
`error`, `getFullName`, `getOutsideLevelZ`, `getPresentable`, `getSpace`, `initialize`, `isClickHandled`, `isOnly3D`, `isPublic`, `onClick`, `remove`, `setDrawMode`, `setOwner`

## Methods inherited from class com.anylogic.engine.markup.AbstractMarkup
`discardOwner`, `executeUserAction`, `findSVGElement`, `getGroupOrOwner`, `getName`, `getOrGenerateUSDId`, `getSVGComponent`, `getSVGId`, `initializeInternal`, `isVisible`, `onAggregatorInitialized`, `onAggregatorVisibilityChanged`, `removeSVGFromOwner`, `resetSVGState`, `setVisible`, `updateDynamicProperties`, `updateDynamicPropertiesStructural`, `updateSVGProperties`

## Methods inherited from class java.lang.Object
`equals`, `getClass`, `hashCode`, `notify`, `notifyAll`, `toString`, `wait`, `wait`, `wait`

## Methods inherited from interface com.anylogic.engine.markup.AggregatableAnimationElement
`postInitialize`

## Methods inherited from interface com.anylogic.engine.markup.AnimationStaticLocationProvider
`getSpace`

## Methods inherited from interface com.anylogic.engine.markup.material_handling.IMaterialMarkupLibraryDescriptor
`getMarkup`, `setMarkup`

## Methods inherited from interface com.anylogic.engine.markup.INetworkMarkupElement
`getNearestPoint`, `getNetwork`, `getSpace`, `randomPointInside`, `randomPointInside`, `randomPointInside`

## Methods inherited from interface com.anylogic.engine.markup.IPath
`getName`, `getPathEnd`

## Methods inherited from interface java.lang.Iterable
`forEach`, `spliterator`
Constructor Details
Path
public Path()
Path
public Path(Agent owner)
Path
@Deprecated
public Path(Agent owner,
 ShapeDrawMode drawMode,
 boolean isPublic,
 boolean bidirectional,
 PathDrawingType drawingType,
 Paint color,
 double lineWidth,
 MarkupSegment... segments)
Deprecated.
deprecated in version 8.4, will be removed in the future releases
Parameters:
owner -
drawMode -
isPublic -
bidirectional -
drawingType -
color -
lineWidth - line width,
for drawingType (PathDrawingType.PATH_LINE, PathDrawingType.PATH_DASHEDLINE) - measured in pixels,
for other drawing types - measured in meters
segments -
Path
@Deprecated
public Path(Agent owner,
 ShapeDrawMode drawMode,
 boolean isPublic,
 boolean bidirectional,
 boolean isLimitSpeed,
 double maxSpeedInMPS,
 boolean limitNumberOfTransporters,
 int maxNumberOfTransporters,
 PathDrawingType drawingType,
 Paint color,
 double lineWidth,
 MarkupSegment... segments)
Deprecated.
deprecated in version 8.4, will be removed in the future releases
Parameters:
owner -
drawMode -
isPublic -
bidirectional -
isLimitSpeed -
maxSpeedInMPS -
limitNumberOfTransporters -
maxNumberOfTransportersInMPS -
drawingType -
color -
lineWidth - line width,
for drawingType (PathDrawingType.PATH_LINE, PathDrawingType.PATH_DASHEDLINE) - measured in pixels,
for other drawing types - measured in meters
segments -
Path
@Deprecated
public Path(Agent owner,
 ShapeDrawMode drawMode,
 boolean isPublic,
 boolean bidirectional,
 boolean isLimitSpeed,
 double maxSpeedInMPS,
 boolean limitNumberOfTransporters,
 int maxNumberOfTransporters,
 PathDrawingType drawingType,
 Paint color,
 double lineWidth,
 Node source,
 Node target,
 MarkupSegment... segments)
Deprecated.
deprecated in version 8.4, will be removed in the future releases
Parameters:
owner -
drawMode -
isPublic -
bidirectional -
isLimitSpeed -
maxSpeedInMPS -
limitNumberOfTransporters -
maxNumberOfTransportersInMPS -
drawingType -
color -
lineWidth - line width,
for drawingType (PathDrawingType.PATH_LINE, PathDrawingType.PATH_DASHEDLINE) - measured in pixels,
for other drawing types - measured in meters
source -
target -
segments -
Method Details
getMaterialLibraryDescriptor
@AnyLogicInternalAPI
public com.anylogic.engine.markup.material_handling.IPathDescriptor<Agent> getMaterialLibraryDescriptor()
isLimitSpeed
public boolean isLimitSpeed()
Returns true if speed is limited on this path, false otherwise
setLimitSpeed
public void setLimitSpeed(boolean limitSpeed)
Enables speed limit on this path if the argument is true, disables it if the argument is false The element should be uninitialized
Parameters:
limitSpeed - argument flag
getMaxSpeed
public double getMaxSpeed(SpeedUnits units)
Returns max allowed speed on this path in specified speed units
Parameters:
units - speed units
Returns:
max speed
setMaxSpeed
public void setMaxSpeed(double maxSpeed,
 SpeedUnits units)
Sets the maximum allowed speed in specified units
Parameters:
maxSpeed - new max speed
units - speed units
isLimitNumberOfTransporters
public boolean isLimitNumberOfTransporters()
Returns true if the number of transporters is limited on this path, false otherwise
setLimitNumberOfTransporters
public void setLimitNumberOfTransporters(boolean limitNumberOfTransporters)
Enables limiting the number of transporters on this path if the argument is true, disables it otherwise
Parameters:
limitNumberOfTransporters - argument flag
getMaxNumberOfTransporters
public int getMaxNumberOfTransporters()
Returns the maximum allowed number of transporters on this path
setMaxNumberOfTransporters
public void setMaxNumberOfTransporters(int maxNumberOfTransporters)
Sets the maximum allowed number of transporters on this path
Parameters:
maxNumberOfTransporters - new value
getNumberOfTransporters
public int getNumberOfTransporters()
Returns the number of transporters currently located on this path
Specified by:
getNumberOfTransporters in interface com.anylogic.engine.markup.material_handling.IPathDescriptor<Agent>
getTransporter
public Agent getTransporter(int index)
Returns the transporter with the specified index
Specified by:
getTransporter in interface com.anylogic.engine.markup.material_handling.IPathDescriptor<Agent>
getTransporters
public List<Agent> getTransporters()
Returns the list of all transporters currently located on this path
Specified by:
getTransporters in interface com.anylogic.engine.markup.material_handling.IPathDescriptor<Agent>
setBidirectional
public void setBidirectional(boolean bidirectional)
Description copied from interface: IPath
Sets the 'bidirectional' property (true by default).
Specified by:
setBidirectional in interface IPath<Node>
Parameters:
bidirectional - true for paths which allow movements in both directions, false for paths which allow movements from source to target only
See Also:
IPath.isBidirectional()
isBidirectional
public boolean isBidirectional()
Description copied from interface: IPath
Returns the 'bidirectional' property (true by default).
Specified by:
isBidirectional in interface IPath<Node>
Returns:
true for paths which allow movements in both directions, false for paths which allow movements from source to target only
createPort
public NetworkPort createPort(PathEndType endType)
Creates and returns a Network Port located on specified path's end
Parameters:
endType - determines the port's location
Returns:
new network port
createPort
public NetworkPort createPort(PathEndType endType,
 NetworkPort pairedPort)
Creates and returns a Network Port located on specified path's end and pairs created port with specified one
Parameters:
endType - determines the port's location.
pairedPort - another port to be paired with the new one. May be a port, located on another path or a lift port. Should not be null
Returns:
new network port
createPortInternal
@AnyLogicInternalAPI
public NetworkPort createPortInternal(PathEndType endType)
setSource
public void setSource(Node node)
Description copied from interface: IPath
Sets source node of this path. This method should be called before initialize() method.
Specified by:
setSource in interface IPath<Node>
Parameters:
node - instance of com.anylogic.engine.markup.INode interface
getSource
public Node getSource()
Description copied from interface: IPath
Returns source node of this path.
Specified by:
getSource in interface IPath<Node>
Returns:
instance of com.anylogic.engine.markup.INode interface
setTarget
public void setTarget(Node node)
Description copied from interface: IPath
Sets source node of this path. This method should be called before initialize() method.
Specified by:
setTarget in interface IPath<Node>
Parameters:
node - instance of com.anylogic.engine.markup.INode interface
getTarget
public Node getTarget()
Description copied from interface: IPath
Returns target node of this path.
Specified by:
getTarget in interface IPath<Node>
Returns:
instance of com.anylogic.engine.markup.INode interface
getOtherNode
public Node getOtherNode(Node n)
If the given node is source of this path, returns path's target, otherwise returns source. Note that this function doesn't check that the given is either source or target: this is the responsibility of user calling this function. The ordinal use case is calling this method for some path connected to some node.
Specified by:
getOtherNode in interface IPath<Node>
Parameters:
n - the node (one of the path endings)
Returns:
the node of the other end of this path
getDrawingType
public PathDrawingType getDrawingType()
Returns the drawing type of this path
Returns:
the drawing type of this path
setDrawingType
public void setDrawingType(PathDrawingType drawingType)
Sets the drawing type of this path
Parameters:
drawingType - the drawing type of this path
setLineColor
public void setLineColor(Color color)
Sets the color of the path.
Parameters:
color - the new color, null = do not draw the path
setLineColor
public void setLineColor(Paint color)
Sets the color (or Texture) of the path.
Specified by:
setLineColor in interface IPath<Node>
Parameters:
color - the new color, null = do not draw the path
getLineColor
public Color getLineColor()
Returns the color of the path, or null if path has no color or has texture (in this case getLineTexture() should be used instead)
Specified by:
getLineColor in interface IPath<Node>
Returns:
the color of the path
getLineTexture
public Texture getLineTexture()
Returns the texture of the path, if the path has it
Specified by:
getLineTexture in interface IPath<Node>
Returns:
the texture of the path
setLineWidth
public void setLineWidth(double widthInPixels)
Sets the width of the path, 0 means thinnest possible
Specified by:
setLineWidth in interface IPath<Node>
Parameters:
width - the new width of the path, measured in meters
setLineWidth
public void setLineWidth(double lineWidth,
 LengthUnits units)
Sets line width
Parameters:
laneWidth - line width, measured in the given units
units - length units
getLineWidth
public double getLineWidth()
Returns the width of the path.
Specified by:
getLineWidth in interface IPath<Node>
Returns:
the width of the path, measured in pixels
getLineWidth
public double getLineWidth(LengthUnits units)
Returns line width
Parameters:
units - length units
Returns:
line width, measured in the given units
contains
public boolean contains(double px,
 double py)
Description copied from class: MarkupShape
Test if the shape contains the point with the given coordinates (relative to this shape's container, i.e. in the same system with the coordinates of this shape, x and y)
Specified by:
contains in interface INetworkMarkupElement
Specified by:
contains in class MarkupShape
Parameters:
px - the x coordinate relative to this shape's container
py - the y coordinate relative to this shape's container
Returns:
true if the shape contains the point with the given coordinates
contains
public boolean contains(double px,
 double py,
 double distance)
Test if the shape contains the point with the given coordinates (relative to this shape's container, i.e. in the same system with the coordinates of this shape, x and y), using the given tolerance
Parameters:
px - the x coordinate relative to this shape's container
py - the y coordinate relative to this shape's container
distance - the distance tolerance to determine whether the given point lies on the markup element line or not
Returns:
true if the shape contains the point with the given coordinates
containsSq
public boolean containsSq(double px,
 double py,
 double squareDistance)
Test if the shape contains the point with the given coordinates (relative to this shape's container, i.e. in the same system with the coordinates of this shape, x and y), using the given tolerance
Parameters:
px - the x coordinate relative to this shape's container
py - the y coordinate relative to this shape's container
squareDistance - the square of distance tolerance to determine whether the given point lies on the markup element line or not
Returns:
true if the shape contains the point with the given coordinates
startDrawing
public void startDrawing(double x,
 double y,
 double z)
Starts drawing (available for markup elements created with no-argument constructor)
Parameters:
x - the x coordinate of the first point
y - the y coordinate of the first point
z - the z coordinate of the first point
lineTo
public void lineTo(double x,
 double y,
 double z)
Adds line segment (available for markup elements created with no-argument constructor)
Parameters:
x - the x coordinate of the segment end point
y - the y coordinate of the segment end point
z - the z coordinate of the segment end point
arcTo
public void arcTo(double x,
 double y,
 double z,
 double startAngle,
 double endAngle,
 double ratioStartToEnd)
Adds arc segment with two circular arcs (available for markup elements created with no-argument constructor)
Parameters:
x - the x coordinate of the segment end point
y - the y coordinate of the segment end point
z - the z coordinate of the segment end point
startAngle - orientation of segment line start
endAngle - orientation of segment line end
ratioStartToEnd - ratio between two circular arcs
addSegment
public void addSegment(MarkupSegment segment)
Adds segment to this markup element
Parameters:
segment - the segment, should be initialized if was created using no-argument constructor
getSegmentCount
public int getSegmentCount()
Description copied from interface: IPath
Returns the number of segments
Specified by:
getSegmentCount in interface IPath<Node>
Returns:
the number of segments
getSegment
public MarkupSegment getSegment(int index)
Description copied from interface: IPath
Returns the segment by its index
Specified by:
getSegment in interface IPath<Node>
Parameters:
index - the segment index, [0 .. IPath.getSegmentCount() - 1]
Returns:
the segment
iterator
public Iterator<MarkupSegment> iterator()
Creates and returns read-only iterator over segments
Specified by:
iterator in interface IPath<Node>
Specified by:
iterator in interface Iterable<MarkupSegment>
getStartPoint
public Point getStartPoint(Point out)
Description copied from interface: IPath
Returns the location of the start point
Specified by:
getStartPoint in interface IPath<Node>
Parameters:
out - output object to write to, may be null
Returns:
the Point object with coordinates of the first point
getStartPoint
public Point getStartPoint()
Description copied from interface: IPath
Returns the location of the start point
Specified by:
getStartPoint in interface IPath<Node>
Returns:
the Point object with coordinates of the first point
getEndPoint
public Point getEndPoint(Point out)
Description copied from interface: IPath
Returns the location of the end point
Specified by:
getEndPoint in interface IPath<Node>
Parameters:
out - output object to write to, may be null
Returns:
the Point object with coordinates of the last point
getEndPoint
public Point getEndPoint()
Description copied from interface: IPath
Returns the location of the end point
Specified by:
getEndPoint in interface IPath<Node>
Returns:
the Point object with coordinates of the last point
getStartPosition
public Position getStartPosition(Position out)
Description copied from interface: IPath
Returns the start position
Specified by:
getStartPosition in interface IPath<Node>
Parameters:
out - output object to write to, may be null
Returns:
the Position object with coordinates of the first position
getStartPosition
public Position getStartPosition()
Returns the start position
Returns:
the Position object with coordinates of the first position
getEndPosition
public Position getEndPosition(Position out)
Description copied from interface: IPath
Returns the end position
Specified by:
getEndPosition in interface IPath<Node>
Parameters:
out - output object to write to, may be null
Returns:
the Position object with coordinates of the last position
getEndPosition
public Position getEndPosition()
Returns the end position
Returns:
the Position object with coordinates of the last position
length
public final double length()
Returns the length of the markup element, calculated in 3D space.
Specified by:
length in interface AnimationMovingLocationProvider
Returns:
the length of the markup element (measured in pixels), a positive number
length
public final double length(LengthUnits units)
Returns the length of the markup element, calculated in 3D space.
Specified by:
length in interface AnimationMovingLocationProvider
Parameters:
units - the units of length
Returns:
the length of the markup element, a positive number
Since:
7.1
getPointAtOffset
public final Point getPointAtOffset(double offset,
 Point out)
Returns the point located on the markup element with the given offset distance calculated from start point.
This method may be slightly faster in some cases but returns no orientation information (rotations).
Parameters:
offset - offset, non-negative value, should be less or equal to the full length.
out - output object to write to, may be null
Returns:
the Point object with coordinates of the point with the given offset
See Also:
getPositionAtOffset(double, Position)
getPointAtOffset
public final Point getPointAtOffset(double offset,
 LengthUnits units,
 Point out)
Returns the point located on the markup element with the given offset distance calculated from start point.
This method may be slightly faster in some cases but returns no orientation information (rotations).
Parameters:
offset - offset, non-negative value, should be less or equal to the full length.
units - the length units
out - output object to write to, may be null
Returns:
the Point object with coordinates of the point with the given offset
See Also:
getPositionAtOffset(double, Position)
getPositionAtOffset
public final Position getPositionAtOffset(double offset,
 Position out)
Description copied from interface: IPath
Returns the point (+rotations) located on the markup element with the given offset distance calculated from start point.
Specified by:
getPositionAtOffset in interface IPath<Node>
Parameters:
offset - offset, non-negative value, should be less or equal to the full length.
out - output object to write to, may be null
Returns:
the Position object with coordinates of the point with the given offset and orientation along markup element line at this point
getPositionAtOffset
public final Position getPositionAtOffset(double offset,
 LengthUnits units,
 Position out)
Description copied from interface: IPath
Returns the point (+rotations) located on the markup element with the given offset distance calculated from start point.
Specified by:
getPositionAtOffset in interface IPath<Node>
Parameters:
offset - offset, non-negative value, should be less or equal to the full length.
units - the length units
out - output object to write to, may be null
Returns:
the Position object with coordinates of the point with the given offset and orientation along markup element line at this point
getNearestPoint
public double getNearestPoint(double x,
 double y,
 Point out)
Calculates (using the output object) the point in this space markup element nearest to the given (x, y) point. Returns the square of distance to the point (in the XY-projection). All the calculations are performed in the horizontal projection (z-coordinates aren't used, as if all of the z coordinates were zero).
Specified by:
getNearestPoint in class NetworkMarkupElement
Parameters:
x - x coordinate of the point
y - y coordinate of the point
output - the output point to write result to. Note that output.z is left unchanged.
Returns:
the square of distance to the nearest point in the horizontal (XY) projection
getNearestPoint
public double getNearestPoint(double x,
 double y,
 double z,
 Point out)
Calculates (using the output object) the point in this space markup element nearest to the given (x, y, z) point. Returns the square of distance to the point.
Specified by:
getNearestPoint in class NetworkMarkupElement
Parameters:
x - x coordinate of the point
y - y coordinate of the point
z - z coordinate of the point
output - the output point to write result to.
Returns:
the square of distance to the nearest point
getNearestPointOnRay
public double getNearestPointOnRay(double x1,
 double y1,
 double x2,
 double y2,
 Point out)
Calculates the intersection point between this element and the given ray. If there are several intersections, returns the one nearest to the ray start
Parameters:
x1 - the x coordinate of ray start
y1 - the y coordinate of ray start
x2 - the x coordinate of some ray point
y2 - the y coordinate of some ray point
out - the output: intersection point, should be not null
Returns:
the offset of the nearest point or -1 if there is no intersections with the given ray
getNearestPointOnRay
public double getNearestPointOnRay(double x1,
 double y1,
 double x2,
 double y2,
 LengthUnits units,
 Point out)
Calculates the intersection point between this element and the given ray. If there are several intersections, returns the one nearest to the ray start
Parameters:
x1 - the x coordinate of ray start
y1 - the y coordinate of ray start
x2 - the x coordinate of some ray point
y2 - the y coordinate of some ray point
out - the output: intersection point, should be not null
Returns:
the offset of the nearest point or -1 if there is no intersections with the given ray
randomPointInside
public final Point randomPointInside(Random rng,
 Point out)
Description copied from interface: INetworkMarkupElement
Returns the randomly chosen point inside/along the given space markup element. This method utilises the given Random Number Generator.
Specified by:
randomPointInside in interface INetworkMarkupElement
Parameters:
rng - the random number generator.
out - output object to write to, may be null
Returns:
the randomly chosen point
randomPositionInside
public final Position randomPositionInside(Random rng,
 Position out)
Returns the randomly chosen position along the path. This method utilizes the given Random Number Generator.
Returned position is set to the orientation 'along' the path
Parameters:
rng - the random number generator.
out - output object to write to, may be null
Returns:
the randomly chosen point along the path
toPath3D
public Path3D toPath3D()
Converts this markup element to Path3D interface
getPosition
public Position getPosition(int index,
 int totalNumber,
 Position out)
Description copied from interface: AnimationStaticLocationProvider
Returns the item position with the given index.
In case of any wrong argument returns zero-index position (position for index=0 with totalNumber=1).
Specified by:
getPosition in interface AnimationStaticLocationProvider
Parameters:
index - the index of some item positions, should be not negative and less than totalNumber
totalNumber - the total number of item positions, should be positive
out - output object to write to, may be null
Returns:
the Position object with coordinates of the requested item position
getPosition
public Position getPosition(double value,
 double maxValue,
 Position out)
Description copied from interface: AnimationMovingLocationProvider
Returns position with offset corresponding to the given value, assuming that 0 is start and maxValue is end
Specified by:
getPosition in interface AnimationMovingLocationProvider
Returns:
position by offset
getBoundingRectangle
@AnyLogicInternalAPI
public BoundingRectangle getBoundingRectangle()
createPort
@AnyLogicInternalAPI
default NetworkPort createPort(IPath<?> path,
 PathEndType endType)
createPort
@AnyLogicInternalAPI
default NetworkPort createPort(IPath<?> path,
 PathEndType endType,
 NetworkPort pairedPort)
