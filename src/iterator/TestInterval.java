package iterator;

public class TestInterval {
    public static void main(String[] args) {
        double[] array = {0.5, 1.5, 2.5, 3.5, 4.5, 5.5, 6.5, 7.5, 8.5, 9.5};

        for (int index : IteratorUtils.squares(0, array.length)) {
            System.out.print(" " + index);
        }
        System.out.println();

        for (int index : IteratorUtils.interval(0, array.length)) {
            System.out.print(" " + array[index]);
        }
        System.out.println();

        for (int index : IteratorUtils.squares(9, 30)) {
            System.out.print(" " + index);
        }
        System.out.println();

        for (int index : IteratorUtils.squares(5, 9)) {
            System.out.print(" " + array[index]);
        }
    }
}
