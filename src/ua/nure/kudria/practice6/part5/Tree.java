package ua.nure.kudria.practice6.part5;

import java.util.Comparator;

public class Tree<T extends Comparable<T>> {
    private Node<T> root;
    private Comparator<T> comparator;

    Tree() {
        root = null;
        comparator = null;
    }

    private int compare(T x, T y) {
        if (comparator == null) return x.compareTo(y);
        else
            return comparator.compare(x, y);
    }

    boolean add(T data) {
        boolean tmp = !search(root, data);
        root = add(root, data);
        return tmp;
    }

    boolean add(T[] data) {
        boolean tmp = false;
        for (T obj : data) {
            add(obj);
            tmp = true;
        }
        return tmp;
    }

    private Node<T> add(Node<T> p, T toInsert) {
        if (p == null)
            return new Node<>(toInsert);

        if (compare(toInsert, p.data) == 0)
            return p;

        if (compare(toInsert, p.data) < 0)
            p.left = add(p.left, toInsert);
        else
            p.right = add(p.right, toInsert);

        return p;
    }

    private boolean search(Node<T> p, T toSearch) {
        if (p == null)
            return false;
        else if (compare(toSearch, p.data) == 0)
            return true;
        else if (compare(toSearch, p.data) < 0)
            return search(p.left, toSearch);
        else
            return search(p.right, toSearch);
    }

    boolean remove(T toDelete) {
        boolean tmp = search(root, toDelete);
        root = remove(root, toDelete);
        return tmp;
    }

    private Node<T> remove(Node<T> p, T toDelete) {
        if (p == null) {
            search(root, toDelete);
        } else if (compare(toDelete, p.data) < 0)
            p.left = remove(p.left, toDelete);
        else if (compare(toDelete, p.data) > 0)
            p.right = remove(p.right, toDelete);
        else {
            if (p.left == null) return p.right;
            else if (p.right == null) return p.left;
            else {
                p.data = retrieveData(p.left);
                p.left = remove(p.left, p.data);
            }
        }
        return p;
    }

    private T retrieveData(Node<T> p) {
        while (p.right != null) p = p.right;
        return p.data;
    }

    void print() {
        treeSorter(root);
        System.out.println();
    }

    private void treeSorter(Node r) {
        if (r != null) {
            treeSorter(r.left);
            System.out.print(r + " ");
            treeSorter(r.right);
        }
    }

    private static class Node<E> {
        private E data;
        private Node<E> left;
        private Node<E> right;

        Node(E data, Node<E> l, Node<E> r) {
            left = l;
            right = r;
            this.data = data;
        }

        Node(E data) {
            this(data, null, null);
        }

        public String toString() {
            return data.toString();
        }
    }
}
