import java.io.Serializable;

/**
 * Represents an intermediate vertex in the network, which is part of an edge.
 * Used to create curved or multi-segment paths.
 */
public class NetworkVertex implements Serializable {
    private String id;
    private String edgeId;
    private int edgeIndex;
    private Vector3 position;
    
    /**
     * Create a new NetworkVertex
     * @param id Unique identifier
     * @param edgeId ID of the edge this vertex belongs to
     * @param edgeIndex Index of this vertex within the edge (for ordering)
     * @param position 3D position
     */
    public NetworkVertex(String id, String edgeId, int edgeIndex, Vector3 position) {
        this.id = id;
        this.edgeId = edgeId;
        this.edgeIndex = edgeIndex;
        this.position = position;
    }
    
    /**
     * Get the vertex ID
     * @return Vertex ID
     */
    public String getId() {
        return id;
    }
    
    /**
     * Get the edge ID this vertex belongs to
     * @return Edge ID
     */
    public String getEdgeId() {
        return edgeId;
    }
    
    /**
     * Get the index of this vertex within the edge
     * @return Edge index
     */
    public int getEdgeIndex() {
        return edgeIndex;
    }
    
    /**
     * Get the vertex position
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
     * Set the vertex ID
     * @param id New ID
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Set the edge ID this vertex belongs to
     * @param edgeId New edge ID
     */
    public void setEdgeId(String edgeId) {
        this.edgeId = edgeId;
    }
    
    /**
     * Set the index of this vertex within the edge
     * @param edgeIndex New edge index
     */
    public void setEdgeIndex(int edgeIndex) {
        this.edgeIndex = edgeIndex;
    }
    
    /**
     * Set the vertex position
     * @param position New position
     */
    public void setPosition(Vector3 position) {
        this.position = position;
    }
    
    public String toString() {
        return String.format("NetworkVertex[id=%s, edgeId=%s, index=%d, position=%s]", 
                id, edgeId, edgeIndex, position);
    }

	/**
	 * This number is here for model snapshot storing purpose<br>
	 * It needs to be changed when this class gets changed
	 */ 
	private static final long serialVersionUID = 1L;
}