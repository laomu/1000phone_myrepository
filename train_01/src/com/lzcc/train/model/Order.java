package com.lzcc.train.model;

import java.util.Date;

/**
 * Order.java 订单实体类
 * 
 * @author 老牟
 * @see train_01->com.lzcc.train.model->Order.java
 * @see 2016年1月25日 下午5:08:37
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class Order {
	private int oid;// 编号
	private User user;// 所属用户
	private String status;// 订单状态
	private Date orderTime;// 下单时间
	private double totalPrice;// 总计价格

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
