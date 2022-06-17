package jd;

/**
 *
 */
public class InternalNode extends Node {

    //Left is 0
    private Node left = null;

    //Right is 1
    private Node right = null;

    public InternalNode () {
    }

    public InternalNode (Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    public void insert( LeafNode leaf ) {

    }

    public InternalNode getOrCreateRight () {
        if( right == null ){
            right = new InternalNode();
        }

        return( (InternalNode) right );
    }
    public InternalNode getOrCreateLeft () {
        if( left == null ){
            left = new InternalNode();
        }

        return( (InternalNode) left );
    }

    public void setLeft (Node left) {
        this.left = left;
    }

    public void setRight (Node right) {
        this.right = right;
    }
}
