package com.atguigu.java.chapter02;

public class ClassLoaderTest2 {
    public static void main(String[] args) {
        try {
            // 获取当前类的ClassLoader
            ClassLoader classLoader = Class.forName("java.lang.String").getClassLoader();
            System.out.println(classLoader);

            // 获取当前线程上下文的ClassLoader
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            System.out.println(contextClassLoader);

            // 获取系统的ClassLoader
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader().getParent();
            System.out.println(systemClassLoader);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
