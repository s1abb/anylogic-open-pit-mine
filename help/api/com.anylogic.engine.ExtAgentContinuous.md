# Interface ExtAgentContinuous

## All Superinterfaces
AgentExtension, ExtAgentInteractive, ExtAgentWithSpatialMetrics, ExtAnimationParams, ExtWithSpaceType, Serializable

## All Known Implementing Classes
ExtAgentContinuousDelegate, ExtEntityContinuousDelegate

```java
public interface ExtAgentContinuous
extends ExtAgentInteractive, ExtAnimationParams, ExtAgentWithSpatialMetrics, ExtWithSpaceType
```

An extension of agent designed to support agent based modeling in continuous (3D) space, in particular:
- time (continuous or discrete)
- 3D continuous space
- connections between agents, networks (e.g. social) and their visualization
- communication - message passing and broadcasting

**Author:** AnyLogic North America, LLC https://anylogic.com

## Field Summary

### Fields inherited from interface com.anylogic.engine.AgentExtension
P_AGENT_INTERACTIVE_DELEGATE, P_AGENT_WITH_SPATIAL_METRICS_DELEGATE, P_AGENT_WITH_SPECIFIC_SPACE, P_AGENT_WITH_SPECIFIC_SPACE_DELEGATE, P_ENTITY_DELEGATE, P_ENV_WITH_SPECIFIC_SPACE, P_ROOT, P_SPACE, P_USER_EXT

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `double` | `distanceTo(double x, double y)` | Calculates the distance from this agent to a given point in the projection to the horizontal plane (i.e. agent's Z coordinate isn't used in the calculation). |
| `double` | `distanceTo(double x, double y, double z)` | Calculates the distance from this agent to a given point in continuous 3D space. |
| `double` | `distanceTo(double x, double y, double z, LengthUnits units)` | Calculates the distance from this agent to a given point in continuous 3D space. |
| `double` | `distanceTo(Agent other)` | Calculates the distance from this agent to another one in continuous 3D space. |
| `double` | `distanceToSq(double x, double y)` | Calculates the square of distance from this agent to a given point in the projection to the horizontal plane (i.e. agent's Z coordinate isn't used in the calculation). |
| `double` | `distanceToSq(double x, double y, double z)` | Calculates the square of distance from this agent to a given point in continuous 3D space. (this method has better performance compared to distanceTo(double, double, double)) |
| `double` | `distanceToSq(Agent other)` | Calculates the square of distance from this agent to another one in continuous space. (this method has better performance compared to distanceTo(Agent)) |
| `double` | `getSpeed(SpeedUnits units)` | Returns the current value of the agent speed in continuous space. |
| `double` | `getTargetX()` | Returns the x of the target location if moving, otherwise current x in continuous space. |
| `double` | `getTargetY()` | Returns the y of the target location if moving, otherwise current y in continuous space. |
| `double` | `getTargetZ()` | Returns the z of the target location if moving, otherwise current z in continuous space. |
| `double` | `getVelocity()` | **Deprecated.** This function is deprecated since AnyLogic 7.1. |
| `boolean` | `isAutomaticVerticalRotation()` | Returns true if agent is set to be rotated (in vertical direction, along Z-axis) during movement in 3D, false otherwise. The returned value has no effect if ExtAgentWithSpatialMetrics.isAutomaticHorizontalRotation() is false |
| `void` | `jumpTo(double x, double y, double z)` | Instantly moves the agent to a given location. |
| `void` | `moveTo(double x, double y, double z)` | Starts movement in the direction of the given target location. "On arrival" code is executed when movement is finished. |
| `void` | `moveTo(double x, double y, double z, Path3D path)` | Starts movement in the direction of the given target location in continuous 3D space along a given path. |
| `void` | `moveTo(double x, double y, Path2D path)` | Starts movement in the direction of the given target location in continuous 3D space along a given path. |
| `void` | `moveTo(Attractor attractor)` | Starts movement to the given attractor. "On arrival" code is executed when movement is finished. |
| `void` | `moveTo(Point location, Path3D path)` | Starts movement in the direction of the given target location in continuous 3D space along a given path. |
| `void` | `moveToInTime(double x, double y, double z, double tripTime)` | Starts movement in the direction of the given target location. Changes the speed of the agent in order to reach target in tripTime model time units. "On arrival" code is executed when movement is finished. |
| `void` | `moveToInTime(double x, double y, double z, double tripTime, TimeUnits units)` | Starts movement in the direction of the given target location. Changes the speed of the agent in order to reach target in tripTime model time units. "On arrival" code is executed when movement is finished. |
| `void` | `moveToInTime(double x, double y, double z, Path3D path, double tripTime)` | Starts movement in the direction of the given target location in continuous 3D space along a given path. |
| `void` | `moveToInTime(double x, double y, double z, Path3D path, double tripTime, TimeUnits units)` | Starts movement in the direction of the given target location in continuous 3D space along a given path. |
| `void` | `moveToInTime(double x, double y, Path2D path, double tripTime)` | Starts movement in the direction of the given target location in continuous 3D space along a given path. |
| `void` | `moveToInTime(double x, double y, Path2D path, double tripTime, TimeUnits units)` | Starts movement in the direction of the given target location in continuous 3D space along a given path. |
| `void` | `moveToInTime(Attractor attractor, double tripTime)` | Starts movement to the given attractor. Changes the speed of the agent in order to reach target in tripTime model time units. "On arrival" code is executed when movement is finished. |
| `void` | `moveToInTime(Attractor attractor, double tripTime, TimeUnits units)` | Starts movement to the given attractor. Changes the speed of the agent in order to reach target in tripTime model time units. "On arrival" code is executed when movement is finished. |
| `void` | `moveToInTime(Point location, Path3D path, double tripTime)` | Starts movement in the direction of the given target location in continuous 3D space along a given path. |
| `void` | `moveToInTime(Point location, Path3D path, double tripTime, TimeUnits units)` | Starts movement in the direction of the given target location in continuous 3D space along a given path. |
| `void` | `moveToStraight(double x, double y, double z)` | Starts straight movement in the direction of the given target location. "On arrival" code is executed when movement is finished. |
| `void` | `moveToStraightInTime(double x, double y, double z, double tripTime)` | Starts straight movement in the direction of the given target location. "On arrival" code is executed when movement is finished. |
| `void` | `moveToStraightInTime(double x, double y, double z, double tripTime, TimeUnits units)` | Starts straight movement in the direction of the given target location. "On arrival" code is executed when movement is finished. |
| `void` | `setAutomaticVerticalRotation(boolean yes)` | Tells agent to rotate automatically (in vertical direction, along Z-axis) during movements in 3D. Has no effect if ExtAgentWithSpatialMetrics.isAutomaticHorizontalRotation() is false |
| `void` | `setNetworkNode(Attractor attractor)` | Sets the current network location for the agent |
| `void` | `setSpeed(double s, SpeedUnits units)` | Changes speed of the agent in continuous space (measured in the given units). If the agent is moving, it continues moving with the new speed. |
| `void` | `setVelocity(double v)` | **Deprecated.** This function is deprecated since AnyLogic 7.1. |
| `void` | `stop()` | Stops movement, if any. |
| `double` | `timeToArrival()` | Returns the time to arrival to the target location in continuous space, in model-time units. If the agent is not moving, returns 0. |

