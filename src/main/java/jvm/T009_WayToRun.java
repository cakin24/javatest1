package jvm;

import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class T009_WayToRun {
    public static void main(String[] args) {
        for (int i = 0; i < 101000; i++) {
            getDigestResult("SHA-256","SHA-256");
            getDigestResult("SHA-rewrewreeeeeeeeeeeeeeee1","SHA-512");
        }

        // 开始计时
        long start = System.currentTimeMillis();
        int u = 0;
        for (int i = 0; i < 240000; i++) {
            getDigestResult("SHA-256","SHA-256");
            getDigestResult("SHA-rewrewreeeeeeeeeeeeeeee1","SHA-512");
        }
        // 结束计时
        long end = System.currentTimeMillis();
        System.out.println(end - start);

    }

    public static String getDigestResult(String inputStr,String hashAlgorithm)  {
        MessageDigest messageDigest;
        String reslutStr = null;
        // 获得某种摘要，例如hashAlgorithm可取为SHA-512
        try {
            // Oracle's JVM supports MD2, MD5, SHA-1, SHA-256, SHA-384, and SHA-512
            // 返回实现指定摘要算法的MessageDigest对象。
            messageDigest = MessageDigest.getInstance(hashAlgorithm);

            // inputStr不能为空
            if(StringUtils.isNotEmpty(inputStr)){
                // 使用指定的字节更新摘要。
                messageDigest.update(inputStr.getBytes("UTF-8"));
                // 将bytes数组转换为BigInterger类型。1，表示 +，即正数。
                BigInteger bigInteger = new BigInteger(1,messageDigest.digest());
                reslutStr = bigInteger.toString(16);
            }else {
                System.out.println("getDigestResult function param inputstr is null");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return reslutStr;
    }
}
