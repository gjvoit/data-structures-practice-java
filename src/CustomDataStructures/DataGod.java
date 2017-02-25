package CustomDataStructures;

import CustomDataStructures.LinkedList.SinglyLinkedList;
import CustomDataStructures.LinkedList.SinglyLinkedListEntry;
import CustomDataStructures.Tree.gjvTree;
import CustomDataStructures.Tree.gjvTreeNode;

/**
 * Created by Garet on 2/19/2017.
 */
public class DataGod {
    public static void main(String[] args) {
        System.out.println("Welcome to the land of data structures.");
        SinglyLinkedList myList = new SinglyLinkedList();
        for (int i = 0; i < 10; i++) {
            SinglyLinkedListEntry entry = new SinglyLinkedListEntry(i);
            myList.addLast(entry);
        }
        System.out.println("Behold... a list with 10 elements! \n\n" + myList.toString());
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
        //
        try {
            System.out.println(myTree.searchNode(myTree.getRoot(), 12));
        }
        catch (Exception e) {
            System.out.println("Null value returned from searchNode, value is not in tree.");
        }
//        System.out.println(myTree.searchNode(myTree.getRoot(), 10));
//        System.out.println(myTree.deleteNode(10));
//        System.out.println(myTree.getRoot());
        System.out.println(myTree.preOrderTraversal(myTree.getRoot(), "Pre-order traversal: "));
        System.out.println(myTree.inOrderTraversal(myTree.getRoot(), "In-order traversal: "));
        System.out.println(myTree.postOrderTraversal(myTree.getRoot(), "Post-order traversal: "));
    }
}
