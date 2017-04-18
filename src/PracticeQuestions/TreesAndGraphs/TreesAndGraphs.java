package PracticeQuestions.TreesAndGraphs;

import CustomDataStructures.Tree.gjvTree;
import CustomDataStructures.Tree.gjvTreeNode;

/**
 * Created by Garet on 4/15/2017.
 */
public class TreesAndGraphs {
    public gjvTree createBST(int[] sorted) {
        gjvTree result = new gjvTree();
        if (sorted.length == 0) return result;
        int mid = sorted.length / 2;


        return new gjvTree();
    }
    private gjvTree createBSTRecurse(gjvTree result, int[] sorted, int mid) {
        gjvTreeNode addThis = new gjvTreeNode(sorted[mid]);
        result.addNode(addThis, result.getRoot());
        return result;
    }
}
