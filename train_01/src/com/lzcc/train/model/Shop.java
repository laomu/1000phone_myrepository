package com.lzcc.train.model;

import java.util.Date;

/**
 * Shop.java �̵�����
 * 
 * @author ��Ĳ
 * @see train_01->com.lzcc.train.model->Shop.java
 * @see 2016��1��25�� ����5:07:09
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class Shop {
	private int sid;// ���
	private User user;// �����û�:����
	private String sname;// �̵�����
	private Date createTime;// ����ʱ��
	private String sdesc;// �̵����
	private String shopImg;// �̵�����ͼƬ
	private int score;// ������

	public Shop() {
	}

	public Shop(User user, String sname, String sdesc, String shopImg) {
		super();
		this.user = user;
		this.sname = sname;
		this.sdesc = sdesc;
		this.shopImg = shopImg;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getSdesc() {
		return sdesc;
	}

	public void setSdesc(String sdesc) {
		this.sdesc = sdesc;
	}

	public String getShopImg() {
		return shopImg;
	}

	public void setShopImg(String shopImg) {
		this.shopImg = shopImg;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
