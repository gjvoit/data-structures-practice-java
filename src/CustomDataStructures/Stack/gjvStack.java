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

    public gjvStack(SinglyLinkedListEntry top) {
        stack = new SinglyLinkedList();
        stack.addFirst(top);
        this.top = top;
        size = 1;
    }

    public int size() {
        return size;
    }

    public SinglyLinkedListEntry top() {
        return top;
    }

    public void push(SinglyLinkedListEntry newTop) {
        size++;
        this.stack.addFirst(newTop);
        top = stack.getHead();
    }

    public boolean pop() {
        if (this.size() == 0) return false;
        if (this.size() == 1) {
            top = null;
        }
        else {
            stack.setHead(stack.getHead().getNext());
            top = stack.getHead();
        }
        size--;
        return true;
    }
}
