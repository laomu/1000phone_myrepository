package com.luas.model;

import java.util.Date;

/**
 * Users.java �����û��ĳ�������
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.model->Users.java
 * @see 2015��12��7�� ����10:22:50
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public abstract class Users {

	private int id;// ���
	private String username;// �˺�
	private String password;// ����
	private String realName;// ��ʵ����
	private String phone;// ��ϵ��ʽ
	private String headerImg;// ͷ��
	private String email; // ����
	private Date registTime;// �������

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
