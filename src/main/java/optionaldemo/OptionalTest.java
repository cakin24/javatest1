/**
 * Copyright (C), 2020-2020, 软件公司
 * FileName: OptionalTest
 * Author:   cakin
 * Date:     2020/4/24
 * Description: Optional 用法
 */

package optionaldemo;

import common.Constant;
import lombok.extern.slf4j.Slf4j;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * @ClassName: OptionalTest
 * @Description: Optional 用法
 * @Date: 2020/4/24
 * @Author: cakin
 */
@Slf4j
public class OptionalTest {
    public static void main( String[] args ) {
        log.info("++++++++++++++++++++++++++++++++++++++++++++++");
        /**
         * 创建 Optional 对象
         */
        Optional<String> empty = Optional.empty();
        log.info("empty is " + empty);

        Optional<String> opt = Optional.of("cakin");
        log.info("opt is " + opt);

        String name = null;
        try {
            Optional<String> optnull = Optional.of(name);
        } catch (NullPointerException e) {
            log.info("catch NullPointerException");
        }

        String name1 = null;
        Optional<String> optOrNull = Optional.ofNullable(name1);
        log.info("optOrNull is" + optOrNull);
        log.info("++++++++++++++++++++++++++++++++++++++++++++++");

        /**
         * 判断值是否存在
         */
        Optional<String> opt1 = Optional.of("cakin");
        log.info("opt1 is " + opt1.isPresent());

        Optional<String> optOrNull1 = Optional.ofNullable(null);
        log.info("optOrNull1 is " + optOrNull1.isPresent());
        log.info("++++++++++++++++++++++++++++++++++++++++++++++");

        /**
         * 非空表达式
         */
        Optional<String> optOrNull2 = Optional.ofNullable("cakin");
        if (optOrNull2.isPresent()) {
            log.info("optOrNull2 length is " + optOrNull2.get().length());
        }

        Optional<String> opt2 = Optional.of("cakin");
        opt2.ifPresent(str -> log.info("str length is " + str.length()));
        log.info("++++++++++++++++++++++++++++++++++++++++++++++");

        /**
         * orElse() :用于返回包裹在 Optional 对象中的值，如果该值不为 null，则返回；否则返回默认值。
         * 该方法的参数类型和值得类型一致。
         */
        String nullName = null;
        String name2 = Optional.ofNullable(nullName).orElse("cakin");
        log.info("name2 is " + name2);
        log.info("++++++++++++++++++++++++++++++++++++++++++++++");

        /**
         * orElseGet() :与 orElse() 方法类似，但参数类型不同。
         * 如果 Optional 对象中的值为 null，则执行参数中的函数。
         */
        String nullName1 = null;
        String name3 = Optional.ofNullable(nullName1).orElseGet(() -> "cakin");
        log.info("name3 is " + name3);
        log.info("++++++++++++++++++++++++++++++++++++++++++++++");

        /**
         * orElse() 方法和 orElseGet() 方法分别调用 getDefaultValue() 方法返回默认值。
         * 两者输出结果一致
         * 类名 :: 方法名是 Java 8 引入的语法，方法名后面是没有 () 的，表明该方法并不一定会被调用。
         */
        String name4 = null;
        log.info("orElse");
        String name5 = Optional.ofNullable(name4).orElse(getDefaultValue());
        log.info("name5 is " + name5);

        log.info("orElseGet");
        String name6 = Optional.ofNullable(name4).orElseGet(OptionalTest::getDefaultValue);
        log.info("name6 is " + name6);
        log.info("++++++++++++++++++++++++++++++++++++++++++++++");

        /**
         *  Optional 对象的值不为 null,orElse() 方法和 orElseGet() 方法输出结果不一样
         *  orElseGet() 没有去调用 getDefaultValue()，性能更优
         */
        String name7 = "cakin";
        log.info("orElse");
        String name8 = Optional.ofNullable(name7).orElse(getDefaultValue());
        log.info("name8 is " + name8);

        log.info("orElseGet");
        String name9 = Optional.ofNullable(name7).orElseGet(OptionalTest::getDefaultValue);
        log.info("name9 is " + name9);
        log.info("++++++++++++++++++++++++++++++++++++++++++++++");

        /**
         * 获取值
         * get() 方法才是最正宗的获取 Optional 对象值的方法，但很遗憾，该方法是有缺陷的，
         * 因为假如 Optional 对象的值为 null，该方法会抛出 NoSuchElementException 异常。
         * 建议 orElseGet() 方法获取 Optional 对象的值。
         */
        String name10 = null;
        Optional<String> optOrNull10 = Optional.ofNullable(name10);
        try {
            log.info(optOrNull10.get());
        } catch (NoSuchElementException e) {
            log.info("catch NoSuchElementException");
        }
        log.info(optOrNull10.orElseGet(() -> name10));
        log.info("++++++++++++++++++++++++++++++++++++++++++++++");

        /**
         * 过滤值 filter方法实现
         */
        String password = "12345";
        Optional<String> opt3 = Optional.ofNullable(password);
        // 由于 password 的长度为 5 ，所以程序输出的结果为 false。
        log.info("pass:" + opt3.filter(pwd -> pwd.length() > Constant.NUM6).isPresent());

        Predicate<String> len6 = pwd -> pwd.length() > Constant.NUM6;
        Predicate<String> len10 = pwd -> pwd.length() < Constant.NUM10;
        Predicate<String> containA = pwd -> pwd.contains("A");

        password = "1234567A";
        Optional<String> opt4 = Optional.ofNullable(password);
        boolean result = opt4.filter(len6.and(len10).and(containA)).isPresent();
        // 密码变成了 7 位，在 6 到 10 位之间,并且包括A，所以通过了
        log.info("pass:" + result);
        log.info("++++++++++++++++++++++++++++++++++++++++++++++");

        /**
         * 转换值
         */
        // 名字转换为长度
        nameLength();
        // 验证密码
        validPassword();
        log.info("++++++++++++++++++++++++++++++++++++++++++++++");
    }

    /**
     * 功能描述：验证密码
     *
     * @author cakin
     * @date 2020/4/24
     */
    private static void validPassword() {
        String password = "pAssWord";
        Optional<String> opt = Optional.ofNullable(password);

        Predicate<String> len6 = pwd -> pwd.length() > Constant.NUM6;
        Predicate<String> len10 = pwd -> pwd.length() < Constant.NUM10;
        Predicate<String> eq = pwd -> pwd.equals("password");

        boolean result = opt.map(String::toLowerCase).filter(len6.and(len10).and(eq)).isPresent();
        log.info("pass:" + result);
    }

    /**
     * 功能描述：将name转成长度
     *
     * @author cakin
     * @date 2020/4/24
     */
    private static void nameLength() {
        String name = "cakin";
        Optional<String> nameOptional = Optional.of(name);
        Optional<Integer> intOpt = nameOptional
                .map(String::length);
        log.info("name length is " + intOpt.orElse(0));
    }

    public static String getDefaultValue() {
        log.info("getDefaultValue");
        return "cakin";
    }
}
