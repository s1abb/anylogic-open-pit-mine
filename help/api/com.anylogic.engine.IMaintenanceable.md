Package com.anylogic.engine
Class Presentable
java.lang.Object
com.anylogic.engine.Presentable
All Implemented Interfaces:
Serializable
Direct Known Subclasses:
Utilities
public abstract class Presentable
extends Object
implements Serializable
A base for any object that can be displayed by presentation panel. Is capable of drawing model and presentation parts of the object in a Graphics2D context of a Panel.
Author:
AnyLogic North America, LLC https://anylogic.com
See Also:
Serialized Form
Field Summary
Modifier and Type	Field	Description
static final TextAlignment	ALIGNMENT_CENTER	
Text alignment type constant
static final TextAlignment	ALIGNMENT_LEFT	
Text alignment type constant
static final TextAlignment	ALIGNMENT_RIGHT	
Text alignment type constant
static final LineArrowStyle	ARROW_FILLED	 
static final LineArrowStyle	ARROW_NONE	 
static final LineArrowStyle	ARROW_THIN	 
static final int	CAD_ANTIALIASING	
Attribute of CAD indicating that CAD should be drawn using antialiasing.
By default antialiasing is turned off for CADs.
static final int	CAD_INVERTED	
Attribute of CAD indicating that CAD should be drawn in inverted colors.
Doesn't affect appearance of layers with custom colors (where customLayerColors[i] != null)
static final LineStyle	LINE_STYLE_DASHED	 
static final LineStyle	LINE_STYLE_DOTTED	 
static final LineStyle	LINE_STYLE_SOLID	 
static final ShapeDrawMode	SHAPE_DRAW_2D	 
static final ShapeDrawMode	SHAPE_DRAW_2D3D	 
static final ShapeDrawMode	SHAPE_DRAW_3D	 
Constructor Summary
Constructor	Description
Presentable()	 
Method Summary
Modifier and Type	Method	Description
static Map<String,IElementDescriptor>	createElementDescriptors(Class<?> presentableClass)	
This method is internal and shouldn't be called by user.
it may be removed/renamed in future. It is public due to technical reasons.
void	executeShapeControlAction(int id, int index)	
Deprecated.
void	executeShapeControlAction(int id, int index, boolean value)	
Deprecated.
void	executeShapeControlAction(int id, int index, double value)	
Deprecated.
void	executeShapeControlAction(int id, int index, int value)	
Deprecated.
void	executeShapeControlAction(int id, int index, String value)	
Deprecated.
void	executeShapeControlAction(int id, int index, String value, String[] values)	
Deprecated.
Map<String,IElementDescriptor>	getElementDesciptors()	
This method is internal and shouldn't be called by user.
it may be removed/renamed in future.
<T> T	getElementProperty(String elementName, String propertyName)	
This method is internal and shouldn't be called by user.
it may be removed/renamed in future.
abstract Engine	getEngine()	
Returns the simulation engine.
Experiment<?>	getExperiment()	
Returns the experiment controlling the model execution.
abstract IExperimentHost	getExperimentHost()	
Returns the experiment host object of the model, or some dummy object with no functionality if there is none.
ShapeModelElementsGroup	getModelElementsShape()	 
IExperimentHost	getPresentation()	
Deprecated.
this method will be removed in the next releases.
ShapeTopLevelPresentationGroup	getPresentationShape()	 
boolean	getShapeControlDefaultValueBoolean(int id, int index)	
Deprecated.
double	getShapeControlDefaultValueDouble(int id, int index)	
Deprecated.
int	getShapeControlDefaultValueInt(int id, int index)	
Deprecated.
String	getShapeControlDefaultValueString(int id, int index)	
Deprecated.
int	getViewAreas(Map<String,ViewArea> output)	
Adds all ViewAreas of this presentable to the given map output, if it is not null.
Default implementation does nothing and returns 0.
final boolean	iconContains(double px, double py)	
Tests if any of the icon shapes contain the point with the coordinates (px,py).
void	onSelectionChanged_xjal(int id, int index, int[] selectedIndices, boolean programmatically)	
Deprecated.
boolean	onShapeClick(int id, int index, double clickx, double clicky)	
Deprecated.
void	onShapeGroupDraw(int id, int index)	
Deprecated.
final boolean	presentationContains(double px, double py)	
Tests if any of the presentation shapes contain the point with the coordinates (px,py).
void	readCustomData(ObjectInputStream in)	
This method may be overridden to perform custom data reading when loading model snapshot
final void	updateShapeDynamicProperties(boolean publicOnly)	
Updates dynamic properties of persistent presentation elements of the of the presentable object (shapes, controls, charts, and presentations of the embedded objects).
void	writeCustomData(ObjectOutputStream out)	
This method may be overridden to perform custom data writing when saving model snapshot
Methods inherited from class java.lang.Object
equals, getClass, hashCode, notify, notifyAll, toString, wait, wait, wait
Field Details
SHAPE_DRAW_2D3D
public static final ShapeDrawMode SHAPE_DRAW_2D3D
SHAPE_DRAW_2D
public static final ShapeDrawMode SHAPE_DRAW_2D
SHAPE_DRAW_3D
public static final ShapeDrawMode SHAPE_DRAW_3D
LINE_STYLE_SOLID
public static final LineStyle LINE_STYLE_SOLID
LINE_STYLE_DOTTED
public static final LineStyle LINE_STYLE_DOTTED
LINE_STYLE_DASHED
public static final LineStyle LINE_STYLE_DASHED
ARROW_NONE
public static final LineArrowStyle ARROW_NONE
ARROW_THIN
public static final LineArrowStyle ARROW_THIN
ARROW_FILLED
public static final LineArrowStyle ARROW_FILLED
ALIGNMENT_LEFT
public static final TextAlignment ALIGNMENT_LEFT
Text alignment type constant
ALIGNMENT_CENTER
public static final TextAlignment ALIGNMENT_CENTER
Text alignment type constant
ALIGNMENT_RIGHT
public static final TextAlignment ALIGNMENT_RIGHT
Text alignment type constant
CAD_INVERTED
public static final int CAD_INVERTED
Attribute of CAD indicating that CAD should be drawn in inverted colors.
Doesn't affect appearance of layers with custom colors (where customLayerColors[i] != null)
See Also:
#getShapeCADDrawingAttributes(int, int)
ShapeCAD(Presentable, boolean, double, double, double, double, String, String, int, Color, String[], Color[], int)
Constant Field Values
CAD_ANTIALIASING
public static final int CAD_ANTIALIASING
Attribute of CAD indicating that CAD should be drawn using antialiasing.
By default antialiasing is turned off for CADs.
See Also:
#getShapeCADDrawingAttributes(int, int)
ShapeCAD(Presentable, boolean, double, double, double, double, String, String, int, Color, String[], Color[], int)
Constant Field Values
Constructor Details
Presentable
public Presentable()
Method Details
getEngine
public abstract Engine getEngine()
Returns the simulation engine.
Returns:
the simulation engine
getExperimentHost
public abstract IExperimentHost getExperimentHost()
Returns the experiment host object of the model, or some dummy object with no functionality if there is none.
Returns:
the experiment host object of the model
getPresentation
@Deprecated
public IExperimentHost getPresentation()
Deprecated.
this method will be removed in the next releases. Please use getExperimentHost() instead.
getExperiment
public Experiment<?> getExperiment()
Returns the experiment controlling the model execution.
Returns:
the experiment controlling the model execution
getPresentationShape
@AnyLogicInternalCodegenAPI
public ShapeTopLevelPresentationGroup getPresentationShape()
getModelElementsShape
@AnyLogicInternalCodegenAPI
public ShapeModelElementsGroup getModelElementsShape()
getShapeControlDefaultValueBoolean
@Deprecated
@AnyLogicInternalCodegenAPI
public boolean getShapeControlDefaultValueBoolean(int id,
 int index)
