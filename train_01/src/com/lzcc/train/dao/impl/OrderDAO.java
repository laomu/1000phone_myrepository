package com.lzcc.train.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.model.Order;
import com.lzcc.train.utils.DeleteType;
import com.lzcc.train.utils.FindType;

/**
 * OrderDAO.java �������ݷ��ʶ���
 * @author ��Ĳ
 * @see train_01->com.lzcc.train.dao.impl->OrderDAO.java
 * @see 2016��1��26�� ����10:59:37 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class OrderDAO implements IDAO<Order>{

	@Override
	public int add(Connection conn, Order t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, Order t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Order findById(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findByConndition(Connection conn, FindType type, Object... objs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByCondition(Connection conn, DeleteType type, Object... objs) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
