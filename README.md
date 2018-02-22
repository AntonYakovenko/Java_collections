# Collections
Viewed such topics as collections hierarchy, `ArrayList`, `LinkedList`, `HashSet`, `TreeSet`, `HashMap`, `TreeMap`, computational complexity, overriding `equals()` and `hashcode()`.
## Completed tasks
### 1. Entity
There are `EntityA`, `EntityB`, `EntityC`:
```
public class EntityA {
    private int age;
    private int height;
    private String name;
}    
```
```
public class EntityB {
    private final String[][] stringArr;
    private final double[] doubleArr;
}    
```
```
public class EntityC {
    private final EntityA entity;
    private final List<EntityB> list;
    private final Map<Set<EntityA>, List<EntityB[]>> map;
}
```
Override `equals()` and `hashcode()` correctly for `EntityA`, `EntityB`, `EntityC`.
### 2. List
Create simple implementations of `ArrayList` and `LinkedList`. Implement methods `add(int index, E element)`, `get(int index)`, `iterator()`, `contains(E element)`, `size()`, `isEmpty()`, `set(int index, E element)`, `remove(E element)`, `equalas()`, `hashcode()`, `toString()`.
### 3. Iterator
Write an iterator that returns squares of integers