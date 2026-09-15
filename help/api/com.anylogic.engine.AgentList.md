## Class AgentList<E extends Agent>
java.lang.Object
↳ com.anylogic.engine.AgentList<E>

Type Parameters:
  E - agent type

## All Implemented Interfaces:
  com.anylogic.engine.internal.Child, IterableWithSize<E>, Serializable, Iterable<E>

## Direct Known Subclasses:
  AgentArrayList, AgentLinkedHashSet

public abstract class AgentList<E extends Agent>
extends Object
implements Iterable<E>, IterableWithSize<E>, Serializable, com.anylogic.engine.internal.Child

Description:
  Agent population list interface

Author:
  AnyLogic North America, LLC https://anylogic.com

See Also:
  AgentArrayList, Serialized Form

## Constructor Summary:
  AgentList(Agent owner)

## Method Summary:
abstract void _add(E agent)
- This method should not be called by user.
- Call add_EONAME() method of class containing embedded object with name EONAME or agent.goToPopulation(population)

abstract boolean _remove(Agent agent)
- This method should not be called by user.
- Call remove_EONAME() method of class containing embedded object with name EONAME or agent.goToPopulation(null)

double average(String fieldName)
- Returns the average of (numeric) field values for all agents in this collection

double average(String fieldName, String triggerFieldName)
- Returns the average of (numeric) field values for all agents in this collection which have true value of a boolean field with name triggerFieldName (if specified)

void callCreate(E agent, int index)
- Internal method. Calls Agent.create() and performs population-related initializations

void callCreate(E agent, int index, TableInput tableInput)
- Internal method. Calls Agent.create() and performs population-related initializations

void callSetupParameters(E agent, int index)
- Internal method. Sets agent parameters to values defined in population

void callSetupParameters(E agent, int index, TableInput tableInput)
- Internal method. Sets agent parameters to values defined in population

abstract boolean contains(Object agent)
- Returns true if this agent population contains the specified element

int count(String triggerFieldName)
- Returns the number of agents in this collection with true value of a boolean field named triggerFieldName

void fillFromTable(TableInput tableInput)
- Creates agents from the given table using configured parameter mappings, adds to population, and starts agents

void fillFromTable(TableInput tableInput, BiConsumer<TableInput,E> agentSetupCode, boolean callCreate, boolean startAgents)
- Creates agents from the given table, sets parameters, adds to population

void fillFromTable(TableInput tableInput, BiConsumer<TableInput,E> agentSetupCode, Function<TableInput,Integer> numberOfAgents, boolean callCreate, boolean startAgents)
- Creates agents from the given table, sets parameters, adds to population

List<E> findAll(Predicate<E> condition)
- Returns new list with agents from this population which meet the given condition


E findFirst(Predicate<E> condition)
- Returns the first agent from this population which meets the given condition.

abstract E get(int index)
- Returns the agent element at the specified position in this agent population.

Agent getEnvironment()
- Returns the environment where this agent population belongs to.

Agent getOwner()
- Returns the owner agent that encapsulates this population.

double getPresentationScaleOnOwnerSpace()
- Returns the scale of the agent presentation animation on its space or 1.0 if space isn't defined or agent list is empty.

<T> T getValueFromTable(String columnLabel, Class<T> returnType)

E instantiateAgent(int index)
- Internal method. Creates new instance of agent for this population.
- Should be overridden by code generation. Default implementation is unsupported.

abstract boolean isEmpty()
- Returns true if this agent population contains no elements.

boolean isPresentationEnabled()
- Internal method. May be removed/renamed in future.

abstract Iterator<E> iterator()
- Returns an iterator over the agent population (in insertion order).

double max(String fieldName)
- Returns the maximum of (numeric) field values for all agents in this collection.

double max(String fieldName, String triggerFieldName)
- Returns the maximum of (numeric) field values for agents with true value of a boolean field named triggerFieldName.

double min(String fieldName)
- Returns the minimum of (numeric) field values for all agents in this collection.

double min(String fieldName, String triggerFieldName)
- Returns the minimum of (numeric) field values for agents with true value of a boolean field named triggerFieldName.

double min(Collection<? extends Agent> agents, String fieldName, String triggerFieldName)
- Deprecated. Will be removed in version 7.1+. Use min(String, String) instead.

void onChange()
- Calls onChange() for all the agents in this list.

final E random()
- Randomly returns one agent from this population (uniform distribution).
- Returns null if the population is empty.

final E random(Random r)
- Randomly returns one agent using the specified random number generator.
- Returns null if the population is empty.

E randomExcept(Agent agent)
- Randomly returns one agent except the given agent.
- Returns null if the population is empty or contains only the given agent.

E randomExcept(Set<? extends Agent> agents)
- Randomly returns one agent except those in the given set.
- Returns null if the population is empty or all agents are in the set.

final void restoreOwner(Object owner)
- Deprecated.

void setEnvironment(Agent environment)

