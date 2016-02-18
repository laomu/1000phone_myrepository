package com.lzcc.train.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dao.impl.OrderItemDAO;
import com.lzcc.train.model.OrderItem;

/**
 * OrderItemService.java 
 * @author 老牟
 * @see train_01->com.lzcc.train.service->OrderItemService.java
 * @see 2016年2月18日 下午4:11:41 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class OrderItemService {
	private IDAO<OrderItem> ioDAO = new OrderItemDAO();

	/**
	 * 保存一个订单项的方法
	 * @param oi
	 * @return
	 */
	public int saveOrderItem(OrderItem orderItem) {
		return new BaseService<Integer>(){

			@Override
			public Integer service(Connection conn) throws SQLException {
				
				return ioDAO.add(conn, orderItem);
			}}.doService();
	}
}
