# Class `AgentExtensionFactory<T extends AgentExtension>`

**Package:** `com.anylogic.engine`

## Overview

`AgentExtensionFactory<T extends AgentExtension>`  
An abstract class used to create agent extensions in AnyLogic.

---

## Constructor Summary

| Constructor | Description |
|-------------|-------------|
| `AgentExtensionFactory()` | Default constructor. |

---

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `abstract T` | `create(Agent owner)` | This method should create an extension for the given agent. It may check for compatibility with existing agent extensions and throw an error if incompatible. |
| `static <T extends AgentExtension>` | `AgentExtensionFactory<? extends T> get(Class<T> c)` | Retrieves the registered factory for the specified agent extension class. |
| `static <T extends AgentExtension>` | `void register(Class<T> c, AgentExtensionFactory<? extends T> factory)` | Registers a new extension factory. |

---

## Inherited Methods from `java.lang.Object`

- `equals`
- `getClass`
- `hashCode`
- `notify`
- `notifyAll`
- `toString`
- `wait` (3 overloads)

---

## Constructor Details

### `AgentExtensionFactory()`

Default constructor.

---

## Method Details

### `register`

```java
public static <T extends AgentExtension> void register(
    Class<T> c,
    AgentExtensionFactory<? extends T> factory
)
```

### `get`

```java
@AnyLogicInternalAPI
public static <T extends AgentExtension> AgentExtensionFactory<? extends T> get(Class<T> c)
```

### `create`

```java
public abstract T create(Agent owner)
```

Creates an extension for the given agent.

This method should:

Instantiate a new extension for the specified agent.
Optionally perform compatibility checks with existing agent extensions.
For example, it may throw an error if a "Discrete space Agent" extension is requested while the agent already has a "Continuous space Agent" extension.
Potentially invoke nested ext() calls on the agent.
This is common when the new extension is based on another extension (e.g., an "Entity" extension based on a "Continuous space Agent").
Parameters:

owner – The agent that will own the new extension.
Returns:

A new instance of the agent extension.