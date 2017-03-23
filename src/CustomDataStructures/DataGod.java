package CustomDataStructures;

import CustomDataStructures.*;
import CustomDataStructures.ArrayList.ArrayList;
import CustomDataStructures.HashTable.*;
import CustomDataStructures.Heap.Heap;

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
        System.out.println("myArrayList.search(11): " + myArrayList.search(11));
        System.out.println("myArrayList.removeRange(0,5): " + myArrayList.removeRange(0,5));
        System.out.println(myArrayList);
        */
        /* Heap Tests
        Heap myHeap = new Heap(10);
        System.out.println("myHeap root: " + myHeap.peek());
        myHeap.enqueue(11);
        System.out.println(myHeap.get(11));
        myHeap.enqueue(6);
        myHeap.enqueue(5);
        myHeap.enqueue(7);
        myHeap.enqueue(4);
        System.out.println(myHeap);
        myHeap.increasePriority(10, 3);
        System.out.println(myHeap);
        myHeap.decreasePriority(3, 10);
        System.out.println(myHeap);
        myHeap.enqueue(12);
        myHeap.enqueue(13);
        myHeap.enqueue(14);
        System.out.println(myHeap);
        myHeap.increasePriority(14,2);
        System.out.println(myHeap);
        myHeap.enqueue(15);
        myHeap.dequeue();
        System.out.println(myHeap);
        myHeap.decreasePriority(6, 9);
        System.out.println(myHeap);
        System.out.println(myHeap);
        System.out.println(myHeap.dequeue());
        System.out.println(myHeap);
        */
        /* Hash Table Tests */
        HashTable myHashTable = new HashTable();
        HashNode january = new HashNode(1, "January");
        HashNode february = new HashNode(2, "February");
        HashNode march = new HashNode(3, "March");
        HashNode june = new HashNode(6, "June");
        HashNode april = new HashNode(4, "April");
        HashNode may = new HashNode(5, "May");
        HashNode october = new HashNode(10, "October");
        HashNode december = new HashNode(12, "December");
        HashNode july = new HashNode(7, "July");
        HashNode august = new HashNode(8, "August");
        HashNode september = new HashNode(9, "September");
        HashNode november = new HashNode(11, "November");

        myHashTable.put(january);
        myHashTable.put(october);
        myHashTable.put(march);
        myHashTable.put(february);
        myHashTable.put(april);
        myHashTable.put(august);
        myHashTable.put(june);
        myHashTable.put(july);
        myHashTable.put(september);
        myHashTable.put(november);
        myHashTable.put(december);
        myHashTable.put(may);

//        System.out.println(myHashTable);
        String hashOutput = "hashOutput after add, before remove:\n";
        for (int i=1;i<13; i++) {
            hashOutput += "[" + i + "]: " + myHashTable.get(i).getValue() + " ";
        }
        System.out.println(myHashTable);
        for (int j=1; j<13; j++) {
            myHashTable.remove(j);
        }
        System.out.println(myHashTable);
    }
}
