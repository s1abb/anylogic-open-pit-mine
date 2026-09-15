# Interface UtilitiesRandom

## Package
`com.anylogic.engine`

## All Known Implementing Classes
`Agent`, `Experiment`, `ExperimentCompareRuns`, `ExperimentMultipleRuns`, `ExperimentOptimization`, `ExperimentParamVariation`, `ExperimentRunFast`, `ExperimentSimulation`, `FlowchartBlock`, `Utilities`

## Interface Declaration
```java
public interface UtilitiesRandom
```

## Description
Random number generation utilities for various probability distributions.

**Author:** AnyLogic North America, LLC https://anylogic.com

## Field Summary
| Modifier and Type | Field | Description |
|-------------------|-------|-------------|
| `static final int` | `RANDOM_BOUNDED_DISTRIBUTIONS_MAX_ITERATIONS` | Maximum number of iterations for bounded distributions |

## Method Summary

### Basic Random Generation
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `default double` | `random()` | Generates a random value uniformly distributed on the interval [0,1) |
| `default double` | `uniform()` | Generates a random value uniformly distributed on the interval [0,1) |
| `default double` | `uniform(double max)` | Generates a sample of the Uniform distribution on the interval [0, max) |
| `default double` | `uniform(double min, double max)` | Generates a sample of the Uniform distribution on the interval [min, max) |
| `default double` | `uniform_pos()` | Generates a positive random value uniformly distributed on the interval (0,1) |
| `default int` | `uniform_discr(int max)` | Generates a sample of the Discrete Uniform distribution in the interval [0, max] |
| `default int` | `uniform_discr(int min, int max)` | Generates a sample of the Discrete Uniform distribution on the interval [min, max] |

### Continuous Distributions
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `default double` | `beta(double p, double q)` | Generates a sample of the Beta distribution |
| `default double` | `beta(double p, double q, double min, double max)` | Generates a sample of the Beta distribution |
| `default double` | `cauchy(double lambda)` | Generates a sample of the Cauchy distribution |
| `default double` | `cauchy(double lambda, double theta)` | Generates a sample of the Cauchy distribution |
| `default double` | `chi2(double nu)` | Generates a sample of the Chi Squared distribution |
| `default double` | `chi2(double nu, double min)` | Generates a sample of the Chi Squared distribution |
| `default double` | `erlang(double beta, int m)` | Generates a sample of the Erlang distribution |
| `default double` | `erlang(double beta, int m, double min)` | Generates a sample of the Erlang distribution |
| `default double` | `exponential()` | Generates a sample of the Exponential distribution |
| `default double` | `exponential(double lambda)` | Generates a sample of the Exponential distribution |
| `default double` | `exponential(double lambda, double min)` | Generates a sample of the Exponential distribution |
| `default double` | `gamma(double alpha, double beta)` | Generates a sample of the Gamma distribution |
| `default double` | `gamma(double alpha, double beta, double min)` | Generates a sample of the Gamma distribution |
| `default double` | `gumbel1(double a, double b)` | Generates a sample of the Type I Gumbel distribution |
| `default double` | `gumbel2(double a, double b)` | Generates a sample of the Type II Gumbel distribution |
| `default double` | `laplace(double phi, double theta)` | Generates a sample of the Laplace distribution |
| `default double` | `logistic(double beta, double alpha)` | Generates a sample of the Logistic distribution |
| `default double` | `lognormal(double mu, double sigma, double min)` | Generates a sample of the Lognormal distribution |
| `default double` | `normal()` | Generates a sample of the Normal distribution |
| `default double` | `normal(double sigma)` | Generates a sample of the Normal distribution |
| `default double` | `normal(double sigma, double mean)` | Generates a sample of the Normal distribution |
| `default double` | `pareto(double alpha)` | Generates a sample of the Pareto distribution |
| `default double` | `pareto(double alpha, double min)` | Generates a sample of the Pareto distribution |
| `default double` | `pert(double min, double max, double mode)` | Generates a sample of the PERT distribution |
| `default double` | `rayleigh(double sigma)` | Generates a sample of the Rayleigh distribution |
| `default double` | `rayleigh(double sigma, double min)` | Generates a sample of the Rayleigh distribution |
| `default double` | `triangular(double min, double max)` | Generates a sample of the Triangular distribution |
| `default double` | `triangular(double min, double max, double mode)` | Generates a sample of the Triangular distribution |
| `default double` | `triangularAV(double average, double variability)` | Generates a sample of the Triangular distribution with mode set to average |
| `default double` | `weibull(double beta, double alpha)` | Generates a sample of the Weibull distribution |
| `default double` | `weibull(double alpha, double beta, double min)` | Generates a sample of the Weibull distribution |

