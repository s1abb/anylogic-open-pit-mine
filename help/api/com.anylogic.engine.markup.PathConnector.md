# PathConnector

## Package
`com.anylogic.engine.markup`

## Class
`PathConnector<P extends IPath<N>,N extends INode<N,P>>`

## Inheritance
```
java.lang.Object
  └── com.anylogic.engine.markup.PathConnector<P,N>
```

## All Implemented Interfaces
`Serializable`

## Description
Path connector inside a point node connects one path with another one. If moving in the opposite direction is possible then connector is also bidirectional.

## Author
AnyLogic North America, LLC https://anylogic.com

## See Also
Serialized Form

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `PathConnector(P startPath, P endPath, boolean bidirectional, MarkupSegment... segments)` | A connection between two paths inside PointNode |

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `P` | `getEndPath()` | Returns the path this connector ends at |
| `Path` | `getPathConnector()` | This method is internal and shouldn't be called by user. It may be removed/renamed in future. |
| `P` | `getStartPath()` | Returns the path this connector starts at |
| `boolean` | `isBidirectional()` | Returns the 'bidirectional' property |
| `double` | `length()` | |
| `double` | `length(LengthUnits units)` | |
| `String` | `toString()` | |

## Methods inherited from class java.lang.Object
`equals`, `getClass`, `hashCode`, `notify`, `notifyAll`, `wait`, `wait`, `wait`

## Constructor Details

### PathConnector
```java
public PathConnector(P startPath,
                    P endPath,
                    boolean bidirectional,
                    MarkupSegment... segments)
```
A connection between two paths inside PointNode

**Parameters:**  
`startPath` - from which path a connection will be created  
`endPath` - to which path a connection will be created  
`bidirectional` - if true allows agents to pass through the connection in reverse direction  
`segments` - the array of segments

## Method Details

### getStartPath
```java
public P getStartPath()
```
Returns the path this connector starts at

**Returns:**  
the reference to path this connector starts at

### getEndPath
```java
public P getEndPath()
```
Returns the path this connector ends at

**Returns:**  
the reference to path this connector ends at

### isBidirectional
```java
public boolean isBidirectional()
```
Returns the 'bidirectional' property

**Returns:**  
true for paths connected in both directions, false for paths connected from getStartPath() to getEndPath() only

### getPathConnector
```java
@AnyLogicInternalAPI
public Path getPathConnector()
```
This method is internal and shouldn't be called by user.
It may be removed/renamed in future.

### length
```java
@AnyLogicInternalAPI
public double length(LengthUnits units)
```

### length
```java
@AnyLogicInternalAPI
public double length()
```

### toString
```java
public String toString()
```
**Overrides:**  
`toString` in class `Object`
