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
        if (head == null || index == 0) {
            prepend(e);
        }
        else if (index > length()) {
            append(e);
        }
        else {
            Node curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            Node newNode = new Node(e);
            newNode.setNext(curr.next);
            curr.setNext(newNode);
        }
    }

    @Override
    public void empty() {

    }

    @Override
    public boolean has(T e) {
        Node curr = head;
        for (int i = 0; i < length()-1; i++) {
            if (curr.value == e) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    @Override
    public T retrieve(int index) {
        Node curr = head;
        if (index > length()-1) {
            return null;
        } else {
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            return curr.value;
        }
    }

    @Override
    public boolean isEmpty() {
        if (head != null) {
            return false;
        }
        return true;
    }

    @Override
    public T delete(int index) {
        Node curr = head;
        if (index == 0) {
            deleteHeadAndUpdate();
            return curr.value;
        } else if (index > length()) {
            return null;

        } else {
            Node prev = null;
            for (int i = 0; i < index; i++) {
                prev = curr;
                curr = curr.next;
            }
            if (index == length()-1) {
                deleteTail();
                return curr.value;
            } else {
                prev.setNext(curr.next);
                //need previous
                return curr.value;
            }

        }
    }

    public Node updateTail() {
        Node curr = head.next.next;
        Node tail = head.next;
        Node beforeTail = head;
        while (curr != null) {
            beforeTail = beforeTail.next;
            tail = tail.next;
            curr = curr.next;
        }
        return beforeTail;
    }

    public void deleteTail() {
        Node kicker = updateTail();
        kicker.setNext(null);
    }

    public void deleteHeadAndUpdate() {
        if (head.next != null) {
            head = head.next;
        } else {
            head = null;
        }

    }

    @Override
    public boolean delete(T e) {
        Node curr = head;
        Node prev = null;
        for (int i = 0; i < length(); i++) {
            if (i == 0 && curr.value.equals(e)) {
                deleteHeadAndUpdate();
                return true;
            } else if (i == length()-1 && curr.value.equals(e)) {
                deleteTail();
                return true;
            } else {
                if (curr.value.equals(e)) {
                    prev.setNext(curr.next);
                    return true;
                }
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }


    @Override
    public boolean deleteAll(Collection<?> c) {
        if (c.isEmpty()) {
            return false;
        } else {
            head = null;
        }
        return true;
    }

    @Override
    public T mutate(int index, T e) {
        Node curr = head;
        T temp = null;
        if (index == 0) {
            temp = curr.value;
            curr.setValue(e);
            return temp;
        } else if (index > length()) {
            return null;
        } else {
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            temp = curr.value;
            curr.setValue(e);
            return temp;
        }
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
        if (length() == 0 || curr==null) {
            return "[]";
        }

        while (curr != null) {
            result += curr.value.toString() + ", ";
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
