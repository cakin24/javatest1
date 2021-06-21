package com.mashibing.strategy;

import java.util.Arrays;

/**
 * @author: Yuanzt
 * @Date: 2021/3/8
 */
public class Main {

    public static void main(String[] args) {
//        int[] a = {9,2,3,5,7,1,4};
//        Dog[] a = {new Dog(1),new Dog(4),new Dog(3),new Dog(0)};
        Cat[] a = {new Cat(1,1),new Cat(5,5),new Cat(3,3),new Cat(9,9)};
        Sorter<Cat> sorter = new Sorter<>();
//        sorter.sort(a, new Comparator<Cat>() {
//            @Override
//            public int compare(Cat t1, Cat t2) {
//                if (t1.weight<t2.weight) return -1;
//                else if (t1.weight > t2.weight) return 1;
//                else return 0;
//            }
//        });
        sorter.sort(a,(t1,t2)->{
            if (t1.weight<t2.weight) return 1;
            else if (t1.weight>t2.weight) return -1;
            else return 0;
        });
        System.out.println(Arrays.toString(a));
    }

}
