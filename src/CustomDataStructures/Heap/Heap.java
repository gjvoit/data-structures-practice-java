package CustomDataStructures.Heap;

import CustomDataStructures.ArrayList.ArrayList;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Garet on 3/2/2017.
 * Specialized tree-based structure.
 * Must have the property:
 * If A is a parent node of B, then the key (the value) of node A is ordered with respect to the
 * key of node B with the same ordering applying across the heap.
 * The example I will be implementing will be a minHeap which has the following properties:
 * The ORDER property:
 * For every node n, the value in n is greater than or equal to the values in its children
 * (and thus is also greater than or equal to all of the values in its subtrees).
 * The SHAPE property:
 * 1. All leaves are either at depth d or d-1 (for some value d).
 * 2. All of the leaves at depth d-1 are to the right of the leaves at depth d.
 * 3. (a) There is at most 1 node with just 1 child. (b) That child is the left child of its parent, and
 * (c) it is the rightmost leaf at depth d.
 * Key methods: add(Object o), clear, contains(Object o), peek, remove(Object o), compare, size
 */
public class Heap {
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private int[] heap;
    private int hole;
    private int capacity;
    private int size;

    public Heap() {
        // Add arbitrary value at heap[0], so root sits at heap[1] to allow 2i and 2i + 1 logic to work for adding children
        heap = new int[DEFAULT_INITIAL_CAPACITY];
        heap[0] = -9999999;
        hole = 1;
        size = 1;
        capacity = DEFAULT_INITIAL_CAPACITY;
    }

    public Heap(int root) {
        // Add arbitrary root, so root begins at 1
        heap = new int[DEFAULT_INITIAL_CAPACITY];
        heap[0] = -9999999;
        heap[1] = root;
        hole = 2;
        size = 2;
        capacity = DEFAULT_INITIAL_CAPACITY;
    }

    /* Space Complexity: O(1)
     * Time Complexity: O(n)
     * Because the array isn't sorted and isn't a binary search tree, we cannot use binary search to reduce to O(log(n))?
     * Linearly search through the array until we find the value we're looking for
     * Return the index at which we found the value, or -1 if the value wasn't found
     */
    public int get(int searchVal) {
        for (int i=1; i < hole; i++) {
            if (heap[i] == searchVal) return i;
        }
        return -1;
    }

    public int getLeft(int index) {
        if (index*2 > capacity) throw new IndexOutOfBoundsException("Cannot get right, index out of bounds");
        return heap[index*2];
    }

    public int getRight(int index) {
        if ((index*2)+1 > capacity) throw new IndexOutOfBoundsException("Cannot get right, index out of bounds");
        return heap[(index*2)+1];
    }

    public int getParent(int index) {
        if (Math.floorDiv(index,2) < 1) throw new IndexOutOfBoundsException("Cannot access indices lower than 1");
        return heap[(int) (Math.floor(index/2))];
    }

    public String toString() {
        String str = "";
        for (int i=1; i < capacity; i++) str += i + ":[" + heap[i] + "] ";
        return str;
    }

    public int[] getHeap() {
        return heap;
    }

    // O(1)
    // Returns the root node without removing it
    public int peek() {
        return heap[1];
    }

    // Worst case runtime is O(n*log(n)), since array copy requires n operations.
    // However, amortized runtime for this is O(log(n)), as the amortized insertion time for an array is O(1)
    // Time Complexity: O(log(n))
    // Space Complexity: Amortized (O(1)), Worst case (O(2n)) since expanding the array requires holding a new array in memory.
    public void enqueue(int newVal) {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, heap.length*2);
            capacity = heap.length;
        }
        // Add at the "hole" then percolate up.
        heap[hole] = newVal;
        // Max number of times this would get called is log(n) where n is the size of heap;
        percolateUp(hole);
        hole++;
        size++;
    }

    public int dequeue() {
        int dequeueVal = heap[1];
        // Move rightmost leaf to root
        heap[1] = heap[size-1];
        // Percolate down while currVal > min(left, right)
        percolateDown(1);
        heap[size-1] = 0;
        hole--;
        size--;
        return dequeueVal;
    }

    public void increasePriority(int task, int newPriority) {
        int indexOfTask = get(task);
        heap[indexOfTask] = newPriority;
        percolateUp(indexOfTask);
    }

    public void decreasePriority(int task, int newPriority) {
        int indexOfTask = get(task);
        heap[indexOfTask] = newPriority;
        percolateDown(indexOfTask);
    }

    private void percolateUp(int index) {
        int currentLocation = index;
        // Percolate up until the heap[currLocation] is not less than its parent
        while (heap[currentLocation] < heap[Math.floorDiv(currentLocation, 2)]) {
            int tempParent = heap[Math.floorDiv(currentLocation, 2)];
            heap[Math.floorDiv(currentLocation, 2)] = heap[currentLocation];
            heap[currentLocation] = tempParent;
            currentLocation = Math.floorDiv(currentLocation, 2);
        }
    }

    private void percolateDown(int index) {
        // Percolate down
        int currentLocation = index;
        int tempSwap;
        int minIndex;
        while (currentLocation*2+1 <= hole &&
                heap[currentLocation] > Math.min(heap[currentLocation*2], heap[currentLocation*2+1])) {
            if (heap[currentLocation*2] == 0 && heap[currentLocation*2+1] == 0) break;
            // Temporarily hold current value (being percolated down) to enable the swap
            tempSwap = heap[currentLocation];
            // Logic here is kind of spotty.
            // Any 0 values represent "null" and should not be considered when checking the min
            // Therefore calculating min(0,x [ for any x > 0]) will return 0, which results in unintended swaps
            if (getLeft(currentLocation) < getRight(currentLocation)) {
                if (getLeft(currentLocation) == 0) minIndex = currentLocation*2+1;
                else minIndex = currentLocation*2;
            }
            else if (getRight(currentLocation) == 0) minIndex = currentLocation*2;
            else minIndex = currentLocation*2+1;
            heap[currentLocation] = heap[minIndex];
            heap[minIndex] = tempSwap;
            currentLocation = minIndex;
        }
    }

    public int remove(int deleteValue) {
        // Start at index 1 (root), if value is
        return -1;
    }
}
