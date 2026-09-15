import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an edge in the network, connecting two nodes.
 * May contain intermediate vertices for curved paths.
 */
public class NetworkEdge implements Serializable {
    private String id;
    private String startNodeId;
    private String endNodeId;
    private boolean bidirectional;
    private String type;
    private List<Vector3> vertices;
    
    /**
     * Create a new NetworkEdge
     * @param id Unique identifier
     * @param startNodeId Start node ID
     * @param endNodeId End node ID
     * @param bidirectional Whether traffic can flow in both directions
     * @param type Edge type (e.g., "STANDARD", "ONEWAY")
     */
    public NetworkEdge(String id, String startNodeId, String endNodeId, boolean bidirectional, String type) {
        this.id = id;
        this.startNodeId = startNodeId;
        this.endNodeId = endNodeId;
        this.bidirectional = bidirectional;
        this.type = type;
        this.vertices = new ArrayList<>();
    }
    
    /**
     * Create a new NetworkEdge with default properties
     * @param id Unique identifier
     * @param startNodeId Start node ID
     * @param endNodeId End node ID
     */
    public NetworkEdge(String id, String startNodeId, String endNodeId) {
        this(id, startNodeId, endNodeId, true, "STANDARD");
    }
    
    /**
     * Get the edge ID
     * @return Edge ID
     */
    public String getId() {
        return id;
    }
    
    /**
     * Get the start node ID
     * @return Start node ID
     */
    public String getStartNodeId() {
        return startNodeId;
    }
    
    /**
     * Get the end node ID
     * @return End node ID
     */
    public String getEndNodeId() {
        return endNodeId;
    }
    
    /**
     * Check if the edge is bidirectional
     * @return True if bidirectional
     */
    public boolean isBidirectional() {
        return bidirectional;
    }
    
    /**
     * Get the edge type
     * @return Edge type
     */
    public String getType() {
        return type;
    }
    
    /**
     * Get the list of intermediate vertices
     * @return List of vertices
     */
    public List<Vector3> getVertices() {
        return vertices;
    }
    
    /**
     * Add an intermediate vertex to the edge
     * @param vertex Vertex to add
     */
    public void addVertex(Vector3 vertex) {
        this.vertices.add(vertex);
    }
    
    /**
     * Add multiple intermediate vertices to the edge
     * @param vertices Vertices to add
     */
    public void addVertices(List<Vector3> vertices) {
        this.vertices.addAll(vertices);
    }
    
    /**
     * Clear all intermediate vertices
     */
    public void clearVertices() {
        this.vertices.clear();
    }
    
    /**
     * Get the number of intermediate vertices
     * @return Vertex count
     */
    public int getVertexCount() {
        return vertices.size();
    }
    
    /**
     * Set the edge ID
     * @param id New ID
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Set the start node ID
     * @param startNodeId New start node ID
     */
    public void setStartNodeId(String startNodeId) {
        this.startNodeId = startNodeId;
    }
    
    /**
     * Set the end node ID
     * @param endNodeId New end node ID
     */
    public void setEndNodeId(String endNodeId) {
        this.endNodeId = endNodeId;
    }
    
    /**
     * Set whether the edge is bidirectional
     * @param bidirectional New bidirectional flag
     */
    public void setBidirectional(boolean bidirectional) {
        this.bidirectional = bidirectional;
    }
    
    /**
     * Set the edge type
     * @param type New type
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * Set the list of intermediate vertices
     * @param vertices New vertices
     */
    public void setVertices(List<Vector3> vertices) {
        this.vertices = new ArrayList<>(vertices);
    }
    
    public String toString() {
        return String.format("NetworkEdge[id=%s, start=%s, end=%s, bidirectional=%s, type=%s, vertices=%d]", 
                id, startNodeId, endNodeId, bidirectional, type, vertices.size());
    }

	/**
	 * This number is here for model snapshot storing purpose<br>
	 * It needs to be changed when this class gets changed
	 */ 
	private static final long serialVersionUID = 1L;
}