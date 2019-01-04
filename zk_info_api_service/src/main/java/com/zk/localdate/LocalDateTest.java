package com.zk.localdate;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author Zhangk
 * @Date 10:39 2018/11/23
 * @Description
 */
public class LocalDateTest {

    public static void main(String []args) {
        /**
         * date表示时间点对象
         * LocalDate表示日历对象
         */
        LocalDate now = LocalDate.now();
        /**
         * 2018-11-23
         */
        System.out.println(now.toString());

        LocalDateTime now1 = LocalDateTime.now();
        /**
         * 2018-11-23T10:55:24.792
         */
        System.out.println(now1);
        LocalDate parse = LocalDate.parse("2018-11-23");
        System.out.println(parse);
        System.out.println(parse.getYear());
        DayOfWeek dayOfWeek = parse.getDayOfWeek();
        System.out.println(dayOfWeek);
        LocalDate localDate = parse.plusDays(60);
        System.out.println(localDate);

        System.out.println("1 2 3 4 5 6 7");
        /**
         * 当前多第多少天
         */
        int dayOfMonth = now.getDayOfMonth();
        System.out.println(dayOfMonth);
        /**
         * 第几个月
         */
        int monthValue = now.getMonthValue();
        System.out.println(monthValue);
        /**
         * 2018-11-01
         * 月初
         */
        LocalDate localDate1 = now.minusDays(now.getDayOfMonth()-1);
        int week = now.getDayOfWeek().getValue();
        System.out.println(week);
        LocalDate localDate2 = localDate1.plusDays(1);
        System.out.println(localDate2);

        int currMonth = monthValue;

        System.out.println("1 2 3 4 5 6 7");
        for(int i=1;i<week;i++) {
            System.out.print("* ");
        }


        /*LocalDate date = LocalDate.now ();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth () ;
        date = date.minusDays(today - 1); // Set to start of month
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue(); // I - Monday , . . . 7 = Sunday
        System.out.println ( " Mon Tue Wed Thu Fri Sat Sun " ) ;
        for ( int i = 1 ; i < value ; i++) {

            System.out.print(" ");
        }
        while ( date.getMonthValue() == month )
        {
            System.out.printf ( "%3d" , date.getDayOfMonth ()) ;
            if ( date.getDayOfMonth() == today )
            {
                System.out.print ( " * " ) ;
            }
            else {

                System.out.print (" ") ;
                date = date.plusDays (1) ;
            }
            if (date.getDayOfWeek().getValue ( ) == 1) {

                System.out.println();
            }
        }
        if ( date.getDayOfWeek().getValue() != 1 ) {
            System.out.println();
        }*/
    }
}
