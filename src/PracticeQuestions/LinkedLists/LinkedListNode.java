package PracticeQuestions.LinkedLists;

/**
 * Created by Garet on 4/7/2017.
 */
public class LinkedListNode {
    private LinkedListNode next;
    private int value;
    LinkedListNode(int value) {
        this.value = value;
    }
    public LinkedListNode getNext() {
        return next;
    }
    public void setNext(LinkedListNode next) {
        this.next = next;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public String toString() {
        return value + "->";
    }
}
