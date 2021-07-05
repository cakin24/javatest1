package jvm;

public class T011_ClassReloading1 {
    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class clazz = myClassLoader.loadClass("jvm.Log");
        System.out.println(clazz.hashCode());

        myClassLoader = new MyClassLoader();
        Class clazz1 = myClassLoader.loadClass("jvm.Log");
        System.out.println(clazz1.hashCode());

        System.out.println(clazz == clazz1);
    }
}
