# Class Experiment

## Package
`com.anylogic.engine`

## Inheritance Hierarchy
```
java.lang.Object
  com.anylogic.engine.Presentable
    com.anylogic.engine.Utilities
      com.anylogic.engine.Experiment<ROOT>
```

## Type Parameters
- `ROOT` - class of top-level agent

## All Implemented Interfaces
`AgentConstants`, `EnvironmentConstants`, `UtilitiesMath`, `UtilitiesRandom`, `UtilitiesString`, `Serializable`

## Direct Known Subclasses
`ExperimentRunFast`, `ExperimentSimulation`

## Class Declaration
```java
public abstract class Experiment<ROOT extends Agent> extends Utilities
```

## Description
The simulation engine that drives the model execution. The engine maintains the event queue, the default random number generator, etc. Although there is one engine per simulation, it is designed to have no static data, so there may exist several concurrent simulations in one JVM, in particular, one simulation can invoke the other, etc.

A base class for all AnyLogic experiments. Experiment describes how would one like to run the model (just perform a single simulation run, do Monte Carlo simulation, vary parameters, optimize, etc.), and what outputs of the model you are interested in (this may be a simple chart of how a certain value was changing over time during a run, or how an observable depends on a parameter in case of multiple runs, or a histogram in case of risk analysis, etc.). The experiment is also capable of storing the outputs producted by the model so that they are available after the simulation and independently of it. Experiment can display itself in a presentation window and be controlled by the presentation GUI. For that purpose it supports a set of commands that can be assigned to the presentation window toolbar buttons and menu items.

AnyLogic models with GUI can run as Java applications.

**Author:** AnyLogic North America, LLC https://anylogic.com

## Nested Classes

### Experiment.Command
```java
static enum Experiment.Command
```

### Experiment.State
```java
static enum Experiment.State
```
The state of the Engine

## Field Summary

### Engine States
| Modifier and Type | Field | Description |
|-------------------|-------|-------------|
| `static final Experiment.State` | `IDLE` | Engine is idle |
| `static final Experiment.State` | `PAUSED` | Engine is paused |
| `static final Experiment.State` | `RUNNING` | Engine is running |
| `static final Experiment.State` | `FINISHED` | Engine has finished |
| `static final Experiment.State` | `ERROR` | Engine has encountered an error |
| `static final Experiment.State` | `PLEASE_WAIT` | Engine is executing a non-interruptible command |

### Commands
| Modifier and Type | Field | Description |
|-------------------|-------|-------------|
| `static final Experiment.Command` | `OPEN_RESULTS` | Open results command |
| `static final Experiment.Command` | `SAVE_RESULTS` | Save results command |
| `static final Experiment.Command` | `OPEN_SNAPSHOT` | Open snapshot command |
| `static final Experiment.Command` | `SAVE_SNAPSHOT` | Save snapshot command |
| `static final Experiment.Command` | `RUN` | Run command |
| `static final Experiment.Command` | `STEP` | Step command |
| `static final Experiment.Command` | `PAUSE` | Pause command |
| `static final Experiment.Command` | `STOP` | Stop command |

### Internal Fields
| Modifier and Type | Field | Description |
|-------------------|-------|-------------|
| `com.anylogic.engine.internal.ActionQueue` | `modelExecutionCommandQueue` | This field shouldn't be accessed by user, is public due to technical reasons |
| `com.anylogic.engine.internal.ActionQueue` | `mutexModelActionQueue` | This field shouldn't be accessed by user, is public due to technical reasons |

## Method Summary

### Experiment Control Methods
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `abstract void` | `run()` | Starts the experiment execution from the current state |
| `abstract void` | `step()` | Performs one step of experiment execution |
| `abstract void` | `pause()` | Pauses the experiment execution |
| `abstract void` | `stop()` | Terminates the experiment execution |
| `void` | `close()` | Stops experiment, destroys model and closes experiment window |
| `boolean` | `isCommandEnabled(Experiment.Command cmd)` | Checks if a command can be executed |

