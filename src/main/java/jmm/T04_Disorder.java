package jmm;

public class T04_Disorder {
    private static int a = 0, b = 0;
    private static int x = 0, y = 0;

    public static void main(String[] args) throws Exception {
        int i = 0;
        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    x = b;
                }
            });
            Thread other = new Thread(new Runnable() {
                @Override
                public void run() {
                    b = 1;
                    x = a;
                }
            });
            one.start();
            other.start();
            one.join();
            other.join();
            String result = "第" + i + "次(" + x + "," + y + ")";
            if (x == 0 && y == 0) {
                System.out.println(result);
            } else {
            }
        }
    }
}
