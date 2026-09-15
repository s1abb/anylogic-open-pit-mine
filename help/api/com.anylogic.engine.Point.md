# Class Point

## Inheritance Hierarchy
java.lang.Object  
&nbsp;&nbsp;&nbsp;└── com.anylogic.engine.Point

## All Implemented Interfaces
Locatable2D, Serializable, Cloneable

## Direct Known Subclasses
Position

```java
public class Point extends Object implements Serializable, Cloneable, Locatable2D
```

Class representing Point structure: three coordinates (x, y, z). Used in various utility methods in the AnyLogic Engine and in some AnyLogic libraries.
For those utilities which operate in 2D space (x, y), the third (z) coordinate is simply ignored.

**Author:** AnyLogic North America, LLC https://anylogic.com

**See Also:** Serialized Form

## Field Summary

| Modifier and Type | Field | Description |
|-------------------|-------|-------------|
| `double` | `x` | The x coordinate of this Point |
| `double` | `y` | The y coordinate of this Point |
| `double` | `z` | The z coordinate of this Point |

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `Point()` | Creates new point with zero (0, 0, 0) coordinates |
| `Point(double x, double y)` | Creates new point with the given (x, y) coordinates |
| `Point(double x, double y, double z)` | Creates new point with the given coordinates |
| `Point(Point p)` | Creates a copy of the given point |

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `Point` | `add(Point p)` | Adds p to this point: moves this point by the offset specified by the given point p |
| `Point` | `clone()` | Creates a copy of this point |
| `Point` | `clone(Point out)` | Fills the given output instance (if it is not null) or otherwise creates a copy of this object and returns it |
| `double` | `distance(double px, double py)` | Returns the distance from this Point to the specified point |
| `double` | `distance(double px, double py, double pz)` | Returns the distance from this Point to the specified point |
| `double` | `distance(Point p)` | Returns the distance from this Point to the specified Point |
| `double` | `distance2D(Point p)` | Returns the distance from this Point to the specified Point |
| `double` | `distanceGIS(double lat, double lon)` | Returns the distance from this Point to the specified (lat, lon) on GIS surface |
| `double` | `distanceGIS(double lat, double lon, LengthUnits units)` | Returns the distance from this Point to the specified (lat, lon) on GIS surface |
| `double` | `distanceGIS(Point p)` | Returns the distance from this Point to the specified Point on GIS surface |
| `double` | `distanceGIS(Point p, LengthUnits units)` | Returns the distance from this Point to the specified Point on GIS surface |
| `double` | `distanceSq(double px, double py)` | Returns the square of the distance from this Point to the specified point |
| `double` | `distanceSq(double px, double py, double pz)` | Returns the square of the distance from this Point to the specified point |
| `double` | `distanceSq(Point p)` | Returns the square of the distance from this Point to the specified Point |
| `double` | `distanceSq2D(Point p)` | Returns the square of the distance from this Point to the specified Point |
| `boolean` | `equals(Point p, double relativeError)` | Returns true if this point has the same coordinates as in the given point, within the given relative error |
| `boolean` | `equals(Object obj)` | Returns true if the given object is Point and it has exactly the same coordinates as in this Point |
| `boolean` | `equals2D(Point p, double relativeError)` | Returns true if this point has the same (x, y) coordinates (z is ignored) as in the given point, within the given relative error |
| `double` | `getLatitude()` | Returns the latitude of this Point |
| `double` | `getLongitude()` | Returns the longitude if this Point |
| `double` | `getX()` | Returns the x coordinate of this Point |
| `double` | `getY()` | Returns the y coordinate of this Point |
| `double` | `getZ()` | Returns the z coordinate of this Point |
| `int` | `hashCode()` | Returns the hash code for this point |
| `Point` | `setLatLon(double lat, double lon)` | Set latitude and longitude of this Point |
| `Point` | `setLocation(double x, double y)` | Sets the location of this Point to the given coordinates |
| `Point` | `setLocation(double x, double y, double z)` | Sets the location of this Point to the given coordinates |
| `Point` | `setLocation(Point p)` | Sets the location of this Point to the same coordinates as in the given Point object |
| `Point` | `sub(Point p)` | Subtracts p from this point: moves this point by the negative offset specified by the given point p |
| `String` | `toString()` | Returns a string representation of this point |

### Methods inherited from class java.lang.Object
getClass, notify, notifyAll, wait, wait, wait

## Field Details

### x
```java
public double x
```
The x coordinate of this Point. In case of GIS environment this is the latitude of this Point, measured in degrees (-90 ... (South) ... 0 ... (North) ... +90)

### y
```java
public double y
```
The y coordinate of this Point. In case of GIS environment this is the longitude of the Point, measured in degrees (-180 ... (West) ... 0 ... (East) ... +180)

### z
```java
public double z
```
The z coordinate of this Point.

## Constructor Details

### Point
```java
public Point()
```
Creates new point with zero (0, 0, 0) coordinates

### Point
```java
public Point(Point p)
```
Creates a copy of the given point