### Discrete Distributions
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `default int` | `bernoulli(double p)` | Generates a sample of the Bernoulli distribution |
| `default int` | `binomial(double p)` | Generates a sample of the Binomial distribution with n set to 1 |
| `default int` | `binomial(double p, int n)` | Generates a sample of the Binomial distribution |
| `default int` | `geometric(double p)` | Generates a sample of the Geometric distribution |
| `default int` | `hypergeometric(int ss, int dn, int ps)` | Generates a sample of the Hypergeometric distribution |
| `default int` | `logarithmic(double theta)` | Generates a sample of the Logarithmic distribution |
| `default int` | `negativeBinomial(double p, double n)` | Generates a sample of the Negative Binomial distribution |
| `default int` | `poisson(double lambda)` | Generates a sample of the Poisson distribution |

### Truncated Distributions
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `default double` | `beta(double min, double max, double p, double q, double shift, double stretch)` | Generates a sample of truncated Beta distribution |
| `default double` | `binomial(double min, double max, double p, double n, double shift, double stretch)` | Generates a sample of truncated Binomial distribution |
| `default double` | `exponential(double min, double max, double shift, double stretch)` | Generates a sample of truncated Exponential distribution |
| `default double` | `gamma(double min, double max, double alpha, double shift, double stretch)` | Generates a sample of truncated Gamma distribution |
| `default double` | `negativeBinomial(double min, double max, double p, double n, double shift, double stretch)` | Generates a sample of truncated Negative Binomial distribution |
| `default double` | `normal(double min, double max, double shift, double stretch)` | Generates a sample of truncated Normal distribution |
| `default double` | `poisson(double min, double max, double mean, double shift, double stretch)` | Generates a sample of truncated Poisson distribution |
| `default double` | `triangular(double min, double max, double left, double mode, double right)` | Generates a sample of truncated Triangular distribution |
| `default double` | `weibull(double min, double max, double alpha, double shift, double stretch)` | Generates a sample of truncated Weibull distribution |

### Boolean Generation
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `default boolean` | `randomTrue(double p)` | Generates true with the given probability p |
| `default boolean` | `randomFalse(double p)` | Generates false with the given probability p |

### Collection and Array Operations
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `default <T> T` | `randomFrom(T[] array)` | Returns the randomly chosen element of the given array |
| `default <T> T` | `randomFrom(Iterable<T> collection)` | Returns the randomly chosen element of the given collection |
| `default <T extends Enum<T>> T` | `randomFrom(Class<T> enumeration)` | Returns the randomly chosen enumeration constant |
| `default <T> T` | `randomWhere(T[] array, Predicate<T> condition)` | Returns the randomly chosen element of the given array which meets the given condition |
| `default <T> T` | `randomWhere(Iterable<T> collection, Predicate<T> condition)` | Returns the randomly chosen element of the given collection which meets the given condition |
| `default void` | `shuffle(List<?> list)` | Randomly permutes the specified list |

### Object Creation
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `default <T> T` | `randomlyCreate(Class<? extends T>... classes)` | Creates a randomly chosen object using one of the given constructors |
| `default <T> T` | `randomlyCreate(Supplier<? extends T>... constructors)` | Creates a randomly chosen object using one of the given constructors |

### Random Generator Access
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `Random` | `getDefaultRandomGenerator()` | Retrieves the random number generator used by all probability distributions by default |

## Method Details

### random
```java
default double random()
```
Generates a random value uniformly distributed on the interval [0,1), the upper bound is not included.

Please use uniform() function (has the same logic) instead, for not to get in confusion with Math.random() function (the latter shouldn't be used in models because it doesn't utilize random number generator of Engine and will result in not reproducible model runs).

**Returns:** a random value uniformly distributed on the interval [0,1)

### uniform
```java
default double uniform()
```
Generates a random value uniformly distributed on the interval [0,1), the upper bound is not included.

**Returns:** a random value uniformly distributed on the interval [0,1)

### uniform
```java
default double uniform(double max)
```
Generates a sample of the Uniform distribution on the interval [0, max).

**Parameters:**
- `max` - the upper bound of the interval (not included)

**Returns:** a random value uniformly distributed on the interval [0, max)

### uniform
```java
default double uniform(double min, double max)
```
Generates a sample of the Uniform distribution on the interval [min, max).

**Parameters:**
- `min` - the lower bound of the interval (included)
- `max` - the upper bound of the interval (not included)

**Returns:** a random value uniformly distributed on the interval [min, max)

### uniform_pos
```java
default double uniform_pos()
```
Generates a positive random value uniformly distributed on the interval (0,1).

**Returns:** a positive random value uniformly distributed on the interval (0,1)

### uniform_discr
```java
default int uniform_discr(int max)
```
Generates a sample of the Discrete Uniform distribution in the interval [0, max], both 0 and max included! Is equivalent to uniform_discr(0, max).

**Parameters:**
- `max` - the upper bound of the interval (included)

**Returns:** a random integer uniformly distributed on the interval [0, max]

### uniform_discr
```java
default int uniform_discr(int min, int max)
```
Generates a sample of the Discrete Uniform distribution on the interval [min, max], both min and max included!

**Parameters:**
- `min` - the lower bound of the interval (included)
- `max` - the upper bound of the interval (included)

