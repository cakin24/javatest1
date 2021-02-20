package com.itheima.pattern.bridge;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: TODO(一句话描述该类的功能)
 * @Author: cakin
 */
public class Client {
    public static void main(String[] args) {
        //创建mac系统对象
        OpratingSystem system = new Mac(new AviFile());
        //使用操作系统播放视频文件
        system.play("战狼3");
    }
}
