package lists;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

import static java.lang.Math.max;

public class SimpleArrayList<E> implements SimpleList<E> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private E[] data;
    private int size = 0;

    SimpleArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    SimpleArrayList(int initialCapacity) {
        this.data = (E[]) new Object[initialCapacity];
    }

    /*** ADD ***/
    @Override
    public boolean add(E newElement) {
        ensureCapacity(size + 1);
        data[size] = newElement;
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index);
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    /*** READ ***/
    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<E> {
        int cursor;

        Iter() {}

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            if (cursor >= size) {
                throw new NoSuchElementException();
            }
            return data[cursor++];
        }
    }

    /*** CHECK ***/
    @Override
    public boolean contains(Object element) {
        if (element == null) { //look for null
            for (int k = 0; k < size; k++) {
                if (data[k] == null) {
                    return true;
                }
            }
        } else { //look for !null
            for (int k = 0; k < size; k++) {
                if (element.equals(data[k])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /*** MUTATE ***/
    @Override
    public E set(int index, E newElement) {
        checkIndex(index);
        E oldElement = data[index];
        data[index] = newElement;
        return oldElement;
    }

    /*** REMOVE ***/
    @Override
    public boolean remove(Object obj) {
        if (obj == null) { //look for null
            for (int k = 0; k < size; k++) {
                if (data[k] == null) {
                    int numMoved = size - k - 1;
                    System.arraycopy(data, k + 1, data, k, numMoved);
                    data[--size] = null;
                    return true;
                }
            }
        } else { //look for !null
            for (int k = 0; k < size; k++) {
                if (data[k] == obj) {
                    int numMoved = size - k - 1;
                    System.arraycopy(data, k + 1, data, k, numMoved);
                    data[--size] = null;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E oldValue = data[index];
        int numMoved = size - index - 1;
        System.arraycopy(data, index + 1, data, index, numMoved);
        data[--size] = null;
        return oldValue;
    }

    /*** OBJECT METHODS ***/
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        SimpleArrayList<?> that = (SimpleArrayList<?>) obj;
        if (this.size != that.size) {
            return false;
        }
        Iterator<E> thisItr = this.iterator();
        Iterator<?> thatItr = that.iterator();
        while (thisItr.hasNext() && thatItr.hasNext()) {
            if (!Objects.equals(thisItr.next(), thatItr.next())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (E elem : this.data) {
            if (elem == null) {
                result = 31 * result;
            } else {
                result = 31 * result + elem.hashCode();
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "[";
        Iterator<E> itr = iterator();
        while (true) {
            result += itr.next();
            if (!itr.hasNext()) {
                return result + "]";
            }
            result += ", ";
        }
    }

    /*** INTERNALS ***/
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = max(minCapacity, data.length + (data.length >> 1));
            E[] newData = (E[]) new Object[newCapacity];
            System.arraycopy(data, 0, newData, 0, data.length);
            this.data = newData;
        }
    }
}
