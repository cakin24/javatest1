package RegexMatches;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Copyright (C), 2020-2020, XXX有限公司
 * FileName: RegexMatches
 * Author:   cakin
 * Date:     2020/3/15 9:36
 * Description: 正则测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class RegexMatches {
    public static void main(String args[]) {
        System.out.println("-----------------匹配数字--------------");
        String str = "1263428742";
        String pattern = "^[0-9]*$";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        System.out.println(m.matches());

        System.out.println("----------------匹配文件名---------------");
        String str1 = "datax.dat";
        String pattern1 = "data(\\w)?\\.dat";  // 这里?表示匹配0个或1个前面的字符,\.表示这里的.是实际.,而不是元字符中国的.

        Pattern r1 = Pattern.compile(pattern1);
        Matcher m1 = r1.matcher(str1);
        System.out.println(m1.matches());

        System.out.println("------------匹配数字开头，abc结尾-------------------");
        String str2 = "1263428742abc";
        String pattern2 = "^[0-9]+abc$";

        Pattern r2 = Pattern.compile(pattern2);
        Matcher m2 = r2.matcher(str2);
        System.out.println(m2.matches());

        System.out.println("------------用户名包含字符、数字、下划线和连接字符(-)，并设置用户名的长度-------------------");
        str = "cakin24";
        pattern = "^[a-z0-9_-]{3,15}$";

        r = Pattern.compile(pattern);
        m = r.matcher(str);
        System.out.println(m.matches());

        System.out.println("------------+代表1次或多次-------------------");
        str = "runoob";
        pattern = "runoo+b";

        r = Pattern.compile(pattern);
        m = r.matcher(str);
        System.out.println(m.matches());

        System.out.println("------------*代表0次1次或多次-------------------");
        str = "runob";
        pattern = "runoo*b";

        r = Pattern.compile(pattern);
        m = r.matcher(str);
        System.out.println(m.matches());

        System.out.println("------------?代表0次1次或多次-------------------");
        str = "color";
        pattern = "colou?r";

        r = Pattern.compile(pattern);
        m = r.matcher(str);
        System.out.println(m.matches());

        System.out.println("------------匹配一个正整数-------------------");
        str = "57";
        pattern = "[1-9][0-9]*";

        r = Pattern.compile(pattern);
        m = r.matcher(str);
        System.out.println(m.matches());

        System.out.println("------------匹配1到99的数-------------------");
        str = "57";
        pattern = "[1-9][0-9]?";

        r = Pattern.compile(pattern);
        m = r.matcher(str);
        System.out.println(m.matches());

        System.out.println("------------贪婪匹配-------------------");
        str = "<h1>RUNOOB-菜鸟教程</h1>";
        pattern = "<.*>";

        r = Pattern.compile(pattern);
        m = r.matcher(str);
        System.out.println(m.matches());
        System.out.println(m.start());
        System.out.println(m.end());

        System.out.println("------------定位符匹配^和$-------------------");
        str = "Chapter 56";
        pattern = "^Chapter [1-9][0-9]{0,1}$";

        r = Pattern.compile(pattern);
        m = r.matcher(str);
        System.out.println(m.matches());
        System.out.println(m.start());
        System.out.println(m.end());

        System.out.println("------------定位符匹配b-------------------");
        str = "Cha";
        pattern = "\\bCha";

        r = Pattern.compile(pattern);
        m = r.matcher(str);
        System.out.println(m.matches());
        System.out.println(m.start());
        System.out.println(m.end());

        System.out.println("------------所有包含一个以上的字母、数字或下划线的字符串-------------------");
        str = "Cha54t";
        pattern = "^[a-zA-Z0-9_]+$";

        r = Pattern.compile(pattern);
        m = r.matcher(str);
        System.out.println(m.matches());
        System.out.println(m.start());
        System.out.println(m.end());

        System.out.println("------------所有正整数-------------------");
        str = "12345";
        pattern = "^[1-9][0-9]*$";

        r = Pattern.compile(pattern);
        m = r.matcher(str);
        System.out.println(m.matches());
        System.out.println(m.start());
        System.out.println(m.end());

        System.out.println("------------所有整数-------------------");
        str = "-12345";
        pattern = "^\\-?[0-9]+$";

        r = Pattern.compile(pattern);
        m = r.matcher(str);
        System.out.println(m.matches());
        System.out.println(m.start());
        System.out.println(m.end());

        System.out.println("------------所有浮点数-------------------");
        str = "-0.12345";
        pattern = "^[-]?[0-9]+(\\.[0-9]+)?$";

        r = Pattern.compile(pattern);
        m = r.matcher(str);
        System.out.println(m.matches());
        System.out.println(m.start());
        System.out.println(m.end());

        System.out.println("------------句点匹配-------------------");
        str = "abc";
        pattern = "a.c";

        r = Pattern.compile(pattern);
        m = r.matcher(str);
        System.out.println(m.matches());
        System.out.println(m.start());
        System.out.println(m.end());

        System.out.println("------------句点原意匹配-------------------");
        str = "filename.ext";
        pattern = "filename\\.ext";

        r = Pattern.compile(pattern);
        m = r.matcher(str);
        System.out.println(m.matches());
        System.out.println(m.start());
        System.out.println(m.end());

        System.out.println("------------中括号表达式-------------------");
        str = "Chapter 5";
        pattern = "Chapter [1-5]";

        r = Pattern.compile(pattern);
        m = r.matcher(str);
        System.out.println(m.matches());
        System.out.println(m.start());
        System.out.println(m.end());

        System.out.println("------------中括号表达式中的^，表示不在范围内-------------------");
        str = "Chapter 9";
        pattern = "Chapter [^1-5]";

        r = Pattern.compile(pattern);
        m = r.matcher(str);
        System.out.println(m.matches());
        System.out.println(m.start());
        System.out.println(m.end());

        System.out.println("------------替换和分组保存-------------------");
        str = "Section 9";
        pattern = "^(Chapter|Section) [1-9][0-9]{0,1}$";

        r = Pattern.compile(pattern);
        m = r.matcher(str);
        System.out.println(m.matches());
        System.out.println(m.start());
        System.out.println(m.end());

        System.out.println("------------替换和分组不保存-------------------");
        str = "Section 9";
        pattern = "^(?:Chapter|Section) [1-9][0-9]{0,1}$";

        r = Pattern.compile(pattern);
        m = r.matcher(str);
        System.out.println(m.matches());
        System.out.println(m.start());
        System.out.println(m.end());

        System.out.println("------------将一个URL解析为协议、域、端口及相对路径-------------------");
        str = "http://localhost:8080/test/user";
        pattern = "(\\w+):\\/\\/([^/:]+)(:\\d*)?([^# ]*)";

        r = Pattern.compile(pattern);
        m = r.matcher(str);
        System.out.println(m.matches());
        System.out.println(m.start());
        System.out.println(m.end());

        System.out.println("------------a至z共26个字母再加一个-号。-------------------");
        str = "-";
        pattern = "[-a-z]";

        r = Pattern.compile(pattern);
        m = r.matcher(str);
        System.out.println(m.matches());
        System.out.println(m.start());
        System.out.println(m.end());

        System.out.println("------------a至z共26个字母再加一个-号。-------------------");
        str = "" +
                "";
        pattern = "^\\s*$";

        r = Pattern.compile(pattern);
        m = r.matcher(str);
        System.out.println(m.matches());
        System.out.println(m.start());
        System.out.println(m.end());

        System.out.println("------------验证由两位数字、一个连字符再加 5 位数字组成的 ID 号。-------------------");
        str = "12-45632";
        pattern = "\\d{2}-\\d{5}";

        r = Pattern.compile(pattern);
        m = r.matcher(str);
        System.out.println(m.matches());
        System.out.println(m.start());
        System.out.println(m.end());

        System.out.println("------------验证由两位数字、一个连字符再加 5 位数字组成的 ID 号。-------------------");
        str = "<html>hello</html>";
        pattern = "<\\s*(\\S+)(\\s[^>]*)?>[\\s\\S]*<\\s*\\/\\1\\s*>";

        r = Pattern.compile(pattern);
        m = r.matcher(str);
        System.out.println(m.matches());
        System.out.println(m.start());
        System.out.println(m.end());
    }
}
