package CustomDataStructures.HashTable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Garet on 3/2/2017.
 * Key methods: put, remove, size, get
 * Average runtimes: Insert O(1), Delete O(1), Search O(1)
 * Worst case runtimes: Insert O(n), Delete O(n), Search O(n)
 */
public class HashTable {



    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private ArrayList<LinkedList> map;
    private int size;
    private int capacity;

    public HashTable() {
         map = new ArrayList<LinkedList>(DEFAULT_INITIAL_CAPACITY);
         size = 0;
         for (int i=0; i < DEFAULT_INITIAL_CAPACITY; i++) {
             map.add(i, new LinkedList());
         }
         capacity = DEFAULT_INITIAL_CAPACITY;
    }

    public String toString() {
        String returnString = "[";
        for (int i=0; i < DEFAULT_INITIAL_CAPACITY; i++) {
            returnString += "\n  [";
            for (int j=0; j < map.get(i).size(); j++) {
                returnString += "\n    [" + j + "]: " + ((HashNode) map.get(i).get(j)).getValue();
            }
            returnString += "\n  ]";
        }
        returnString += "\n]";
        return returnString;
    }

    public int getSize() { return size; }

    /**
     *
     * @param objectToInsert The object to add to the associated LinkedList.
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public void put(HashNode objectToInsert) {
        int hash = objectToInsert.getKey() % 10;
        size++;
        map.get(hash).addLast(objectToInsert);
    }

    /**
     *
     * @param keyToGet Key to compare to while iterating through the associated LinkedList.
     * @return HashNode
     * Worst case Time Complexity: O(n), as all items could collide on a single hash value, resulting in the worst case runtime of a LinkedList.
     * Average Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public HashNode get(int keyToGet) {
        int hash = keyToGet % 10;
        HashNode curr = null;
        for (int i=0; i < map.get(hash).size(); i++) {
            curr = (HashNode) map.get(hash).get(i);
            if (curr.getKey() == keyToGet) return curr;
        }
        return curr;
    }

    /**
     *
     * @param keyToRemove Key to compare to while iterating through the associated LinkedList.
     * My worst case runtime is O(3n), due to my LinkedList implementation and my lack of proper implementation of .equals for HashNodes.
     * However, Time Complexity still reduces to O(n).
     * This could be improved upon by a factor of 3, but I will leave it as is for now, as I have achieved my goal of
     * refreshing my memory on Hash Maps (Hash Tables).
     * Space Complexity: O(1)
     */
    public boolean remove(Integer keyToRemove) {
        int hash = keyToRemove % 10;
        if (map.get(hash) == null) return false;
        HashNode curr;
        for (int index = 0; index < map.get(hash).size(); index++) {
            curr = (HashNode) map.get(hash).get(index);
            if (curr.getKey() == keyToRemove) {
                map.get(hash).remove(index);
                return true;
            }
        }
        return false;
    }
}
