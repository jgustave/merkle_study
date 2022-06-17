package jd;

/**
 *
 */
public class Utils {

    //because the key is 32 Bytes, 2^256 combinations
    public static final int NUM_LEVELS = 256;
    public static final int HASH_SIZE  = 32;

    //For each of the 255 levels, precompute empty hash[32]
    private final static byte[][] PRE_COMPUTED_HASHES = new byte[NUM_LEVELS][HASH_SIZE];

    static {
        for( int x=0;x<NUM_LEVELS;x++) {
            if( x==0 ) {
                PRE_COMPUTED_HASHES[x] = new byte[32]; //TODO: not sure about this.. 0?
            }else {
                PRE_COMPUTED_HASHES[x] = digest(PRE_COMPUTED_HASHES[x - 1], PRE_COMPUTED_HASHES[x - 1], 0);
            }
        }
    };

//    byte[] digest(String foo) {
//        return new byte[HASH_SIZE]; //TODO: actual hash
//    }

    static byte[] digest(byte[] left, byte[] right, long sum ) {
        return new byte[HASH_SIZE]; //TODO: actual hash
    }


    /**
     * We pre-compute the Hash for each level if empty
     * @param Level
     * @return
     */
    public static byte[] getEmptyHash(int level) {
        return( PRE_COMPUTED_HASHES[level] );
    }

}
