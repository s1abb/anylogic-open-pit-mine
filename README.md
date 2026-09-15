# AnyLogic Network Builder

A data-driven network visualization system for AnyLogic that parses OBJ files and generates 3D network representations with nodes, edges, and vertices.

## Overview

This project provides a complete workflow for converting 3D geometry data (OBJ format) into interactive network visualizations within AnyLogic. It features automatic topology analysis, JSON-based data loading, and 3D network rendering using AnyLogic's markup API.

## Key Features

- **OBJ File Parsing**: Reads Wavefront OBJ files and extracts line geometry
- **Topology Analysis**: Automatically identifies network nodes (junction points) vs. inline vertices
- **Coordinate Transformation**: Applies configurable transforms to align geometry with AnyLogic coordinate system
- **JSON Data Format**: Intermediate JSON representation for network structure
- **Data-Driven Agents**: Agent types that populate from JSON using reflection-based DataDriver
- **3D Visualization**: Renders networks with AnyLogic Network, PointNode, and Path markup elements

## Project Structure

```
AnylogicNetworkBuilder/
├── AnylogicNetworkBuilder.alpx     # Main AnyLogic project file
├── _alp/
│   ├── Experiments.xml             # Experiment configurations
│   ├── Agents/
│   │   ├── Main/                   # Main agent with startup code
│   │   │   └── AOC.Main.xml
│   │   ├── a_Network/              # Network container agent
│   │   ├── a_Node/                 # Node agent (junction points)
│   │   ├── a_Edge/                 # Edge agent (connections between nodes)
│   │   └── a_Vertex/               # Vertex agent (inline path points)
│   └── Classes/
│       ├── Class.CoordinateTransform.java   # Coordinate system transformation
│       ├── Class.DataDriver.java            # JSON-based agent initialization
│       ├── Class.IDataDriver.java           # Interface for data-driven agents
│       ├── Class.InputException.java        # Custom exception handling
│       ├── Class.NetworkBuilder.java        # OBJ parser and topology analyzer
│       ├── Class.NetworkEdge.java           # Edge data structure
│       ├── Class.NetworkNode.java           # Node data structure
│       ├── Class.NetworkVertex.java         # Vertex data structure
│       └── Class.Vector3.java               # 3D vector utilities
├── network.json                    # Generated network data (output)
└── logback.xml                     # Logging configuration

network/
└── network.obj                     # Input OBJ file
```

## Workflow

### 1. OBJ File Input

Place your OBJ file at `C:\repos\anylogic-network-builder\network\network.obj`

The OBJ file should contain line geometry (polylines) representing network paths:
```obj
v x1 y1 z1
v x2 y2 z2
v x3 y3 z3
l 1 2 3
```

### 2. Parse and Generate JSON

When the AnyLogic model starts, `NetworkBuilder` automatically:

1. **Parses OBJ file** - Reads vertices and line definitions
2. **Analyzes topology** - Identifies nodes (junction/endpoint) vs inline vertices
3. **Applies transforms** - Converts coordinates to AnyLogic space
4. **Generates JSON** - Saves network data to `./network.json`

### 3. Load Data into Agents

The `DataDriver` system initializes agent populations from JSON:

- **a_Network**: Container for all network elements
- **a_Node**: Junction points where edges meet (degree > 1) or endpoints (degree = 1)
- **a_Edge**: Connections between nodes with optional inline vertices
- **a_Vertex**: Intermediate points along edge paths

### 4. Create 3D Visualization

The network visualization is built using AnyLogic markup:

- **Network**: Top-level markup container
- **Level**: 3D space container
- **PointNode**: Visual representation of each node
- **Path**: Connections between nodes with MarkupSegmentLine segments

### 5. View Results

The 3D network appears in the presentation window with:
- Node positions from OBJ geometry
- Edge paths following original polylines
- Interactive 3D navigation (rotate, zoom, pan)

## Core Components

### NetworkBuilder

Main OBJ parser with topology analysis:

```java
NetworkBuilder builder = new NetworkBuilder();
builder.setCoordinateTransform(CoordinateTransform.createDefaultTransform());
builder.parseOBJFile("C:\\path\\to\\network.obj");
builder.saveJSONToFile("./network.json");
```

