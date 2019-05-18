/**
 * @Author: Liang
 * @Date: 2019/5/18 22:27
 * @Version 1.0
 */
package com.liang.admin_4.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Liang
 * @date 2019/5/18 22:27
 * 日期字符串转换
 */
public class DateUtils {
    //日期转换字符串
    public static  String date2string(Date date, String patt){
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }

    //字符串转换日期
    public static  Date string2date(Date date,String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date date1 = sdf.parse(patt);
        return  date1;
    }
}
