package com.atguigu.java.chapter02;

import sun.security.ec.CurveDB;

import java.net.URL;
import java.security.Provider;


public class ClassLoaderTest1 {
    public static void main(String[] args) {
        System.out.println("*********启动类加载器************");
        // 获取BootstrapClassLoader 能够加载的API的路径
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url.toExternalForm());
        }

        // 从上面路径中，随意选择一个类，来看看他的类加载器是什么：得到的是null，说明是根加载器
        ClassLoader classLoader = Provider.class.getClassLoader();
        System.out.println(classLoader); // null

        System.out.println("*********扩展类加载器************");
        String pathExt = System.getProperty("java.ext.dirs");
        System.out.println(pathExt.replaceAll(";",System.lineSeparator()));

        ClassLoader classLoader1 = CurveDB.class.getClassLoader();
        System.out.println(classLoader1); // sun.misc.Launcher$ExtClassLoader@31befd9f
    }
}
