package CustomDataStructures.Heap;

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

}
