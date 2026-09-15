# Enum SpeedUnits

## Package
`com.anylogic.engine`

## Inheritance Hierarchy
```
java.lang.Object
  java.lang.Enum<SpeedUnits>
    com.anylogic.engine.SpeedUnits
```

## All Implemented Interfaces
`IUnits<SpeedUnits>`, `Serializable`, `Comparable<SpeedUnits>`, `Constable`

## Enum Declaration
```java
public enum SpeedUnits extends Enum<SpeedUnits> implements IUnits<SpeedUnits>
```

## Description
Standard AnyLogic speed units, should be used in specific functions and parameters which work with units.

**Author:** AnyLogic North America, LLC https://anylogic.com

## Nested Class Summary

### Nested classes/interfaces inherited from class java.lang.Enum
`Enum.EnumDesc<E extends Enum<E>>`

## Field Summary

### Fields inherited from interface com.anylogic.engine.IUnits
`ALL_UNIT_TYPES`

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `double` | `convertTo(double value, SpeedUnits units)` | Converts the given value from this units to the given units |
| `LengthUnits` | `getLengthUnits()` | Returns the length units component of this speed unit |
| `String` | `getName()` | Returns human-readable name (e.g. "meters per second") |
| `TimeUnits` | `getTimeUnits()` | Returns the time units component of this speed unit |
| `double` | `modifier(SpeedUnits units)` | Returns the conversion modifier |
| `static SpeedUnits` | `valueOf(String name)` | Returns the enum constant of this class with the specified name |
| `static SpeedUnits[]` | `values()` | Returns an array containing the constants of this enum class, in the order they are declared |

### Methods inherited from class java.lang.Enum
`compareTo`, `describeConstable`, `equals`, `getDeclaringClass`, `hashCode`, `name`, `ordinal`, `toString`, `valueOf`

### Methods inherited from class java.lang.Object
`getClass`, `notify`, `notifyAll`, `wait`, `wait`, `wait`

### Methods inherited from interface com.anylogic.engine.IUnits
`name`

## Method Details

### values
```java
public static SpeedUnits[] values()
```
Returns an array containing the constants of this enum class, in the order they are declared.

**Returns:** an array containing the constants of this enum class, in the order they are declared

### valueOf
```java
public static SpeedUnits valueOf(String name)
```
Returns the enum constant of this class with the specified name. The string must match exactly an identifier used to declare an enum constant in this class. (Extraneous whitespace characters are not permitted.)

**Parameters:**
- `name` - the name of the enum constant to be returned.

**Returns:** the enum constant with the specified name

**Throws:**
- `IllegalArgumentException` - if this enum class has no constant with the specified name
- `NullPointerException` - if the argument is null

### getLengthUnits
```java
public LengthUnits getLengthUnits()
```
Returns the length units component of this speed unit.

**Returns:** the length units component

### getTimeUnits
```java
public TimeUnits getTimeUnits()
```
Returns the time units component of this speed unit.

**Returns:** the time units component

### getName
```java
public String getName()
```
Description copied from interface: IUnits

Returns human-readable name (e.g. "meters per second")

**Specified by:** `getName` in interface `IUnits<SpeedUnits>`

**Returns:** the human-readable name

### modifier
```java
public double modifier(SpeedUnits units)
```
**Specified by:** `modifier` in interface `IUnits<SpeedUnits>`

**Parameters:**
- `units` - the units to convert to

**Returns:** the conversion modifier

### convertTo
```java
public double convertTo(double value, SpeedUnits units)
```
Description copied from interface: IUnits

Converts the given value from this units to the given units

**Specified by:** `convertTo` in interface `IUnits<SpeedUnits>`

**Parameters:**
- `value` - the value, measured in this units
- `units` - units to convert the value to

**Returns:** the value, measured in the given units