Deprecated.
Should be overridden to return the boolean value used to initialized a non-persistent control when it is first created or becomes vsisible,
Parameters:
id - the control id
index - index of the component (for replicated components)
Returns:
the component default value, false by default
getShapeControlDefaultValueInt
@Deprecated
@AnyLogicInternalCodegenAPI
public int getShapeControlDefaultValueInt(int id,
 int index)
Deprecated.
Should be overridden to return the integer value used to initialized a non-persistent control when it is first created or becomes vsisible.
Parameters:
id - the control id
index - index of the component (for replicated components)
Returns:
the component default value, 0 by default
getShapeControlDefaultValueDouble
@Deprecated
@AnyLogicInternalCodegenAPI
public double getShapeControlDefaultValueDouble(int id,
 int index)
Deprecated.
Should be overridden to return the double value used to initialized a non-persistent control when it is first created or becomes vsisible.
Parameters:
id - the control id
index - index of the component (for replicated components)
Returns:
the component default value, 0 by default
getShapeControlDefaultValueString
@Deprecated
@AnyLogicInternalCodegenAPI
public String getShapeControlDefaultValueString(int id,
 int index)
Deprecated.
Should be overridden to return the String value used to initialized a non-persistent control when it is first created or becomes vsisible.
Parameters:
id - the control id
index - index of the component (for replicated components)
Returns:
the component default value, null by default
executeShapeControlAction
@Deprecated
@AnyLogicInternalCodegenAPI
public void executeShapeControlAction(int id,
 int index)
