package CustomDataStructures.LinkedList;

/**
 * Created by Garet on 2/10/2017.
 */
public class LinkedListCreator {
    public static void main(String[] args) {
        SinglyLinkedList myList = new SinglyLinkedList();
        SinglyLinkedList myList2 = new SinglyLinkedList();

        // Add some data to our list
        for (int i =0; i < 5; i++) {
            SinglyLinkedListEntry entry = new SinglyLinkedListEntry(i);
            myList.addLast(entry);
        }



        System.out.println("Head after initial insertion: " + myList.getHead().getValue());
        System.out.println("Size after initial insertion: " + myList.size());
        System.out.println("Contains 4? " + myList.contains(4));
        myList.removeHead();
        System.out.println("What is the new head? " + myList.getHead().getValue());
        SinglyLinkedListEntry entry12 = new SinglyLinkedListEntry(12);
        SinglyLinkedListEntry entry13 = new SinglyLinkedListEntry(13);
        SinglyLinkedListEntry entrynegative5 = new SinglyLinkedListEntry(-5);
        System.out.println(myList.size());
        System.out.println("Before addAtIndex: " + myList.size());
        myList.addAtIndex(entry12, 12);
        myList.addAtIndex(entrynegative5, 0);
        myList.addAtIndex(entry13, 4);
        System.out.println("After addAtIndex: " + myList.size());
        System.out.println("SinglyLinkedListEntry at index 5: " + myList.getSinglyLinkedListEntryAtIndex(6).getValue());
        System.out.println("SinglyLinkedListEntry at index 0: " + myList.getSinglyLinkedListEntryAtIndex(0).getValue());
    }
}
