/**
 * Copyright (C), 2020-2020, 软件公司
 * FileName: ToolUtils
 * Author:   cakin
 * Date:     2020/4/26
 * Description: 常用开源工具测试
 */
package toolutils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.File;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.Arrays;

import static common.Constant.SPLIT_LINE;
import static common.Constant.NUM4;
import static common.Constant.NUM5;
import static common.Constant.NUM6;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;


/**
 * @ClassName: ToolUtils
 * @Description: 常用开源工具测试
 * @Date: 2020/4/26
 * @Author: cakin
 */
@Slf4j
public class ToolUtils {
    public static void main( String[] args ) {
        log.info(SPLIT_LINE);
        // IOUtils测试
        testIOUtils();

        log.info(SPLIT_LINE);
        // FileUtils测试
        testFileUtils();

        log.info(SPLIT_LINE);
        // 测试 FilenameUtils
        testStringUtils();

        log.info(SPLIT_LINE);
        // 测试FilenameUtils
        testFilenameUtils();

        // 测试ArrayUtils
        log.info(SPLIT_LINE);
        testArrayUtils();

        log.info(SPLIT_LINE);
        // 测试DigestUtils
        testDigestUtils();

        log.info(SPLIT_LINE);
        // StringEscapeUtils测试
        testStringEscapeUtils();

        log.info(SPLIT_LINE);
        // 测试BeanUtils工具类
        testBeanUtils();

        log.info(SPLIT_LINE);
    }

    /**
     * 功能描述：IOUtils测试
     *
     * @author cakin
     * @date 2020/4/28
     */
    private static void testIOUtils() {
        String strSource = "D:/test/test/source.txt";
        File file = new File(strSource);

        String strFile = "D:/test/test/des.txt";
        String str1 = "D:/test/test/des1.txt";
        File saveFile = new File(strFile);
        File saveFile1 = new File(str1);
        OutputStream outputStream = null;
        OutputStream outputStream1 = null;
        InputStream inputStream = null;

        try {
            outputStream = new FileOutputStream(saveFile);
            outputStream1 = new FileOutputStream(saveFile1);
            int a = 5/0;
        } catch (FileNotFoundException e) {
            log.info("catch FileNotFoundException");
        } catch (ArithmeticException e){
            log.info("catch ArithmeticException");

        }

        try {
            inputStream = new FileInputStream(file);
            byte[] result = IOUtils.toByteArray(inputStream); // 以byte[]形式获取输入流中的内容，输入流读完后，再读内容为空
            String resultString = new String(result, "UTF-8"); // 将byte数组转成字符
            log.info((resultString));

            /**
             * inputStream只能读一次，如果读多次，会异常，这里有两种解决方法
             * 1 屏蔽上面这段代码
             * 2 inputStream重写赋值
             * 这里采用方式2
             */
            inputStream = new FileInputStream(file); // inputStream 重新赋值
            byte[] intArray = new byte[inputStream.available()]; // 获取输入流的大小
            IOUtils.readFully(inputStream, intArray);
            String resultString1 = new String(intArray, "UTF-8");
            log.info(resultString1);

        } catch (IOException e) {
            log.info("catch IOException");
        }

        try {
            InputStream inputStream2 = new FileInputStream(file);
            IOUtils.copy(inputStream2, outputStream1); // 将字节从输入流赋值到输出流，拷贝完后，输入流清空
            // 从输入流中复制内容到输出流，超过2G
            IOUtils.copyLarge(inputStream2, outputStream1);
            IOUtils.write("是追加而不是覆盖", outputStream1, "UTF-8"); // 将字符或者字节写入输出流中
            // 从输入流中一行一行读取，并安装指定的字符编码返回字符串列表
            InputStream inputStream1 = new FileInputStream(file);
            List<String> lines = IOUtils.readLines(new InputStreamReader(inputStream1, "utf-8"));
            for (String line : lines
            ) {
                log.info(line);
            }
        } catch (IOException e) {
            log.info("catch IOException");
        } finally {
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(outputStream);
        }
    }

