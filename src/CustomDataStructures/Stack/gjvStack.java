package CustomDataStructures.Stack;

import CustomDataStructures.LinkedList.SinglyLinkedList;
import CustomDataStructures.LinkedList.SinglyLinkedListEntry;

/**
 * Created by Garet on 2/25/2017.
 * A stack implements a Last in, First out (LIFO) pattern.
 * A stack has only one element with which you can interact, the "top".
 * Key Methods include: push, pop, peek, size, search, isEmpty
 */
public class gjvStack {
    private SinglyLinkedListEntry top;
    private int size;
    private SinglyLinkedList stack;

    public gjvStack() {
        stack = new SinglyLinkedList();
        this.top = null;
        size = 0;
    }

    public gjvStack(SinglyLinkedListEntry top) {
        stack = new SinglyLinkedList();
        stack.addFirst(top);
        this.top = top;
        size = 1;
    }

    /*
     * size - Returns the size of the stack.
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public int size() {
        return size;
    }

    /*
     * peek - Returns the "top" element but does NOT remove it from the stack.
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public SinglyLinkedListEntry peek() {
        return top;
    }

    /*
     * Returns void, adds the specified element as the new "top".
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public void push(SinglyLinkedListEntry newTop) {
        size++;
        this.stack.addFirst(newTop);
        top = stack.getHead();
    }

    /*
     * pop - Returns the "top" element and removes it from the stack.
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public SinglyLinkedListEntry pop() {
        SinglyLinkedListEntry nodeToPop = top;
        if (this.size() == 0) return null;
        if (this.size() == 1) {
            top = null;
            this.stack.setHead(null);
            this.stack.setTail(null);
        }
        else {
            stack.setHead(stack.getHead().getNext());
            top = stack.getHead();
        }
        size--;
        // Return the node that got popped
        return nodeToPop;
    }

    /*
     * search - Returns the offset from the top if the list contains the specified value, otherwise returns null.
     * Time complexity: O(n)
     * In the worst case, we must pop every element in the stack, then push every element back on to the stack.
     * This reduces to O(n)
     * Space complexity: O(n)
     * In the worst case, we must store the entire stack on an inverted temporary stack so that we can restore the popped elements.
     */

    public int search(int numToFind, gjvStack rebuilder, int currOffset) {
        // The only thing the function returns is the offset.
        // You should be pushing a current element onto a temp list, then popping the current element off of this.stack
        // At the end, reverse the process
        // Base case 1... current top is the value we're looking for. Return the offset.
        // Base case 2: We've popped the entire stack and haven't found the int, return -1 to indicate this.
        if (peek() == null) return -1;
        else if (numToFind == peek().getValue()) {
            return currOffset;
        }
        else {
            currOffset += 1;
            rebuilder.push(pop());
            currOffset = this.search(numToFind, rebuilder, currOffset);
            push(rebuilder.pop());
        }
        return currOffset;
    }

    /*
     * isEmpty - Returns true if the stack has no elements, otherwise returns false.
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public boolean isEmpty() {
        return peek() == null;
    }
}
