/**
 * Copyright (C), 2020-2020, 软件公司
 * FileName: Local
 * Author:   cakin
 * Date:     2020/4/25
 * Description: 简单本地发送异步消息的类
 */
package asymsg;

import GPer.Teacher;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;


/**
 * @ClassName: Local
 * @Description: 简单本地发送异步消息的类
 * @Date: 2020/4/25
 * @Author: cakin
 */
@Slf4j
public class Local implements CallBack, Runnable {

    /**
     * 远程接收消息的类，模拟point-to-point
     */
    private Remote remote;

    /**
     * 发送出去的消息
     */
    private String message;

    public Local( Remote remote, String message ) {
        super();
        this.remote = remote;
        this.message = message;
    }

    public Local() {
    }

    /**
     * @className: Local
     * @description: 发送消息
     * @date: 2020/4/25
     * @author: cakin
     */
    public void sendMessage() {
        /**
         * 当前线程的名称
         */
        log.info("1:" + Thread.currentThread().getName());
        /**
         * 创建一个新的线程发送消息
         */
        SendThead thread = new SendThead("SendThead");
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException( Thread t, Throwable e ) {
                log.info(thread.getName() + ":" + e.getMessage());
            }
        });
        thread.start();
        /**
         * 当前线程继续执行
         */
        log.info("2:Message has been sent by Local~!");
    }

    /**
     * 功能描述：发送消息后的回调函数
     *
     * @param jsonString 回调参数
     * @author cakin
     * @date 2020/4/25
     */
    public void execute( String jsonString ) {
        /**
         * 打印返回的消息*
         */
        log.info("5:" + jsonString);
        /**
         * 打印发送消息的线程名称
         */
        log.info("6:" + Thread.currentThread().getName());
        /**
         * 中断发送消息的线程
         */
        Thread.interrupted();
    }

    public static void main( String[] args ) {
        Local local = new Local(new Remote(), "Hello");

        local.sendMessage();
    }

    public void run() {
        remote.executeMessage(message, this);

    }

    public class SendThead extends Thread {
        public SendThead( String name ) {
        }

        public void run() {
            remote.executeMessage(JSON.toJSONString(new Teacher("cakin")), new Local());
        }
    }
}
