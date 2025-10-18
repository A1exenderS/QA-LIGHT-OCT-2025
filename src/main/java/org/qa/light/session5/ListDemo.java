package org.qa.light.session5;

import org.qa.light.session4.Boat;

import java.util.*;

public class ListDemo {
    public static void main(String[] args) {
        int[] ints = new int[10];
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList();
        //Array list:
        arrayList.add("a");//0
        arrayList.add("a");//0
        arrayList.add("b");//1
        arrayList.add("b");//1
        arrayList.add("e");//2
        arrayList.add("e");//2
        arrayList.add("c");//2->3
        arrayList.add("c");//2->3
        arrayList.add("d");//3->4
        arrayList.add("d");//3->4
        arrayList.add("f");//3->4
        arrayList.add("g");//3->4
        //LInked List:
        linkedList.add("a");//[start-of-list]-[a]-[b]
        linkedList.add("b");//[a]-[b]-[c] -> [a]-[b]-[e]
        linkedList.add("e");//[b]-[e]-[c]
        linkedList.add("c");//[b]-[c]-[d] -> [e]-[c]-[d]
        linkedList.add("d");//[c]-[d]-[end-of-list]
        linkedList.add("k");//[c]-[d]-[end-of-list]

        System.out.println(arrayList.get(3));
        System.out.println(linkedList.get(3));
//        arrayList.addAll(linkedList);
//        arrayList.removeAll(linkedList);
//        arrayList.remove("a");
//        System.out.println(arrayList.contains("k"));
//        System.out.println(arrayList.contains("a"));
//        System.out.println(arrayList.size());
//        System.out.println(arrayList.containsAll(linkedList));
//        Iterator<String> iterator = arrayList.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
        arrayList.retainAll(linkedList);

        List<Boat> boatList = new ArrayList<>();
        boatList.add(new Boat());
        boatList.get(0).color = "red";
        boatList.get(0).name = "test name";
        System.out.println(boatList.size());
    }
}
