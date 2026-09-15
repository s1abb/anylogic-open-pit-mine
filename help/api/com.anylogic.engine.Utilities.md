# Class Utilities

## Package
`com.anylogic.engine`

## Inheritance Hierarchy
```
java.lang.Object
  com.anylogic.engine.Presentable
    com.anylogic.engine.Utilities
```

## All Implemented Interfaces
`AgentConstants`, `EnvironmentConstants`, `UtilitiesMath`, `UtilitiesRandom`, `UtilitiesString`, `Serializable`

## Direct Known Subclasses
`Agent`, `Experiment`

## Class Declaration
```java
public abstract class Utilities extends Presentable implements EnvironmentConstants, AgentConstants, UtilitiesRandom, UtilitiesMath, UtilitiesString
```

## Description
This class provides a lot of commonly used functions and constants, including probability distributions and mathematical functions. The class is a superclass for `Agent` and `Experiment`, so that its functions can be called without any prefixing from any code written by the user within those subclasses.

**Author:** AnyLogic North America, LLC https://anylogic.com

## Field Summary

### Date and Time Constants
| Modifier and Type | Field | Description |
|-------------------|-------|-------------|
| `static final int` | `AM` | Value of the getAmPm(Date) method indicating the period of the day from midnight to just before noon. |
| `static final int` | `PM` | Value of the getAmPm(Date) method indicating the period of the day from noon to just before midnight. |
| `static final int` | `JANUARY` | Value of the getMonth(Date) method indicating the first month of the year. |
| `static final int` | `FEBRUARY` | Value of the getMonth(Date) method indicating the second month of the year. |
| `static final int` | `MARCH` | Value of the getMonth(Date) method indicating the third month of the year. |
| `static final int` | `APRIL` | Value of the getMonth(Date) method indicating the fourth month of the year. |
| `static final int` | `MAY` | Value of the getMonth(Date) method indicating the fifth month of the year. |
| `static final int` | `JUNE` | Value of the getMonth(Date) method indicating the sixth month of the year. |
| `static final int` | `JULY` | Value of the getMonth(Date) method indicating the seventh month of the year. |
| `static final int` | `AUGUST` | Value of the getMonth(Date) method indicating the eighth month of the year. |
| `static final int` | `SEPTEMBER` | Value of the getMonth(Date) method indicating the ninth month of the year. |
| `static final int` | `OCTOBER` | Value of the getMonth(Date) method indicating the tenth month of the year. |
| `static final int` | `NOVEMBER` | Value of the getMonth(Date) method indicating the eleventh month of the year. |
| `static final int` | `DECEMBER` | Value of the getMonth(Date) method indicating the twelfth month of the year. |
| `static final int` | `UNDECIMBER` | Value of the getMonth(Date) method indicating the thirteenth month of the year. |
| `static final int` | `SUNDAY` | Value of the getDayOfWeek(Date) method indicating Sunday. |
| `static final int` | `MONDAY` | Value of the getDayOfWeek(Date) method indicating Monday. |
| `static final int` | `TUESDAY` | Value of the getDayOfWeek(Date) method indicating Tuesday. |
| `static final int` | `WEDNESDAY` | Value of the getDayOfWeek(Date) method indicating Wednesday. |
| `static final int` | `THURSDAY` | Value of the getDayOfWeek(Date) method indicating Thursday. |
| `static final int` | `FRIDAY` | Value of the getDayOfWeek(Date) method indicating Friday. |
| `static final int` | `SATURDAY` | Value of the getDayOfWeek(Date) method indicating Saturday. |

### Time Unit Constants
| Modifier and Type | Field | Description |
|-------------------|-------|-------------|
| `static final long` | `TIME_UNIT_MILLISECOND` | One of the possible time units. |
| `static final long` | `TIME_UNIT_SECOND` | One of the possible time units. |
| `static final long` | `TIME_UNIT_MINUTE` | One of the possible time units. |
| `static final long` | `TIME_UNIT_HOUR` | One of the possible time units. |
| `static final long` | `TIME_UNIT_DAY` | One of the possible time units. |
| `static final long` | `TIME_UNIT_WEEK` | One of the possible time units. |
| `static final long` | `TIME_UNIT_MONTH` | One of the possible time units. |
| `static final long` | `TIME_UNIT_YEAR` | One of the possible time units. |

