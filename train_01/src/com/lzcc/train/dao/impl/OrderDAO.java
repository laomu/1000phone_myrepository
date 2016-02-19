package com.lzcc.train.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dbhelper.DBHelper;
import com.lzcc.train.mapper.IMapper;
import com.lzcc.train.mapper.impl.OrderMapper;
import com.lzcc.train.model.Order;
import com.lzcc.train.utils.DeleteType;
import com.lzcc.train.utils.FindType;

/**
 * OrderDAO.java 订单数据访问对象
 * @author 老牟
 * @see train_01->com.lzcc.train.dao.impl->OrderDAO.java
 * @see 2016年1月26日 上午10:59:37 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class OrderDAO implements IDAO<Order>{
	
	private String sql;
	private Order order;
	private List<Order> olist;
	private IMapper<Order> mapper = new OrderMapper();
	private DBHelper<Order> dh = new DBHelper<Order>();

	@Override
	public int add(Connection conn, Order t) throws SQLException {
		sql = "insert into `order`(uid, status, ordertime, totalprice, address, contact, phone)values(?,?,?,?,?,?,?)";
		return dh.executeInsert(conn, sql, t.getUser().getUid(),
											t.getStatus(),
											t.getOrderTime(),
											t.getTotalPrice(),
											t.getAddress(),
											t.getContact(),
											t.getPhone());
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
		sql = "select * from `order` where oid = ?";
		olist = dh.executeQuery(conn, mapper, sql, id);
		if (olist != null && olist.size() > 0) {
			return olist.get(0);
		}
		return null;
	}

	@Override
	public List<Order> findAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> findByConndition(Connection conn, FindType type, Object... objs) throws SQLException {
		if (type == FindType.ORDER_USER) {
			return this.findByUser(conn, objs);
		}
		return null;
	}
	
	private List<Order> findByUser(Connection conn, Object... objs) throws SQLException {
		sql = "select * from `order` where uid = ? order by ordertime desc";
		return dh.executeQuery(conn, mapper, sql, objs);
	}

	@Override
	public int deleteByCondition(Connection conn, DeleteType type, Object... objs) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
