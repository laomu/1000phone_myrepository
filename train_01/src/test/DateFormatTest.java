package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTest {
	public static void main(String[] args) throws ParseException {
		// 1. 时间转换为字符串
		Date date = new Date();
		
		// 使用格式化对象，将时间对象转换为需要的字符串表示方式
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss:SSS");
		
		System.out.println(date);
		
		// 格式化转化
		String time = format.format(date);
		
		System.out.println(time);
		
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * *");
		// 2.将字符串，转换为时间
		// 规定要转换为时间对象的字符串格式
		format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		// String str1 = "2016年1月26日 9:50:00";
		String str2 = "2016-1-26 9:50:00";
		String str3 = "2016-01-26 09:50:00";
		
		// Date d1 = format.parse(str1);
		Date d2 = format.parse(str2);
		Date d3 = format.parse(str3);
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -v");
		// System.out.println(d1);
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -v");
		System.out.println(d2);
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - -v");
		System.out.println(d3);
		
	}
}
