package com.lzcc.train.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dbhelper.DBHelper;
import com.lzcc.train.mapper.IMapper;
import com.lzcc.train.mapper.impl.ShopMapper;
import com.lzcc.train.model.Shop;
import com.lzcc.train.utils.DeleteType;
import com.lzcc.train.utils.FindType;

/**
 * ShopDAO.java 商店数据访问对象
 * @author 老牟
 * @see train_01->com.lzcc.train.dao.impl->ShopDAO.java
 * @see 2016年1月26日 上午11:00:53 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ShopDAO implements IDAO<Shop> {
	private String sql;
	private Shop shop;
	private List<Shop> slist;
	private DBHelper<Shop> dh = new DBHelper<Shop>();
	private IMapper<Shop> mapper = new ShopMapper();

	@Override
	public int add(Connection conn, Shop t) throws SQLException {
		sql = "insert into shop(uid, sname, createtime, sdesc, shopimg, score) values(?,?,?,?,?,?)";
		return dh.executeInsert(conn, sql, t.getUser().getUid(),
											t.getSname(),
											new Date(),
											t.getSdesc(),
											t.getShopImg(),
											0);
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		sql = "delete from shop where sid = ?";
		return dh.executeSQL(conn, sql, id);
	}

	@Override
	public int update(Connection conn, Shop t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Shop findById(Connection conn, int id) throws SQLException {
		sql = "select * from shop where sid = ?";
		slist = dh.executeQuery(conn, mapper, sql, id);
		if (slist != null && slist.size() > 0) {
			return slist.get(0);
		}
		return null;
	}

	@Override
	public List<Shop> findAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shop> findByConndition(Connection conn, FindType type, Object... objs) throws SQLException {
		if (type == FindType.SHOP_USER) {
			return this.findByUser(conn, objs);
		}
		return null;
	}
	
	/*
	 * 根据用户查询所有商店的方法
	 */
	private List<Shop> findByUser(Connection conn, Object... objs) throws SQLException {
		sql = "select * from shop where uid = ?";
		return dh.executeQuery(conn, mapper, sql, objs);
	}

	@Override
	public int deleteByCondition(Connection conn, DeleteType type, Object... objs) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
