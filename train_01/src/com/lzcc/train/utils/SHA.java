package com.lzcc.train.utils;

import java.security.MessageDigest;

/**
 * SHA.java SHA�����㷨
 * 
 * @author ��Ĳ
 * @see train_01->com.lzcc.train.utils->SHA.java
 * @see 2016��2��15�� ����3:31:56
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class SHA {
	/***
	 * SHA���� ����40λSHA��
	 * 
	 * @param �������ַ���
	 * @return ����40λSHA��
	 */
	public static String shaEncode(String inStr) throws Exception {
		MessageDigest sha = null;
		try {
			sha = MessageDigest.getInstance("SHA");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
			return "";
		}

		byte[] byteArray = inStr.getBytes("UTF-8");
		byte[] md5Bytes = sha.digest(byteArray);
		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}

	/**
	 * ����������
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		String str = new String("adminmanagermanagert");
		System.out.println("ԭʼ��" + str);
		System.out.println("SHA��" + shaEncode(str));
	}
}