**Parameters:**
- `p` - the original point

### Point
```java
public Point(double x, double y, double z)
```
Creates new point with the given coordinates.

**Parameters:**
- `x` - the x coordinate of the Point
- `y` - the y coordinate of the Point
- `z` - the z coordinate of the Point

### Point
```java
public Point(double x, double y)
```
Creates new point with the given (x, y) coordinates. (z coordinate is set to zero)

**Parameters:**
- `x` - the x coordinate of the Point. In case of GIS environment this is the latitude of the Point, measured in degrees (-90 ... (South) ... 0 ... (North) ... +90)
- `y` - the y coordinate of the Point. In case of GIS environment this is the longitude of the Point, measured in degrees (-180 ... (West) ... 0 ... (East) ... +180)

## Method Details

### getX
```java
public double getX()
```
Returns the x coordinate of this Point

**Specified by:** getX in interface Locatable2D

**Returns:** the x coordinate of this Point

### getY
```java
public double getY()
```
Returns the y coordinate of this Point

**Specified by:** getY in interface Locatable2D

**Returns:** the y coordinate of this Point

### getZ
```java
public double getZ()
```
Returns the z coordinate of this Point

**Returns:** the z coordinate of this Point

### setLocation
```java
public Point setLocation(double x, double y, double z)
```
Sets the location of this Point to the given coordinates.

**Parameters:**
- `x` - the new x coordinate of this Point
- `y` - the new y coordinate of this Point
- `z` - the new z coordinate of this Point

**Returns:** this Point object

### setLocation
```java
public Point setLocation(double x, double y)
```
Sets the location of this Point to the given coordinates. (z coordinate is not changed)

**Parameters:**
- `x` - the new x coordinate of this Point. In case of GIS environment this is the latitude of this Point, measured in degrees (-90 ... (South) ... 0 ... (North) ... +90)
- `y` - the y coordinate of the Point. In case of GIS environment this is the longitude of this Point, measured in degrees (-180 ... (West) ... 0 ... (East) ... +180)

**Returns:** this Point object

### setLatLon
```java
public Point setLatLon(double lat, double lon)
```
Set latitude and longitude of this Point

**Parameters:**
- `lat` - the latitude coordinate of the Point measured in degrees (-90 ... (South) ... 0 ... (North) ... +90)
- `lon` - the longitude coordinate of the Point measured in degrees (-180 ... (West) ... 0 ... (East) ... +180)

**Returns:** this Point object

### setLocation
```java
public Point setLocation(Point p)
```
Sets the location of this Point to the same coordinates as in the given Point object.

**Parameters:**
- `p` - the specified Point to which to set this Point

**Returns:** this Point object

### add
```java
public Point add(Point p)
```
Adds p to this point: moves this point by the offset specified by the given point p. In other words, increments coordinates of this point by the values of p's coordinates.
Returns this point for convenience.

**Parameters:**
- `p` - the point which will be added to this point

**Returns:** this point

### sub
```java
public Point sub(Point p)
```
Subtracts p from this point: moves this point by the negative offset specified by the given point p. In other words, decrements coordinates of this point by the values of p's coordinates.
Returns this point for convenience.

**Parameters:**
- `p` - the point which will be subtracted from this point

**Returns:** this point

### distanceSq
```java
public double distanceSq(Point p)
```
Returns the square of the distance from this Point to the specified Point.
This method is useful for comparing different distances, finding nearest point etc. because of better performance compared with distance()

**Parameters:**
- `p` - the specified point to be measured against this Point

**Returns:** the square of the distance between this Point and the specified Point.

### distanceSq2D
```java
public double distanceSq2D(Point p)
```
Returns the square of the distance from this Point to the specified Point. Z coordinate isn't used in calculation.
This method is useful for comparing different distances, finding nearest point etc. because of better performance compared with distance()

**Parameters:**
- `p` - the specified point to be measured against this Point

**Returns:** the square of the distance between this Point and the specified Point in the XY-plane (2D).

### distanceSq
```java
public double distanceSq(double px, double py)
```
Returns the square of the distance from this Point to the specified point. Z coordinate isn't used in calculation.
This method is useful for comparing different distances, finding nearest point etc. because of better performance compared with distance()

**Parameters:**
- `px` - the x coordinate of the specified point to be measured against this Point
- `py` - the y coordinate of the specified point to be measured against this Point

**Returns:** the square of the distance between this Point and the specified point in the XY-plane (2D).

### distance
```java
public double distance(double px, double py)
```
Returns the distance from this Point to the specified point. Z coordinate isn't used in calculation.

**Parameters:**
- `px` - the x coordinate of the specified point to be measured against this Point
- `py` - the y coordinate of the specified point to be measured against this Point

**Returns:** the distance between this Point and the specified point.

### distanceSq
```java
public double distanceSq(double px, double py, double pz)
```
Returns the square of the distance from this Point to the specified point.
This method is useful for comparing different distances, finding nearest point etc. because of better performance compared with distance()

