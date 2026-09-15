# Class ExperimentTest

## Package
`com.anylogic.engine`

## Inheritance Hierarchy
```
java.lang.Object
  com.anylogic.engine.ExperimentCustom
    com.anylogic.engine.ExperimentTest<ROOT>
```

## Type Parameters
- `ROOT` - class of top-level agent

## All Implemented Interfaces
`Serializable`

## Class Declaration
```java
@AnyLogicInternalAPI
public abstract class ExperimentTest<ROOT extends Agent> extends ExperimentCustom
```

## Description
This class is internal and shouldn't be called by user. It may be removed/renamed in future.

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `ExperimentSimulation<ROOT>` | `getSimulation()` | Gets the simulation experiment. |
| `void` | `run()` | Use `ExperimentCustom.createEngine()`. |
| `void` | `setupEngine_xjal(Engine engine)` | This method should not be called by user. |

## Method Details

### getSimulation
```java
public ExperimentSimulation<ROOT> getSimulation()
```
Gets the simulation experiment.

### run
```java
public void run()
```
Use `ExperimentCustom.createEngine()`.

### setupEngine_xjal
```java
public void setupEngine_xjal(Engine engine)
```
This method should not be called by user.
