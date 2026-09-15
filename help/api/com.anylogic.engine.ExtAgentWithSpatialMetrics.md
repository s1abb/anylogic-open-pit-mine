# Interface ExtAgentWithSpatialMetrics

## All Superinterfaces
AgentExtension, ExtAnimationParams, Serializable

## All Known Subinterfaces
ExtAgentContinuous, ExtAgentGIS, ExtEntity

## All Known Implementing Classes
ExtAgentContinuousDelegate, ExtAgentWithSpatialMetricsDelegate, ExtEntityContinuousDelegate, ExtEntityDelegate

```java
@AnyLogicInternalAPI
public interface ExtAgentWithSpatialMetrics extends ExtAnimationParams
```

## Field Summary

### Fields inherited from interface com.anylogic.engine.AgentExtension
P_AGENT_INTERACTIVE_DELEGATE, P_AGENT_WITH_SPATIAL_METRICS_DELEGATE, P_AGENT_WITH_SPECIFIC_SPACE, P_AGENT_WITH_SPECIFIC_SPACE_DELEGATE, P_ENTITY_DELEGATE, P_ENV_WITH_SPECIFIC_SPACE, P_ROOT, P_SPACE, P_USER_EXT

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `<T extends Agent>` `List<T>` | `agentsInRange(Iterable<T> agents, double distance)` | Returns the unsorted list of agents from the given collection which are within the given distance from this agent |
| `<T extends Agent>` `List<T>` | `agentsInRange(Iterable<T> agents, double distance, LengthUnits units)` | Returns the unsorted list of agents from the given collection which are within the given distance from this agent |
| `double` | `distanceTo(double x, double y)` | Calculates the distance from this agent to a given point in the projection to the horizontal plane (i.e. agent's Z coordinate isn't used in the calculation) |
| `double` | `distanceTo(double x, double y, LengthUnits units)` | Calculates the distance from this agent to a given point in the projection to the horizontal plane (i.e. agent's Z coordinate isn't used in the calculation) |
| `double` | `distanceTo(Agent other)` | Calculates the distance from this agent to another one. The exact behavior of this method depends on the underlying space type |
| `double` | `distanceTo(Agent other, LengthUnits units)` | Calculates the distance from this agent to another one. The exact behavior of this method depends on the underlying space type |
| `double` | `distanceTo(Point point)` | Calculates the distance from this agent to the point. The exact behavior of this method depends on the underlying space type |
| `double` | `distanceTo(Point point, LengthUnits units)` | Calculates the distance from this agent to the point. The exact behavior of this method depends on the underlying space type |
| `Level` | `getLevel()` | Returns the level this agent lives in, actual for agents in continuous space |
| `<T extends Agent>` `T` | `getNearestAgent(Iterable<T> agents)` | Returns the nearest agent from the given collection |
| `INetwork` | `getNetwork()` | Returns the network this agent lives in, actual for agents in continuous space |
| `INode` | `getNetworkNode()` | Returns the network node this agent currently is located in, actual for agents in continuous space |
| `IRouteProvider` | `getRouteProvider()` | Returns the provider of routes for agent movement |
| `SpaceType` | `getSpaceType()` | Returns the type of space this agent lives in, one of SPACE_CONTINUOUS, SPACE_GIS |
| `double` | `getSpeed()` | Returns the current value of the agent speed (measured in m/s) |
| `double` | `getSpeed(SpeedUnits units)` | Returns the current value of the agent speed |
| `double` | `getTargetX()` | Returns the x of the target location if moving, otherwise current x. The exact behavior of this method depends on the underlying space type |
| `double` | `getTargetY()` | Returns the y of the target location if moving, otherwise current y. The exact behavior of this method depends on the underlying space type |
| `double` | `getVelocity()` | **Deprecated.** |
| `boolean` | `isAutomaticHorizontalRotation()` | Returns true if agent is set to be rotated (in horizontal plane) during movement, false otherwise |
| `boolean` | `isMoving()` | Tests if the agent is currently moving |
| `void` | `jumpTo(double x, double y)` | Instantly moves the agent to a given location (without changes to Z-coordinate, if any) |
| `void` | `jumpTo(INode node, Point location)` | Instantly moves the agent to a given network location |
| `void` | `jumpTo(Point location)` | Instantly moves the agent to a given location |
| `void` | `moveTo(double x, double y)` | Starts movement in the direction of the given target location |
| `void` | `moveTo(INode node, Point location)` | Starts movement to the given network node. "On arrival" code is executed when movement is finished |
| `void` | `moveTo(Point location)` | Starts movement in the direction of the given target location. "On arrival" code is executed when movement is finished |
| `void` | `moveToInTime(double x, double y, double tripTime)` | Starts movement in the direction of the given target location |
| `void` | `moveToInTime(double x, double y, double tripTime, TimeUnits units)` | Starts movement in the direction of the given target location |
| `void` | `moveToInTime(INode node, Point location, double tripTime)` | Starts movement to the given network node. Changes the speed of the agent in order to reach target in tripTime model time units. "On arrival" code is executed when movement is finished |
| `void` | `moveToInTime(INode node, Point location, double tripTime, TimeUnits units)` | Starts movement to the given network node. Changes the speed of the agent in order to reach target in tripTime model time units. "On arrival" code is executed when movement is finished |
| `void` | `moveToInTime(Point location, double tripTime)` | Starts movement in the direction of the given target location. Changes the speed of the agent in order to reach target in tripTime model time units. "On arrival" code is executed when movement is finished |
| `void` | `moveToInTime(Point location, double tripTime, TimeUnits units)` | Starts movement in the direction of the given target location. Changes the speed of the agent in order to reach target in tripTime model time units. "On arrival" code is executed when movement is finished |
| `void` | `moveToNearestAgent(Iterable<? extends Agent> agents)` | Starts movement to the nearest agent from the given collection |
| `void` | `moveToNearestAgent(Iterable<? extends Agent> agents, double tripTime)` | Starts movement to the nearest agent from the given collection |
| `void` | `moveToStraight(Point location)` | Starts straight movement in the direction of the given target location. "On arrival" code is executed when movement is finished |
| `void` | `moveToStraightInTime(Point location, double tripTime)` | Starts straight movement in the direction of the given target location. Changes the speed of the agent in order to reach target in tripTime model time units. "On arrival" code is executed when movement is finished |
| `void` | `moveToStraightInTime(Point location, double tripTime, TimeUnits units)` | Starts straight movement in the direction of the given target location. Changes the speed of the agent in order to reach target in tripTime model time units. "On arrival" code is executed when movement is finished |
| `void` | `setArrivalCallback(ArrivalCallback arrivalCallback)` | This method is designed for advanced users and library developers, for general purpose arrival processing please use "On arrival" action which can be found on the properties of Agent Type. Sets the listener which will be notified when the agent arrives (onArrival) or when the agent movement is cancelled or redirected (onCancel) |
| `void` | `setAutomaticHorizontalRotation(boolean yes)` | Tells agent to rotate automatically (in horizontal plane) during movements |
| `void` | `setLevel(Level level)` | Sets this agent to live in the level, actual for agents in continuous space |
| `void` | `setNetwork(INetwork network)` | Sets this agent to live in the network, actual for agents in continuous space |
| `void` | `setNetworkInternal(INetwork network, INode node, Position location)` | Internal method |
| `void` | `setNetworkNode(INode node)` | Sets the current network location for the agent |
| `void` | `setNetworkNode(INode node, Point position)` | **Deprecated.** |
| `void` | `setRouteProvider(IRouteProvider routeProvider)` | Stops agent If it is moving |
| `void` | `setSpeed(double speedInMPS)` | Changes speed of the agent (measured in m/s). If the agent is moving, it continues moving with the new speed |
| `void` | `setSpeed(double s, SpeedUnits units)` | Changes speed of the agent (the units of the value depend on the specific space type). If the agent is moving, it continues moving with the new speed |
| `void` | `setVelocity(double v)` | **Deprecated.** |
| `void` | `stop()` | Stops movement, if any |
| `double` | `timeToArrival()` | Returns the time to arrival to the target location, in model-time units. If the agent is not moving, returns 0 |
| `double` | `timeToArrival(TimeUnits units)` | Returns the time to arrival to the target location, in time units. If the agent is not moving, returns 0 |
| `void` | `updatePosition()` | Updates agent coordinates |

