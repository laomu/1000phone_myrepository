package com.luas.model;

/**
 * Member.java ��Ա��
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.model->Member.java
 * @see 2015��12��7�� ����10:20:12
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class Member extends Users {

	private boolean isLock;

	public Member() {
	}

	public Member(String username, String password) {
		super(username, password);
	}

	public Member(String username, String password, String realName) {
		super(username, password, realName);
	}

	public boolean isLock() {
		return isLock;
	}

	public void setLock(boolean isLock) {
		this.isLock = isLock;
	}

}
