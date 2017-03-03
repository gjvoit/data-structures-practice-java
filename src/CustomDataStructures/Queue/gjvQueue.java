package CustomDataStructures.Queue;

import CustomDataStructures.LinkedList.SinglyLinkedList;
import CustomDataStructures.LinkedList.SinglyLinkedListEntry;
import java.util.ArrayList;


/**
 * Created by Garet on 2/28/2017.
 * A queue implements a First in, First out (FIFO) pattern.
 * A queue has only one element with which you can interact, the "front".
 * Key methods: enqueue, dequeue, isEmpty, peek, count
 */
public class gjvQueue {
    private Integer front;
    private ArrayList<Integer> queue;
    private int count;

    public int getCount() {
        return count;
    }

    public gjvQueue() {
        this.front = null;
        queue = new ArrayList<Integer>();
        count = 0;
    }

    public gjvQueue(Integer front) {
        this.front = front;
        queue = new ArrayList<Integer>();
        queue.add(0, front);
        count = 1;
    }

    /*
     * enqueue - Returns true if the element was inserted successfully, otherwise returns false.
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public boolean enqueue(Integer newBack) {
        try {
            if (isEmpty()) {
                front = newBack;
            }
            count++;
            queue.add(0, newBack);
            return true;
        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
    }

    /*
     * dequeue - If the queue is not empty, removes the front item, and returns it, otherwise returns null.
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public Integer dequeue() {
        if (isEmpty()) return null;
        else if (count == 1) {
            Integer intToDequeue = front;
            front = null;
            count--;
            return intToDequeue;
        }
        else {
            Integer intToDequeue = front;
            queue.remove(count-1);
            count--;
            front = queue.get(count-1);
            return intToDequeue;
        }
    }

    /*
     * enqueue - Returns the item that would be removed if dequeue() were called (aka the "front").
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public Integer peek() {
        return front;
    }

    /*
     * isEmpty - Returns true if the list is empty, otherwise returns false.
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public boolean isEmpty() {
        return front == null;
    }
}
