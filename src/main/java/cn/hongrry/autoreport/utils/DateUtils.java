package cn.hongrry.autoreport.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Hongrry
 * @create 2021-08-03 19:21
 */
public class DateUtils {
    public static String getSimpleDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return sdf.format(date);
    }
    public static Date parsesDateString(String date){
        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd");
        Date t = null;
        try {
            t = sdf.parse(date);
            System.out.println(t);
        } catch (ParseException e) {
            System.out.println("Unparseable using " + sdf);
        }
        return t;

    }
    public static int differentDaysByMillisecond( Date date1,Date date2) {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days;
    }
}
