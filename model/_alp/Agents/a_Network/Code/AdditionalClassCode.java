private static final Logger logger = LogManager.getLogger("a_Network");

public void loadDataFromJson() {
    logger.info("Starting JSON data load from: {}", this.jsonFilePath);
    try {
        DataDriver dataDriver = new DataDriver();
        dataDriver.initialiseFromJSON(this, this.jsonFilePath);
        logger.info("DataDriver initialized successfully");
        buildEdgeVertexAssociations();
        dataDriver.callOnParametersSet();
        dataDriver.callOnRunStarted();
        logger.info("Data loading completed successfully");
    } catch (Exception e) {
        logger.error("Error loading data from JSON: {}", e.getMessage(), e);
        traceln("Error loading data from JSON: " + e.getMessage());
        e.printStackTrace();
    }
}

private void buildEdgeVertexAssociations() {
    logger.info("Starting buildEdgeVertexAssociations with {} edges and {} vertices", this.p_Edges.size(), this.p_Vertices.size());
    traceln("INFO: Starting buildEdgeVertexAssociations with " + this.p_Edges.size() + " edges and " + this.p_Vertices.size() + " vertices");
    
    Map<String, a_Edge> edgeMap = new HashMap<>();
    Map<String, Map<Integer, a_Vertex>> edgeVerticesMap = new HashMap<>();
    
    for (a_Edge edge : this.p_Edges) {
        if (edge != null && edge.id != null) {
            edgeMap.put(edge.id, edge);
            if (edge.vertices == null) {
                edge.vertices = new ArrayList<>();
            } else {
                edge.vertices.clear();
            }
            edgeVerticesMap.put(edge.id, new HashMap<>());
        }
    }
    
    int totalVertices = 0;
    int validVertices = 0;
    
    for (a_Vertex vertex : this.p_Vertices) {
        totalVertices++;
        
        if (vertex == null || vertex.edge_id == null) continue;
        
        a_Edge edge = edgeMap.get(vertex.edge_id);
        if (edge == null) continue;
        
        validVertices++;
        edgeVerticesMap.get(vertex.edge_id).put(vertex.edge_index, vertex);
    }
    
    int totalVerticesAssigned = 0;
    
    for (String edgeId : edgeVerticesMap.keySet()) {
        a_Edge edge = edgeMap.get(edgeId);
        Map<Integer, a_Vertex> vertexMap = edgeVerticesMap.get(edgeId);
        
        if (vertexMap.isEmpty()) continue;
        
        List<Integer> sortedIndices = new ArrayList<>(vertexMap.keySet());
        Collections.sort(sortedIndices);
        
        for (Integer index : sortedIndices) {
            a_Vertex vertex = vertexMap.get(index);
            edge.vertices.add(new a_Edge.VertexPoint(vertex.x, vertex.y, vertex.z));
            totalVerticesAssigned++;
        }
    }
    
    logger.info("Vertex association complete - {} valid vertices assigned to edges", validVertices);
    traceln("INFO: Vertex association complete - " + validVertices + " valid vertices assigned to edges");
}

