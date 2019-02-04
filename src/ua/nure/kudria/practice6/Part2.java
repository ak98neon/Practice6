package ua.nure.kudria.practice6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Part2 {

    private static final int MAX_ELEMENTS = 10_000;
    private static final int K = 3;

    public static long removeByIndex(List<?> list, int k) {
        // TODO place your code here
        return 0;
    }

    public static long removeByIterator(List<?> list, int k) {
        // TODO place your code here
        return 0;
    }

    public static List<Object> init(List<Object> list) {
        // TODO add elements
        return list;
    }

    public static void main(String[] args) {
        List<Object> arrayList = init(new ArrayList<>());
        List<Object> linkedList = init(new LinkedList<>());

        System.out.println("ArrayList#Index: " + removeByIndex(arrayList, K) + " ms");
        System.out.println("LinkedList#Index: " + removeByIndex(linkedList, K) + " ms");

        arrayList = init(new ArrayList<>());
        linkedList = init(new LinkedList<>());

        System.out.println("ArrayList#Iterator: " + removeByIterator(arrayList, K) + " ms");
        System.out.println("LinkedList#Iterator: " + removeByIterator(linkedList, K) + " ms");
    }
}
