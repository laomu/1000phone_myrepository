package com.lzcc.train.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dao.impl.OrderDAO;
import com.lzcc.train.model.Order;

/**
 * OrderService.java ����������
 * @author ��Ĳ
 * @see train_01->com.lzcc.train.service->OrderService.java
 * @see 2016��2��18�� ����3:59:56 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see �ֻ���15294157465
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
