package com.mashibing.singleton;

/**
 * 静态内部类方式
 * JVM保证线程安全
 * 加载外部类时，不会加载内部类，这样可以实现懒加载
 * @author: Yuanzt
 * @Date: 2021/3/8
 */
public class Mgr07 {

    private Mgr07(){}

    private static class Mgr07Holder{
        private final static Mgr07 INSTANCE = new Mgr07();
    }

    public static Mgr07 getInstance(){
        return Mgr07Holder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i =0;i<100;i++){
            new Thread(()-> System.out.println(Mgr07.getInstance().hashCode())).start();
        }
    }

}
