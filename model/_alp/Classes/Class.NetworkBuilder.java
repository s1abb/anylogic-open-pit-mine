import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Implementation of INetworkBuilder that parses OBJ files and generates
 * network structures compatible with AnyLogic and DataDriver.
 */
public class NetworkBuilder implements Serializable {
    private static final long serialVersionUID = 1L;
    
    //------------------------------------------------------------------------------
    // Inner classes
    //------------------------------------------------------------------------------
    
    /**
     * Internal representation of OBJ file data
     */
    static class OBJData {
        List<Vector3> vertices = new ArrayList<>();
        List<Line> lines = new ArrayList<>();
        
        public String toString() {
            return String.format("OBJData: %d vertices, %d lines", vertices.size(), lines.size());
        }
    }
    
    /**
     * Represents a line between two vertices
     */
    static class Line {
        int startIndex;
        int endIndex;
        
        Line(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
        
        public String toString() {
            return String.format("Line(%d -> %d)", startIndex, endIndex);
        }
    }
    
    /**
     * Result of topology analysis
     */
    static class TopologyResult {
        Set<Integer> nodeIndices = new HashSet<>();
        Set<Integer> inlineVertexIndices = new HashSet<>();
        Map<Integer, List<Integer>> vertexConnections = new HashMap<>();
        Map<String, List<Integer>> edgeComposition = new HashMap<>();
        
        public String toString() {
            return String.format("Topology: %d nodes, %d inline vertices", 
                    nodeIndices.size(), inlineVertexIndices.size());
        }
    }
    
    /**
     * Helper class to represent an edge path
     */
    static class EdgePath {
        int startNode;
        int endNode;
        List<Integer> inlineVertices;
        boolean valid;
        
        EdgePath(int startNode, int endNode, List<Integer> inlineVertices, boolean valid) {
            this.startNode = startNode;
            this.endNode = endNode;
            this.inlineVertices = inlineVertices;
            this.valid = valid;
        }
        
        boolean isValid() {
            return valid && startNode != endNode;
        }
    }
    
    //------------------------------------------------------------------------------
    // Fields
    //------------------------------------------------------------------------------
    
    // Logging disabled for Any Logic - use traceln() instead
    private CoordinateTransform transform;
    
    private List<NetworkNode> nodes = new ArrayList<>();
    private List<NetworkEdge> edges = new ArrayList<>();
    private List<NetworkVertex> vertices = new ArrayList<>();
    
    private Map<String, NetworkNode> nodeMap = new HashMap<>();
    private Map<String, NetworkEdge> edgeMap = new HashMap<>();
    
    private OBJData objData;
    private TopologyResult topology;
    
    /**
     * Create a new NetworkBuilder
     */
    public NetworkBuilder() {
        this.transform = new CoordinateTransform();
    }
    
    public void parseOBJFile(String objFilePath) {
        parseOBJFile(objFilePath, this.transform);
    }
    
    public void parseOBJFile(String objFilePath, CoordinateTransform transform) {
        // traceln("Parsing OBJ file: {}", objFilePath);
        
        try {
            // 1. Parse the OBJ file
            this.objData = parseOBJ(objFilePath);
            
            // 2. Apply coordinate transformation
            if (transform != null) {
                applyTransformation(transform);
            }
            
            // 3. Analyze topology
            this.topology = analyzeTopology(objData);
            
            // 4. Create network structure
            createNetworkStructure(objData, topology);
            
            // traceln("Successfully parsed OBJ file with {} nodes, {} edges, and {} vertices", 
            //         nodes.size(), edges.size(), vertices.size());
            
        } catch (Exception e) {
            // traceln("Error parsing OBJ file: {}", e.getMessage(), e);
            throw new RuntimeException("Error parsing OBJ file", e);
        }
    }
    
    public String generateJSON() {
        // traceln("Generating JSON for network with {} nodes, {} edges, and {} vertices", 
        //         nodes.size(), edges.size(), vertices.size());
        
        // Validate the network before generating JSON
        if (!validateNetwork()) {
            // traceln("Network validation failed - this may cause missing elements in visualization");
        }
        
        try {
            ObjectMapper mapper = new ObjectMapper();
            ObjectNode rootNode = mapper.createObjectNode();
            
            // 1. Create nodes array
            ArrayNode nodesArray = mapper.createArrayNode();
            for (NetworkNode node : nodes) {
                ObjectNode nodeObj = mapper.createObjectNode();
                nodeObj.put("id", node.getId());
                nodeObj.put("x", node.getX());
                nodeObj.put("y", node.getY());
                nodeObj.put("z", node.getZ());
                nodeObj.put("name", node.getName());
                nodeObj.put("type", node.getType());
                
                nodesArray.add(nodeObj);
            }
            
            // 2. Create edges array
            ArrayNode edgesArray = mapper.createArrayNode();
            for (NetworkEdge edge : edges) {
                ObjectNode edgeObj = mapper.createObjectNode();
                edgeObj.put("id", edge.getId());
                edgeObj.put("startNodeId", edge.getStartNodeId());
                edgeObj.put("endNodeId", edge.getEndNodeId());
                edgeObj.put("bidirectional", edge.isBidirectional());
                edgeObj.put("type", edge.getType());
                
                edgesArray.add(edgeObj);
            }
            
            // 3. Create vertices array - keep this for compatibility with DataDriver
            ArrayNode verticesArray = mapper.createArrayNode();
            for (NetworkVertex vertex : vertices) {
                ObjectNode vertexObj = mapper.createObjectNode();
                vertexObj.put("id", vertex.getId());
                vertexObj.put("edge_id", vertex.getEdgeId());
                vertexObj.put("edge_index", vertex.getEdgeIndex());
                vertexObj.put("x", vertex.getX());
                vertexObj.put("y", vertex.getY());
                vertexObj.put("z", vertex.getZ());
                
                verticesArray.add(vertexObj);
            }
            
            // Add arrays to root object
            rootNode.set("p_Nodes", nodesArray);
            rootNode.set("p_Edges", edgesArray);
            rootNode.set("p_Vertices", verticesArray);
            
            // Convert to formatted JSON string
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
            
        } catch (Exception e) {
            // traceln("Error generating JSON: {}", e.getMessage(), e);
            throw new RuntimeException("Error generating JSON", e);
        }
    }
    
