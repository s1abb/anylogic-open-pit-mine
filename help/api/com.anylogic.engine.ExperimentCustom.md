# Class ExperimentCustom

## Package
`com.anylogic.engine`

## Inheritance Hierarchy
```
java.lang.Object
  com.anylogic.engine.ExperimentCustom
```

## All Implemented Interfaces
`Serializable`

## Direct Known Subclasses
`ExperimentReinforcementLearning`, `ExperimentTest`

## Class Declaration
```java
public abstract class ExperimentCustom extends Object implements Serializable
```

## Description
Base class for all custom experiments. The experiment scenario should be defined in the overridden `run()` method.

Custom experiment may be executed from another experiment - in this case the latter should be passed as an argument to the constructor of the custom experiment. Experiment is executed by calling `run()` method.

A sample action code of some Main agent which runs custom experiment:
```java
// Create custom experiment, pass currently running experiment
// as an argument to the constructor:
MyCustomExperiment e = new MyCustomExperiment(getExperiment());
// setup some custom fields defined in the
// additional class code of MyCustomExperiment:
e.day = getDayOfWeek();
// run experiment
e.run();
// collect results from custom fields defined in the
// additional class code of MyCustomExperiment:
traceln("result: " + e.myResult);
```
(In the example above, custom experiment has Code (which is actually inside run() method) which gets field day (defined in the additional class code), uses it in the experiment and then sets some result value to the field myResult)

### Usage notes
Use `createEngine()` to create new Engine instance. Use `Engine.runFast()` method to run experiment in the fastest possible mode.
Don't forget to setup stop time or stop date to the engine before.
Use `ExperimentOptimization.createOptimization(Engine)` to create new OptQuest Optimization instance.

The simplest example of `run()` code:
```java
// Create Engine, initialize random number generator:
Engine engine = createEngine();
// Set stop time
engine.setStopTime(100);
// Create new top-level agent:
Main root = new Main(engine, null, null);
// Setup parameters of top-level agent here
root.myParameter = 10;
// Prepare Engine for simulation:
engine.start(root);
// Start simulation in fast mode:
engine.runFast();
// Obtain results of simulation here
traceln(root.myResult);
// Destroy the model:
engine.stop();
```

This object is only available in the AnyLogic Professional.

See also an example of optimization performed within custom experiment.

**Author:** AnyLogic North America, LLC https://anylogic.com

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `ExperimentCustom(Object parentExperiment)` | Creates new custom experiment which may be executed from another experiment |

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `final Engine` | `createEngine()` | Creates Engine |
| `final String[]` | `getCommandLineArguments()` | Returns an array of Command-line Arguments passed to this experiment on model start |
| `void` | `onError(Throwable error)` | May be overridden for custom error processing |
| `void` | `onError(Throwable error, Agent root)` | May be overridden for custom error processing |
| `abstract void` | `run()` | Use `createEngine()` |
| `void` | `setCommandLineArguments_xjal(String[] commandLineArguments)` | This method should not be called by user |
| `void` | `setupEngine_xjal(Engine engine)` | This method should not be called by user |

## Constructor Details

### ExperimentCustom
```java
public ExperimentCustom(Object parentExperiment)
```
Creates new custom experiment which may be executed from another experiment - in this case the latter should be passed as an argument to the constructor of the custom experiment.

**Parameters:**
- `parentExperiment` - experiment which uses/runs this custom experiment (it may be experiment of any type: simulation, optimization, custom etc.)

## Method Details

### createEngine
```java
public final Engine createEngine()
```
Creates Engine.

**Returns:** new Engine instance

### run
```java
public abstract void run()
```
Use `createEngine()`.

### onError
```java
public void onError(Throwable error)
```
This method may be overridden to perform custom processing on errors in the model execution (i.e. errors in the action code of events, dynamic events, transitions, entry/exit codes of states etc, formulas, conditions of events etc.)

By default, this method does nothing.
This method shouldn't be called directly by user. Instead, engine calls it internally.

**Parameters:**
- `error` - an error which has occurred during event execution

### onError
```java
public void onError(Throwable error, Agent root)
```
This method may be overridden to perform custom processing on errors in the model execution (i.e. errors in the action code of events, dynamic events, transitions, entry/exit codes of states etc, formulas, conditions of events etc.)

By default, this method does nothing.
This method shouldn't be called directly by user. Instead, engine calls it internally.

**Parameters:**
- `error` - an error which has occurred during event execution
- `root` - the root (main) agent of the model, useful for experiments with multiple runs executed in parallel. May be null in some cases (e.g. on errors during root agent creation).

**Since:** 8.4

### getCommandLineArguments
```java
public final String[] getCommandLineArguments()
```
Returns an array of Command-line Arguments passed to this experiment on model start (empty array in case of no arguments).
Never returns null.
This method is designed for usage inside the `run()` method.

**Returns:** array of Command-line Arguments passed to this experiment on model start
