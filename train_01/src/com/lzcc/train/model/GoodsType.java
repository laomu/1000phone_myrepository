package com.lzcc.train.model;

/**
 * GoodsType.java 商品类型实体类
 * 
 * @author 老牟
 * @see train_01->com.lzcc.train.model->GoodsType.java
 * @see 2016年1月25日 下午5:07:21
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class GoodsType {
	private int gtId;// 编号
	private String gtName;// 类型名称

	public int getGtId() {
		return gtId;
	}

	public void setGtId(int gtId) {
		this.gtId = gtId;
	}

	public String getGtName() {
		return gtName;
	}

	public void setGtName(String gtName) {
		this.gtName = gtName;
	}

}