### Experiment Information Methods
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `abstract Experiment.State` | `getState()` | Returns the current state of the experiment |
| `abstract double` | `getProgress()` | Returns the progress of the experiment |
| `abstract double` | `getRunTimeSeconds()` | Returns the real duration of the experiment in seconds |
| `int` | `getRunCount()` | Returns the number of the current simulation run |
| `long` | `getStep()` | Returns the number of events executed |
| `String` | `getName()` | Returns the name (window title) of the experiment |
| `void` | `setName(String name)` | Sets the name (window title) of the experiment |
| `int` | `getWindowWidth()` | Returns the initial width of the experiment window |
| `int` | `getWindowHeight()` | Returns the initial height of the experiment window |
| `IExperimentHost` | `getExperimentHost()` | Returns the experiment host object |

### Snapshot Methods
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `final void` | `setLoadRootFromSnapshot(String snapshotFileName)` | Tells this experiment to load the top-level agent from AnyLogic snapshot file |
| `final boolean` | `isLoadRootFromSnapshot()` | Returns true if this experiment is configured to start simulation from state loaded from snapshot file |
| `final String` | `getSnapshotFileName()` | Returns the name of snapshot file this experiment is configured to start simulation from |

### Error Handling Methods
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `RuntimeException` | `error(Throwable cause, String errorText)` | Signals an error during the model run |
| `RuntimeException` | `errorInModel(Throwable cause, String errorText)` | Signals a model logic error |
| `void` | `warning(String warningText)` | Signals a warning during the model run |
| `void` | `warning(String warningTextFormat, Object... args)` | Signals a warning during the model run with formatting |

### Experiment Lifecycle Methods
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `abstract ROOT` | `createRoot(Engine engine)` | Is called to obtain a new top-level agent |
| `void` | `reset()` | Is called each time before a new model is created |
| `void` | `setup(IExperimentHost experimentHost)` | Is called in static main() method of applications |
| `void` | `setupEngine(Engine engine)` | Is called for the simulation engine when it is created |
| `void` | `onDestroy()` | User extension point called when experiment is disposed |
| `void` | `onError(Throwable error)` | May be overridden for custom error processing |
| `void` | `onError(Throwable error, Agent root)` | May be overridden for custom error processing |

### Command Line Arguments
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `final String[]` | `getCommandLineArguments()` | Returns an array of Command-line Arguments passed to this experiment |

## Method Details

### getState
```java
public abstract Experiment.State getState()
```
Returns the current state of the experiment: IDLE, PAUSED, RUNNING, FINISHED, ERROR, or PLEASE_WAIT

**Returns:** the current state of the experiment

### getProgress
```java
public abstract double getProgress()
```
Returns the progress of the experiment: a number between 0 and 1 depending on what part of experiment is completed, or -1 if not known.

**Returns:** the progress of the experiment

### run
```java
public abstract void run()
```
Starts the experiment execution from the current state.

### step
```java
public abstract void step()
```
Performs one step of experiment execution.

### pause
```java
public abstract void pause()
```
Pauses the experiment execution.

### stop
```java
public abstract void stop()
```
Terminates the experiment execution.

### close
```java
public void close()
```
This method returns immediately and performs the following actions in a separate thread:
- stops experiment if it is not stopped,
- destroys the model and
- closes experiment window (only if model is started in the application mode)

### createRoot
```java
public abstract ROOT createRoot(Engine engine)
```
Is called to obtain a new top-level agent. This method must be defined in a subclass. Note that the top-level agent should just be constructed in this method, as its create() and start() methods will be called later on.

**Parameters:**
- `engine` - the simulation engine that will simulate the model

### error
```java
public RuntimeException error(Throwable cause, String errorText)
```
Signals an error during the model run by throwing a RuntimeException with errorText preceded by the agent full name.

**Parameters:**
- `cause` - the cause (which will be saved for more detailed message), may be null
- `errorText` - the text describing the error that will be displayed.

**Returns:** actually this method never returns, it throws runtime exception by itself. But the return type is defined for some cases when you would like to use the following form of call: throw error("my message");

### warning
```java
public void warning(String warningText)
```
Signals a warning during the model run with warningText preceded by the agent full name.

Warnings may be turned off in the AnyLogic preferences (runtime section) or by API: AnyLogicRuntimePreferences.setEnableWarnings(Boolean).

This method checks against numerous warnings output:
- In case of multiple warnings having equal warningText, only the first 10 of them are displayed.
- When more than 1000 warnings having different warningText occur, all the subsequent warnings (including new occurrences of those in the first 1000) will stop displaying.

Be careful with using dynamically changing warningText (e.g. listing names of agents), it could be better to use Utilities.warning(String, Object...).

**Parameters:**
- `warningText` - the text describing the warning that will be displayed.
