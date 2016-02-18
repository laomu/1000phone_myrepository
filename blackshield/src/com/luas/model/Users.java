package com.luas.model;

import java.util.Date;

/**
 * Users.java 所有用户的超级父类
 * 
 * @author 老牟
 * @see blackshield->com.luas.model->Users.java
 * @see 2015年12月7日 上午10:22:50
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public abstract class Users {

	private int id;// 编号
	private String username;// 账号
	private String password;// 密码
	private String realName;// 真实姓名
	private String phone;// 联系方式
	private String headerImg;// 头像
	private String email; // 邮箱
	private Date registTime;// 添加日期

	public Users(String username, String password, String realName) {
		super();
		this.username = username;
		this.password = password;
		this.realName = realName;
	}

	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Users(int id, String username, String password, String realName, String phone, String headerImg) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.realName = realName;
		this.phone = phone;
		this.headerImg = headerImg;
	}

	public Users() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHeaderImg() {
		return headerImg;
	}

	public void setHeaderImg(String headerImg) {
		this.headerImg = headerImg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegistTime() {
		return registTime;
	}

	public void setRegistTime(Date registTime) {
		this.registTime = registTime;
	}

}
