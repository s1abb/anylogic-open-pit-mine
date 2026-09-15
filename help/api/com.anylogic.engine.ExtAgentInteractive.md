# Interface ExtAgentInteractive

## All Superinterfaces
AgentExtension, Serializable

## All Known Subinterfaces
ExtAgentContinuous, ExtAgentDiscrete, ExtAgentGIS

## All Known Implementing Classes
ExtAgentContinuousDelegate, ExtEntityContinuousDelegate

```java
public interface ExtAgentInteractive extends AgentExtension
```

An extension of Agent designed to support agent communication, in particular:
- time (continuous or discrete)
- connections between agents, networks (e.g. social) and their visualization
- communication - message passing and broadcasting

Also, there are several extension classes for different space types.

**Author:** AnyLogic North America, LLC https://anylogic.com

## Field Summary

### Fields inherited from interface com.anylogic.engine.AgentExtension
P_AGENT_INTERACTIVE_DELEGATE, P_AGENT_WITH_SPATIAL_METRICS_DELEGATE, P_AGENT_WITH_SPECIFIC_SPACE, P_AGENT_WITH_SPECIFIC_SPACE_DELEGATE, P_ENTITY_DELEGATE, P_ENV_WITH_SPECIFIC_SPACE, P_ROOT, P_SPACE, P_USER_EXT

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `void` | `addConnection_xjal(Agent a)` | This method is internal and shouldn't be called by user. It may be removed/renamed in future |
| `String` | `agentInfo()` | Returns information about the agent |
| `boolean` | `connectTo(Agent a)` | Creates a bi-directional connection between this agent and a given other agent |
| `void` | `copyToAndDestroyOnSpaceTypeChange_xjal(ExtAgentInteractive newExt)` | Internal method |
| `void` | `deliver(Object msg, Agent dest)` | Delivers a message to a given agent immediately during this method call |
| `void` | `deliver(Object msg, MessageDeliveryType mode)` | Delivers a message to an agent or a group of agents, as specified by the mode parameter immediately during this method call |
| `boolean` | `disconnectFrom(Agent a)` | Disconnects this agent from another given agent |
| `void` | `disconnectFromAll()` | Disconnects the agent from all other agents |
| `Agent` | `getConnectedAgent(int index)` | Returns the connected agent with a given index |
| `<T extends Agent>` `List<T>` | `getConnections()` | Returns a collection of agents connected to this agent (bi-directionally), or empty collection if there have not been any connections yet |
| `int` | `getConnectionsNumber()` | Returns the number of agents connected to this agent |
| `Agent` | `getEnvironment()` | Returns the environment where this agent belongs to |
| `Agent` | `getRandomConnectedAgent()` | Returns the randomly chosen connected agent |
| `SpaceType` | `getSpaceType()` | Returns the type of space this agent lives in, one of SPACE_CONTINUOUS, SPACE_DISCRETE, SPACE_GIS, SPACE_NONE |
| `boolean` | `isConnectedTo(Agent a)` | Tests if this agent is connected to a given other agent |
| `void` | `receive(Object msg)` | Immediately delivers a message to this agent |
| `void` | `removeConnection_xjal(Agent a)` | This method is internal and shouldn't be called by user. It may be removed/renamed in future |
| `void` | `restoreConnections_xjal(List<?> connections)` | **Deprecated.** This method is internal and shouldn't be called by user. It may be removed/renamed in future |
| `void` | `send(Object msg, Agent dest)` | Sends a message to a given agent |
| `void` | `send(Object msg, MessageDeliveryType mode)` | Sends a message to an agent or a group of agents, as specified by the mode parameter |
| `void` | `setEnvironment_xjal(Agent environment)` | This method is internal and shouldn't be called by user. It may be removed/renamed in future |

### Methods inherited from interface com.anylogic.engine.AgentExtension
getAgent, next_xjal, onDestroy, onExtensionRemoved, priority, setNext_xjal, supportsInterface_xjal

## Method Details

### getEnvironment
```java
Agent getEnvironment()
```
Returns the environment where this agent belongs to.

**Returns:** the environment where this agent belongs to

### getConnections
```java
<T extends Agent> List<T> getConnections()
```
Returns a collection of agents connected to this agent (bi-directionally), or empty collection if there have not been any connections yet. You should not modify this collection.

**Returns:** collection of connected agents, may be empty

### getConnectionsNumber
```java
int getConnectionsNumber()
```
Returns the number of agents connected to this agent.