### Length Unit Constants
| Modifier and Type | Field | Description |
|-------------------|-------|-------------|
| `static final LengthUnits` | `LENGTH_UNIT_METER` | Meter length unit. |
| `static final LengthUnits` | `LENGTH_UNIT_CENTIMETER` | Centimeter length unit. |
| `static final LengthUnits` | `LENGTH_UNIT_KILOMETER` | Kilometer length unit. |
| `static final LengthUnits` | `LENGTH_UNIT_INCH` | Inch length unit. |
| `static final LengthUnits` | `LENGTH_UNIT_FOOT` | Foot length unit. |
| `static final LengthUnits` | `LENGTH_UNIT_MILE` | Mile length unit. |

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
| `Utilities()` | Default constructor |

## Method Summary

### Time and Date Methods
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `double` | `time()` | Returns the current model (logical) time. |
| `double` | `time(TimeUnits units)` | Returns the current model (logical) time in specified units. |
| `Date` | `date()` | Returns the current model date with respect to the start time/date and the model time unit. |
| `double` | `millisecond()` | Returns a time value equal to one millisecond according to the current time unit setting. |
| `double` | `second()` | Returns a time value equal to one second according to the current time unit setting. |
| `double` | `minute()` | Returns a time value equal to one minute according to the current time unit setting. |
| `double` | `hour()` | Returns a time value equal to one hour according to the current time unit setting. |
| `double` | `day()` | Returns a time value equal to 24-hour day according to the current time unit setting. |
| `double` | `week()` | Returns a time value equal to one week according to the current time unit setting. |
| `double` | `month()` | Returns a time value equal to 30 days according to the current time unit setting. |
| `double` | `year()` | Returns a time value equal to 365 days according to the current time unit setting. |
| `Date` | `timeToDate(double t)` | Converts the given model time to date with respect to the start date, start time and model time unit settings. |
| `double` | `dateToTime(Date d)` | Converts the given date to model time with respect to the start date, start time and model time unit settings. |
| `static Date` | `addToDate(Date date, int timeUnit, double amount)` | Returns the date, which will be after the given amount of timeUnits from the given date. |
| `static Date` | `addToDate(Date date, TimeUnits timeUnit, double amount)` | Returns the date, which will be after the given amount of timeUnits from the given date. |
| `double` | `differenceInCalendarUnits(TimeUnits timeUnit, double time1, double time2)` | Returns the difference (time2 - time1) between two model dates in the given time units. |
| `static double` | `differenceInCalendarUnits(TimeUnits timeUnit, Date date1, Date date2)` | Returns the difference (date2 - date1) between two dates in the given time units. |
| `double` | `toModelTime(double value, TimeUnits units)` | Converts the given timeout (in units) to model time units. |
| `double` | `toTimeUnits(double modelTimeValue, TimeUnits units)` | Converts the timeout (in model time units) to the given units. |
| `double` | `toModelRate(double value, RateUnits units)` | Converts the given rate (in rate units) to units based on model time units. |
| `double` | `toRateUnits(double modelRateValue, RateUnits units)` | Converts the rate (in units based on model time units) to the given units. |
| `double` | `toTimeoutInCalendar(TimeUnits timeUnit, double amount)` | Returns timeout, in model time units, which equals to the given amount of timeUnits from current model date. |
| `double` | `getTimeoutToNextTime(int hourOfDay, int minute, int second)` | Returns timeout, in model time units, to the nearest date which will have the specified in-day time. |
| `String` | `formatTimeInterval(double dt)` | Returns a string representation of a given time interval, according to the current time unit settings. |

