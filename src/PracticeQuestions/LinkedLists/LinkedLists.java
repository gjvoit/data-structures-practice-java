package PracticeQuestions.LinkedLists;

import java.util.LinkedList;

/**
 * Created by Garet on 4/7/2017.
 */
public class LinkedLists {

    void deleteMiddleNode(LinkedListNode n) {
        if (n == null || n.getNext() == null) return;
        n.setValue(n.getNext().getValue());
        n.setNext(n.getNext().getNext());
    }

    public void toString(LinkedListNode n) {
        String retString = "";
        while (n != null) {
            System.out.println(n.getValue() + "->");
        }
    }
}