### Methods inherited from interface com.anylogic.engine.AgentExtension
getAgent, next_xjal, onDestroy, onExtensionRemoved, priority, setNext_xjal, supportsInterface_xjal

### Methods inherited from interface com.anylogic.engine.ExtAnimationParams
getAnimationPosition, getAnimationX, getAnimationY, getAnimationZ, getPresentationScaleOnOwnerSpace, getSpace, isAnimationVisible_xjal, setSpace

## Method Details

### stop
```java
void stop()
```
Stops movement, if any.

### moveTo
```java
void moveTo(double x, double y)
```
Starts movement in the direction of the given target location. Z coordinate of target is the same as the current agent's Z coordinate.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `x` - the x coordinate of the target location
- `y` - the y coordinate of the target location

### moveTo
```java
void moveTo(Point location)
```
Starts movement in the direction of the given target location.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `location` - the target location

### moveToInTime
```java
void moveToInTime(Point location, double tripTime)
```
Starts movement in the direction of the given target location.
Changes the speed of the agent in order to reach target in tripTime model time units.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `location` - the target location
- `tripTime` - the time of the movement trip

### moveToInTime
```java
void moveToInTime(Point location, double tripTime, TimeUnits units)
```
Starts movement in the direction of the given target location.
Changes the speed of the agent in order to reach target in tripTime model time units.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `location` - the target location
- `tripTime` - the time of the movement trip
- `units` - the time units