    /**
     * 功能描述：FileUtils测试
     *
     * @author cakin
     * @date 2020/4/27
     */
    private static void testFileUtils() {
        String strDir = "D:/test/test";
        File file = new File(strDir);
        try {
            FileUtils.deleteDirectory(file); // 删除目录
        } catch (IOException e) {
            log.info("catch IOException");
        }

        String strFile = "D:/test/test/test.txt";
        File reportFile = new File(strFile);
        try {
            String fileAsString = FileUtils.readFileToString(reportFile); // 把文件内容读入到字符串
            log.info(fileAsString);
        } catch (IOException e) {
            log.info("catch FileNotFoundException");
        }

        String strFile1 = "D:/test/test/test1.txt";
        String strFile2 = "D:/test/test/test2.txt";
        File source = new File(strFile1);
        File dest = new File(strFile2);
        try {
            FileUtils.copyFile(source, dest); // 把文件复制到一个新的位置
        } catch (IOException e) {
            log.info("catch FileNotFoundException");
        }

        File file1 = new File("D:/test/test/test1.txt");
        String writeText = "test";
        try {
            FileUtils.writeStringToFile(file1, writeText, Charset.forName("UTF-8")); // 把字符串写入文件
            FileUtils.write(file1, "test2", "utf-8"); // 把字符或者字节写入到文件，覆盖写
        } catch (IOException e) {
            e.printStackTrace();
        }

        File dir = new File("D:/test/test");
        if (!dir.exists()) {
            try {
                FileUtils.forceMkdir(dir); // 强制创建任务必需但不存在的父目录
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        otherFileUtils();
        listDir();
    }

    // 列式目录
    private static void listDir() {
        String dirName = "D:/test/test";
        File root = new File(dirName);
        Collection<File> files = FileUtils.listFiles(root, //列出指定目录下的所有文件
                new RegexFileFilter(".*."),
                DirectoryFileFilter.DIRECTORY);
        for (Iterator<File> iterator = files.iterator(); iterator.hasNext(); ) {
            Object obj = iterator.next();
            if (obj instanceof File) {
                File file = (File) obj;
                log.info(file.getName());
            }
        }
    }

    private static void otherFileUtils() {
        File src = new File("D:/test/test1");
        File dest = new File("D:/test/test2");
        try {
            FileUtils.copyDirectory(src, dest); // 将目录下的所有目录以及文件复制到新的目录。
        } catch (IOException e) {
            log.info("catch FileNotFoundException");
        }

        try {
            FileUtils.forceDelete(dest); // 强制删除文件或者目录及其所有子目录和文件
        } catch (IOException e) {
            log.info("catch FileNotFoundException");
        }

        String strFileNotExit = "D:/test/test3/test.txt";
        File testFile = new File(strFileNotExit);
        FileUtils.deleteQuietly(testFile); // 删除文件，但不抛出异常
    }

    /**
     * 功能描述：测试 FilenameUtils
     *
     * @author cakin
     * @date 2020/4/27
     */
    private static void testStringUtils() {
        // isBlank()，检查字符是否为空字符串""，或者 null，或者空格。
        log.info("result is " + StringUtils.isBlank(null));
        log.info("result is " + StringUtils.isBlank(""));
        log.info("result is " + StringUtils.isBlank(" "));
        log.info("result is " + StringUtils.isBlank("王小二"));
        log.info("result is " + StringUtils.isBlank("  王小二  "));

        // isNotBlank()，与 isBlank () 检查的结果相反。

        // isEmpty()，检查字符是否为空字符串 ""，或者 null；和 isBlank () 不同，不包括空格的检查。
        log.info("result is " + StringUtils.isEmpty(null));
        log.info("result is " + StringUtils.isEmpty(""));
        log.info("result is " + StringUtils.isEmpty(" "));
        log.info("result is " + StringUtils.isEmpty("王小二"));
        log.info("result is " + StringUtils.isEmpty("  王小二  "));

        // isNotEmpty()，与 isEmpty () 检查的结果相反。

        // join()，将多个元素连接成一个字符串。
        log.info("result is " + StringUtils.join(null));
        log.info("result is " + StringUtils.join("王", "二小"));

        // equals()，比较两个字符序列是否相等。
        log.info("result is " + StringUtils.equals(null, null));
        log.info("result is " + StringUtils.equals(null, "王小二"));
        log.info("result is " + StringUtils.equals("王小二", null));
        log.info("result is " + StringUtils.equals("王小二", "王小二"));
        log.info("result is " + StringUtils.equals("cmower", "CMOWER"));

        // split()，把字符串拆分为数组，拆分符为空白字符。
        log.info("result is " + StringUtils.split(null));
        log.info("result is " + StringUtils.split(""));
        log.info("result is " + Arrays.toString(StringUtils.split("王小二 小四")));
        log.info("result is " + Arrays.toString(StringUtils.split(" 王小二 ")));

        // replace()，替换另一个字符串中所有出现的字符串。
        log.info(StringUtils.replace(null, "*", "*"));
        log.info(StringUtils.replace("", "*", "*"));
        log.info(StringUtils.replace("any", null, "*"));
        log.info(StringUtils.replace("any", "*", null));
        log.info(StringUtils.replace("any", "", "*"));
        log.info(StringUtils.replace("王小二", "二", null));
        log.info(StringUtils.replace("王小二", "二", ""));
        log.info(StringUtils.replace("王小二", "二", "三"));
    }

    /**
     * 功能描述：测试FilenameUtils
     *
     * @author cakin
     * @date 2020/4/27
     */
    private static void testFilenameUtils() {
        // getExtension()，获取文件的扩展名。
        log.info(FilenameUtils.getExtension("test.txt"));
        log.info(FilenameUtils.getExtension("a/b/test.jpg"));
        log.info(FilenameUtils.getExtension("a/test.txt/c"));
        log.info(FilenameUtils.getExtension("a/b/c"));

        // getBaseName()，获取单纯的文件名或者路径名，文件时去掉路径和扩展名；是路径时去掉父级路径。
        log.info(FilenameUtils.getBaseName("a/b/test.txt"));
        log.info(FilenameUtils.getBaseName("test.txt"));
        log.info(FilenameUtils.getBaseName("a/b/c"));
        log.info(FilenameUtils.getBaseName("a/b/c/"));

        // getName()，如果是文件时，获取文件名和后缀，去掉路径；如果是路径时，去掉父级路径。
        log.info(FilenameUtils.getName("a/b/test.txt"));
        log.info(FilenameUtils.getName("test.txt"));
        log.info(FilenameUtils.getName("a/b/c"));
        log.info(FilenameUtils.getName("a/b/c/"));

        // concat()，将路径和文件名连接在一起。
        log.info(FilenameUtils.concat("/foo/", "bar"));
        log.info(FilenameUtils.concat("/foo", "bar"));
        log.info(FilenameUtils.concat("/foo", "/bar"));
        log.info(FilenameUtils.concat("/foo", "C:/bar"));
        log.info(FilenameUtils.concat("/foo", "C:bar"));
        log.info(FilenameUtils.concat("/foo/a/", "../bar"));
        log.info(FilenameUtils.concat("/foo/", " ../../bar"));
        log.info(FilenameUtils.concat("/foo/", "/bar"));
        log.info(FilenameUtils.concat("/foo/.. ", "/bar"));
        log.info(FilenameUtils.concat("/foo", " bar/c.txt"));
        log.info(FilenameUtils.concat("/foo/c.txt", "bar"));

        // FilenameUtils.wildcardMatch()，检查文件名是否匹配指定的格式。
        log.info("is match:" + FilenameUtils.wildcardMatch("c.txt", "*.txt"));
        log.info("is match:" + FilenameUtils.wildcardMatch("c.txt", "*.jpg"));
        log.info("is match:" + FilenameUtils.wildcardMatch("a/b/c.txt", "a/b/*"));
        log.info("is match:" + FilenameUtils.wildcardMatch("c.txt", "*.???"));
        log.info("is match:" + FilenameUtils.wildcardMatch("c.txt", "*.????"));

        // separatorsToUnix()，将所有分隔符转换为正斜杠的 Unix 分隔符。
        log.info(FilenameUtils.separatorsToUnix("my/unix/filename"));

        // getFullPath()，获取文件的完整路径。
        log.info(FilenameUtils.getFullPath("C:\\a\\b\\c.txt"));
        log.info(FilenameUtils.getFullPath("~/a/b/c.txt"));
        log.info(FilenameUtils.getFullPath("a.txt"));
    }

    /**
     * 功能描述：测试ArrayUtils
     *
     * @param
     * @return
     * @author cakin
     * @date 2020/4/26
     */
    private static void testArrayUtils() {
        testContains();
        testAddAll();
        testClone();
        testSubarray();
        testToObject();
        testOther();
    }

    /**
     * Contains
     * 如果某个数组包含某个值就返回true
     * 否则返回false
     */
    public static void testContains() {
        String[] array = {"1", "2", "3"};
        log.info("{}", ArrayUtils.contains(array, "2"));
        log.info("{}", ArrayUtils.contains(array, "4"));
    }

    /**
     * AddAll
     * 创建出一个新的数组，原数组的值不变
     */
    public static void testAddAll() {
        String[] array1 = {"1", "2", "3"};
        String[] array2 = {"4", "5", "6"};
        String[] array3 = ArrayUtils.addAll(array1, array2);
        log.info(Arrays.toString(array3));
    }

    /**
     * 浅拷贝一个数组
     */
    public static void testClone() {
        String[] array1 = {"1", "2", "3"};
        String[] clone = ArrayUtils.clone(array1);
        log.info(Arrays.toString(clone));
    }

    /**
     * 截取某个数组的值
     * 从startIndexInclusive
     * 到endIndexExclusive
     * 即[)
     */
    public static void testSubarray() {
        String[] array = {"4", "5", "6"};
        String[] subarray = ArrayUtils.subarray(array, 0, NUM6);
        log.info(Arrays.toString(subarray));
    }

    /**
     * 将基本类型数组变成
     * 对应的引用类型数组
     */
    public static void testToObject() {
        int[] array = {NUM4, NUM5, NUM6};
        Integer[] array1 = ArrayUtils.toObject(array);
        for (Integer integer : array1) {
            log.info("{}", integer);
        }
    }

    private static void testOther() {
        String[] strs = null;
        // 检查数组是否为 null 或者没有元素
        if (ArrayUtils.isEmpty(strs)) {
            log.info("strs is null");
        }

        // 在数组中添加一个新的元素，原数组不变。
        String[] strNews = ArrayUtils.add(strs, "how are you");
        log.info(Arrays.toString(strNews));

        // 找出指定数组的下标
        String[] num = {"12", "34", "56"};
        log.info("{}", ArrayUtils.indexOf(num, "56"));
    }


    /**
     * 功能描述：测试DigestUtils
     *
     * @author cakin
     * @date 2020/4/26
     */
    private static void testDigestUtils() {
        // 计算字符串的 MD5 摘要，并返回 32 位的十六进制字符。
        log.info(DigestUtils.md5Hex("王小二"));
        // 计算字符串的 MD5 摘要，并返回 16 个元素的字节数组。
        log.info(Arrays.toString(DigestUtils.md5("王小二")));
    }

    /**
     * 功能描述：StringEscapeUtils测试
     *
     * @author cakin
     * @date 2020/4/26
     * @description: 使用pom如下
     */
    private static void testStringEscapeUtils() {
        // 反转义 HTML
        log.info(StringEscapeUtils.unescapeHtml4("&lt;div&gt;&lt;/div&gt;"));
        // 转义 HTML
        log.info(StringEscapeUtils.escapeHtml4("<div></div>"));
        // 转义 Java
        log.info(StringEscapeUtils.escapeJava("王二小"));
        // 反转义 Java
        log.info(StringEscapeUtils.unescapeJava("\\u738B\\u4E8C\\u5C0F"));
    }

    /**
     * 功能描述：测试BeanUtils工具类
     *
     * @author cakin
     * @date 2020/4/26
     */
    private static void testBeanUtils() {
        User user1 = new User(1, "cakin");
        User user2 = new User();

        try {
            BeanUtils.copyProperties(user2, user1);
        } catch (IllegalAccessException e) {
            log.info("catch IllegalAccessException");
        } catch (InvocationTargetException e) {
            log.info("catch InvocationTargetException");
        }
        log.info("user2 is" + user2);

        try {
            BeanUtils.setProperty(user2, "username", "cakin24");
            log.info("user2 is" + user2);
            String fieldValue = BeanUtils.getProperty(user2, "username");
        } catch (IllegalAccessException e) {
            log.info("catch IllegalAccessException");
        } catch (InvocationTargetException e) {
            log.info("catch InvocationTargetException");
        } catch (NoSuchMethodException e) {
            log.info("catch NoSuchMethodException");
        }
    }
}
