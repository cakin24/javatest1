package ZipFile;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.InputStream;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static org.apache.xmlbeans.impl.store.Public2.test;

/**
 * Copyright (C), 2020-2020, XXX有限公司
 * FileName: ZipFile
 * Author:   cakin
 * Date:     2020/1/18
 * Description: 将文件夹压缩成zip文件,该范例重点关注资源关闭的顺序
 * 在开启了资源后，就要按照打开的顺序，依次相反地关闭资源。
 */
public class ZipFile {
    private static Logger log = LogManager.getLogger(ZipFile.class);

    public static void main( String[] args ) {
        String filePath = "F:\\Javatest" + File.separator + "tempTest"; // 代表一个文件夹
        String zipPath = "F:\\Javatest" + File.separator + "tempTest.zip"; // 代表一个压缩文件
        zipMutiFile(filePath, zipPath);
    }

    public static void zipMutiFile( String filePath, String zipPath ) {
        // 文件夹为空
        if (StringUtils.isEmpty(filePath)) {
            log.error("filePath is null");
            return;
        }

        // 文件名为空
        if (StringUtils.isEmpty(zipPath)) {
            log.error("zipPath is null");
            return;
        }
        InputStream input = null;
        File file = new File(filePath); // 要被压缩的文件夹
        File zipFile = new File(zipPath); // 压缩后的文件
        ZipOutputStream zipOut = null; // 该类实现了以ZIP文件格式写入文件的输出流过滤器。 包括对压缩和未压缩条目的支持。
        try {
            zipOut = new ZipOutputStream(FileUtils.openOutputStream(zipFile));   // 1 申请的资源
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File tempFile : files) {
                        input = FileUtils.openInputStream(tempFile);  // 2 如果是两个文件，会两次申请 FileInputStream 资源
                        System.out.println(file.getName() + File.separator + tempFile.getName());
                        // ZipEntry:表示zip文件条目   http://www.matools.com/api/java8
                        // putNextEntry:开始编写新的ZIP文件条目，并将流定位到条目数据的开头。
                        zipOut.putNextEntry(new ZipEntry(file.getName() + File.separator + tempFile.getName()));
                        int temp;
                        while ((temp = input.read()) != -1) {
                            System.out.println(temp);
                            // write将一个字节写入压缩的输出流。 该方法将阻塞直到该字节被写入。
                            zipOut.write(temp);
                        }
                        // 要对每一个input都close()
                        // 这里不用判断input是否为空，因为openInputStream要么抛出一个异常，要么返回一个实例
                        try {
                            System.out.println("关闭2处的FileInputStream资源");
                            input.close();
                            input = null;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null) {
                    System.out.println("这个地方是保护关闭2处的FileInputStream资源，一般不会走到这里");
                    input.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (zipOut != null) {
                    try {
                        zipOut.close();
                        System.out.println("关闭1处的zipOut资源");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