**Returns:** a random integer uniformly distributed on the interval [min, max]

### normal
```java
default double normal()
```
Generates a sample of the Normal distribution with mean set to 0 and sigma set to 1.

**Returns:** a random value from the Normal distribution with mean 0 and sigma 1

### normal
```java
default double normal(double sigma)
```
Generates a sample of the Normal distribution with mean set to 0.

**Parameters:**
- `sigma` - the standard deviation

**Returns:** a random value from the Normal distribution with mean 0 and the given sigma

### normal
```java
default double normal(double sigma, double mean)
```
Generates a sample of the Normal distribution.

**Parameters:**
- `sigma` - the standard deviation
- `mean` - the mean

**Returns:** a random value from the Normal distribution with the given mean and sigma

### exponential
```java
default double exponential()
```
Generates a sample of the Exponential distribution with lambda set to 1 and min set to 0.

**Returns:** a random value from the Exponential distribution with lambda 1 and min 0

### exponential
```java
default double exponential(double lambda)
```
Generates a sample of the Exponential distribution with min set to 0.

**Parameters:**
- `lambda` - the rate parameter

**Returns:** a random value from the Exponential distribution with the given lambda and min 0

### exponential
```java
default double exponential(double lambda, double min)
```
Generates a sample of the Exponential distribution.

**Parameters:**
- `lambda` - the rate parameter
- `min` - the minimum value (shift)

**Returns:** a random value from the Exponential distribution with the given lambda and min

### triangular
```java
default double triangular(double min, double max)
```
Generates a sample of the Triangular distribution with mode set to (min + max)/2.

**Parameters:**
- `min` - the minimum value
- `max` - the maximum value

**Returns:** a random value from the Triangular distribution with the given min, max, and mode (min + max)/2

### triangular
```java
default double triangular(double min, double max, double mode)
```
Generates a sample of the Triangular distribution.

**Parameters:**
- `min` - the minimum value
- `max` - the maximum value
- `mode` - the mode (most likely value)

**Returns:** a random value from the Triangular distribution with the given min, max, and mode

### triangularAV
```java
default double triangularAV(double average, double variability)
```
Generates a sample of the Triangular distribution with mode set to average.
Defines distribution in the form like "roughly this, +/-20%".
Is equivalent to triangular(average * (1 - variability), average * (1 + variability)).

**Parameters:**
- `average` - the average value
- `variability` - the variability as a fraction (e.g., 0.2 for 20%)

**Returns:** a random value from the Triangular distribution with the given parameters

### randomTrue
```java
default boolean randomTrue(double p)
```
Generates true with the given probability p.

**Parameters:**
- `p` - the probability of generating true (0 <= p <= 1)

**Returns:** true with probability p, false with probability (1-p)

### randomFalse
```java
default boolean randomFalse(double p)
```
Generates false with the given probability p.

**Parameters:**
- `p` - the probability of generating false (0 <= p <= 1)

**Returns:** false with probability p, true with probability (1-p)

### randomFrom
```java
default <T> T randomFrom(T[] array)
```
Returns the randomly chosen element of the given array.
This result of this method is an equivalent of calling: array[uniform_discr(array.length - 1)]

**Parameters:**
- `array` - the array to choose from

**Returns:** a randomly chosen element from the array

### randomFrom
```java
default <T> T randomFrom(Iterable<T> collection)
```
Returns the randomly chosen element of the given collection.
For empty collections return null.
This result of this method is an equivalent of calling: collection.get(uniform_discr(collection.size() - 1))

**Parameters:**
- `collection` - the collection to choose from

**Returns:** a randomly chosen element from the collection, or null if the collection is empty

### randomFrom
```java
default <T extends Enum<T>> T randomFrom(Class<T> enumeration)
```
Returns the randomly chosen enumeration constant.
Throws NullPointerException if the given class is null or not an enumeration class

**Parameters:**
- `enumeration` - the enumeration class

**Returns:** a randomly chosen enumeration constant

### randomWhere
```java
default <T> T randomWhere(T[] array, Predicate<T> condition)
```
Returns the randomly chosen element of the given array which meets the given condition.

**Parameters:**
- `array` - the array to choose from
- `condition` - the condition that elements must satisfy

**Returns:** a randomly chosen element from the array that satisfies the condition, or null if no such element exists

### randomWhere
```java
default <T> T randomWhere(Iterable<T> collection, Predicate<T> condition)
```
Returns the randomly chosen element of the given collection which meets the given condition.
For empty collections return null.

**Parameters:**
- `collection` - the collection to choose from
- `condition` - the condition that elements must satisfy

**Returns:** a randomly chosen element from the collection that satisfies the condition, or null if no such element exists

### shuffle
```java
default void shuffle(List<?> list)
```
Randomly permutes the specified list.

**Parameters:**
- `list` - the list to be shuffled

### getDefaultRandomGenerator
```java
Random getDefaultRandomGenerator()
```
Retrieves the random number generator used by all probability distributions by default.

**Returns:** the default random number generator
