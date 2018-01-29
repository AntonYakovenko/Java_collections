package iterator;

import java.util.Iterator;

public class squaresIterator implements Iterator<Integer> {
    private int current;
    private final int max;

    squaresIterator(int current, int max) {
        double currentDouble = Math.sqrt(current);
        if ((currentDouble == Math.floor(currentDouble)) && !Double.isInfinite(currentDouble)) {
            this.current = (int) currentDouble;
        } else {
            this.current = (int) currentDouble + 1;
        }
        this.max = max;
    }

    @Override
    public boolean hasNext() {
        return current * current <= max;
    }

    @Override
    public Integer next() {
        int value = current * current;
        current++;
        return value;
    }
}
