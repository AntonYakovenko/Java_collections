package lists;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements SimpleList<E> {
    private Node<E> first = null; //head
    private Node<E> last = null; //tail
    private int size = 0;

    /*** ADD ***/
    @Override
    public boolean add(E newElement) {
        final Node<E> tmp = last;
        final Node<E> newNode = new Node<>(tmp, newElement, null);
        last = newNode;
        if (tmp == null) {
            first = newNode;
        } else {
            tmp.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index);
        if (index == size) {
            linkLast(element);
        } else {
            linkBefore(element, node(index));
        }
    }

    /*** READ ***/
    @Override
    public E get(int index) {
        checkIndex(index);
        return node(index).item;
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
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E elem = node(cursor).item;
            cursor++;
            return elem;
        }
    }

    /*** CHECK ***/
    @Override
    public boolean contains(Object hasElement) {
        return indexOf(hasElement) != -1;
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
        Node<E> foundNode = node(index);
        E oldVal = foundNode.item;
        foundNode.item = newElement;
        return oldVal;
    }

    /*** REMOVE ***/
    @Override
    public boolean remove(Object obj) {
        if (obj == null) { //look for null
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else { //look for !null
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item.equals(obj)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        return unlink(node(index));
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
        SimpleLinkedList<?> that = (SimpleLinkedList<?>) obj;
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
        for (Node<E> x = first; x != null; x = x.next) {
            if (x.item == null) {
                result = 31 * result;
            } else {
                result = 31 * result + x.item.hashCode();
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

    private Node<E> node(int index) {
        if (index < size / 2) {
            Node<E> tmp1 = first;
            for (int i = 0; i < index; i++) {
                tmp1 = tmp1.next;
            }
            return tmp1;
        } else {
            Node<E> tmp2 = last;
            for (int i = size - 1; i > index; i--) {
                tmp2 = tmp2.prev;
            }
            return tmp2;
        }
    }

    private int indexOf(Object obj) {
        int index = 0;
        if (obj == null) { // look for null
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    return index;
                }
                index++;
            }
        } else { //look fir !null
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item.equals(obj)) {
                    return index;
                }
                index++;
            }
        }
        return -1;
    }

    private E unlink(Node<E> x) {
//        assert x != null;
        final E item = x.item;
        final Node<E> prev = x.prev;
        final Node<E> next = x.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return item;
    }

    private void linkLast(E e) {
        final Node<E> tmp = last;
        final Node<E> newNode = new Node<>(tmp, e, null);
        last = newNode;
        if (tmp == null) {
            first = newNode;
        } else {
            tmp.next = newNode;
        }
        size++;
    }

    private void linkBefore(E e, Node<E> succ) {
//        assert succ != null;
        final Node<E> prev = succ.prev;
        final Node<E> newNode = new Node<>(prev, e, succ);
        succ.prev = newNode;
        if (prev == null) {
            first = newNode;
        } else {
            prev.next = newNode;
        }
        size++;
    }

    private static class Node<T> {
        private Node<T> prev;
        private T item;
        private Node<T> next;

        Node(Node<T> prev, T item, Node<T> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
}
