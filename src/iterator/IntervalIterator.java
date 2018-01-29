package iterator;

import java.util.Iterator;

public class IntervalIterator implements Iterator<Integer> {
    private int current;
    private final int max;

    IntervalIterator(int left, int right) {
        this.current = left;
        this.max = right;
    }

    @Override
    public boolean hasNext() {
        return current < max;
    }

    @Override
    public Integer next() {
        return current++;
    }
}