**Returns:** the number of agents connected to this agent

### getConnectedAgent
```java
Agent getConnectedAgent(int index)
```
Returns the connected agent with a given index.

**Parameters:**
- `index` - the index of connection

**Returns:** the connected agent with a given index

### getRandomConnectedAgent
```java
Agent getRandomConnectedAgent()
```
Returns the randomly chosen connected agent.

**Returns:** the connected agent

### isConnectedTo
```java
boolean isConnectedTo(Agent a)
```
Tests if this agent is connected to a given other agent.

**Parameters:**
- `a` - another agent

**Returns:** true if the agents are connected, false otherwise

### connectTo
```java
boolean connectTo(Agent a)
```
Creates a bi-directional connection between this agent and a given other agent. Raises error if you try to connect to itself. Does nothing and returns false if agents are already connected.

**Parameters:**
- `a` - another agent

**Returns:** true if was not connected before, false if was already connected

### disconnectFrom
```java
boolean disconnectFrom(Agent a)
```
Disconnects this agent from another given agent.

**Parameters:**
- `a` - another agent

**Returns:** true if the agents were connected, false otherwise

### disconnectFromAll
```java
void disconnectFromAll()
```
Disconnects the agent from all other agents.

### send
```java
void send(Object msg, Agent dest)
```
Sends a message to a given agent. The message will be delivered during a separate event scheduled to occur in zero time after the current one. If you are OK with the message delivered immediately during this event, use deliver() method, which has better performance.

**Parameters:**
- `msg` - a message
- `dest` - the destination agent

### send
```java
void send(Object msg, MessageDeliveryType mode)
```
Sends a message to an agent or a group of agents, as specified by the mode parameter. The message will be delivered during a separate event scheduled to occur in zero time after the current one. If you are OK with the message delivered immediately during this event, use deliver() method, which has better performance.

**Parameters:**
- `msg` - a message
- `mode` - specifies the message sending mode (ALL, RANDOM, ...)

### deliver
```java
void deliver(Object msg, Agent dest)
```
Delivers a message to a given agent immediately during this method call. If you wish this to happen in a separate event, use send() method.

**Parameters:**
- `msg` - a message
- `dest` - the destination agent

### deliver
```java
void deliver(Object msg, MessageDeliveryType mode)
```
Delivers a message to an agent or a group of agents, as specified by the mode parameter immediately during this method call. If you wish this to happen in a separate event, use send() method.

**Parameters:**
- `msg` - the message
- `mode` - specifies the message sending mode (ALL, RANDOM, ...)

### receive
```java
void receive(Object msg)
```
Immediately delivers a message to this agent. Sender is set to null.

**Parameters:**
- `msg` - the message

### agentInfo
```java
String agentInfo()
```
Returns information about the agent.

**Returns:** information about the agent

### getSpaceType
```java
SpaceType getSpaceType()
```
Returns the type of space this agent lives in, one of SPACE_CONTINUOUS, SPACE_DISCRETE, SPACE_GIS, SPACE_NONE

**Returns:** one of SPACE_CONTINUOUS, SPACE_DISCRETE, SPACE_GIS, SPACE_NONE

### setEnvironment_xjal
```java
@AnyLogicInternalAPI
void setEnvironment_xjal(Agent environment)
```
This method is internal and shouldn't be called by user.
It may be removed/renamed in future

**Parameters:**
- `environment` - the environment

### addConnection_xjal
```java
@AnyLogicInternalAPI
void addConnection_xjal(Agent a)
```
This method is internal and shouldn't be called by user.
It may be removed/renamed in future

**Parameters:**
- `a` - the agent to connect to

### removeConnection_xjal
```java
@AnyLogicInternalAPI
void removeConnection_xjal(Agent a)
```
This method is internal and shouldn't be called by user.
It may be removed/renamed in future

**Parameters:**
- `a` - the agent to disconnect from

### restoreConnections_xjal
```java
@AnyLogicInternalAPI
@Deprecated
void restoreConnections_xjal(List<?> connections)
```
**Deprecated.**

This method is internal and shouldn't be called by user.
It may be removed/renamed in future

**Parameters:**
- `connections` - the connections to restore

### copyToAndDestroyOnSpaceTypeChange_xjal
```java
@AnyLogicInternalAPI
void copyToAndDestroyOnSpaceTypeChange_xjal(ExtAgentInteractive newExt)
```
Internal method for copying agent data when changing space type.

**Parameters:**
- `newExt` - the new extension to copy data to
