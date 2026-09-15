# Interface ExperimentExecutionListener

## Package
`com.anylogic.engine`

## All Superinterfaces
`Serializable`

## Interface Declaration
```java
@AnyLogicInternalAPI
public interface ExperimentExecutionListener extends Serializable
```

## Description
This class is internal and shouldn't be called by user. It may be removed/renamed in future.

**Author:** AnyLogic North America, LLC https://anylogic.com

**See Also:**
- `Experiment.addExecutionListener(ExperimentExecutionListener)`
- `Experiment.removeExecutionListener(ExperimentExecutionListener)`

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `default void` | `onAfterSimulationRun(Agent root)` | This method is internal and shouldn't be called by user. |
| `default void` | `onBeforeSimulationRun(Agent root)` | This method is internal and shouldn't be called by user. |

## Method Details

### onBeforeSimulationRun
```java
@AnyLogicInternalAPI
@AnyLogicInternalCodegenAPI
default void onBeforeSimulationRun(Agent root)
```
This method is internal and shouldn't be called by user. It may be removed/renamed in future.

### onAfterSimulationRun
```java
@AnyLogicInternalAPI
@AnyLogicInternalCodegenAPI
default void onAfterSimulationRun(Agent root)
```
This method is internal and shouldn't be called by user. It may be removed/renamed in future.
