package com.lzcc.train.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dao.impl.OrderDAO;
import com.lzcc.train.model.Order;

/**
 * OrderService.java 订单处理类
 * @author 老牟
 * @see train_01->com.lzcc.train.service->OrderService.java
 * @see 2016年2月18日 下午3:59:56 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class OrderService {
	private IDAO<Order> orderDAO = new OrderDAO();

	public int saveOrder(Order order) {
		return new BaseService<Integer>(){

			@Override
			public Integer service(Connection conn) throws SQLException {
				return orderDAO.add(conn, order);
			}}.doService();
	}
}
