package lists;

public class SimpleListDemo {
    public static void main(String[] args) {
        SimpleList<String> list1 = new SimpleLinkedList<>();
        System.out.println("Add \"A\": " + list1.add("A"));
        System.out.println("Add \"B\": " + list1.add("B"));
        System.out.println("Add \"C\": " + list1.add("C"));
        System.out.println("Add \"D\": " + list1.add("D"));
        System.out.println("list1: " + list1);
        System.out.println("Get elem from index \"0\": " + list1.get(0));
        System.out.println("Contains \"ELEM\": " + list1.contains("ELEM"));
        System.out.println("Contains \"A\": " + list1.contains("A"));
        System.out.println("IsEmpty: " + list1.isEmpty());
        System.out.println("Size: " + list1.size());
        System.out.println("Set \"SET\" to index \"2\": " + list1.set(2, "SET"));
        System.out.println("Void: add \"ADD\" to index \"2\"");
        list1.add(2, "ADD");
        System.out.println("list1: " + list1);
        System.out.println("Remove \"int[]{0}\": " + list1.remove(new int[]{0}));
        System.out.println("Remove elem from index \"2\": " + list1.remove(2));
        System.out.println("Remove \"SET\": " + list1.remove("SET"));
        System.out.println("list1: " + list1);

        SimpleList<String> list2 = new SimpleArrayList<>();
        list2.add("A");
        list2.add("B");
        list2.add("D");
        System.out.println("Equality: " + list1.equals(list2));
        list2.add(3, "ADD");
        System.out.println("Equality: " + list1.equals(list2));
    }
}
