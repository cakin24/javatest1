package jmm;

public final class WriteCombiningExt {

    private static final int ITERATIONS = Integer.MAX_VALUE;
    private static final int ITEMS = 1 << 24;
    private static final int MASK = ITEMS - 1;

    private static final byte[] array1 = new byte[ITEMS];
    private static final byte[] array2 = new byte[ITEMS];
    private static final byte[] array3 = new byte[ITEMS];
    private static final byte[] array4 = new byte[ITEMS];
    private static final byte[] array5 = new byte[ITEMS];
    private static final byte[] array6 = new byte[ITEMS];
    private static final byte[] array7 = new byte[ITEMS];
    private static final byte[] array8 = new byte[ITEMS];
    private static final byte[] array9 = new byte[ITEMS];
    private static final byte[] array10 = new byte[ITEMS];
    private static final byte[] array11 = new byte[ITEMS];
    private static final byte[] array12 = new byte[ITEMS];
    private static final byte[] array13 = new byte[ITEMS];
    private static final byte[] array14 = new byte[ITEMS];


    public static void main(final String[] args) {
        System.out.println(" SingleLoop duration (ns) = " + runCaseOne());
        System.out.println(" SplitLoop  duration (ns) = " + runCaseTwo());
    }

    public static long runCaseOne() {
        long start = System.nanoTime();
        int i = ITERATIONS;

        while (--i != 0) {
            int slot = i & MASK;
            byte b = (byte) i;
            array1[slot] = b;
            array2[slot] = b;
            array3[slot] = b;
            array4[slot] = b;
            array5[slot] = b;
            array6[slot] = b;
            array7[slot] = b;
            array8[slot] = b;
            array9[slot] = b;
            array10[slot] = b;
            array11[slot] = b;
            array12[slot] = b;
            array13[slot] = b;
            array14[slot] = b;
        }
        return System.nanoTime() - start;
    }

    public static long runCaseTwo() {
        long start = System.nanoTime();
        int i = ITERATIONS;
        while (--i != 0) {
            int slot = i & MASK;
            byte b = (byte) i;
            array1[slot] = b;
            array2[slot] = b;
            array3[slot] = b;
            array4[slot] = b;
            array5[slot] = b;
            array6[slot] = b;
            array7[slot] = b;
        }
        i = ITERATIONS;
        while (--i != 0) {
            int slot = i & MASK;
            byte b = (byte) i;
            array8[slot] = b;
            array9[slot] = b;
            array10[slot] = b;
            array11[slot] = b;
            array12[slot] = b;
            array13[slot] = b;
            array14[slot] = b;
        }
        return System.nanoTime() - start;
    }
}