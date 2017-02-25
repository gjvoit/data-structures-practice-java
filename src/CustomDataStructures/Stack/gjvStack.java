package CustomDataStructures.Stack;

/**
 * Created by Garet on 2/25/2017.
 * A stack implements a Last in, First out (LIFO) pattern.
 * A stack has only one element with which you can interact, the "top".
 * Key Methods include: push, pop, peek, size, isEmpty
 */
public class gjvStack {
    private int top;
    public gjvStack(int top) {
        this.top = top;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }
}
