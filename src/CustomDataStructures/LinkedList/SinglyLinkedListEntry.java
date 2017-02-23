package CustomDataStructures.LinkedList;

/**
 * Created by Garet on 2/10/2017.
 */
public class SinglyLinkedListEntry {
    private int value;
    private SinglyLinkedListEntry next;

    public String toString() {
        return "( " + value + " )" + " --> ";
    }

    public SinglyLinkedListEntry(int value) {
        this.value = value;
        next = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public SinglyLinkedListEntry getNext() {
        return next;
    }

    public void setNext(SinglyLinkedListEntry next) {
        this.next = next;
    }
}
