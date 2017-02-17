package com.ding.favorites.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * Created by hzdzf on 2017/2/14.
 */
public class DateUtil {

    public static String dateToString(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }



}