### Methods inherited from interface com.anylogic.engine.AgentExtension
getAgent, next_xjal, onDestroy, onExtensionRemoved, priority, setNext_xjal, supportsInterface_xjal

### Methods inherited from interface com.anylogic.engine.ExtAgentInteractive
addConnection_xjal, agentInfo, connectTo, copyToAndDestroyOnSpaceTypeChange_xjal, deliver, deliver, disconnectFrom, disconnectFromAll, getConnectedAgent, getConnections, getConnectionsNumber, getEnvironment, getRandomConnectedAgent, getSpaceType, isConnectedTo, receive, removeConnection_xjal, restoreConnections_xjal, send, send, setEnvironment_xjal

### Methods inherited from interface com.anylogic.engine.ExtAgentWithSpatialMetrics
agentsInRange, agentsInRange, distanceTo, distanceTo, distanceTo, distanceTo, getLevel, getNearestAgent, getNetwork, getNetworkNode, getRouteProvider, getSpaceType, getSpeed, isAutomaticHorizontalRotation, isMoving, jumpTo, jumpTo, jumpTo, moveTo, moveTo, moveTo, moveToInTime, moveToInTime, moveToInTime, moveToInTime, moveToInTime, moveToInTime, moveToNearestAgent, moveToNearestAgent, moveToStraight, moveToStraightInTime, moveToStraightInTime, setArrivalCallback, setAutomaticHorizontalRotation, setLevel, setNetwork, setNetworkInternal, setNetworkNode, setNetworkNode, setRouteProvider, setSpeed, timeToArrival, updatePosition

