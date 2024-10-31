package deque;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDeque<T> implements Deque<T> {

    private int size;
    private Node sentinel;


    private class Node {
        public T item;
        public Node prev;
        public Node next;

        public Node (T i, Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    public LinkedListDeque() {
        size = 0;
        sentinel = null;

    }


    public void addFirst(T item) {
        size += 1;
        if (sentinel == null) {
            sentinel = new Node(item, null, null);
        }
        else {
            sentinel.next = new Node(item, sentinel, sentinel.next);
        }
    }

    public void addLast(T item) {
        size += 1;
        if (sentinel == null) {
            sentinel = new Node(item, null, null);
        }
        else {
            sentinel.prev = new Node(item, sentinel.prev, sentinel);
        }
    }

    public boolean isEmpty() {
        return sentinel == null;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (Node p = sentinel; p != null; p = p.next) {
            System.out.println(p.item);
        }
    }

    public T removeFirst() {
        if (sentinel == null) {
            return null;
        }
        T item = sentinel.item;
        sentinel = sentinel.next;
        size -= 1;
        return item;
    }

    public T removeLast() {
        if (sentinel == null) {
            return null;
        }
        T item = sentinel.item;
        sentinel = sentinel.prev;
        size -= 1;
        return item;
    }

    public T get(int index) {
        for (int i = 0; i < index; i += 1) {
            sentinel = sentinel.next;
            if (sentinel == null) {
                return null;
            }
        }
        return sentinel.item;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof LinkedListDeque<?>) {
            LinkedListDeque<?> other = (LinkedListDeque<?>) o;
            if (((LinkedListDeque<?>) o).size() != this.size()) {
                return false;
            }
            for (int i = 0; i < this.size(); i += 1) {
                if (this.get(i) != other.get(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public Iterator<T> iterator() {

    }

    public T getRecursive(int index) {
        if (sentinel == null) {
            return null;
        }
        if (index == 0) {
            return sentinel.item;
        }
        sentinel = sentinel.next;
        return getRecursive(index - 1);
    }
}
