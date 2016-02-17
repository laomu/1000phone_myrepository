package com.lzcc.train.model;

import java.sql.Timestamp;

/**
 * User.java �û�����
 * 
 * @author ��Ĳ
 * @see train_01->com.lzcc.train.model->User.java
 * @see 2016��1��25�� ����5:06:51
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class User {
	private int uid;// ���
	private String username;// �˺�
	private String password;// ����
	private String nickName;// �ǳ�
	private Timestamp registTime;// ע��ʱ��
	private String regNo;// ���֤����
	private int age;// ����
	private String gender;// �Ա�
	private int score;// ����
	private boolean status;// �Ƿ����
	private String phone;// �ֻ�
	private String email;// ����

	public User() {
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(String username, String password, String nickName) {
		super();
		this.username = username;
		this.password = password;
		this.nickName = nickName;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Timestamp getRegistTime() {
		return registTime;
	}

	public void setRegistTime(Timestamp registTime) {
		this.registTime = registTime;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
