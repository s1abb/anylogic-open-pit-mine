import java.util.List;

/**
 * Required interface for objects that are setup via the DataDriver
 */
public interface IDataDriver {

    /**
	 * Used to find embedded agents or agent populations
	 * @return the field name of the agent or agent list
	 */
	default public String getName() {
		return null;
	}
	
	/**
	 * Returns array of all parameter names.
	 * @return array of all the parameters that can be set
	 */
	public String[] getParameterNames();
	
	/**
	 * Returns the value of parameter with the given name.
	 * This method should be overridden in subclasses.
	 * Throws error if there is no parameter with the given name.
	 * @param name the name of the parameter
	 * @return
	 */
	public <T> T getParameter(String name);
	
	/**
	 * Sets the value to parameter with the given name.
	 * This method should be overridden in subclasses.
	 * @param name the name of the parameter
	 * @param value the value to be set
	 * @param callOnChange true to call on change code
	 * @return true if successful, false if unsuccessful or parameter wasn't found
	 */
	public boolean setParameter(String name, Object value, boolean callOnChange);
	
	/**
	 * Creates and returns a list of embedded objects if there are any, null if there are none. 
	 * For an agent population its list is included in the result, not each object, 
	 * therefore the resulting list contains either instances of Agent or of AgentList of extending Agent types.
	 * This function must be implemented in a subclass if there is at least one embedded object.
	 * @return the list of all embedded objects, or null by default
	 */
	default public List<Object> getEmbeddedObjects() {
		return null;
	}
	
	/**
	 * Called after all parameters have been set. 
	 * Default implementation is to do nothing. 
	 */
	default public void onParametersSet() {}
	
	/**
	 * Called after all parameters have been set and onParametersSet() has been called. 
	 * Default implementation is to do nothing. 
	 */
	default public void onRunStarted() {}
	
}