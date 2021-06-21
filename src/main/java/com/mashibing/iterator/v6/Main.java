package com.mashibing.iterator.v6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author: Yuanzt
 * @Date: 2021/3/17
 */
public class Main {

    public static void main(String[] args) {
        Collection<String> c = new LinkedList<>();
        for (int i=0;i<15;i++){
            c.add(new String("s"+i));
        }

        Iterator<String> it = c.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
