/**
 * Copyright (C), 2020-2020, 软件公司
 * FileName: WithoutOptionalDemo
 * Author:   cakin
 * Date:     2020/4/24
 * Description: 没有 Optional 会有什么问题
 */
package optionaldemo;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: WithoutOptionalDemo
 * @Description: 没有 Optional 会有什么问题
 * @Date: 2020/4/24
 * @Author: cakin
 */
@Slf4j
public class WithoutOptionalDemo {
    class Member {
        /**
         * 名字
         */
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Member mem = getMemberByIdFromDB();
        /**
         * 问题在这里，需要判断是否为空，否则会引起NullPointerException问题
         */
        if (mem != null) {
            log.info(mem.getName());
        }
    }

    public static Member getMemberByIdFromDB() {
        // 当前 ID 的会员不存在
        return null;
    }
}

