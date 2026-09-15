# Class Engine

## Package
`com.anylogic.engine`

## Inheritance Hierarchy
```
java.lang.Object
  com.anylogic.engine.Engine
```

## All Implemented Interfaces
`Serializable`

## Class Declaration
```java
public final class Engine extends Object implements Serializable
```

## Description
The simulation engine that drives the model execution. The engine maintains the event queue, the default random number generator, etc. Although there is one engine per simulation, it is designed to have no static data, so there may exist several concurrent simulations in one JVM, in particular, one simulation can invoke the other, etc.

The engine behavior and usage patterns are best described with a statechart with states IDLE, PAUSED, RUNNING, FINISHED, ERROR, PLEASE_WAIT. The normal usage pattern of the engine controlled by the Presentation GUI is like this:

```java
Engine engine = new Engine(); // -> IDLE; random number generator is initialized
Agent root = new RootAgent(engine, null, null);
...//setup parameters of root
engine.start(root); // -> PAUSED
engine.run(); // -> RUNNING; launches execution in a new thread, calls the experiment back on finish
...
engine.pause(); // -> PAUSED
engine.step(); // -> PAUSED
engine.run(); // -> RUNNING
...
engine.stop(); // -> IDLE completely destroys the model
...
Agent root2 = new RootAgent2(engine, null, null);
...etc.
```

The engine state PLEASE_WAIT means the engine is executing a non-interruptible single command, such as pause(), step(), or stop(). If you do not need multithreading and wish to run the model as fast as possible (i.e. in virtual time mode only) in the controlling thread, you may call runFast() instead of run(). runFast() ignores any synchronization, therefore you should not access the model data (e.g. call drawing of agents) concurrently with runFast().

**Author:** AnyLogic North America, LLC https://anylogic.com

## Nested Classes

### Engine.EventSelectionMode
```java
static enum Engine.EventSelectionMode
```
Simultaneous event selection mode constants.

### Engine.ModelType
```java
static enum Engine.ModelType
```
The type of the model, returned by Engine.getModelType().

### Engine.SolverDAEType
```java
static enum Engine.SolverDAEType
```
The solver type for mixed differential-algebraic equations.

### Engine.SolverNAEType
```java
static enum Engine.SolverNAEType
```
The solver type for algebraic equations.

### Engine.SolverODEType
```java
static enum Engine.SolverODEType
```
The solver type for ordinary differential equations.

### Engine.State
```java
static enum Engine.State
```
The state of the Engine.

## Field Summary

### Engine States
| Modifier and Type | Field | Description |
|-------------------|-------|-------------|
| `static final Engine.State` | `IDLE` | Engine is idle |
| `static final Engine.State` | `PAUSED` | Engine is paused |
| `static final Engine.State` | `RUNNING` | Engine is running |
| `static final Engine.State` | `FINISHED` | Engine has finished |
| `static final Engine.State` | `ERROR` | Engine has encountered an error |
| `static final Engine.State` | `PLEASE_WAIT` | Engine is executing a non-interruptible command |

### Model Types
| Modifier and Type | Field | Description |
|-------------------|-------|-------------|
| `static final Engine.ModelType` | `MODEL_TYPE_UNKNOWN` | Model is either empty or it is too early to judge |
| `static final Engine.ModelType` | `MODEL_TYPE_DISCRETE` | Model has at least one discrete event and no equations |
| `static final Engine.ModelType` | `MODEL_TYPE_CONTINUOUS` | Model has at least one equation and no discrete events |
| `static final Engine.ModelType` | `MODEL_TYPE_HYBRID` | Model has both events and equations |

### Event Selection Modes
| Modifier and Type | Field | Description |
|-------------------|-------|-------------|
| `static final Engine.EventSelectionMode` | `EVENT_SELECTION_LIFO` | Last in - first out mode |
| `static final Engine.EventSelectionMode` | `EVENT_SELECTION_FIFO` | First in - first out mode (default) |
| `static final Engine.EventSelectionMode` | `EVENT_SELECTION_RANDOM` | Random selection mode |
| `static final Engine.EventSelectionMode` | `EVENT_SELECTION_DETERMINISTIC` | Deprecated. Use EVENT_SELECTION_LIFO or EVENT_SELECTION_FIFO instead |

