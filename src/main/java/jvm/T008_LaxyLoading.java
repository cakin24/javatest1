package jvm;

public class T008_LaxyLoading {
    public static void main(String[] args) throws ClassNotFoundException {
        //P p; // a
        //X x= new X(); // b
        //System.out.println(P.i); // c
        //System.out.println(P.j); // d
        Class.forName("jvm.T008_LaxyLoading$P"); // e
    }

    public static class P{
        final static int i = 9;
        static int j = 10;
        static {
            System.out.println("加载 P 类");
        }
    }

    public static class X extends P{
        static {
            System.out.println("加载 X 类");
        }
    }
}
