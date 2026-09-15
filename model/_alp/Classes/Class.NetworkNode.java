import java.io.Serializable;

/**
 * Represents a node in the network, typically an intersection point or endpoint.
 * This class is a data holder for node properties.
 */
public class NetworkNode implements Serializable {
    private String id;
    private Vector3 position;
    private String name;
    private String type;
    
    /**
     * Create a new NetworkNode
     * @param id Unique identifier
     * @param position 3D position
     * @param name Display name
     * @param type Node type (e.g., "STANDARD", "ENDPOINT", "INTERSECTION")
     */
    public NetworkNode(String id, Vector3 position, String name, String type) {
        this.id = id;
        this.position = position;
        this.name = name;
        this.type = type;
    }
    
    /**
     * Create a new NetworkNode with default name and type
     * @param id Unique identifier
     * @param position 3D position
     */
    public NetworkNode(String id, Vector3 position) {
        this(id, position, "Node " + id, "STANDARD");
    }
    
    /**
     * Get the node ID
     * @return Node ID
     */
    public String getId() {
        return id;
    }
    
    /**
     * Get the node position
     * @return 3D position
     */
    public Vector3 getPosition() {
        return position;
    }
    
    /**
     * Get the X coordinate
     * @return X coordinate
     */
    public double getX() {
        return position.x;
    }
    
    /**
     * Get the Y coordinate
     * @return Y coordinate
     */
    public double getY() {
        return position.y;
    }
    
    /**
     * Get the Z coordinate
     * @return Z coordinate
     */
    public double getZ() {
        return position.z;
    }
    
    /**
     * Get the node name
     * @return Node name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Get the node type
     * @return Node type
     */
    public String getType() {
        return type;
    }
    
    /**
     * Set the node ID
     * @param id New ID
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Set the node position
     * @param position New position
     */
    public void setPosition(Vector3 position) {
        this.position = position;
    }
    
    /**
     * Set the node name
     * @param name New name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Set the node type
     * @param type New type
     */
    public void setType(String type) {
        this.type = type;
    }
    
    public String toString() {
        return String.format("NetworkNode[id=%s, position=%s, name=%s, type=%s]", 
                id, position, name, type);
    }

	/**
	 * This number is here for model snapshot storing purpose<br>
	 * It needs to be changed when this class gets changed
	 */ 
	private static final long serialVersionUID = 1L;
}