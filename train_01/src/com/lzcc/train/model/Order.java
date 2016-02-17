package com.lzcc.train.model;

import java.util.Date;

/**
 * Order.java ����ʵ����
 * 
 * @author ��Ĳ
 * @see train_01->com.lzcc.train.model->Order.java
 * @see 2016��1��25�� ����5:08:37
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class Order {
	private int oid;// ���
	private User user;// �����û�
	private String status;// ����״̬
	private Date orderTime;// �µ�ʱ��
	private double totalPrice;// �ܼƼ۸�

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
