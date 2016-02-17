package com.lzcc.train.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * RegNoUtils.java ���֤���빤����
 * 
 * @author ��Ĳ
 * @see train_01->com.lzcc.train.utils->RegNoUtils.java
 * @see 2016��2��16�� ����5:12:36
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class RegNoUtils {
	/**
	 * �������֤�����ȡ�Ա�
	 * 
	 * @param regNo
	 * @return
	 */
	public static String getGender(String regNo) {
		if (validRegNo(regNo)) {
			// ��ȡ�����ڶ�λ
			char g = regNo.charAt(16);
			System.out.println(g);
			return (g % 2 == 0)?"Ů":"��";
		}
		return "����";
	}

	/**
	 * �������֤�����ȡ����
	 * 
	 * @param regNo
	 * @return
	 */
	public static int getAge(String regNo) {
		int age = 0;
		if (validRegNo(regNo)) {
			// ��ȡ�м��ꡢ��
			String year = regNo.substring(6,10);
			String month = regNo.substring(10,12);
			
			// ��ȡ��ǰϵͳʱ��
			String systemYear = new SimpleDateFormat("yyyy").format(new Date());
			String systemMonty = new SimpleDateFormat("mm").format(new Date());
			
			// ��������
			age = Integer.parseInt(systemYear) - Integer.parseInt(year);
			
			if (Integer.parseInt(systemMonty) > Integer.parseInt(month)) {
				age -= 1;
			}
			System.out.println(age);
		}
		return age;
	}

	/**
	 * �ж����֤�����Ƿ�Ϸ� �ж�����������18λ��ǰ17λΪ���֣����1λ���ֻ���X����x
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