public void initializeNetwork() {
    logger.info("Initializing network visualization with {} nodes and {} edges", this.p_Nodes.size(), this.p_Edges.size());
    this.v_Network = new Network(this, "myNetwork");
    this.v_Level = new Level(this, "myNetworkLevel", this.SHAPE_DRAW_2D3D, 0);

    validateNodeReferences();

    Map<String, a_Node> nodeMap = new HashMap<>();

    // Shared label used to show details of whichever node was last clicked
    this.v_InfoText = new ShapeText();
    this.v_InfoText.setDrawMode(this.SHAPE_DRAW_2D3D);
    this.v_InfoText.setColor(Color.BLACK);
    this.v_InfoText.setText("");
    this.v_InfoText.setVisible(false);

    for (a_Node node : this.p_Nodes) {
        if (node == null || node.id == null) continue;

        node.v_PointNode = new PointNode(node, node.x, node.y, node.z);
        node.v_PointNode.setLineColor(dodgerBlue);
        node.v_PointNode.setRadius(4);

        this.v_Network.add(node.v_PointNode);
        nodeMap.put(node.id, node);

        // Clickable marker shape showing this node's details, toggled on repeat click
        final a_Node n = node; // effectively final for the anonymous class below

        ShapeOval marker = new ShapeOval() {
            @Override
            public boolean onClick(double clickx, double clicky) {
                if (v_SelectedNode == n && v_InfoText.isVisible()) {
                    // second click on the same node -> hide
                    v_InfoText.setVisible(false);
                    v_SelectedNode = null;
                } else {
                    // first click, or a different node -> show its details
                    v_InfoText.setText(
                        "Name: " + n.name + "\n" +
                        "X: " + n.x + "\n" +
                        "Y: " + n.y + "\n" +
                        "Z: " + n.z
                    );
                    v_InfoText.setPos(n.x, n.y + 5);
                    v_InfoText.setZ(n.z);
                    v_InfoText.setVisible(true);
                    v_SelectedNode = n;
                }
                return true;
            }
        };

        marker.setDrawMode(this.SHAPE_DRAW_2D3D);
        marker.setPos(n.x, n.y);
        marker.setZ(n.z);
        marker.setRadiusX(3);
        marker.setRadiusY(3);
        marker.setFillColor(Color.RED);   // distinct from dodgerBlue PointNode so it's not blending in
        marker.setLineColor(Color.BLACK);

        this.v_Level.add(marker);
    }

    this.v_Level.add(this.v_InfoText);
    this.v_Level.add(this.v_Network);

    for (a_Edge edge : this.p_Edges) {
        if (edge == null || edge.startNodeId == null || edge.endNodeId == null) continue;

        a_Node startNode = nodeMap.get(edge.startNodeId);
        a_Node endNode = nodeMap.get(edge.endNodeId);

        if (startNode == null || endNode == null) continue;

        edge.v_Path = new Path(edge);
        edge.v_Path.setBidirectional(edge.bidirectional);
        edge.v_Path.setSource(startNode.v_PointNode);
        edge.v_Path.setTarget(endNode.v_PointNode);

        if (edge.vertices != null && !edge.vertices.isEmpty()) {
            a_Edge.VertexPoint firstVertex = edge.vertices.get(0);
            edge.v_Path.addSegment(new MarkupSegmentLine(
                startNode.x, startNode.y, startNode.z,
                firstVertex.x, firstVertex.y, firstVertex.z
            ));

            for (int i = 0; i < edge.vertices.size() - 1; i++) {
                a_Edge.VertexPoint v1 = edge.vertices.get(i);
                a_Edge.VertexPoint v2 = edge.vertices.get(i + 1);
                edge.v_Path.addSegment(new MarkupSegmentLine(
                    v1.x, v1.y, v1.z, v2.x, v2.y, v2.z
                ));
            }

            a_Edge.VertexPoint lastVertex = edge.vertices.get(edge.vertices.size() - 1);
            edge.v_Path.addSegment(new MarkupSegmentLine(
                lastVertex.x, lastVertex.y, lastVertex.z,
                endNode.x, endNode.y, endNode.z
            ));
        } else {
            edge.v_Path.addSegment(new MarkupSegmentLine(
                startNode.x, startNode.y, startNode.z,
                endNode.x, endNode.y, endNode.z
            ));
        }

        edge.v_Path.setLineColor(dodgerBlue);
        edge.v_Path.setLineWidth(2.0);

        this.v_Network.add(edge.v_Path);

        // Direction arrow for one-way edges, drawn at the edge's midpoint
        if (!edge.bidirectional) {
            double midX = (startNode.x + endNode.x) / 2.0;
            double midY = (startNode.y + endNode.y) / 2.0;
            double midZ = (startNode.z + endNode.z) / 2.0;

            double dirX = endNode.x - startNode.x;
            double dirY = endNode.y - startNode.y;
            double dirZ = endNode.z - startNode.z;
            double len = Math.sqrt(dirX * dirX + dirY * dirY + dirZ * dirZ);

            if (len > 0) {
                double arrowLen = 20; // tune to your network's scale
                double ux = dirX / len, uy = dirY / len, uz = dirZ / len;

                double startX = midX - ux * arrowLen / 2;
                double startY = midY - uy * arrowLen / 2;
                double startZ = midZ - uz * arrowLen / 2;

                ShapeArrowLine directionArrow = new ShapeArrowLine(
                    this.SHAPE_DRAW_2D3D, true,
                    startX, startY, startZ,
                    Color.BLACK,
                    ux * arrowLen, uy * arrowLen, uz * arrowLen,
                    2, 0,
                    LINE_STYLE_SOLID,
                    ARROW_NONE, 0, 4, 3,
                    ARROW_FILLED, 0, 4, 3
                );

                this.v_Level.add(directionArrow);
            }
        }
    }

    this.v_Level.initialize();
    logger.info("Network visualization created successfully with {} nodes and {} edges", this.p_Nodes.size(), this.p_Edges.size());
    traceln("INFO: Network initialized with " + this.p_Nodes.size() + " nodes and " + this.p_Edges.size() + " edges");
}

private void validateNodeReferences() {
    logger.debug("Validating node references for {} edges", this.p_Edges.size());
    Set<String> nodeIds = new HashSet<>();
    for (a_Node node : this.p_Nodes) {
        if (node != null && node.id != null) {
            nodeIds.add(node.id);
        }
    }
    
    int invalidReferences = 0;
    for (a_Edge edge : this.p_Edges) {
        if (edge == null || edge.id == null) continue;
        
        if (edge.startNodeId != null && !nodeIds.contains(edge.startNodeId)) {
            logger.error("Edge {} references non-existent start node: {}", edge.id, edge.startNodeId);
            traceln("ERROR: Edge " + edge.id + " references non-existent start node: " + edge.startNodeId);
            invalidReferences++;
        }
        
        if (edge.endNodeId != null && !nodeIds.contains(edge.endNodeId)) {
            logger.error("Edge {} references non-existent end node: {}", edge.id, edge.endNodeId);
            traceln("ERROR: Edge " + edge.id + " references non-existent end node: " + edge.endNodeId);
            invalidReferences++;
        }
    }
    
    if (invalidReferences == 0) {
        logger.info("All node references validated successfully");
        traceln("INFO: All node references in edges are valid");
    } else {
        logger.warn("Found {} invalid node references", invalidReferences);
    }
}

public List<NodeLabelInfo> getNodeLabelInfo() {
    List<NodeLabelInfo> result = new ArrayList<>();
    for (a_Node node : p_Nodes) {
        if (node != null && node.id != null) {
            result.add(new NodeLabelInfo(node.id, node.x, node.y, node.z));
        }
    }
    return result;
}

public static class NodeLabelInfo {
    public String id;
    public double x, y, z;
    
    public NodeLabelInfo(String id, double x, double y, double z) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}