Deprecated.
Should be overridden to execute the action associated with a non-persistent control that has no value information (like button). Does nothing by default.
Parameters:
id - the control id
index - index of the component (for replicated components)
executeShapeControlAction
@Deprecated
@AnyLogicInternalCodegenAPI
public void executeShapeControlAction(int id,
 int index,
 boolean value)
Deprecated.
Should be overridden to execute the action associated with a non-persistent control that has a boolean value (like checkbox). Does nothing by default.
Parameters:
id - the control id
index - index of the component (for replicated components)
value - the value of the component
executeShapeControlAction
@Deprecated
@AnyLogicInternalCodegenAPI
public void executeShapeControlAction(int id,
 int index,
 int value)
Deprecated.
Should be overridden to execute the action associated with a non-persistent control that has an integer value (like radio button group or list). Does nothing by default.
Parameters:
id - the control id
index - index of the component (for replicated components)
value - the value of the component
executeShapeControlAction
@Deprecated
@AnyLogicInternalCodegenAPI
public void executeShapeControlAction(int id,
 int index,
 double value)
Deprecated.
Should be overridden to execute the action associated with a non-persistent control that has a double value (like slider). Does nothing by default.
Parameters:
id - the control id
index - index of the component (for replicated components)
value - the value of the component
executeShapeControlAction
@Deprecated
@AnyLogicInternalCodegenAPI
public void executeShapeControlAction(int id,
 int index,
 String value)
Deprecated.
Should be overridden to execute the action associated with a non-persistent control that has a String value (like text field). Does nothing by default.
Parameters:
id - the control id
index - index of the component (for replicated components)
value - the value of the component
executeShapeControlAction
@Deprecated
@AnyLogicInternalCodegenAPI
public void executeShapeControlAction(int id,
 int index,
 String value,
 String[] values)
Deprecated.
Should be overridden to execute the action associated with a non-persistent control that has a one or more String values (like list box). Does nothing by default.
Parameters:
id - the control id
index - index of the component (for replicated components)
value - the value of the component (the first value in component has several values)
values - the values of the component
onSelectionChanged_xjal
@Deprecated
@AnyLogicInternalCodegenAPI
public void onSelectionChanged_xjal(int id,
 int index,
 int[] selectedIndices,
 boolean programmatically)
