# Class AbstractMarkupSegment

## Inheritance Hierarchy
```
java.lang.Object
  com.anylogic.engine.markup.AbstractMarkupSegment
```

## All Implemented Interfaces
`IMarkupSegment`, `Serializable`

## Direct Known Subclasses
`GISMarkupSegment`, `MarkupSegment`

## Class Declaration
```java
public abstract class AbstractMarkupSegment
extends Object
implements IMarkupSegment, Serializable
```

## Description
This class represents a segment of IPath.

**Author:** AnyLogic North America, LLC https://anylogic.com

**See Also:** [Serialized Form](#)

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `AbstractMarkupSegment()` | Default constructor |

## Method Summary

| Modifier and Type | Method | Description |
|------------------|--------|-------------|
| `double` | `getAngle()` | Returns the angle between the segment and XY plane |
| `abstract Position` | `getEnd(Position out)` | Returns the location of the end position of the segment |
| `abstract Position` | `getStart(Position out)` | Returns the location of the start position of the segment |
| `boolean` | `is2D()` | Returns true, if the segment is flat in XY plane (dz = 0), false otherwise |
| `double` | `length()` | Returns the length of the path segment |
| `double` | `length2D()` | Returns the length of the projection of the path segment on XY plane |

## Methods inherited from class java.lang.Object
`equals`, `getClass`, `hashCode`, `notify`, `notifyAll`, `toString`, `wait`, `wait`, `wait`

## Methods inherited from interface com.anylogic.engine.markup.IMarkupSegment
`addTo`, `getDistanceSq`, `getEnd`, `getNearestPoint`, `getNearestPointOnRay2D`, `getOffsetOfPoint`, `getStart`, `setEnd`, `setStart`, `setStartNextTo`

## Constructor Details

### `AbstractMarkupSegment()`
- **Description**: Default constructor

## Method Details

### `length()`
- **Type**: `public double`
- **Description**: Returns the length of the path segment
- **Specified by**: `length` in interface `IMarkupSegment`
- **Returns**: the length of the path segment, a positive number

### `is2D()`
- **Type**: `public boolean`
- **Description**: Returns true, if the segment is flat in XY plane (dz = 0), false otherwise
- **Returns**: true, if the segment is flat in XY plane (dz = 0), false otherwise

### `length2D()`
- **Type**: `public double`
- **Description**: Returns the length of the projection of the path segment on XY plane
- **Returns**: the length of the projection of the path segment on XY plane, a positive number

### `getAngle()`
- **Type**: `public double`
- **Description**: Returns the angle between the segment and XY plane
- **Returns**: the angle between the segment and XY plane

### `getEnd(Position out)`
- **Type**: `public abstract Position`
- **Description**: Returns the location of the end position of the segment
- **Parameters**: 
  - `out`: output object to write to, may be null
- **Returns**: the Position object with coordinates of the segment end

### `getStart(Position out)`
- **Type**: `public abstract Position`
- **Description**: Returns the location of the start position of the segment
- **Parameters**: 
  - `out`: output object to write to, may be null
- **Returns**: the Position object with coordinates of the segment start