    public void saveJSONToFile(String filePath) {
        // traceln("Saving JSON to file: {}", filePath);
        
        try {
            String json = generateJSON();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(json);
            }
            // traceln("Successfully saved JSON to file: {}", filePath);
        } catch (Exception e) {
            // traceln("Error saving JSON to file: {}", e.getMessage(), e);
            throw new RuntimeException("Error saving JSON to file", e);
        }
    }
    
    public void setCoordinateTransform(CoordinateTransform transform) {
        this.transform = transform;
    }
    
    public int getNodeCount() {
        return nodes.size();
    }
    
    public int getEdgeCount() {
        return edges.size();
    }
    
    public int getVertexCount() {
        return vertices.size();
    }
    
    public boolean validateNetwork() {
        boolean valid = true;
        int invalidNodes = 0;
        int invalidEdges = 0;
        int invalidVertices = 0;
        
        // Check nodes
        for (NetworkNode node : nodes) {
            if (node.getId() == null || node.getPosition() == null) {
                // traceln("Invalid node: {}", node);
                invalidNodes++;
                valid = false;
            }
        }
        
        // Check edges
        for (NetworkEdge edge : edges) {
            if (edge.getId() == null || edge.getStartNodeId() == null || edge.getEndNodeId() == null) {
                // traceln("Invalid edge: {}", edge);
                invalidEdges++;
                valid = false;
            }
            
            // Check that start and end nodes exist
            if (!nodeMap.containsKey(edge.getStartNodeId())) {
                // traceln("Edge {} references non-existent start node: {}", edge.getId(), edge.getStartNodeId());
                invalidEdges++;
                valid = false;
            }
            
            if (!nodeMap.containsKey(edge.getEndNodeId())) {
                // traceln("Edge {} references non-existent end node: {}", edge.getId(), edge.getEndNodeId());
                invalidEdges++;
                valid = false;
            }
        }
        
        // Check vertices
        for (NetworkVertex vertex : vertices) {
            if (vertex.getId() == null || vertex.getEdgeId() == null || vertex.getPosition() == null) {
                // traceln("Invalid vertex: {}", vertex);
                invalidVertices++;
                valid = false;
            }
            
            // Check that edge exists
            if (!edgeMap.containsKey(vertex.getEdgeId())) {
                // traceln("Vertex {} references non-existent edge: {}", vertex.getId(), vertex.getEdgeId());
                invalidVertices++;
                valid = false;
            }
        }
        
        // traceln("Network validation: {}", valid ? "VALID" : "INVALID");
        if (!valid) {
            // traceln("Invalid nodes: {}, invalid edges: {}, invalid vertices: {}", 
            //         invalidNodes, invalidEdges, invalidVertices);
        }
        
        return valid;
    }
    
    //------------------------------------------------------------------------------
    // Private helper methods
    //------------------------------------------------------------------------------
    