Deprecated.
Should be overridden to execute the action associated with a non-persistent chart item-selection-changed event. Does nothing by default.
Parameters:
id - the chart id
index - index of the component (for replicated components)
selectedIndices - the array of currently selected indices (never null; may be empty)
programmatically - this parameter is always false for non-persistent charts
(designed for uniformity with persistent charts code generation, where it defines either selection was changed programmatically (via Chart.selectItem(int, boolean) and Chart.setSelectedItemIndices(int[])) or by user mouse-click)
getViewAreas
@AnyLogicInternalCodegenAPI
public int getViewAreas(Map<String,ViewArea> output)
Adds all ViewAreas of this presentable to the given map output, if it is not null.
Default implementation does nothing and returns 0.
Parameters:
output - the map for view areas (field name -> view area), not cleared by this method, may be null: in this case the method only returns the number of view areas.
Returns:
the number of view areas in this presentable
updateShapeDynamicProperties
@AnyLogicInternalCodegenAPI
public final void updateShapeDynamicProperties(boolean publicOnly)
Updates dynamic properties of persistent presentation elements of the of the presentable object (shapes, controls, charts, and presentations of the embedded objects).
Parameters:
panel - the panel where the drawing is done
g - the graphics context
publicOnly - if true, this method draws only shapes marked as public
onShapeClick
@AnyLogicInternalCodegenAPI
@Deprecated
public boolean onShapeClick(int id,
 int index,
 double clickx,
 double clicky)
Deprecated.
Should be overridden to define reaction on mouse click on a non-persistent shape. The click coordinates are definitely within the shape bounds if this method is called. In case of AbstractShapeGISMap, coordinates are geographical. By default, does nothing and returns false.
Parameters:
id - the shape id
index - index of the shape (for replicated shapes)
clickx - the x coordinate of the click relative to the shape
(or longitude, for AbstractShapeGISMap: for more information see AbstractShapeGISMap.onClick(double, double))
clicky - the y coordinate of the click relative to the shape
(or latitude, for AbstractShapeGISMap: for more information see AbstractShapeGISMap.onClick(double, double))
Returns:
true if further click processing is not needed, false otherwise
onShapeGroupDraw
@AnyLogicInternalCodegenAPI
@Deprecated
public void onShapeGroupDraw(int id,
 int index)
Deprecated.
Should be overridden to do custom drawing before the group contents has been drawn.
Parameters:
id - the shape group id
index - index of the group (for replicated groups)
presentationContains
public final boolean presentationContains(double px,
 double py)
Tests if any of the presentation shapes contain the point with the coordinates (px,py).
Parameters:
px - the x coordinate of the click
py - the y coordinate of the click
Returns:
true if if any of the presentation shapes contain the point, false otherwise
iconContains
public final boolean iconContains(double px,
 double py)
Tests if any of the icon shapes contain the point with the coordinates (px,py).
Parameters:
px - the x coordinate of the click
py - the y coordinate of the click
Returns:
true if if any of the icon shapes contain the point, false otherwise
getElementDesciptors
@AnyLogicInternalAPI
public Map<String,IElementDescriptor> getElementDesciptors()
This method is internal and shouldn't be called by user.
it may be removed/renamed in future.
getElementProperty
@AnyLogicInternalCodegenAPI
public <T> T getElementProperty(String elementName,
 String propertyName)
This method is internal and shouldn't be called by user.
it may be removed/renamed in future.
createElementDescriptors
@AnyLogicInternalCodegenAPI
public static Map<String,IElementDescriptor> createElementDescriptors(Class<?> presentableClass)
This method is internal and shouldn't be called by user.
it may be removed/renamed in future. It is public due to technical reasons.
writeCustomData
@AnyLogicInternalCodegenAPI
public void writeCustomData(ObjectOutputStream out)
                     throws IOException
This method may be overridden to perform custom data writing when saving model snapshot
Parameters:
out -
Throws:
IOException
readCustomData
@AnyLogicInternalCodegenAPI
public void readCustomData(ObjectInputStream in)
                    throws IOException,
ClassNotFoundException
This method may be overridden to perform custom data reading when loading model snapshot
Parameters:
in -
Throws:
IOException
ClassNotFoundException