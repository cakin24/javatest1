package com.atguigu.java.chapter02;


public class ClinitTest1 {
    static class Father {
        public static int A = 1;
        static {
            A = 2;
        }
    }

    static class Son extends Father {
        public static int b = A;
    }

    public static void main(String[] args) {
        // 加载 Father 类，其次加载 Son 类
        System.out.println(Son.b); // 2
    }
}
