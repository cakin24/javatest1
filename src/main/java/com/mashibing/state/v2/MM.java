package com.mashibing.state.v2;

/**
 * @author: Yuanzt
 * @Date: 2021/3/19
 */
public class MM {
    String name;
    MMState state;

    public void smile(){
        state.smile();
    }

    public void cry(){
        state.cry();
    }

    public void say(){
        state.say();
    }
}
