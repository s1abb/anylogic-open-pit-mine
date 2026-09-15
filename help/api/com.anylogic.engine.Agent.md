# Class Agent

## Inheritance Hierarchy
```
java.lang.Object
  com.anylogic.engine.Presentable
    com.anylogic.engine.Utilities
      com.anylogic.engine.Agent
```

## All Implemented Interfaces
`AgentConstants`, `EnvironmentConstants`, `IMaintenanceable`, `com.anylogic.engine.internal.Child`, `UtilitiesMath`, `UtilitiesRandom`, `UtilitiesString`, `Serializable`

## Direct Known Subclasses
`FlowchartBlock`

## Class Declaration
```java
public class Agent
extends Utilities
implements com.anylogic.engine.internal.Child, IMaintenanceable
```

## Description
This is a base class for all agent classes created by the user. Agent is the main building block of AnyLogic models; it can have parameters, variables, ports, events, statecharts and embedded agents and/or agent populations. Agent is the unit of dynamic creation of destruction.

Agent may dynamically obtain extensions (which will increase memory footprint of agent), see `ext(Class)`

**Author:** AnyLogic North America, LLC https://anylogic.com

**See Also:** [Serialized Form](#)

## Field Summary

| Modifier and Type | Field | Description |
|------------------|-------|-------------|
| `static final Object` | `_ARRIVAL_message_xjal` | This variable shouldn't be accessed by user: it is used internally by AnyLogic and may be renamed/removed in future |

### Fields inherited from class com.anylogic.engine.Utilities
`AM`, `APRIL`, `AUGUST`, `DECEMBER`, `FEBRUARY`, `FRIDAY`, `JANUARY`, `JULY`, `JUNE`, `LENGTH_UNIT_CENTIMETER`, `LENGTH_UNIT_FOOT`, `LENGTH_UNIT_INCH`, `LENGTH_UNIT_KILOMETER`, `LENGTH_UNIT_METER`, `LENGTH_UNIT_MILE`, `MARCH`, `MAY`, `MONDAY`, `NOVEMBER`, `OCTOBER`, `PM`, `SATURDAY`, `SEPTEMBER`, `SUNDAY`, `THURSDAY`, `TIME_UNIT_DAY`, `TIME_UNIT_HOUR`, `TIME_UNIT_MILLISECOND`, `TIME_UNIT_MINUTE`, `TIME_UNIT_MONTH`, `TIME_UNIT_SECOND`, `TIME_UNIT_WEEK`, `TIME_UNIT_YEAR`, `TUESDAY`, `UNDECIMBER`, `WEDNESDAY`

### Fields inherited from class com.anylogic.engine.Presentable
`ALIGNMENT_CENTER`, `ALIGNMENT_LEFT`, `ALIGNMENT_RIGHT`, `ARROW_FILLED`, `ARROW_NONE`, `ARROW_THIN`, `CAD_ANTIALIASING`, `CAD_INVERTED`, `LINE_STYLE_DASHED`, `LINE_STYLE_DOTTED`, `LINE_STYLE_SOLID`, `SHAPE_DRAW_2D`, `SHAPE_DRAW_2D3D`, `SHAPE_DRAW_3D`

### Fields inherited from interface com.anylogic.engine.AgentConstants
`AGENT_ORIENTATION_FRONT`, `AGENT_ORIENTATION_LEFT`, `AGENT_ORIENTATION_REAR`, `AGENT_ORIENTATION_RIGHT`, `ALL`, `ALL_CONNECTED`, `ALL_NEIGHBORS`, `AREA_ACCESS_RESTRICTION_BY_CAPACITY`, `AREA_ACCESS_RESTRICTION_BY_CONDITION`, `AREA_ACCESS_RESTRICTION_BY_SCHEDULE`, `AREA_ACCESS_RESTRICTION_BY_THROUGHPUT`, `AREA_ACCESS_RESTRICTION_MANUAL`, `CENTIMETER`, `CONVEYOR_BACKWARD`, `CONVEYOR_CUSTOM_STATION_AGENT_LOCATION_CENTER`, `CONVEYOR_CUSTOM_STATION_AGENT_LOCATION_NEAR_CONVEYOR`, `CONVEYOR_CUSTOM_STATION_AGENT_LOCATION_RANDOM`, `CONVEYOR_FORWARD`, `CONVEYOR_SIMPLE_STATION_DELAY_TYPE_MANUAL`, `CONVEYOR_SIMPLE_STATION_DELAY_TYPE_TIMEOUT`, `CONVEYOR_TYPE_BELT`, `CONVEYOR_TYPE_CELL`, `CONVEYOR_TYPE_ROLLER`, `CUBIC_METER`, `CUBIC_METER_PER_SECOND`, `CUSTOM_COLOR_SCHEME`, `DAY`, `DEG_PER_SECOND`, `DEGREE`, `DENSITY_VALUE_MAX`, `DENSITY_VALUE_MEAN`, `EAST`, `ELEVATOR_DIRECTION_DOWN`, `ELEVATOR_DIRECTION_NONE`, `ELEVATOR_DIRECTION_UP`, `ELEVATOR_DOOR_FRONT`, `ELEVATOR_DOOR_REAR`, `ELEVATOR_DOORS_FRONT`, `ELEVATOR_DOORS_FRONT_REAR`, `ELEVATOR_DOORS_FRONT_REAR_XJAL`, `ELEVATOR_DOORS_FRONT_XJAL`, `ELEVATOR_MOVEMENT_BY_SPEED`, `ELEVATOR_MOVEMENT_BY_TIME_PER_LEVEL`, `ELEVATOR_STATE_FAILED`, `ELEVATOR_STATE_IDLE`, `ELEVATOR_STATE_LOADING`, `ELEVATOR_STATE_MOVING`, `ESCALATOR_STAY_ALL`, `ESCALATOR_WALK_ALL`, `ESCALATOR_WALK_ON_LEFT_SIDE`, `ESCALATOR_WALK_ON_RIGHT_SIDE`, `EVENT_TIMEOUT_MODE_CYCLIC`, `EVENT_TIMEOUT_MODE_ONCE`, `EVENT_TIMEOUT_MODE_USER`, `EXCEEDED_QUEUE_CROWD_ROUND_AT_THE_END`, `EXCEEDED_QUEUE_EXTEND_TO_THE_FREE_SPACE`, `EXT_AGENT_CONTINUOUS`, `EXT_AGENT_DISCRETE`, `EXT_AGENT_GIS`, `EXT_AGENT_INTERACTIVE`, `EXT_AGENT_NETWORK`, `EXT_ENTITY`, `EXT_ENVIRONMENT_CONTINUOUS`, `EXT_ENVIRONMENT_DISCRETE`, `EXT_ENVIRONMENT_GIS`, `EXT_ENVIRONMENT_INTERACTIVE`, `EXT_SPACE`, `FLOW_STATISTICS_BOTH`, `FLOW_STATISTICS_LEFT`, `FLOW_STATISTICS_RIGHT`, `FOOT`, `FPM`, `FPS`, `FPS_SQ`, `HOUR`, `INCH`, `JIB_CRANE_CAT_HEAD`, `JIB_CRANE_FLAT_TOP`, `JIB_CRANE_INDUSTRIAL`, `JIB_CRANE_MOVEMENT_CONCURRENT`, `JIB_CRANE_MOVEMENT_STEP_BY_STEP`, `KILOGRAM`, `KILOGRAM_PER_SECOND`, `KILOMETER`, `KN`, `KPH`, `LIFT_PLATFORM_FLAT`, `LIFT_PLATFORM_ROLLER`, `LIFT_SELECTION_MODE_COMPARISON`, `LIFT_SELECTION_MODE_FIFO`, `LIFT_SELECTION_MODE_PRIORITY`, `LINEAR_COLOR_SCHEME`, `LITER`, `LITER_PER_SECOND`, `LOGARITHMIC_COLOR_SCHEME`, `METER`, `MILE`, `MILLIMETER`, `MILLISECOND`, `MINUTE`, `MONTH`, `MPH`, `MPS`, `MPS_SQ`, `NAUTICAL_MILE`, `NORTH`, `NORTHEAST`, `NORTHWEST`, `OBJECT_3D_INTERNAL_LIGHTING_GLOBAL`, `OBJECT_3D_INTERNAL_LIGHTING_INSIDE`, `OBJECT_3D_INTERNAL_LIGHTING_OFF`, `OBJECT_3D_XYZ_AXIS_ORDER`, `OBJECT_3D_YZX_AXIS_ORDER`, `OBJECT_3D_ZXY_AXIS_ORDER`, `OIL_BARREL`, `OIL_BARREL_PER_SECOND`, `OVERHEAD_CRANE_BRIDGE`, `OVERHEAD_CRANE_GANTRY`, `OVERHEAD_CRANE_GIRDER_DOUBLE_TIE`, `OVERHEAD_CRANE_GIRDER_SINGLE_FLAT`, `OVERHEAD_CRANE_MOVEMENT_CONCURRENT`, `OVERHEAD_CRANE_MOVEMENT_INDEPENDENT_HOIST`, `OVERHEAD_CRANE_MOVEMENT_STEP_BY_STEP`, `PALLET_RACK_LEFT_TO_RIGHT`, `PALLET_RACK_NO_DIRECTION`, `PALLET_RACK_RIGHT_TO_LEFT`, `PALLET_RACK_SINGLE_AISLE_LEFT`, `PALLET_RACK_SINGLE_AISLE_RIGHT`, `PALLET_RACK_TWO_AISLES`, `PALLET_RACK_TWO_PALLET_RACKS`, `PARKING_LOT_DIAGONAL`, `PARKING_LOT_PARALLEL`, `PARKING_LOT_PERPENDICULAR`, `PATH_CONVEYOR`, `PATH_DASHEDLINE`, `PATH_LINE`, `PATH_RAILROAD`, `PATH_ROAD`, `PEDESTRIAN_MAP_TYPE`, `PER_DAY`, `PER_HOUR`, `PER_MILLISECOND`, `PER_MINUTE`, `PER_MONTH`, `PER_SECOND`, `PER_WEEK`, `PER_YEAR`, `POSITION_CHOICE_ARRANGED`, `POSITION_CHOICE_BY_ATTRACTORS`, `POSITION_CHOICE_RANDOM`, `RACK_ODD_LEFT`, `RACK_ODD_RIGHT`, `RACK_PLACEMENT_BACK_TO_BACK`, `RACK_PLACEMENT_STAND_ALONE`, `RACK_TYPE_DRIVE_IN`, `RACK_TYPE_FIFO_FLOW`, `RACK_TYPE_LIFO_FLOW`, `RACK_TYPE_SELECTIVE`, `RAD_PER_SECOND`, `RADIAN`, `RAILWAY_SWITCH_ALL_TO_ALL`, `RAILWAY_SWITCH_DOUBLE_SLIP`, `RAILWAY_SWITCH_SINGLE_SLIP`, `RANDOM`, `RANDOM_CONNECTED`, `RANDOM_NEIGHBOR`, `ROAD_LEFT_HAND`, `ROAD_LINE_DOUBLE`, `ROAD_LINE_DOUBLE_DASHED`, `ROAD_LINE_SINGLE`, `ROAD_LINE_SINGLE_DASHED`, `ROAD_RIGHT_HAND`, `ROBOT_APPROACH_NEAREST_SIDE`, `ROBOT_APPROACH_TOP_SIDE`, `ROBOT_END_EFFECTOR_GRIPPER`, `ROBOT_END_EFFECTOR_NONE`, `ROBOT_END_EFFECTOR_VACUUM_GRIPPER`, `ROBOT_END_EFFECTOR_WELDING_GUN`, `RPM`, `SECOND`, `SERVICE_GROUP_BEHAVIOR_DEPENDS_ON_INCOMING_GROUP`, `SERVICE_GROUP_BEHAVIOR_SAME_FOR_ALL_GROUPS`, `SERVICE_GROUP_INDIVIDUAL_SERVING`, `SERVICE_GROUP_ONE_MEMBER_IS_SERVED_OTHERS_WAIT_IN_AREA`, `SERVICE_GROUP_ONE_MEMBER_IS_SERVED_OTHERS_WAIT_IN_QUEUE`, `SERVICE_QUEUE_CLOSEST_NON_EMPTY`, `SERVICE_QUEUE_CLOSEST_STRICT`, `SERVICE_QUEUE_CUSTOM`, `SERVICE_QUEUE_LONGEST`, `SERVICE_QUEUE_NEXT_ROUND_ROBIN`, `SERVICE_QUEUE_PRIORITY`, `SERVICE_TYPE_LINEAR`, `SERVICE_TYPE_POINT`, `SIGNAL_GREEN`, `SIGNAL_NONE`, `SIGNAL_RED`, `SIGNAL_YELLOW`, `SIMPLE_STATION_LOADING_MODE_AFTER_UNLOADING`, `SIMPLE_STATION_LOADING_MODE_SIMULTANEOUS_WITH_UNLOADING`, `SIMPLE_STATION_PROCESSING_WHEN_AGENT_ENTERS`, `SIMPLE_STATION_PROCESSING_WHEN_CAPACITY_FULL`, `SOUTH`, `SOUTHEAST`, `SOUTHWEST`, `SPACE_CONTINUOUS`, `SPACE_CONTINUOUS_2D`, `SPACE_DISCRETE`, `SPACE_DISCRETE_2D`, `SPACE_GIS`, `SPACE_UNDEFINED`, `SQ_CENTIMETER`, `SQ_FOOT`, `SQ_INCH`, `SQ_KILOMETER`, `SQ_METER`, `SQ_MILE`, `SQ_MILLIMETER`, `SQ_NAUTICAL_MILE`, `SQ_YARD`, `TON`, `TON_PER_SECOND`, `TRANSFER_MODE_AUTOMATIC`, `TRANSFER_MODE_MANUAL`, `TRANSPORTER_MAP_TYPE`, `TURN`, `TURN_STATION_MODE_ANGLE`, `TURN_STATION_MODE_ORIENTATION`, `WALL_FILL_HATCHING`, `WALL_FILL_NONE`, `WALL_FILL_SOLID`, `WEEK`, `WEST`, `WINDOW_3D_NAVIGATION_FULL`, `WINDOW_3D_NAVIGATION_LIMITED_TO_Z_ABOVE_ZERO`, `WINDOW_3D_NAVIGATION_NONE`, `WINDOW_3D_NAVIGATION_ROTATION_ONLY`, `YARD`, `YEAR`

### Fields inherited from interface com.anylogic.engine.EnvironmentConstants
`LAYOUT_ARRANGED`, `LAYOUT_RANDOM`, `LAYOUT_RING`, `LAYOUT_SPRING_MASS`, `LAYOUT_USER_DEFINED`, `NEIGHBORHOOD_EUCLIDEAN`, `NEIGHBORHOOD_MOORE`, `NETWORK_ALL_IN_RANGE`, `NETWORK_RANDOM`, `NETWORK_RING_LATTICE`, `NETWORK_SCALE_FREE`, `NETWORK_SMALL_WORLD`, `NETWORK_USER_DEFINED`

### Fields inherited from interface com.anylogic.engine.UtilitiesMath
`infinity`

### Fields inherited from interface com.anylogic.engine.UtilitiesRandom
`RANDOM_BOUNDED_DISTRIBUTIONS_MAX_ITERATIONS`

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `Agent()` | Create constructor. |
| `Agent(Engine engine, Agent owner, AgentList<?> ownerPopulation)` | Constructs the agent, sets up its owner and list (if replicated). |

# Method Summary

# Method Summary

| Modifier & Type | Method | Description |
|-----------------|--------|-------------|
| `static Engine` | `_initGetEngine_xjal(Agent owner)` | This method shouldn't be called by user. It is public due to technical reasons. |
| `void` | `addAgentToContents(Agent agent)` | Adds a given agent to the contents of this agent. |
| `void` | `addEntityToContents(Agent agent)` | **Deprecated.** Please use `addAgentToContents(Agent)` instead. |
| `void` | `addExt_xjal(AgentExtension ext)` | Internal method. Shouldn't be called by user. May be removed/renamed in future. |
| `String` | `agentInfo()` | — |
| `Iterable<Agent>` | `agents()` | Returns the collection of all agents registered in this space. |
| `List<? extends Agent>` | `agentsInRange(double distance)` | Returns unsorted list of agents within the given distance from this agent. |
| `List<? extends Agent>` | `agentsInRange(double distanceInUnits, LengthUnits units)` | Same as above, with specified units. |
| `final <T extends Agent> List<T>` | `agentsInRange(Iterable<T> agents, double distance)` | Returns agents from the given collection within the specified distance. |
| `final <T extends Agent> List<T>` | `agentsInRange(Iterable<T> agents, double distanceInUnits, LengthUnits units)` | Same as above, with specified units. |
| `void` | `applyLayout()` | Rearranges agents according to the selected layout type. |
| `void` | `applyNetwork()` | Rebuilds network connections based on current settings. |
| `void` | `applyNetwork(Random r)` | Same as above, using the specified random generator. |
| `boolean` | `areStepsEnabled()` | Checks if time steps are enabled. |
| `void` | `assignInitialConditions_xjal()` | Internal method. Assigns initial conditions for stocks and flow variables. |
| `boolean` | `connectTo(Agent a)` | Creates a bi-directional connection with another agent. |
| `<T extends Agent> List<T>` | `contents()` | — |
| `final void` | `create()` | Creates embedded agent objects and calls lifecycle methods. |
| `void` | `createAndStart(Agent anyAgent)` | Initializes and starts the agent with internal structure. |
| `final void` | `createAsEmbedded()` | Internal method for embedded agents. |
| `void` | `createUsdObjects()` | — |
| `FlowchartBlock` | `currentBlock()` | Returns the current flowchart block being processed. |
| `void` | `deleteSelf()` | Removes this agent from its population. |
| `void` | `deliver(Object msg, Agent dest)` | **Deprecated.** Deprecated since AnyLogic 8.9.2. |
| `void` | `deliver(Object msg, MessageDeliveryType mode)` | Delivers a message based on the specified mode. |
| `void` | `deliverToAllAgentsInside(Object msg)` | **Deprecated.** |
| `void` | `deliverToAllConnected(Object msg)` | **Deprecated.** Deprecated since AnyLogic 8.9.2. |
| `void` | `deliverToAllNeighbors(Object msg)` | **Deprecated.** Deprecated since AnyLogic 8.9.2. |
| `void` | `deliverToRandomAgentInside(Object msg)` | **Deprecated.** |
| `void` | `deliverToRandomConnected(Object msg)` | **Deprecated.** Deprecated since AnyLogic 8.9.2. |
| `void` | `deliverToRandomNeighbor(Object msg)` | **Deprecated.** Deprecated since AnyLogic 8.9.2. |
| `void` | `disableSteps()` | Disables time steps. |
| `boolean` | `disconnectFrom(Agent a)` | Disconnects from the specified agent. |
| `void` | `disconnectFromAll()` | Disconnects from all agents. |
| `double` | `distanceByRoute(Agent other)` | Calculates route-based distance (GIS only). |
| `double` | `distanceTo(double x, double y)` | Calculates distance to a point in 3D or GIS space. |
| `double` | `distanceTo(double x, double y, double z)` | Calculates distance to a point in 3D space. |
| `double` | `distanceTo(double x, double y, double z, LengthUnits units)` | Same as above, with specified units. |
| `double` | `distanceTo(double x, double y, LengthUnits units)` | Same as above, for 2D points. |
| `double` | `distanceTo(Agent other)` | Calculates distance to another agent in 3D or GIS space (returns meters in GIS). |
| `double` | `distanceTo(Agent other, LengthUnits units)` | Calculates the distance from this agent to another one in continuous 3D space or GIS space. In case of GIS space returns distance measured in meters. |
| `double` | `distanceTo(Point p)` | Calculates the distance from this agent to a given point. |
| `double` | `distanceTo(Point p, LengthUnits units)` | Calculates the distance from this agent to a given point. |
| `void` | `doAfterCreate()` | Internal callback to perform additional "after all agents created" actions. |
| `void` | `doCreate()` | Creates the agent embedded objects. Should be implemented in subclass to instantiate and initialize embedded objects. |
| `void` | `doFinish()` | Internal method. Shouldn't be called by user. May be removed/renamed in future. |
| `void` | `doStart()` | Starts activities (e.g.). |
| `void` | `drawLinksToAgents(boolean underAgents, LinkToAgentAnimator animator)` | Automatically generated by AnyLogic. |
| `void` | `enableSteps(double stepDuration)` | Enables discrete time steps with a given duration. |
| `RuntimeException` | `error(Throwable cause, String errorText)` | Signals an error during the model run by throwing a RuntimeException. |
| `RuntimeException` | `errorInModel(Throwable cause, String errorText)` | Signals a model logic error during the model run. |
| `double` | `evaluateRateOf(EventRate e)` | Evaluates the rate expression of a rate event. |
| `double` | `evaluateRateOf(TransitionRate t)` | Evaluates the rate expression of a rate transition. |
| `double` | `evaluateTimeoutOf(EventTimeout e)` | Evaluates timeout expression of a timeout event. |
| `double` | `evaluateTimeoutOf(TransitionTimeout t)` | Evaluates timeout expression of a timeout transition. |
| `void` | `executeActionOf(EventCondition e)` | Executes action of a condition event. |
| `void` | `executeActionOf(EventRate e)` | Executes action of a rate event. |
| `void` | `executeActionOf(EventTimeout e)` | Executes action of a timeout event. |
| `void` | `executeActionOf(Statechart<?> s)` | Executes startup action of a statechart. |
| `void` | `executeActionOf(TransitionCondition t)` | Executes action of a condition transition. |
| `void` | `executeActionOf(TransitionMessage t, int msg)` | Executes action of a message transition for int message type. |
| `void` | `executeActionOf(TransitionMessage t, Object msg)` | Executes action of a message transition for Object message type. |
| `void` | `executeActionOf(TransitionRate t)` | Executes action of a rate transition. |
| `void` | `executeActionOf(TransitionTimeout t)` | Executes action of a timeout transition. |
| `boolean` | `executeOnReceiveActionOf(Port<?,?> p, Object msg)` | Executes action code for a message received at a port. |
| `boolean` | `executeOnSendActionOf(Port<?,?> p, Object msg)` | Executes action for a message sent via a port. |
| `final <T extends AgentExtension> T` | `ext(Class<T> c)` | Returns an extension of given type. |
| `boolean` | `finishSimulation()` | Ends simulation if in RUNNING or PAUSED state. |
| `void` | `formulasExecute_xjal()` | Executes formulas defined in this agent. |
| `Agent` | `getAgentAtCell(int r, int c)` | Returns the agent in the specified cell or null. |
| `Agent` | `getAgentNextToMe(CellDirection dir)` | Returns the agent next to this agent in a given direction. |
| `SpaceType` | `getAgentSpaceType()` | Returns type of space where this agent lives. |
| `int` | `getAgentTypeId()` | Returns the unique identifier of agent's type. |
| `AgentAnimationSettings` | `getAnimationSettingsOf(Agent ao)` | Returns animation settings of a simple embedded object. |
| `AgentAnimationSettings` | `getAnimationSettingsOf(AgentList<?> aocollection)` | Returns animation settings of a replicated embedded object. |
| `double` | `getBlockEnterTime()` | Returns the time this agent entered its current flowchart block. |
| `int` | `getC()` | Returns the column of the agent's cell. |
| `int` | `getCameras3D(Map<String,Camera3D> output)` | Adds all Camera3D of this agent to the given map. |
| `Color` | `getColor()` | Returns the color of the item's default animation shape. |
| `Agent` | `getConnectedAgent(int index)` | Returns the connected agent with a given index. |
| `<T extends Agent> List<T>` | `getConnections()` | Returns a collection of agents connected to this agent. |
| `int` | `getConnectionsNumber()` | Returns the number of agents connected to this agent. |
| `<T extends Enum<T> & IStatechartState<?,T>> T` | `getContainerStateOf(T state)` | **Deprecated.** |
| `ConveyorNetwork[]` | `getConveyorNetworks()` | Returns array of conveyor networks in this agent. |
| `AgentList<Agent>` | `getDefaultPopulation()` | Returns the default population or null. |
| `int` | `getDifferentialFlatEquationsCount_xjal()` | Internal method. |
| `Set<DynamicEvent>` | `getDynamicEvents()` | Returns the set of all dynamic events of this agent. |
| `List<Object>` | `getEmbeddedObjects()` | Returns a list of embedded objects or null. |
| `Engine` | `getEngine()` | Returns the simulation engine of this object. |
| `Agent` | `getEnvironment()` | **Deprecated.** |
| `SpaceType` | `getEnvironmentSpaceType()` | **Deprecated.** |
| `IExperimentHost` | `getExperimentHost()` | Returns the experiment host object of the model. |
| `double` | `getFirstOccurrenceTime(EventTimeout e)` | Returns the time of first occurrence of a timeout event. |
| `double` | `getFlowchartEntryTime()` | Returns the time the entity entered the first flowchart block. |
| `final String` | `getFullName()` | Returns the name of the agent with full path. |
| `double` | `getGISHeading()` | Returns current heading angle of agent in GIS space. |
| `AbstractShapeGISMap` | `getGISMap()` | Returns AbstractShapeGISMap object used in this GIS space. Throws error if space type is different from GIS. |
| `double` | `getHeight()` | Returns the height of the agent (measured in meters) - used by conveyors and other blocks which require it during processing. |
| `double` | `getHeight(LengthUnits units)` | Returns the height of the agent (measured in the given units) - used by conveyors and other blocks which require it during processing. |
| `int` | `getId()` | Returns the unique identifier of this agent in the context of the model run. |
| `int` | `getIdOf(Statechart<?>)` | Internal method. Returns ordinal number of this statechart in the agent type. |
| `int` | `getIndex()` | For list-based agent population, returns its index in the list, otherwise -1. |
| `int` | `getInitialAlgebraicFlatEquationsCount_xjal()` | Internal method. |
| `int` | `getInitialFormulaFlatEquationsCount_xjal()` | Internal method. |
| `SDIntegrationManager` | `getIntegrationManager_xjal()` | Internal method. Returns static integration manager defined in derived classes. |
| `double` | `getLat()` | **Deprecated.** Use `getLatitude()`. |
| `double` | `getLatitude()` | Returns current latitude of the agent in GIS space. |
| `LayoutType` | `getLayoutType()` | Returns the layout type. |
| `double` | `getLength()` | Returns the length of the agent (in meters). |
| `double` | `getLength(LengthUnits units)` | Returns the length of the agent (in specified units). |
| `Level` | `getLevel()` | Returns the level this agent lives in. |
| `Level[]` | `getLevels()` | Returns array of levels located in this agent. |
| `LinkToAgentCollection<? extends Agent,? extends Agent>` | `getLinkToAgentStandard_xjal()` | Internal method. |
| `double` | `getLon()` | **Deprecated.** Use `getLongitude()`. |
| `double` | `getLongitude()` | Returns current longitude of the agent in GIS space. |
| `EventTimeout.Mode` | `getModeOf(EventTimeout e)` | Returns mode of a timeout event. |
| `final String` | `getName()` | Returns the name of this agent. |
| `String` | `getNameOf(...)` | Returns the name of various embedded objects, events, ports, statecharts, transitions, and states. |
| `final <T extends Agent> T` | `getNearestAgent(Iterable<T> agents)` | Returns the nearest agent from the given collection. |
| `final <T extends Agent> T` | `getNearestAgentByRoute(Iterable<T> agents)` | Returns the nearest agent from the given collection by route. |
| `Agent[]` | `getNeighbors()` | Returns array of neighbor agents. |
| `INetwork` | `getNetwork()` | Returns the network this agent lives in. |
| `double` | `getNetworkConnectionRange()` | Returns the range of agent connections. |
| `double` | `getNetworkConnectionsPerAgent()` | Returns average or exact number of connections per agent. |
| `double` | `getNetworkNeighborLinkProbability()` | Returns probability of an agent connection to be a neighbour. |
| `INode` | `getNetworkNode()` | Returns the network node this agent is located in. |
| `INetwork[]` | `getNetworks()` | Returns array of networks located in this agent. |
| `int` | `getNetworkScaleFreeM()` | Returns the M parameter of a scale free network. |
| `NetworkType` | `getNetworkType()` | Returns the network type. |
| `Agent` | `getOwner()` | Returns the owner agent that encapsulates this one. |
| `ShapeEmbeddedObjectPresentation` | `getOwnerShape()` | Returns the shape on owner's presentation this object belongs to. |
| `<T> T` | `getParameter(String name)` | Returns the value of parameter with the given name. Throws error if not found. |
| `String[]` | `getParameterNames()` | Returns array of all not dynamic parameter names. |
| `void` | `getPhaseVector_xjal(double[] D, int idxD, double[] A, int idxA)` | Internal method. Assigns given arrays with current variables values. |
| `void` | `getPhaseVectorForInitialConditions_xjal(double[] A, int idxA)` | Internal method. Assigns arrays with values for solving initial conditions loops. |
| `AgentList<?>` | `getPopulation()` | Returns the list of agents embedded in the owner object. |
| `Position` | `getPosition()` | Returns current x, y (and z) coordinate and orientation. |
| `Position` | `getPosition(Position out)` | Same as above, with output parameter. |
| `double` | `getPresentationScaleOnOwnerSpace()` | Returns the scale of the agent presentation animation. |
| `ShapeTopLevelPresentationGroup` | `getPresentationShape()` | — |
| `int` | `getR()` | Returns the row of the agent's cell. |
| `RailwayNetwork[]` | `getRailwayNetworks()` | Returns array of railway networks in this agent. |
| `Agent` | `getRandomConnectedAgent()` | Returns a randomly chosen connected agent. |
| `AgentList<?>` | `getReplicatedCollection()` | **Deprecated.** May be removed in the next release. |
| `AgentList<?>` | `getReplicatedList()` | Returns the list of embedded agents in the owner object. |
| `void` | `getRightPart_xjal(double[] DR, int idxDR, double[] AR, int idxAR)` | Internal method. Calculates right parts of equations. |
| `void` | `getRightPartForInitialConditions_xjal(double[] AR, int idxAR)` | Internal method. Used for solving algebraic loops in initial conditions. |
| `RoadNetwork[]` | `getRoadNetworks()` | Returns array of road networks in this agent. |
| `Agent` | `getRootAgent()` | Returns the top-level agent or null. |
| `double` | `getRotation()` | Returns the current rotation angle in radians. |
| `IRouteProvider` | `getRouteProvider()` | Returns the provider of routes for agent movement. |
| `int` | `getRuntimeAlgebraicFlatEquationsCount_xjal()` | Internal method. |
| `int` | `getRuntimeFormulaFlatEquationsCount_xjal()` | Internal method. |
| `Scale` | `getScale()` | Returns the scale used by the space of this agent. |
| `Agent` | `getSpace()` | Returns the agent representing the space. |
| `SpaceType` | `getSpaceType()` | Returns the agent space type. |
| `double` | `getSpeed()` | Returns the current speed of the agent. |
| `double` | `getSpeed(SpeedUnits units)` | Returns the current speed in specified units. |
| `Statechart` | `getStatechartOf(TransitionCondition t)` | Returns the statechart of the condition transition. |
| `Statechart` | `getStatechartOf(TransitionMessage t)` | Returns the statechart of the message transition. |
| `Statechart` | `getStatechartOf(TransitionRate t)` | Returns the statechart of the rate transition. |
| `Statechart` | `getStatechartOf(TransitionTimeout t)` | Returns the statechart of the timeout transition. |
| `double` | `getTargetLat()` | Returns latitude of target location or current latitude. |
| `double` | `getTargetLon()` | Returns longitude of target location or current longitude. |
| `double` | `getTargetX()` | Returns x of target location or current x. |
| `double` | `getTargetY()` | Returns y of target location or current y. |
| `double` | `getTargetZ()` | Returns z of target location or current z. |
| `UsdContext` | `getUsdContext()` | — |
| `double` | `getVelocity()` | **Deprecated.** Deprecated since AnyLogic 7.1. |
| `double` | `getVerticalRotation()` | Returns vertical rotation angle in 3D space. |
| `double` | `getWidth()` | Returns width of the agent in meters. |
| `double` | `getWidth(LengthUnits units)` | Returns width in specified units. |
| `double` | `getX()` | Returns current x coordinate. |
| `Point` | `getXYZ()` | Returns current x, y, z coordinates. |
| `Point` | `getXYZ(Point out)` | Same as above, with output parameter. |
| `double` | `getY()` | Returns current y coordinate. |
| `double` | `getZ()` | Returns current z coordinate. |
| `void` | `goToPopulation(AgentList newPopulation)` | Changes the population of agent. |
| `void` | `highlight(boolean yes)` | Turns on/off highlighting of agent animation. |
| `void` | `instantiateBaseStructure_xjal()` | Internal method. May be removed/renamed. |
| `boolean` | `inState(IStatechartState<?,?> state)` | Returns true if agent is in specified state. |
| `boolean` | `isAgent()` | Returns true if this is an agent. |
| `boolean` | `isAutomaticHorizontalRotation()` | Returns true if agent rotates during movement. |
| `boolean` | `isAutomaticVerticalRotation()` | Returns true if agent rotates vertically in 3D. |
| `boolean` | `isConnectedTo(Agent a)` | Tests if agent is connected to another. |
| `boolean` | `isEmbeddedAgentPresentationVisible(Agent embeddedAgent)` | Internal method. Works for single embedded objects. |
| `boolean` | `isEnvironment()` | **Deprecated.** |
| `boolean` | `isLoggingToDB(LoggingType loggingType)` | Returns true if agent logs to AnyLogic DB. |
| `boolean` | `isLoggingToDB(EventOriginator e)` | Returns true if event is logged to database. |
| `boolean` | `isMoving()` | Tests if the agent is currently moving in continuous 3D space or GIS space. |
| `boolean` | `isNextCellInsideSpace(CellDirection dir)` | Returns true if there is an adjacent cell in a given direction. |
| `boolean` | `isPublicPresentationDefined()` | Internal method. May be removed/renamed in future. |
| `boolean` | `isReplicated()` | Returns true if this object is embedded in its owner as replicated. |
| `boolean` | `isSpacePositionSet_xjal()` | **Deprecated.** |
| `void` | `jumpTo(...)` | Instantly moves the agent to a given location (various overloads). |
| `boolean` | `jumpToRandomEmptyCell()` | Finds a random empty cell and places the agent there. |
| `<T extends Enum<T> & IStatechartState<?,T>> void` | `logToDB(...)` | Logs state transitions if logging is enabled. |
| `void` | `markParametersAreSet()` | Marks agents created with no-arg constructor as having all parameters set. |
| `void` | `moveTo(...)` | Starts movement to a target location or agent (various overloads). |
| `void` | `moveToInTime(...)` | Starts movement to a target with speed adjusted to reach in given time (various overloads). |
| `boolean` | `isMoving()` | Tests if the agent is currently moving in continuous 3D space or GIS space. |
| `boolean` | `isNextCellInsideSpace(CellDirection dir)` | Returns true if there is an adjacent cell in a given direction. |
| `boolean` | `isPublicPresentationDefined()` | Internal method. May be removed/renamed in future. |
| `boolean` | `isReplicated()` | Returns true if this object is embedded in its owner as replicated. |
| `boolean` | `isSpacePositionSet_xjal()` | **Deprecated.** |
| `void` | `jumpTo(...)` | Instantly moves the agent to a given location (various overloads). |
| `boolean` | `jumpToRandomEmptyCell()` | Finds a random empty cell and places the agent there. |
| `<T extends Enum<T> & IStatechartState<?,T>> void` | `logToDB(...)` | Logs state transitions if logging is enabled. |
| `void` | `markParametersAreSet()` | Marks agents created using no-arg constructor as having all parameters set. |
| `void` | `moveTo(...)` | Starts movement toward a target location or agent (various overloads). |
| `void` | `moveToInTime(...)` | Starts timed movement toward a target (various overloads). |
| `void` | `moveToNearestAgent(...)` | Starts movement to the nearest agent from a collection. |
| `void` | `moveToNextCell(CellDirection dir)` | Moves the agent to an adjacent cell in a given direction. |
| `void` | `moveToStraight(...)` | Starts straight movement ignoring network/routes. |
| `void` | `moveToStraightInTime(...)` | Starts timed straight movement ignoring network/routes. |
| `void` | `nothingChanged()` | Prevents engine from calling `onChange()` during event execution. |
| `void` | `onAfterStepEnvironment()` | Called at the end of every step after agent actions. |
| `void` | `onArrival()` | Called when the agent arrives at the target location. |
| `void` | `onBeforeCreate()` | Called at the start of `create()` method. |
| `void` | `onBeforeStep()` | Called at the beginning of every step before `onStep()`. |
| `void` | `onBeforeStepEnvironment()` | Called before agents perform step actions. |
| `void` | `onChange()` | Notification that agent data may have changed. |
| `void` | `onCreate()` | Called at the end of `create()` method. |
| `void` | `onDestroy()` | Must be called when the agent is disposed. |
| `void` | `onEngineFinished()` | Called when the engine finishes running. |
| `void` | `onEnterFlowchartBlock(...)` | Called when the agent enters a flowchart block. |
| `void` | `onExitFlowchartBlock(...)` | Called when the agent exits a flowchart block. |
| `void` | `onOwnerChanged_xjal()` | Internal method. May be removed/renamed in future. |
| `void` | `onReceive(Object msg, Agent sender)` | Called when the agent receives a message. |
| `void` | `onReleaseResource(Agent unit)` | Called when the agent releases a resource. |
| `void` | `onSeizeResource(Agent unit)` | Called when the agent seizes a resource. |
| `void` | `onStartup()` | Called after all activities are started. |
| `void` | `onStep()` | Called at every step in discrete time. |
| `boolean` | `pauseSimulation()` | Pauses the simulation if it is running. |
| `void` | `putPhaseVector_xjal(double[] D, int idxD, double[] A, int idxA)` | Internal method. Assigns variable values from arrays. |
| `void` | `putPhaseVectorForInitialConditions_xjal(double[] A, int idxA)` | Internal method for assigning initial condition values. |
| `Agent` | `randomAgentInside()` | Returns a random agent in the space or null if none. |
| `Agent` | `randomAgentInside(Random r)` | Returns a random agent using the specified random generator. |
| `CellPosition` | `randomEmptyCell()` | Finds a pseudo-random empty cell and returns its position. |
| `Point` | `randomPointOfSpace()` | Returns a random location in the space. |
| `void` | `receive(Object msg)` | **Deprecated.** Deprecated since AnyLogic 8.9.2. |
| `boolean` | `removeAgentFromContents(Agent agent)` | Removes the given agent from this agent's contents. |
| `boolean` | `removeEntityFromContents(Agent agent)` | **Deprecated.** Use `removeAgentFromContents(Agent)` instead. |
| `boolean` | `removeExt_xjal(AgentExtension ext)` | Internal method to remove an extension if found. |
| `void` | `removeFromFlowchart()` | Internal method. May be removed/renamed in future. |
| `void` | `removeUsdObjects()` | — |
| `Agent` | `resourceUnitOfPool(Agent pool)` | Returns the first seized resource unit from the given pool. |
| `<T extends Agent> List<T>` | `resourceUnits()` | Returns list of seized resource units. |
| `<T extends Agent> List<T>` | `resourceUnitsOfPool(Agent pool)` | Returns seized resource units from the given pool. |
| `<T extends Agent> List<T>` | `resourceUnitsOfSeize(Agent seize)` | Returns seized resource units from the given Seize block. |
| `final void` | `restoreCollection_xjal(AgentList<?> collection)` | **Deprecated.** |
| `void` | `restoreConnections_xjal(List<?> connections)` | **Deprecated.** |
| `void` | `restoreOwner(Object owner)` | **Deprecated.** |
| `boolean` | `runSimulation()` | Starts simulation if in PAUSED state. |
| `void` | `send(Object msg, Agent dest)` | Sends a message to a specific agent. |
| `void` | `send(Object msg, MessageDeliveryType mode)` | Sends a message based on delivery mode. |
| `void` | `sendToAll(Object msg)` | Sends a message to all agents in the same space. |
| `void` | `sendToAllAgentsInside(Object msg)` | Sends a message to all agents in the space. |
| `void` | `sendToAllConnected(Object msg)` | Sends a message to all connected agents. |
| `void` | `sendToAllNeighbors(Object msg)` | Sends a message to all neighbors. |
| `void` | `sendToRandom(Object msg)` | Sends a message to a random agent in the same space. |
| `void` | `sendToRandomAgentInside(Object msg)` | Sends a message to a random agent in the space. |
| `void` | `sendToRandomConnected(Object msg)` | Sends a message to a random connected agent. |
| `void` | `sendToRandomNeighbor(Object msg)` | Sends a message to a random neighbor. |
| `void` | `setAgentSpaceType(SpaceType spaceType)` | Sets the space type for this agent. |
| `void` | `setAutomaticHorizontalRotation(boolean yes)` | Enables/disables automatic horizontal rotation. |
| `void` | `setAutomaticVerticalRotation(boolean yes)` | Enables/disables automatic vertical rotation. |
| `void` | `setCell(int r, int c)` | Places the agent in a specific cell. |
| `void` | `setColor(Color color)` | Sets the default animation shape color. |
| `void` | `setDestroyed()` | Marks the object for destruction after current step. |
| `void` | `setDimensions(double lengthInMeters, double widthInMeters, double heightInMeters)` | Sets agent dimensions in meters. |
| `void` | `setDimensions(double lengthInUnits, double widthInUnits, double heightInUnits, LengthUnits units)` | Sets agent dimensions in specified units. |
| `void` | `setEngine(Engine engine)` | Sets the simulation engine. |
| `void` | `setEnvironment(Agent env)` | **Deprecated.** |
| `void` | `setHeight(double heightInMeters)` | Sets the height in meters. |
| `void` | `setHeight(double heightInUnits, LengthUnits units)` | Sets the height in specified units. |
| `void` | `setId(int id)` | Sets the agent ID. |
| `void` | `setLatLon(double latitude, double longitude)` | Sets the agent's coordinates. |
| `void` | `setLayoutType(LayoutType type)` | Sets the layout type. |
| `void` | `setLength(double lengthInMeters)` | Sets the length in meters. |
| `void` | `setLength(double lengthInUnits, LengthUnits units)` | Sets the length in specified units. |
| `void` | `setLevel(Level level)` | Sets the level for the agent. |
| `void` | `setLocation(Agent agent)` | Sets location to match another agent. |
| `void` | `setLocation(Attractor attractor)` | Sets the network location using an attractor. |
| `void` | `setLocation(INode node)` | Initializes location using a network node. |
| `void` | `setLocation(Point point)` | Initializes location using a point. |
| `void` | `setLocationRandomInside(INode node)` | Sets the coordinates of the agent location to a random point inside the given node. Initialization only. |
| `void` | `setNetwork(INetwork network)` | Sets this agent to live in the network. |
| `void` | `setNetworkAllInRange(double connectionRange)` | Sets network type to connect agents within a given distance. |
| `void` | `setNetworkNode(Attractor attractor)` | Sets the current network location for the agent. |
| `void` | `setNetworkNode(INode node)` | Sets the current network location for the agent. |
| `void` | `setNetworkNode(INode node, Point position)` | **Deprecated.** |
| `void` | `setNetworkRandom(double connectionsPerAgent)` | Sets network type to random with specified average connections. |
| `void` | `setNetworkRingLattice(int connectionsPerAgent)` | Sets network type to ring lattice. |
| `void` | `setNetworkScaleFree(int m)` | Sets network type to scale free. |
| `void` | `setNetworkSmallWorld(int connectionsPerAgent, double neighborLinkProbability)` | Sets network type to small world. |
| `void` | `setNetworkUserDefined()` | Sets network type to user-defined. |
| `boolean` | `setParameter(String name, Object value, boolean callOnChange)` | Sets a parameter value by name. |
| `void` | `setParametersToDefaultValues()` | Resets all non-dynamic parameters to default values. |
| `void` | `setPosition(Position position)` | Sets coordinates and orientation of the agent. Initialization only. |
| `void` | `setRotation(double rotation)` | Sets rotation angle of the agent in 3D or GIS space. |
| `void` | `setRouteProvider(IRouteProvider routeProvider)` | Stops agent if it is moving. |
| `void` | `setSpace(Agent space)` | Sets the space for the agent. |
| `void` | `setSpeed(double speedInMPS)` | Sets agent speed in meters per second. |
| `void` | `setSpeed(double speedInUnits, SpeedUnits units)` | Sets agent speed in specified units. |
| `void` | `setupExt_xjal(AgentExtension ext)` | Internal method. Not for user. |
| `void` | `setupInitialConditions_xjal(Class<?> callerClass)` | Internal method. Not for user. |
| `void` | `setupSpace(double width, double height)` | Sets space dimensions. |
| `void` | `setupSpace(double width, double height, double zHeight)` | Sets 3D space dimensions. |
| `void` | `setupSpace(double width, double height, int rows, int columns, NeighborhoodType neighborhoodType)` | Sets discrete space with neighborhood type. |
| `void` | `setupSpace(AbstractShapeGISMap gisMap)` | Sets GIS space using the given map. |
| `void` | `setVelocity(double v)` | **Deprecated.** |
| `void` | `setVerticalRotation(double rotation)` | Sets vertical rotation angle in 3D space. |
| `void` | `setWidth(double widthInMeters)` | Sets agent width in meters. |
| `void` | `setWidth(double widthInUnits, LengthUnits units)` | Sets agent width in specified units. |
| `void` | `setXY(double x, double y)` | Sets 2D coordinates of the agent. |
| `void` | `setXYZ(double x, double y, double z)` | Sets 3D coordinates of the agent. Initialization only. |
| `void` | `setXYZ(Point location)` | Sets 3D coordinates using a Point. Initialization only. |
| `double` | `spaceCellHeight()` | Returns height of a cell in discrete space. |
| `double` | `spaceCellWidth()` | Returns width of a cell in discrete space. |
| `int` | `spaceColumns()` | Returns number of columns in the space. |
| `double` | `spaceHeight()` | Returns height of the space. |
| `int` | `spaceRows()` | Returns number of rows in the space. |
| `double` | `spaceWidth()` | Returns width of the space. |
| `double` | `spaceZHeight()` | Returns height of the space along Z-axis. |
| `final void` | `start()` | Starts agent activities. |
| `final void` | `startAsEmbedded()` | Internal method for embedded agents. |
| `<T extends Enum<T> & IStatechartState<?,T>> boolean` | `stateContainsState(T compstate, T simpstate)` | **Deprecated.** |
| `void` | `stop()` | Stops movement in continuous 3D or GIS space. |
| `boolean` | `stopSimulation()` | Engine command applicable only in any non-IDLE state (in IDLE state does nothing and returns false). |
| `void` | `swapWithAgent(Agent anotherAgent)` | Swaps the cell location of this agent with another agent. |
| `void` | `swapWithCell(int r, int c)` | Swaps this agent with an agent at the cell with the given row and column. |
| `void` | `swapWithNextCell(CellDirection dir)` | Swaps the agent with an agent at the adjacent cell in a given direction. |
| `boolean` | `testConditionOf(EventCondition e)` | Tests the condition expression of a condition event. Must be implemented in a subclass if there are any condition events. |
| `boolean` | `testConditionOf(TransitionCondition t)` | Tests the condition expression of a transition event. Must be implemented in a subclass if there are any condition transitions. |
| `boolean` | `testGuardOf(TransitionCondition t)` | Tests the guard expression of a condition transition. Implementation in a subclass can be skipped if the guard(s) are empty. |
| `boolean` | `testGuardOf(TransitionMessage t)` | Tests the guard expression of a message transition. Implementation in a subclass can be skipped if the guard(s) are empty. |
| `boolean` | `testGuardOf(TransitionRate t)` | Tests the guard expression of a rate transition. Implementation in a subclass can be skipped if the guard(s) are empty. |
| `boolean` | `testGuardOf(TransitionTimeout t)` | Tests the guard expression of a timeout transition. Implementation in a subclass can be skipped if the guard(s) are empty. |
| `boolean` | `testMessageOf(TransitionMessage t, Object msg)` | Tests the message received by the statechart against the trigger description of a message transition - for Object message type. Must be implemented in a subclass if there are any message transitions. |
| `final double` | `timeToArrival()` | Returns the time to arrival to the target location in continuous 2D space or GIS space, in model-time units. If the agent is not moving, returns 0. |
| `final double` | `timeToArrival(TimeUnits units)` | Returns the time to arrival to the target location in continuous 2D space or GIS space, in model-time units. If the agent is not moving, returns 0. |
| `double` | `toLengthUnits(double lengthInPixels, LengthUnits units)` | Converts the given pixel length to the length units (using scale of this agent which acts as 'Space'). |
| `double` | `toPixels(double lengthInUnits, LengthUnits units)` | Converts the length in the given length units to pixels (using scale of this agent which acts as 'Space'). |
| `String` | `toString()` | Returns a (possibly, multi-line) textual information on the agent. |
| `final <T extends AgentExtension> T` | `tryExt(Class<T> c)` | Returns an extension of given type only if this object already contains such extension. |
| `void` | `warning(String warningText)` | Signals a warning during the model run with warningText preceded by the agent full name. |
| `void` | `warning(String warningTextFormat, Object... args)` | Signals a warning during the model run with warningText preceded by the agent full name. |

## Methods inherited from class com.anylogic.engine.Utilities

addToDate, atan2fast, bernoulli, beta, binomial, briefInfoOn, castNumberTypes, castTypes, castTypesBack, cauchy, chi2, convertMarkupSegmentDescriptors_xjal, copyToClipboard, createTableElementDatabaseBuilder, createTrajectoryGIS, createURL_xjal, date, dateToTime, day, deleteFrom, difference, differenceInCalendarUnits, differenceInDateUnits, dirToAngle, dropTime, erlang, error, errorInModel, executeAction, executeExpression, executeStatement, exponential, findExistingFile, format, formatAmountUnits, formatDayOfWeek, formatFlowRateUnits, formatGeoHeading, formatLatitude, formatLengthUnits, formatLongitude, formatMonth, formatSpeedUnits, formatTimeInterval, gamma, gammaLog, geometric, getAmPm, getCanonicalPath, getDatabaseConnection, getDateWithTimeNextTo, getDayOfMonth, getDayOfWeek, getDayOfYear, getDefaultRandomGenerator, getDistance, getDistanceFromPointToLine, getDistanceFromPointToLineSq, getDistanceFromPointToSegment, getDistanceFromPointToSegmentSq, getDistanceGIS, getDistanceSq, getFullName, getHour, getHourOfDay, getLength, getLengthSq, getMillisecond, getMinute, getMonth, getName, getNearestPointOnSegment, getPerformanceParallelWorkersCount_xjal, getRandom, getResult, getSecond, getTime, getTimeoutToNextTime, getYear, gumbel1, gumbel2, hour, hypergeometric, insertInto, inspectOf, inspectOfLink_xjal, isFinite, isLineIntersectingLine, isLineIntersectingRectangle, isLoggingClassToDB, isPointInsideRay, isPointInsideRectangle, isPointInsideSegment, isPointOnTheSameLine, isRayIntersectingSegment, joinArrays_xjal, laplace, layoutTypeToString, limit, limitMax, limitMin, logarithmic, logistic, lognormal, logToDB, millisecond, minute, month, negativeBinomial, normal, pareto, pert, poisson, prepareBeforeExperimentStart_xjal, prepareStatement, pulse, pulseTrain, quantum, ramp, randomColor, randomFalse, randomFrom, randomlyCreate, randomTrue, randomWhere, rayleigh, roundToDecimal, roundToInt, second, selectAndDoForEach, selectArrayOfDouble, selectArrayOfInt, selectExists, selectFirstValue, selectFrom, selectResultSet, selectTableFunction, selectUniqueValue, selectValues, setDefaultRandomGenerator, sqlGetObject, sqlSetObject, sqr, step, time, timeToDate, toDate, toDateInMillis, toLatitude, toLongitude, toModelRate, toModelTime, toRateUnits, toStringAlignedNameValues, toTimeout, toTimeoutInCalendar, toTimeUnits, trace, traceln, traceToDB, triangular, triangularAV, uniform, uniform_discr, uniform_pos, update, week, weibull, xidz, year, zidz

## Methods inherited from class com.anylogic.engine.Presentable

createElementDescriptors, executeShapeControlAction, getElementDesciptors, getElementProperty, getExperiment, getModelElementsShape, getPresentation, getShapeControlDefaultValueBoolean, getShapeControlDefaultValueDouble, getShapeControlDefaultValueInt, getShapeControlDefaultValueString, getViewAreas, iconContains, onSelectionChanged_xjal, onShapeClick, onShapeGroupDraw, presentationContains, readCustomData, updateShapeDynamicProperties, writeCustomData

## Methods inherited from class java.lang.Object

equals, getClass, hashCode, notify, notifyAll, wait

## Methods inherited from interface com.anylogic.engine.UtilitiesRandom

bernoulli, beta, binomial, cauchy, chi2, erlang, exponential, gamma, geometric, gumbel1, gumbel2, hypergeometric, laplace, logarithmic, logistic, lognormal, negativeBinomial, normal, pareto, pert, poisson, random, randomFalse, randomFrom, randomlyCreate, randomTrue, randomWhere, rayleigh, shuffle, triangular, triangularAV, uniform, uniform_discr, uniform_pos, weibull

# Agent Class: Field and Constructor Details

## Field Details

### `_ARRIVAL_message_xjal`
- **Annotation**: `@AnyLogicInternalCodegenAPI`
- **Type**: `public static final Object`
- **Description**: This variable shouldn't be accessed by user: it is used internally by AnyLogic and may be renamed/removed in future.

---

## Constructor Details

### `Agent(Engine engine, Agent owner, AgentList<?> ownerPopulation)`
- **Description**: Constructs the agent, sets up its owner and list (if replicated). Should not create any embedded objects: parameters must be set by the owner after construction and only then `create()` should be called.
- **Parameters**:
  - `engine`: the simulation engine
  - `owner`: owner agent that encapsulates this one, or `null` if this is root
  - `ownerPopulation`: collection of agent populations where this object belongs to or `null` if not replicated

---

### `Agent()`
- **Description**: Create constructor. This is a way for e.g. simple creation of entities. Note that object is created BUT parameters are not set and its structure is neither created nor started.
- **Usage Notes**:
  - To set default values of parameters please call `setParametersToDefaultValues()`
  - To create structure and start, please either call `createAndStart(Agent)` or `goToPopulation(AgentList)`
  - These functions will call `setParametersToDefaultValues()` if it hasn't yet been called or if the agent has been created using other constructor
  - These functions are automatically called by AnyLogic libraries, therefore you don't need to call them for entities
  - All the agents in the running model should have owner either in the form of population or in the form of direct link
  - The only agent in the model having `null` owner is top-level agent