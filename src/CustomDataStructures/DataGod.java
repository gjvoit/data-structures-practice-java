package CustomDataStructures;

import CustomDataStructures.*;
import CustomDataStructures.ArrayList.ArrayList;

/**
 * Created by Garet on 2/19/2017.
 */
public class DataGod {
    public static void main(String[] args) {
        System.out.println("Welcome to the land of data structures.");
        /* SinglyLinkedList Tests
        SinglyLinkedList myList = new SinglyLinkedList();
        for (int i = 0; i < 10; i++) {
            SinglyLinkedListEntry entry = new SinglyLinkedListEntry(i);
            myList.addLast(entry);
        }
        System.out.println("Behold... a list with 10 elements! \n\n" + myList.toString());
        */
        /* Binary Tree Tests
        System.out.println("Time for a Binary Tree!");
        gjvTree myTree = new gjvTree();
        gjvTreeNode myTreeNode = new gjvTreeNode(10);
        myTree.addAtRoot(myTreeNode);
        gjvTreeNode myTreeNode3 = new gjvTreeNode(13);
        gjvTreeNode myTreeNode5 = new gjvTreeNode(12);
        gjvTreeNode myTreeNode2 = new gjvTreeNode(11);
        gjvTreeNode myTreeNode9 = new gjvTreeNode(9);
        myTree.addNode(myTreeNode2, myTree.getRoot());
        myTree.addNode(myTreeNode3, myTree.getRoot());
        myTree.addNode(myTreeNode5, myTree.getRoot());
        myTree.addNode(myTreeNode9, myTree.getRoot());
        try {
            System.out.println(myTree.searchNode(myTree.getRoot(), 12));
        }
        catch (Exception e) {
            System.out.println("Null value returned from searchNode, value is not in tree.");
        }
        System.out.println(myTree.preOrderTraversal(myTree.getRoot(), "Pre-order traversal: "));
        System.out.println(myTree.inOrderTraversal(myTree.getRoot(), "In-order traversal: "));
        System.out.println(myTree.postOrderTraversal(myTree.getRoot(), "Post-order traversal: "));
        */
        /* Stack Tests
        SinglyLinkedListEntry entry1 = new SinglyLinkedListEntry(30);
        gjvStack myStack = new gjvStack(entry1);
        for (int i =0; i < 10; i++) {
            SinglyLinkedListEntry entry = new SinglyLinkedListEntry(i);
            myStack.push(entry);
        }
        System.out.println(myStack.search(8, new gjvStack(), 0));
        for (int i = 9; i > -1; i--) {
            System.out.println("Top is: " + myStack.peek());
            System.out.println("Top is " + i + ": " + (myStack.peek().getValue()==i));
            myStack.pop();
        }
        System.out.println("Top is: " + myStack.peek());
        System.out.println("Top is " + 30 + ": " + (myStack.peek().getValue()==30));
        System.out.println(myStack.size());
        myStack.pop();
        System.out.println(myStack.size());
        System.out.println("Top is null: " + (myStack.peek() == null));
        */
        /* Queue Tests
        Integer int1 = 5;
        gjvQueue myQueue = new gjvQueue(int1);
        System.out.println("Peek should return 5: " + myQueue.peek());
        for (int i=0; i < 5; i++) {
            System.out.println("myQueue.count(): " + myQueue.getCount());
            Integer nextInt = i;
            myQueue.enqueue(nextInt);
            System.out.println("myQueue.peek() should be " + 5 + ": " + myQueue.peek());
        }
        System.out.println("myQueue.peek() should be " + 5 + ": " + myQueue.peek());
        System.out.println("myQueue.dequeue() should return 5: " + myQueue.dequeue());
        for (int i=0; i < 5; i++) {
            System.out.println("myQueue.dequeue() should return " + i + ":" + myQueue.dequeue());
        }
        System.out.println("myQueue.dequeue() should return null: " + myQueue.dequeue());
        */
        /* ArrayList Tests
        ArrayList myArrayList = new ArrayList();
        for (int i=0; i<12; i++) {
            Integer myInt = i;
            myArrayList.add(i);
            System.out.println("myArrayList.size(): " + myArrayList.size());
            System.out.println("myArrayList.capacity: " + myArrayList.myStore.length);
            System.out.println("Element " + myArrayList.get(i) + " added at index: " + i);
        }
        System.out.println(myArrayList);
        for (int i=0; i<12; i++) {
            System.out.println(myArrayList.remove(0));
        }
        System.out.println(myArrayList);
        */
        /* Vector Tests */
        
    }
}
