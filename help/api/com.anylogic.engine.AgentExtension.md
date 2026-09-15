# Interface `AgentExtension`

**Superinterfaces:**  
- `Serializable`

**Known Subinterfaces:**  
- `ExtAgentContinuous`  
- `ExtAgentDiscrete`  
- `ExtAgentGIS`  
- `ExtAgentInteractive`  
- `ExtAgentWithSpatialMetrics`  
- `ExtAnimationParams`  
- `ExtDefaultAnimationProvider`  
- `ExtEntity`  
- `ExtEnvironmentContinuous`  
- `ExtEnvironmentDiscrete`  
- `ExtEnvironmentGIS`  
- `ExtEnvironmentInteractive`  
- `ExtEnvironmentWithLayout`  
- `ExtEnvironmentWithMetrics`  
- `ExtRootModelAgent`  
- `ExtSpace`

**Known Implementing Classes:**  
- `AgentExtensionImpl`  
- `ExtAgentContinuousDelegate`  
- `ExtAgentWithSpatialMetricsDelegate`  
- `ExtEntityContinuousDelegate`  
- `ExtEntityDelegate`

**Annotation:**  
- `@AnyLogicInternalCodegenAPI`

## Description
Base interface for extensions of Agents.  
**Author:** AnyLogic North America, LLC https://anylogic.com

---

## Field Summary

| Modifier and Type | Field | Description |
|-------------------|-------|-------------|
| `static final int` | `P_AGENT_WITH_SPECIFIC_SPACE` | — |
| `static final int` | `P_AGENT_WITH_SPECIFIC_SPACE_DELEGATE` | — |
| `static final int` | `P_AGENT_WITH_SPATIAL_METRICS_DELEGATE` | — |
| `static final int` | `P_AGENT_INTERACTIVE_DELEGATE` | — |
| `static final int` | `P_ENTITY_DELEGATE` | — |
| `static final int` | `P_ENV_WITH_SPECIFIC_SPACE` | — |
| `static final int` | `P_USER_EXT` | — |
| `static final int` | `P_ROOT` | — |
| `static final int` | `P_SPACE` | — |

---

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `Agent` | `getAgent()` | Returns the agent this extension belongs to. |
| `AgentExtension` | `next_xjal()` | Internal method. Shouldn't be called by user. May be removed/renamed in future. |
| `void` | `setNext_xjal(AgentExtension next)` | Internal method. Shouldn't be called by user. May be removed/renamed in future. |
| `void` | `onDestroy()` | Called when the owner of this extension is destroyed. Override for custom destroy logic. |
| `void` | `onExtensionRemoved(AgentExtension ext)` | Callback invoked when another agent extension is removed. |
| `int` | `priority()` | Used for sorting extensions. Internal use only. |
| `boolean` | `supportsInterface_xjal(Class<?> itfs)` | Internal method. Shouldn't be called by user. May be removed/renamed in future. |

---

## Method Details

### `AgentExtension next_xjal()`
**Annotation:** `@AnyLogicInternalAPI`  
Internal method. Shouldn't be called by user. May be removed/renamed in future.

---

### `void setNext_xjal(AgentExtension next)`
**Annotation:** `@AnyLogicInternalAPI`  
Internal method. Shouldn't be called by user. May be removed/renamed in future.

---

### `Agent getAgent()`
Returns the agent this extension belongs to.  
**Returns:** the agent this extension belongs to.

---

### `void onDestroy()`
**Annotation:** `@AnyLogicInternalAPI`  
Called when the owner of this extension is destroyed.  
Override this method for custom destroy logic.  
Default implementation does nothing.

---

### `boolean supportsInterface_xjal(Class<?> itfs)`
**Annotation:** `@AnyLogicInternalAPI`  
Internal method. Shouldn't be called by user. May be removed/renamed in future.

---

### `int priority()`
**Annotation:** `@AnyLogicInternalAPI`  
Used for sorting extensions (for overriding delegation).  
**Returns:** int value, see also P_* constants.

---

### `void onExtensionRemoved(AgentExtension ext)`
**Annotation:** `@AnyLogicInternalAPI`  
Callback invoked when another agent extension is removed.  
This is invoked for all extensions (including the removed one).  
Note: `onDestroy()` is not called when an extension is removed.  
**Parameters:**  
- `ext` — the extension which has just been removed.