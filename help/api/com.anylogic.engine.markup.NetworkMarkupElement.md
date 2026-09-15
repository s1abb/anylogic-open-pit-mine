# Class NetworkMarkupElement

## Package
`com.anylogic.engine.markup`

## Inheritance Hierarchy
```
java.lang.Object
  com.anylogic.engine.markup.AbstractMarkup
    com.anylogic.engine.markup.MarkupShape
      com.anylogic.engine.markup.NetworkMarkupElement
```

## All Implemented Interfaces
`AggregatableAnimationElement`, `HasLevel`, `INetworkMarkupElement`, `SVGElement`, `Serializable`

## Direct Known Subclasses
`Node`, `PalletRack`, `Path`

## Class Declaration
```java
@AnyLogicInternalAPI
public abstract class NetworkMarkupElement
extends MarkupShape
implements INetworkMarkupElement
```

**See Also:** [Serialized Form](#)

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `NetworkMarkupElement()` | Default constructor |
| `NetworkMarkupElement(Agent owner)` | Constructor with owner |
| `NetworkMarkupElement(Agent owner, ShapeDrawMode drawMode, boolean isPublic)` | Constructor with owner, draw mode, and public flag |

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `ShapeDrawMode` | `getDrawMode()` | Returns the drawing mode of the shape |
| `Level` | `getLevel()` | Returns level associated with this space markup element |
| `double` | `getNearestPoint(double x, double y, double z, LengthUnits units, Point output)` | Calculates the point in this space markup element nearest to the given (x, y, z) point |
| `abstract double` | `getNearestPoint(double x, double y, double z, Point output)` | Calculates the point in this space markup element nearest to the given (x, y, z) point |
| `double` | `getNearestPoint(double x, double y, LengthUnits units, Point output)` | Calculates the point in this space markup element nearest to the given (x, y) point |
| `abstract double` | `getNearestPoint(double x, double y, Point output)` | Calculates the point in this space markup element nearest to the given (x, y) point |
| `double` | `getNearestPoint(Point givenPoint, Point out)` | Calculates the point in this space markup element nearest to the given point |
| `Network` | `getNetwork()` | Gets the network this markup element belongs to |
| `void` | `setLevel(Level level)` | Sets the level of this element |

## Methods inherited from class com.anylogic.engine.markup.MarkupShape
`contains`, `error`, `getFullName`, `getOutsideLevelZ`, `getPresentable`, `getSpace`, `initialize`, `isClickHandled`, `isPublic`, `onClick`, `remove`, `setDrawMode`, `setOwner`

## Methods inherited from class com.anylogic.engine.markup.AbstractMarkup
`discardOwner`, `executeUserAction`, `findSVGElement`, `getName`, `getSVGId`, `initializeInternal`, `isVisible`, `onAggregatorInitialized`, `onAggregatorVisibilityChanged`, `removeSVGFromOwner`, `resetSVGState`, `setVisible`, `updateDynamicProperties`, `updateDynamicPropertiesStructural`, `updateSVGProperties`

## Methods inherited from class java.lang.Object
`equals`, `getClass`, `hashCode`, `notify`, `notifyAll`, `toString`, `wait`, `wait`, `wait`

## Methods inherited from interface com.anylogic.engine.markup.AggregatableAnimationElement
`postInitialize`

## Methods inherited from interface com.anylogic.engine.markup.INetworkMarkupElement
`contains`, `getSpace`, `randomPointInside`, `randomPointInside`, `randomPointInside`, `randomPointInside`

## Constructor Details

### `NetworkMarkupElement()`
```java
public NetworkMarkupElement()
```
Default constructor

### `NetworkMarkupElement(Agent owner)`
```java
public NetworkMarkupElement(Agent owner)
```
Constructor with owner

### `NetworkMarkupElement(Agent owner, ShapeDrawMode drawMode, boolean isPublic)`
```java
public NetworkMarkupElement(Agent owner,
                           ShapeDrawMode drawMode,
                           boolean isPublic)
```
Constructor with owner, draw mode, and public flag

## Method Details

### `getDrawMode()`
```java
public ShapeDrawMode getDrawMode()
```
**Description copied from class: MarkupShape**

Returns the drawing mode of the shape (where to draw this shape: 2D, 3D or 2D+3D).
If the shape has been created with no-argument constructor, and has no specific limitations (like 2D-only), and drawing mode hasn't yet been set, then it is initialized to default (2D + 3D).

**Overrides:**
`getDrawMode` in class `MarkupShape`

**Returns:**
The draw mode for this shape

### `getNearestPoint(double x, double y, Point output)`
```java
public abstract double getNearestPoint(double x,
                                      double y,
                                      Point output)
```
Calculates (using the output object) the point in this space markup element nearest to the given (x, y) point. Returns the square of distance to the point (in the XY-projection). All the calculations are performed in the horizontal projection (z-coordinates aren't used, as if all of the z coordinates were zero).

**Parameters:**
- `x` - x coordinate of the point
- `y` - y coordinate of the point
- `output` - the output point to write result to. Note that output.z is left unchanged.

**Returns:**
The square of distance to the nearest point in the horizontal (XY) projection

### `getNearestPoint(double x, double y, LengthUnits units, Point output)`
```java
public double getNearestPoint(double x,
                             double y,
                             LengthUnits units,
                             Point output)
```
Calculates (using the output object) the point in this space markup element nearest to the given (x, y) point. Returns the square of distance to the point (in the XY-projection). All the calculations are performed in the horizontal projection (z-coordinates aren't used, as if all of the z coordinates were zero).

**Parameters:**
- `x` - x coordinate of the point
- `y` - y coordinate of the point
- `units` - the units of length
- `output` - the output point to write result to. Note that output.z is left unchanged.

**Returns:**
The square of distance to the nearest point in the horizontal (XY) projection

**Since:**
7.1

### `getNearestPoint(double x, double y, double z, Point output)`
```java
public abstract double getNearestPoint(double x,
                                      double y,
                                      double z,
                                      Point output)
```
Calculates (using the output object) the point in this space markup element nearest to the given (x, y, z) point. Returns the square of distance to the point.

**Parameters:**
- `x` - x coordinate of the point
- `y` - y coordinate of the point
- `z` - z coordinate of the point
- `output` - the output point to write result to.

**Returns:**
The square of distance to the nearest point

### `getNearestPoint(double x, double y, double z, LengthUnits units, Point output)`
```java
public double getNearestPoint(double x,
                             double y,
                             double z,
                             LengthUnits units,
                             Point output)
```
Calculates (using the output object) the point in this space markup element nearest to the given (x, y, z) point. Returns the square of distance to the point.

**Parameters:**
- `x` - x coordinate of the point
- `y` - y coordinate of the point
- `z` - z coordinate of the point
- `units` - the units of length
- `output` - the output point to write result to.

**Returns:**
The square of distance to the nearest point

**Since:**
7.1

### `getNearestPoint(Point givenPoint, Point out)`
```java
public double getNearestPoint(Point givenPoint,
                             Point out)
```
**Description copied from interface: INetworkMarkupElement**

Calculates (using the output object) the point in this space markup element nearest to the given point. Returns the square of distance to the point.

**Specified by:**
`getNearestPoint` in interface `INetworkMarkupElement`

**Parameters:**
- `givenPoint` - given point
- `out` - the output point to write result to.

**Returns:**
The square of distance to the nearest point

### `getNetwork()`
```java
public Network getNetwork()
```
**Specified by:**
`getNetwork` in interface `INetworkMarkupElement`

**Returns:**
Network this markup element belongs to or null if this element isn't a part of a network

### `getLevel()`
```java
public Level getLevel()
```
**Description copied from interface: HasLevel**

Returns level associated with this space markup element or null if this element has no level

**Specified by:**
`getLevel` in interface `HasLevel`

**Specified by:**
`getLevel` in class `MarkupShape`

**Returns:**
The level associated with this space markup element

### `setLevel(Level level)`
```java
public void setLevel(Level level)
```
Sets the level of this element. The element should not be contained in any level before the call of this method. Also sets the owner of the specified level as the owner of this element

**Parameters:**
- `level` - new level
