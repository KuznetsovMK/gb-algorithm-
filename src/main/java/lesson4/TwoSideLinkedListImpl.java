package lesson4;

import java.util.Iterator;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedListImpl<E> implements TwoSideLinkedList<E> {

    protected Node<E> last;

    @Override
    public void insertFirst(E value) {
        Node<E> first = this.first;
        Node<E> newNode = new Node<E>(value, first, null);
        this.first = newNode;
        if (first == null) {
            this.last = newNode;
        } else {
            first.prev = newNode;
        }
        size++;
    }

    @Override
    public void insertLast(E value) {
        Node<E> last = this.last;
        Node<E> newNode = new Node<>(value, null, last);
        this.last = newNode;
        if (last == null) {
            this.first = newNode;
        } else {
            last.next = newNode;
        }
        size++;
    }

    @Override
    public E removeLast() {
        Node<E> last = this.last;
        E element = last.item;
        Node<E> prev = last.prev;
        last.item = null;
        last.prev = null;
        this.last = prev;
        if (prev == null) {
            this.first = null;
        } else {
            prev.next = null;
        }

        --this.size;
        return element;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> first = this.first;
        E element = first.item;
        Node<E> next = first.next;
        first.item = null;
        first.next = null;
        this.first = next;
        if (next == null) {
            this.last = null;
        } else {
            next.prev = null;
        }

        --this.size;
        return element;
    }

    @Override
    public boolean remove(E value) {
        Node<E> prev = null;
        Node<E> current = first;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == first) {
            removeFirst();
            return true;
        }
        if (current == last) {
            last = prev;
            last.next = null;
        }

        prev.next = current.next;
        current.next = null;
        size--;

        return true;
    }

    @Override
    public E getLast() {
        return last.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIterator<>(this);
    }

    private class ListIterator<E> implements Iterator<E> {

        private TwoSideLinkedList<E> linkedList;

        public ListIterator(TwoSideLinkedList<E> linkedList) {
            this.linkedList = linkedList;
        }


        @Override
        public boolean hasNext() {
            return linkedList.size() > 0;
        }

        @Override
        public E next() {
            return linkedList.removeFirst();
        }
    }
}
