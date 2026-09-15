# Package com.anylogic.engine

## Interface ExtSpace

### All Superinterfaces
AgentExtension, Serializable

```java
public interface ExtSpace
extends AgentExtension
```

This extension:
- Tracks moving agents (either straight movement or through network or on the GIS map)
- Owns animator for agents created dynamically in flowcharts and for agents which jumped from their original space (implemented using replicated embedded object presentation shape)

## Field Summary

### Fields inherited from interface com.anylogic.engine.AgentExtension
P_AGENT_INTERACTIVE_DELEGATE, P_AGENT_WITH_SPATIAL_METRICS_DELEGATE, P_AGENT_WITH_SPECIFIC_SPACE, P_AGENT_WITH_SPECIFIC_SPACE_DELEGATE, P_ENTITY_DELEGATE, P_ENV_WITH_SPECIFIC_SPACE, P_ROOT, P_SPACE, P_USER_EXT

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `void` | `addAgent(Agent a)` | Adds an agent to this space. |
| `void` | `addMovingAgent(com.anylogic.engine.AgentMovement amd)` | Adds a moving agent to this space. |
| `AbstractShapeGISMap` | `getGISMap()` | In case of GIS space, returns AbstractShapeGISMap object |
| `void` | `removeAgent(Agent a)` | Removes an agent from this space. |
| `boolean` | `removeMovingAgent(com.anylogic.engine.AgentMovement amd)` | Removes a moving agent from this space. |
| `void` | `setupSpace(AbstractShapeGISMap gisMap)` | Sets the space to be based on given gisMap. |

### Methods inherited from interface com.anylogic.engine.AgentExtension
getAgent, next_xjal, onDestroy, onExtensionRemoved, priority, setNext_xjal, supportsInterface_xjal

## Method Details

### addAgent
```java
@AnyLogicInternalAPI
void addAgent(Agent a)
```
Adds an agent to this space.

**Parameters:**
- `a` - the agent to add

### removeAgent
```java
@AnyLogicInternalAPI
void removeAgent(Agent a)
```
Removes an agent from this space.

**Parameters:**
- `a` - the agent to remove

### addMovingAgent
```java
@AnyLogicInternalAPI
void addMovingAgent(com.anylogic.engine.AgentMovement amd)
```
Adds a moving agent to this space.

**Parameters:**
- `amd` - the agent movement to add

### removeMovingAgent
```java
@AnyLogicInternalAPI
boolean removeMovingAgent(com.anylogic.engine.AgentMovement amd)
```
Removes a moving agent from this space.

**Parameters:**
- `amd` - the agent movement to remove

**Returns:** true if the agent movement was removed, false otherwise

### setupSpace
```java
@AnyLogicInternalAPI
void setupSpace(AbstractShapeGISMap gisMap)
```
Sets the space to be based on given gisMap. This method should only be called when the environment is empty.

**Parameters:**
- `gisMap` - the GIS map to use in this environment, should not be null

### getGISMap
```java
AbstractShapeGISMap getGISMap()
```
In case of GIS space, returns AbstractShapeGISMap object

**Returns:** GIS map object used in this GIS space or null for other space types

Note, that returned object has the base GIS map type and for additional services it needs to be casted to ShapeGISMap
