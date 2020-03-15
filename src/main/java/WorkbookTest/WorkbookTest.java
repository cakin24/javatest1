package WorkbookTest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;

/**
 * Copyright (C), 2020-2020, XXX有限公司
 * FileName: Workbook
 * Author:   cakin
 * Date:     2020/1/18
 * Description: 获取对应Excel文件的Workbook对象
 */
public class WorkbookTest {
    public static void main( String[] args ) {
        String file = "F:\\Javatest\\tempTest\\test.xlsx1";
        File fileTest = new File(file);
        Workbook workbook = getWorkbook(fileTest);
        System.out.println("workbook:"+workbook);
    }

    public static Workbook getWorkbook( File file ) {
        Workbook wb = null;
        try {
            if (file.exists() && file.isFile()) {
                // 文件名
                String fileName = file.getName();
                // 文件扩展名
                String extension = fileName.lastIndexOf(".") == -1 ? "" : fileName.substring(fileName.lastIndexOf(".") + 1);
                // 文件输入流
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    if ("xls".equals(extension)) { //Excel 2003
                        // 参考   https://www.cnblogs.com/fqfanqi/p/6172223.html
                        // 得到Excel工作簿对象
                        wb = new HSSFWorkbook(fileInputStream);
                    } else if ("xlsx".equals(extension)) { //Excel 2007
                        wb = new XSSFWorkbook(fileInputStream);
                    } else {
                        throw new IOException("not support the file type");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        // 关闭资源
                        System.out.println("关闭资源");
                        fileInputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return wb;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
