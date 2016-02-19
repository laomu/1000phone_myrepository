package com.lzcc.train.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dbhelper.DBHelper;
import com.lzcc.train.mapper.IMapper;
import com.lzcc.train.mapper.impl.OrderItemMapper;
import com.lzcc.train.model.OrderItem;
import com.lzcc.train.utils.DeleteType;
import com.lzcc.train.utils.FindType;

/**
 * OrderItemDAO.java 订单项数据访问对象
 * @author 老牟
 * @see train_01->com.lzcc.train.dao.impl->OrderItemDAO.java
 * @see 2016年1月26日 上午11:00:03 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class OrderItemDAO implements IDAO<OrderItem>{
	
	private String sql;
	private OrderItem oi;
	private List<OrderItem> oilist;
	private IMapper<OrderItem> mapper = new OrderItemMapper();
	private DBHelper<OrderItem> dh = new DBHelper<OrderItem>();

	@Override
	public int add(Connection conn, OrderItem t) throws SQLException {
		sql = "insert into `orderitem`(oid, gid, buyCount, dealPrice, subtotal)values(?,?,?,?,?)";
		return dh.executeInsert(conn, sql, t.getOrder().getOid(),t.getGoods().getGid(),t.getBuyCount(),t.getDealPrice(),t.getSubTotal());
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, OrderItem t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public OrderItem findById(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItem> findAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItem> findByConndition(Connection conn, FindType type, Object... objs) throws SQLException {
		if (type == FindType.ORDERITEM_ORDER) {
			return this.findByOrder(conn, objs);
		}
		return null;
	}
	
	private List<OrderItem> findByOrder(Connection conn, Object... objs) throws SQLException {
		sql = "select * from `orderitem` where oid = ?";
		return dh.executeQuery(conn, mapper, sql, objs);
	}

	@Override
	public int deleteByCondition(Connection conn, DeleteType type, Object... objs) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
