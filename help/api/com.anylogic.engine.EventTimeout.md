# Package com.anylogic.engine

## Class EventTimeout

```java
java.lang.Object
  ↳ com.anylogic.engine.EventOriginator
      ↳ com.anylogic.engine.Event
          ↳ com.anylogic.engine.EventTimeout
```

### All Implemented Interfaces
com.anylogic.engine.internal.Child, Serializable

```java
public class EventTimeout
extends Event
```

Event with trigger of type timeout. The event occurs exactly in timeout time after it is started. Optionally, the event may be made cyclic and set to occur at startup.

Memory: sizeof(Event) + 8 bytes = 30 bytes

**Author:** AnyLogic North America, LLC https://anylogic.com

**See Also:** Serialized Form

## Nested Class Summary

| Modifier and Type | Class | Description |
|-------------------|-------|-------------|
| `static enum` | `EventTimeout.Mode` | Enumeration of event timeout modes |

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `EventTimeout(Agent ao)` | Constructs the event object with Timeout trigger. |

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `String` | `getName()` | Returns the name of the timeout event as specified by the user. |
| `void` | `reset()` | Cancels the currently scheduled event, if any. |
| `void` | `restart()` | Cancels the currently scheduled event, if any, and schedules the next occurrence according to the Timeout specified |
| `void` | `restart(double timeout)` | Cancels the currently scheduled event, if any, and schedules the next occurrence in time t. |
| `void` | `restart(double timeout, TimeUnits units)` | Cancels the currently scheduled event, if any, and schedules the next occurrence in time t. |
| `void` | `restartTo(double time)` | Cancels the currently scheduled event, if any, and schedules the next occurrence at the (absolute) model time time. |
| `void` | `restartTo(double time, TimeUnits units)` | Cancels the currently scheduled event, if any, and schedules the next occurrence at the (absolute) model time time expressed in the given units. |
| `void` | `restartTo(Date date)` | Cancels the currently scheduled event, if any, and schedules the next occurrence at the (absolute) model date date. |
| `void` | `resume()` | Re-schedules the previously suspended event in the remaining time. |
| `void` | `start()` | Should be called when the agents starts. |
| `void` | `suspend()` | Cancels the currently scheduled event, if any, and remembers the remaining time so that it can be resumed by calling resume(). |

### Methods inherited from class com.anylogic.engine.Event
restoreOwner

### Methods inherited from class com.anylogic.engine.EventOriginator
cancel, getActiveObject, getAgent, getFullName, getRest, getRest, isActive, isCurrent, isLoggingToDB, onDestroy, toString

### Methods inherited from class java.lang.Object
equals, getClass, hashCode, notify, notifyAll, wait, wait, wait

## Constructor Details

### EventTimeout
```java
public EventTimeout(Agent ao)
```
Constructs the event object with Timeout trigger. Does not start it.

**Parameters:**
- `ao` - agent where this event belongs to

## Method Details

### getName
```java
public String getName()
```
Returns the name of the timeout event as specified by the user.

**Specified by:**
- `getName` in class `EventOriginator`

**Returns:** The name of the timeout event

### reset
```java
public void reset()
```
Cancels the currently scheduled event, if any. In case the event is Cyclic, the cycle would not resume until restart() or restart(double) is called.

**Specified by:**
- `reset` in class `Event`

### restart
```java
public void restart()
```
Cancels the currently scheduled event, if any, and schedules the next occurrence according to the Timeout specified

**Specified by:**
- `restart` in class `Event`

### restart
```java
public void restart(double timeout)
```
Cancels the currently scheduled event, if any, and schedules the next occurrence in time t. If the event is Cyclic, it will then continue occurring at the original timeout/rate.

**Parameters:**
- `timeout` - time (from now) in which the event will be scheduled.

**See Also:** restartTo(double)

### restart
```java
public void restart(double timeout, TimeUnits units)
```
Cancels the currently scheduled event, if any, and schedules the next occurrence in time t. If the event is Cyclic, it will then continue occurring at the original timeout/rate.

**Parameters:**
- `timeout` - time (from now) in which the event will be scheduled.
- `units` - the time units

**Since:** 7.1

**See Also:** restartTo(double, TimeUnits)

### restartTo
```java
public void restartTo(double time)
```
Cancels the currently scheduled event, if any, and schedules the next occurrence at the (absolute) model time time. If the event is Cyclic, it will then continue occurring at the original timeout/rate.

This method seems to be like the call restart( time - time() ), but it is different because it eliminates numeric calculation error which may occur on any machine.

**Parameters:**
- `time` - model time (absolute) at which the event will be scheduled.

### restartTo
```java
public void restartTo(double time, TimeUnits units)
```
Cancels the currently scheduled event, if any, and schedules the next occurrence at the (absolute) model time time expressed in the given units. If the event is Cyclic, it will then continue occurring at the original timeout/rate.

This method seems to be like the call restart( time - time(units), units ), but it is different because it eliminates numeric calculation error which may occur on any machine.

**Parameters:**
- `time` - model time (absolute) at which the event will be scheduled.
- `units` - the time units

**Since:** 7.1

### restartTo
```java
public void restartTo(Date date)
```
Cancels the currently scheduled event, if any, and schedules the next occurrence at the (absolute) model date date. If the event is Cyclic, it will then continue occurring at the original timeout/rate.

This method seems to be like the call restart( toTimeout(...) ), but it is different because it eliminates numeric calculation error which may occur on any machine.

**Parameters:**
- `date` - model date at which the event will be scheduled.

### suspend
```java
public void suspend()
```
Cancels the currently scheduled event, if any, and remembers the remaining time so that it can be resumed by calling resume(). If the event is not scheduled at the time of calling suspend(), the subsequent resume will result in nothing.

Note that you should not call this method (i.e. should not try to suspend the event) from its own action code: it will have the effect of reset().

### resume
```java
public void resume()
```
Re-schedules the previously suspended event in the remaining time. Does nothing if event was never suspended or was reset or restarted after it was last suspended.

### start
```java
@AnyLogicInternalCodegenAPI
public void start()
```
Should be called when the agents starts. Performs initial event scheduling according to mode (CYCLIC, ONCE, USER).

**Specified by:**
- `start` in class `Event`
