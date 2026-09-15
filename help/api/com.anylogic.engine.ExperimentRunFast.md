# Class ExperimentRunFast

## Package
`com.anylogic.engine`

## Inheritance Hierarchy
```
java.lang.Object
  com.anylogic.engine.Presentable
    com.anylogic.engine.Utilities
      com.anylogic.engine.Experiment<ROOT>
        com.anylogic.engine.ExperimentRunFast<ROOT>
```

## Type Parameters
- `ROOT` - class of top-level agent

## All Implemented Interfaces
`AgentConstants`, `EnvironmentConstants`, `UtilitiesMath`, `UtilitiesRandom`, `UtilitiesString`, `Serializable`

## Direct Known Subclasses
`ExperimentCompareRuns`, `ExperimentMultipleRuns`

## Class Declaration
```java
public abstract class ExperimentRunFast<ROOT extends Agent> extends Experiment<ROOT>
```

## Description
Base class for all experiments that support fast simulation run (e.g. optimization, parameter variation, compare runs).

**Author:** AnyLogic North America, LLC https://anylogic.com

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `ExperimentRunFast(boolean singleEngine)` | Creates the experiment, a new simulation engine is created. |

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `Engine` | `getEngine()` | Returns the engine executing the model. |
| `double` | `getProgress()` | Returns the progress of the experiment. |
| `final double` | `getRunTimeSeconds()` | Returns the real duration of the experiment in seconds. |
| `final Experiment.State` | `getState()` | Returns the current state of the experiment. |
| `final void` | `pause()` | Pauses the model execution. |
| `void` | `registerExperimentHost_xjal(IExperimentHost experimentHost)` | This method isn't designed to be called by user. |
| `final void` | `run()` | Runs the model from the current state. |
| `final void` | `step()` | Performs one step of the model execution. |
| `final void` | `stop()` | Terminates the model execution. |

## Constructor Details

### ExperimentRunFast
```java
public ExperimentRunFast(boolean singleEngine)
```
Creates the experiment, a new simulation engine is created.

## Method Details

### getEngine
```java
public Engine getEngine()
```
Returns the engine executing the model.

**Returns:** the engine executing the model

### getState
```java
public final Experiment.State getState()
```
Returns the current state of the experiment. Possible states are: IDLE, RUNNING, PAUSED, FINISHED, ERROR, and PLEASE_WAIT.

**Returns:** the current state of the experiment

### getProgress
```java
public double getProgress()
```
Returns the progress of the experiment: a number between 0 and 1 corresponding to the part of the experiment completed so far (based on iteration count or time limit), or -1 if this cannot be calculated.

**Returns:** the progress of the experiment

### getRunTimeSeconds
```java
public final double getRunTimeSeconds()
```
Returns the real duration of the experiment in seconds. This includes simulation run time and excludes pause times.

**Returns:** the real duration of the experiment in seconds

### run
```java
public final void run()
```
Runs the model from the current state. If model is not yet existing, resets the experiment, creates and starts the model.

### step
```java
public final void step()
```
Performs one step of the model execution. If model is not yet existing, resets the experiment, creates and starts the model (not making a step).

### pause
```java
public final void pause()
```
Pauses the model execution.

This method has different behavior depending on context where it is called:
- When this method is called from the model execution thread, from control action code, or from on-click code of a shape, it returns immediately. All the actions are performed in separate concurrent thread.
- When this method is called from other locations (e.g. user-defined concurrent thread), it waits for the experiment execution to be paused.

### stop
```java
public final void stop()
```
Terminates the model execution, destroys and forgets the model and calls garbage collector, but keeps all experiment data.

This method has different behavior depending on context where it is called:
- When this method is called from the model execution thread, from control action code, or from on-click code of a shape, it returns immediately. All the actions are performed in separate concurrent thread.
- When this method is called from other locations (e.g. user-defined concurrent thread), it waits for the model execution termination.
