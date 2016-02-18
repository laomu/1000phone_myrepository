package com.luas.model;

/**
 * Manager.java 管理员类
 * 
 * @author 老牟
 * @see blackshield->com.luas.model->Manager.java
 * @see 2015年12月7日 上午10:19:56
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
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