### Date Component Methods
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `int` | `getYear()` | Returns the year of the current model date. |
| `static int` | `getYear(Date date)` | Returns the year of the given date. |
| `int` | `getMonth()` | Returns the month of the current model date. |
| `static int` | `getMonth(Date date)` | Returns the month of the given date. |
| `int` | `getDayOfMonth()` | Returns the day of the month of the current model date. |
| `static int` | `getDayOfMonth(Date date)` | Returns the day of the month of the given date. |
| `int` | `getDayOfWeek()` | Returns the day of the week of the current model date. |
| `static int` | `getDayOfWeek(Date date)` | Returns the day of the week of the given date. |
| `static int` | `getDayOfYear(Date date)` | Returns the day of the year of the given date. |
| `int` | `getHourOfDay()` | Returns the hour of day of the current model date (24-hour clock). |
| `static int` | `getHourOfDay(Date date)` | Returns the hour of day of the given date (24-hour clock). |
| `int` | `getHour()` | Returns the hour of the morning or afternoon of the current model date (12-hour clock). |
| `static int` | `getHour(Date date)` | Returns the hour of the morning or afternoon of the given date (12-hour clock). |
| `int` | `getAmPm()` | Indicates whether the hour of the current model date is before (AM) or after (PM) noon. |
| `static int` | `getAmPm(Date date)` | Indicates whether the hour of the given date is before (AM) or after (PM) noon. |
| `int` | `getMinute()` | Returns the minute within the hour of the current model date. |
| `static int` | `getMinute(Date date)` | Returns the minute within the hour of the given date. |
| `int` | `getSecond()` | Returns the second within the minute of the current model date. |
| `static int` | `getSecond(Date date)` | Returns the second within the minute of the given date. |
| `int` | `getMillisecond()` | Returns the millisecond within the second of the current model date. |
| `static int` | `getMillisecond(Date date)` | Returns the millisecond within the second of the given date. |

### Date Formatting and Conversion Methods
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `static Date` | `toDate(int year, int month, int day)` | Returns the date in the default time zone with given field values and the time set to midnight. |
| `static Date` | `toDate(int year, int month, int day, int hourOfDay, int minute, int second)` | Returns the date in the default time zone with given field values. |
| `static Date` | `toDate(String dateFormat, String text)` | Parses the date from the given string using date format pattern. |
| `static long` | `toDateInMillis(int year, int month, int day, int hourOfDay, int minute, int second)` | Returns the date in its milliseconds representation. |
| `static Date` | `dropTime(Date date)` | Drops time-of-the-day information and returns the date with the time 00:00:00.000. |
| `static Date` | `getDateWithTimeNextTo(Date date, int hourOfDay, int minute, int second)` | Returns the date which is the next date after the given date and has the specified time. |
| `static String` | `formatDayOfWeek(int dayOfWeek, boolean fullName)` | Returns the full or short name of the weekday. |
| `static String` | `formatMonth(int month, boolean fullName)` | Returns the full or short name of the month. |

### Mathematical Functions
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `static double` | `limit(double min, double x, double max)` | Returns x if it is within [min,max] interval, otherwise returns the closest bound. |
| `static int` | `limit(int min, int x, int max)` | Returns x if it is within [min,max] interval, otherwise returns the closest bound. |
| `static double` | `limitMin(double min, double x)` | Returns x if it is greater or equal to min, otherwise returns min. |
| `static int` | `limitMin(int min, int x)` | Returns x if it is greater or equal to min, otherwise returns min. |
| `static double` | `limitMax(double x, double max)` | Returns x if it is less or equal to max, otherwise returns max. |
| `static int` | `limitMax(int x, int max)` | Returns x if it is less or equal to max, otherwise returns max. |
| `static double` | `sqr(double v)` | Returns the square of the given value (v²). |
| `static double` | `roundToDecimal(double v, int nDecimalDigits)` | Rounds the value to the given precision. |
| `static int` | `roundToInt(double v)` | Returns int closest to the given value. |
| `static double` | `quantum(double value, double quantizer)` | Returns the number smaller (by absolute value) than or equal to value that is an integer multiple of quantizer. |
| `static double` | `atan2fast(double y, double x)` | Returns the angle theta from the conversion of rectangular coordinates (x, y) to polar coordinates (r, theta). |
| `static double` | `gammaLog(double x)` | Returns the natural logarithm of the gamma function of x. |
| `static double` | `zidz(double a, double b)` | Tries to divide the first argument by the second. |
| `static double` | `xidz(double a, double b, double x)` | Tries to divide the first argument by the second. |
| `static boolean` | `isFinite(double v)` | Returns true if the given value is finite (not +/-infinity or NaN). |