**Key Methods:**
- `parseOBJFile()`: Read and parse OBJ geometry
- `analyzeTopology()`: Identify nodes vs inline vertices
- `saveJSONToFile()`: Export network data as JSON
- `getNodeCount()`, `getEdgeCount()`, `getVertexCount()`: Query results

### DataDriver

Reflection-based agent initialization from JSON:

```java
DataDriver driver = new DataDriver("./network.json");
driver.loadDataFromJSONFile();
driver.updateAgents(this, a_Node.class, "p_Nodes");
driver.updateAgents(this, a_Edge.class, "p_Edges");
driver.updateAgents(this, a_Vertex.class, "p_Vertices");
```

### CoordinateTransform

Handles coordinate system conversion:

```java
CoordinateTransform transform = CoordinateTransform.createDefaultTransform();
Vector3 transformedPoint = transform.transform(new Vector3(x, y, z));
```

Default transform:
- Scale: X=1.0, Y=1.0, Z=1.0
- Offset: X=0.0, Y=0.0, Z=0.0

## JSON Data Format

Generated network data structure:

```json
{
  "p_Nodes": [
    {
      "index": 0,
      "position": {"x": 10.5, "y": 20.3, "z": 0.0},
      "degree": 2
    }
  ],
  "p_Edges": [
    {
      "index": 0,
      "node_a_index": 0,
      "node_b_index": 1,
      "length": 15.7
    }
  ],
  "p_Vertices": [
    {
      "index": 0,
      "edge_index": 0,
      "position": {"x": 12.0, "y": 21.0, "z": 0.0},
      "sequence": 1
    }
  ]
}
```

## Agent Types

All agents implement `IDataDriver` interface for JSON initialization:

### a_Network
- Container for entire network
- Manages node/edge/vertex collections
- Creates 3D visualization markup
- Validates topology

### a_Node
- Represents junction points or endpoints
- Properties: `index`, `position` (Vector3), `degree`

### a_Edge
- Connects two nodes
- Properties: `index`, `node_a_index`, `node_b_index`, `length`
- Contains ordered list of inline vertices

### a_Vertex
- Intermediate point along edge path
- Properties: `index`, `edge_index`, `position` (Vector3), `sequence`

## Configuration

### Logging

Configured in `logback.xml` to suppress infrastructure noise:

```xml
<logger name="org.eclipse.jetty" level="OFF"/>
<logger name="sparkjava.jetty" level="OFF"/>
<root level="ERROR">
    <appender-ref ref="CONSOLE"/>
</root>
```

### Coordinate Transform

Modify in startup code for different coordinate systems:

```java
CoordinateTransform transform = new CoordinateTransform(
    scaleX, scaleY, scaleZ,
    offsetX, offsetY, offsetZ
);
builder.setCoordinateTransform(transform);
```

## Running the Project

1. **Open project**: `AnylogicNetworkBuilder/AnylogicNetworkBuilder.alpx` in AnyLogic 8.9.7+
2. **Prepare OBJ file**: Place at `C:\repos\anylogic-network-builder\network\network.obj`
3. **Run model**: Click Run or press F5
4. **View network**: 3D visualization appears in presentation window

The startup code automatically executes the full workflow:
- Parse OBJ → Generate JSON → Load data → Build visualization

## Requirements

- AnyLogic 8.9.7 Professional or higher
- Java 8+ (included with AnyLogic)
- Jackson library for JSON processing (included)

## Example Use Cases

- **Mine network visualization**: Underground tunnel systems from surveyed geometry
- **Road networks**: Street layouts from GIS data
- **Utility networks**: Pipe/cable routing visualization
- **Transportation**: Railway or metro line networks

## Troubleshooting

**"Couldn't read input file"**
- Ensure OBJ file exists at specified path
- Check JSON was generated successfully
- Verify file permissions

**Network shows 0 nodes/edges**
- Check console for parsing errors
- Verify OBJ file contains line (`l`) definitions
- Ensure coordinates are in reasonable range

**Excessive console output**
- Logging configured in logback.xml
- Set Jetty loggers to "OFF" level
- Adjust root level to ERROR or WARN

## License

[Add your license information]

## Credits

Based on mine network visualization concepts for underground infrastructure mapping.