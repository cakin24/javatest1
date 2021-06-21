package com.mashibing.strategy;

/**
 * 选择排序
 * @author: Yuanzt
 * @Date: 2021/3/8
 */
public class Sorter<T> {

    public void sort(T[] arr,Comparator<T> comparator){
        for (int i = 0;i<arr.length;i++){
            int minpos = i;
            for (int j=i+1;j<arr.length; j++){
                minpos = comparator.compare(arr[j],arr[minpos]) == -1 ? j : minpos;
            }
            swap(arr,i,minpos);
        }
    }

    void swap(T[] arr,int i,int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
