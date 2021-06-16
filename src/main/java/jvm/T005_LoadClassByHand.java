package jvm;

public class T005_LoadClassByHand {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = T005_LoadClassByHand.class.getClassLoader().loadClass("jvm.T001_ClassLoadLevel");
        System.out.println(clazz.getName());
    }
}
