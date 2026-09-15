# Class AbstractMarkup

## Package
`com.anylogic.engine.markup`

## Inheritance Hierarchy
```
java.lang.Object
  com.anylogic.engine.markup.AbstractMarkup
```

## All Implemented Interfaces
`AggregatableAnimationElement`, `SVGElement`, `Serializable`

## Direct Known Subclasses
`GISMarkupElement`, `MarkupShape`

## Class Declaration
```java
@AnyLogicInternalAPI
public abstract class AbstractMarkup
extends Object
implements Serializable, SVGElement, AggregatableAnimationElement
```

**See Also:** [Serialized Form](#)

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `AbstractMarkup()` | Default constructor |

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `void` | `discardOwner()` | Discards the owner of this markup element |
| `abstract RuntimeException` | `error(String errorMessage)` | Creates an error with the specified message |
| `void` | `executeUserAction(String value)` | This method is internal and shouldn't be called by user. It may be removed/renamed in future. |
| `SVGElement` | `findSVGElement(long svgId)` | This method is internal and shouldn't be called by user. It may be removed/renamed in future. |
| `ShapeDrawMode` | `getDrawMode()` | Returns the draw mode for this markup element. Either it is drawn in 2D animation only, or in 3D only, or both in 2D and 3D. |
| `String` | `getName()` | If the markup shape is declared as field in an agent class, e.g. if it was drawn in the graphical editor, returns the name of the field. |
| `abstract Agent` | `getSpace()` | Returns the agent where the markup element is defined |
| `long` | `getSVGId()` | This method is internal and shouldn't be called by user. It may be removed/renamed in future. |
| `final void` | `initializeInternal()` | This method is internal and shouldn't be called by user. It may be removed/renamed in future. |
| `boolean` | `isPublic()` | Tests if the markup is public, i.e. if it should be drawn on the agent's parent animation. |
| `boolean` | `isVisible()` | Returns the visibility of the markup element. |
| `void` | `onAggregatorInitialized()` | Called when the aggregator is initialized |
| `void` | `onAggregatorVisibilityChanged()` | This method is internal and shouldn't be called by user. It may be removed/renamed in future. |
| `abstract void` | `remove()` | Removes the markup element from the presentation. |
| `void` | `removeSVGFromOwner(Shape oldOwner)` | This method is internal and shouldn't be called by user. It may be removed/renamed in future. |
| `void` | `resetSVGState()` | This method is internal and shouldn't be called by user. It may be removed/renamed in future. |
| `void` | `setVisible(boolean v)` | Sets the visibility of the markup element. |
| `void` | `updateDynamicProperties()` | Updates dynamic properties of this shape only (without structural contents, if any) in a given context. |
| `boolean` | `updateDynamicPropertiesStructural(boolean publicOnly)` | Updates dynamic properties of this shape and its structural contents |
| `SVGElement` | `updateSVGProperties(List<SVGCommand> output, ShapeDrawMode drawMode, boolean publicOnly, SVGElement owner, SVGElement elbehind)` | This method is internal and shouldn't be called by user. It may be removed/renamed in future. |

## Methods inherited from class java.lang.Object
`equals`, `getClass`, `hashCode`, `notify`, `notifyAll`, `toString`, `wait`, `wait`, `wait`

## Methods inherited from interface com.anylogic.engine.markup.AggregatableAnimationElement
`postInitialize`

## Constructor Details

### `AbstractMarkup()`
```java
public AbstractMarkup()
```
Default constructor

## Method Details

### `getName()`
```java
public String getName()
```
If the markup shape is declared as field in an agent class, e.g. if it was drawn in the graphical editor, returns the name of the field, otherwise returns the string #UNKNOWN_NAME. For replicated shapes returns the name of the field with the index of the shape in square brackets.

This method is designed to be used for debug/development purposes only. It has a very inefficient implementation.

**Returns:**
The name of the corresponding field or #UNKNOWN_NAME

### `getSpace()`
```java
public abstract Agent getSpace()
```
Returns the agent where the markup element is defined

**Returns:**
The agent associated with this element

### `remove()`
```java
public abstract void remove()
```
Removes the markup element from the presentation, if it is not a part of the presentation, does nothing. Please note that removal from presentation does not necessarily mean removing from the model logic as logical networks and routes may have been created before the removal and survive it.

### `getDrawMode()`
```java
public ShapeDrawMode getDrawMode()
```
Returns the draw mode for this markup element.
Either it is drawn in 2D animation only, or in 3D only, or both in 2D and 3D.

**Returns:**
The draw mode for this shape

### `setVisible(boolean v)`
```java
public void setVisible(boolean v)
```
Sets the visibility of the markup element.

**Parameters:**
- `v` - visibility: true - visible, false - not

### `isVisible()`
```java
public boolean isVisible()
```
Returns the visibility of the markup element.

**Returns:**
Visibility: true - visible, false - not

### `isPublic()`
```java
public boolean isPublic()
```
Tests if the markup is public, i.e. if it should be drawn on the agent's parent animation. If the markup is a part of a network, the markup is public only if both the network and the markup itself are public.

**Returns:**
True if the markup is public, false otherwise.

### `initializeInternal()`
```java
@AnyLogicInternalAPI
public final void initializeInternal()
```
**Description copied from interface: AggregatableAnimationElement**

This method is internal and shouldn't be called by user.
It may be removed/renamed in future.

**Specified by:**
`initializeInternal` in interface `AggregatableAnimationElement`

### `onAggregatorInitialized()`
```java
@AnyLogicInternalAPI
public void onAggregatorInitialized()
```
Called when the aggregator is initialized

### `onAggregatorVisibilityChanged()`
```java
@AnyLogicInternalAPI
public void onAggregatorVisibilityChanged()
```
**Description copied from interface: AggregatableAnimationElement**

This method is internal and shouldn't be called by user.
It may be removed/renamed in future.

**Specified by:**
`onAggregatorVisibilityChanged` in interface `AggregatableAnimationElement`

### `updateDynamicProperties()`
```java
@AnyLogicInternalCodegenAPI
public void updateDynamicProperties()
```
Updates dynamic properties of this shape only (without structural contents, if any) in a given context.
Method should be overridden for shapes with dynamic properties. Note that you should call super.updateDynamicProperties() at the end of overridden method.

### `updateDynamicPropertiesStructural(boolean publicOnly)`
```java
@AnyLogicInternalAPI
public boolean updateDynamicPropertiesStructural(boolean publicOnly)
```
Updates dynamic properties of this shape and its structural contents

**Returns:**
True if update was done (usually for visible elements, respecting public flag etc.)

### `error(String errorMessage)`
```java
public abstract RuntimeException error(String errorMessage)
```
Creates an error with the specified message

### `getSVGId()`
```java
@AnyLogicInternalAPI
public long getSVGId()
```
**Description copied from interface: SVGElement**

This method is internal and shouldn't be called by user.
It may be removed/renamed in future.

**Specified by:**
`getSVGId` in interface `SVGElement`

### `updateSVGProperties(List<SVGCommand> output, ShapeDrawMode drawMode, boolean publicOnly, SVGElement owner, SVGElement elbehind)`
```java
@AnyLogicInternalAPI
public SVGElement updateSVGProperties(List<SVGCommand> output,
                                     ShapeDrawMode drawMode,
                                     boolean publicOnly,
                                     SVGElement owner,
                                     SVGElement elbehind)
```
**Description copied from interface: SVGElement**

This method is internal and shouldn't be called by user.
It may be removed/renamed in future.

Updates SVG properties of the element that are then sent to the rendering client. If the element is not yet in the SVG scene, generates "C" command, if it is there, but some properties are out of date, generates "U" command. If SVG drawing of this element is not needed because of public only settings, or permanently not needed, or not supported yet, returns false and does nothing.

**Specified by:**
`updateSVGProperties` in interface `SVGElement`

**Parameters:**
- `output` - the list of commands to add to
- `drawMode` - TODO
- `publicOnly` - drawing context: if true, only shapes that are marked as public only are updated
- `owner` - the SVG element that serves as a container for this element
- `elbehind` - the SVG element behind this one, or null if none or if order is irrelevant

**Returns:**
The actual owner this element has been added to or null if element is not drawn (e.g. drawing of this element is not needed because of public only settings, permanently not needed or not supported - hence SVG id is not set). The actual owner may differ from the given owner when the svg element is added to a different place (e.g. GIS map).

### `resetSVGState()`
```java
@AnyLogicInternalAPI
public void resetSVGState()
```
**Description copied from interface: SVGElement**

This method is internal and shouldn't be called by user.
It may be removed/renamed in future.

**Specified by:**
`resetSVGState` in interface `SVGElement`

### `findSVGElement(long svgId)`
```java
public SVGElement findSVGElement(long svgId)
```
**Description copied from interface: SVGElement**

This method is internal and shouldn't be called by user.
It may be removed/renamed in future.

**Specified by:**
`findSVGElement` in interface `SVGElement`

### `executeUserAction(String value)`
```java
public void executeUserAction(String value)
```
**Description copied from interface: SVGElement**

This method is internal and shouldn't be called by user.
It may be removed/renamed in future.

**Specified by:**
`executeUserAction` in interface `SVGElement`

### `discardOwner()`
```java
@AnyLogicInternalAPI
public void discardOwner()
```
Discards the owner of this markup element

### `removeSVGFromOwner(Shape oldOwner)`
```java
@AnyLogicInternalAPI
public void removeSVGFromOwner(Shape oldOwner)
```
**Description copied from interface: SVGElement**

This method is internal and shouldn't be called by user.
It may be removed/renamed in future.

**Specified by:**
`removeSVGFromOwner` in interface `SVGElement`

**Parameters:**
- `oldOwner` - may be null
