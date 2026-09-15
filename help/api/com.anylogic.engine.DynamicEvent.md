# Package com.anylogic.engine

## Class DynamicEvent

```java
java.lang.Object
  ↳ com.anylogic.engine.EventOriginator
      ↳ com.anylogic.engine.DynamicEvent
```

### All Implemented Interfaces
AgentDestroyListener, Serializable

```java
public class DynamicEvent
extends EventOriginator
implements AgentDestroyListener
```

This class is a base class for dynamic events created by the user. Dynamic events are used to schedule any number of concurrent and independent events; a typical object that uses dynamic event would be a Delay object that can delay arbitrary number of entities concurrently. The event gets scheduled when a DynamicEvent is instantiated. Upon execution of the dynamic event the instance is deleted. When the Agent is destroyed, all dynamic events belonging to it are discarded.

Memory: sizeof(EventOriginator) = 22 bytes + sizeof(HashSet entry - in AO) + user data

**Author:** AnyLogic North America, LLC https://anylogic.com

**See Also:** Serialized Form

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `DynamicEvent(Agent ao, double dt)` | A base class constructor for dynamic events. |
| `DynamicEvent(Agent ao, double t, boolean absoluteTime)` | A base class constructor for dynamic events. |
| `DynamicEvent(Agent ao, double dt, TimeUnits units)` | A base class constructor for dynamic events. |
| `DynamicEvent(Agent ao, double t, TimeUnits units, boolean absoluteTime)` | A base class constructor for dynamic events. |

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `void` | `execute()` | This method should be implemented at the subclass with a necessary call to super.execute() at the beginning. |
| `String` | `getName()` | Returns the name of the dynamic event - actually, the simple name of the dynamic event class. |
| `void` | `onDestroy(Agent agent)` | This method is internal and shouldn't be called by user. It may be removed/renamed in future. |
| `void` | `reset()` | Discards the scheduled occurrence of the event unregisters this dynamic event at the agent |

### Methods inherited from class com.anylogic.engine.EventOriginator
cancel, getActiveObject, getAgent, getFullName, getRest, getRest, isActive, isCurrent, isLoggingToDB, onDestroy, toString

### Methods inherited from class java.lang.Object
equals, getClass, hashCode, notify, notifyAll, wait, wait, wait

## Constructor Details

### DynamicEvent
```java
public DynamicEvent(Agent ao, double dt)
```
A base class constructor for dynamic events. The constructor of the subclass must call "super( agent, timeout )". Schedules the event in the timeout specified.

**Parameters:**
- `ao` - agent - event owner
- `dt` - the timeout

### DynamicEvent
```java
public DynamicEvent(Agent ao, double dt, TimeUnits units)
```
A base class constructor for dynamic events. The constructor of the subclass must call "super( agent, timeout )". Schedules the event in the timeout specified.

**Parameters:**
- `ao` - agent - event owner
- `dt` - the timeout
- `units` - the units of time

### DynamicEvent
```java
public DynamicEvent(Agent ao, double t, boolean absoluteTime)
```
A base class constructor for dynamic events. The constructor of the subclass must call "super( agent, timeout )". Schedules the event in the timeout specified.

**Parameters:**
- `ao` - agent - event owner
- `t` - the absolute time or timeout, depending on absoluteTime parameter
- `absoluteTime` - true to schedule to the given time, false - to the current time + given timeout

### DynamicEvent
```java
public DynamicEvent(Agent ao, double t, TimeUnits units, boolean absoluteTime)
```
A base class constructor for dynamic events. The constructor of the subclass must call "super( agent, timeout )". Schedules the event in the timeout specified.

**Parameters:**
- `ao` - agent - event owner
- `t` - the absolute time or timeout, depending on absoluteTime parameter
- `units` - the units of time
- `absoluteTime` - true to schedule to the given time, false - to the current time + given timeout

## Method Details

### getName
```java
public String getName()
```
Returns the name of the dynamic event - actually, the simple name of the dynamic event class.

**Specified by:**
- `getName` in class `EventOriginator`

**Returns:** The name of the dynamic event.

### reset
```java
public void reset()
```
Discards the scheduled occurrence of the event unregisters this dynamic event at the agent

### execute
```java
@AnyLogicInternalAPI
public void execute()
```
This method should be implemented at the subclass with a necessary call to super.execute() at the beginning.

### onDestroy
```java
@AnyLogicInternalAPI
public void onDestroy(Agent agent)
```
This method is internal and shouldn't be called by user.
It may be removed/renamed in future.

**Specified by:**
- `onDestroy` in interface `AgentDestroyListener`
