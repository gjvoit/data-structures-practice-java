package CustomDataStructures.ArrayList;

import java.util.Arrays;

/**
 * Created by Garet on 3/2/2017.
 * An ArrayList accesses elements by index and searches using a linear, brute force pattern.
 * Key methods: add, get, remove, size.
 * Dynamic (resizable) array.
 * Doubles in size whenever add is called AND size=capacity.
 */
public class ArrayList {
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    public Object[] myStore;
    private int size = 0;
    private int capacity = DEFAULT_INITIAL_CAPACITY;

    public ArrayList() {
        myStore = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public Object add(Object objectToAdd) {
        if (size == capacity) {
            increaseListSize();
            capacity = myStore.length;
            myStore[size] = objectToAdd;
            size++;
            return objectToAdd;
        } else {
            myStore[size] = objectToAdd;
            size++;
            return objectToAdd;
        }
    }

    public void increaseListSize() {
        myStore = Arrays.copyOf(myStore, myStore.length*2);
    }

    public Object get(int index) {
        if (0 <= index && index < capacity) return myStore[index];
        else throw new ArrayIndexOutOfBoundsException();
    }

    public Object remove (int index) {
        if (0 <= index && index < size) {
            // "Remove" the object at myStore.[index]
            // int shiftingIndex = index;
            Object removedObject = myStore[index];
            myStore[index] = null;
            while (index < size) {
                myStore[index] = myStore[index+1];
                index++;
            }
            size--;
            return removedObject;
        } else throw new ArrayIndexOutOfBoundsException();
    }

    public boolean removeRange(int beginIndex, int endIndex) {
        if ((0 <= beginIndex && beginIndex < size) && (beginIndex <= endIndex && endIndex < size )) {
            int iteratingIndex = beginIndex;
            int numElementsRemoved = endIndex - beginIndex + 1;
            while (iteratingIndex <= endIndex) {
                myStore[iteratingIndex] = null;
                iteratingIndex++;
            }
            int i=beginIndex;
            while  (i < size - numElementsRemoved) {
                // Shift the array to the left by "difference"
                myStore[i] = myStore[i+numElementsRemoved];
                i++;
            }
            size -= numElementsRemoved;
            return true;
        } else return false;
    }

    @Override
    public String toString() {
        String str = "Current state of ArrayList: ";
        for (int i=0; i<size; i++) {
            str += "[" + myStore[i] + "], ";
        }
        return str;
    }

    public int size() {
        return this.size;
    }
}