### Methods inherited from interface com.anylogic.engine.ExtAnimationParams
getAnimationPosition, getAnimationX, getAnimationY, getAnimationZ, getPresentationScaleOnOwnerSpace, getSpace, isAnimationVisible_xjal, setSpace

## Method Details

### setNetworkNode
```java
void setNetworkNode(Attractor attractor)
```
Sets the current network location for the agent

**Parameters:**
- `attractor` - the attractor

### stop
```java
void stop()
```
Stops movement, if any.

**Specified by:**
- `stop` in interface `ExtAgentWithSpatialMetrics`

### moveTo
```java
void moveTo(double x, double y, double z)
```
Starts movement in the direction of the given target location.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `x` - the x coordinate of the target location
- `y` - the y coordinate of the target location
- `z` - the z coordinate of the target location

### moveTo
```java
void moveTo(double x, double y, Path2D path)
```
Starts movement in the direction of the given target location in continuous 3D space along a given path. Z coordinate of target (and path points) is the same as the current agent's Z coordinate. If the agent is currently not on the path, it will first move to the closest point on the path. If the target is not on the path, the agent will move along the path to the point closest to the target, and then move to the target.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `x` - the x coordinate of the target location
- `y` - the y coordinate of the target location
- `path` - the polyline along which the agent will move

### moveTo
```java
void moveTo(Attractor attractor)
```
Starts movement to the given attractor.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `attractor` - the attractor.

### moveToInTime
```java
void moveToInTime(double x, double y, double z, double tripTime)
```
Starts movement in the direction of the given target location.
Changes the speed of the agent in order to reach target in tripTime model time units.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `x` - the x coordinate of the target location
- `y` - the y coordinate of the target location
- `z` - the z coordinate of the target location
- `tripTime` - the time of the movement trip

### moveToInTime
```java
void moveToInTime(double x, double y, double z, double tripTime, TimeUnits units)
```
Starts movement in the direction of the given target location.
Changes the speed of the agent in order to reach target in tripTime model time units.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `x` - the x coordinate of the target location
- `y` - the y coordinate of the target location
- `z` - the z coordinate of the target location
- `tripTime` - the time of the movement trip
- `units` - the time units

### moveToInTime
```java
void moveToInTime(Attractor attractor, double tripTime)
```
Starts movement to the given attractor.
Changes the speed of the agent in order to reach target in tripTime model time units.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `attractor` - the attractor.
- `tripTime` - the time of the movement trip

### moveToInTime
```java
void moveToInTime(Attractor attractor, double tripTime, TimeUnits units)
```
Starts movement to the given attractor.
Changes the speed of the agent in order to reach target in tripTime model time units.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `attractor` - the attractor.
- `tripTime` - the time of the movement trip
- `units` - the time units

