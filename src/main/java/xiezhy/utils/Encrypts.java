package xiezhy.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/**
 * Created by binbin on 2015/11/15.
 */
public class Encrypts {

    private Encrypts() {
    }

    /**
     * MD5加密
     *
     * @param msg
     * @return
     */
    public static String encryptMD5(String msg) {
        String newMsg = "";
        if (msg != null) {
            char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            try {
                byte[] btInput = msg.getBytes();
                // 获得MD5摘要算法的 MessageDigest 对象
                MessageDigest mdInst = MessageDigest.getInstance("MD5");
                // 使用指定的字节更新摘要
                mdInst.update(btInput);
                // 获得密文
                byte[] md = mdInst.digest();
                // 把密文转换成十六进制的字符串形式
                int j = md.length;
                char str[] = new char[j * 2];
                int k = 0;
                for (int i = 0; i < j; i++) {
                    byte byte0 = md[i];
                    str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                    str[k++] = hexDigits[byte0 & 0xf];
                }
                return new String(str);
            } catch (Exception e) {
                e.printStackTrace();
                return newMsg;
            }
        }

        return newMsg;
    }

/*******************************华丽丽的分割线*****************************************/
    /**
     * base64加密解密
     */

    // 加密
    public static String encryptBase64(String str) {
        byte[] b = null;
        String s = "";
        try {
            b = str.getBytes("utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return s;
        }
        if (b != null) {
            s = new BASE64Encoder().encode(b);
        }
        return s;
    }

    // 解密
    public static String decoderBase64(String s) {
        byte[] b = null;
        String result = "";
        if (s != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(s);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
                return result;
            }
        }
        return result;
    }

/*******************************华丽丽的分割线*****************************************/

}
