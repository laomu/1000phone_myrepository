package com.lzcc.train.model;

/**
 * OrderItem.java ��������ʵ����
 * 
 * @author ��Ĳ
 * @see train_01->com.lzcc.train.model->OrderItem.java
 * @see 2016��1��25�� ����5:08:50
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class OrderItem {
	private int oiId;// ���
	private Order order;// ��������
	private Goods goods;// ������Ʒ
	private int buyCount;// ��������
	private double dealPrice;// �ɽ��۸�
	private double subTotal;// С�Ƽ۸�

	public OrderItem(Order order, Goods goods, int buyCount, double dealPrice, double subTotal) {
		super();
		this.order = order;
		this.goods = goods;
		this.buyCount = buyCount;
		this.dealPrice = dealPrice;
		this.subTotal = subTotal;
	}

	public OrderItem() {
	}

	public int getOiId() {
		return oiId;
	}

	public void setOiId(int oiId) {
		this.oiId = oiId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getBuyCount() {
		return buyCount;
	}

	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}

	public double getDealPrice() {
		return dealPrice;
	}

	public void setDealPrice(double dealPrice) {
		this.dealPrice = dealPrice;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

}
