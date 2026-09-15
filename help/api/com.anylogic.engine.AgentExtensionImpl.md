# Class AgentExtensionImpl

**java.lang.Object**  
**com.anylogic.engine.AgentExtensionImpl**

## All Implemented Interfaces:
- AgentExtension
- Serializable

## Direct Known Subclasses:
- ExtAgentContinuousDelegate
- ExtAgentWithSpatialMetricsDelegate

---

### @AnyLogicInternalAPI

**public abstract class AgentExtensionImpl**  
_extends Object_  
_implements AgentExtension, Serializable_

Base class for extensions of Agents.  
Please note that agent, during its lifetime, may change instances of some extensions (e.g. replace existing extension with its subclass), so you shouldn't store references to extensions anywhere. Please store references to agent instead.

**Author:**  
AnyLogic North America, LLC https://anylogic.com

**See Also:**  
Serialized Form

---

## Field Summary

Fields inherited from interface `com.anylogic.engine.AgentExtension`:
- P_AGENT_INTERACTIVE_DELEGATE
- P_AGENT_WITH_SPATIAL_METRICS_DELEGATE
- P_AGENT_WITH_SPECIFIC_SPACE
- P_AGENT_WITH_SPECIFIC_SPACE_DELEGATE
- P_ENTITY_DELEGATE
- P_ENV_WITH_SPECIFIC_SPACE
- P_ROOT
- P_SPACE
- P_USER_EXT

---

## Constructor Summary

| Constructor | Description |
|------------|-------------|
| AgentExtensionImpl(Agent owner) |  |

---

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| RuntimeException | error(String errorText) |  |
| RuntimeException | error(String errorTextFormat, Object... args) |  |
| Agent | getAgent() | Returns the agent this extension belongs to |
| static Set&lt;Class&lt;?&gt;&gt; | getSupportedInterfaces_xjal(Class&lt;? extends AgentExtension&gt; extClass) | This method is internal and shouldn't be called by user. It may be removed/renamed in future. |
| final AgentExtension | next_xjal() | This method is internal and shouldn't be called by user. It may be removed/renamed in future |
| void | onDestroy() | This method is called when the owner of this extension is destroyed. Should be overridden when custom destroy is required. Default implementation does nothing |
| void | onExtensionRemoved(AgentExtension ext) | This method is internal and shouldn't be called by user. It may be removed/renamed in future. Default implementation does nothing |
| int | priority() | This method is internal and shouldn't be called by user. It may be removed/renamed in future. This function is used for sorting extensions (in order for the overriding delegation to work) |
| final void | setNext_xjal(AgentExtension next) | This method is internal and shouldn't be called by user. It may be removed/renamed in future |
| boolean | supportsInterface_xjal(Class&lt;?&gt; itfs) | This method is internal and shouldn't be called by user. It may be removed/renamed in future. |

## Methods inherited from class java.lang.Object:
  - equals
  - getClass
  - hashCode
  - notify
  - notifyAll
  - toString
  - wait
  - wait
  - wait

## Constructor Details:
  AgentExtensionImpl
    public AgentExtensionImpl(Agent owner)

## Method Details:
  getAgent
    public Agent getAgent()
    Returns the agent this extension belongs to.
    Specified by: getAgent in interface AgentExtension
    Returns: the agent this extension belongs to

  supportsInterface_xjal
    @AnyLogicInternalAPI
    public boolean supportsInterface_xjal(Class<?> itfs)
    This method is internal and shouldn't be called by user.
    It may be removed/renamed in future.
    Specified by: supportsInterface_xjal in interface AgentExtension

  getSupportedInterfaces_xjal
    @AnyLogicInternalAPI
    public static Set<Class<?>> getSupportedInterfaces_xjal(Class<? extends AgentExtension> extClass)
    This method is internal and shouldn't be called by user.
    It may be removed/renamed in future.

  error
    public RuntimeException error(String errorText)
    See Also: Utilities.error(String)

  error
    public RuntimeException error(String errorTextFormat, Object... args)
    See Also: Utilities.error(String, Object...)

  onDestroy
    @AnyLogicInternalAPI
    public void onDestroy()
    This method is called when the owner of this extension is destroyed.
    Should be overridden when custom destroy is required.
    Default implementation does nothing.
    Specified by: onDestroy in interface AgentExtension

  next_xjal
    @AnyLogicInternalAPI
    public final AgentExtension next_xjal()
    Description copied from interface: AgentExtension
    This method is internal and shouldn't be called by user.
    It may be removed/renamed in future.
    Specified by: next_xjal in interface AgentExtension

  setNext_xjal
    @AnyLogicInternalAPI
    public final void setNext_xjal(AgentExtension next)
    Description copied from interface: AgentExtension
    This method is internal and shouldn't be called by user.
    It may be removed/renamed in future.
    Specified by: setNext_xjal in interface AgentExtension

  priority
    @AnyLogicInternalAPI
    public int priority()
    Description copied from interface: AgentExtension
    This method is internal and shouldn't be called by user.
    It may be removed/renamed in future.
    This function is used for sorting extensions (in order for the overriding delegation to work).
    Specified by: priority in interface AgentExtension
    Returns: int value, see also P_* constants

  onExtensionRemoved
    @AnyLogicInternalAPI
    public void onExtensionRemoved(AgentExtension ext)
    This method is internal and shouldn't be called by user.
    It may be removed/renamed in future.
    Default implementation does nothing.
    Specified by: onExtensionRemoved in interface AgentExtension
    Parameters: ext - the extension which has just been removed
    See Also: AgentExtension.onExtensionRemoved(AgentExtension)