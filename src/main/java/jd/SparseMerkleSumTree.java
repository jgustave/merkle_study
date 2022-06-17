package jd;

import static jd.Utils.NUM_LEVELS;

/**
 * This is not a compact (trie) version. Will do that next.
 */
public class SparseMerkleSumTree {

    private InternalNode root = new InternalNode();


    //TODO: need to abstract out the tree. getNode() etc so that we could store on disk etc.
    //Thinking ahead... around locking, the contention for 255 things in a tree would be nasty.
    //More like 1 writer at a time.

    //TODO: value and sum?
    void insert(Key key, String value, long sum ) {
        InternalNode[]  path        = new InternalNode[NUM_LEVELS];
        InternalNode    currentNode = root;

        for( int x=0;x<255;x++) { //Save one bit till the end for the leaf node

            boolean currentBit = key.getBit(x);
            if( currentBit ) {
                //Go right
                currentNode = currentNode.getOrCreateRight();
            }else {
                currentNode = currentNode.getOrCreateLeft();
                //Go Left
            }
            path[x] = currentNode; //Save the Path from the root.
        }

        //currentNode is now pointing at the last InternalNode before
        boolean lastBit = key.getBit(255);

        //TODO: allow overwrite? check if exists exception etc

        //TODO: We might need to save the path to update the hashes up the tree

        LeafNode leafNode = new LeafNode(value, sum);

        if( lastBit ) {
            currentNode.setRight(leafNode);
        }else {
            currentNode.setLeft(leafNode);
        }

        for( int x=255;x>=0;x--) {
            //TODO: walk back up the tree and update hashes.
            path[x].updateHashAndSum();
        }

    }


    void remove(String key) {

    }

    //TODO: inclusion Proof

    //TODO: exclusion Proof
}