### moveToInTime
```java
void moveToInTime(double x, double y, Path2D path, double tripTime)
```
Starts movement in the direction of the given target location in continuous 3D space along a given path. Z coordinate of target (and path points) is the same as the current agent's Z coordinate. If the agent is currently not on the path, it will first move to the closest point on the path. If the target is not on the path, the agent will move along the path to the point closest to the target, and then move to the target.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `x` - the x coordinate of the target location
- `y` - the y coordinate of the target location
- `path` - the polyline along which the agent will move
- `tripTime` - the time of the movement trip

### moveToInTime
```java
void moveToInTime(double x, double y, Path2D path, double tripTime, TimeUnits units)
```
Starts movement in the direction of the given target location in continuous 3D space along a given path. Z coordinate of target (and path points) is the same as the current agent's Z coordinate. If the agent is currently not on the path, it will first move to the closest point on the path. If the target is not on the path, the agent will move along the path to the point closest to the target, and then move to the target.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `x` - the x coordinate of the target location
- `y` - the y coordinate of the target location
- `path` - the polyline along which the agent will move
- `tripTime` - the time of the movement trip
- `units` - the time units

### moveTo
```java
void moveTo(Point location, Path3D path)
```
Starts movement in the direction of the given target location in continuous 3D space along a given path. If the agent is currently not on the path, it will first move to the closest point on the path. If the target is not on the path, the agent will move along the path to the point closest to the target, and then move to the target.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `location` - the target location
- `path` - the polyline along which the agent will move

### moveToInTime
```java
void moveToInTime(Point location, Path3D path, double tripTime)
```
Starts movement in the direction of the given target location in continuous 3D space along a given path. If the agent is currently not on the path, it will first move to the closest point on the path. If the target is not on the path, the agent will move along the path to the point closest to the target, and then move to the target.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `location` - the target location
- `path` - the polyline along which the agent will move
- `tripTime` - the time of the movement trip

### moveToInTime
```java
void moveToInTime(Point location, Path3D path, double tripTime, TimeUnits units)
```
Starts movement in the direction of the given target location in continuous 3D space along a given path. If the agent is currently not on the path, it will first move to the closest point on the path. If the target is not on the path, the agent will move along the path to the point closest to the target, and then move to the target.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `location` - the target location
- `path` - the polyline along which the agent will move
- `tripTime` - the time of the movement trip
- `units` - the time units

### moveTo
```java
void moveTo(double x, double y, double z, Path3D path)
```
Starts movement in the direction of the given target location in continuous 3D space along a given path. If the agent is currently not on the path, it will first move to the closest point on the path. If the target is not on the path, the agent will move along the path to the point closest to the target, and then move to the target.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `x` - the x coordinate of the target location
- `y` - the y coordinate of the target location
- `z` - the z coordinate of the target location
- `path` - the polyline along which the agent will move

### moveToInTime
```java
void moveToInTime(double x, double y, double z, Path3D path, double tripTime)
```
Starts movement in the direction of the given target location in continuous 3D space along a given path. If the agent is currently not on the path, it will first move to the closest point on the path. If the target is not on the path, the agent will move along the path to the point closest to the target, and then move to the target.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `x` - the x coordinate of the target location
- `y` - the y coordinate of the target location
- `z` - the z coordinate of the target location
- `path` - the polyline along which the agent will move
- `tripTime` - the time of the movement trip

### moveToInTime
```java
void moveToInTime(double x, double y, double z, Path3D path, double tripTime, TimeUnits units)
```
Starts movement in the direction of the given target location in continuous 3D space along a given path. If the agent is currently not on the path, it will first move to the closest point on the path. If the target is not on the path, the agent will move along the path to the point closest to the target, and then move to the target.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `x` - the x coordinate of the target location
- `y` - the y coordinate of the target location
- `z` - the z coordinate of the target location
- `path` - the polyline along which the agent will move
- `tripTime` - the time of the movement trip
- `units` - the time units

