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
    private int root;
    private int hole;
    private int capacity;
    private int size;

    Heap() {
        // Add arbitrary value at heap[0], so root sits at heap[1] to allow 2i and 2i + 1 logic to work for adding children
        heap = new int[DEFAULT_INITIAL_CAPACITY];
        heap[0] = 99999;
        hole = 1;
        size = 1;
        capacity = DEFAULT_INITIAL_CAPACITY;
    }

    Heap(int root) {
        // Add arbitrary root, so root begins at 1
        heap = new int[DEFAULT_INITIAL_CAPACITY];
        heap[0] = 99999;
        this.root = root;
        heap[1] = this.root;
        hole = 2;
        size = 1;
        capacity = DEFAULT_INITIAL_CAPACITY;
    }

    // O(1)
    // Returns the root node without removing it
    public int peek() {
        return root;
    }

    // Worst case runtime is O(n*log(n)), since array copy requires n operations.
    // However, amortized runtime for this is O(log(n)), as the amortized insertion time for an array is O(1)
    // Time Complexity: O(log(n))
    // Space Complexity: Amortized (O(1)), Worst case (O(2n)) since expanding the array requires holding a new array in memory.
    public boolean add(int newVal) {
        if (size == capacity) Arrays.copyOf(heap, heap.length*2);
        // Add at the "hole" then percolate up.
        heap[hole] = newVal;
        hole++;
        size++;
        // Max number of times this would get called is log(n) where n is the size of heap;
        for (int i=0; i < size; )
        return false;
    }

}
