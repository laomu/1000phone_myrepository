package com.lzcc.train.model;

import java.util.Date;

/**
 * Shopcart.java ���ﳵʵ����
 * 
 * @author ��Ĳ
 * @see train_01->com.lzcc.train.model->Shopcart.java
 * @see 2016��1��25�� ����5:08:25
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class Shopcart {
	private int scId;// ���
	private User user;// �����û�
	private Goods goods;// �����Ʒ
	private Date addTime;// ���ʱ��
	private int shoppingCount;// ��������
	private double subTotal;// С�Ƽ۸�

	public Shopcart(User user, Goods goods, Date addTime, int shoppingCount, double subTotal) {
		super();
		this.user = user;
		this.goods = goods;
		this.addTime = addTime;
		this.shoppingCount = shoppingCount;
		this.subTotal = subTotal;
	}

	public Shopcart() {
		super();
	}

	public int getScId() {
		return scId;
	}

	public void setScId(int scId) {
		this.scId = scId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public int getShoppingCount() {
		return shoppingCount;
	}

	public void setShoppingCount(int shoppingCount) {
		this.shoppingCount = shoppingCount;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

}
