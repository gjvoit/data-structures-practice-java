package CustomDataStructures.Tree;

/**
 * Created by Garet on 2/19/2017.
 */
public class gjvTree {
    private gjvTreeNode root;

    public gjvTree() {
        root = null;
    }

    // toString defaults to inOrderTraversal
    // TODO @gjvoit This is broken. Step through it when you get to Cleve.
    public String inOrderTraversal(gjvTreeNode currNode, String result) {
        if (currNode == null) return "";
        else {
            if (currNode.getLeft() != null) inOrderTraversal(currNode.getLeft(), result);
            result += currNode.getValue();
            if (currNode.getRight() != null)  inOrderTraversal(currNode.getRight(), result);
        }
        return result;
    }

    // Key methods - InsertNode, DeleteNode, InOrderTraversal, PreOrderTraversal, SearchNode
    // TODO Could make "value" a string instead of an int (allows for tests easily verified via print)
    // E.g. ((())) or (5+4)

    public gjvTreeNode getRoot() {
        return root;
    }

    public void setRoot(gjvTreeNode root) {
        this.root = root;
    }

    public void addAtRoot(gjvTreeNode newRoot) {
        newRoot.setLeft(root);
        root = newRoot;
    }

    public void addNode(gjvTreeNode newNode, gjvTreeNode rootNode) {
        // Value could be equal to root, less than root, or greater than root.
        // Equal case: do nothing, inform user of their mistake.
        // Less than case, recurse on curr.getLeft()
        // Greater than case, recurse on curr.getRight()
        if (newNode.getValue() == rootNode.getValue()) {
            System.out.println("Cannot insert node with duplicate value!");
            return;
        } else if (newNode.getValue() < rootNode.getValue()){
            // Check to see if we've reached a leaf where we can insert the node
            if (rootNode.getLeft() == null) {
                rootNode.setLeft(newNode);
                return;
            } else addNode(newNode, rootNode.getLeft());
        } else {
            if (rootNode.getRight() == null) {
                rootNode.setRight(newNode);
                return;
            } else addNode(newNode, rootNode.getRight());
        }
    }

    public gjvTreeNode searchNode(gjvTreeNode currNode, int valToFind) {
        // If currNode == null, return null or some arbitrary gjvTreeNode with a specific value e.g. -1000
        // Start at the root, if valToFind == current, return current node
        // If valToFind < currNode.getValue(), recurse on currNode.getLeft()
        // else recurse on currNode.getRight()
        if (currNode == null) return null;
        else if (currNode.getValue() == valToFind ) return currNode;
        else if (valToFind < currNode.getValue()) return searchNode(currNode.getLeft(), valToFind);
        else return searchNode(currNode.getRight(), valToFind);
    }

    public boolean deleteNode(int valToDelete) {
        if (root == null) return false;
        else {
            // Special case if root is the node we are looking for.
            if (root.getValue() == valToDelete) {
                gjvTreeNode tempRoot = new gjvTreeNode(0);
                tempRoot.setLeft(root);
                boolean result = root.remove(valToDelete, tempRoot);
                root = tempRoot.getLeft();
                return result;
            // Otherwise we are looking deeper in the tree, so call gjvTreeNode.remove on root and recurse.
            } else return root.remove(valToDelete, null);
        }
    }

}
