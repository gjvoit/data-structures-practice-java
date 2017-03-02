package CustomDataStructures.Stack;

import CustomDataStructures.LinkedList.SinglyLinkedList;
import CustomDataStructures.LinkedList.SinglyLinkedListEntry;

/**
 * Created by Garet on 2/25/2017.
 * A stack implements a Last in, First out (LIFO) pattern.
 * A stack has only one element with which you can interact, the "top".
 * Key Methods include: push, pop, peek, size, isEmpty
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

    public int size() {
        return size;
    }

    public SinglyLinkedListEntry peek() {
        return top;
    }

    public void push(SinglyLinkedListEntry newTop) {
        size++;
        this.stack.addFirst(newTop);
        top = stack.getHead();
    }

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
}
