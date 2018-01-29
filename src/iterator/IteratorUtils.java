package iterator;

public class IteratorUtils {
    public static Iterable<Integer> interval(int left, int right) {
        return new IntervalIterable(left, right);
    }

    public static Iterable<Integer> squares(int left, int right) {
        return new SquaresIterable(left, right);
    }
}