**Parameters:**
- `px` - the x coordinate of the specified point to be measured against this Point
- `py` - the y coordinate of the specified point to be measured against this Point
- `pz` - the z coordinate of the specified point to be measured against this Point

**Returns:** the square of the distance between this Point and the specified point.

### distance
```java
public double distance(double px, double py, double pz)
```
Returns the distance from this Point to the specified point.

**Parameters:**
- `px` - the x coordinate of the specified point to be measured against this Point
- `py` - the y coordinate of the specified point to be measured against this Point
- `pz` - the z coordinate of the specified point to be measured against this Point

**Returns:** the distance between this Point and the specified point.

### distance
```java
public double distance(Point p)
```
Returns the distance from this Point to the specified Point.

**Parameters:**
- `p` - the specified point to be measured against this Point

**Returns:** the distance between this Point and the specified Point.

### distanceGIS
```java
public double distanceGIS(Point p)
```
Returns the distance from this Point to the specified Point on GIS surface. Latitude and Longitude used.

**Parameters:**
- `p` - the specified point to be measured against this Point

**Returns:** the distance between this Point and the specified Point in meters.

### distanceGIS
```java
public double distanceGIS(Point p, LengthUnits units)
```
Returns the distance from this Point to the specified Point on GIS surface. Latitude and Longitude used.

**Parameters:**
- `p` - the specified point to be measured against this Point
- `units` - the units of length

**Returns:** the distance between this Point and the specified Point in given length units.

### distanceGIS
```java
public double distanceGIS(double lat, double lon)
```
Returns the distance from this Point to the specified (lat, lon) on GIS surface.

**Parameters:**
- `lat` - the latitude coordinate of the Point measured in degrees (-90 ... (South) ... 0 ... (North) ... +90)
- `lon` - the longitude coordinate of the Point measured in degrees (-180 ... (West) ... 0 ... (East) ... +180)

**Returns:** the distance in meters between this Point and the specified (lat, lon).

### distanceGIS
```java
public double distanceGIS(double lat, double lon, LengthUnits units)
```
Returns the distance from this Point to the specified (lat, lon) on GIS surface.

**Parameters:**
- `lat` - the latitude coordinate of the Point measured in degrees (-90 ... (South) ... 0 ... (North) ... +90)
- `lon` - the longitude coordinate of the Point measured in degrees (-180 ... (West) ... 0 ... (East) ... +180)
- `units` - the units of length

**Returns:** the distance in given length units between this Point and the specified (lat, lon).

### distance2D
```java
public double distance2D(Point p)
```
Returns the distance from this Point to the specified Point. Z coordinate isn't used in calculation.

**Parameters:**
- `p` - the specified point to be measured against this Point

**Returns:** the distance between this Point and the specified Point in the XY-plane (2D).

### toString
```java
public String toString()
```
Returns a string representation of this point.

**Overrides:** toString in class Object

**Returns:** a string representation of this point

### clone
```java
public Point clone()
```
Creates a copy of this point.

**Returns:** a copy of this point

### hashCode
```java
public int hashCode()
```
Returns the hash code for this point.

**Overrides:** hashCode in class Object

**Returns:** the hash code for this point

### equals
```java
public boolean equals(Object obj)
```
Returns true if the given object is Point and it has exactly the same coordinates as in this Point. Note that due to numeric errors there may cases when some calculated point has slightly different coordinates and hence doesn't match with expected value.

**Overrides:** equals in class Object

**Parameters:**
- `obj` - the object to compare with

**Returns:** true if the objects are the same; false otherwise

**See Also:** equals(Point, double)

### equals
```java
public boolean equals(Point p, double relativeError)
```
Returns true if this point has the same coordinates as in the given point, within the given relative error. Each pair of coordinates is compared separately using this formula:
|x1 - x2| <= relativeError * max( |x1|, |x2| )

**Parameters:**
- `p` - the point to compare to
- `relativeError` - relative error, applied to each coordinate separately

**Returns:** true if the points are equal within the given error; false otherwise

### equals2D
```java
public boolean equals2D(Point p, double relativeError)
```
Returns true if this point has the same (x, y) coordinates (z is ignored) as in the given point, within the given relative error. Each pair of coordinates is compared separately using this formula:
|x1 - x2| <= relativeError * max( |x1|, |x2| )

**Parameters:**
- `p` - the point to compare to
- `relativeError` - relative error, applied to each coordinate separately

**Returns:** true if the points are equal in 2D within the given error; false otherwise

### clone
```java
public Point clone(Point out)
```
Fills the given output instance (if it is not null) or otherwise creates a copy of this object and returns it

**Parameters:**
- `out` - the Point object to write to (may be null)

**Returns:** the given output object (if was not null) or new Point with coordinates set equal to this object.

### getLatitude
```java
public double getLatitude()
```
Returns the latitude of this Point

**Returns:** latitude

### getLongitude
```java
public double getLongitude()
```
Returns the longitude if this Point

**Returns:** longitude
