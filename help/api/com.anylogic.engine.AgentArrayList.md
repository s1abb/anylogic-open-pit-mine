# Class `AgentArrayList<E extends Agent>`

## Class Hierarchy
- `java.lang.Object`
  - `com.anylogic.engine.AgentList<E>`
    - `com.anylogic.engine.AgentArrayList<E>`

## Type Parameters
- `E` — agent type

## Implemented Interfaces
- `com.anylogic.engine.internal.Child`
- `IterableWithSize<E>`
- `Serializable`
- `Iterable<E>`

## Description
`AgentArrayList` is an agent population list based on array implementation.  
It supports fast element retrieval by its index (the `get(int)` operation runs in constant time).  
The `add` operation runs in amortized constant time, i.e., adding `n` elements requires O(n) time.

**Author:** AnyLogic North America, LLC — https://anylogic.com  
**See Also:** Serialized Form

---

## Constructor Summary

| Constructor | Description |
|------------|-------------|
| `AgentArrayList(Agent owner)` | Constructs an empty list with an initial capacity of ten. |

---

## Method Summary

| Modifier and Type | Method | Description |
|-------------------|--------|-------------|
| `void` | `_add(E agent)` | Should not be called by user. Use `add_EONAME()` or `agent.goToPopulation(population)` |
| `boolean` | `_remove(Agent agent)` | Should not be called by user. Use `remove_EONAME()` or `agent.goToPopulation(null)` |
| `boolean` | `contains(Object agent)` | Returns true if this agent population contains the specified element. |
| `E` | `get(int index)` | Returns the agent element at the specified position in this agent population. |
| `boolean` | `isEmpty()` | Returns true if this agent population contains no elements. |
| `Iterator<E>` | `iterator()` | Returns an iterator over the agent population. |
| `int` | `size()` | Returns the number of elements in this agent population. |
| `Stream<E>` | `stream()` | Returns a sequential Stream with this agent population as its source. |
| `String` | `toString()` | — |

---

## Methods Inherited from Class `com.anylogic.engine.AgentList`
average, callCreate, callSetupParameters, count, fillFromTable, findAll, findFirst, getEnvironment, getOwner, getPresentationScaleOnOwnerSpace, getValueFromTable, instantiateAgent, isPresentationEnabled, max, min, onChange, random, randomExcept, restoreOwner, setEnvironment, sum

## Methods Inherited from Class `java.lang.Object`
equals, getClass, hashCode, notify, notifyAll, wait

## Methods Inherited from Interface `java.lang.Iterable`
forEach, spliterator

# Method Details: AgentArrayList<E extends Agent>

## _add
**Annotation:** `@AnyLogicInternalCodegenAPI`  
**Signature:** `public void _add(E agent)`  
**Description:**  
This method should not be called by user.  
Call `add_EONAME()` method of class containing embedded object with name EONAME or `agent.goToPopulation(population)`  
**Overrides:** `_add` in class `AgentList<E extends Agent>`

---

## _remove
**Annotation:** `@AnyLogicInternalCodegenAPI`  
**Signature:** `public boolean _remove(Agent agent)`  
**Description:**  
This method should not be called by user.  
Call `remove_EONAME()` method of class containing embedded object with name EONAME or `agent.goToPopulation(null)`  
**Overrides:** `_remove` in class `AgentList<E extends Agent>`

---

## get
**Signature:** `public E get(int index)`  
**Description:**  
Returns the agent element at the specified position in this agent population.  
The position index is the number of list element in the insertion order.  
**Parameters:**  
- `index` — index of the element to return  
**Returns:** the element at the specified position in this list  
**Overrides:** `get` in `IterableWithSize<E extends Agent>` and `AgentList<E extends Agent>`

---

## contains
**Signature:** `public boolean contains(Object agent)`  
**Description:**  
Returns true if this agent population contains the specified element.  
**Parameters:**  
- `agent` — element whose presence in this agent population is to be tested  
**Returns:** `true` if this agent population contains the specified element  
**Overrides:** `contains` in class `AgentList<E extends Agent>`

---

## isEmpty
**Signature:** `public boolean isEmpty()`  
**Description:**  
Returns true if this agent population contains no elements.  
**Returns:** `true` if this agent population contains no elements  
**Overrides:** `isEmpty` in `IterableWithSize<E extends Agent>` and `AgentList<E extends Agent>`

---

## iterator
**Signature:** `public Iterator<E> iterator()`  
**Description:**  
Returns an iterator over the agent population.  
This iterator guarantees the insertion order of elements.  
Note: returned iterator doesn't support remove operation.  
**Overrides:** `iterator` in `Iterable<E extends Agent>` and `AgentList<E extends Agent>`

---

## stream
**Signature:** `public Stream<E> stream()`  
**Description:**  
Returns a sequential Stream with this agent population as its source.  
**Overrides:** `stream` in class `AgentList<E extends Agent>`

---

## size
**Signature:** `public int size()`  
**Description:**  
Returns the number of elements in this agent population.  
If this collection contains more than `Integer.MAX_VALUE` elements, returns `Integer.MAX_VALUE`.  
**Overrides:** `size` in `IterableWithSize<E extends Agent>` and `AgentList<E extends Agent>`

---

## toString
**Signature:** `public String toString()`  
**Overrides:** `toString` in class `Object`
