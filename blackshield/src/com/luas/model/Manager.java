package com.luas.model;

/**
 * Manager.java ����Ա��
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.model->Manager.java
 * @see 2015��12��7�� ����10:19:56
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class Manager extends Users {
	public Manager() {
	}
	
	public Manager(String username, String password) {
		super(username, password);
	}

	public Manager(String username, String password, String realName) {
		super(username, password, realName);
	}
}
