import java.io.Serializable;

/**
 * Represents a 3D vector with x, y, and z coordinates.
 * Used for positioning components in 3D space.
 * 
 * @author Extend AnyLogic Library
 * @version 1.0.0
 */
public class Vector3 implements Serializable {
    
    public double x;
    public double y;
    public double z;
    
    /**
     * Default constructor (0,0,0)
     */
    public Vector3() {
        this(0, 0, 0);
    }
    
    /**
     * Constructor with coordinates
     * @param x x coordinate
     * @param y y coordinate
     * @param z z coordinate
     */
    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    /**
     * Copy constructor
     * @param other vector to copy
     */
    public Vector3(Vector3 other) {
        this(other.x, other.y, other.z);
    }
    
    /**
     * Calculate distance to another vector
     * @param other the other vector
     * @return distance in 3D space
     */
    public double distanceTo(Vector3 other) {
        double dx = x - other.x;
        double dy = y - other.y;
        double dz = z - other.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
    
    /**
     * Calculate 2D distance (X,Z plane) to another vector
     * @param other the other vector
     * @return distance in X,Z plane
     */
    public double distanceToXZ(Vector3 other) {
        double dx = x - other.x;
        double dz = z - other.z;
        return Math.sqrt(dx * dx + dz * dz);
    }
    
    /**
     * Calculate squared 2D distance (X,Z plane) to another vector
     * @param other the other vector
     * @return squared distance in X,Z plane
     */
    public double distanceSquaredTo2D(Vector3 other) {
        double dx = x - other.x;
        double dz = z - other.z;
        return dx * dx + dz * dz;
    }
    
    /**
     * Add another vector to this one
     * @param other vector to add
     * @return this vector for chaining
     */
    public Vector3 add(Vector3 other) {
        this.x += other.x;
        this.y += other.y;
        this.z += other.z;
        return this;
    }
    
    /**
     * Subtract another vector from this one
     * @param other vector to subtract
     * @return this vector for chaining
     */
    public Vector3 subtract(Vector3 other) {
        this.x -= other.x;
        this.y -= other.y;
        this.z -= other.z;
        return this;
    }
    
    /**
     * Multiply this vector by a scalar
     * @param scalar scalar to multiply by
     * @return this vector for chaining
     */
    public Vector3 multiply(double scalar) {
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
        return this;
    }
    
    /**
     * Normalize this vector (make it unit length)
     * @return this vector for chaining
     */
    public Vector3 normalize() {
        double length = length();
        if (length > 0) {
            this.x /= length;
            this.y /= length;
            this.z /= length;
        }
        return this;
    }
    
    /**
     * Calculate the length of this vector
     * @return vector length
     */
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }
    
    /**
     * Calculate the dot product with another vector
     * @param other the other vector
     * @return dot product
     */
    public double dot(Vector3 other) {
        return x * other.x + y * other.y + z * other.z;
    }
    
    /**
     * Calculate the cross product with another vector
     * @param other the other vector
     * @return new vector representing the cross product
     */
    public Vector3 cross(Vector3 other) {
        return new Vector3(
            y * other.z - z * other.y,
            z * other.x - x * other.z,
            x * other.y - y * other.x
        );
    }
    
    public String toString() {
        return String.format("(%.2f, %.2f, %.2f)", x, y, z);
    }
    
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vector3 other = (Vector3) obj;
        return Double.compare(other.x, x) == 0 &&
               Double.compare(other.y, y) == 0 &&
               Double.compare(other.z, z) == 0;
    }
    
    public int hashCode() {
        int result = 17;
        result = 31 * result + Double.hashCode(x);
        result = 31 * result + Double.hashCode(y);
        result = 31 * result + Double.hashCode(z);
        return result;
    }

	/**
	 * This number is here for model snapshot storing purpose<br>
	 * It needs to be changed when this class gets changed
	 */ 
	private static final long serialVersionUID = 1L;
}