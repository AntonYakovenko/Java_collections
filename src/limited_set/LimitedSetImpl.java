package limited_set;

public class LimitedSetImpl<T> implements LimitedSet<T> {

    private static final int CAPACITY = 10;
    private T[] data;
    private int[] calls;
    private int size = 0;

    @SuppressWarnings("unchecked")
    LimitedSetImpl() {
        this.data = (T[]) new Object[CAPACITY];
        this.calls = new int[CAPACITY];
    }

    @Override
    public void add(T t) {
        switch (size) {
            case 0:
                data[0] = t;
                size++;
                break;
            case CAPACITY:
                // find index of element with max calls
                int index = 0;
                int minCalls = calls[0];
                for (int i = 1; i < size; i++) {
                    if (calls[i] < minCalls) {
                        minCalls = calls[i];
                        index = i;
                    }
                }
                data[index] = t;
                break;
            default:
                if (t == null) { // check for null
                    for (int i = 0; i < size; i++) {
                        if (data[i] != null) {
                            data[size] = null;
                            size++;
                            break;
                        }
                    }
                } else {
                    for (int i = 0; i < size; i++) {
                        if (!t.equals(data[i])) {
                            data[size] = t;
                            size++;
                            break;
                        }
                    }
                }
        }
    }

    @Override
    public boolean remove(T t) {
        if (t == null) { // check for null
            for (int i = 0; i < size; i++) {
                if (data[i] == null) {
                    fastRemove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (t.equals(data[i])) {
                    fastRemove(i);
                    return true;
                }
            }
        }
        return false;
    }

    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        System.arraycopy(data, index + 1, data, index, numMoved);
        data[size - 1] = null;
        System.arraycopy(calls, index + 1, calls, index, numMoved);
        calls[size - 1] = 0;
        size--;
    }

    @Override
    public boolean contains(T t) {
        if (t == null) { // check for null
            for (int i = 0; i < size; i++) {
                if (data[i] == null) {
                    calls[i]++;
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (t.equals(data[i])) {
                    calls[i]++;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            result.append(data[i]).append(" ");
        }
        return result.toString();
    }
}
