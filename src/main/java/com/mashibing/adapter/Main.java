package com.mashibing.adapter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 转接器模式
 * @author: Yuanzt
 * @Date: 2021/3/18
 */
public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:/test.txt");
        //Adapter模式，中间BufferedReader就是Adapter模式
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        while (line != null && !line.equals("")){
            System.out.println(line);
        }
        br.close();
        isr.close();
        fis.close();
    }
}
