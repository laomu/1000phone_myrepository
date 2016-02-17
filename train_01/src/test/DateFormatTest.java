package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTest {
	public static void main(String[] args) throws ParseException {
		// 1. ʱ��ת��Ϊ�ַ���
		Date date = new Date();
		
		// ʹ�ø�ʽ�����󣬽�ʱ�����ת��Ϊ��Ҫ���ַ�����ʾ��ʽ
		SimpleDateFormat format = new SimpleDateFormat("yyyy��MM��dd��  HH:mm:ss:SSS");
		
		System.out.println(date);
		
		// ��ʽ��ת��
		String time = format.format(date);
		
		System.out.println(time);
		
		System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * *");
		// 2.���ַ�����ת��Ϊʱ��
		// �涨Ҫת��Ϊʱ�������ַ�����ʽ
		format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		// String str1 = "2016��1��26�� 9:50:00";
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
