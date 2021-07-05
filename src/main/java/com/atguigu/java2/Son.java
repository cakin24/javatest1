package com.atguigu.java2;

/**
 * 解析调用中非虚方法、虚方法的测试
 * invokestatic 指令和 invokespecial 指令调用的方法称为非虚方法
 */
class Father {
    public Father() {
        System.out.println("father的构造器");
    }

    public static void showStatic(String str) {
        System.out.println("father " + str);
    }

    public final void showFinal() {
        System.out.println("father show final");
    }

    public void showCommon() {
        System.out.println("father 普通方法");
    }
}

public class Son extends Father {
    public Son() {
        // invokespecial
        super(); // 非虚方法
    }

    public Son(int age) {
        // invokespecial
        this(); // 非虚方法
    }

    // 不是重写的父类的静态方法，因为静态方法不能被重写！
    public static void showStatic(String str) {
        System.out.println("son " + str);
    }

    private void showPrivate(String str) {
        System.out.println("son private" + str);
    }

    public void show() {
        // invokestatic
        showStatic("atguigu.com");  // 非虚方法
        // invokestatic
        super.showStatic("good!"); // 非虚方法
        // invokespecial
        showPrivate("hello!"); // 非虚方法
        //invokespecial
        super.showCommon(); // 非虚方法

        // invokevirtual
        showFinal(); // 因为此方法声明有 final，不能被子类重写，所以也认为此方法是非虚方法。

        // 虚方法如下：
        // invokevirtual
        showCommon(); // 虚方法
        info(); // 虚方法

        MethodInterface in = null;
        // invokeinterface
        in.methodA(); // 虚方法
    }

    public void info() {
    }

    public void display(Father f) {
        f.showCommon();
    }

    public static void main(String[] args) {
        Son so = new Son();
        so.show();
    }
}

interface MethodInterface {
    void methodA();
}
