// Note: requires Java 11 or above

public class BSTTree {
    private Node tree = null;

    private static class Node {  //All private so can't be access outside the class & static for this (and all) subclasses
        private int val;
        private Node left, right;

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        private Node(){
            throw new Error("This constructor should never be called"); // Without this the default one is called
        }

        // This is just a helper method for pretty printing a tree
        private String toString(int indent) {
            String indentStr = "    ";

            String ret = "";
            if (left == null)
                ret += indentStr.repeat(indent + 1) + "null" + "\n";
            else
                ret += left.toString(indent + 1);
            ret += indentStr.repeat(indent) + val + "\n";
            if (right == null)
                ret += indentStr.repeat(indent + 1) + "null" + "\n";
            else
                ret += right.toString(indent + 1);
            return ret;
        }
    }

    public void insert(int v) {
        if (tree == null)
            tree = new Node(v, null, null);
        else
            insert(v, tree);
    }

    private void insert(int v, Node ptr) {  //this is a private helper method
        if (v < ptr.val) {
            if (ptr.left == null)
                ptr.left = new Node(v, null, null);
            else
                insert(v, ptr.left);
        } else if (v > ptr.val) {
            if (ptr.right == null)
                ptr.right = new Node(v, null, null);
            else
                insert(v, ptr.right);
        } else
            throw new Error("Value already in tree");
    }

    public String toString() {
        return tree == null ? "Empty" : tree.toString(0);
        /*tree == null can be replaced with isEmpty
        * helps prevent future changes, if e.g. isEmpty changes
        * however it leads to another method call which is a bit less efficient
        * return isEmpty() ? "Empty" : tree.toString(0);  */
    }

    public boolean isEmpty(){
        return tree == null;
    }

    public int getMax(){
        return getMax(tree); // calls another private method
    }

    private int getMax(Node ptr){
        if (ptr.right == null){
            return ptr.val;
        } //can put else here but not needed
        return getMax(ptr.right);
    }

    public static void main(String[] args) {
        BSTTree tree = new BSTTree();
        tree.insert(20);
        tree.insert(10);
        tree.insert(15);
        tree.insert(30);
        tree.insert(40);
        tree.insert(25);
        tree.insert(12);
        tree.insert(100);
        System.out.println(tree);
        System.out.println("Max is: " + tree.getMax());
    }
}
