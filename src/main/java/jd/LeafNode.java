package jd;

/**
 *
 */
public class LeafNode extends Node {

    private final String    value;
    private final long      sum;

    public LeafNode (String value, long sum) {
        this.value = value;
        this.sum = sum;
    }
}