### Solver Types
| Modifier and Type | Field | Description |
|-------------------|-------|-------------|
| `static final Engine.SolverODEType` | `SOLVER_ODE_EULER` | Euler solver for ordinary differential equations |
| `static final Engine.SolverODEType` | `SOLVER_ODE_RK4` | RK4 solver for ordinary differential equations |
| `static final Engine.SolverNAEType` | `SOLVER_NAE_MODIFIED_NEWTON` | Modified Newton solver for algebraic equations |
| `static final Engine.SolverNAEType` | `SOLVER_NAE_FAST_NEWTON` | Fast Newton solver for algebraic equations |
| `static final Engine.SolverNAEType` | `SOLVER_NAE_CLASSIC_NEWTON` | Classic Newton solver for algebraic equations |
| `static final Engine.SolverDAEType` | `SOLVER_DAE_RK45_NEWTON` | RK45 Newton solver for differential-algebraic equations |
| `static final Engine.SolverDAEType` | `SOLVER_DAE_EULER_NEWTON` | Euler Newton solver for differential-algebraic equations |

## Constructor Summary
| Constructor | Description |
|-------------|-------------|
| `Engine()` | Constructs the engine and sets the seed of the default random number generator to 0 |

## Method Summary

### Engine Control Methods
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `boolean` | `start(Agent root)` | Starts the model with the given root agent |
| `boolean` | `run()` | Runs the model in a separate thread |
| `boolean` | `runFast()` | Runs the model in the fastest possible way in the same thread |
| `boolean` | `runFast(double pauseTime)` | Runs the model fast but pauses at the specified time |
| `boolean` | `pause()` | Pauses the model execution |
| `boolean` | `step()` | Makes at most one discrete step of the model |
| `boolean` | `stop()` | Stops and destroys the model |
| `boolean` | `finish()` | Terminates the model after execution of current event |

### Time and Date Methods
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `double` | `time()` | Returns the current model (logical) time |
| `double` | `time(TimeUnits units)` | Returns the current model time in specified units |
| `Date` | `date()` | Returns the current model date |
| `long` | `dateInMillis()` | Returns the current model date in milliseconds |
| `Date` | `timeToDate(double t)` | Converts model time to date |
| `double` | `dateToTime(Date d)` | Converts date to model time |
| `long` | `timeToDateInMillis(double time)` | Converts model time to date in milliseconds |

### Date Component Methods
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `int` | `getYear()` | Returns the year of the current model date |
| `int` | `getMonth()` | Returns the month of the current model date |
| `int` | `getDayOfMonth()` | Returns the day of the month of the current model date |
| `int` | `getDayOfWeek()` | Returns the day of the week of the current model date |
| `int` | `getDayOfYear()` | Returns the day of the year of the current model date |
| `int` | `getHourOfDay()` | Returns the hour of day of the current model date (24-hour clock) |
| `int` | `getHour()` | Returns the hour of the current model date (12-hour clock) |
| `int` | `getAmPm()` | Indicates whether the hour is before (AM) or after (PM) noon |
| `int` | `getMinute()` | Returns the minute within the hour of the current model date |
| `int` | `getSecond()` | Returns the second within the minute of the current model date |
| `int` | `getMillisecond()` | Returns the millisecond within the second of the current model date |

### Engine Configuration Methods
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `void` | `setStartTime(double tstart)` | Sets the start time for the simulation |
| `double` | `getStartTime()` | Returns the currently set start time |
| `void` | `setStopTime(double tstop)` | Sets the stop time for the simulation |
| `double` | `getStopTime()` | Returns the currently set stop time |
| `void` | `setTimeUnit(TimeUnits tu)` | Sets the model time unit |
| `TimeUnits` | `getTimeUnit()` | Returns the current model time unit |
| `void` | `setStartDate(Date date)` | Sets the date corresponding to the start time |
| `Date` | `getStartDate()` | Returns the date corresponding to the start time |
| `void` | `setStopDate(Date date)` | Sets the stop time based on a date |
| `Date` | `getStopDate()` | Returns the date corresponding to the stop time |
| `void` | `setRealTimeMode(boolean on)` | Sets the virtual or real time execution mode |
| `boolean` | `getRealTimeMode()` | Returns true if in real time mode |
| `void` | `setRealTimeScale(double scale)` | Sets the real time scale of model execution |
| `double` | `getRealTimeScale()` | Returns the current real time scale |
| `void` | `setSimultaneousEventsSelectionMode(Engine.EventSelectionMode mode)` | Sets the mode of event selection among simultaneous events |

