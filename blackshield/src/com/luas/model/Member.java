package com.luas.model;

/**
 * Member.java 会员类
 * 
 * @author 老牟
 * @see blackshield->com.luas.model->Member.java
 * @see 2015年12月7日 上午10:20:12
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
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
