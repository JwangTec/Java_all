package com.jwang.demo_date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @PROJECT_NAME: Java_stu_all
 * @DESCRIPTION: Date类
 * @USER: jwang
 * @DATE: 2021/1/29 下午1:21
 */
public class demo1 {
    /*
    Date类：精确到毫秒值
        构造方法：Date()：当前时间 Date(Long data):标准基准时间：1970.1.1(0时区)，我们是8时区，偏移date后的日期
        其他方法：getTime():当前时间到基准时间的毫秒数
                setTime(Long date):设置

    DateFormat类:时间/日期格式化类（抽象类），使用其子类:SimpleDateFormat
        SimpleDateFormat
            构造方法：SimpleDateFormat(String pattern):创建一个日期格式化类的对象
            方法：
                format(Date date): 日期转为字符串 --格式化
                parse(String source): String 转日期 --解析

     Calender类：日历（抽象类），子类：GregorianCalendar
     静态方法：getInstance：创建日历对象
             get(int field):获取某一个参数值，field:Calender.YEAR获取相关int值
             set(int field, int value):设置
             add(int field, int amount):某个字段增加amount量
             setTime(Date date): 设置日历对象表示的日期
             before/after(Object when):判断时间在前还是后
     */

    public static void main(String[] args) throws ParseException {

        //Date
        Date datw1 = new Date();
        System.out.println(datw1);

        Date date2 = new Date(1000); //偏移一秒 1970.1.1 8:0:1
        System.out.println(date2);

        //SimpleDateFormat 格式化
        final SimpleDateFormat date4 = new SimpleDateFormat("yyyy-MM-dd");
        final String s = date4.format(datw1);
        System.out.println(s);
        //解析，字符串格式与定义的需要一致
        final Date date = date4.parse(s);

        //GregorianCalendar空参构造创建日历对象
        final GregorianCalendar gc1 = new GregorianCalendar();

        //Calendar静态方法创建日历对象--推荐
        final Calendar gc2 = Calendar.getInstance();
        //get
        final int year = gc2.get(Calendar.YEAR);
        //set

    }
}
