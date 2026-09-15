# Class AbstractLevelMarkup

## Package
`com.anylogic.engine.markup`

## Inheritance Hierarchy
```
java.lang.Object
  com.anylogic.engine.markup.AbstractMarkup
    com.anylogic.engine.markup.MarkupShape
      com.anylogic.engine.markup.AbstractLevelMarkup
```

## All Implemented Interfaces
`AggregatableAnimationElement`, `HasLevel`, `LevelElement`, `LevelMarkup`, `SVGElement`, `Serializable`

## Direct Known Subclasses
`AbstractFluidMarkup`, `AbstractWall`, `Crane`, `DensityMap`, `Elevator`, `EscalatorGroup`, `LevelGate`, `Lift`, `Pathway`, `PedFlowStatistics`, `ServiceBase`, `Storage`, `TargetLine`

## Class Declaration
```java
public abstract class AbstractLevelMarkup
extends MarkupShape
implements LevelMarkup
```

**See Also:** [Serialized Form](#)

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `AbstractLevelMarkup()` | Default constructor |
| `AbstractLevelMarkup(Agent owner, ShapeDrawMode drawMode, boolean isPublic)` | Constructor with parameters |

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `ShapeDrawMode` | `getDrawMode()` | Returns the drawing mode of the shape (where to draw this shape: 2D, 3D or 2D+3D). If the shape has been created with no-argument constructor, and has no specific limitations (like 2D-only), and drawing mode hasn't yet been set, then it is initialized to default (2D + 3D). |
| `Level` | `getLevel()` | Returns level associated with this space markup element or null if this element has no level |
| `void` | `setLevel(Level level)` | Sets the level for this element |

## Methods inherited from class com.anylogic.engine.markup.MarkupShape
`contains`, `error`, `getFullName`, `getOutsideLevelZ`, `getPresentable`, `getSpace`, `initialize`, `isClickHandled`, `isPublic`, `onClick`, `remove`, `setDrawMode`, `setOwner`

## Methods inherited from class com.anylogic.engine.markup.AbstractMarkup
`discardOwner`, `executeUserAction`, `findSVGElement`, `getName`, `getSVGId`, `initializeInternal`, `isVisible`, `onAggregatorInitialized`, `onAggregatorVisibilityChanged`, `removeSVGFromOwner`, `resetSVGState`, `setVisible`, `updateDynamicProperties`, `updateDynamicPropertiesStructural`, `updateSVGProperties`

## Methods inherited from class java.lang.Object
`equals`, `getClass`, `hashCode`, `notify`, `notifyAll`, `toString`, `wait`, `wait`, `wait`

## Methods inherited from interface com.anylogic.engine.markup.AggregatableAnimationElement
`initializeInternal`, `onAggregatorVisibilityChanged`, `postInitialize`

## Constructor Details

### `AbstractLevelMarkup()`
```java
public AbstractLevelMarkup()
```
Default constructor

### `AbstractLevelMarkup(Agent owner, ShapeDrawMode drawMode, boolean isPublic)`
```java
public AbstractLevelMarkup(Agent owner,
                          ShapeDrawMode drawMode,
                          boolean isPublic)
```
Constructor with parameters

## Method Details

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

### `setLevel(Level level)`
```java
@AnyLogicInternalAPI
public void setLevel(Level level)
```
Sets the level for this element

**Specified by:**
`setLevel` in interface `LevelElement`
