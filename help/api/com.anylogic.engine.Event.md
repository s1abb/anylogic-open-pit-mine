# Package com.anylogic.engine

## Class Event

```java
java.lang.Object
  ↳ com.anylogic.engine.EventOriginator
      ↳ com.anylogic.engine.Event
```

### All Implemented Interfaces
com.anylogic.engine.internal.Child, Serializable

### Direct Known Subclasses
EventCondition, EventRate, EventTimeout

```java
public abstract class Event
extends EventOriginator
implements com.anylogic.engine.internal.Child
```

Base class for all kinds of (static) events: EventTimeout, EventRate and EventCondition.

Memory: sizeof(EventOriginator) = 22 bytes

**Author:** AnyLogic North America, LLC https://anylogic.com

**See Also:** Serialized Form

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `abstract void` | `reset()` | Resets the event, canceling any scheduled occurrences. |
| `abstract void` | `restart()` | Restarts the event, canceling any scheduled occurrences and scheduling a new one. |
| `void` | `restoreOwner(Object owner)` | **Deprecated.** This method normally should not be called by user |
| `abstract void` | `start()` | Should be called when the agents starts. |

### Methods inherited from class com.anylogic.engine.EventOriginator
cancel, getActiveObject, getAgent, getFullName, getName, getRest, getRest, isActive, isCurrent, isLoggingToDB, onDestroy, toString

### Methods inherited from class java.lang.Object
equals, getClass, hashCode, notify, notifyAll, wait, wait, wait

## Method Details

### reset
```java
public abstract void reset()
```
Resets the event, canceling any scheduled occurrences.

### restart
```java
public abstract void restart()
```
Restarts the event, canceling any scheduled occurrences and scheduling a new one.

### start
```java
@AnyLogicInternalCodegenAPI
public abstract void start()
```
Should be called when the agents starts. Performs initial event scheduling.

### restoreOwner
```java
@AnyLogicInternalCodegenAPI
@Deprecated
public void restoreOwner(Object owner)
```
**Deprecated.** This method normally should not be called by user

This method restores owner of this object.
The method is used in snapshot saving/loading.

**Specified by:**
- `restoreOwner` in interface `com.anylogic.engine.internal.Child`

**Parameters:**
- `owner` - owner of this object, usually Agent, Experiment or ShapeGroup
