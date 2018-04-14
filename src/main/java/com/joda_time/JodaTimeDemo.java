package com.joda_time;

import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author zhangweizhou
 * Email: zhangweizhou@wanhuchina.com
 * Date:  2018/4/12
 * Time:  19:33
 */
public class JodaTimeDemo {
    public static void main(String[] args) throws ParseException {
        DateTime dateTime = new DateTime(new Date());
        DateTime dayTime = dateTime.plusDays(1);
        DateTime weekTime = dateTime.plusWeeks(1);
        DateTime monthTime = dateTime.plusMonths(1);
        DateTime otTime = dateTime.plus(1000);
        System.out.println(dateTime.toString());
        System.out.println(dateTime.toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println(dateTime.toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println(dayTime.toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println(weekTime.toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println(monthTime.toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println(otTime.toString("yyyy-MM-dd HH:mm:ss"));


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateFormat.parse("2018-04-12 20:48:39"));
        String rentalTime = "1";
        System.out.println(calendar.getTime());
        System.out.println("---------------------");
        System.out.println("---------------------");
        calendar.setTimeInMillis(calendar.getTimeInMillis() + Long.valueOf(rentalTime) * 24 * 30 * 3600 * 1000);
        System.out.println(String.valueOf(dateFormat.format(calendar.getTime())));
    }
}
