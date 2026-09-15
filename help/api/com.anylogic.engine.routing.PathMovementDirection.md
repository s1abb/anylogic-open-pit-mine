# Enum Class PathMovementDirection

## Inheritance Hierarchy
```
java.lang.Object
  java.lang.Enum<PathMovementDirection>
    com.anylogic.engine.routing.PathMovementDirection
```

## All Implemented Interfaces
`Serializable`, `Comparable<PathMovementDirection>`, `Constable`

## Enum Declaration
```java
public enum PathMovementDirection
extends Enum<PathMovementDirection>
```

## Description
Represents the direction of movement along a path.

## Nested Class Summary

### Nested classes/interfaces inherited from class java.lang.Enum
`Enum.EnumDesc<E extends Enum<E>>`

## Method Summary

| Modifier and Type | Method | Description |
|------------------|--------|-------------|
| `PathMovementDirection` | `reverse()` | Returns the opposite direction |
| `static PathMovementDirection` | `valueOf(String name)` | Returns the enum constant of this class with the specified name |
| `static PathMovementDirection[]` | `values()` | Returns an array containing the constants of this enum class, in the order they are declared |

## Methods inherited from class java.lang.Enum
`compareTo`, `describeConstable`, `equals`, `getDeclaringClass`, `hashCode`, `name`, `ordinal`, `toString`, `valueOf`

## Methods inherited from class java.lang.Object
`getClass`, `notify`, `notifyAll`, `wait`, `wait`, `wait`

## Method Details

### `values()`
- **Type**: `public static PathMovementDirection[]`
- **Description**: Returns an array containing the constants of this enum class, in the order they are declared
- **Returns**: An array containing the constants of this enum class, in the order they are declared

### `valueOf(String name)`
- **Type**: `public static PathMovementDirection`
- **Description**: Returns the enum constant of this class with the specified name. The string must match exactly an identifier used to declare an enum constant in this class. (Extraneous whitespace characters are not permitted.)
- **Parameters**:
  - `name`: The name of the enum constant to be returned
- **Returns**: The enum constant with the specified name
- **Throws**:
  - `IllegalArgumentException`: If this enum class has no constant with the specified name
  - `NullPointerException`: If the argument is null

### `reverse()`
- **Type**: `public PathMovementDirection`
- **Description**: Returns the opposite direction
- **Returns**: The opposite direction
