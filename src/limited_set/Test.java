package limited_set;

public class Test {
    public static void main(String[] args) {
        LimitedSet<String> set = new LimitedSetImpl<>();
        for (int i = 0; i < 12; i++) {
            set.add("" + i);
        }
        // expected: 11 1 2 3 4 5 6 7 8 9
        System.out.println(set);
        for (int i = 1; i < 10; i++) {
            set.contains("" + i);
        }
        set.add("elem1");
        // expected: elem1 1 2 3 4 5 6 7 8 9
        System.out.println(set);
        set.remove("4");
        set.contains("elem1");
        for (int i = 2; i < 10; i++) {
            set.contains("" + i);
        }
        // expected: elem1 1 2 3 5 6 7 8 9
        System.out.println(set);
        set.add("elem2");
        // expected: elem1 1 2 3 5 6 7 8 9 elem2
        System.out.println(set);
        //expected: elem1 1 2 3 5 6 7 8 9 elem3
        set.add("elem3");
        System.out.println(set);
    }
}
