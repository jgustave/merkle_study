package jd;

/**
 *
 */
public class Key {
    private final byte[] data = new byte[32];

    /**
     * Return 1(true) or 0(false) that represents the bitnumber bit in data
     * @param pos
     * @return
     */
    public boolean getBit(int pos ) {
        return(getBit(data, pos) == 1);
    }

    private static int getBit(byte[] data, int pos) {
       int posByte = pos/8;
       int posBit = pos%8;
       byte valByte = data[posByte];
       return valByte >> (8 - (posBit + 1)) & 0x0001;
    }
}