### Solver Configuration Methods
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `void` | `setSolverODE(Engine.SolverODEType solverODE)` | Sets solver type for ordinary differential equations |
| `Engine.SolverODEType` | `getSolverODE()` | Returns solver type for ordinary differential equations |
| `void` | `setSolverNAE(Engine.SolverNAEType solverNAE)` | Sets solver type for algebraic equations |
| `Engine.SolverNAEType` | `getSolverNAE()` | Returns solver type for algebraic equations |
| `void` | `setSolverDAE(Engine.SolverDAEType solverDAE)` | Sets solver type for mixed differential-algebraic equations |
| `Engine.SolverDAEType` | `getSolverDAE()` | Returns solver type for mixed differential-algebraic equations |
| `void` | `setATOL(double atol)` | Sets the absolute tolerance of the numeric engine |
| `double` | `getATOL()` | Returns absolute tolerance of the numeric engine |
| `void` | `setRTOL(double rtol)` | Sets the relative tolerance of the numeric engine |
| `double` | `getRTOL()` | Returns relative tolerance of the numeric engine |
| `void` | `setHTOL(double htol)` | Sets the fixed step of the numeric engine |
| `double` | `getHTOL()` | Returns fixed step of the numeric engine |
| `void` | `setTTOL(double ttol)` | Sets the time tolerance of the numeric engine |
| `double` | `getTTOL()` | Returns time tolerance of the numeric engine |
| `void` | `setEventAwareSolver(boolean eventAwareSolver)` | Sets whether the solver should be aware of discrete events |
| `boolean` | `isEventAwareSolver()` | Returns whether the solver is aware of discrete events |

### Random Number Generation
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `void` | `setDefaultRandomGenerator(Random r)` | Changes the default random number generator |
| `Random` | `getDefaultRandomGenerator()` | Returns the currently used default random number generator |

### Model Information Methods
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `Engine.State` | `getState()` | Returns the current state of the engine |
| `Engine.ModelType` | `getModelType()` | Returns the type of model being executed |
| `Agent` | `getRoot()` | Returns the top-level agent |
| `long` | `getStep()` | Returns the number of events executed |
| `long` | `getEventCount()` | Returns the number of currently scheduled events |
| `double` | `getNextEventTime()` | Returns the time of the earliest event scheduled |
| `double` | `getNextStepTime()` | Returns the time which will be after the next step() execution |
| `double` | `getProgress()` | Returns the progress of the simulation |
| `int` | `getRunCount()` | Returns the number of the current simulation run |
| `long` | `getRunTimeMillis()` | Returns the real duration of the simulation run |
| `long` | `getStartTimeMillis()` | Returns the system time at simulation start |
| `boolean` | `isCalendarDateUsed()` | Returns true if calendar dates are used |
| `static String` | `getVersion()` | Returns the AnyLogic version |

### Error Handling Methods
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `RuntimeException` | `error(String errorText)` | Signals an error during the model run |
| `RuntimeException` | `error(Throwable cause, String errorText)` | Signals an error during the model run |
| `RuntimeException` | `errorInModel(String errorText)` | Signals a model logic error |
| `RuntimeException` | `errorInModel(Throwable cause, String errorText)` | Signals a model logic error |
| `void` | `disableWarning(String warningType)` | Disables a specific warning type |

### Snapshot Methods
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `void` | `saveRootObjectSnapshot(String snapshotFileName)` | Saves top-level agent to a snapshot file |
| `Agent` | `loadRootObjectFromSnapshot(String snapshotFileName)` | Loads top-level agent from a snapshot file |
| `Agent` | `loadRootObjectFromSnapshot(String snapshotFileName, boolean cacheSnapshot)` | Loads top-level agent from a snapshot file with caching option |
| `void` | `flushSnapshotCache()` | Clears cache with contents of recently loaded snapshot file |

### Experiment Methods
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `void` | `setExperiment(Experiment<?> ex)` | Sets the experiment that will control the model execution |
| `Experiment<?>` | `getExperiment()` | Returns the experiment controlling the model execution |
| `ExperimentCustom` | `getExperimentCustom()` | Returns the custom experiment controlling the model execution |
| `void` | `setExperimentHost(IExperimentHost h)` | Sets the object that will host the model execution |
| `IExperimentHost` | `getExperimentHost()` | Returns the experiment host object |
| `ModelDatabase` | `getModelDatabase()` | Returns the database of this model |
| `ModelProperties` | `getModelProperties()` | Returns the model properties of this model |

## Method Details

### time
```java
public double time()
```
Returns the current model (logical) time.

**Returns:** the current model time

### date
```java
public Date date()
```
Returns the current model date with respect to the start time/date and the model time unit.

**Returns:** the current model date

### start
```java
public boolean start(Agent root)
```
Engine command applicable only in IDLE state (in other states does nothing and returns false).

Sets the given agent as the root of the model, initializes the model time to the start time, and puts the engine into the PAUSED state. The model is ready to run.