### jumpTo
```java
void jumpTo(double x, double y, double z)
```
Instantly moves the agent to a given location. Terminates any movement.
Doesn't call "on arrival" code

**Parameters:**
- `x` - the x coordinate of the new location
- `y` - the y coordinate of the new location
- `z` - the z coordinate of the new location

### moveToStraight
```java
void moveToStraight(double x, double y, double z)
```
Starts straight movement in the direction of the given target location.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `x` - the x coordinate of the target location
- `y` - the y coordinate of the target location
- `z` - the z coordinate of the target location

### moveToStraightInTime
```java
void moveToStraightInTime(double x, double y, double z, double tripTime)
```
Starts straight movement in the direction of the given target location.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `x` - the x coordinate of the target location
- `y` - the y coordinate of the target location
- `z` - the z coordinate of the target location
- `tripTime` - the time of the movement trip

**Since:** 7.1

### moveToStraightInTime
```java
void moveToStraightInTime(double x, double y, double z, double tripTime, TimeUnits units)
```
Starts straight movement in the direction of the given target location.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `x` - the x coordinate of the target location
- `y` - the y coordinate of the target location
- `z` - the z coordinate of the target location
- `tripTime` - the time of the movement trip
- `units` - the time units

**Since:** 7.1

### setAutomaticVerticalRotation
```java
void setAutomaticVerticalRotation(boolean yes)
```
Tells agent to rotate automatically (in vertical direction, along Z-axis) during movements in 3D.
Has no effect if ExtAgentWithSpatialMetrics.isAutomaticHorizontalRotation() is false

**Parameters:**
- `yes` - true - agent will be rotated during movement (e.g. box travelling on conveyor slope), false - rotation will not be changed (e.g. passenger going upstairs)

**See Also:** Agent.setVerticalRotation(double)

### isAutomaticVerticalRotation
```java
boolean isAutomaticVerticalRotation()
```
Returns true if agent is set to be rotated (in vertical direction, along Z-axis) during movement in 3D, false otherwise.
The returned value has no effect if ExtAgentWithSpatialMetrics.isAutomaticHorizontalRotation() is false

**Returns:** true if agent is set to be rotated during movement (e.g. box travelling on conveyor slope), false - rotation will not be changed (e.g. passenger going upstairs)

**See Also:** setAutomaticVerticalRotation(boolean)

### getTargetX
```java
double getTargetX()
```
Returns the x of the target location if moving, otherwise current x in continuous space.

**Specified by:** getTargetX in interface ExtAgentWithSpatialMetrics

**Returns:** the x of the target location if moving, otherwise current x

### getTargetY
```java
double getTargetY()
```
Returns the y of the target location if moving, otherwise current y in continuous space.

**Specified by:** getTargetY in interface ExtAgentWithSpatialMetrics

**Returns:** the y of the target location if moving, otherwise current y

### getTargetZ
```java
double getTargetZ()
```
Returns the z of the target location if moving, otherwise current z in continuous space.

**Returns:** the z of the target location if moving, otherwise current z

### distanceTo
```java
double distanceTo(Agent other)
```
Calculates the distance from this agent to another one in continuous 3D space.

**Specified by:** distanceTo in interface ExtAgentWithSpatialMetrics

**Parameters:**
- `other` - another agent

**Returns:** the distance to the other agent (in pixels)

### distanceToSq
```java
double distanceToSq(Agent other)
```
Calculates the square of distance from this agent to another one in continuous space.
(this method has better performance compared to distanceTo(Agent))

**Parameters:**
- `other` - another agent

**Returns:** the square of distance to the other agent

### distanceTo
```java
double distanceTo(double x, double y)
```
Calculates the distance from this agent to a given point in the projection to the horizontal plane (i.e. agent's Z coordinate isn't used in the calculation).

**Specified by:** distanceTo in interface ExtAgentWithSpatialMetrics