abstract int size()
- Returns the number of elements in this agent population.
- If more than Integer.MAX_VALUE, returns Integer.MAX_VALUE.

Stream<E> stream()
- Returns a sequential Stream with this agent population as its source.

double sum(String fieldName)
- Returns the sum of (numeric) field values for all agents in this collection.

double sum(String fieldName, String triggerFieldName)
- Returns the sum of (numeric) field values for agents with true value of a boolean field named triggerFieldName.

## Methods inherited from class java.lang.Object
equals, getClass, hashCode, notify, notifyAll, toString, wait, wait, wait

## Methods inherited from interface java.lang.Iterable
forEach, spliterator

## Constructor Details
public AgentList(Agent owner)

## Method Details

public Agent getOwner()
  - Returns the owner agent that encapsulates this population.
  - Returns: owner agent

@AnyLogicInternalCodegenAPI
public abstract void _add(E agent)
  - This method should not be called by user.
  - Call add_EONAME() method of class containing embedded object with name EONAME or agent.goToPopulation(population)

@AnyLogicInternalCodegenAPI
public abstract boolean _remove(Agent agent)
  - This method should not be called by user.
  - Call remove_EONAME() method of class containing embedded object with name EONAME or agent.goToPopulation(null)

@AnyLogicInternalCodegenAPI
public void setEnvironment(Agent environment)

public Agent getEnvironment()
  - Returns the environment where this agent population belongs to.
  - Returns: the environment where this agent population belongs to

public abstract int size()
  - Returns the number of elements in this agent population.
  - If this collection contains more than Integer.MAX_VALUE elements, returns Integer.MAX_VALUE.
  - Returns: the number of elements in this agent population

public abstract boolean isEmpty()
  - Returns true if this agent population contains no elements.
  - Returns: true if this agent population contains no elements

public abstract boolean contains(Object agent)
  - Returns true if this agent population contains the specified element.
  - Parameters: agent - element whose presence in this agent population is to be tested
  - Returns: true if this agent population contains the specified element

public final E random()
  - Randomly returns one agent from this population (uses uniform distribution from the Engine)
  - This method runs in linear time
  - Returns: the agent randomly chosen from this population or null if empty

public final E random(Random r)
  - Randomly returns one agent from this population using the specified random number generator
  - This method runs in linear time
  - Parameters: r - the random number generator
  - Returns: the agent randomly chosen from this population or null if empty

- randomExcept
public E randomExcept(Agent agent)
- Randomly returns one agent from this population except the given agent
- (uses uniform distribution from the Engine)
- This method runs in linear time
- Returns null if the population is empty or contains only the given agent
- Parameters:
-   agent - agent not to be chosen
- Returns:
-   the agent randomly chosen from this population but not the given agent

public E randomExcept(Set<? extends Agent> agents)
- Randomly returns one agent from this population except the given agents
- (uses uniform distribution from the Engine)
- This method runs in linear time multiplied by the complexity of 'contains' check
- Returns null if the population is empty or all agents are in the given set
- Parameters:
-   agents - agents not to be chosen
- Returns:
-   the agent randomly chosen from this population

- findAll
public List<E> findAll(Predicate<E> condition)
- Returns new list with agents from this population which meet the given condition
- Returns:
-   always new instance of list, modifiable, with agents which satisfy the condition

- findFirst
public E findFirst(Predicate<E> condition)
- Returns the first agent from this population which meets the given condition
- Returns:
-   the agent satisfying the condition, or null if none found

- onChange
public void onChange()
- Calls onChange() for all the agents in this list
- Notifies agents that some data may have changed

- sum
@AnyLogicLegacyAPI
public double sum(String fieldName, String triggerFieldName)
- Returns the sum of numeric field values for agents with true value of triggerFieldName
- Parameters:
-   fieldName - field to sum
-   triggerFieldName - boolean field to filter agents (may be null)
- Returns:
-   sum of field values

public double sum(String fieldName)
- Returns the sum of numeric field values for all agents
- Parameters:
-   fieldName - field to sum
- Returns:
-   sum of field values

- average
@AnyLogicLegacyAPI
public double average(String fieldName, String triggerFieldName)
- Returns the average of numeric field values for agents with true value of triggerFieldName
- Parameters:
-   fieldName - field to average
-   triggerFieldName - boolean field to filter agents (may be null)
- Returns:
-   average of field values, or 0 if no suitable agents

public double average(String fieldName)
- Returns the average of numeric field values for all agents
- Parameters:
-   fieldName - field to average
- Returns:
-   average of field values, or 0 if no agents

- min
@Deprecated
public double min(Collection<? extends Agent> agents, String fieldName, String triggerFieldName)
- Deprecated. Use min(String, String) instead

@AnyLogicLegacyAPI
public double min(String fieldName, String triggerFieldName)
- Returns the minimum of numeric field values for agents with true value of triggerFieldName
- Parameters:
-   fieldName - field to check
-   triggerFieldName - boolean field to filter agents (may be null)
- Returns:
-   minimum value, +infinity if no suitable agents
public double min(String fieldName)
- Returns the minimum of numeric field values for all agents
- Parameters:
-   fieldName - field to check
- Returns:
-   minimum value, -infinity if no suitable agents

