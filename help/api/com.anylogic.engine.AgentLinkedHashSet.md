# Class AgentLinkedHashSet<E extends Agent>
java.lang.Object
  ↳ com.anylogic.engine.AgentList<E>
    ↳ com.anylogic.engine.AgentLinkedHashSet<E>

## All Implemented Interfaces:
  - com.anylogic.engine.internal.Child
  - IterableWithSize<E>
  - Serializable
  - Iterable<E>

public class AgentLinkedHashSet<E extends Agent> extends AgentList<E>
Description:
  Agent population collection based on LinkedHashSet implementation.
  Offers constant time performance for basic operations (add, remove, contains, size).
  Guarantees insertion-order during iteration.

Note:
  Due to set-based implementation, element retrieval by index (get(int)) is extremely slow for large collections.
  Similarly, Agent.getIndex() will be slow.

Author:
  AnyLogic North America, LLC https://anylogic.com

See Also:
  Serialized Form

## Constructor Summary:
  AgentLinkedHashSet(Agent owner)

## Method Summary:
  void _add(E agent)
    - Internal use only. Do not call directly.
    - Use add_EONAME() or agent.goToPopulation(population)

  boolean _remove(Agent agent)
    - Internal use only. Do not call directly.
    - Use remove_EONAME() or agent.goToPopulation(null)

  boolean contains(Object agent)
    - Returns true if this population contains the specified element.
    - Runs in about constant time.

  E get(int index)
    - Returns the agent at the specified index.
    - Extremely slow for large collections with random access.

  boolean isEmpty()
    - Returns true if the population contains no elements.

  Iterator<E> iterator()
    - Returns an iterator preserving insertion order.

  int size()
    - Returns the number of elements.
    - Returns Integer.MAX_VALUE if size exceeds it.

  Stream<E> stream()
    - Returns a sequential Stream of the population.

  String toString()
    - Overrides Object.toString()

## Methods inherited from class com.anylogic.engine.AgentList:
  - average, callCreate, callSetupParameters, count, fillFromTable, findAll, findFirst,
    getEnvironment, getOwner, getPresentationScaleOnOwnerSpace, getValueFromTable,
    instantiateAgent, isPresentationEnabled, max, min, onChange, random, randomExcept,
    restoreOwner, setEnvironment, sum

## Methods inherited from class java.lang.Object:
  - equals, getClass, hashCode, notify, notifyAll, wait

## Methods inherited from interface java.lang.Iterable:
  - forEach, spliterator

## Constructor Details:
  public AgentLinkedHashSet(Agent owner)

## Method Details:

  contains
    public boolean contains(Object agent)
    - Returns true if the population contains the specified element.
    - Specified by: contains in AgentList<E>

  isEmpty
    public boolean isEmpty()
    - Returns true if the population is empty.
    - Specified by: isEmpty in IterableWithSize<E>, AgentList<E>

  iterator
    public Iterator<E> iterator()
    - Returns an iterator preserving insertion order.
    - Specified by: iterator in Iterable<E>, AgentList<E>

  stream
    public Stream<E> stream()
    - Returns a sequential Stream.
    - Overrides: stream in AgentList<E>

  size
    public int size()
    - Returns the number of elements.
    - Specified by: size in IterableWithSize<E>, AgentList<E>

  get
    public E get(int index)
    - Returns the agent at the specified index.
    - Throws IndexOutOfBoundsException if index is invalid.
    - Specified by: get in IterableWithSize<E>, AgentList<E>

  _add
    @AnyLogicInternalCodegenAPI
    public void _add(E agent)
    - Internal use only.
    - Specified by: _add in AgentList<E>

  _remove
    @AnyLogicInternalCodegenAPI
    public boolean _remove(Agent agent)
    - Internal use only.
    - Specified by: _remove in AgentList<E>

  toString
    public String toString()
    - Overrides: toString in Object