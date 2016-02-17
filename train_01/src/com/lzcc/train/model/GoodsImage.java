package com.lzcc.train.model;

/**
 * GoodsImage.java 商品图片类型实体类
 * 
 * @author 老牟
 * @see train_01->com.lzcc.train.model->GoodsImage.java
 * @see 2016年1月25日 下午5:07:50
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class GoodsImage {
	private int giid;// 编号
	private Goods goods;// 所属商品
	private String path;// 图片路径

	public GoodsImage(Goods goods, String path) {
		super();
		this.goods = goods;
		this.path = path;
	}

	public GoodsImage() {
	}

	public int getGiid() {
		return giid;
	}

	public void setGiid(int giid) {
		this.giid = giid;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