    /**
     * Parse an OBJ file
     */
    private OBJData parseOBJ(String filePath) throws IOException {
        OBJData data = new OBJData();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                
                if (line.startsWith("v ")) {
                    // Parse vertex definition
                    String[] parts = line.split("\\s+");
                    if (parts.length >= 4) {
                        double x = Double.parseDouble(parts[1]);
                        double y = Double.parseDouble(parts[2]);
                        double z = Double.parseDouble(parts[3]);
                        data.vertices.add(new Vector3(x, y, z));
                    }
                } else if (line.startsWith("l ")) {
                    // Parse line definition
                    String[] parts = line.split("\\s+");
                    if (parts.length >= 3) {
                        // OBJ indices are 1-based, convert to 0-based
                        int start = Integer.parseInt(parts[1]) - 1;
                        int end = Integer.parseInt(parts[2]) - 1;
                        data.lines.add(new Line(start, end));
                    }
                }
                // Ignore other OBJ elements like materials, normals, etc.
            }
        }
        
        // traceln("Parsed OBJ file with {} vertices and {} lines", 
        //         data.vertices.size(), data.lines.size());
        
        return data;
    }
    
    /**
     * Apply coordinate transformation to vertices
     */
    private void applyTransformation(CoordinateTransform transform) {
        if (transform == null || objData == null) return;
        
        List<Vector3> transformedVertices = new ArrayList<>();
        for (Vector3 v : objData.vertices) {
            transformedVertices.add(transform.apply(v));
        }
        objData.vertices = transformedVertices;
        
        // traceln("Applied coordinate transformation");
    }
    
    /**
     * Analyze topology to classify vertices and build edge compositions
     */
    private TopologyResult analyzeTopology(OBJData data) {
        TopologyResult result = new TopologyResult();
        
        // 1. Count connections for each vertex
        Map<Integer, Integer> connectionCounts = new HashMap<>();
        
        // Initialize connection counts to zero
        for (int i = 0; i < data.vertices.size(); i++) {
            connectionCounts.put(i, 0);
            result.vertexConnections.put(i, new ArrayList<>());
        }
        
        // Count connections from lines
        for (int i = 0; i < data.lines.size(); i++) {
            Line line = data.lines.get(i);
            
            // Increment counts for both start and end vertices
            connectionCounts.put(line.startIndex, connectionCounts.get(line.startIndex) + 1);
            connectionCounts.put(line.endIndex, connectionCounts.get(line.endIndex) + 1);
            
            // Record which lines connect to each vertex
            result.vertexConnections.get(line.startIndex).add(i);
            result.vertexConnections.get(line.endIndex).add(i);
        }
        
        // 2. Classify vertices based on connection count
        for (int i = 0; i < data.vertices.size(); i++) {
            int connections = connectionCounts.get(i);
            
            if (connections == 1 || connections >= 3) {
                // Classify as node: endpoint (1 connection) or intersection (3+ connections)
                result.nodeIndices.add(i);
            } else if (connections == 2) {
                // Classify as inline vertex: exactly 2 connections
                result.inlineVertexIndices.add(i);
            }
            // Ignore vertices with 0 connections
        }
        
        // 3. Validate and clean vertex connections data structure
        validateAndCleanVertexConnections(data, result);
        
        // 4. Create edge compositions (which inline vertices belong to which edge)
        findEdgeCompositions(data, result);
        
        // 5. Validate connections for comprehensive reporting
        validateEdgeCompleteness(data, result);
        
        // traceln("Analyzed topology: {} nodes, {} inline vertices, {} edges", 
        //         result.nodeIndices.size(), result.inlineVertexIndices.size(), 
        //         result.edgeComposition.size());
        
        return result;
    }
    
    /**
     * Validate and clean the vertex connections data structure to ensure consistency
     * This removes invalid line references and ensures all connections are valid
     */
    private void validateAndCleanVertexConnections(OBJData data, TopologyResult result) {
        // traceln("Validating and cleaning vertex connections data structure...");
        
        int totalConnections = 0;
        int invalidConnections = 0;
        int removedConnections = 0;
        
        for (Map.Entry<Integer, List<Integer>> entry : result.vertexConnections.entrySet()) {
            int vertex = entry.getKey();
            List<Integer> lineIndices = entry.getValue();
            totalConnections += lineIndices.size();
            
            // Create a list to track invalid line indices for removal
            List<Integer> invalidLineIndices = new ArrayList<>();
            
            for (int lineIndex : lineIndices) {
                // Check if line index is valid
                if (lineIndex < 0 || lineIndex >= data.lines.size()) {
                    // traceln("Vertex {} has invalid line index: {} (out of range 0-{})", 
                    //            vertex, lineIndex, data.lines.size() - 1);
                    invalidLineIndices.add(lineIndex);
                    invalidConnections++;
                    continue;
                }
                
                Line line = data.lines.get(lineIndex);
                
                // Check if the line actually connects to this vertex
                if (line.startIndex != vertex && line.endIndex != vertex) {
                    // traceln("Vertex {} references line {} ({} -> {}) but is not connected to it", 
                    //            vertex, lineIndex, line.startIndex, line.endIndex);
                    invalidLineIndices.add(lineIndex);
                    invalidConnections++;
                }
            }
            
            // Remove invalid line references
            for (int invalidLineIndex : invalidLineIndices) {
                lineIndices.remove(Integer.valueOf(invalidLineIndex));
                removedConnections++;
            }
        }
        
        // traceln("Vertex connections validation complete:");
        // traceln("  Total connections checked: {}", totalConnections);
        // traceln("  Invalid connections found: {}", invalidConnections);
        // traceln("  Invalid connections removed: {}", removedConnections);
        
        if (invalidConnections > 0) {
            // traceln("Removed {} invalid line references from vertex connections", removedConnections);
        } else {
            // traceln("All vertex connections are valid");
        }
    }
    
    /**
     * Find edge compositions by traversing from each node through inline vertices
     * using a complete shortest path approach for more reliable edge detection
     */
    private void findEdgeCompositions(OBJData data, TopologyResult result) {
        // traceln("Starting topology edge composition analysis with {} nodes and {} inline vertices",
        //         result.nodeIndices.size(), result.inlineVertexIndices.size());
        
        // Track processed node pairs to avoid duplicates
        Set<String> processedPairs = new HashSet<>();
        
        // First, capture all direct connections between nodes
        addDirectConnections(data, result, processedPairs);
        // traceln("Added {} direct connections between nodes", processedPairs.size());
        
        // For each node, find paths to all other reachable nodes
        for (int startNode : result.nodeIndices) {
            // Find all reachable nodes through BFS
            Set<Integer> reachableNodes = findReachableNodes(startNode, data, result);
            // traceln("Node {} can reach {} other nodes", startNode, reachableNodes.size());
            
            // For each reachable node, find shortest path
            for (int endNode : reachableNodes) {
                // Skip self connections
                if (startNode == endNode) continue;
                
                // Create a consistent edge key (smaller index first)
                String edgeKey = createEdgeKey(startNode, endNode);
                
                // Skip if we've already processed this pair
                if (processedPairs.contains(edgeKey)) continue;
                
                // Find all paths between these nodes
                List<List<Integer>> paths = findPathsBetweenNodes(startNode, endNode, data, result);
                
                if (!paths.isEmpty()) {
                    // Log all candidate paths for debugging
                    if (paths.size() > 1) {
                        // traceln("Multiple paths found between nodes {} and {} - {} candidates:", 
                        //            startNode, endNode, paths.size());
                        for (int i = 0; i < paths.size(); i++) {
                            List<Integer> path = paths.get(i);
                            double score = scorePathQuality(path);
                            double continuity = validatePathContinuity(path);
                            // traceln("  Path {}: {} (score: {:.2f}, continuity: {:.2f})", 
                            //            i, path, score, continuity);
                        }
                    }
                    
                    // Select the best path for this edge
                    List<Integer> bestPath = selectBestPath(paths);
                    
                    // Use direction-aware edge composition assignment
                    if (assignEdgeCompositionWithDirectionAwareness(edgeKey, bestPath, result)) {
                        processedPairs.add(edgeKey);
                        // traceln("Successfully assigned edge composition for {}", edgeKey);
                    } else {
                        // traceln("Failed to assign edge composition for {} with path {}", edgeKey, bestPath);
                    }
                }
            }
        }
        
        // Double-check by validating edge compositions
        boolean valid = validateEdgeCompositions(result);
        if (!valid) {
            // traceln("Edge composition validation failed - some vertices may be missing or duplicated");
        }
        
        // Validate all edge connections against original OBJ data
        validateAllEdgeConnections(data, result);
    }
    
    /**
     * Build a complete edge path by following connected lines sequentially
     */
    private EdgePath buildEdgePathFromLine(int startNode, int startLineIndex, 
                                          OBJData data, TopologyResult result, 
                                          Set<Integer> processedLines) {
        
        Line startLine = data.lines.get(startLineIndex);
        
        // Validate that startNode is actually a node
        if (!result.nodeIndices.contains(startNode)) {
            // traceln("Start vertex {} is not a node - skipping edge", startNode);
            return null;
        }
        
        // Determine direction: which end of the line is the start node?
        int currentVertex, nextVertex;
        if (startLine.startIndex == startNode) {
            currentVertex = startLine.startIndex;
            nextVertex = startLine.endIndex;
        } else if (startLine.endIndex == startNode) {
            currentVertex = startLine.endIndex;
            nextVertex = startLine.startIndex;
        } else {
            // traceln("Start node {} is not connected to line {} ({} -> {})", 
            //            startNode, startLineIndex, startLine.startIndex, startLine.endIndex);
            return null;
        }
        
        // Track the path
        List<Integer> pathVertices = new ArrayList<>();
        pathVertices.add(currentVertex); // Start with the start node
        
        Set<Integer> usedLines = new HashSet<>();
        usedLines.add(startLineIndex);
        
        // Follow the line sequence
        while (true) {
            pathVertices.add(nextVertex);
            
            // If next vertex is a node, we've completed the edge
            if (result.nodeIndices.contains(nextVertex)) {
                // Validate that both start and end are valid nodes
                if (!result.nodeIndices.contains(currentVertex)) {
                    // traceln("Invalid edge: start vertex {} is not a node", currentVertex);
                    return null;
                }
                if (!result.nodeIndices.contains(nextVertex)) {
                    // traceln("Invalid edge: end vertex {} is not a node", nextVertex);
                    return null;
                }
                
                // Mark all used lines as processed
                processedLines.addAll(usedLines);
                
                // Extract inline vertices (everything except start and end nodes)
                List<Integer> inlineVertices = new ArrayList<>();
                if (pathVertices.size() > 2) {
                    inlineVertices = pathVertices.subList(1, pathVertices.size() - 1);
                }
                
                // traceln("Created valid edge path from node {} to node {} with {} inline vertices", 
                //            currentVertex, nextVertex, inlineVertices.size());
                
                return new EdgePath(currentVertex, nextVertex, inlineVertices, true);
            }
            
            // If next vertex is inline, find the next line to follow
            if (result.inlineVertexIndices.contains(nextVertex)) {
                int nextLineIndex = findNextLineInSequence(nextVertex, usedLines, 
                                                          data, result);
                
                if (nextLineIndex == -1) {
                    // Dead end - this shouldn't happen in a well-formed mesh
                    // traceln("Dead end at inline vertex {} - incomplete edge", nextVertex);
                    return null;
                }
                
                usedLines.add(nextLineIndex);
                
                // Move to next vertex along this line
                Line nextLine = data.lines.get(nextLineIndex);
                currentVertex = nextVertex;
                nextVertex = (nextLine.startIndex == currentVertex) ? 
                            nextLine.endIndex : nextLine.startIndex;
            } else {
                // Vertex is neither node nor inline - shouldn't happen
                // traceln("Vertex {} is neither node nor inline vertex", nextVertex);
                return null;
            }
        }
    }
    
    /**
     * Find the next line in sequence from an inline vertex
     */
    private int findNextLineInSequence(int vertex, Set<Integer> usedLines, 
                                      OBJData data, TopologyResult result) {
        
        List<Integer> connectedLines = result.vertexConnections.get(vertex);
        
        // Find a connected line that hasn't been used yet
        for (int lineIndex : connectedLines) {
            if (!usedLines.contains(lineIndex)) {
                return lineIndex;
            }
        }
        
        return -1; // No unused line found
    }
    
    /**
     * Add direct connections between nodes
     */
    private void addDirectConnections(OBJData data, TopologyResult result, Set<String> processedPairs) {
        for (int i = 0; i < data.lines.size(); i++) {
            Line line = data.lines.get(i);
            
            // Check if both ends of the line are nodes
            if (result.nodeIndices.contains(line.startIndex) && result.nodeIndices.contains(line.endIndex)) {
                String edgeKey = createEdgeKey(line.startIndex, line.endIndex);
                
                // If this connection hasn't been processed yet, add it
                if (!processedPairs.contains(edgeKey)) {
                    // traceln("Adding direct connection between nodes {} and {}", 
                    //         line.startIndex, line.endIndex);
                            
                    processedPairs.add(edgeKey);
                    result.edgeComposition.put(edgeKey, new ArrayList<>());
                }
            }
        }
    }
    
    /**
     * Find all possible paths between two nodes
     */
    private List<List<Integer>> findPathsBetweenNodes(int startNode, int endNode, OBJData data, TopologyResult result) {
        List<List<Integer>> allPaths = new ArrayList<>();
        
        // Start with path containing just the start node
        List<Integer> initialPath = new ArrayList<>();
        initialPath.add(startNode);
        
        // Track visited vertices to avoid cycles - separate tracking for each path-finding operation
        Set<Integer> visited = new HashSet<>();
        visited.add(startNode);
        
        // Use DFS to find all paths
        findPathsDFS(startNode, endNode, data, result, visited, initialPath, allPaths);
        
        return allPaths;
    }
    
    /**
     * Recursive DFS to find all paths between nodes
     * This version ensures that each step in the path follows an actual line connection
     * and validates connections at every step during traversal
     */
    private void findPathsDFS(int currentVertex, int targetNode, OBJData data, TopologyResult result, 
                             Set<Integer> visited, List<Integer> currentPath, List<List<Integer>> allPaths) {
        
        // If we reached the target node, we found a path
        if (currentVertex == targetNode) {
            // Double-validate that this path follows actual line connections
            if (isValidPath(currentPath, data)) {
                allPaths.add(new ArrayList<>(currentPath));
                // traceln("Found valid path: {}", currentPath);
            } else {
                // traceln("Rejecting invalid path that doesn't follow line connections: {}", currentPath);
            }
            return;
        }
        
        // Look at all lines connected to the current vertex
        for (int lineIndex : result.vertexConnections.get(currentVertex)) {
            Line line = data.lines.get(lineIndex);
            
            // Get the other end of the line - this ensures we only follow actual line connections
            int nextVertex = (line.startIndex == currentVertex) ? line.endIndex : line.startIndex;
            
            // Skip visited vertices to avoid cycles
            if (visited.contains(nextVertex)) continue;
            
            // CRITICAL: Validate the connection BEFORE adding to path
            // This prevents invalid paths from being constructed in the first place
            if (!areVerticesConnectedByLine(currentVertex, nextVertex)) {
                // traceln("Skipping invalid connection {} -> {} during DFS", currentVertex, nextVertex);
                continue;
            }
            
            // Add vertex to path and mark as visited
            currentPath.add(nextVertex);
            visited.add(nextVertex);
            
            // If next vertex is a node (and not our target), we don't want to include this path
            // as we're looking for direct connections between node pairs
            if (result.nodeIndices.contains(nextVertex) && nextVertex != targetNode) {
                // Remove this vertex from the path and visited set before continuing
                currentPath.remove(currentPath.size() - 1);
                visited.remove(nextVertex);
                continue;
            }
            
            // Continue path finding - this will only follow actual line connections
            findPathsDFS(nextVertex, targetNode, data, result, visited, currentPath, allPaths);
            
            // Backtrack - remove the vertex from path and visited set
            currentPath.remove(currentPath.size() - 1);
            visited.remove(nextVertex);
        }
    }
    
    /**
     * Validate that a path follows actual line connections in the OBJ data
     */
    private boolean isValidPath(List<Integer> path, OBJData data) {
        if (path.size() < 2) return true;
        
        // Check each consecutive pair of vertices in the path
        for (int i = 0; i < path.size() - 1; i++) {
            int vertex1 = path.get(i);
            int vertex2 = path.get(i + 1);
            
            // Verify that these vertices are connected by an actual line
            if (!areVerticesConnectedByLine(vertex1, vertex2)) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Select the best path from a list of possible paths
     * This implementation prioritizes paths that follow the original line sequence
     */
    private List<Integer> selectBestPath(List<List<Integer>> paths) {
        if (paths.isEmpty()) return new ArrayList<>();
        if (paths.size() == 1) return paths.get(0);
        
        // Score each path based on multiple criteria
        List<Integer> bestPath = paths.get(0);
        double bestScore = scorePathQuality(bestPath);
        
        for (List<Integer> path : paths) {
            double score = scorePathQuality(path);
            if (score > bestScore) {
                bestScore = score;
                bestPath = path;
            }
        }
        
        // traceln("Selected best path with score {} from {} candidates", bestScore, paths.size());
        return bestPath;
    }
    
    /**
     * Score a path based on quality criteria
     * Higher scores indicate better paths
     */
    private double scorePathQuality(List<Integer> path) {
        if (path.size() < 2) return 0.0;
        
        double score = 0.0;
        
        // Criterion 1: Prefer shorter paths (fewer vertices = more direct)
        // Invert the length so shorter paths get higher scores
        double lengthScore = 1000.0 / path.size();
        score += lengthScore;
        
        // Criterion 2: Validate path continuity (consecutive vertices should be connected by lines)
        double continuityScore = validatePathContinuity(path);
        score += continuityScore * 100.0; // Weight continuity heavily
        
        // Criterion 3: Prefer paths that maintain consistent direction
        double directionScore = scorePathDirection(path);
        score += directionScore * 50.0;
        
        return score;
    }
    
    /**
     * Validate that consecutive vertices in a path are actually connected by lines
     * Returns a score from 0.0 (no continuity) to 1.0 (perfect continuity)
     */
    private double validatePathContinuity(List<Integer> path) {
        if (path.size() < 2) return 1.0;
        
        int validConnections = 0;
        int totalConnections = path.size() - 1;
        
        for (int i = 0; i < path.size() - 1; i++) {
            int vertex1 = path.get(i);
            int vertex2 = path.get(i + 1);
            
            // Check if these vertices are connected by a line in the original data
            if (areVerticesConnectedByLine(vertex1, vertex2)) {
                validConnections++;
            }
        }
        
        return (double) validConnections / totalConnections;
    }
    
    /**
     * Check if two vertices are directly connected by a line in the original OBJ data
     */
    private boolean areVerticesConnectedByLine(int vertex1, int vertex2) {
        for (Line line : objData.lines) {
            if ((line.startIndex == vertex1 && line.endIndex == vertex2) ||
                (line.startIndex == vertex2 && line.endIndex == vertex1)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Score path direction consistency
     * Returns a score from 0.0 (inconsistent) to 1.0 (perfectly consistent)
     */
    private double scorePathDirection(List<Integer> path) {
        if (path.size() < 3) return 1.0; // Can't measure direction with less than 3 points
        
        // For now, return a neutral score
        // This could be enhanced to check geometric direction consistency
        return 0.5;
    }
    
    /**
     * Find all nodes that are reachable from a given start node
     */
    private Set<Integer> findReachableNodes(int startNode, OBJData data, TopologyResult result) {
        Set<Integer> reachableNodes = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(startNode);
        
        // Queue for breadth-first traversal
        List<Integer> queue = new ArrayList<>();
        queue.add(startNode);
        
        while (!queue.isEmpty()) {
            int current = queue.remove(0);
            
            // Check all connected vertices
            for (int lineIndex : result.vertexConnections.get(current)) {
                Line line = data.lines.get(lineIndex);
                int nextVertex = (line.startIndex == current) ? line.endIndex : line.startIndex;
                
                if (!visited.contains(nextVertex)) {
                    visited.add(nextVertex);
                    
                    // If the next vertex is a node, add it to reachable nodes
                    if (result.nodeIndices.contains(nextVertex)) {
                        reachableNodes.add(nextVertex);
                    }
                    
                    // Continue BFS traversal
                    queue.add(nextVertex);
                }
            }
        }
        
        return reachableNodes;
    }
    
    /**
     * Validate that all expected connections in the data have been captured in the topology
     */
    private void validateEdgeCompleteness(OBJData data, TopologyResult result) {
        // Check if all nodes are connected to at least one edge
        Map<Integer, Boolean> nodeConnected = new HashMap<>();
        for (int nodeIndex : result.nodeIndices) {
            nodeConnected.put(nodeIndex, false);
        }
        
        // Mark nodes as connected if they appear in any edge
        for (String edgeKey : result.edgeComposition.keySet()) {
            String[] nodeParts = edgeKey.split("_");
            int node1 = Integer.parseInt(nodeParts[0]);
            int node2 = Integer.parseInt(nodeParts[1]);
            
            nodeConnected.put(node1, true);
            nodeConnected.put(node2, true);
        }
        
        // Check for unconnected nodes
        for (Map.Entry<Integer, Boolean> entry : nodeConnected.entrySet()) {
            if (!entry.getValue()) {
                // traceln("Node {} is not connected to any edge", entry.getKey());
            }
        }
        
        // Check if all inline vertices were assigned to some edge
        Set<Integer> assignedVertices = new HashSet<>();
        for (List<Integer> vertexList : result.edgeComposition.values()) {
            assignedVertices.addAll(vertexList);
        }
        
        // Check for unassigned inline vertices
        for (int vertexIndex : result.inlineVertexIndices) {
            if (!assignedVertices.contains(vertexIndex)) {
                // traceln("Inline vertex {} was not assigned to any edge", vertexIndex);
            }
        }
        
        // Count total edges and check against expected connections
        int totalEdges = result.edgeComposition.size();
        // traceln("Found {} edges between nodes", totalEdges);
    }
    
    /**
     * Validate edge compositions to ensure all inline vertices are properly assigned
     */
    private boolean validateEdgeCompositions(TopologyResult result) {
        boolean valid = true;
        
        // Check that all inline vertices are used in some edge
        Set<Integer> usedVertices = new HashSet<>();
        for (Map.Entry<String, List<Integer>> entry : result.edgeComposition.entrySet()) {
            usedVertices.addAll(entry.getValue());
        }
        
        for (int vertexIndex : result.inlineVertexIndices) {
            if (!usedVertices.contains(vertexIndex)) {
                // traceln("Inline vertex {} is not used in any edge", vertexIndex);
                valid = false;
            }
        }
        
        // Check for overlapping edges (same vertex used in multiple edges)
        Map<Integer, List<String>> vertexToEdges = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : result.edgeComposition.entrySet()) {
            String edgeKey = entry.getKey();
            for (Integer vertexIndex : entry.getValue()) {
                if (!vertexToEdges.containsKey(vertexIndex)) {
                    vertexToEdges.put(vertexIndex, new ArrayList<>());
                }
                vertexToEdges.get(vertexIndex).add(edgeKey);
            }
        }
        
        for (Map.Entry<Integer, List<String>> entry : vertexToEdges.entrySet()) {
            if (entry.getValue().size() > 1) {
                // traceln("Vertex {} is used in multiple edges: {}", 
                //         entry.getKey(), String.join(", ", entry.getValue()));
                valid = false;
            }
        }
        
        return valid;
    }
    
    /**
     * Recursively traverse through inline vertices to find the end node of an edge
     */
    private int findEndNodeThroughInlineVertices(
            int currentVertex, int previousVertex, 
            OBJData data, TopologyResult result,
            Set<Integer> visitedVertices, List<Integer> edgeVertices) {
        
        visitedVertices.add(currentVertex);
        
        // Look at lines connected to this vertex
        for (int lineIndex : result.vertexConnections.get(currentVertex)) {
            Line line = data.lines.get(lineIndex);
            
            // Determine the next vertex
            int nextVertex = (line.startIndex == currentVertex) ? line.endIndex : line.startIndex;
            
            // Skip the vertex we came from
            if (nextVertex == previousVertex) continue;
            
            // If the next vertex is already visited, skip
            if (visitedVertices.contains(nextVertex)) continue;
            
            // If next vertex is a node, we found the end node
            if (result.nodeIndices.contains(nextVertex)) {
                visitedVertices.add(nextVertex);
                return nextVertex;
            }
            
            // If next vertex is an inline vertex, continue traversing
            if (result.inlineVertexIndices.contains(nextVertex)) {
                edgeVertices.add(nextVertex);
                int endNode = findEndNodeThroughInlineVertices(
                    nextVertex, currentVertex, data, result, visitedVertices, edgeVertices);
                
                if (endNode >= 0) {
                    return endNode;
                }
            }
        }
        
        // If we get here, this path didn't lead to a node
        return -1;
    }
    
    /**
     * Validate all edge connections against the original OBJ data
     * This checks every vertex-to-vertex connection in each edge to identify invalid paths
     */
    private void validateAllEdgeConnections(OBJData data, TopologyResult result) {
        // traceln("Validating all edge connections against original OBJ data...");
        
        int totalEdges = 0;
        int validEdges = 0;
        int invalidEdges = 0;
        int totalConnections = 0;
        int invalidConnections = 0;
        
        for (Map.Entry<String, List<Integer>> entry : result.edgeComposition.entrySet()) {
            String edgeKey = entry.getKey();
            List<Integer> inlineVertices = entry.getValue();
            totalEdges++;
            
            // Build complete path: start node + inline vertices + end node
            List<Integer> completePath = buildCompletePath(edgeKey, inlineVertices);
            
            if (completePath.size() < 2) {
                // traceln("Edge {} has invalid path length: {}", edgeKey, completePath.size());
                invalidEdges++;
                continue;
            }
            
            boolean edgeValid = true;
            
            // Check every consecutive pair in the path
            for (int i = 0; i < completePath.size() - 1; i++) {
                int vertex1 = completePath.get(i);
                int vertex2 = completePath.get(i + 1);
                totalConnections++;
                
                if (!areVerticesConnectedByLine(vertex1, vertex2)) {
                    // traceln("INVALID CONNECTION in edge {}: vertex {} -> {} not connected in OBJ", 
                    //            edgeKey, vertex1, vertex2);
                    // traceln("  Complete path: {}", completePath);
                    // traceln("  Inline vertices: {}", inlineVertices);
                    invalidConnections++;
                    edgeValid = false;
                }
            }
            
            if (edgeValid) {
                validEdges++;
                if (!inlineVertices.isEmpty()) {
                    // traceln("Edge {} validated successfully with {} inline vertices", 
                    //            edgeKey, inlineVertices.size());
                }
            } else {
                invalidEdges++;
            }
        }
        
        // traceln("Edge validation complete:");
        // traceln("  Total edges: {}", totalEdges);
        // traceln("  Valid edges: {}", validEdges);
        // traceln("  Invalid edges: {}", invalidEdges);
        // traceln("  Total connections: {}", totalConnections);
        // traceln("  Invalid connections: {}", invalidConnections);
        
        if (invalidEdges > 0) {
            // traceln("FOUND {} EDGES WITH INVALID VERTEX ORDERING!", invalidEdges);
            // traceln("These edges have vertex sequences that don't match the original OBJ line connections.");
        } else {
            // traceln("All edges have valid vertex ordering that matches the original OBJ data.");
        }
    }
    
    /**
     * Build complete path for an edge including start node, inline vertices, and end node
     */
    private List<Integer> buildCompletePath(String edgeKey, List<Integer> inlineVertices) {
        List<Integer> completePath = new ArrayList<>();
        
        // Parse edge key to get start and end nodes
        String[] nodeParts = edgeKey.split("_");
        int startNode = Integer.parseInt(nodeParts[0]);
        int endNode = Integer.parseInt(nodeParts[1]);
        
        // Build complete path: start + inline vertices + end
        completePath.add(startNode);
        completePath.addAll(inlineVertices);
        completePath.add(endNode);
        
        return completePath;
    }
    
    /**
     * Assign edge composition with direction awareness to ensure correct vertex ordering
     * This method ensures that inline vertices are ordered correctly regardless of edge key direction
     */
    private boolean assignEdgeCompositionWithDirectionAwareness(String edgeKey, List<Integer> dfsPath, TopologyResult result) {
        if (dfsPath.size() < 2) {
            // traceln("Cannot assign edge composition for {}: path too short ({})", edgeKey, dfsPath.size());
            return false;
        }
        
        // Parse edge key to get canonical node ordering (always smaller index first)
        String[] parts = edgeKey.split("_");
        int canonicalNode1 = Integer.parseInt(parts[0]); // Always smaller index
        int canonicalNode2 = Integer.parseInt(parts[1]); // Always larger index
        
        // Get actual path start and end nodes
        int pathStart = dfsPath.get(0);
        int pathEnd = dfsPath.get(dfsPath.size() - 1);
        
        // traceln("Assigning edge composition for {}: canonical ({} -> {}), path ({} -> {})", 
        //             edgeKey, canonicalNode1, canonicalNode2, pathStart, pathEnd);
        
        List<Integer> inlineVertices = new ArrayList<>();
        
        // Extract inline vertices based on path direction vs. edge key direction
        if (pathStart == canonicalNode1 && pathEnd == canonicalNode2) {
            // Path direction matches edge key direction - use vertices as-is
            if (dfsPath.size() > 2) {
                inlineVertices = new ArrayList<>(dfsPath.subList(1, dfsPath.size() - 1));
            }
            // traceln("Path direction matches edge key direction - inline vertices: {}", inlineVertices);
            
        } else if (pathStart == canonicalNode2 && pathEnd == canonicalNode1) {
            // Path direction is reverse of edge key direction - reverse the inline vertices
            if (dfsPath.size() > 2) {
                List<Integer> reversedInline = new ArrayList<>(dfsPath.subList(1, dfsPath.size() - 1));
                java.util.Collections.reverse(reversedInline);
                inlineVertices = reversedInline;
            }
            // traceln("Path direction is reverse of edge key direction - reversed inline vertices: {}", inlineVertices);
            
        } else {
            // Invalid path - doesn't match edge key nodes
            // traceln("Path {} doesn't match edge key {} nodes ({}, {})", 
            //             dfsPath, edgeKey, canonicalNode1, canonicalNode2);
            return false;
        }
        
        // Validate the edge composition before assigning
        if (validateEdgeCompositionBeforeAssignment(edgeKey, inlineVertices)) {
            result.edgeComposition.put(edgeKey, inlineVertices);
            
            if (!inlineVertices.isEmpty()) {
                // traceln("Assigned edge {} with {} inline vertices: {}", 
                //            edgeKey, inlineVertices.size(), inlineVertices);
                // traceln("  Original path: {}", dfsPath);
                // traceln("  Final composition: {} -> {} -> {}", 
                //            canonicalNode1, inlineVertices, canonicalNode2);
            } else {
                // traceln("Assigned direct edge {} between nodes {} and {}", 
                //            edgeKey, canonicalNode1, canonicalNode2);
            }
            
            return true;
        } else {
            // traceln("Edge composition validation failed for {}", edgeKey);
            return false;
        }
    }
    
    /**
     * Validate edge composition before assignment to ensure it follows actual line connections
     */
    private boolean validateEdgeCompositionBeforeAssignment(String edgeKey, List<Integer> inlineVertices) {
        // Build the complete path that would be created
        List<Integer> completePath = buildCompletePath(edgeKey, inlineVertices);
        
        if (completePath.size() < 2) {
            // traceln("Invalid edge composition for {}: path too short", edgeKey);
            return false;
        }
        
        // Validate that every consecutive pair of vertices is connected by an actual line
        for (int i = 0; i < completePath.size() - 1; i++) {
            int vertex1 = completePath.get(i);
            int vertex2 = completePath.get(i + 1);
            
            if (!areVerticesConnectedByLine(vertex1, vertex2)) {
                // traceln("Invalid edge composition for {}: vertices {} -> {} not connected by line", 
                //            edgeKey, vertex1, vertex2);
                // traceln("  Complete path would be: {}", completePath);
                return false;
            }
        }
        
        // traceln("Edge composition validation passed for {}: {}", edgeKey, completePath);
        return true;
    }
    
    /**
     * Create a consistent key for an edge between two nodes
     */
    private String createEdgeKey(int node1, int node2) {
        // Ensure consistent ordering (smaller index first)
        return Math.min(node1, node2) + "_" + Math.max(node1, node2);
    }
    
    /**
     * Create network structure from OBJ data and topology analysis
     */
    private void createNetworkStructure(OBJData data, TopologyResult topology) {
        // Clear existing data
        nodes.clear();
        edges.clear();
        vertices.clear();
        nodeMap.clear();
        edgeMap.clear();
        
        // 1. Create nodes
        int nodeCount = 0;
        Map<Integer, String> vertexToNodeId = new HashMap<>();
        
        for (int vertexIndex : topology.nodeIndices) {
            Vector3 position = data.vertices.get(vertexIndex);
            String nodeId = "node_" + nodeCount;
            String nodeName = "Node " + nodeCount;
            
            NetworkNode node = new NetworkNode(nodeId, position, nodeName, "STANDARD");
            nodes.add(node);
            nodeMap.put(nodeId, node);
            vertexToNodeId.put(vertexIndex, nodeId);
            
            nodeCount++;
        }
        
        // 2. Create edges
        int edgeCount = 0;
        int skippedEdges = 0;
        Map<String, String> edgeKeyToId = new HashMap<>();
        
        for (Map.Entry<String, List<Integer>> entry : topology.edgeComposition.entrySet()) {
            String edgeKey = entry.getKey();
            String[] nodeParts = edgeKey.split("_");
            
            int startNodeIndex = Integer.parseInt(nodeParts[0]);
            int endNodeIndex = Integer.parseInt(nodeParts[1]);
            
            String startNodeId = vertexToNodeId.get(startNodeIndex);
            String endNodeId = vertexToNodeId.get(endNodeIndex);
            
            // Validate that both node IDs exist
            if (startNodeId == null) {
                // traceln("Skipping edge {}: start node index {} not found in vertex-to-node mapping", 
                //            edgeKey, startNodeIndex);
                skippedEdges++;
                continue;
            }
            
            if (endNodeId == null) {
                // traceln("Skipping edge {}: end node index {} not found in vertex-to-node mapping", 
                //            edgeKey, endNodeIndex);
                skippedEdges++;
                continue;
            }
            
            // Validate that the node indices are actually classified as nodes
            if (!topology.nodeIndices.contains(startNodeIndex)) {
                // traceln("Skipping edge {}: start vertex {} is not classified as a node", 
                //            edgeKey, startNodeIndex);
                skippedEdges++;
                continue;
            }
            
            if (!topology.nodeIndices.contains(endNodeIndex)) {
                // traceln("Skipping edge {}: end vertex {} is not classified as a node", 
                //            edgeKey, endNodeIndex);
                skippedEdges++;
                continue;
            }
            
            String edgeId = "edge_" + edgeCount;
            NetworkEdge edge = new NetworkEdge(edgeId, startNodeId, endNodeId, false, "STANDARD");
            edges.add(edge);
            edgeMap.put(edgeId, edge);
            edgeKeyToId.put(edgeKey, edgeId);
            
            // traceln("Created valid edge {}: {} -> {}", edgeId, startNodeId, endNodeId);
            edgeCount++;
        }
        
        if (skippedEdges > 0) {
            // traceln("Skipped {} invalid edges during network structure creation", skippedEdges);
        }
        
        // 3. Create vertices
        int vertexCount = 0;
        
        for (Map.Entry<String, List<Integer>> entry : topology.edgeComposition.entrySet()) {
            String edgeKey = entry.getKey();
            String edgeId = edgeKeyToId.get(edgeKey);
            List<Integer> inlineVertices = entry.getValue();
            
            NetworkEdge edge = edgeMap.get(edgeId);
            
            // Add vertices to edge and create NetworkVertex objects
            for (int i = 0; i < inlineVertices.size(); i++) {
                int vertexIndex = inlineVertices.get(i);
                Vector3 position = data.vertices.get(vertexIndex);
                
                String vertexId = "vertex_" + vertexCount;
                
                // Create network vertex
                NetworkVertex vertex = new NetworkVertex(vertexId, edgeId, i, position);
                vertices.add(vertex);
                
                // Add to edge's vertex list
                edge.addVertex(position);
                
                vertexCount++;
            }
        }
        
        // traceln("Created network structure with {} nodes, {} edges, and {} vertices", 
        //         nodes.size(), edges.size(), vertices.size());
    }
    
    public void saveEdgesCSV(String csvFilePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {
            writer.write("id,startNodeId,endNodeId,bidirectional,type,flipDirection");
            writer.newLine();

            for (NetworkEdge edge : edges) {
                writer.write(String.join(",",
                    edge.getId(),
                    edge.getStartNodeId(),
                    edge.getEndNodeId(),
                    String.valueOf(edge.isBidirectional()),
                    edge.getType(),
                    "false"   // default value for the corrected-CSV workflow
                ));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing edges CSV", e);
        }
    }
}