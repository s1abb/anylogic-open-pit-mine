import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Supplier;
import java.util.Iterator;
import java.util.LinkedHashMap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.math.NumberUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataDriver implements Serializable {

    private Logger logger = LogManager.getLogger("DataDriver");
	private boolean success = true;
	private LinkedHashMap<String, IDataDriver> idMap = new LinkedHashMap<String, IDataDriver>();
	private LinkedHashMap<String, Object> objectMap = new LinkedHashMap<String, Object>();
	private ArrayDeque<IDataDriver> iDataDriverObjects = new ArrayDeque<IDataDriver>();
	
	/**
	 * Default Constructor
	 */
	public DataDriver() {}
	
	/**
	 * Sets the parameters of all the {@link IDataDriver} objects from the given 
	 * JSON input file. Also populates agent populations, arrays, and maps. 
	 * @param topLevelAgent the root agent of the model
	 * @param inputFilePath the path to the JSON input file
	 * @throws InputException throws an InputException if any parameter can't be set
	 */
	public void initialiseFromJSON(IDataDriver topLevelAgent, String inputFilePath) throws InputException {

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode root = null;
		try {
			log("*** Reading inputs ***");
			log(inputFilePath);
		    root = objectMapper.readTree(new File(inputFilePath));
		} catch (Exception e) {
		    logError("Couldn't read input file.");
		    throw new InputException("Error in model initialisation. See logs for more detail.");
		}
		
	    // Traverse to create objects and populate idMap
	    log("*** Populating idMap ***");
	    addToObjectMap("root", topLevelAgent);
	    traverse(topLevelAgent, null, root, "root", true);
		if(!success) {
			throw new InputException("Error in model initialisation. See logs for more detail.");
		}
		
		
		// Traverse again to set parameters
		log("*** Setting parameters ***");
		traverse(topLevelAgent, null, root, "root", false);
		if(!success) {
			throw new InputException("Error in model initialisation. See logs for more detail.");
		}
		
	}
	
	/**
	 * Calls onParametersSet for all IDataDriver objects found during initialisation
	 */
	public void callOnParametersSet() {
		
		// Parameters are set, notify IDataDriver objects
		log("*** Parameters set, notifying IDataDriver objects ***");
		Iterator<IDataDriver> itr = iDataDriverObjects.descendingIterator();
		while(itr.hasNext()) {
			itr.next().onParametersSet();
		}
		
	}
		
	/**
	 * Calls onRunStarted for all IDataDriver objects found during initialisation
	 */
	public void callOnRunStarted() {
		
		// Run has started, notify IDataDriver objects
		log("*** Model Initialisation Successful, notifying IDataDriver objects that run has started ***");
		Iterator<IDataDriver> itr = iDataDriverObjects.descendingIterator();
		while(itr.hasNext()) {
			itr.next().onRunStarted();
		}
		
	}
	
	/**
	 * Populate a collection of {@link IDataDriver} objects from a CSV. 
	 * An object is created for each row. 
	 * Column headers must correspond to parameters in the object. 
	 * @param addMethod a function that returns a IDataDriver object and adds it to a collection
	 * @param csvFilePath path to CSV file
	 * @param logDetail whether to log detailed information for each parameter set
	 * @throws InputException if there's an error during initialization
	 */
	public void initialiseFromCSV(Supplier<IDataDriver> addMethod, String csvFilePath, boolean logDetail) throws InputException {
		
        log("Reading CSV: " + csvFilePath);
		try {
			BufferedReader csvData = new BufferedReader(new FileReader(csvFilePath));
			CSVFormat csvFormat = CSVFormat.Builder.create(CSVFormat.DEFAULT).setHeader().setSkipHeaderRecord(true).build();
			CSVParser parser = CSVParser.parse(csvData,  csvFormat);

            // Read header row and determine parameter types
            LinkedHashMap<String, Class<?>> headerMap = new LinkedHashMap<String, Class<?>>();
            Iterator<CSVRecord> csvRecordIterator = parser.iterator();
			if(!csvRecordIterator.hasNext()) {
				logger.warn("No records in " + csvFilePath);
				parser.close();
				csvData.close();
				return;
			}
			IDataDriver csvRecordObj = addMethod.get();
            for(String header: parser.getHeaderNames()) {
                Class<?> ownerClass = csvRecordObj.getClass();
                Class<?> fieldType = null;
                do {
                    try {
                        Field field = ownerClass.getDeclaredField(header);
                        fieldType = field.getType();
                        break;
                    } catch (NoSuchFieldException e) {
                        ownerClass = ownerClass.getSuperclass();
                    }
                } while(ownerClass != null);
                if(fieldType == null) {
                    logError(csvFilePath + ": No such parameter " + header);
                    return;
                } else {
                    headerMap.put(header, fieldType);
                }
            }

            // Read rows and create a new object for each row
            while (csvRecordIterator.hasNext()) {   
				CSVRecord csvRecord = csvRecordIterator.next();
				if(!csvRecord.isConsistent()) {
					logError(csvRecord.getRecordNumber() + ": Record is inconsistent");
					continue;
				}
                if(csvRecordObj == null) csvRecordObj = addMethod.get();
                iDataDriverObjects.add(csvRecordObj);
                for(String header: parser.getHeaderNames()) {
                    Object fieldValue;
					String strValue = csvRecord.get(header);
                    Class<?> fieldType = headerMap.get(header);
                    try {
                        fieldValue = getFieldValue(strValue, fieldType);
                        boolean success = csvRecordObj.setParameter(header, fieldValue, true);
                        if(success) {
                            if(logDetail) {
                                log(csvRecord.getRecordNumber() + ": set " + header + " = " + fieldValue);
                            }
                        } else {
                            logError(csvRecord.getRecordNumber() + ": Failed to set parameter " + header);
                        }
                    } catch (InputException e) {
                        logError(csvRecord.getRecordNumber() + ": " + e.getMessage());
                    }
                }
				csvRecordObj = null;
            }
            parser.close();
			csvData.close();
		} catch (Exception e) {
		    logError("Couldn't read CSV " + csvFilePath);
		    throw new InputException("Error in model initialisation. See logs for more detail.");
		}
		
	}
	
	/**
	 * Returns whether the model initialization was successful.
	 * 
	 * @return true if initialization was successful, false otherwise
	 */
	public boolean getSuccess() {
		return success; 
	}
	
	
	private void traverse(IDataDriver owner, String fieldName, JsonNode root, String treePath, boolean firstTraverse) {
		
	    if(root.isObject()){
	    	// Objects
	    	
	    	if(firstTraverse) {
	    		populateIdMap(owner, root);
	    	}
	    	
    		// Continue to traverse JSON tree
	        Iterator<String> fieldNames = root.fieldNames();
	        while(fieldNames.hasNext()) {
	            String subfieldName = fieldNames.next();
	            JsonNode subfieldValue = root.get(subfieldName);
	            // If subfield is not an object, then skip to setting parameter
	            if(!subfieldValue.isObject()) {
	            	traverse(owner, subfieldName, subfieldValue, treePath, firstTraverse);
	            } else {
	            	String subTreePath = treePath + "." + subfieldName;
					Object embeddedObject;
	            	if(firstTraverse) {
			            embeddedObject = getEmbeddedObject(owner, subfieldName);
			            if(embeddedObject == null) {
			            	logError("Object " + subfieldName + " can't be found or hasn't implemented the IDataDriver interface.");
			            } else {
			            	try {
			            		addToObjectMap(subTreePath, embeddedObject);
			            	} catch (InputException e) {
			            		logError("Duplicated object at " + subTreePath);
			            		return;
			            	}
			            }
	            	}  else {
            			embeddedObject = objectMap.get(subTreePath);
						if(embeddedObject == null) {
    						logError("No object found at " + subTreePath);
						}
    				}
					// Embedded object found, continue traversing json
    				if (embeddedObject instanceof IDataDriver) {
    	            	IDataDriver child = (IDataDriver) embeddedObject;
    					traverse(child, subfieldName, subfieldValue, subTreePath, firstTraverse);
    				} else if (embeddedObject instanceof Map) {
    					if(!firstTraverse) {
    						setMap(owner, subfieldName, subfieldValue, subTreePath);
						}
    				} else {
    					logError("Unsupported object type at " + subTreePath);
    				}
		            
	            }
	    	}
	    } else if(root.isArray()){
	    	// Arrays
	        ArrayNode arrayNode = (ArrayNode) root;
	        IDataDriver child = owner;
	        int i=-1;
	        for(JsonNode arrayElement: arrayNode) {
	        	i++;
	        	String subTreePath = treePath + "." + fieldName + "[" + i + "]";
        		if(arrayElement.isValueNode()) {
        			if(firstTraverse) return;
        			// If the array has only primitives and object reference, then 
        			// add method must have one argument
        			try {
    					Method addMethod = getAddMethod(owner, fieldName, 1);
    					Class<?> arrayElementType = addMethod.getParameterTypes()[0];
    					Object value = getFieldValue(arrayElement, arrayElementType);
    					addMethod.invoke(owner, value);
	        			log(subTreePath + ": add " + arrayElement);
        			} catch (Exception e) {
        				logError(subTreePath + ": " + e.getMessage());
        			}
        		} else {
        			if(firstTraverse) {
        				try {
		        			// If the array has objects, then
		        			// add method must have zero arguments
		        			Method addMethod = getAddMethod(owner, fieldName, 0);
							Object object = addMethod.invoke(owner);
							log(subTreePath + ": add new object");
							addToObjectMap(subTreePath, object);
        				} catch (Exception e) {
	        				logError(subTreePath + ": " + e.getMessage());
	        			}
        			}
    				Object object = objectMap.get(subTreePath);
    				if(object == null) {
    					logError("No object found at " + subTreePath);
    				} else if(object instanceof IDataDriver) {
						child = (IDataDriver) object;
			            traverse(child, fieldName, arrayElement, subTreePath, firstTraverse);
					} else {
						logError("Object must be IDataDriver at " + subTreePath);
					}
		        }
	        }
	    } else if(root.isValueNode()) {
	    	if(firstTraverse) return;
			setValueNode(owner, fieldName, root, treePath);
	    } else {
			logError("Unsupported node type.");
		}
	}
	
	private void addToObjectMap(String treePath, Object object) throws InputException {
    	if(objectMap.containsKey(treePath)) {
    		throw new InputException("There is already something at this path " + treePath);
    	}
    	objectMap.put(treePath, object);
    	if(object instanceof IDataDriver) {
        	if(iDataDriverObjects.contains(object)) {
        		throw new InputException("There is already something at this path " + treePath);
        	}
        	iDataDriverObjects.add((IDataDriver)object);
    	}
	}

	private Object getFieldValue(JsonNode node, Class<?> fieldType) throws InputException {
		if(!node.isValueNode()) {
			throw new InputException("Must be called on value node");
		}
		// Enum
		if(fieldType.isEnum()) {
			for(Object enumConstant: fieldType.getEnumConstants()) {
				if(enumConstant.toString().equalsIgnoreCase(node.asText())) {
					return enumConstant;
				}
			}
			throw new InputException("Enum input doesn't match any enum constant for " + fieldType.getName());
		}
		if(node.isBoolean()) { // Boolean
	        return node.asBoolean();
	    } else if(node.isNumber()) { // Number
	    	return node.numberValue();
	    } else if(node.isTextual()) { 
	    	String nodeValue = node.asText();
	    	if(fieldType.isAssignableFrom(String.class)) {
	    		// String
	    		return nodeValue;
	    	} else {
	    		// Object reference
	    		if(idMap.containsKey(nodeValue)) {
	    			return idMap.get(nodeValue);
	    		} else {
	    			throw new InputException("Can't find referenced object " + nodeValue);
	    		}
	    	}
	    }
	    throw new InputException("Field data type is not supported");
	}
	
	private Object getFieldValue(String strValue, Class<?> fieldType) throws InputException {
		// Enum
		if(fieldType.isEnum()) {
			for(Object enumConstant: fieldType.getEnumConstants()) {
				if(enumConstant.toString().equalsIgnoreCase(strValue)) {
					return enumConstant;
				}
			}
			throw new InputException("Enum input doesn't match any enum constant for " + fieldType.getName());
		}
	    if(fieldType.isAssignableFrom(String.class)) { 
	    	// String
	    	return strValue;
	    } else if(ClassUtils.isPrimitiveOrWrapper(fieldType)) {
			if(ClassUtils.isAssignable(Boolean.class, fieldType)) { 
				// Boolean
			    return BooleanUtils.toBooleanObject(strValue);
			} else if(NumberUtils.isCreatable(strValue)) { 
				// Number
				return NumberUtils.createNumber(strValue);
			}
	    } else {
			// Object reference
			if(idMap.containsKey(strValue)) {
				return idMap.get(strValue);
			} else {
				throw new InputException("Can't find referenced object " + strValue);
			}
	    }
	    throw new InputException("Field data type is not supported");
	}
	
	private Object getKeyValue(String fieldName, Class<?> fieldType) throws InputException {
		// Enum
		if(fieldType.isEnum()) {
			for(Object enumConstant: fieldType.getEnumConstants()) {
				if(enumConstant.toString().equalsIgnoreCase(fieldName)) {
					return enumConstant;
				}
			}
			throw new InputException("Enum input doesn't match any enum constant for " + fieldType.getName());
		}
    	if(fieldType.isAssignableFrom(String.class)) {
    		// String
    		return fieldName;
    	} else {
    		// Object reference
    		if(idMap.containsKey(fieldName)) {
    			return idMap.get(fieldName);
    		} else {
    			throw new InputException("Can't find referenced object " + fieldName);
    		}
    	}
	}

	private Method getAddMethod(Object owner, String fieldName, int parameterCount) throws InputException {
		Class<?> ownerClass = owner.getClass();
		do {
			for (Method method : ownerClass.getDeclaredMethods()) {
				if(method.getName().equals("add_" + fieldName) && method.getParameterCount() == parameterCount) {
					return method;
				}
			}
			ownerClass = ownerClass.getSuperclass();
		} while(ownerClass != null);
		throw new InputException("No add method found for " + fieldName + " with " + parameterCount + " parameters");
	}

	private Object getEmbeddedObject(IDataDriver owner, String fieldName) {
	    // First look in embedded objects for matching field
		if(owner.getEmbeddedObjects() != null) {
	        for(Object embeddedObject: owner.getEmbeddedObjects()) {
	        	if(embeddedObject instanceof IDataDriver) {
	        		IDataDriver iDataDriverObject = (IDataDriver)embeddedObject;
	             	if(iDataDriverObject.getName() != null && iDataDriverObject.getName().equals(fieldName)) {
	            		return iDataDriverObject;
	            	}
	            }
	        }
	    }
		// Second look in parameters for matching field
		try {
			return owner.getParameter(fieldName);
		} catch (RuntimeException e) {
			logError(e.getMessage());
		}
	    return null;
	} 
	
	private void setMap(IDataDriver owner, String fieldName, JsonNode node, String treePath) {
		 int i=-1;
		 Iterator<String> fieldNames = node.fieldNames();
	     while(fieldNames.hasNext()) {
        	i++;
        	String subFieldName = fieldNames.next();
        	String subTreePath = treePath + "." + fieldName + "[" + i + "]";
        	JsonNode subNode =  node.get(subFieldName);
 			try {
				Method addMethod = getAddMethod(owner, fieldName, 2);
				Class<?> keyType = addMethod.getParameterTypes()[0];
				Class<?> valueType = addMethod.getParameterTypes()[1];
				Object key = getKeyValue(subFieldName, keyType);
				Object value = getFieldValue(subNode, valueType);
				addMethod.invoke(owner, key, value);
        		log(subTreePath + ": put " + key + ", " + value);
 			} catch (Exception e) {
 				logError(subTreePath + ": " + e.getMessage());
 			}
	     }
	}


	private void log(String message) {
		logger.info(message);
	}
	
	private void logError(String message) {
		logger.error(message);
		success = false;
	}

	private void populateIdMap(IDataDriver owner, JsonNode root) {
	    		
		// Check for existing id
		String existingId = null;
		if(Arrays.asList(owner.getParameterNames()).contains("id")) {
			existingId = owner.getParameter("id");
			if(existingId != null) {
				try {
					addToIdMap(existingId, owner);
				} catch (InputException e) {
					logError(e.getMessage());
					return;
				}
			}
		}
		// Check for id in JSON fields
		Iterator<String> fieldNames = root.fieldNames();
		while(fieldNames.hasNext()) {
			String subfieldName = fieldNames.next();
			JsonNode subfieldValue = root.get(subfieldName);
			if(subfieldName.equals("id")) {
				String id = subfieldValue.asText();
				if(existingId != null) {
					if(!existingId.equals(id)) {
						logError("Existing id " + existingId + " doesn't match id field " + id);
					}
				} else {
					try {
						addToIdMap(id, owner);
					} catch (InputException e) {
						logError(e.getMessage());
					}
				}
			}
		}
	}

	private void addToIdMap(String id, IDataDriver object) throws InputException {
		if(idMap.containsKey(id)) {
			throw new InputException("ids must be unique. There is already an id " + id);
		}
		log("idMap: add " + id);
		idMap.put(id, object);
	}

	private void setValueNode(IDataDriver owner, String fieldName, JsonNode root, String treePath) {
		// Primitives and Object references
		Class<?> ownerClass = owner.getClass();
		Class<?> fieldType = null;
		do {
			try {
				Field field = ownerClass.getDeclaredField(fieldName);
				fieldType = field.getType();
				break;
			} catch (NoSuchFieldException e) {
				ownerClass = ownerClass.getSuperclass();
			}
		} while(ownerClass != null);
		if(fieldType == null) {
			logError(treePath + ": No such parameter " + fieldName);
			return;
		}
		Object fieldValue;
		try {
			fieldValue = getFieldValue(root, fieldType);
			boolean success = owner.setParameter(fieldName, fieldValue, true);
			if(success) {
				log(treePath + ": set " + fieldName + " = " + root);
			} else {
				logError("Failed to set parameter " + fieldName);
			}
		} catch (InputException e) {
			logError(treePath + ": " + e.getMessage());
		}
	}

	/**
	 * This number is here for model snapshot storing purpose<br>
	 * It needs to be changed when this class gets changed
	 */ 
	private static final long serialVersionUID = 1L;
    
}