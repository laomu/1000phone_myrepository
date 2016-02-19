package com.lzcc.train.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dao.impl.GoodsDAO;
import com.lzcc.train.dao.impl.OrderDAO;
import com.lzcc.train.mapper.IMapper;
import com.lzcc.train.model.Goods;
import com.lzcc.train.model.Order;
import com.lzcc.train.model.OrderItem;
import com.lzcc.train.service.GoodsService;

/**
 * OrderItemMapper.java ������Ŀʵ����ӳ���ϵ��
 * @author ��Ĳ
 * @see train_01->com.lzcc.train.mapper.impl->OrderItemMapper.java
 * @see 2016��1��26�� ����10:55:06 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class OrderItemMapper implements IMapper<OrderItem>{
	
	private IDAO<Order> orderDAO = new OrderDAO();

	@Override
	public OrderItem mapper(Connection conn, ResultSet rs) throws SQLException {
		OrderItem orderItem = new OrderItem();
		orderItem.setOiId(rs.getInt("oiid"));
		orderItem.setOrder(orderDAO.findById(conn, rs.getInt("oid")));
		orderItem.setGoods(new GoodsService().findById(String.valueOf(rs.getInt("gid"))));
		orderItem.setBuyCount(rs.getInt("buyCount"));
		orderItem.setDealPrice(rs.getDouble("dealprice"));
		orderItem.setSubTotal(rs.getDouble("subtotal"));
		return orderItem;
	}

}
