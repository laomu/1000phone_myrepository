package com.lzcc.train.model;

/**
 * OrderItem.java 订单类型实体类
 * 
 * @author 老牟
 * @see train_01->com.lzcc.train.model->OrderItem.java
 * @see 2016年1月25日 下午5:08:50
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class OrderItem {
	private int oiId;// 编号
	private Order order;// 所属订单
	private Goods goods;// 包含商品
	private int buyCount;// 购买数量
	private double dealPrice;// 成交价格
	private double subTotal;// 小计价格

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
