# Class MarkupSegmentArc

## Inheritance Hierarchy
```
java.lang.Object
  com.anylogic.engine.markup.AbstractMarkupSegment
    com.anylogic.engine.markup.MarkupSegment
      com.anylogic.engine.markup.MarkupSegmentArc
```

## All Implemented Interfaces
`IMarkupSegment`, `Serializable`

## Class Declaration
```java
public final class MarkupSegmentArc
extends MarkupSegment
```

## Description
Arched markup segment for continuous space.

**Author:** AnyLogic North America, LLC https://anylogic.com

**See Also:** [Serialized Form](#)

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `MarkupSegmentArc()` | Default constructor |
| `MarkupSegmentArc(double sx, double sy, double sz, double ex, double ey, double ez, double startAngle, double endAngle, double ratioStartToEnd)` | Constructor with start/end coordinates and angles |
| `MarkupSegmentArc(double sx, double sy, double sz, double ex, double ey, double ez, double startAngle, double endAngle, double ratioStartToEnd, double sArcCenterX, double sArcCenterY, double sArcRadius, double sArcStartAngle, double sArcAngle, double eArcCenterX, double eArcCenterY, double eArcRadius, double eArcStartAngle, double eArcAngle)` | Full constructor with all arc parameters |

## Method Summary

| Modifier and Type | Method | Description |
|------------------|--------|-------------|
| `void` | `addTo(Path2D path)` | Adds this segment to the given path assuming that path is currently positioned on the start point of this segment |
| `List<Shape>` | `convertToShapes()` | Converts the markup segment into java.awt.geom primitives like Arc2D or Line2D |
| `static Point` | `getArgNearestPointOnRay2D(double ax, double ay, double bx, double by, double arcCenterX, double arcCenterY, double sx, double sy, double ex, double ey, double arcRadius, double arcAngle, double arcSign, Point out)` | **Deprecated.** |
| `BoundingRectangle` | `getBoundingRectangle()` | Gets the bounding rectangle for this arc segment |
| `double` | `getDistanceSq(double x, double y)` | For horizontal segments, calculates and returns the square of distance to the point (in the XY-projection) |
| `double` | `getDistanceSq(double x, double y, double z)` | Calculates and returns the square of distance to the given (x, y, z) point |
| `Position` | `getEnd(Position out)` | Returns the location of the end position of the segment |
| `double` | `getEndAngle()` | Returns the angle of the tangent to the segment at its end |
| `double` | `getEndArcAngle()` | Gets the end arc angle |
| `double` | `getEndArcCenterX()` | Gets the X coordinate of the end arc center |
| `double` | `getEndArcCenterY()` | Gets the Y coordinate of the end arc center |
| `double` | `getEndArcRadius()` | Gets the end arc radius |
| `double` | `getEndArcSign()` | Gets the end arc sign |
| `double` | `getEndArcStartAngle()` | Gets the end arc start angle |
| `double` | `getJoinX()` | Gets the X coordinate of the join point |
| `double` | `getJoinY()` | Gets the Y coordinate of the join point |
| `double` | `getJoinZ()` | Gets the Z coordinate of the join point |
| `double` | `getNearestPoint(double x, double y, double z, Point out)` | Calculates the point in this space markup element pseudo-nearest to the given (x, y, z) point |
| `double` | `getNearestPoint(double x, double y, Point out)` | For horizontal segments, calculates the point in this space markup element nearest to the given (x, y) point |
| `double` | `getNearestPointOnRay2D(double x1, double y1, double x2, double y2, Point out)` | Calculates the point where this segment intersects the given ray with the minimum distance from ray beginning |
| `double` | `getOffsetOfPoint(double x, double y)` | Calculates distance by segment to the given point |
| `double` | `getRatioStartToEnd()` | Returns the start to end ratio |
| `Position` | `getStart(Position out)` | Returns the location of the start position of the segment |
| `double` | `getStartAngle()` | Returns the angle of the tangent to the segment at its start |
| `double` | `getStartArcAngle()` | Gets the start arc angle |
| `double` | `getStartArcCenterX()` | Gets the X coordinate of the start arc center |
| `double` | `getStartArcCenterY()` | Gets the Y coordinate of the start arc center |
| `double` | `getStartArcRadius()` | Gets the start arc radius |
| `double` | `getStartArcSign()` | Gets the start arc sign |
| `double` | `getStartArcStartAngle()` | Gets the start arc start angle |
| `void` | `initialize()` | Initializes the arc segment |
| `void` | `setAngles(double startAngle, double endAngle, double ratioStartToEnd)` | Sets the angles of this arc |
| `String` | `toString()` | Returns a string representation of this arc segment |

## Methods inherited from class com.anylogic.engine.markup.MarkupSegment
`getDistanceSq`, `getEnd`, `getEndX`, `getEndY`, `getEndZ`, `getNearestPoint`, `getOffsetFrom2D`, `getPositionAtOffset`, `getStart`, `getStartX`, `getStartY`, `getStartZ`, `length`, `length2D`, `setEnd`, `setEnd`, `setStart`, `setStart`, `setStartNextTo`

## Methods inherited from class com.anylogic.engine.markup.AbstractMarkupSegment
`getAngle`, `is2D`

## Methods inherited from class java.lang.Object
`equals`, `getClass`, `hashCode`, `notify`, `notifyAll`, `wait`, `wait`, `wait`

## Constructor Details

### `MarkupSegmentArc()`
- **Description**: Default constructor

### `MarkupSegmentArc(double sx, double sy, double sz, double ex, double ey, double ez, double startAngle, double endAngle, double ratioStartToEnd)`
- **Description**: Constructor with start/end coordinates and angles
- **Parameters**:
  - `sx`, `sy`, `sz`: Start point coordinates
  - `ex`, `ey`, `ez`: End point coordinates
  - `startAngle`: Start angle
  - `endAngle`: End angle
  - `ratioStartToEnd`: Ratio of start to end

### `MarkupSegmentArc(double sx, double sy, double sz, double ex, double ey, double ez, double startAngle, double endAngle, double ratioStartToEnd, double sArcCenterX, double sArcCenterY, double sArcRadius, double sArcStartAngle, double sArcAngle, double eArcCenterX, double eArcCenterY, double eArcRadius, double eArcStartAngle, double eArcAngle)`
- **Description**: Full constructor with all arc parameters
- **Parameters**:
  - `sx`, `sy`, `sz`: Start point coordinates
  - `ex`, `ey`, `ez`: End point coordinates
  - `startAngle`: Start angle
  - `endAngle`: End angle
  - `ratioStartToEnd`: Ratio of start to end
  - `sArcCenterX`, `sArcCenterY`: Start arc center coordinates
  - `sArcRadius`: Start arc radius
  - `sArcStartAngle`: Start arc start angle
  - `sArcAngle`: Start arc angle
  - `eArcCenterX`, `eArcCenterY`: End arc center coordinates
  - `eArcRadius`: End arc radius
  - `eArcStartAngle`: End arc start angle
  - `eArcAngle`: End arc angle

## Method Details

### `initialize()`
- **Type**: `public void`
- **Description**: Initializes the arc segment

### `setAngles(double startAngle, double endAngle, double ratioStartToEnd)`
- **Type**: `public void`
- **Description**: Sets the angles of this arc. The element should be uninitialized
- **Parameters**:
  - `startAngle`: Start angle
  - `endAngle`: End angle
  - `ratioStartToEnd`: Start to end ratio

### `getStartAngle()`
- **Type**: `public double`
- **Description**: Returns the angle of the tangent to the segment at its start
- **Returns**: The angle of the tangent to the segment at its start

### `getEndAngle()`
- **Type**: `public double`
- **Description**: Returns the angle of the tangent to the segment at its end
- **Returns**: The angle of the tangent to the segment at its end

### `getRatioStartToEnd()`
- **Type**: `public double`
- **Description**: Returns the start to end ratio
- **Returns**: The start to end ratio

### `getStart(Position out)`
- **Type**: `public Position`
- **Description**: Returns the location of the start position of the segment
- **Specified by**: `getStart` in class `AbstractMarkupSegment`
- **Parameters**:
  - `out`: Output object to write to, may be null
- **Returns**: The Position object with coordinates of the segment start

### `getEnd(Position out)`
- **Type**: `public Position`
- **Description**: Returns the location of the end position of the segment
- **Specified by**: `getEnd` in class `AbstractMarkupSegment`
- **Parameters**:
  - `out`: Output object to write to, may be null
- **Returns**: The Position object with coordinates of the segment end

### `getNearestPoint(double x, double y, Point out)`
- **Type**: `public double`
- **Description**: For horizontal segments, calculates the point in this space markup element nearest to the given (x, y) point. Returns the square of distance to the point (in the XY-projection)
- **Specified by**: `getNearestPoint` in class `MarkupSegment`
- **Parameters**:
  - `x`: X coordinate of the point
  - `y`: Y coordinate of the point
  - `out`: The output point to write result to. Note that output.z is left unchanged
- **Returns**: The square of distance to the nearest point in the horizontal (XY) projection

### `getNearestPoint(double x, double y, double z, Point out)`
- **Type**: `public double`
- **Description**: Calculates the point in this space markup element pseudo-nearest to the given (x, y, z) point: the chosen point is really nearest in the 2D (XY) plane. Returns the square of distance to the point
- **Specified by**: `getNearestPoint` in class `MarkupSegment`
- **Parameters**:
  - `x`: X coordinate of the point
  - `y`: Y coordinate of the point
  - `z`: Z coordinate of the point
  - `out`: The output point to write result to
- **Returns**: The square of distance to the nearest point

### `getDistanceSq(double x, double y)`
- **Type**: `public double`
- **Description**: For horizontal segments, calculates and returns the square of distance to the point (in the XY-projection)
- **Specified by**: `getDistanceSq` in class `MarkupSegment`
- **Parameters**:
  - `x`: X coordinate of the point
  - `y`: Y coordinate of the point
- **Returns**: The square of distance to the given point in the horizontal (XY) projection

### `getDistanceSq(double x, double y, double z)`
- **Type**: `public double`
- **Description**: Calculates and returns the square of distance to the given (x, y, z) point
- **Specified by**: `getDistanceSq` in class `MarkupSegment`
- **Parameters**:
  - `x`: X coordinate of the point
  - `y`: Y coordinate of the point
  - `z`: Z coordinate of the point
- **Returns**: The square of distance to the given point

### `addTo(Path2D path)`
- **Type**: `public void`
- **Description**: Adds this segment to the given path assuming that path is currently positioned on the start point of this segment
- **Specified by**: `addTo` in interface `IMarkupSegment`
- **Parameters**:
  - `path`: The path to add this segment to

### `toString()`
- **Type**: `public String`
- **Description**: Returns a string representation of this arc segment
- **Overrides**: `toString` in class `Object`
- **Returns**: A string representation of this arc segment

### `getOffsetOfPoint(double x, double y)`
- **Type**: `public double`
- **Description**: Calculates distance by segment to the given point. Point is specified by a pair of coordinates. The given point should be on this segment
- **Specified by**: `getOffsetOfPoint` in interface `IMarkupSegment`
- **Parameters**:
  - `x`: The x coordinate of the given point. In case of GIS space this is the latitude of the given point, measured in degrees (-90 ... (South) ... 0 ... (North) ... +90)
  - `y`: The y coordinate of the given point. In case of GIS space this is the longitude of the given point, measured in degrees (-180 ... (West) ... 0 ... (East) ... +180)
- **Returns**: The distance by segment to the given point

### `getNearestPointOnRay2D(double x1, double y1, double x2, double y2, Point out)`
- **Type**: `public double`
- **Description**: Calculates the point where this segment intersects the given ray with the minimum distance from ray beginning. Returns the square of that distance. Returns +infinity if there is no intersections
- **Specified by**: `getNearestPointOnRay2D` in interface `IMarkupSegment`
- **Parameters**:
  - `x1`: The X coordinate of the start point of the ray
  - `y1`: The Y coordinate of the start point of the ray
  - `x2`: The X coordinate of some point on the ray
  - `y2`: The Y coordinate of some point on the ray
  - `out`: The Point object to write result to
- **Returns**: The square of the distance from ray beginning to the nearest intersection point or +infinity if there is no intersections

### `getArgNearestPointOnRay2D(double ax, double ay, double bx, double by, double arcCenterX, double arcCenterY, double sx, double sy, double ex, double ey, double arcRadius, double arcAngle, double arcSign, Point out)`
- **Type**: `public static Point`
- **Deprecated**
- **Annotation**: `@AnyLogicInternalAPI`
- **Description**: Internal method for calculating nearest point on ray

### `getStartArcCenterX()`, `getStartArcCenterY()`, `getStartArcRadius()`, `getStartArcStartAngle()`, `getStartArcAngle()`, `getStartArcSign()`, `getEndArcCenterX()`, `getEndArcCenterY()`, `getEndArcRadius()`, `getEndArcStartAngle()`, `getEndArcAngle()`, `getEndArcSign()`, `getJoinX()`, `getJoinY()`, `getJoinZ()`
- **Type**: `public double`
- **Annotation**: `@AnyLogicInternalAPI`
- **Description**: Internal methods for accessing arc properties

### `convertToShapes()`
- **Type**: `public List<Shape>`
- **Description**: Converts the markup segment into java.awt.geom primitives like Arc2D or Line2D
- **Specified by**: `convertToShapes` in class `MarkupSegment`
- **Returns**: The list of primitives that comprise the markup segment

### `getBoundingRectangle()`
- **Type**: `public BoundingRectangle`
- **Annotation**: `@AnyLogicInternalAPI`
- **Description**: Gets the bounding rectangle for this arc segment
- **Returns**: The bounding rectangle