- max
@AnyLogicLegacyAPI
public double max(String fieldName, String triggerFieldName)
- Returns the maximum of numeric field values for agents with true value of triggerFieldName
- Parameters:
-   fieldName - field to check
-   triggerFieldName - boolean field to filter agents (may be null)
- Returns:
-   maximum value, -infinity if no suitable agents

public double max(String fieldName)
- Returns the maximum of numeric field values for all agents
- Parameters:
-   fieldName - field to check
- Returns:
-   maximum value, -infinity if no suitable agents

- count
public int count(String triggerFieldName)
- Returns the number of agents with true value of triggerFieldName
- Parameters:
-   triggerFieldName - boolean field to filter agents (may be null)
- Returns:
-   number of matching agents

- restoreOwner
@AnyLogicInternalCodegenAPI
@Deprecated
public final void restoreOwner(Object owner)
- Deprecated. Used internally for snapshot saving/loading
- Parameters:
-   owner - owner of this object (Agent, Experiment, or ShapeGroup)

- iterator
public abstract Iterator<E> iterator()
- Returns an iterator over the agent population
- Guarantees insertion order, does not support remove operation
- Returns:
-   Iterator over the agents

- stream
public Stream<E> stream()
- Returns a sequential Stream with this agent population as its source
- Since: 8.0

- get
public abstract E get(int index)
- Returns the agent element at the specified position in this agent population.
- Parameters:
-   index - index of the element to return
- Returns:
-   the element at the specified position
- Throws:
-   IndexOutOfBoundsException if index < 0 || index >= size()

- instantiateAgent
@AnyLogicInternalCodegenAPI
public E instantiateAgent(int index)
- Internal method. Creates new instance of agent for this population.
- Parameters:
-   index - index of agent in the population
- Returns:
-   the agent
- Since: 7.2

- callSetupParameters
@AnyLogicInternalCodegenAPI
public void callSetupParameters(E agent, int index)
- Internal method. Sets agent parameters to values defined in population.
- Parameters:
-   agent - the agent
-   index - index of agent in the population

@AnyLogicInternalCodegenAPI
public void callSetupParameters(E agent, int index, TableInput tableInput)
- Internal method. Sets agent parameters to values defined in population.
- Parameters:
-   agent - the agent
-   index - index of agent in the population
-   tableInput - TableInput if agent is loaded from DB, or null

- callCreate
@AnyLogicInternalCodegenAPI
public void callCreate(E agent, int index)
- Internal method. Calls Agent.create() and performs population-related initializations.
- Parameters:
-   agent - the agent
-   index - index of agent in the population

@AnyLogicInternalCodegenAPI
public void callCreate(E agent, int index, TableInput tableInput)
- Internal method. Calls Agent.create() and performs population-related initializations.
- Parameters:
-   agent - the agent
-   index - index of agent in the population
-   tableInput - TableInput if agent is loaded from DB, or null

- fillFromTable
@AnyLogicInternalAPI
public void fillFromTable(TableInput tableInput)
- Creates agents from the given table using AnyLogic parameter mapping.
- Parameters:
-   tableInput - table input with source and mapping info
- Since: 7.2

@AnyLogicInternalAPI
public void fillFromTable(TableInput tableInput,
                          BiConsumer<TableInput,E> agentSetupCode,
                          boolean callCreate,
                          boolean startAgents)
- Creates agents from table, sets parameters, adds to population.
- Parameters:
-   tableInput - table input
-   agentSetupCode - code to set agent parameters
-   callCreate - true to call Agent.create()
-   startAgents - true to call Agent.start()

@AnyLogicInternalAPI
public void fillFromTable(TableInput tableInput,
                          BiConsumer<TableInput,E> agentSetupCode,
                          Function<TableInput,Integer> numberOfAgents,
                          boolean callCreate,
                          boolean startAgents)
- Creates agents from table, sets parameters, adds to population.
- Parameters:
-   tableInput - table input
-   agentSetupCode - code to set agent parameters
-   numberOfAgents - function to determine number of agents
-   callCreate - true to call Agent.create()
-   startAgents - true to call Agent.start()
- Since: 7.2

- getValueFromTable
@AnyLogicInternalCodegenAPI
public <T> T getValueFromTable(String columnLabel, Class<T> returnType)
- Retrieves a value from a table column with specified return type.

- getPresentationScaleOnOwnerSpace
@AnyLogicInternalCodegenAPI
public double getPresentationScaleOnOwnerSpace()
- Returns the scale of the agent presentation animation on its space
- Returns:
-   scale of presentation or 1.0 if undefined or empty

- isPresentationEnabled
@AnyLogicInternalCodegenAPI
public boolean isPresentationEnabled()
- Internal method. Indicates if presentation is enabled.
