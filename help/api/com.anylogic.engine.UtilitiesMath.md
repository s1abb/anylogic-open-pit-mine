# Interface UtilitiesMath

## Package
`com.anylogic.engine`

## All Known Implementing Classes
`Agent`, `Experiment`, `ExperimentCompareRuns`, `ExperimentMultipleRuns`, `ExperimentOptimization`, `ExperimentParamVariation`, `ExperimentRunFast`, `ExperimentSimulation`, `FlowchartBlock`, `Utilities`

## Interface Declaration
```java
public interface UtilitiesMath
```

## Description
Various math utilities.

**Author:** AnyLogic North America, LLC https://anylogic.com

## Field Summary
| Modifier and Type | Field | Description |
|-------------------|-------|-------------|
| `static final double` | `infinity` | A constant holding the positive infinity of type double. If you want to get negative infinity, please write -infinity |

## Method Summary

### Basic Math Operations
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `static double` | `sqr(double v)` | Returns the square of the given value (v²) |
| `static boolean` | `isFinite(double v)` | Returns true if the given value is finite (not +/-infinity or NaN) |
| `static int` | `roundToInt(double v)` | Returns int closest to the given value |
| `static double` | `roundToDecimal(double v, int nDecimalDigits)` | Rounds the value to the given precision |
| `static double` | `zidz(double a, double b)` | Tries to divide the first argument by the second |
| `static double` | `xidz(double a, double b, double x)` | Tries to divide the first argument by the second |

### Limiting Functions
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `static double` | `limitMin(double min, double x)` | Returns x if it is greater or equal to min, otherwise returns min |
| `static int` | `limitMin(int min, int x)` | Returns x if it is greater or equal to min, otherwise returns min |
| `static double` | `limitMax(double x, double max)` | Returns x if it is less or equal to max, otherwise returns max |
| `static int` | `limitMax(int x, int max)` | Returns x if it is less or equal to max, otherwise returns max |
| `static double` | `limit(double min, double x, double max)` | Returns x if it is within [min,max] interval, otherwise returns the closest bound |
| `static int` | `limit(int min, int x, int max)` | Returns x if it is within [min,max] interval, otherwise returns the closest bound |

### Advanced Math Functions
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `static double` | `gammaLog(double x)` | Returns the natural logarithm of the gamma function of x |
| `static double` | `quantum(double value, double quantizer)` | Returns the number smaller (by absolute value) than or equal to value that is an integer multiple of quantizer |
| `static double` | `atan2fast(double y, double x)` | Returns the angle theta from the conversion of rectangular coordinates (x, y) to polar coordinates (r, theta) |

### Data Analysis Functions
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `static double` | `difference(BasicDataSet ds, TableFunction f)` | Difference function which is always non-negative and reflects difference between given data set and table function in their common arguments range |
| `static double` | `difference(BasicDataSet ds1, BasicDataSet ds2)` | Difference function which is always non-negative and reflects difference between 2 given data sets in their common arguments range |

## Field Details

### infinity
```java
static final double infinity
```
A constant holding the positive infinity of type double. If you want to get negative infinity, please write -infinity.

## Method Details

### sqr
```java
static double sqr(double v)
```
Returns the square of the given value (v²).

**Parameters:**
- `v` - the value

**Returns:** v * v

### isFinite
```java
static boolean isFinite(double v)
```
Returns true if the given value is finite (not +/-infinity or NaN).

**Parameters:**
- `v` - the value

**Returns:** the result of -infinity < v && v < +infinity

### roundToInt
```java
static int roundToInt(double v)
```
Returns int closest to the given value. Unlike Math.round(double), returns int value (instead of long) which may be more convenient for some operations.

The result is equal to the expression: `(int) floor(v + 0.5)`

**Special cases:**
- If the argument is NaN, the result is 0.
- If the argument is negative infinity or any value less than or equal to Integer.MIN_VALUE, the result is Integer.MIN_VALUE.
- If the argument is positive infinity or any value greater than or equal to Integer.MAX_VALUE, the result is Integer.MAX_VALUE.

**Parameters:**
- `v` - floating-point value to be rounded to an int

**Returns:** the value rounded to the nearest int value

### roundToDecimal
```java
static double roundToDecimal(double v, int nDecimalDigits)
```
Rounds the value to the given precision. Returns the number closest to the given value, retaining the given number of decimal digits in the fractional/integer part.

The result is equal to the expression: `floor(v * 10^nDecimalDigits + 0.5) / 10^nDecimalDigits`

**Parameters:**
- `v` - floating-point value to be rounded to the given precision
- `nDecimalDigits` - if positive, fractional part will be affected; if negative, integer part will be