**Parameters:**
- `x` - the x coordinate of the point
- `y` - the y coordinate of the point

**Returns:** the distance of Agent's projection (on the plane Z=0) to the point (x,y) (in pixels)

### distanceToSq
```java
double distanceToSq(double x, double y)
```
Calculates the square of distance from this agent to a given point in the projection to the horizontal plane (i.e. agent's Z coordinate isn't used in the calculation).
(this method has better performance compared to distanceTo(double, double))

**Parameters:**
- `x` - the x coordinate of the point
- `y` - the y coordinate of the point

**Returns:** the square of distance of Agent's projection (on the plane Z=0) to the point (x,y)

### distanceTo
```java
double distanceTo(double x, double y, double z)
```
Calculates the distance from this agent to a given point in continuous 3D space.

**Parameters:**
- `x` - the x coordinate of the point
- `y` - the y coordinate of the point
- `z` - the z coordinate of the point

**Returns:** the distance to the point (x,y,z) (in pixels)

### distanceTo
```java
double distanceTo(double x, double y, double z, LengthUnits units)
```
Calculates the distance from this agent to a given point in continuous 3D space.

**Parameters:**
- `x` - the x coordinate of the point
- `y` - the y coordinate of the point
- `z` - the z coordinate of the point
- `units` - the length units

**Returns:** the distance to the point (x,y,z)

### distanceToSq
```java
double distanceToSq(double x, double y, double z)
```
Calculates the square of distance from this agent to a given point in continuous 3D space.
(this method has better performance compared to distanceTo(double, double, double))

**Parameters:**
- `x` - the x coordinate of the point
- `y` - the y coordinate of the point
- `z` - the z coordinate of the point

**Returns:** the square of distance to the point (x,y,z)

### setVelocity
```java
@Deprecated
void setVelocity(double v)
```
**Deprecated.** This function is deprecated since AnyLogic 7.1. Please use setSpeed(double, SpeedUnits) instead

Changes speed of the agent in continuous space (measured in pixels per model-time-unit).
If the agent is moving, it continues moving with the new speed. Note that nonzero speed does not mean the agent is moving - it starts moving only after moveTo() is called.

**Specified by:** setVelocity in interface ExtAgentWithSpatialMetrics

**Parameters:**
- `v` - the new speed

### getVelocity
```java
@Deprecated
double getVelocity()
```
**Deprecated.** This function is deprecated since AnyLogic 7.1. Please use #getSpeed(double, SpeedUnits) instead

Returns the current value of the agent speed in continuous space. (measured in pixels per model-time-unit).
Note that nonzero speed does not mean the agent is moving - it starts moving only after moveTo is called.

**Specified by:** getVelocity in interface ExtAgentWithSpatialMetrics

**Returns:** the current value of agent speed

### setSpeed
```java
void setSpeed(double s, SpeedUnits units)
```
Changes speed of the agent in continuous space (measured in the given units).
If the agent is moving, it continues moving with the new speed. Note that nonzero speed does not mean the agent is moving - it starts moving only after moveTo() is called.

**Specified by:** setSpeed in interface ExtAgentWithSpatialMetrics

**Parameters:**
- `s` - the new speed
- `units` - the speed units

### getSpeed
```java
double getSpeed(SpeedUnits units)
```
Returns the current value of the agent speed in continuous space. (measured in the given units).
Note that nonzero speed does not mean the agent is moving - it starts moving only after moveTo is called.

**Specified by:** getSpeed in interface ExtAgentWithSpatialMetrics

**Parameters:**
- `units` - the speed units

**Returns:** the current value of agent speed

### timeToArrival
```java
double timeToArrival()
```
Returns the time to arrival to the target location in continuous space, in model-time units.
If the agent is not moving, returns 0.

**Specified by:** timeToArrival in interface ExtAgentWithSpatialMetrics

**Returns:** the time to arrival to the target location, or 0
