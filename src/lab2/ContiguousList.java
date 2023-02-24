package lab2;

import java.util.Collection;


public class ContiguousList {
    // Array that backs the list
    private String[] elements;
    // Current number of elements in the list
    private int count;
    private int currentArrayLength;


    public ContiguousList() {
        elements = new String[10];
        count = 0;
    }

    // Adds the given element to front of the list
    public void prepend(String e) {
        if (isFull()) {
            doubleArray();
            for (int i = elements.length-1; i > 0; i--) {
                elements[i] = elements[i-1];
            }
            elements[0] = e;
        } else {
            for (int i = elements.length-1; i > 0; i--) {
                elements[i] = elements[i-1];
            }
            elements[0] = e;
        }
    }

    // Adds the given element to the end of the list
    public void append(String e) {
        if (isFull()) {
            doubleArray();
        }
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
        if (isFull()) {
            doubleArray();
        }
        int end = elements.length-1;
        while (index <= elements.length && index != 0) {
            elements[end-1] = elements[end];
            end--;
        }
        if (index == 0){
            prepend(e);
        }

        if (index >elements.length) {
            append(e);
        }
        //size of 5
        // insert at 3
        // element[3]= element[4]
        // element[4]= element [5]
        // element[5] =
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
        String returner = elements[index];
        if (elements[index] == null) {
            return null;
        } else {
            elements[index] = null;
            return returner;
        }
    }

    // Deletes the first occurrence of an element from the list if it exists,
    // if an element is removed return true, false otherwise
    public boolean delete(String e) {
        for (int i = 0; i < elements.length-1; i++) {
            if (elements[i] == e) {
                elements[i] = null;
                return true;
            }
        }
        return false;
    }

    // Deletes all elements within the given collection,
    // this includes duplicates. If it removes an element then return true,
    // otherwise false
    public boolean deleteAll(Collection<?> c) {
        if (c.isEmpty()){
            return false;
        } else {
            for (int i = 0; i < elements.length - 1; i++) {
                if (c.contains(String.valueOf(elements[i]))) {
                    elements[i] = null;
                }
            }
        }

        return true;
    }

    // Sets the element at the given index to the given element and
    // returns the old element, return null if the index doesn't exist
    public String mutate(int index, String e) {
        String oldElement = elements[index];
        if (elements[index] == null) {
            return null;
        }
        else {
            elements[index] = e;
        }
        return oldElement;
    }

    // Returns the current length of the list
    public int length() {
        int lenghtCounter = 0;
        for (int i = 0; i < elements.length-1; i++) {
            if (elements[i] != null) {
                lenghtCounter++;
            }
        }
        return lenghtCounter;
    }

    // Override toString from Object
    // Should print out with a square bracket at the front and the back of the list
    // Each element should be seperated by a comma and a space
    // For example if your list had the elements "1" "2" and "3"
    // then the output would be "[1, 2, 3]"
    // nulls should not be printed
    @Override
    public String toString() {
        String returner = "";
        if (isEmpty()) {
            return returner;
        } else {
            for (int i = 0; i < elements.length - 1; i++) {
                if (elements[i] != null) {
                    returner += elements[i] + ", ";
                }
            }
            returner = "[" + returner.substring(0,returner.length()-2) + "]";
        }
        return returner;
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
        if (getElements() == o) {
            return true;
        }
        return false;
    }

    public String[] getElements(){
        String[] returner = new String[elements.length];
        for (int i = 0; i < elements.length-1; i++) {
            returner[i] = elements[i];
        }
        return returner;
    }

    public boolean isFull() {
        for (int i = 0; i < elements.length-1; i++) {
            if (elements[i] == null) {
                return false;
            }
        }
        return true;
    }

    public void doubleArray() {
        currentArrayLength = elements.length * 2;
        String[] tempArray = new String[currentArrayLength];
        for (int i = 0; i < elements.length ; i++) {
            tempArray[i] = elements[i];
        }
        elements=tempArray;
    }
}
