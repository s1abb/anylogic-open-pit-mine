# Package com.anylogic.engine

## Class EventRate

```java
java.lang.Object
  ↳ com.anylogic.engine.EventOriginator
      ↳ com.anylogic.engine.Event
          ↳ com.anylogic.engine.EventRate
```

### All Implemented Interfaces
com.anylogic.engine.internal.Child, Serializable

```java
public class EventRate
extends Event
```

Event with trigger of type rate. Such event is executed periodically with time intervals distributed exponentially with the parameter rate, i.e. if the rate is 5, the event will occur on average 5 times per time unit. If the rate changes dynamically, the event occurrence gets re-scheduled; such changes may only be noticed by EventRate if onChange() is called for the agent.

Memory: sizeof(Event) + 8 = 30 bytes

**Author:** AnyLogic North America, LLC https://anylogic.com

**See Also:** Serialized Form

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `EventRate(Agent ao)` | Constructs the event object with Rate trigger. |

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `String` | `getName()` | Returns the name of the rate event as specified by the user. |
| `void` | `onChange()` | Should be called when something changes in the object (and probably the rate changes). |
| `void` | `reset()` | Cancels the currently scheduled event, if any. |
| `void` | `restart()` | Cancels the currently scheduled event, if any, and schedules the next occurrence according to the Rate. |
| `void` | `start()` | Should be called when the agents starts. |

### Methods inherited from class com.anylogic.engine.Event
restoreOwner

### Methods inherited from class com.anylogic.engine.EventOriginator
cancel, getActiveObject, getAgent, getFullName, getRest, getRest, isActive, isCurrent, isLoggingToDB, onDestroy, toString

### Methods inherited from class java.lang.Object
equals, getClass, hashCode, notify, notifyAll, wait, wait, wait

## Constructor Details

### EventRate
```java
public EventRate(Agent ao)
```
Constructs the event object with Rate trigger. Does not start it.

**Parameters:**
- `ao` - agent where this event belongs to

## Method Details

### getName
```java
public String getName()
```
Returns the name of the rate event as specified by the user.

**Specified by:**
- `getName` in class `EventOriginator`

**Returns:** The name of the rate event

### reset
```java
public void reset()
```
Cancels the currently scheduled event, if any. The cyclic execution would not resume until restart() is called.

**Specified by:**
- `reset` in class `Event`

### restart
```java
public void restart()
```
Cancels the currently scheduled event, if any, and schedules the next occurrence according to the Rate.

**Specified by:**
- `restart` in class `Event`

### start
```java
@AnyLogicInternalCodegenAPI
public void start()
```
Should be called when the agents starts. Schedules the first occurrence at the time exponentially distributed with the specified Rate

**Specified by:**
- `start` in class `Event`

### onChange
```java
public void onChange()
```
Should be called when something changes in the object (and probably the rate changes). Re-schedules the event with re-calculated rate.
