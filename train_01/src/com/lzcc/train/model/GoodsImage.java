package com.lzcc.train.model;

/**
 * GoodsImage.java ��ƷͼƬ����ʵ����
 * 
 * @author ��Ĳ
 * @see train_01->com.lzcc.train.model->GoodsImage.java
 * @see 2016��1��25�� ����5:07:50
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class GoodsImage {
	private int giid;// ���
	private Goods goods;// ������Ʒ
	private String path;// ͼƬ·��

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
