# Interface UtilitiesString

## Package
`com.anylogic.engine`

## All Known Implementing Classes
`Agent`, `Experiment`, `ExperimentCompareRuns`, `ExperimentMultipleRuns`, `ExperimentOptimization`, `ExperimentParamVariation`, `ExperimentRunFast`, `ExperimentSimulation`, `FlowchartBlock`, `Utilities`

## Interface Declaration
```java
public interface UtilitiesString
```

## Description
Various string utilities, e.g. number formatting.

**Author:** AnyLogic North America, LLC https://anylogic.com

## Method Summary

### Basic Formatting
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `static String` | `format(boolean value)` | Formats a boolean value |
| `static String` | `format(char value)` | Formats a character to String |
| `static String` | `format(double value)` | Formats a double value using the default AnyLogic formatter |
| `static String` | `format(int value)` | Formats an integer value using the default AnyLogic formatter |
| `static String` | `format(long value)` | Formats a long value using the default AnyLogic formatter |
| `static String` | `format(Date date)` | Formats a date using the default AnyLogic formatter |

### Units Formatting
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `static String` | `format(double value, IUnits<?> units)` | Formats a double value with units, using the default AnyLogic formatter |
| `static String` | `formatAmountUnits(double value, AmountUnits units)` | Converts value to required units and turns it into String |
| `static String` | `formatFlowRateUnits(double value, FlowRateUnits units)` | Converts value to required units and turns it into String |
| `static String` | `formatLengthUnits(double value, LengthUnits units)` | Converts value to required units and turns it into String |
| `static String` | `formatSpeedUnits(double value, SpeedUnits units)` | Converts value to required units and turns it into String |
| `static String` | `formatLengthUnits(LengthUnits unit, boolean fullName)` | Returns the full or short name of the length units |

### Date and Time Formatting
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `static String` | `formatDayOfWeek(int dayOfWeek, boolean fullName)` | Returns the full or short name of the weekday |
| `static String` | `formatMonth(int month, boolean fullName)` | Returns the full or short name of the month |

### Parsing
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `static int` | `parseInt(String text)` | Inverse operation of format(int) |

## Method Details

### format
```java
static String format(double value)
```
Formats a double value using the default AnyLogic formatter.

**Parameters:**
- `value` - the double value to be formatted

**Returns:** the string containing the formatted value

### format
```java
static String format(double value, IUnits<?> units)
```
Formats a double value with units, using the default AnyLogic formatter.

**Parameters:**
- `value` - the double value to be formatted
- `units` - units

**Returns:** the string containing the formatted value

**Since:** 8.0

### format
```java
static String format(int value)
```
Formats an integer value using the default AnyLogic formatter.

**Parameters:**
- `value` - the integer value to be formatted

**Returns:** the string containing the formatted value

### format
```java
static String format(long value)
```
Formats a long value using the default AnyLogic formatter.

**Parameters:**
- `value` - the long value to be formatted

**Returns:** the string containing the formatted value

### format
```java
static String format(Date date)
```
Formats a date using the default AnyLogic formatter.

**Parameters:**
- `date` - the date to be formatted

**Returns:** the string containing the formatted value

### format
```java
static String format(boolean value)
```
Formats a boolean value.

**Parameters:**
- `value` - the boolean value to be formatted

**Returns:** the string containing the formatted value ("true" or "false")

### format
```java
static String format(char value)
```
Formats a character to String.

**Parameters:**
- `value` - the character value to be formatted

**Returns:** the string containing the formatted value

### formatDayOfWeek
```java
static String formatDayOfWeek(int dayOfWeek, boolean fullName)
```
Returns the full or short name of the weekday.

**Parameters:**
- `dayOfWeek` - one of MONDAY, TUESDAY, ... constants
- `fullName` - if true, then returns the full name ("Monday", "Tuesday", etc.), otherwise - short ("Mon", "Tue", etc.)

**Returns:** the name of the weekday

### formatMonth
```java
static String formatMonth(int month, boolean fullName)
```
Returns the full or short name of the month.

**Parameters:**
- `month` - one of JANUARY, FEBRUARY, ... constants
- `fullName` - if true, then returns the full name ("January", "February", etc.), otherwise - short ("Jan", "Feb", etc.)

**Returns:** the name of the month

### formatLengthUnits
```java
static String formatLengthUnits(LengthUnits unit, boolean fullName)
```
Returns the full or short name of the length units.

**Parameters:**
- `unit` - length units
- `fullName` - if true, then returns the full name ("meter", "foot", etc.), otherwise - short ("m", "ft", etc.)

**Returns:** the name of the units

### formatAmountUnits
```java
static String formatAmountUnits(double value, AmountUnits units)
```
Converts value to required units and turns it into String.

**Parameters:**
- `value` - value in cubic meters or kilograms
- `units` - required units

**Returns:** string representation

### formatFlowRateUnits
```java
static String formatFlowRateUnits(double value, FlowRateUnits units)
```
Converts value to required units and turns it into String.

**Parameters:**
- `value` - value in cubic meters per second or kilograms per second
- `units` - required units

**Returns:** string representation

### formatLengthUnits
```java
static String formatLengthUnits(double value, LengthUnits units)
```
Converts value to required units and turns it into String.

**Parameters:**
- `value` - value in meters
- `units` - required units

**Returns:** string representation

### formatSpeedUnits
```java
static String formatSpeedUnits(double value, SpeedUnits units)
```
Converts value to required units and turns it into String.

**Parameters:**
- `value` - value in meters per second
- `units` - required units

**Returns:** string representation

### parseInt
```java
static int parseInt(String text) throws ParseException
```
This method is internal and shouldn't be called by user. It may be removed/renamed in future.
Inverse operation of format(int).

**Parameters:**
- `text` - the text to parse

**Returns:** the parsed integer value

**Throws:** ParseException - if the text cannot be parsed as an integer
