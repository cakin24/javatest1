package RegexMatches;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Copyright (C), 2020-2020, XXX有限公司
 * FileName: RegexExample1
 * Author:   cakin
 * Date:     2020/3/15 16:44
 * Description: 正则例子
 * 捕获组是通过从左至右计算其开括号来编号。例如，在表达式（（A）（B（C））），有四个这样的组：
 * ((A)(B(C)))
 * (A)
 * (B(C))
 * (C)
 * 可以通过调用 matcher 对象的 groupCount 方法来查看表达式有多少个分组。groupCount 方法返回一个 int 值，
 * 表示matcher对象当前有多个捕获组。
 * 还有一个特殊的组（group(0)），它总是代表整个表达式。该组不包括在 groupCount 的返回值中。
 */
public class RegexExample1 {
    public static void main(String args[]){
        String content = "I am noob " +
                "from runoob.com.";

        String pattern = ".*runoob.*";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);


        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern1 = "(\\D*)(\\d+)(.*)";

        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern1);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );  // group(0)），它总是代表整个表达式。
            System.out.println("Found value: " + m.group(1) );  // group(1)）:代表第1个分组
            System.out.println("Found value: " + m.group(2) );  // group(2)）:代表第2个分组
            System.out.println("Found value: " + m.group(3) );  // group(3)）:代表第3个分组
        } else {
            System.out.println("NO MATCH");
        }

        System.out.println("groupCount: " + m.groupCount() );   // 不包括 group 0

        Pattern p = Pattern.compile(REGEX);
        Matcher m1 = p.matcher(INPUT); // 获取 matcher 对象
        int count = 0;

        // cat匹配
        while(m1.find()) {  // 尝试查找与该模式匹配的输入序列的下一个子序列。
            count++;
            System.out.println("Match number "+count);
            System.out.println("start(): "+m1.start());     // 演示start方法
            System.out.println("end(): "+m1.end());         // 演示end方法
        }
    }

    private static final String REGEX = "\\bcat\\b";
    private static final String INPUT =
            "cat cat cat cattie cat";
}

class RegexMatchesTest
{
    private static final String REGEX = "foo";
    private static final String INPUT = "fooooooooooooooooo";
    private static final String INPUT2 = "ooooofoooooooooooo";
    private static Pattern pattern;
    private static Matcher matcher;
    private static Matcher matcher2;

    public static void main( String args[] ){
        pattern = Pattern.compile(REGEX);
        matcher = pattern.matcher(INPUT);
        matcher2 = pattern.matcher(INPUT2);

        System.out.println("Current REGEX is: "+REGEX);
        System.out.println("Current INPUT is: "+INPUT);
        System.out.println("Current INPUT2 is: "+INPUT2);

        //lookingAt 方法虽然不需要整句都匹配，但是需要从第一个字符开始匹配。
        // matches 和 lookingAt 方法都用来尝试匹配一个输入序列模式。
        // 它们的不同是 matches 要求整个序列都匹配，而lookingAt 不要求。
        System.out.println("lookingAt(): "+matcher.lookingAt());  // 从开头部分匹配，这里可以匹配上
        System.out.println("matches(): "+matcher.matches());      // 从开头全部匹配，这里匹配不上
        System.out.println("lookingAt(): "+matcher2.lookingAt()); // 从开头不匹配，匹配不上
    }
}


class RegexMatches2
{
    private static String REGEX = "dog";
    private static String INPUT = "The dog says meow. " +
            "All dogs say meow.";
    private static String INPUT1 = "The dog says meow. " +
            "All dogs say meow.";
    private static String REPLACE = "cat";

    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        // get a matcher object
        Matcher m = p.matcher(INPUT);
        INPUT = m.replaceFirst(REPLACE);  // 只替换第1个地方的cat
        System.out.println(INPUT);  // The cat says meow. All dogs say meow.

        m = p.matcher(INPUT1);
        INPUT1 = m.replaceAll(REPLACE);  // 全部替换成cat
        System.out.println(INPUT1); // The cat says meow. All cats say meow.
    }
}

class RegexMatches3
{
    private static String REGEX = "a*b";
    private static String INPUT = "aabfooaabfooabfoobkkk";
    private static String REPLACE = "-";
    public static void main(String[] args) {
        Pattern p = Pattern.compile(REGEX);
        // 获取 matcher 对象
        Matcher m = p.matcher(INPUT);
        StringBuffer sb = new StringBuffer();
        while(m.find()){
            m.appendReplacement(sb,REPLACE);  // 实现添加替换
        }
        m.appendTail(sb);
        System.out.println(sb.toString());   // 输出  -foo-foo-foo-kkk
    }
}
