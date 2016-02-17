package com.lzcc.train.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * RegNoUtils.java 身份证号码工具类
 * 
 * @author 老牟
 * @see train_01->com.lzcc.train.utils->RegNoUtils.java
 * @see 2016年2月16日 下午5:12:36
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class RegNoUtils {
	/**
	 * 根据身份证号码获取性别
	 * 
	 * @param regNo
	 * @return
	 */
	public static String getGender(String regNo) {
		if (validRegNo(regNo)) {
			// 截取倒数第二位
			char g = regNo.charAt(16);
			System.out.println(g);
			return (g % 2 == 0)?"女":"男";
		}
		return "待定";
	}

	/**
	 * 根据身份证号码获取年龄
	 * 
	 * @param regNo
	 * @return
	 */
	public static int getAge(String regNo) {
		int age = 0;
		if (validRegNo(regNo)) {
			// 截取中间年、月
			String year = regNo.substring(6,10);
			String month = regNo.substring(10,12);
			
			// 获取当前系统时间
			String systemYear = new SimpleDateFormat("yyyy").format(new Date());
			String systemMonty = new SimpleDateFormat("mm").format(new Date());
			
			// 计算年龄
			age = Integer.parseInt(systemYear) - Integer.parseInt(year);
			
			if (Integer.parseInt(systemMonty) > Integer.parseInt(month)) {
				age -= 1;
			}
			System.out.println(age);
		}
		return age;
	}

	/**
	 * 判断身份证号码是否合法 判断条件：长度18位，前17位为数字，最后1位数字或者X或者x
	 * 
	 * @param regNo
	 * @return
	 */
	public static boolean validRegNo(String regNo) {
		if (regNo != null && regNo.length() == 18) {
			String pre = regNo.substring(0, 17);
			String pub = regNo.substring(17, 18);

			try {
				Long.parseLong(pre);
			} catch (NumberFormatException e) {
				return false;
			}

			try {
				Byte.parseByte(pub);
				return true;
			} catch (NumberFormatException e) {
				char c = pub.charAt(0);
				if ((int) c == 88 || (int) c == 120) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		//System.out.println(RegNoUtils.validRegNo("62250920061212201x"));
		//System.out.println(RegNoUtils.getGender("62250919908010101x"));
		System.out.println(RegNoUtils.getAge("62250920061212201x"));
		System.out.println(RegNoUtils.getAge("620522198611030514"));
	}
}
