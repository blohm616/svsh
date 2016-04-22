package xiezhy.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * version:
 * --------------------
 * date:2016/3/18
 * author:binbin
 */
public class StringUtil {
    // get方式改变文本格式
    public static String changeGetStr(String str) {
        if (str == null)
            return null;
        String retStr = str;
        byte b[];
        try {
            b = str.getBytes("ISO8859_1");

            for (int i = 0; i < b.length; i++) {
                byte b1 = b[i];
                if (b1 == 63)
                    break; // 1
                else if (b1 > 0)
                    continue;// 2
                else if (b1 < 0) { // 不可能为0，0为字符串结束符
                    retStr = new String(b, "UTF-8");
                    break;
                }
            }
        } catch (Exception e) {

        }
        return retStr;
    }

    /**
     * 去掉html标签
     */
    private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
    private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
    private static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
    private static final String regEx_space = "\\s*|\t|\r|\n";// 定义空格回车换行符

    public static String delHTMLTag(String htmlStr) {
        Pattern p_script = Pattern.compile(regEx_script,
                Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); // 过滤script标签

        Pattern p_style = Pattern
                .compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); // 过滤style标签

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); // 过滤html标签

        Pattern p_space = Pattern
                .compile(regEx_space, Pattern.CASE_INSENSITIVE);
        Matcher m_space = p_space.matcher(htmlStr);
        htmlStr = m_space.replaceAll(""); // 过滤空格回车标签

        htmlStr = htmlStr.replaceAll("&nbsp;", "");

        return htmlStr.trim(); // 返回文本字符串
    }
}
