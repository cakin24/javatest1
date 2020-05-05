/**
 * Copyright (C), 2020-2020, 软件公司
 * FileName: Main.java
 * Author:   cakin
 * Date:     2020/5/3
 * Description: 
 */
import java.util.HashMap;
import java.util.List;

import static org.apache.xmlbeans.impl.store.Public2.test;

/**
 * @className: Main
 * @description: TODO
 * @date: 2020/5/3
 * @author: cakin
 */
public class Main {
    
    /**
     * 功能描述：
     *
     * @author cakin
     * @date 2020/5/3
     * @param 
     * @return 
     * @description:
     */
    public static void main( String[] args ) {
        System.out.println("a1");
        System.out.println("a2");
        System.out.println("a3");
        System.out.println("a4");
        int a = 1;
        if(a == 2)
        {
            throw new IndexOutOfBoundsException();
        }
        System.out.println("a5");
        System.out.println("a6");
        testdebug();
    }

    private static void testdebug() {
        System.out.println("a1");
        System.out.println("a2");
        System.out.println("a3");
        System.out.println("a4");
        int a = 1;
        if(a == 1)
        {
            throw new IndexOutOfBoundsException();
        }
        System.out.println("a5");
        System.out.println("a6");
    }
}