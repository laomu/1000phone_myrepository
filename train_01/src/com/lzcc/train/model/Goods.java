package com.lzcc.train.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Goods.java ��Ʒʵ����
 * 
 * @author ��Ĳ
 * @see train_01->com.lzcc.train.model->Goods.java
 * @see 2016��1��25�� ����5:08:07
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class Goods {
	private int gid;// ���
	private GoodsType goodsType;// ��Ʒ����
	private ActivityType activityType;// �����
	private Shop shop;// �����̵�
	private String gname;// ��Ʒ����
	private double originalCost;// ԭ��
	private double price;// ����
	private int stock;// ���
	private String gdesc;// ��Ʒ����
	private List<GoodsImage> giList = new ArrayList<GoodsImage>();

	public List<GoodsImage> getGiList() {
		return giList;
	}

	public void setGiList(List<GoodsImage> giList) {
		this.giList = giList;
	}

	public Goods() {
	}

	public Goods(GoodsType goodsType, ActivityType activityType, Shop shop, String gname, double originalCost,
			double price, int stock, String gdesc) {
		super();
		this.goodsType = goodsType;
		this.activityType = activityType;
		this.shop = shop;
		this.gname = gname;
		this.originalCost = originalCost;
		this.price = price;
		this.stock = stock;
		this.gdesc = gdesc;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public GoodsType getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}

	public ActivityType getActivityType() {
		return activityType;
	}

	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public double getOriginalCost() {
		return originalCost;
	}

	public void setOriginalCost(double originalCost) {
		this.originalCost = originalCost;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getGdesc() {
		return gdesc;
	}

	public void setGdesc(String gdesc) {
		this.gdesc = gdesc;
	}

}
