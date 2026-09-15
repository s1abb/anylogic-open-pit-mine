# Package com.anylogic.engine

## Class EventOriginator

```java
java.lang.Object
  ↳ com.anylogic.engine.EventOriginator
```

### All Implemented Interfaces
Serializable

### Direct Known Subclasses
DynamicEvent, Event, Transition

```java
public abstract class EventOriginator
extends Object
implements Serializable
```

Base class for all constructs in AnyLogic modeling language that are able to schedule discrete events, like Event, DynamicEvent and Transition.

Memory: sizeof(Object) + 8 bytes = 22 bytes

**Author:** AnyLogic North America, LLC https://anylogic.com

**See Also:** Serialized Form

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `void` | `cancel()` | **Deprecated.** User should not call this method for events, call reset() instead |
| `Agent` | `getActiveObject()` | **Deprecated.** Use getAgent() instead |
| `Agent` | `getAgent()` | Returns the agent that owns the event originator. |
| `String` | `getFullName()` | Returns the name of the event originator prefixed by the full name of its agent. |
| `abstract String` | `getName()` | Returns the name of the event originator, i.e. the name of an event or a transition object specified by the user. |
| `double` | `getRest()` | Returns the time remaining before the scheduled occurrence of the event, or +infinity if the event is not scheduled. |
| `double` | `getRest(TimeUnits units)` | Returns the time remaining before the scheduled occurrence of the event, or +infinity if the event is not scheduled. |
| `boolean` | `isActive()` | Returns true if the event is currently scheduled by this event originator, false otherwise. |
| `boolean` | `isCurrent()` | Tests if the event is being currently executed, or just has been executed. |
| `boolean` | `isLoggingToDB()` | Return true if the given event (or dynamic event) is logged to database (note that this may be overridden by logging settings of Agent). |
| `void` | `onDestroy()` | Discards the scheduled event, if any (deletes it from the engine). |
| `String` | `toString()` | Returns a string representation of the event originator. |

### Methods inherited from class java.lang.Object
equals, getClass, hashCode, notify, notifyAll, wait, wait, wait

## Method Details

### getName
```java
public abstract String getName()
```
Returns the name of the event originator, i.e. the name of an event or a transition object specified by the user.

**Returns:** The name of the event originator.

### getFullName
```java
public String getFullName()
```
Returns the name of the event originator prefixed by the full name of its agent.

**Returns:** The full name of the event.

### toString
```java
public String toString()
```
Returns a string representation of the event originator.

**Overrides:** toString in class Object

### getAgent
```java
public Agent getAgent()
```
Returns the agent that owns the event originator.

**Returns:** The agent owning this event originator.

### getActiveObject
```java
@Deprecated
public Agent getActiveObject()
```
**Deprecated.** Use getAgent() instead

### isActive
```java
public boolean isActive()
```
Returns true if the event is currently scheduled by this event originator, false otherwise.

**Returns:** The status of the event.

### isCurrent
```java
public boolean isCurrent()
```
Tests if the event is being currently executed, or just has been executed.

**Returns:** true if the event is "current", false otherwise

### getRest
```java
public double getRest()
```
Returns the time remaining before the scheduled occurrence of the event, or +infinity if the event is not scheduled.

**Returns:** The time remaining before the occurrence of the event.

### getRest
```java
public double getRest(TimeUnits units)
```
Returns the time remaining before the scheduled occurrence of the event, or +infinity if the event is not scheduled.

**Parameters:**
- `units` - the time units

**Returns:** The time remaining before the occurrence of the event.

**Since:** 7.1

### cancel
```java
@Deprecated
@AnyLogicInternalCodegenAPI
public void cancel()
```
**Deprecated.** User should not call this method for events, call reset() instead

Cancels the scheduled event and clears the eventEntry

### isLoggingToDB
```java
@AnyLogicInternalAPI
public boolean isLoggingToDB()
```
Return true if the given event (or dynamic event) is logged to database (note that this may be overridden by logging settings of Agent).

### onDestroy
```java
@AnyLogicInternalCodegenAPI
public void onDestroy()
```
Discards the scheduled event, if any (deletes it from the engine). Must be called when the agent is destroyed. We assume it is common behavior of all event originators
