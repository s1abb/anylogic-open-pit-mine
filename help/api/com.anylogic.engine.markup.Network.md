# Class Network

## Package
`com.anylogic.engine.markup`

## Inheritance Hierarchy
```
java.lang.Object
  com.anylogic.engine.markup.AbstractMarkupAggregator<Owner>
    com.anylogic.engine.markup.AbstractNetwork<Node,Path,Agent>
      com.anylogic.engine.markup.Network
```

## All Implemented Interfaces
`IRouteProvider<ShortestPathData<Node,Path>>`, `AggregatableAnimationElement`, `HasLevel`, `INetwork<Node,Path>`, `LevelElement`, `LevelMarkup`, `Serializable`

## Class Declaration
```java
public class Network
extends AbstractNetwork<Node,Path,Agent>
implements LevelMarkup, AggregatableAnimationElement
```

Implementation of network for agent movement in continuous space.

**Author:** AnyLogic North America, LLC https://anylogic.com

**See Also:** [Serialized Form](#)

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `Network(Agent owner, String name)` | Creates a network with a specified owner and name |
| `Network(Agent owner, String name, ShapeDrawMode drawMode, double z)` | **Deprecated.** Deprecated in version 8.5.0, will be removed in the future releases. |
| `Network(Agent owner, String name, ShapeDrawMode drawMode, double z, boolean isPublic, boolean visible)` | **Deprecated.** Deprecated in version 8.5.0, will be removed in the future releases. |
| `Network(Agent owner, String name, ShapeDrawMode drawMode, double z, boolean isPublic, boolean visible, NetworkMarkupElement... markupShapes)` | **Deprecated.** Deprecated in version 8.5.0, will be removed in the future releases. |

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `void` | `add(PalletRack palletRack)` | Adds a pallet rack to the network. |
| `void` | `addAll(NetworkMarkupElement... markupShapes)` | Adds all arguments to the network |
| `static NetworkPort` | `createPort(Agent owner, Path path, PathEndType type)` | **Deprecated.** |
| `Stream<? extends AbstractMarkup>` | `elementsInternal()` | This method is internal and shouldn't be called by user. |
| `BoundingRectangle` | `getBoundingRectangle()` | Gets the bounding rectangle of the network |
| `final Class<? extends ExtAgentWithSpatialMetrics>` | `getCompatibleAgentExtensionClass()` | This method is internal and shouldn't be called by user. |
| `ShapeDrawMode` | `getDrawMode()` | Returns the drawing mode of the shape (either 2D, 3D, or 2D&3D). |
| `Level` | `getLevel()` | Returns the level where this network is located. |
| `List<PalletRack>` | `getPalletRacks()` | Returns List of all PalletRack in the network. |
| `double` | `getPlainDistance(Point firstPoint, Point secondPoint)` | See Point.distance(Point) |
| `Agent` | `getSpace()` | Returns the space where the space markup element is defined |
| `double` | `getZ()` | Returns the z-coordinate of the base level. |
| `void` | `setDrawMode(ShapeDrawMode drawMode)` | Sets the drawing mode of the shape (either 2D, 3D, or 2D&3D). |
| `void` | `setLevel(Level level)` | Sets the new level where this network will be located. |
| `void` | `setZ(double z)` | Sets the z-coordinate of the base level. |

## Methods inherited from class com.anylogic.engine.markup.AbstractNetwork
`add`, `add`, `getDistance`, `getDistance`, `getDistance`, `getDistance`, `getDistance`, `getDistance`, `getDistance`, `getDistance`, `getDistance`, `getDistance`, `getDistance`, `getDistance`, `getDistance`, `getDistance`, `getDistance`, `getDistance`, `getDistance`, `getDistance`, `getDistance`, `getLength`, `getNearestNetworkElement`, `getNearestNetworkElement`, `getNearestNetworkElement`, `getNearestNode`, `getNearestNode`, `getNearestNode`, `getNearestNode`, `getNearestPath`, `getNearestPath`, `getNearestPath`, `getNode`, `getNodeCount`, `getPath`, `getPathCount`, `getPathData`, `getPlainDistance`, `getPosition`, `getPosition`, `getPositionAtOffset`, `getRelatedNetworks`, `nodes`, `paths`, `ports`

## Methods inherited from class com.anylogic.engine.markup.AbstractMarkupAggregator
`error`, `getName`, `getOwner`, `initializeInternal`, `isVisible`, `onAggregatorVisibilityChanged`, `setVisible`

## Methods inherited from class java.lang.Object
`equals`, `getClass`, `hashCode`, `notify`, `notifyAll`, `toString`, `wait`, `wait`, `wait`

## Methods inherited from interface com.anylogic.engine.markup.AggregatableAnimationElement
`initializeInternal`, `onAggregatorVisibilityChanged`, `postInitialize`

## Constructor Details

### `Network(Agent owner, String name)`
```java
public Network(Agent owner,
              String name)
```
Creates a network with a specified owner and name

**Parameters:**
- `owner` - the agent to whom this new instance belongs
- `name` - the name of the network

### `Network(Agent owner, String name, ShapeDrawMode drawMode, double z)`
```java
@Deprecated
public Network(Agent owner,
              String name,
              ShapeDrawMode drawMode,
              double z)
```
**Deprecated.**
Deprecated in version 8.5.0, will be removed in the future releases. Use Network(Agent, String)

### `Network(Agent owner, String name, ShapeDrawMode drawMode, double z, boolean isPublic, boolean visible)`
```java
@Deprecated
public Network(Agent owner,
              String name,
              ShapeDrawMode drawMode,
              double z,
              boolean isPublic,
              boolean visible)
```
**Deprecated.**
Deprecated in version 8.5.0, will be removed in the future releases. Use Network(Agent, String)

### `Network(Agent owner, String name, ShapeDrawMode drawMode, double z, boolean isPublic, boolean visible, NetworkMarkupElement... markupShapes)`
```java
@Deprecated
public Network(Agent owner,
              String name,
              ShapeDrawMode drawMode,
              double z,
              boolean isPublic,
              boolean visible,
              NetworkMarkupElement... markupShapes)
```
**Deprecated.**
Deprecated in version 8.5.0, will be removed in the future releases. Use Network(Agent, String)

## Method Details

### `elementsInternal()`
```java
@AnyLogicInternalAPI
public Stream<? extends AbstractMarkup> elementsInternal()
```
**Description copied from class: AbstractMarkupAggregator**

This method is internal and shouldn't be called by user.
It may be removed/renamed in future.

**Specified by:**
`elementsInternal` in class `AbstractMarkupAggregator<Agent>`

### `addAll(NetworkMarkupElement... markupShapes)`
```java
public void addAll(NetworkMarkupElement... markupShapes)
```
Adds all arguments to the network

**Parameters:**
- `markupShapes` - an instance of any of the following classes: Node, Path, PalletRack

### `setDrawMode(ShapeDrawMode drawMode)`
```java
public void setDrawMode(ShapeDrawMode drawMode)
```
Sets the drawing mode of the shape (either 2D, 3D, or 2D&3D).
This method may be called only once and only for the shapes which are created using a no-argument constructor (since they have no limitations on the drawing mode, e.g. 3D only). Any subsequent call for a shape that has the drawing mode already set, will throw an error.

**Parameters:**
- `drawMode` - where to draw this shape: 2D, 3D, or 2D&3D

### `getDrawMode()`
```java
public ShapeDrawMode getDrawMode()
```
Returns the drawing mode of the shape (either 2D, 3D, or 2D&3D).
If the shape has been created with a no-argument constructor, has no specific limitations on the drawing mode (e.g., 2D only), and its drawing mode hasn't been set yet, then it is initialized to the default 2D&3D drawing mode.

### `setZ(double z)`
```java
public void setZ(double z)
```
Sets the z-coordinate of the base level. The elements in the network will have their z-coordinates calculated as relative to this level.

**Parameters:**
- `z` - the z-coordinate of the base level

### `getZ()`
```java
public double getZ()
```
Returns the z-coordinate of the base level. The elements in the network will have their z-coordinates calculated as relative to this level.

**Returns:**
The z-coordinate of the base level

### `add(PalletRack palletRack)`
```java
public void add(PalletRack palletRack)
```
Adds a pallet rack to the network.

**Parameters:**
- `palletRack` - a pallet rack to be added to the network

### `getPalletRacks()`
```java
public List<PalletRack> getPalletRacks()
```
Returns List of all PalletRack in the network.

**Returns:**
A list of all pallet racks located in this network

### `getSpace()`
```java
public Agent getSpace()
```
Returns the space where the space markup element is defined

**Specified by:**
`getSpace` in interface `INetwork<Node,Path>`

**Returns:**
The space associated with this element

### `getLevel()`
```java
public Level getLevel()
```
Returns the level where this network is located.

**Specified by:**
`getLevel` in interface `HasLevel`

**Returns:**
Network level

### `setLevel(Level level)`
```java
public void setLevel(Level level)
```
Sets the new level where this network will be located.

**Specified by:**
`setLevel` in interface `LevelElement`

**Parameters:**
- `level` - the new level

### `getPlainDistance(Point firstPoint, Point secondPoint)`
```java
public double getPlainDistance(Point firstPoint,
                              Point secondPoint)
```
See Point.distance(Point)

**Specified by:**
`getPlainDistance` in interface `INetwork<Node,Path>`

**Specified by:**
`getPlainDistance` in class `AbstractNetwork<Node,Path,Agent>`

**Returns:**
Distance between two points

### `getCompatibleAgentExtensionClass()`
```java
@AnyLogicInternalAPI
public final Class<? extends ExtAgentWithSpatialMetrics> getCompatibleAgentExtensionClass()
```
**Description copied from interface: INetwork**

This method is internal and shouldn't be called by user.
It may be removed/renamed in future.

**Specified by:**
`getCompatibleAgentExtensionClass` in interface `INetwork<Node,Path>`

### `createPort(Agent owner, Path path, PathEndType type)`
```java
@Deprecated
public static NetworkPort createPort(Agent owner,
                                    Path path,
                                    PathEndType type)
```
**Deprecated.**

Creates NetworkPort on the specified path. Note, that this network port should be paired with another one for correct behavior. See MarkupPort.setPairedPort(MarkupPort)

**Parameters:**
- `owner` - the created network port will belong to this agent
- `path` - the created network port will be connected to this path
- `type` - determines the location of the specified path's ending point

**Returns:**
A new network port connected to the specified path

### `getBoundingRectangle()`
```java
@AnyLogicInternalAPI
public BoundingRectangle getBoundingRectangle()
```
Gets the bounding rectangle of the network
