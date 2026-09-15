# Class MarkupSegmentLine

## Inheritance Hierarchy
```
java.lang.Object
  com.anylogic.engine.markup.AbstractMarkupSegment
    com.anylogic.engine.markup.MarkupSegment
      com.anylogic.engine.markup.MarkupSegmentLine
```

## All Implemented Interfaces
`IMarkupSegment`, `Serializable`

## Class Declaration
```java
public final class MarkupSegmentLine
extends MarkupSegment
```

## Description
Straight markup segment for continuous space.

**Author:** AnyLogic North America, LLC https://anylogic.com

**See Also:** [Serialized Form](#)

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `MarkupSegmentLine()` | Default constructor |
| `MarkupSegmentLine(double sx, double sy, double sz, double ex, double ey, double ez)` | Constructor with start and end coordinates |

## Method Summary

| Modifier and Type | Method | Description |
|------------------|--------|-------------|
| `void` | `addTo(Path2D path)` | Adds this segment to the given path assuming that path is currently positioned on the start point of this segment |
| `List<Shape>` | `convertToShapes()` | Converts the markup segment into java.awt.geom primitives like Arc2D or Line2D |
| `BoundingRectangle` | `getBoundingRectangle()` | Gets the bounding rectangle for this line segment |
| `double` | `getDistanceSq(double x, double y)` | For horizontal segments, calculates and returns the square of distance to the point (in the XY-projection) |
| `double` | `getDistanceSq(double x, double y, double z)` | For horizontal segments, calculates and returns the square of distance to the point (in the XY-projection) |
| `Position` | `getEnd(Position out)` | Returns the location of the end position of the segment |
| `double` | `getNearestPoint(double x, double y, double z, Point out)` | Calculates the point in this space markup element nearest to the given (x, y, z) point |
| `double` | `getNearestPoint(double x, double y, Point out)` | For horizontal segments, calculates the point in this space markup element nearest to the given (x, y) point |
| `double` | `getNearestPointOnRay2D(double x1, double y1, double x2, double y2, Point out)` | Calculates the point where this segment intersects the given ray with the minimum distance from ray beginning |
| `double` | `getOffsetOfPoint(double x, double y)` | Calculates distance by segment to the given point |
| `Position` | `getStart(Position out)` | Returns the location of the start position of the segment |
| `final void` | `initialize()` | Initializes the line segment |
| `String` | `toString()` | Returns a string representation of this line segment |

## Methods inherited from class com.anylogic.engine.markup.MarkupSegment
`getDistanceSq`, `getEnd`, `getEndX`, `getEndY`, `getEndZ`, `getNearestPoint`, `getOffsetFrom2D`, `getPositionAtOffset`, `getStart`, `getStartX`, `getStartY`, `getStartZ`, `length`, `length2D`, `setEnd`, `setEnd`, `setStart`, `setStart`, `setStartNextTo`

## Methods inherited from class com.anylogic.engine.markup.AbstractMarkupSegment
`getAngle`, `is2D`

## Methods inherited from class java.lang.Object
`equals`, `getClass`, `hashCode`, `notify`, `notifyAll`, `wait`, `wait`, `wait`

## Constructor Details

### `MarkupSegmentLine(double sx, double sy, double sz, double ex, double ey, double ez)`
- **Description**: Constructor with start and end coordinates
- **Parameters**:
  - `sx`, `sy`, `sz`: Start point coordinates
  - `ex`, `ey`, `ez`: End point coordinates

### `MarkupSegmentLine()`
- **Description**: Default constructor

## Method Details

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

### `initialize()`
- **Type**: `public final void`
- **Description**: Initializes the line segment

### `getNearestPoint(double x, double y, Point out)`
- **Type**: `public double`
- **Description**: For horizontal segments, calculates the point in this space markup element nearest to the given (x, y) point. Returns the square of distance to the point (in the XY-projection)
- **Specified by**: `getNearestPoint` in class `MarkupSegment`
- **Parameters**:
  - `x`: X coordinate of the point
  - `y`: Y coordinate of the point
  - `out`: The output point to write result to. Note that output.z is left unchanged
- **Returns**: The square of distance to the nearest point in the horizontal (XY) projection

### `getDistanceSq(double x, double y)`
- **Type**: `public double`
- **Description**: For horizontal segments, calculates and returns the square of distance to the point (in the XY-projection)
- **Specified by**: `getDistanceSq` in class `MarkupSegment`
- **Parameters**:
  - `x`: X coordinate of the point
  - `y`: Y coordinate of the point
- **Returns**: The square of distance to the given point in the horizontal (XY) projection

### `getNearestPoint(double x, double y, double z, Point out)`
- **Type**: `public double`
- **Description**: Calculates the point in this space markup element nearest to the given (x, y, z) point. Returns the square of distance to the point
- **Specified by**: `getNearestPoint` in class `MarkupSegment`
- **Parameters**:
  - `x`: X coordinate of the point
  - `y`: Y coordinate of the point
  - `z`: Z coordinate of the point
  - `out`: The output point to write result to
- **Returns**: The square of distance to the nearest point

### `getDistanceSq(double x, double y, double z)`
- **Type**: `public double`
- **Description**: For horizontal segments, calculates and returns the square of distance to the point (in the XY-projection)
- **Specified by**: `getDistanceSq` in class `MarkupSegment`
- **Parameters**:
  - `x`: X coordinate of the point
  - `y`: Y coordinate of the point
  - `z`: Z coordinate of the point
- **Returns**: The square of distance to the given point in the horizontal (XY) projection

### `getNearestPointOnRay2D(double x1, double y1, double x2, double y2, Point out)`
- **Type**: `public double`
- **Description**: Calculates the point where this segment intersects the given ray with the minimum distance from ray beginning. Returns the square of that distance. Returns +infinity if there is no intersections
- **Parameters**:
  - `x1`: The X coordinate of the start point of the ray
  - `y1`: The Y coordinate of the start point of the ray
  - `x2`: The X coordinate of some point on the ray
  - `y2`: The Y coordinate of some point on the ray
  - `out`: The Point object to write result to
- **Returns**: The square of the distance from ray beginning to the nearest intersection point or +infinity if there is no intersections

### `getOffsetOfPoint(double x, double y)`
- **Type**: `public double`
- **Description**: Calculates distance by segment to the given point. Point is specified by a pair of coordinates. The given point should be on this segment
- **Parameters**:
  - `x`: The x coordinate of the given point. In case of GIS space this is the latitude of the given point, measured in degrees (-90 ... (South) ... 0 ... (North) ... +90)
  - `y`: The y coordinate of the given point. In case of GIS space this is the longitude of the given point, measured in degrees (-180 ... (West) ... 0 ... (East) ... +180)
- **Returns**: The distance by segment to the given point

### `addTo(Path2D path)`
- **Type**: `public void`
- **Description**: Adds this segment to the given path assuming that path is currently positioned on the start point of this segment
- **Parameters**:
  - `path`: The path to add this segment to

### `toString()`
- **Type**: `public String`
- **Description**: Returns a string representation of this line segment
- **Overrides**: `toString` in class `Object`
- **Returns**: A string representation of this line segment

### `convertToShapes()`
- **Type**: `public List<Shape>`
- **Description**: Converts the markup segment into java.awt.geom primitives like Arc2D or Line2D
- **Specified by**: `convertToShapes` in class `MarkupSegment`
- **Returns**: The list of primitives that comprise the markup segment

### `getBoundingRectangle()`
- **Type**: `public BoundingRectangle`
- **Annotation**: `@AnyLogicInternalAPI`
- **Description**: Gets the bounding rectangle for this line segment
- **Returns**: The bounding rectangle
