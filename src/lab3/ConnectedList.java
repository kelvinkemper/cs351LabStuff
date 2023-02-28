package lab3;

import java.util.Collection;
import java.util.Objects;

/**
 * This class must use Node in order to implement the ListInterface
 * Node contains a value and reference to the next element in the list
 * This enough to successfully implement interface
 */
public class ConnectedList<T> implements ListInterface<T> {
    private Node head;

    @Override
    public void prepend(T e) {
        //create a new node

        if (head == null) {
            head = new Node(e);
        } else {
            Node newNode = new Node(e);
            newNode.setNext(head);
            head = newNode;
        }
    }

    @Override
    public void append(T e) {
        Node curr = head;
        Node newNode = new Node(e);
        for (int i = 0; i < length()-1; i++) {
            curr = curr.next;
        }
        curr.setNext(newNode);
    }

    @Override
    public void insert(int index, T e) {
        if (index > length()) {
            append(e);
        }
    }

    @Override
    public void empty() {
        head.setValue(null);
    }

    @Override
    public boolean has(T e) {
        return false;
    }

    @Override
    public T retrieve(int index) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T delete(int index) {
        return null;
    }

    @Override
    public boolean delete(T e) {
        return false;
    }

    @Override
    public boolean deleteAll(Collection<?> c) {
        return false;
    }

    @Override
    public T mutate(int index, T e) {
        return null;
    }

    @Override
    public int length() {
        int counter = 0;
        Node curr = head;
        while (curr != null) {
            counter++;
            curr = curr.next;

        }
        return counter;
    }

    @Override
    public String toString() {
        String result = "";
        Node curr = head;
        while (curr != null) {
            result+= curr.value.toString() + ", ";
            curr = curr.next;
        }
        result = "[" + result.substring(0,result.length()-2) + "]";
        return result;
    }

    private class Node {
        private T value;
        private Node next;

        private Node(T value) {
            this.value = value;
        }

        private Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public T value() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node next() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }
}
