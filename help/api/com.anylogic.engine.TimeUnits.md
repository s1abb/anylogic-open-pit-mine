# Enum TimeUnits

## Package
`com.anylogic.engine`

## Inheritance Hierarchy
```
java.lang.Object
  java.lang.Enum<TimeUnits>
    com.anylogic.engine.TimeUnits
```

## All Implemented Interfaces
`IUnits<TimeUnits>`, `Serializable`, `Comparable<TimeUnits>`, `Constable`

## Enum Declaration
```java
public enum TimeUnits extends Enum<TimeUnits> implements IUnits<TimeUnits>
```

## Description
Standard AnyLogic time units, should be used in specific functions and parameters which work with units.

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
| `double` | `convertTo(double value, TimeUnits units)` | Converts the given value from this units to the given units |
| `static TimeUnits` | `fromCalendarConstant(int timeUnit)` | This method is internal and shouldn't be called by user. It may be removed/renamed in future. |
| `int` | `getCalendarConstant()` | This method is internal and shouldn't be called by user. It may be removed/renamed in future. |
| `String` | `getName()` | Returns human-readable name (e.g. "seconds") |
| `boolean` | `isFixedLength()` | This method is internal and shouldn't be called by user. It may be removed/renamed in future. |
| `double` | `modifier(TimeUnits units)` | Returns the conversion modifier |
| `long` | `toMilliseconds()` | Converts the unit to milliseconds |
| `static TimeUnits` | `valueOf(String name)` | Returns the enum constant of this class with the specified name |
| `static TimeUnits[]` | `values()` | Returns an array containing the constants of this enum class, in the order they are declared |

### Methods inherited from class java.lang.Enum
`compareTo`, `describeConstable`, `equals`, `getDeclaringClass`, `hashCode`, `name`, `ordinal`, `toString`, `valueOf`

### Methods inherited from class java.lang.Object
`getClass`, `notify`, `notifyAll`, `wait`, `wait`, `wait`

### Methods inherited from interface com.anylogic.engine.IUnits
`name`

## Method Details

### values
```java
public static TimeUnits[] values()
```
Returns an array containing the constants of this enum class, in the order they are declared.

**Returns:** an array containing the constants of this enum class, in the order they are declared

### valueOf
```java
public static TimeUnits valueOf(String name)
```
Returns the enum constant of this class with the specified name. The string must match exactly an identifier used to declare an enum constant in this class. (Extraneous whitespace characters are not permitted.)

**Parameters:**
- `name` - the name of the enum constant to be returned.

**Returns:** the enum constant with the specified name

**Throws:**
- `IllegalArgumentException` - if this enum class has no constant with the specified name
- `NullPointerException` - if the argument is null

### getName
```java
public String getName()
```
Description copied from interface: IUnits

Returns human-readable name (e.g. "seconds")

**Specified by:** `getName` in interface `IUnits<TimeUnits>`

**Returns:** the human-readable name

### modifier
```java
public double modifier(TimeUnits units)
```
**Specified by:** `modifier` in interface `IUnits<TimeUnits>`

**Parameters:**
- `units` - the units to convert to

**Returns:** the conversion modifier

### convertTo
```java
public double convertTo(double value, TimeUnits units)
```
Description copied from interface: IUnits

Converts the given value from this units to the given units

**Specified by:** `convertTo` in interface `IUnits<TimeUnits>`

**Parameters:**
- `value` - the value, measured in this units
- `units` - units to convert the value to

**Returns:** the value, measured in the given units

### toMilliseconds
```java
@AnyLogicLegacyAPI
public long toMilliseconds()
```
Converts the unit to milliseconds

**Returns:** the number of milliseconds in this time unit

### getCalendarConstant
```java
@AnyLogicLegacyAPI
@AnyLogicInternalAPI
public int getCalendarConstant()
```
This method is internal and shouldn't be called by user. It may be removed/renamed in future.

**Returns:** one of Calendar constants (e.g. Calendar.YEAR)

### isFixedLength
```java
@AnyLogicInternalAPI
public boolean isFixedLength()
```
This method is internal and shouldn't be called by user. It may be removed/renamed in future.

**Returns:** e.g. true for HOUR, but false for DAY (because of possible DST days != 24 hours).

### fromCalendarConstant
```java
@AnyLogicLegacyAPI
@AnyLogicInternalAPI
public static TimeUnits fromCalendarConstant(int timeUnit)
```
This method is internal and shouldn't be called by user. It may be removed/renamed in future.

**Parameters:**
- `timeUnit` - one of Calendar constants (e.g. Calendar.YEAR)

**Returns:** the corresponding TimeUnits value