**Returns:** the value rounded to the given precision

**Since:** 7.3

### zidz
```java
static double zidz(double a, double b)
```
Tries to divide the first argument by the second. If the result is infinity or not a number, returns 0, otherwise returns the division result.

**Parameters:**
- `a` - first value
- `b` - second value

**Returns:** division result or 0

### xidz
```java
static double xidz(double a, double b, double x)
```
Tries to divide the first argument by the second. If the result is infinity or not a number, returns the third argument, otherwise returns the division result.

**Parameters:**
- `a` - first value
- `b` - second value
- `x` - defines return result in case of unsuccessful division

**Returns:** division result or x

### limitMin
```java
static double limitMin(double min, double x)
```
Returns x if it is greater or equal to min, otherwise returns min. May be more self-explanatory than the function max as it explicitly says "x is left-limited by min".

**Parameters:**
- `min` - left bound
- `x` - the value

**Returns:** x or min

### limitMin
```java
static int limitMin(int min, int x)
```
Returns x if it is greater or equal to min, otherwise returns min. May be more self-explanatory than the function max as it explicitly says "x is left-limited by min".

**Parameters:**
- `min` - left bound
- `x` - the value

**Returns:** x or min

### limitMax
```java
static double limitMax(double x, double max)
```
Returns x if it is less or equal to max, otherwise returns max. May be more self-explanatory than the function min as it explicitly says "x is right-limited by max".

**Parameters:**
- `x` - the value
- `max` - right bound

**Returns:** x or max

### limitMax
```java
static int limitMax(int x, int max)
```
Returns x if it is less or equal to max, otherwise returns max. May be more self-explanatory than the function min as it explicitly says "x is right-limited by max".

**Parameters:**
- `x` - the value
- `max` - right bound

**Returns:** x or max

### limit
```java
static double limit(double min, double x, double max)
```
Returns x if it is within [min,max] interval, otherwise returns the closest bound.

**Parameters:**
- `min` - left bound
- `x` - the value
- `max` - right bound

**Returns:** min, x or max

### limit
```java
static int limit(int min, int x, int max)
```
Returns x if it is within [min,max] interval, otherwise returns the closest bound.

**Parameters:**
- `min` - left bound
- `x` - the value
- `max` - right bound

**Returns:** min, x or max

### gammaLog
```java
static double gammaLog(double x)
```
Returns the natural logarithm of the gamma function of x: ln(Γ(x)).

The gamma function is an extension of the factorial function that works on all positive values of x. If n is a positive integer, then: Γ(n) = (n - 1)!.

The gammaLog function may be useful in System Dynamics models for computing combinatorial factors.

**Parameters:**
- `x` - the value

**Returns:** ln(Γ(x))

### quantum
```java
static double quantum(double value, double quantizer)
```
Returns the number smaller (by absolute value) than or equal to value that is an integer multiple of quantizer.

If quantizer is less than or equal to zero, then value is returned unchanged. For example, quantum(PI, 0.01) will return 3.14

**Parameters:**
- `value` - the value to quantize
- `quantizer` - the quantization step

**Returns:** quantized value

### difference
```java
static double difference(BasicDataSet ds, TableFunction f)
```
Difference function which is always non-negative and reflects difference between given data set and table function in their common arguments range.

**Parameters:**
- `ds` - data set
- `f` - table function with linear interpolation

**Returns:** square root of the average of square of difference between linearly interpolated data set and table function. The integration range is the intersection of argument ranges of data set and function.

### difference
```java
static double difference(BasicDataSet ds1, BasicDataSet ds2)
```
Difference function which is always non-negative and reflects difference between 2 given data sets in their common arguments range.

**Parameters:**
- `ds1` - first data set
- `ds2` - second data set

**Returns:** square root of the average of square of difference between linearly interpolated data sets. The integration range is the intersection of argument ranges of data sets.

### atan2fast
```java
static double atan2fast(double y, double x)
```
Returns the angle theta from the conversion of rectangular coordinates (x, y) to polar coordinates (r, theta). 

This method computes the phase theta by computing an arc tangent of y/x in the range of -pi to pi. Comparing with Math.atan2(double, double), instead of computation of value every time, this method uses precomputed table of values Math.atan2(double, double). Therefore atan2fast is approximately 20 times faster than Math.atan2(double, double). 

Average error (comparing to Math.atan2(double, double)) is 3e-5 radians, max error is 1e-4 radians. This Method does not accept special arguments like NaN or Infinities. It's recommended to use when you don't need extremely high accuracy and have assurance that your arguments are finite.

**Parameters:**
- `y` - the ordinate coordinate
- `x` - the abscissa coordinate

**Returns:** arctangent(y/x)
