
package com.mashibing.juc.c_002;

public class T {
    private int count = 10;

    public void m() {
        synchronized (this) { // 任何线程要执行下面的代码，必须先拿到 this 的锁，锁定当前对象
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }
}

