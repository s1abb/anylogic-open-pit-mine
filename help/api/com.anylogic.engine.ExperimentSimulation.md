# Class ExperimentSimulation

## Package
`com.anylogic.engine`

## Inheritance Hierarchy
```
java.lang.Object
  com.anylogic.engine.Presentable
    com.anylogic.engine.Utilities
      com.anylogic.engine.Experiment<ROOT>
        com.anylogic.engine.ExperimentSimulation<ROOT>
```

## Type Parameters
- `ROOT` - class of top-level agent

## All Implemented Interfaces
`AgentConstants`, `EnvironmentConstants`, `UtilitiesMath`, `UtilitiesRandom`, `UtilitiesString`, `Serializable`

## Class Declaration
```java
public abstract class ExperimentSimulation<ROOT extends Agent> extends Experiment<ROOT>
```

## Description
The simplest possible experiment consisting of a single simulation run. One should implement the `createRoot()` method in a subclass to set a particular model to this experiment.

A typical usage pattern is here:

```java
public class MyExperiment extends ExperimentSimulation {
 
    public Agent createRoot(Engine engine) {
       MyMain root = new MyMain(engine, null, null);
       //set parameters of root if needed
       ...
       return root;
    }
 
    public void setup() {
       Engine eng = getEngine();
       //set engine stop time, time mode, etc.
       ...
       Presentation p = new Presentation(ex, null);
       p.start();
       //set presentation size, configure toolbar, etc.
       ...
    }
 
    public static void main(String[] args) {
       MyExperiment ex = new MyExperiment();
       ex.setName("My Experiment");
       ex.setup(null);
    }
 
}
```

**Author:** AnyLogic North America, LLC https://anylogic.com

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `ExperimentSimulation()` | Creates the experiment and a new simulation engine that will be used for all simulations. |

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `void` | `customRunPause_xjal(boolean requestRun, boolean atAbsoluteTime, double time)` | This method is internal and shouldn't be called by user. |
| `void` | `customRunPause_xjal(boolean absoluteTime, double t)` | Deprecated. |
| `final com.anylogic.engine.internal.ActiveView` | `ep_xjal()` | This method shouldn't be accessed by user. |
| `void` | `finish()` | Sets a flag that, when tested by the engine, causes it to finish after completing the current event execution. |
| `Engine` | `getEngine()` | Returns the engine executing the model. |
| `double` | `getProgress()` | Returns the progress of the experiment: in this case it is the same as the progress of the current simulation run. |
| `double` | `getRunTimeSeconds()` | Returns the real duration of the experiment in seconds, excluding pause times, in this case it is same as duration of the simulation run. |
| `Experiment.State` | `getState()` | Returns the current state of the experiment. |
| `void` | `onDestroy_xjal()` | This method normally shouldn't be called by user. |
| `void` | `pause()` | Pauses the model execution. |
| `void` | `registerExperimentHost_xjal(IExperimentHost experimentHost)` | This method isn't designed to be called by user. |
| `void` | `run()` | Runs the model from the current state. |
| `void` | `runAndShowRoot_xjal()` | Deprecated. |
| `void` | `setNewEngine_xjal(Engine engine)` | This method is internal and shouldn't be called by user. |
| `abstract void` | `setupRootParameters(ROOT root, boolean callOnChangeActions)` | Is called to setup parameters of top-level agent. |
| `void` | `step()` | Performs one step of the model execution. |
| `void` | `stop()` | Terminates the model execution, destroys and forgets the model and calls garbage collector, but keeps all experiment data. |

## Constructor Details

### ExperimentSimulation
```java
public ExperimentSimulation()
```
Creates the experiment and a new simulation engine that will be used for all simulations.

## Method Details

### getEngine
```java
public Engine getEngine()
```
Returns the engine executing the model.

**Returns:** the engine executing the model

### getState
```java
public Experiment.State getState()
```
Returns the current state of the experiment. In case of ExperimentSimulation it is the same as the state of the engine and can be IDLE, PAUSED, RUNNING, STEP, FINISHED, ERROR.

**Returns:** the current state of the experiment

### getProgress
```java
public double getProgress()
```
Returns the progress of the experiment: in this case it is the same as the progress of the current simulation run.

**Returns:** the progress of the experiment

### getRunTimeSeconds
```java
public double getRunTimeSeconds()
```
Returns the real duration of the experiment in seconds, excluding pause times, in this case it is same as duration of the simulation run.

**Returns:** the real duration of the experiment in seconds

### run
```java
public void run()
```
Runs the model from the current state. If model is not yet existing, resets the experiment, creates and starts the model.

### step
```java
public void step()
```
Performs one step of the model execution. If model is not yet existing, resets the experiment, creates and starts the model (not making a step).

### pause
```java
public void pause()
```
Pauses the model execution.

**See Also:** `Engine.pause()`

### finish
```java
public void finish()
```
Sets a flag that, when tested by the engine, causes it to finish after completing the current event execution.

**See Also:** `Engine.finish()`

### stop
```java
public void stop()
```
Terminates the model execution, destroys and forgets the model and calls garbage collector, but keeps all experiment data.

**See Also:** `Engine.stop()`

### setupRootParameters
```java
public abstract void setupRootParameters(ROOT root, boolean callOnChangeActions)
```
Is called to setup parameters of top-level agent. This method must be defined in a subclass.

**Parameters:**
- `root` - the top-level agent instance
- `callOnChangeActions` - if true this method should use set_* methods of root to setup parameters, otherwise parameter values should be simply assigned to the fields of root
