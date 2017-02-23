package CustomDataStructures.Tree;

/**
 * Created by Garet on 2/19/2017.
 */
public class gjvTreeNode {
    private gjvTreeNode left;
    private gjvTreeNode right;
    private int value;

    public gjvTreeNode(int value) {
        this.value = value;
        left = null;
        right = null;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return " (" + value + ")\n" +
                " / \\ ";
    }

    public boolean remove(int valToDelete, gjvTreeNode parent) {
        // Check if we should recurse left.
        if (this.getValue() > valToDelete) {
            if (this.getLeft() != null)
                return this.getLeft().remove(valToDelete, this);
            else return false;
        // Check if we should recurse right.
        } else if (this.getValue() < valToDelete) {
            if (this.getRight() != null)
                return this.getRight().remove(valToDelete, this);
            // If the node has no children, and the value hasn't been found, the node doesn't exist in the tree, return false.
            else return false;
        }
        // We know value is neither greater than nor less than this.getValue() and we know "this" is not null, so we must have found the node to be removed.
        // Now we must check the three cases
        else {
            // Case 1: Two children - find min of right subtree, replace current with that value, delete that duplicate.
            if (this.getLeft() != null && this.getRight() != null) {
                this.setValue(this.getRight().minValue());
                this.getRight().remove(this.getValue(), this);
            } else if (parent.getLeft() == this) {
                // Case 3b: Left child of parent is a leaf node (i.e. has no children)
                if (this.getLeft() == null && this.getRight() == null)
                    parent.setLeft(null);
                else
                    // Case 2a: 1 Child, and need to update parent.left to point to that child.
                    parent.setLeft((this.getLeft() != null) ? this.getLeft() : this.getRight());
            } else if (parent.getRight() == this) {
                // Case 3b: Right child of parent is a leaf node (i.e. has no children)
                if (this.getLeft() == null && this.getRight() == null)
                    parent.setRight(null);
                else
                    // Case 2b: 1 Child, and need to update parent.right to point to that child.
                    parent.setRight((this.getRight() != null) ? this.getRight() : this.getLeft());
            }
        }
        return true;
    }

    public int minValue() {
        if (left == null) {
            return this.value;
        } else return left.minValue();
    }

    public void setValue(int value) {
        this.value = value;
    }

    public gjvTreeNode getLeft() {
        return left;
    }

    public void setLeft(gjvTreeNode left) {
        this.left = left;
    }

    public gjvTreeNode getRight() {
        return right;
    }

    public void setRight(gjvTreeNode right) {
        this.right = right;
    }
}