### Geometry Functions
| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `static final double` | `getDistance(double x1, double y1, double x2, double y2)` | Returns the distance between two given points (x1, y1) and (x2, y2). |
| `static final double` | `getDistance(double x1, double y1, double z1, double x2, double y2, double z2)` | Returns the distance between two given points (x1, y1, z1) and (x2, y2, z2). |
| `static final double` | `getDistanceSq(double x1, double y1, double x2, double y2)` | Returns the square of the distance between two given points (x1, y1) and (x2, y2). |
| `static final double` | `getDistanceSq(double x1, double y1, double z1, double x2, double y2, double z2)` | Returns the square of the distance between two given points (x1, y1, z1) and (x2, y2, z2). |
| `static final double` | `getLength(double dx, double dy)` | Returns the length of the vector (dx, dy). |
| `static final double` | `getLength(double dx, double dy, double dz)` | Returns the length of the vector (dx, dy, dz). |
| `static final double` | `getLengthSq(double dx, double dy)` | Returns the square of length of the vector (dx, dy). |
| `static final double` | `getLengthSq(double dx, double dy, double dz)` | Returns the square of length of the vector (dx, dy, dz). |
| `static final double` | `getDistanceFromPointToLine(double x1, double y1, double x2, double y2, double px, double py)` | Returns the distance from a point to a line. |
| `static final double` | `getDistanceFromPointToLineSq(double x1, double y1, double x2, double y2, double px, double py)` | Returns the square of the distance from a point to a line. |
| `static final double` | `getDistanceFromPointToSegment(double x1, double y1, double x2, double y2, double px, double py)` | Returns the distance from a point to a line segment. |
| `static final double` | `getDistanceFromPointToSegment(double x1, double y1, double z1, double x2, double y2, double z2, double px, double py, double pz)` | Returns the distance from a point to a line segment. |
| `static final double` | `getDistanceFromPointToSegmentSq(double x1, double y1, double x2, double y2, double px, double py)` | Returns the square of the distance from a point to a line segment. |
| `static final double` | `getDistanceFromPointToSegmentSq(double x1, double y1, double z1, double x2, double y2, double z2, double px, double py, double pz)` | Returns the square of the distance from a point to a line segment. |
| `static final Point` | `getNearestPointOnSegment(Point out, double x1, double y1, double x2, double y2, double px, double py)` | Finds a point on a segment that is closest to a given point. |
| `static final Point` | `getNearestPointOnSegment(Point out, double x1, double y1, double z1, double x2, double y2, double z2, double px, double py, double pz)` | Finds a point on a segment that is closest to a given point. |
| `static final boolean` | `isLineIntersectingLine(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4)` | Tests if the line segment from (x1,y1) to (x2,y2) intersects the line segment from (x3,y3) to (x4,y4). |
| `static final boolean` | `isLineIntersectingRectangle(double x1, double y1, double x2, double y2, double rx, double ry, double rw, double rh)` | Check if the line intersects the given rectangle. |
| `static final boolean` | `isPointInsideRay(double x1, double y1, double x2, double y2, double px, double py)` | Tests if the specified point is inside the given ray. |
| `static final boolean` | `isPointInsideRectangle(double rx, double ry, double rw, double rh, double px, double py)` | Tests if the specified point is inside the given rectangle. |
| `static final boolean` | `isPointInsideSegment(double x1, double y1, double x2, double y2, double px, double py)` | Tests if the specified point is inside the given segment. |
| `static final boolean` | `isPointOnTheSameLine(double x1, double y1, double x2, double y2, double x3, double y3)` | Tests if the three point lie on the same line. |
| `static final boolean` | `isRayIntersectingSegment(double rx1, double ry1, double rx2, double ry2, double sx1, double sy1, double sx2, double sy2)` | Tests if the ray from (rx1,ry1)
