package PracticeQuestions.LinkedLists;

import java.util.LinkedList;

/**
 * Created by Garet on 4/7/2017.
 */
public class LinkedListsImpl {
    public static void main(String[] args) {
        LinkedList<LinkedListNode> list = new LinkedList<LinkedListNode>();
        LinkedLists test = new LinkedLists();
        LinkedList<LinkedListNode> list2 = new LinkedList<LinkedListNode>();
        LinkedListNode node5 = new LinkedListNode(5);
        LinkedListNode node3 = new LinkedListNode(3);
        LinkedListNode node4 = new LinkedListNode(4);
        LinkedListNode node2 = new LinkedListNode(2);
        list.add(node4); list.add(node5); list2.add(node2); list2.add(node3);
        list2.addAll(list);
        System.out.println(list2.toString());
        node5.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node2);
        String str = "";
        LinkedListNode curr = node5;
        for (int i =0; i < 4; i++) {
            str += curr.getValue() + "->";
            curr = curr.getNext();
        }
        System.out.println(str);
        test.deleteMiddleNode(node4);
        str = "";
        curr = node5;
        for (int i =0; i < 3; i++) {
            str += curr.getValue() + "->";
            curr = curr.getNext();
        }
        System.out.println(str);


    }
}
