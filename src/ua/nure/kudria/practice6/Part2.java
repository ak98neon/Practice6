package ua.nure.kudria.practice6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Part2 {

    private static final int MAX_ELEMENTS = 10_000;
    private static final int K = 3;

    public static long removeByIndex(List<?> list, int k) {
        final Long startTime = System.currentTimeMillis();
        do {
            int count = 1;
            for (int i = 0; i < list.size(); i++) {
                if (count == k) {
                    list.remove(i);
                    count = 1;
                } else if (list.size() == 2 && count == 2) {
                    list.remove(i);
                    break;
                } else {
                    count++;
                }
            }
        } while (list.size() != 1);
        final Long finishTime = System.currentTimeMillis();
        return finishTime - startTime;
    }

    public static long removeByIterator(List<?> list, int k) {
        final Long startTime = System.currentTimeMillis();
        do {
            int count = 1;
            Iterator iterator = list.iterator();
            iterator.next();
            while (iterator.hasNext()) {
                if (count == k) {
                    iterator.remove();
                    iterator.next();
                } else {
                    count++;
                }
            }

        } while (list.size() != 1);
        final Long finishTime = System.currentTimeMillis();
        return finishTime - startTime;
    }

    public static List<Object> init(List<Object> list) {
        for (int i = 0; i < MAX_ELEMENTS; i++) {
            list.add(i);
        }
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
