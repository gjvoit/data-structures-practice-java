package CustomDataStructures.HashTable;

/**
 * Created by garetvoit on 3/21/17.
 */

public class HashNode implements Comparable {
    Integer key;
    Object value;

    public HashNode() {
        key = null;
        value = null;
    }

    public HashNode(int key, Object value) {
        this.key = key;
        this.value = value;
    }

    public int compareTo(Object compareTo) {
        if (key < (Integer) compareTo) return -1;
        else if (key == compareTo) return 0;
        else return 1;
    }

    public boolean equals(Object o) {
        return key == o;
    }

    public int getKey() { return key; }
    public Object getValue() { return value; }
    public void setKey(int key) { this.key = key; }
    public void setValue() { this.value = value; }
}
