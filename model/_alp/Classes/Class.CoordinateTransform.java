import java.io.Serializable;

/**
 * Utility class for transforming 3D coordinates between different coordinate systems.
 * Supports operations like swapping axes, flipping coordinates, and applying offsets.
 */
public class CoordinateTransform implements Serializable {
    public boolean swapYZ = false;        // Swap Y and Z coordinates
    public boolean flipX = false;         // Flip X coordinate sign (multiply by -1)
    public boolean flipY = false;         // Flip Y coordinate sign (multiply by -1)
    public boolean flipZ = false;         // Flip Z coordinate sign (multiply by -1)
    public double offsetX = 0.0;          // Global X offset to add
    public double offsetY = 0.0;          // Global Y offset to add
    public double offsetZ = 0.0;          // Global Z offset to add
    
    /**
     * Default constructor with no transformations
     */
    public CoordinateTransform() {
    }
    
    /**
     * Fully parameterized constructor
     */
    public CoordinateTransform(
            boolean swapYZ, 
            boolean flipX, boolean flipY, boolean flipZ,
            double offsetX, double offsetY, double offsetZ) {
        this.swapYZ = swapYZ;
        this.flipX = flipX;
        this.flipY = flipY;
        this.flipZ = flipZ;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.offsetZ = offsetZ;
    }
    
    /**
     * Apply transformation to a Vector3 coordinate
     */
    public Vector3 apply(Vector3 v) {
        double x = v.x;
        double y = v.y;
        double z = v.z;
        
        // Apply flipping
        if (flipX) x = -x;
        if (flipY) y = -y;
        if (flipZ) z = -z;
        
        // Swap Y and Z if needed
        if (swapYZ) {
            double temp = y;
            y = z;
            z = temp;
        }
        
        // Apply offsets
        x += offsetX;
        y += offsetY;
        z += offsetZ;
        
        return new Vector3(x, y, z);
    }
    
    /**
     * Create a default transformation for mine layouts
     * This can be modified as needed
     */
    public static CoordinateTransform createDefaultTransform() {
        CoordinateTransform transform = new CoordinateTransform();
        transform.swapYZ = true;    // Swap Y and Z coordinates
        transform.offsetX = 1100;   // Global X offset
        transform.offsetY = 800;    // Global Y offset
        return transform;
    }

	/**
	 * This number is here for model snapshot storing purpose<br>
	 * It needs to be changed when this class gets changed
	 */ 
	private static final long serialVersionUID = 1L;
}