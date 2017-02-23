package CustomDataStructures.LinkedList;

/**
 * Created by Garet on 2/10/2017.
 */

public class SinglyLinkedList {
    private SinglyLinkedListEntry head;
    private SinglyLinkedListEntry tail;

    public SinglyLinkedList() {
        head = null;
        tail = null;
    }

    public String toString() {
        SinglyLinkedListEntry curr = head;
        String response = "Current state of your list: ";
        if (head == null) return response + "null";
        if (head == tail) return response + head.toString() + "null";
        while (curr != null) {
            response += curr.toString();
            curr = curr.getNext();
        }
        return response + "null";
    }

    public int size() {
        SinglyLinkedListEntry curr = head;
        int i = 0;
        while (curr != null) {
            i++;
            curr = curr.getNext();
        }
        return i;
    }

    // Potential methods: insertAtTail, insertAtFront, insertAtIndex

    public void addLast(SinglyLinkedListEntry entry) {
        // 0 Items in list
        if (entry == null) return;
        else if (head == null) {
            this.setHead(entry);
            this.setTail(entry);
        } else {
            // Any other time, you update SinglyLinkedListEntry.next of current SinglyLinkedListEntry referenced by "tail" to point to the new SinglyLinkedListEntry, update tail
            tail.setNext(entry);
            this.setTail(entry);
        }
    }

    public void addFirst (SinglyLinkedListEntry entry) {
        if (head == null) {
            // entry.setNext(null);
            this.setHead(entry);
            this.setTail(entry);
        } else {
            entry.setNext(head);
            head = entry;
        }
    }

    public void addAtIndex(SinglyLinkedListEntry entry, int index) {
        SinglyLinkedListEntry prev = null;
        SinglyLinkedListEntry curr = head;
        if (head == null) {
            head = entry;
            tail = entry;
            return;
        }
        // Eliminate tail edge case by checking to see if index is >= index of tail
        if (index >= this.size()) {
            this.addLast(entry);
            System.out.println("Successfully inserted in \"tail\" case");
            return;
        }
        for (int i=0; i<this.size(); i++) {
            if (i == index) {
                // Once we find the spot to insert, what do we do?
                // We need to update prev.next to point to "entry" (the node we're inserting)
                // We need "entry".next to point to curr.
                // Done.
                if (index == 0) {
                    addFirst(entry);
                    System.out.println("Successfully inserted in \"head\" case");
                    return;
                } else {
                    // We've found the index where we want to insert and have verified that it's not the head.
                    // We've also eliminated the "tail" case
                    // Now just have to deal with general case.
                    prev.setNext(entry);
                    entry.setNext(curr);
                    System.out.println("Successfully inserted in general case");
                    return;
                }
            } else {
                prev = curr;
                curr = curr.getNext();
//                System.out.println("Checking pass by reference vs pass by copy... prev.equals(curr): " + (prev.getValue() == curr.getValue()));
            }
        }
    }

    public boolean contains(int i) {
        // I move through the list by looking at curr.next
        // I check to see if head is null, if head is not null, I use head as my initial "current"
        // I stop when curr.next is null
        SinglyLinkedListEntry curr = this.getHead();
        while (curr != null) {
            if (curr.getValue() == i) return true;
            else curr = curr.getNext();
        }
        return false;
    }

    public SinglyLinkedListEntry getSinglyLinkedListEntry(int entry) {
        SinglyLinkedListEntry curr = this.getHead();
        while(curr != null) {
            if (curr.getValue() == entry) return curr;
            else curr = curr.getNext();
        }
        return null;
    }

    // TODO Add getSinglyLinkedListEntryAtIndex
    public SinglyLinkedListEntry getSinglyLinkedListEntryAtIndex(int index) {
        SinglyLinkedListEntry curr = this.getHead();
        if (this.getHead() == null) {
            System.out.println("List is empty! Try adding some items to the list with addFirst, addLast, or addAtIndex!");
            return null;
        }
        if (index >= this.size()) {
            System.out.println("Index larger than size of list! Try a lower index, or add more items to the list!");
            return null;
        }
        int i = 0;
        while (curr != null) {
            if (i == index) {
                return curr;
            } else {
                curr = curr.getNext();
                i++;
            }
        }
        return null;
    }

    // Interesting bit here is deciding what determines equality (finding the 'matching' node that you want to delete)
    // In my case, I'll just assume no two nodes have the same 'value' and search until I find that value.
    // If I don't find it, simply don't delete anything.
    public void removeHead() {
        if (head.getValue() == tail.getValue()) {
            head = null;
            tail = null;
        } else head = head.getNext();
    }

    public SinglyLinkedListEntry getHead() {
        return head;
    }

    public void setHead(SinglyLinkedListEntry head) {
        this.head = head;
    }

    public SinglyLinkedListEntry getTail() {
        return tail;
    }

    public void setTail(SinglyLinkedListEntry tail) {
        this.tail = tail;
    }
}
