# Interface ExtAnimationParams

## All Superinterfaces
AgentExtension, Serializable

## All Known Subinterfaces
ExtAgentContinuous, ExtAgentDiscrete, ExtAgentGIS, ExtAgentWithSpatialMetrics, ExtEntity

## All Known Implementing Classes
ExtAgentContinuousDelegate, ExtAgentWithSpatialMetricsDelegate, ExtEntityContinuousDelegate, ExtEntityDelegate

```java
@AnyLogicInternalAPI
public interface ExtAnimationParams extends AgentExtension
```

## Field Summary

### Fields inherited from interface com.anylogic.engine.AgentExtension
P_AGENT_INTERACTIVE_DELEGATE, P_AGENT_WITH_SPATIAL_METRICS_DELEGATE, P_AGENT_WITH_SPECIFIC_SPACE, P_AGENT_WITH_SPECIFIC_SPACE_DELEGATE, P_ENTITY_DELEGATE, P_ENV_WITH_SPECIFIC_SPACE, P_ROOT, P_SPACE, P_USER_EXT

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `Position` | `getAnimationPosition(Position out)` | Gets the animation position |
| `double` | `getAnimationX()` | Gets the animation X coordinate |
| `double` | `getAnimationY()` | Gets the animation Y coordinate |
| `double` | `getAnimationZ()` | Gets the animation Z coordinate |
| `double` | `getPresentationScaleOnOwnerSpace()` | Returns the scale of the agent presentation animation on its space or 1.0 if space isn't defined or agent list is empty |
| `Agent` | `getSpace()` | Returns the agent representing space this agent lives in |
| `boolean` | `isAnimationVisible_xjal()` | Checks if animation is visible |
| `void` | `setSpace(Agent space)` | Sets the space for agent |

### Methods inherited from interface com.anylogic.engine.AgentExtension
getAgent, next_xjal, onDestroy, onExtensionRemoved, priority, setNext_xjal, supportsInterface_xjal

## Method Details

### setSpace
```java
void setSpace(Agent space)
```
Sets the space for agent. Shouldn't be called for moving agents. Coordinates and rotations are left "as is"

**Parameters:**
- `space` - the agent representing space this agent will live in

### getSpace
```java
Agent getSpace()
```
Returns the agent representing space this agent lives in

**Returns:** the agent representing space this agent lives in

### getAnimationX
```java
double getAnimationX()
```
Gets the animation X coordinate

**Returns:** the animation X coordinate

### getAnimationY
```java
double getAnimationY()
```
Gets the animation Y coordinate

**Returns:** the animation Y coordinate

### getAnimationZ
```java
double getAnimationZ()
```
Gets the animation Z coordinate

**Returns:** the animation Z coordinate

### getAnimationPosition
```java
Position getAnimationPosition(Position out)
```
Gets the animation position

**Parameters:**
- `out` - output position object, may be null

**Returns:** the animation position

### getPresentationScaleOnOwnerSpace
```java
@AnyLogicInternalCodegenAPI
double getPresentationScaleOnOwnerSpace()
```
Returns the scale of the agent presentation animation on its space or 1.0 if space isn't defined or agent list is empty

**Returns:** the scale of presentation animation on owner space

### isAnimationVisible_xjal
```java
@AnyLogicInternalAPI
boolean isAnimationVisible_xjal()
```
Checks if animation is visible

**Returns:** true if animation is visible, false otherwise
