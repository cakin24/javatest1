/**
 * Copyright (C), 2020-2020, 软件公司
 * FileName: Remote
 * Author:   cakin
 * Date:     2020/4/25
 * Description:处理消息的远程类
 */
package asymsg;

import GPer.Teacher;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import common.Constant;
import lombok.extern.slf4j.Slf4j;

/**
 * @className: Remote
 * @description: 处理消息的远程类
 * @date: 2020/4/25
 * @author: cakin
 */
@Slf4j
public class Remote {
    /**
     * 处理消息
     *
     * @param msg      接收的消息
     * @param callBack 回调函数处理类
     */
    public void executeMessage( String msg, CallBack callBack ) {
        /**
         * 模拟远程类正在处理其他事情，可能需要花费许多时间
         */
        try {
            Thread.sleep(Constant.NUM1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**
         * 处理完其他事情，现在来处理消息
         */
        JSONObject json = JSONObject.parseObject(msg);
        Teacher teacher = JSON.toJavaObject(json, Teacher.class);
        log.info("3:" + teacher.toString());
        log.info("4:I hava executed the message by Local");
        /**
         * 执行回调
         */
        String jsonString = "cakin";
        callBack.execute(jsonString);
    }
}
