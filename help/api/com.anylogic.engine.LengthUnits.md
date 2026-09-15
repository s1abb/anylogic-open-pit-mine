# Enum LengthUnits

## Package
`com.anylogic.engine`

## Inheritance Hierarchy
```
java.lang.Object
  java.lang.Enum<LengthUnits>
    com.anylogic.engine.LengthUnits
```

## All Implemented Interfaces
`IUnits<LengthUnits>`, `Serializable`, `Comparable<LengthUnits>`, `Constable`

## Enum Declaration
```java
public enum LengthUnits extends Enum<LengthUnits> implements IUnits<LengthUnits>
```

## Description
Standard AnyLogic length units, should be used in specific functions and parameters which work with units.

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
| `double` | `convertTo(double value, LengthUnits units)` | Converts the given value from this units to the given units |
| `String` | `formatName(boolean fullName)` | Formats the name of the unit |
| `String` | `getName()` | Returns human-readable name (e.g. "meters") |
| `double` | `modifier(LengthUnits units)` | Returns the conversion modifier |
| `static LengthUnits` | `valueOf(String name)` | Returns the enum constant of this class with the specified name |
| `static LengthUnits[]` | `values()` | Returns an array containing the constants of this enum class, in the order they are declared |

### Methods inherited from class java.lang.Enum
`compareTo`, `describeConstable`, `equals`, `getDeclaringClass`, `hashCode`, `name`, `ordinal`, `toString`, `valueOf`

### Methods inherited from class java.lang.Object
`getClass`, `notify`, `notifyAll`, `wait`, `wait`, `wait`

### Methods inherited from interface com.anylogic.engine.IUnits
`name`

## Method Details

### values
```java
public static LengthUnits[] values()
```
Returns an array containing the constants of this enum class, in the order they are declared.

**Returns:** an array containing the constants of this enum class, in the order they are declared

### valueOf
```java
public static LengthUnits valueOf(String name)
```
Returns the enum constant of this class with the specified name. The string must match exactly an identifier used to declare an enum constant in this class. (Extraneous whitespace characters are not permitted.)

**Parameters:**
- `name` - the name of the enum constant to be returned.

**Returns:** the enum constant with the specified name

**Throws:**
- `IllegalArgumentException` - if this enum class has no constant with the specified name
- `NullPointerException` - if the argument is null

### formatName
```java
public String formatName(boolean fullName)
```
Formats the name of the unit.

**Parameters:**
- `fullName` - whether to return the full name

**Returns:** the formatted name

### getName
```java
public String getName()
```
Description copied from interface: IUnits

Returns human-readable name (e.g. "meters")

**Specified by:** `getName` in interface `IUnits<LengthUnits>`

**Returns:** the human-readable name

### modifier
```java
public double modifier(LengthUnits units)
```
**Specified by:** `modifier` in interface `IUnits<LengthUnits>`

**Parameters:**
- `units` - the units to convert to

**Returns:** the conversion modifier

### convertTo
```java
public double convertTo(double value, LengthUnits units)
```
Description copied from interface: IUnits

Converts the given value from this units to the given units

**Specified by:** `convertTo` in interface `IUnits<LengthUnits>`

**Parameters:**
- `value` - the value, measured in this units
- `units` - units to convert the value to

**Returns:** the value, measured in the given units
