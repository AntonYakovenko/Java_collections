package entities;

import java.util.*;

public class EntitiesDemo {
    public static void main(String[] args) {
        List<EntityA> listA = new ArrayList<>();
        listA.add(new EntityA(20, 170, "Nick"));
        listA.add(new EntityA(25, 160, "Ann"));
        listA.add(new EntityA(30, 165, "Sara"));
        System.out.println(listA.contains(new EntityA(20, 170, "Nick")));
        System.out.println(listA);

        System.out.println();

        List<EntityB> listB = new ArrayList<>();
        listB.add(new EntityB(new String[][]{{"A", "B"}, {"C", "D"}}, new double[]{2.1, 3.2}));
        System.out.println(listB.contains(new EntityB(new String[][]{{"A", "B"}, {"C", "D"}}, new double[]{2.1, 3.2})));
        System.out.println(listB);

        System.out.println();

        List<EntityC> listC = new ArrayList<>();

        //Create map

        Set<EntityA> set1 = new HashSet<>();
        set1.add(new EntityA(20, 170, "Nick"));
        set1.add(new EntityA(25, 160, "Ann"));
        set1.add(new EntityA(30, 165, "Sara"));
        List<EntityB[]> list1 = new ArrayList<>();
        list1.add(new EntityB[]{new EntityB(new String[][]{{"A", "B"}, {"C", "D"}}, new double[]{2.1, 3.2}),
                new EntityB(new String[][]{{"E", "F"}, {"G", "H"}}, new double[]{3.1, 2.2})});
        list1.add(new EntityB[]{new EntityB(new String[][]{{"X", "B"}, {"C", "D"}}, new double[]{2.1, 3.2}),
                new EntityB(new String[][]{{"E", "F"}, {"G", "H"}}, new double[]{3.1, 2.2})});
        Map<Set<EntityA>, List<EntityB[]>> map1 = new HashMap<>();
        map1.put(set1, list1);

        //Create the same map

        Set<EntityA> set2 = new HashSet<>();
        set2.add(new EntityA(20, 170, "Nick"));
        set2.add(new EntityA(25, 160, "Ann"));
        set2.add(new EntityA(30, 165, "Sara"));
        List<EntityB[]> list2 = new ArrayList<>();
        list2.add(new EntityB[]{new EntityB(new String[][]{{"A", "B"}, {"C", "D"}}, new double[]{2.1, 3.2}),
                new EntityB(new String[][]{{"E", "F"}, {"G", "H"}}, new double[]{3.1, 2.2})});
        list2.add(new EntityB[]{new EntityB(new String[][]{{"X", "B"}, {"C", "D"}}, new double[]{2.1, 3.2}),
                new EntityB(new String[][]{{"E", "F"}, {"G", "H"}}, new double[]{3.1, 2.2})});
        Map<Set<EntityA>, List<EntityB[]>> map2 = new HashMap<>();
        map2.put(set2, list2);

        //Check map content

        listC.add(new EntityC(new EntityA(20, 160, "Bella"),
                listB, map1));
        System.out.println(listC.contains(new EntityC(new EntityA(20, 160, "Bella"),
                listB, map2)));
        System.out.println(listC);
    }
}
