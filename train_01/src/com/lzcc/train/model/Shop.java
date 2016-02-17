package com.lzcc.train.model;

import java.util.Date;

/**
 * Shop.java 商店类型
 * 
 * @author 老牟
 * @see train_01->com.lzcc.train.model->Shop.java
 * @see 2016年1月25日 下午5:07:09
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class Shop {
	private int sid;// 编号
	private User user;// 所属用户:店主
	private String sname;// 商店名称
	private Date createTime;// 创建时间
	private String sdesc;// 商店介绍
	private String shopImg;// 商店门面图片
	private int score;// 好评度

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
