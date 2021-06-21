package com.mashibing.iterator.v4;

/**
 * @author: Yuanzt
 * @Date: 2021/3/17
 */
public class Main {

    public static void main(String[] args) {
        Collection_ list = new ArrayList_();
        for (int i=0;i<15;i++){
            list.add(new String("s"+i));
        }
        System.out.println(list.size());
        ArrayList_ al = (ArrayList_) list;
        for (int i=0;i<al.size();i++){

        }
    }
}