**Parameters:**
- `root` - the root agent of the model

**Returns:** true if the command was executed, false otherwise

### run
```java
public boolean run()
```
Engine command applicable only in PAUSED state (in other states does nothing and returns false).

Launches model execution in a separate thread and returns immediately. The model will run until it finishes (because of stop time or finish() method called), or until pause() is called. When the model finishes, the experiment is notified.

**Returns:** true if the command was executed, false otherwise

### runFast
```java
public boolean runFast()
```
Runs the model in the fastest possible way in the same (calling) thread.

The method returns only when the model finishes (because of stop time or finish() method called), or when pause() is called from another thread. This method ignores any synchronization with real time, therefore you should not access the model data (e.g. call drawing of agents) concurrently with runFast().

**Returns:** true if the command was executed, false otherwise

### pause
```java
public boolean pause()
```
Engine command applicable only in RUNNING state (in other states does nothing and returns false).

Pauses the model execution. The model can be later resumed with run() or runFast(), or a single step can be made with step().

**Returns:** true if the command was executed, false otherwise

### step
```java
public boolean step()
```
Makes at most one discrete step of the model (can be done from the PAUSED state only).

If there are no more events, the model finishes. If there are events, the earliest one is executed. If there are several events scheduled for the same time, all of them are executed.

**Returns:** true if the command was executed, false otherwise

### stop
```java
public boolean stop()
```
Stops and destroys the model, see also finish() method, which doesn't destroy the model.

Engine command applicable only in any non-IDLE state (in IDLE state does nothing and returns false).

**Returns:** true if the command was executed, false otherwise

### finish
```java
public boolean finish()
```
Terminates the model after execution of current event.

The model is not destroyed, it just goes to the FINISHED state. This method is typically called from within the model code.

**Returns:** true if the command was executed, false otherwise

### getState
```java
public Engine.State getState()
```
Returns the current state of the engine:
- IDLE - no model is set for execution, doing nothing
- PAUSED - model is set and have started, ready to run or make a step
- RUNNING - in the loop of model execution invoked by run() or runFast()
- FINISHED - the model execution is finished OK, but the model is not yet destroyed
- ERROR - the model execution is finished with error, the model is not yet destroyed
- PLEASE_WAIT - in the process of executing a non-interruptible command like pause(), step() or stop()

The state is however not guaranteed as may be modified concurrently.

**Returns:** the current state of the engine

### getModelType
```java
public Engine.ModelType getModelType()
```
Returns the type of model being executed:
- MODEL_TYPE_UNKNOWN - the model is either empty or it is too early to judge
- MODEL_TYPE_DISCRETE - the model so far had at least one discrete event and no equations
- MODEL_TYPE_CONTINUOUS - the model so far had at equation and no discrete events
- MODEL_TYPE_HYBRID - the model had both events and equations

**Returns:** the type of model being executed

### setRealTimeMode
```java
public void setRealTimeMode(boolean on)
```
Sets the virtual or real time execution mode.

In real time mode, the model execution is synchronized with the wall clock time according to the real time scale. In virtual time mode, the model runs as fast as possible.

**Parameters:**
- `on` - true for real time mode, false for virtual time mode

### setRealTimeScale
```java
public void setRealTimeScale(double scale)
```
Sets the desired real time scale of model execution, i.e. the ratio of model time to real time.

For example, if the scale is 2.0, the model runs twice as fast as real time. If the scale is 0.5, the model runs twice as slow as real time.

**Parameters:**
- `scale` - the real time scale

### setSimultaneousEventsSelectionMode
```java
public void setSimultaneousEventsSelectionMode(Engine.EventSelectionMode mode)
```
Sets the mode of event selection among simultaneous events (if any occur).

Available modes:
- EVENT_SELECTION_LIFO - last in, first out
- EVENT_SELECTION_FIFO - first in, first out (default)
- EVENT_SELECTION_RANDOM - random selection

**Parameters:**
- `mode` - the event selection mode

### error
```java
public RuntimeException error(String errorText)
```
Signals an error during the model run by throwing a RuntimeException with the given text.

**Parameters:**
- `errorText` - the error message

**Returns:** the exception (never returns normally)

### errorInModel
```java
public RuntimeException errorInModel(String errorText)
```
Signals a model logic error during the model run by throwing a ModelException with the given text.

This method differs from error() in the way of displaying error message: model logic errors are 'softer' than other errors, they use to happen in the models and signal the modeler that model might need some parameters adjustments.

**Parameters:**
- `errorText` - the error message

**Returns:** the exception (never returns normally)
