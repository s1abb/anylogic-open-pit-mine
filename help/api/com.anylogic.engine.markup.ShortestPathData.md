# Class ShortestPathData&lt;N extends INode&lt;N,P&gt;,P extends IPath&lt;N&gt;&gt;

## Inheritance Hierarchy
java.lang.Object  
&nbsp;&nbsp;&nbsp;└── com.anylogic.engine.markup.ShortestPathData&lt;N,P&gt;

## Type Parameters
- `N` - network node, an instance of INode
- `P` - network path, an instance of IPath

## All Implemented Interfaces
IPathData, Serializable

## Direct Known Subclasses
ContinuousShortestPathData, GISShortestPathData

```java
public abstract class ShortestPathData<N extends INode<N,P>, P extends IPath<N>>
extends Object
implements IPathData
```

This class keeps data to move an agent through a network.

**Author:** AnyLogic North America, LLC https://anylogic.com

**See Also:** Serialized Form

## Field Summary

| Modifier and Type | Field | Description |
|-------------------|-------|-------------|
| `double` | `distance` | Distance of the path |
| `SimpleDirection` | `fromDirection` | Tells where to go from (fromPath, fromOffset) |
| `N` | `fromNode` | From node |
| `double` | `fromOffset` | From offset |
| `P` | `fromPath` | From path |
| `double` | `fromX` | From X coordinate |
| `double` | `fromY` | From Y coordinate |
| `double` | `fromZ` | From Z coordinate |
| `INetwork<N,P>` | `network` | Network |
| `Point` | `source` | Source point |
| `double` | `sourceRotation` | Source rotation |
| `double` | `sourceSegmentDistance` | Source segment distance |
| `double` | `sourceVerticalRotation` | Source vertical rotation |
| `Point` | `target` | Target point |
| `double` | `targetRotation` | Target rotation |
| `double` | `targetSegmentDistance` | Target segment distance |
| `double` | `targetVerticalRotation` | Target vertical rotation |
| `SimpleDirection` | `toDirectionReverse` | Tells from which side we come to (toPath, toOffset), in terms of target POV (the 'reverse' word stands for it) |
| `P` | `toHubIncomingPath` | To hub incoming path |
| `N` | `toNode` | To node |
| `double` | `toOffset` | To offset |
| `P` | `toPath` | To path |
| `double` | `toX` | To X coordinate |
| `double` | `toY` | To Y coordinate |
| `double` | `toZ` | To Z coordinate |

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `ShortestPathData()` | Default constructor |

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `abstract Position` | `getFromTargetPosition(double offset, Position out)` | Returns the Position object that corresponds to the point that lies at a certain distance from target point in the direction to the end point |
| `INetwork<N,P>` | `getNetwork()` | Returns the network for this path data |
| `abstract Position` | `getToSourcePosition(double offset, Position out)` | Returns the Position object that corresponds to the point that lies at a certain distance from start point in the direction to source point |
| `boolean` | `isPlainMovement()` | Checks if this shortest path data corresponds to plain movement |
| `void` | `reset()` | Resets the path data |
| `abstract void` | `resetFromTargetDirection()` | Resets the direction from target to the stored toPoint |
| `abstract void` | `resetToSourceDirection()` | Resets the direction from the stored fromPoint to the source |
| `abstract void` | `setFromTargetDirection(Point toPoint)` | Sets the direction and rotations from the target point to the specified argument point |
| `abstract void` | `setToSourceDirection(Point fromPoint)` | Sets the direction and rotations from the specified argument point to the source point |

### Methods inherited from class java.lang.Object
equals, getClass, hashCode, notify, notifyAll, toString, wait, wait, wait

## Field Details

### fromPath
```java
public P extends IPath<N> fromPath
```

### fromOffset
```java
public double fromOffset
```

### fromNode
```java
public N extends INode<N,P> fromNode
```

### fromX
```java
public double fromX
```

### fromY
```java
public double fromY
```

### fromZ
```java
public double fromZ
```

### fromDirection
```java
public SimpleDirection fromDirection
```
Tells where to go from (fromPath, fromOffset)

### toPath
```java
public P extends IPath<N> toPath
```

### toOffset
```java
public double toOffset
```

### toNode
```java
public N extends INode<N,P> toNode
```

### toX
```java
public double toX
```

### toY
```java
public double toY
```

### toZ
```java
public double toZ
```

### toDirectionReverse
```java
public SimpleDirection toDirectionReverse
```
Tells from which side we come to (toPath, toOffset), in terms of target POV (the 'reverse' word stands for it)

### toHubIncomingPath
```java
public P extends IPath<N> toHubIncomingPath
```

### distance
```java
public double distance
```

### source
```java
public Point source
```

### sourceRotation
```java
public double sourceRotation
```

### sourceVerticalRotation
```java
public double sourceVerticalRotation
```

### sourceSegmentDistance
```java
public double sourceSegmentDistance
```

### target
```java
public Point target
```

### targetRotation
```java
public double targetRotation
```

### targetVerticalRotation
```java
public double targetVerticalRotation
```

### targetSegmentDistance
```java
public double targetSegmentDistance
```

### network
```java
public INetwork<N extends INode<N,P>, P extends IPath<N>> network
```

## Constructor Details

### ShortestPathData
```java
public ShortestPathData()
```

## Method Details

### reset
```java
public void reset()
```
Resets the path data

### getNetwork
```java
public INetwork<N,P> getNetwork()
```
Returns the network for this path data

**Returns:** the network for this path data

### isPlainMovement
```java
public boolean isPlainMovement()
```
Checks if this shortest path data corresponds to plain movement

**Returns:** true if this data corresponds to plain movement, false otherwise

### setFromTargetDirection
```java
public abstract void setFromTargetDirection(Point toPoint)
```
Sets the direction and rotations from the target point to the specified argument point

**Parameters:**
- `toPoint` - point to set direction to

### setToSourceDirection
```java
public abstract void setToSourceDirection(Point fromPoint)
```
Sets the direction and rotations from the specified argument point to the source point

**Parameters:**
- `fromPoint` - point to set direction from

### resetFromTargetDirection
```java
public abstract void resetFromTargetDirection()
```
Resets the direction from target to the stored toPoint

### resetToSourceDirection
```java
public abstract void resetToSourceDirection()
```
Resets the direction from the stored fromPoint to the source

### getToSourcePosition
```java
public abstract Position getToSourcePosition(double offset, Position out)
```
Returns the Position object that corresponds to the point that lies at a certain distance from start point in the direction to source point

**Parameters:**
- `offset` - the distance
- `out` - output object, may be null

**Returns:** position at offset from start point towards source point

### getFromTargetPosition
```java
public abstract Position getFromTargetPosition(double offset, Position out)
```
Returns the Position object that corresponds to the point that lies at a certain distance from target point in the direction to the end point

**Parameters:**
- `offset` - the distance
- `out` - output object, may be null

**Returns:** position at offset from target point towards end point
