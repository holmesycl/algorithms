package com.holmesycl.algorithms.structure;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {

    private Node first;
    private Node last;
    private int N;

    private class Node {
        T t;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(T t) {
        Node oldLast = last;
        last = new Node();
        last.t = t;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public T dequeue() {
        T t = first.t;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return t;
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
