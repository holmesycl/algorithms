package com.holmesycl.algorithms.structure;

import java.util.Iterator;

public class Bag<T> implements Iterable<T> {

    public Node first;

    private class Node {
        T t;
        Node next;
    }

    public void add(T t) {
        Node oldFirst = first;
        first = new Node();
        first.t = t;
        first.next = oldFirst;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T t = current.t;
            current = current.next;
            return t;
        }
    }
}
