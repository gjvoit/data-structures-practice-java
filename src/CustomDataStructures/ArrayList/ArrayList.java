package CustomDataStructures.ArrayList;

import java.util.Arrays;

/**
 * Created by Garet on 3/2/2017.
 * An ArrayList accesses elements by index and searches using a linear, brute force pattern.
 * Key methods: add, get, remove, size.
 * Dynamic (resizable) array.
 * Java's implementation increases capacity by 50% in size whenever add is called AND size=capacity.
 * Differences Between Vectors and ArrayLists
 * Vectors are synchronized, ArrayLists are not.
 * Data Growth Methods
 * Use ArrayLists if there is no specific requirement to use Vectors.
 * Synchronization
 * If multiple threads access an ArrayList concurrently then we must externally synchronize the block of code which modifies the list either structurally or simply modifies an element. Structural modification means addition or deletion of element(s) from the list. Setting the value of an existing element is not a structural modification.
 * Collections.synchronizedList is normally used at the time of creation of the list to avoid any accidental unsynchronized access to the list.
 * Data growth
 * Internally, both the ArrayList and Vector hold onto their contents using an Array. When an element is inserted into an ArrayList or a Vector, the object will need to expand its internal array if it runs out of room. A Vector defaults to doubling the size of its array, while the ArrayList increases its array size by 50 percent.
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

    // If found, returns the index of the object, otherwise returns -1
    public int search(Object o) {
        for (int i=0;i<size;i++) {
            if (o == myStore[i]) return i;
        }
        return -1;
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
