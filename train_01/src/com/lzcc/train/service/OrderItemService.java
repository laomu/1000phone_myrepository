package com.lzcc.train.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dao.impl.OrderItemDAO;
import com.lzcc.train.model.Order;
import com.lzcc.train.model.OrderItem;
import com.lzcc.train.utils.FindType;

/**
 * OrderItemService.java 
 * @author ��Ĳ
 * @see train_01->com.lzcc.train.service->OrderItemService.java
 * @see 2016��2��18�� ����4:11:41 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class OrderItemService {
	private IDAO<OrderItem> ioDAO = new OrderItemDAO();

	/**
	 * ����һ��������ķ���
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
	
	/**
	 * ���ݶ�����ѯ�����е�ÿһ��
	 * @param order
	 * @return
	 */
	public List<OrderItem> findByOrder(Order order) {
		return new BaseService<List<OrderItem>>(){

			@Override
			public List<OrderItem> service(Connection conn) throws SQLException {
				return ioDAO.findByConndition(conn, FindType.ORDERITEM_ORDER, order.getOid());
			}}.doService();
	}
}
