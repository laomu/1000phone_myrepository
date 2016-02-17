package com.lzcc.train.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Goods.java 商品实体类
 * 
 * @author 老牟
 * @see train_01->com.lzcc.train.model->Goods.java
 * @see 2016年1月25日 下午5:08:07
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class Goods {
	private int gid;// 编号
	private GoodsType goodsType;// 商品类型
	private ActivityType activityType;// 活动类型
	private Shop shop;// 所属商店
	private String gname;// 商品名称
	private double originalCost;// 原价
	private double price;// 单价
	private int stock;// 库存
	private String gdesc;// 商品描述
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
