## Enum Class: AgentOrientation
public enum AgentOrientation extends Enum<AgentOrientation>
implements Serializable, Comparable<AgentOrientation>, Constable

## Nested Class Summary:
- Inherited from java.lang.Enum:
-   Enum.EnumDesc<E extends Enum<E>>

## Method Summary:

- reverse
public AgentOrientation reverse()
- Returns the opposite orientation of the current enum constant.

- valueOf
public static AgentOrientation valueOf(String name)
- Returns the enum constant of this class with the specified name.
- Parameters:
-   name - the name of the enum constant to be returned
- Returns:
-   the enum constant with the specified name
- Throws:
-   IllegalArgumentException - if no constant with the specified name exists
-   NullPointerException - if the argument is null

- values
public static AgentOrientation[] values()
- Returns an array containing the constants of this enum class, in the order they are declared.
- Returns:
-   an array of AgentOrientation constants

## Methods inherited from java.lang.Enum:
-   compareTo, describeConstable, equals, getDeclaringClass,
-   hashCode, name, ordinal, toString, valueOf

## Methods inherited from java.lang.Object:
-   getClass, notify, notifyAll, wait, wait, wait
