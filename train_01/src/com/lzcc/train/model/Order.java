package com.lzcc.train.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	private String address;// �ջ���ַ
	private String contact;// ��ϵ��
	private String phone;// ��ϵ��ʽ
	private List<OrderItem> oiList = new ArrayList<OrderItem>();

	public Order(User user, String status, Date orderTime, double totalPrice, String address, String contact,
			String phone) {
		super();
		this.user = user;
		this.status = status;
		this.orderTime = orderTime;
		this.totalPrice = totalPrice;
		this.address = address;
		this.contact = contact;
		this.phone = phone;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int oid, User user, String status, Date orderTime, double totalPrice, String address, String contact,
			String phone) {
		super();
		this.oid = oid;
		this.user = user;
		this.status = status;
		this.orderTime = orderTime;
		this.totalPrice = totalPrice;
		this.address = address;
		this.contact = contact;
		this.phone = phone;
	}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<OrderItem> getOiList() {
		return oiList;
	}

	public void setOiList(List<OrderItem> oiList) {
		this.oiList = oiList;
	}

}
