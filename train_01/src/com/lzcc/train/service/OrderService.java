package com.lzcc.train.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dao.impl.OrderDAO;
import com.lzcc.train.model.Order;
import com.lzcc.train.model.OrderItem;
import com.lzcc.train.model.User;
import com.lzcc.train.utils.FindType;

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
	private OrderItemService oiService = new OrderItemService();
	private Order order;
	private List<Order> orderList;
	private List<OrderItem> oiList;
	private OrderItem orderItem;

	public int saveOrder(Order order) {
		return new BaseService<Integer>(){

			@Override
			public Integer service(Connection conn) throws SQLException {
				return orderDAO.add(conn, order);
			}}.doService();
	}
	
	/**
	 * ��ѯ��ǰ�û����ж���
	 * @param user
	 * @return
	 */
	public List<Order> findByUser(User user) {
		return new BaseService<List<Order>>(){

			@Override
			public List<Order> service(Connection conn) throws SQLException {
				// ��ѯ��ǰ�û����ж���
				orderList = orderDAO.findByConndition(conn, FindType.ORDER_USER, user.getUid());
				// ���ݶ�����ѯ�û��Ķ�����Ŀ
				for (int i = 0; i < orderList.size(); i++) {
					order = orderList.get(i);
					oiList = oiService.findByOrder(order);
					order.setOiList(oiList);
				}
				
				return orderList;
			}}.doService();
	}
}
