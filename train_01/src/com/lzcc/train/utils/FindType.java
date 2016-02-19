package com.lzcc.train.utils;
/**
 * FindType.java 查询类型枚举
 * @author 老牟
 * @see train_01->com.lzcc.train.utils->FindType.java
 * @see 2016年1月26日 上午11:12:27 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public enum FindType {
	/*
	 *  定义格式：类名称_条件列表
	 *  如：根据用户类型的账号和密码查询：USER_USERNAME_PASSWORD
	 */
	USER_USERNAME_PASSWORD,
	USER_USERNAME,
	ADDRESS_USER,
	ADDRESS_DEFAULT,
	SHOP_USER,
	GOODS_SHOP,
	GOODSIMAGE_GOODS,
	SHOPCART_USER_GOODS,
	SHOPCART_USER,
	GOODS_SEARCH,
	ORDER_USER,
	ORDERITEM_ORDER
}
