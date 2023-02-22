package lab2;

import java.util.Arrays;
import java.util.Collection;

public class ContiguousList {
    // Array that backs the list
    private String[] elements;
    // Current number of elements in the list
    private int count;

    public ContiguousList() {
        elements = new String[10];
        count = 0;
    }

    // Adds the given element to front of the list
    public void prepend(String e) {
        for(int i = elements.length; i > 0; i--) {
            if (elements[i-1] != null) {
                elements[i] = elements[i-1];
            }
        }
        elements[0] = e;
    }

    // Adds the given element to the end of the list
    public void append(String e) {
        int i = 0;
        while (elements[i] != null) {
            i++;
            if (elements[i] == null) {
                elements[i] = e;
                break;
            }
        }
    }

    // Inserts the given element add the given index
    // Shifts all elements after the given index up by 1 index
    // If the index is larger than any index in the list then
    // the element should be inserted at the end of the list
    public void insert(int index, String e) {
        // TODO: Implement the logic given above
    }

    // Removes all elements from the list
    public void empty() {
        for (int i = 0; i < elements.length; i++) {
            delete(i);
        }
    }

    // Returns true if the given element exists in the list, false otherwise
    public boolean has(String e) {

        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == e) {
                return true;
            }
        }
        return false;
    }

    // Retrieves the element at the given index, if the index doesn't exist
    // then return null
    public String retrieve(int index) {
        if (elements[index-1] == null) {
            return null;
        }
        return elements[index];
    }

    // Returns true if the list is empty, false otherwise
    public boolean isEmpty() {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                return false;
            }
        }
        return true;
    }

    // Deletes the element at the given index and returns it,
    // if the index doesn't exist then return null
    public String delete(int index) {
        // TODO: Implement the logic given above
        return null;
    }

    // Deletes the first occurrence of an element from the list if it exists,
    // if an element is removed return true, false otherwise
    public boolean delete(String e) {
        // TODO: Implement the logic given above
        return false;
    }

    // Deletes all elements within the given collection,
    // this includes duplicates. If it removes an element then return true,
    // otherwise false
    public boolean deleteAll(Collection<?> c) {
        // TODO: Implement the logic given above
        return false;
    }

    // Sets the element at the given index to the given element and
    // returns the old element, return null if the index doesn't exist
    public String mutate(int index, String e) {
        // TODO: Implement the logic given above
        return null;
    }

    // Returns the current length of the list
    public int length() {
        // TODO: Implement the logic given above
        return -1;
    }

    // Override toString from Object
    // Should print out with a square bracket at the front and the back of the list
    // Each element should be seperated by a comma and a space
    // For example if your list had the elements "1" "2" and "3"
    // then the output would be "[1, 2, 3]"
    // nulls should not be printed
    @Override
    public String toString() {
        // TODO: Implement the logic given above
        return null;
    }

    public void print() {
        for (int i = 0; i < elements.length; i++) {
            System.out.println(elements[i]);
        }
    }

    // Override equals from Object
    // Should return true if the contents of your array are equal
    // to the contents of o's array, otherwise false.
    // nulls in the array should not be counted
    @Override
    public boolean equals(Object o) {
        // TODO: Implement the logic given above
        return false;
    }
}
