# Package com.anylogic.engine

## Interface ExtEntity

### All Superinterfaces
AgentExtension, ExtAgentWithSpatialMetrics, ExtAnimationParams, ExtDefaultAnimationProvider, Serializable

### All Known Implementing Classes
ExtEntityContinuousDelegate, ExtEntityDelegate

```java
public interface ExtEntity
extends ExtAgentWithSpatialMetrics, ExtDefaultAnimationProvider
```

## Field Summary

### Fields inherited from interface com.anylogic.engine.AgentExtension
P_AGENT_INTERACTIVE_DELEGATE, P_AGENT_WITH_SPATIAL_METRICS_DELEGATE, P_AGENT_WITH_SPECIFIC_SPACE, P_AGENT_WITH_SPECIFIC_SPACE_DELEGATE, P_ENTITY_DELEGATE, P_ENV_WITH_SPECIFIC_SPACE, P_ROOT, P_SPACE, P_USER_EXT

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `void` | `addAgentToContents(Agent agent)` | Adds a given agent to the contents of this agent. |
| `List<Agent>` | `contents()` | Returns the list of agents contained in this agent. |
| `FlowchartBlock` | `currentBlock()` | Returns the current flowchart block this agent is being processed in. |
| `void` | `destroyEntity()` | Destroys the agent. |
| `double` | `getBlockEnterTime()` | Returns the time this agent entered its current flowchart block. |
| `Color` | `getColor()` | Returns the color of the item default shape. |
| `double` | `getFlowchartEntryTime()` | Returns the time the agent has entered the first block in the flowchart, or Double.NaN if this agent hasn't yet visited any flowchart |
| `double` | `getHeight()` | Returns the height of the agent - used by conveyors and other blocks which require it during processing. |
| `double` | `getHeight(LengthUnits units)` | Returns the height of the agent - used by conveyors and other blocks which require it during processing. |
| `int` | `getId()` | Returns Id of agent. |
| `double` | `getLength()` | Returns the length of the agent - used by conveyors and other blocks which require it during processing. |
| `double` | `getLength(LengthUnits units)` | Returns the length of the agent - used by conveyors and other blocks which require it during processing. |
| `double` | `getWidth()` | Returns the width of the agent - used by conveyors and other blocks which require it during processing. |
| `double` | `getWidth(LengthUnits units)` | Returns the width of the agent - used by conveyors and other blocks which require it during processing. |
| `default void` | `highlight(boolean yes)` | Turns on/off highlighting of this agent animation. |
| `boolean` | `removeAgentFromContents(Agent agent)` | Removes the given agent from the contents of this agent. |
| `Agent` | `resourceUnitOfPool(Agent pool)` | Returns the first occurrence of resource unit of a given pool among the seized resource units, or null if not found. |
| `List<Agent>` | `resourceUnits()` | Returns the list of resource units seized by the agent, or empty list if there are none. |
| `List<Agent>` | `resourceUnitsOfPool(Agent pool)` | Returns resource units currently seized by this agent from the given ResourcePool block |
| `List<Agent>` | `resourceUnitsOfSeize(Agent seize)` | Return resource units currently seized by this agent in the given Seize block |
| `void` | `setColor(Color color)` | Sets the color of the item default shape. |
| `void` | `setFlowchartActivityType(FlowchartActivityType activityType, FlowchartBlock block)` | Sets activity type info (used in e.g. logging to DB) |
| `void` | `setHeight(double heightInMeters)` | Sets the height of the agent (in meters) |
| `void` | `setHeight(double height, LengthUnits units)` | Sets the height of the agent in the given units |
| `void` | `setLength(double lengthInMeters)` | Sets the length of the agent (in meters) |
| `void` | `setLength(double length, LengthUnits units)` | Sets the length of the agent in the given units |
| `void` | `setWidth(double widthInMeters)` | Sets the width of the agent (in meters) |
| `void` | `setWidth(double width, LengthUnits units)` | Sets the width of the agent in the given units |

### Methods inherited from interface com.anylogic.engine.AgentExtension
getAgent, next_xjal, onDestroy, onExtensionRemoved, priority, setNext_xjal, supportsInterface_xjal

### Methods inherited from interface com.anylogic.engine.ExtAgentWithSpatialMetrics
agentsInRange, agentsInRange, distanceTo, distanceTo, distanceTo, distanceTo, distanceTo, distanceTo, getLevel, getNearestAgent, getNetwork, getNetworkNode, getRouteProvider, getSpaceType, getSpeed, getSpeed, getTargetX, getTargetY, getVelocity, isAutomaticHorizontalRotation, isMoving, jumpTo, jumpTo, jumpTo, moveTo, moveTo, moveTo, moveToInTime, moveToInTime, moveToInTime, moveToInTime, moveToInTime, moveToInTime, moveToNearestAgent, moveToNearestAgent, moveToStraight, moveToStraightInTime, moveToStraightInTime, setArrivalCallback, setAutomaticHorizontalRotation, setLevel, setNetwork, setNetworkInternal, setNetworkNode, setNetworkNode, setRouteProvider, setSpeed, setSpeed, setVelocity, stop, timeToArrival, timeToArrival, updatePosition

### Methods inherited from interface com.anylogic.engine.ExtAnimationParams
getAnimationPosition, getAnimationX, getAnimationY, getAnimationZ, getPresentationScaleOnOwnerSpace, getSpace, isAnimationVisible_xjal, setSpace

### Methods inherited from interface com.anylogic.engine.ExtDefaultAnimationProvider
createDefaultAnimation, getDefaultAnimation, onClick

## Method Details

### getFlowchartEntryTime
```java
double getFlowchartEntryTime()
```
Returns the time the agent has entered the first block in the flowchart, or Double.NaN if this agent hasn't yet visited any flowchart

