package lists;

import java.util.Iterator;

public interface SimpleList<E> {

    /*** ADD ***/
    boolean add(E newElement);

    void add(int index, E element);

    /*** READ ***/
    E get(int index);

    Iterator<E> iterator();

    /*** CHECK ***/
    boolean contains(Object hasElement);

    int size();

    boolean isEmpty();

    /*** MUTATE ***/
    E set(int index, E newElement);

    /*** REMOVE ***/
    boolean remove(Object o);

    E remove(int index);
}
