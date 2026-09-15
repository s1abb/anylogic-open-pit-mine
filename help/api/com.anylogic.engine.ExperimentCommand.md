# Enum Class Experiment.Command

## Package
`com.anylogic.engine`

## Inheritance Hierarchy
```
java.lang.Object
  java.lang.Enum<Experiment.Command>
    com.anylogic.engine.Experiment.Command
```

## All Implemented Interfaces
`Serializable`, `Comparable<Experiment.Command>`, `Constable`

## Enclosing class
`Experiment<ROOT extends Agent>`

## Class Declaration
```java
public static enum Experiment.Command extends Enum<Experiment.Command>
```

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `static Experiment.Command` | `valueOf(String name)` | Returns the enum constant of this class with the specified name. |
| `static Experiment.Command[]` | `values()` | Returns an array containing the constants of this enum class, in the order they are declared. |

## Method Details

### values
```java
public static Experiment.Command[] values()
```
Returns an array containing the constants of this enum class, in the order they are declared.

**Returns:** an array containing the constants of this enum class, in the order they are declared

### valueOf
```java
public static Experiment.Command valueOf(String name)
```
Returns the enum constant of this class with the specified name. The string must match exactly an identifier used to declare an enum constant in this class. (Extraneous whitespace characters are not permitted.)

**Parameters:**
- `name` - the name of the enum constant to be returned.

**Returns:** the enum constant with the specified name

**Throws:**
- `IllegalArgumentException` - if this enum class has no constant with the specified name
- `NullPointerException` - if the argument is null