**Returns:** time or Double.NaN

### addAgentToContents
```java
void addAgentToContents(Agent agent)
```
Adds a given agent to the contents of this agent.

**Parameters:**
- `agent` - the agent to add

### removeAgentFromContents
```java
boolean removeAgentFromContents(Agent agent)
```
Removes the given agent from the contents of this agent.

**Parameters:**
- `agent` - the agent to remove

**Returns:** returns true if agent was removed, false if this agent didn't contain the specified agent

### getLength
```java
double getLength()
```
Returns the length of the agent - used by conveyors and other blocks which require it during processing.

**Returns:** the length of the agent

### getLength
```java
double getLength(LengthUnits units)
```
Returns the length of the agent - used by conveyors and other blocks which require it during processing.

**Parameters:**
- `units` - units of length to be used

**Returns:** the length of the agent

**Since:** 7.1

### setLength
```java
void setLength(double lengthInMeters)
```
Sets the length of the agent (in meters)

**Parameters:**
- `lengthInMeters` - the length of the agent, measured in meters

### setLength
```java
void setLength(double length, LengthUnits units)
```
Sets the length of the agent in the given units

**Parameters:**
- `length` - the length of the agent
- `units` - units of length to be used

**Since:** 7.1

### getWidth
```java
double getWidth()
```
Returns the width of the agent - used by conveyors and other blocks which require it during processing.

**Returns:** the width of the agent

### getWidth
```java
double getWidth(LengthUnits units)
```
Returns the width of the agent - used by conveyors and other blocks which require it during processing.

**Parameters:**
- `units` - units of length to be used

**Returns:** the width of the agent

**Since:** 8.2

### setWidth
```java
void setWidth(double widthInMeters)
```
Sets the width of the agent (in meters)

**Parameters:**
- `widthInMeters` - the width of the agent, measured in meters

**Since:** 8.2

### setWidth
```java
void setWidth(double width, LengthUnits units)
```
Sets the width of the agent in the given units

**Parameters:**
- `width` - the width of the agent
- `units` - units of length to be used

**Since:** 8.2

### getHeight
```java
double getHeight()
```
Returns the height of the agent - used by conveyors and other blocks which require it during processing.

**Returns:** the height of the agent

### getHeight
```java
double getHeight(LengthUnits units)
```
Returns the height of the agent - used by conveyors and other blocks which require it during processing.

**Parameters:**
- `units` - units of length to be used

**Returns:** the height of the agent

**Since:** 8.2

### setHeight
```java
void setHeight(double heightInMeters)
```
Sets the height of the agent (in meters)

**Parameters:**
- `heightInMeters` - the height of the agent, measured in meters

**Since:** 8.2

### setHeight
```java
void setHeight(double height, LengthUnits units)
```
Sets the height of the agent in the given units

**Parameters:**
- `height` - the height of the agent
- `units` - units of length to be used

**Since:** 8.2

### contents
```java
List<Agent> contents()
```
Returns the list of agents contained in this agent.

**Returns:** the list of contained agents

### resourceUnits
```java
List<Agent> resourceUnits()
```
Returns the list of resource units seized by the agent, or empty list if there are none.

**Returns:** the list of resource units seized by the agent, never returns null

### resourceUnitsOfSeize
```java
List<Agent> resourceUnitsOfSeize(Agent seize)
```
Return resource units currently seized by this agent in the given Seize block

**Parameters:**
- `seize` - Seize block

**Returns:** resource units currently seized by this agent

### resourceUnitsOfPool
```java
List<Agent> resourceUnitsOfPool(Agent pool)
```
Returns resource units currently seized by this agent from the given ResourcePool block

**Parameters:**
- `pool` - ResourcePool block

**Returns:** resource units currently seized by this agent

### resourceUnitOfPool
```java
Agent resourceUnitOfPool(Agent pool)
```
Returns the first occurrence of resource unit of a given pool among the seized resource units, or null if not found.

**Parameters:**
- `pool` - the pool of the unit (ResourcePool block)

**Returns:** the seized resource unit from the given pool, if found

### currentBlock
```java
FlowchartBlock currentBlock()
```
Returns the current flowchart block this agent is being processed in. This method is designed for agents which act as 'entities' in process flowchart diagrams.

**Returns:** the current flowchart block containing this agent or null if the agent isn't in flowchart

### getBlockEnterTime
```java
double getBlockEnterTime()
```
Returns the time this agent entered its current flowchart block.

**Returns:** the time this agent entered its current flowchart block or Double.NaN if this agent isn't in the flowchart

### setColor
```java
void setColor(Color color)
```
Sets the color of the item default shape.

**Parameters:**
- `color` - the new color of the default shape

### getId
```java
int getId()
```
Returns Id of agent. This method is designed only for debug purposes. It doesn't guarantees that id is unique.
Note that when the model produces more than ~billion agents then there may be agents with negative and even equal ids.

**Returns:** Id of agent

### getColor
```java
Color getColor()
```
Returns the color of the item default shape.

**Returns:** the color of the item default shape

### highlight
```java
default void highlight(boolean yes)
```
Turns on/off highlighting of this agent animation. The behavior of the function is specific for different agent types and usually depends on the library which drives this agent

**Parameters:**
- `yes` - true to highlight, false to remove highlighting

### destroyEntity
```java
@AnyLogicInternalAPI
void destroyEntity()
```
Destroys the agent.

### setFlowchartActivityType
```java
@AnyLogicInternalAPI
void setFlowchartActivityType(FlowchartActivityType activityType, FlowchartBlock block)
```
Sets activity type info (used in e.g. logging to DB) for the given entity

**Parameters:**
- `activityType` - the activity type
- `block` - the flowchart block

**See Also:** FlowchartActivityType
