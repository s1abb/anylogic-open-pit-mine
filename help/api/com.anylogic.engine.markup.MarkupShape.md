# Class MarkupShape

## Package
`com.anylogic.engine.markup`

## Inheritance Hierarchy
```
java.lang.Object
  com.anylogic.engine.markup.AbstractMarkup
    com.anylogic.engine.markup.MarkupShape
```

## All Implemented Interfaces
`AggregatableAnimationElement`, `HasLevel`, `SVGElement`, `Serializable`

## Direct Known Subclasses
`AbstractLevelMarkup`, `AbstractRailwayMarkup`, `AbstractRoadMarkup`, `ConveyorMarkupElement`, `LiftPortImpl`, `NetworkMarkupElement`

## Class Declaration
```java
public abstract class MarkupShape
extends AbstractMarkup
implements HasLevel
```

**See Also:** [Serialized Form](#)

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `MarkupShape()` | Default constructor |
| `MarkupShape(Agent owner)` | Constructor with owner |
| `MarkupShape(Agent owner, ShapeDrawMode drawMode, boolean isPublic)` | Constructor with owner, draw mode, and public flag |

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `abstract boolean` | `contains(double px, double py)` | Test if the shape contains the point with the given coordinates |
| `final RuntimeException` | `error(String errorText)` | Signals an error during the model run |
| `ShapeDrawMode` | `getDrawMode()` | Returns the drawing mode of the shape |
| `String` | `getFullName()` | Returns the name of the markup prefixed by the path from the top-level agent |
| `abstract Level` | `getLevel()` | Returns level associated with this space markup element |
| `double` | `getOutsideLevelZ()` | Gets the Z coordinate outside the level |
| `Agent` | `getPresentable()` | Gets the presentable agent |
| `Agent` | `getSpace()` | Returns the agent where the markup element is defined |
| `final void` | `initialize()` | **Deprecated.** Deprecated in version 8.5.0, will be removed in future releases |
| `boolean` | `isClickHandled()` | Checks if click is handled |
| `boolean` | `isPublic()` | Tests if the markup is public |
| `boolean` | `onClick(double clickx, double clicky)` | Should be overridden to define the shape reaction on mouse click |
| `void` | `remove()` | Removes the markup element from the presentation |
| `void` | `setDrawMode(ShapeDrawMode drawMode)` | Sets the drawing mode of the shape |
| `void` | `setOwner(Agent owner)` | Sets the owner of the markup element |

## Methods inherited from class com.anylogic.engine.markup.AbstractMarkup
`discardOwner`, `executeUserAction`, `findSVGElement`, `getName`, `getSVGId`, `initializeInternal`, `isVisible`, `onAggregatorInitialized`, `onAggregatorVisibilityChanged`, `removeSVGFromOwner`, `resetSVGState`, `setVisible`, `updateDynamicProperties`, `updateDynamicPropertiesStructural`, `updateSVGProperties`

## Methods inherited from class java.lang.Object
`equals`, `getClass`, `hashCode`, `notify`, `notifyAll`, `toString`, `wait`, `wait`, `wait`

## Methods inherited from interface com.anylogic.engine.markup.AggregatableAnimationElement
`postInitialize`

## Constructor Details

### `MarkupShape()`
```java
public MarkupShape()
```
Default constructor

### `MarkupShape(Agent owner)`
```java
public MarkupShape(Agent owner)
```
Constructor with owner

### `MarkupShape(Agent owner, ShapeDrawMode drawMode, boolean isPublic)`
```java
public MarkupShape(Agent owner,
                  ShapeDrawMode drawMode,
                  boolean isPublic)
```
Constructor with owner, draw mode, and public flag

## Method Details

### `isPublic()`
```java
public boolean isPublic()
```
**Description copied from class: AbstractMarkup**

Tests if the markup is public, i.e. if it should be drawn on the agent's parent animation. If the markup is a part of a network, the markup is public only if both the network and the markup itself are public.

**Overrides:**
`isPublic` in class `AbstractMarkup`

**Returns:**
True if the markup is public, false otherwise.

### `initialize()`
```java
@Deprecated
public final void initialize()
```
**Deprecated.**
Deprecated in version 8.5.0, will be removed in the future releases

### `setOwner(Agent owner)`
```java
public void setOwner(Agent owner)
```
Sets the owner of the markup element

**Parameters:**
- `owner` - new owner

### `isClickHandled()`
```java
@AnyLogicInternalAPI
public boolean isClickHandled()
```
Checks if click is handled

### `onClick(double clickx, double clicky)`
```java
@AnyLogicInternalCodegenAPI
public boolean onClick(double clickx,
                      double clicky)
```
Should be overridden to define the shape reaction on mouse click. The click coordinates are definitely within the shape bounds if this method is called. By default, does nothing and returns false.

**Parameters:**
- `clickx` - the x coordinate of the click relative to the shape
- `clicky` - the y coordinate of the click relative to the shape

**Returns:**
Always return false here.

### `contains(double px, double py)`
```java
public abstract boolean contains(double px,
                                double py)
```
Test if the shape contains the point with the given coordinates (relative to this shape's container, i.e. in the same system with the coordinates of this shape, x and y)

**Parameters:**
- `px` - the x coordinate relative to this shape's container
- `py` - the y coordinate relative to this shape's container

**Returns:**
True if the shape contains the point with the given coordinates

### `setDrawMode(ShapeDrawMode drawMode)`
```java
public void setDrawMode(ShapeDrawMode drawMode)
```
Sets the drawing mode of the shape (where to draw this shape: 2D, 3D or 2D+3D).
This method may be called only for shapes created using no-argument constructor (which have no limitations like 2D-only) and only once. Any subsequent call for a shape having drawing mode already set, will throw error.

**Parameters:**
- `drawMode` - where to draw this shape: 2D, 3D or 2D+3D

### `getDrawMode()`
```java
public ShapeDrawMode getDrawMode()
```
Returns the drawing mode of the shape (where to draw this shape: 2D, 3D or 2D+3D).
If the shape has been created with no-argument constructor, and has no specific limitations (like 2D-only), and drawing mode hasn't yet been set, then it is initialized to default (2D + 3D).

**Overrides:**
`getDrawMode` in class `AbstractMarkup`

**Returns:**
The draw mode for this shape

### `getFullName()`
```java
public String getFullName()
```
Returns the name of the markup prefixed by the path from the top-level agent to this one.

**Returns:**
The full name of the object including path from root

### `getPresentable()`
```java
@AnyLogicInternalAPI
public Agent getPresentable()
```
Gets the presentable agent

### `getSpace()`
```java
public Agent getSpace()
```
**Description copied from class: AbstractMarkup**

Returns the agent where the markup element is defined

**Specified by:**
`getSpace` in class `AbstractMarkup`

**Returns:**
The agent associated with this element

### `getLevel()`
```java
public abstract Level getLevel()
```
**Description copied from interface: HasLevel**

Returns level associated with this space markup element or null if this element has no level

**Specified by:**
`getLevel` in interface `HasLevel`

**Returns:**
The level associated with this space markup element

### `getOutsideLevelZ()`
```java
@AnyLogicInternalAPI
public double getOutsideLevelZ()
```
Gets the Z coordinate outside the level

### `remove()`
```java
public void remove()
```
**Description copied from class: AbstractMarkup**

Removes the markup element from the presentation, if it is not a part of the presentation, does nothing. Please note that removal from presentation does not necessarily mean removing from the model logic as logical networks and routes may have been created before the removal and survive it.

**Specified by:**
`remove` in class `AbstractMarkup`

### `error(String errorText)`
```java
public final RuntimeException error(String errorText)
```
Signals an error during the model run by throwing a RuntimeException with errorText preceded by the agent full name.

**Specified by:**
`error` in class `AbstractMarkup`

**Parameters:**
- `errorText` - the text describing the error that will be displayed.

**Returns:**
Actually this method never returns, it throws runtime exception by itself. But the return type is defined for some cases when you would like to use the following form of call: throw error("my message");
