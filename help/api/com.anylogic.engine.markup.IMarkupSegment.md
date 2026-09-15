# Interface IMarkupSegment

## All Known Implementing Classes
`AbstractMarkupSegment`, `GISMarkupSegment`, `GISMarkupSegmentLine`, `MarkupSegment`, `MarkupSegmentArc`, `MarkupSegmentLine`

## Interface Declaration
```java
public interface IMarkupSegment
```

## Description
This interface represents a segment of IPath.

**Author:** AnyLogic North America, LLC https://anylogic.com

## Method Summary

| Modifier and Type | Method | Description |
|------------------|--------|-------------|
| `void` | `addTo(Path2D path)` | **Deprecated.** Adds this segment to the given path assuming that path is currently positioned on the start point of this segment |
| `double` | `getDistanceSq(Point givenPoint)` | Calculates and returns the square of distance to the given point |
| `Point` | `getEnd(Point out)` | Gets end point of markup segment |
| `double` | `getNearestPoint(Point givenPoint, Point out)` | For horizontal segments, calculates the point in this space markup element nearest to the given point |
| `double` | `getNearestPointOnRay2D(double x1, double y1, double x2, double y2, Point out)` | Calculates the point where this segment intersects the given ray with the minimum distance from ray beginning |
| `double` | `getOffsetOfPoint(double x, double y)` | Calculates distance by segment to the given point |
| `Point` | `getStart(Point out)` | Gets start point of markup segment |
| `double` | `length()` | Returns the length of the path segment |
| `void` | `setEnd(Point endPoint)` | Sets end point of this segment |
| `void` | `setStart(Point startPoint)` | Sets start point of this segment |
| `void` | `setStartNextTo(IMarkupSegment previousSegment)` | Sets coordinates of the end of the specified segment as start coordinates of this segment |

## Method Details

### `length()`
- **Type**: `double`
- **Description**: Returns the length of the path segment
- **Returns**: the length of the path segment, a positive number

### `getStart(Point out)`
- **Type**: `Point`
- **Description**: Gets start point of markup segment
- **Parameters**:
  - `out`: the point to store the result of method's execution
- **Returns**: the start point of this segment

### `getEnd(Point out)`
- **Type**: `Point`
- **Description**: Gets end point of markup segment
- **Parameters**:
  - `out`: the point to store the result of method's execution
- **Returns**: the end point of this segment

### `setStart(Point startPoint)`
- **Type**: `void`
- **Description**: Sets start point of this segment
- **Parameters**:
  - `startPoint`: the point to set as start point of this segment

### `setEnd(Point endPoint)`
- **Type**: `void`
- **Description**: Sets end point of this segment
- **Parameters**:
  - `endPoint`: the point to set as end point of this segment

### `getDistanceSq(Point givenPoint)`
- **Type**: `double`
- **Description**: Calculates and returns the square of distance to the given point
- **Parameters**:
  - `givenPoint`: the point to calculate distance to
- **Returns**: the square of distance to the given point

### `getNearestPoint(Point givenPoint, Point out)`
- **Type**: `double`
- **Description**: For horizontal segments, calculates (using the output object) the point in this space markup element nearest to the given point. Returns the square of distance to the point (in the XY-projection). All the calculations are performed in the horizontal projection (z-coordinates aren't used, as if all of the z coordinates were zero)
- **Parameters**:
  - `givenPoint`: the point to find the nearest point to
  - `out`: the output point to write result to. Note that output.z is left unchanged
- **Returns**: the square of distance to the nearest point in the horizontal (XY) projection

### `getNearestPointOnRay2D(double x1, double y1, double x2, double y2, Point out)`
- **Type**: `double`
- **Description**: Calculates (and sets in the 'out' object) the point where this segment intersects the given ray with the minimum distance from ray beginning (if there are several intersection points like in arc segments). Returns the square of that distance. Returns +infinity if there is no intersections
- **Parameters**:
  - `x1`: the X coordinate of the start point of the ray
  - `y1`: the Y coordinate of the start point of the ray
  - `x2`: the X coordinate of some point on the ray
  - `y2`: the Y coordinate of some point on the ray
  - `out`: the Point object to write result to
- **Returns**: the square of the distance from ray beginning to the nearest intersection point or +infinity if there is no intersections

### `getOffsetOfPoint(double x, double y)`
- **Type**: `double`
- **Description**: Calculates distance by segment to the given point. Point is specified by a pair of coordinates. The given point should be on this segment
- **Parameters**:
  - `x`: the x coordinate of the given point. In case of GIS space this is the latitude of the given point, measured in degrees (-90 ... (South) ... 0 ... (North) ... +90)
  - `y`: the y coordinate of the given point. In case of GIS space this is the longitude of the given point, measured in degrees (-180 ... (West) ... 0 ... (East) ... +180)
- **Returns**: the distance by segment to the given point

### `setStartNextTo(IMarkupSegment previousSegment)`
- **Type**: `void`
- **Description**: Sets coordinates of the end of the specified segment as start coordinates of this segment
- **Parameters**:
  - `previousSegment`: implementation of IMarkupSegment

### `addTo(Path2D path)`
- **Type**: `void`
- **Deprecated**
- **Description**: Adds this segment to the given path assuming that path is currently positioned on the start point of this segment
- **Parameters**:
  - `path`: the path to add this segment to
