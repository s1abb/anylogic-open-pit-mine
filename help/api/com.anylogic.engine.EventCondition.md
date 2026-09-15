# Package com.anylogic.engine

## Class EventCondition

```java
java.lang.Object
  ↳ com.anylogic.engine.EventOriginator
      ↳ com.anylogic.engine.Event
          ↳ com.anylogic.engine.EventCondition
```

### All Implemented Interfaces
com.anylogic.engine.internal.Child, Serializable

```java
public class EventCondition
extends Event
```

Event with trigger of type condition. The event is executed when the condition becomes true. If the agent has continuously changing variables, the numeric engine constantly monitors the condition. In purely discrete models the condition is tested when something changes in the active obejct, i.e. when onChange() is called.

Memory: sizeof(Event) + 1 byte = 23 bytes

**Author:** AnyLogic North America, LLC https://anylogic.com

**See Also:** Serialized Form

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `EventCondition(Agent ao)` | Constructs the event object with Condition trigger. |

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `String` | `getName()` | Returns the name of the condition event as specified by the user. |
| `boolean` | `isMonitoring()` | Returns true if this event is currently monitoring (waiting on) its condition. |
| `void` | `onChange()` | Should be called when something changes in the object and probably condition changes. |
| `void` | `onDestroy()` | Discards the scheduled event, if any (deletes it from the engine). |
| `void` | `reset()` | Cancels the currently scheduled event, if any. |
| `void` | `restart()` | Resumes waiting on the condition. |
| `void` | `start()` | Should be called when the agents starts. |

### Methods inherited from class com.anylogic.engine.Event
restoreOwner

### Methods inherited from class com.anylogic.engine.EventOriginator
cancel, getActiveObject, getAgent, getFullName, getRest, getRest, isActive, isCurrent, isLoggingToDB, toString

### Methods inherited from class java.lang.Object
equals, getClass, hashCode, notify, notifyAll, wait, wait, wait

## Constructor Details

### EventCondition
```java
public EventCondition(Agent ao)
```
Constructs the event object with Condition trigger. Does not start it.

**Parameters:**
- `ao` - agent where this event belongs to

## Method Details

### getName
```java
public String getName()
```
Returns the name of the condition event as specified by the user.

**Specified by:**
- `getName` in class `EventOriginator`

**Returns:** The name of the condition event

### reset
```java
public void reset()
```
Cancels the currently scheduled event, if any. Stops waiting on the condition, (this can be later on resumed by calling restart()).

**Specified by:**
- `reset` in class `Event`

### restart
```java
public void restart()
```
Resumes waiting on the condition. Can be called in the event action or when event is inactive.

**Specified by:**
- `restart` in class `Event`

### isMonitoring
```java
public boolean isMonitoring()
```
Returns true if this event is currently monitoring (waiting on) its condition. This can be changed using reset() and restart() methods.

**Returns:** true is event is monitoring the condition, false otherwise

### start
```java
@AnyLogicInternalCodegenAPI
public void start()
```
Should be called when the agents starts. Starts waiting on the condition. Checks if the condition is true at this moment and, if yes, schedules event immediately.

**Specified by:**
- `start` in class `Event`

### onChange
```java
public void onChange()
```
Should be called when something changes in the object and probably condition changes. If Condition is true and event is not scheduled, schedules the event immediately. If condition is false, cancels the currently scheduled event, if any.

### onDestroy
```java
@AnyLogicInternalCodegenAPI
public void onDestroy()
```
Discards the scheduled event, if any (deletes it from the engine). Must be called when the agent is destroyed. We assume it is common behavior of all event originators

**Overrides:**
- `onDestroy` in class `EventOriginator`
