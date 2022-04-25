package com.atguigu.fruit.util;

/**
 * @author shkstart
 * @create 2022-03-14 19:33
 */
public class StringUtil {
    //判断字符串是否为null或""
    public static boolean isEmpty(String str){
        return str == null || "".equals(str);
    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }
}