**Since:** 7.1

### moveToStraight
```java
void moveToStraight(Point location)
```
Starts straight movement in the direction of the given target location.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `location` - the target location

**Since:** 7.1

### moveToStraightInTime
```java
void moveToStraightInTime(Point location, double tripTime)
```
Starts straight movement in the direction of the given target location.
Changes the speed of the agent in order to reach target in tripTime model time units.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `location` - the target location
- `tripTime` - the time of the movement trip

**Since:** 7.1

### moveToStraightInTime
```java
void moveToStraightInTime(Point location, double tripTime, TimeUnits units)
```
Starts straight movement in the direction of the given target location.
Changes the speed of the agent in order to reach target in tripTime model time units.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `location` - the target location
- `tripTime` - the time of the movement trip
- `units` - the time units

**Since:** 7.1

### moveTo
```java
void moveTo(INode node, Point location)
```
Starts movement to the given network node.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `node` - the network node.
- `location` - (optional) location within node, may be null

### moveToInTime
```java
void moveToInTime(double x, double y, double tripTime)
```
Starts movement in the direction of the given target location. (in case of 3D space, Z coordinate of target is the same as the current agent's Z coordinate.
"On arrival" code is executed when movement is finished.
The exact behavior of this method depends on the underlying space type.

**Parameters:**
- `x` - the x coordinate of the target location
- `y` - the y coordinate of the target location
- `tripTime` - the time of the movement trip

### moveToInTime
```java
void moveToInTime(double x, double y, double tripTime, TimeUnits units)
```
Starts movement in the direction of the given target location. (in case of 3D space, Z coordinate of target is the same as the current agent's Z coordinate.
"On arrival" code is executed when movement is finished.
The exact behavior of this method depends on the underlying space type.

**Parameters:**
- `x` - the x coordinate of the target location
- `y` - the y coordinate of the target location
- `tripTime` - the time of the movement trip
- `units` - the time units

**Since:** 7.1

### moveToInTime
```java
void moveToInTime(INode node, Point location, double tripTime)
```
Starts movement to the given network node.
Changes the speed of the agent in order to reach target in tripTime model time units.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `node` - the network node.
- `location` - (optional) location within node, may be null
- `tripTime` - the time of the movement trip

### moveToInTime
```java
void moveToInTime(INode node, Point location, double tripTime, TimeUnits units)
```
Starts movement to the given network node.
Changes the speed of the agent in order to reach target in tripTime model time units.
"On arrival" code is executed when movement is finished.

**Parameters:**
- `node` - the network node.
- `location` - (optional) location within node, may be null
- `tripTime` - the time of the movement trip
- `units` - the time units

**Since:** 7.1

### jumpTo
```java
void jumpTo(double x, double y)
```
Instantly moves the agent to a given location (without changes to Z-coordinate, if any). Terminates any movement.
The exact behavior of this method depends on the underlying space type.
Doesn't call "on arrival" code

**Parameters:**
- `x` - the x coordinate of the new location
- `y` - the y coordinate of the new location

### jumpTo
```java
void jumpTo(Point location)
```
Instantly moves the agent to a given location. Terminates any movement.
Doesn't call "on arrival" code

**Parameters:**
- `location` - the new location

### jumpTo
```java
void jumpTo(INode node, Point location)
```
Instantly moves the agent to a given network location. Terminates any movement.
Doesn't call "on arrival" code

**Parameters:**
- `node` - the network node.
- `location` - (optional) location within node, may be null

### setArrivalCallback
```java
void setArrivalCallback(ArrivalCallback arrivalCallback)
```
This method is designed for advanced users and library developers, for general purpose arrival processing please use "On arrival" action which can be found on the properties of Agent Type.
Sets the listener which will be notified when the agent arrives (onArrival) or when the agent movement is cancelled or redirected (onCancel). The agent should be stopped at the time this method is called and should have no arrival callback set, otherwise this method will throw an error.
The arrival callback is automatically forgotten once notified.

**Parameters:**
- `arrivalCallback` - the listener which will be notified about agent's arrival

### moveToNearestAgent
```java
void moveToNearestAgent(Iterable<? extends Agent> agents)
```
Starts movement to the nearest agent from the given collection. Stops any current movement.

**Parameters:**
- `agents` - the collection of agents

### moveToNearestAgent
```java
void moveToNearestAgent(Iterable<? extends Agent> agents, double tripTime)
```
Starts movement to the nearest agent from the given collection. Stops any current movement.
Changes the speed of the agent in order to reach target in tripTime model time units.

**Parameters:**
- `agents` - the collection of agents
- `tripTime` - the time of the movement trip

### getNearestAgent
```java
<T extends Agent> T getNearestAgent(Iterable<T> agents)
```
Returns the nearest agent from the given collection

**Parameters:**
- `agents` - the collection of agents

**Returns:** the nearest agent (never this one) or null if the collection is empty

### agentsInRange
```java
<T extends Agent> List<T> agentsInRange(Iterable<T> agents, double distance)
```
Returns the unsorted list of agents from the given collection which are within the given distance from this agent

**Parameters:**
- `agents` - the collection of agents

**Returns:** the list of agents within the given distance, unsorted

### agentsInRange
```java
<T extends Agent> List<T> agentsInRange(Iterable<T> agents, double distance, LengthUnits units)
```
Returns the unsorted list of agents from the given collection which are within the given distance from this agent

**Parameters:**
- `agents` - the collection of agents

**Returns:** the list of agents within the given distance, unsorted

### setAutomaticHorizontalRotation
```java
void setAutomaticHorizontalRotation(boolean yes)
```
Tells agent to rotate automatically (in horizontal plane) during movements.

**Parameters:**
- `yes` - true - agent will be rotated during movement, false - rotation will not be changed

**See Also:** isAutomaticHorizontalRotation

### isAutomaticHorizontalRotation
```java
boolean isAutomaticHorizontalRotation()
```
Returns true if agent is set to be rotated (in horizontal plane) during movement, false otherwise

**Returns:** true if agent is set to be rotated during movement

**See Also:** setAutomaticHorizontalRotation(boolean)

### getTargetX
```java
double getTargetX()
```
Returns the x of the target location if moving, otherwise current x.
The exact behavior of this method depends on the underlying space type.

**Returns:** the x of the target location if moving, otherwise current x

### getTargetY
```java
double getTargetY()
```
Returns the y of the target location if moving, otherwise current y.
The exact behavior of this method depends on the underlying space type.

**Returns:** the y of the target location if moving, otherwise current y

### distanceTo
```java
double distanceTo(Agent other)
```
Calculates the distance from this agent to another one.
The exact behavior of this method depends on the underlying space type.

**Parameters:**
- `other` - another agent

**Returns:** the distance to the other agent

### distanceTo
```java
double distanceTo(Agent other, LengthUnits units)
```
Calculates the distance from this agent to another one.
The exact behavior of this method depends on the underlying space type.

**Parameters:**
- `other` - another agent
- `units` - the units of length

**Returns:** the distance to the other agent

### distanceTo
```java
double distanceTo(Point point)
```
Calculates the distance from this agent to the point.
The exact behavior of this method depends on the underlying space type.

**Parameters:**
- `point` - the point

**Returns:** the distance to the point

### distanceTo
```java
double distanceTo(Point point, LengthUnits units)
```
Calculates the distance from this agent to the point.
The exact behavior of this method depends on the underlying space type.

**Parameters:**
- `point` - the point
- `units` - the units of length

**Returns:** the distance to the point

### distanceTo
```java
double distanceTo(double x, double y)
```
Calculates the distance from this agent to a given point in the projection to the horizontal plane (i.e. agent's Z coordinate isn't used in the calculation).

**Parameters:**
- `x` - the x coordinate of the point
- `y` - the y coordinate of the point

**Returns:** the distance of Agent's projection (on the plane Z=0) to the point (x,y)

### distanceTo
```java
double distanceTo(double x, double y, LengthUnits units)
```
Calculates the distance from this agent to a given point in the projection to the horizontal plane (i.e. agent's Z coordinate isn't used in the calculation).

**Parameters:**
- `x` - the x coordinate of the point
- `y` - the y coordinate of the point
- `units` - the units of lengths

**Returns:** the distance of Agent's projection (on the plane Z=0) to the point (x,y)

**Since:** 7.1

### isMoving
```java
boolean isMoving()
```
Tests if the agent is currently moving.

**Returns:** true if the agent is moving, false otherwise

### setVelocity
```java
@Deprecated
void setVelocity(double v)
```
**Deprecated.**

Changes speed of the agent (the units of the value depend on the specific space type).
If the agent is moving, it continues moving with the new speed. Note that nonzero speed does not mean the agent is moving - it starts moving only after moveTo() is called.

**Parameters:**
- `v` - the new speed

### getVelocity
```java
@Deprecated
double getVelocity()
```
**Deprecated.**

Returns the current value of the agent speed. The units of the returned value depend on the specific space type.
Note that nonzero speed does not mean the agent is moving - it starts moving only after moveTo is called.

**Returns:** the current value of agent speed

### setSpeed
```java
void setSpeed(double speedInMPS)
```
Changes speed of the agent (measured in m/s).
If the agent is moving, it continues moving with the new speed. Note that nonzero speed does not mean the agent is moving - it starts moving only after moveTo() is called.

**Parameters:**
- `speedInMPS` - the new speed, meters per second

**Since:** 7.1

### setSpeed
```java
void setSpeed(double s, SpeedUnits units)
```
Changes speed of the agent (the units of the value depend on the specific space type).
If the agent is moving, it continues moving with the new speed. Note that nonzero speed does not mean the agent is moving - it starts moving only after moveTo() is called.

**Parameters:**
- `s` - the new speed
- `units` - the units of speed

**Since:** 7.1

### getSpeed
```java
double getSpeed()
```
Returns the current value of the agent speed (measured in m/s). The units of the returned value depend on the specific space type.
Note that nonzero speed does not mean the agent is moving - it starts moving only after moveTo is called.

**Returns:** the current value of agent speed, meters per second

**Since:** 7.1

### getSpeed
```java
double getSpeed(SpeedUnits units)
```
Returns the current value of the agent speed. The units of the returned value depend on the specific space type.
Note that nonzero speed does not mean the agent is moving - it starts moving only after moveTo is called.

**Parameters:**
- `units` - the units of speed

**Returns:** the current value of agent speed

**Since:** 7.1

### timeToArrival
```java
double timeToArrival()
```
Returns the time to arrival to the target location, in model-time units.
If the agent is not moving, returns 0.

**Returns:** the time to arrival to the target location, or 0

### timeToArrival
```java
double timeToArrival(TimeUnits units)
```
Returns the time to arrival to the target location, in time units.
If the agent is not moving, returns 0.

**Parameters:**
- `units` - the time units

**Returns:** the time to arrival to the target location, or 0

**Since:** 7.1

### updatePosition
```java
void updatePosition()
```
Updates agent coordinates

### getLevel
```java
Level getLevel()
```
Returns the level this agent lives in, actual for agents in continuous space.

**Returns:** the level this agent lives in

### setLevel
```java
void setLevel(Level level)
```
Sets this agent to live in the level, actual for agents in continuous space.

**Parameters:**
- `level` - the level this agent will live in

### getNetwork
```java
INetwork getNetwork()
```
Returns the network this agent lives in, actual for agents in continuous space.

**Returns:** the network this agent lives in

### setNetwork
```java
void setNetwork(INetwork network)
```
Sets this agent to live in the network, actual for agents in continuous space.

**Parameters:**
- `network` - the network this agent will live in

### setNetworkInternal
```java
@AnyLogicInternalAPI
void setNetworkInternal(INetwork network, INode node, Position location)
```
Internal method

### getNetworkNode
```java
INode getNetworkNode()
```
Returns the network node this agent currently is located in, actual for agents in continuous space.

**Returns:** the network node this agent currently is located in

### setNetworkNode
```java
@Deprecated
void setNetworkNode(INode node, Point position)
```
**Deprecated.**

Sets the current network location for the agent

**Parameters:**
- `node` - the network node
- `position` - (optional) location within node, may be null

### setNetworkNode
```java
void setNetworkNode(INode node)
```
Sets the current network location for the agent

**Parameters:**
- `node` - the network node

### getSpaceType
```java
SpaceType getSpaceType()
```
Returns the type of space this agent lives in, one of SPACE_CONTINUOUS, SPACE_GIS

**Returns:** one of SPACE_CONTINUOUS, SPACE_GIS

### getRouteProvider
```java
IRouteProvider getRouteProvider()
```
Returns the provider of routes for agent movement

**Returns:** the route provider

### setRouteProvider
```java
void setRouteProvider(IRouteProvider routeProvider)
```
Stops agent If it is moving. Sets the route provider for agent movement. Route provider has several implementations: network, straight movement, specific movement in GIS space such as movement by roads.

**Parameters:**
- `routeProvider` - the route provider
