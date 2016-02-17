package com.lzcc.train.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dbhelper.DBHelper;
import com.lzcc.train.mapper.IMapper;
import com.lzcc.train.mapper.impl.ShopcartMapper;
import com.lzcc.train.model.Shopcart;
import com.lzcc.train.utils.DeleteType;
import com.lzcc.train.utils.FindType;

/**
 * ShopcartDAO.java 购物车数据访问对象
 * @author 老牟
 * @see train_01->com.lzcc.train.dao.impl->ShopcartDAO.java
 * @see 2016年1月26日 上午11:00:33 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ShopcartDAO implements IDAO<Shopcart>{
	private String sql;
	private List<Shopcart> sclist;
	private Shopcart shopcart;
	private DBHelper<Shopcart> dh = new DBHelper<Shopcart>();
	private IMapper<Shopcart> mapper = new ShopcartMapper();

	@Override
	public int add(Connection conn, Shopcart t) throws SQLException {
		sql = "insert into shopcart(uid, gid, addtime, shoppingcount, subtotal)values(?,?,?,?,?)";
		return dh.executeInsert(conn, sql, t.getUser().getUid(),t.getGoods().getGid(),t.getAddTime(),t.getShoppingCount(),t.getSubTotal());
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, Shopcart t) throws SQLException {
		sql = "update shopcart set uid = ?,"
								+ "gid= ?,"
								+ "addtime = ?,"
								+ "shoppingcount = ?,"
								+ "subtotal = ? where scid = ?";
		return dh.executeSQL(conn, sql, t.getUser().getUid(),
										t.getGoods().getGid(),
										t.getAddTime(),
										t.getShoppingCount(),
										t.getSubTotal(),
										t.getScId());
	}

	@Override
	public Shopcart findById(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shopcart> findAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shopcart> findByConndition(Connection conn, FindType type, Object... objs) throws SQLException {
		if (type == FindType.SHOPCART_USER_GOODS) {
			return this.findByUserAndGoods(conn, objs);
		} else if(type == FindType.SHOPCART_USER) {
			return this.findByUser(conn, objs);
		}
		return null;
	}
	/*
	 * 根据用户和商品查询购物对象
	 */
	private List<Shopcart> findByUserAndGoods(Connection conn, Object... objs) throws SQLException {
		sql = "select * from shopcart where uid = ? and gid = ?";
		return dh.executeQuery(conn, mapper, sql, objs);
	}
	
	/*
	 * 根据用户查询购物对象
	 */
	private List<Shopcart> findByUser(Connection conn, Object... objs) throws SQLException {
		sql = "select * from shopcart where uid = ? order by addtime desc";
		return dh.executeQuery(conn, mapper, sql, objs);
	}

	@Override
	public int deleteByCondition(Connection conn, DeleteType type, Object... objs) throws SQLException {
		if (type == DeleteType.SHOPCART_GOODS) {
			return this.deleteByCondition(conn, objs);
		}
		return 0;
	}
	
	/**
	 * 根据商品编号删除购物对象
	 * @param conn
	 * @param objs
	 * @return
	 * @throws SQLException
	 */
	private int deleteByCondition(Connection conn, Object... objs) throws SQLException {
		sql = "delete from shopcart where gid = ?";
		return dh.executeSQL(conn, sql, objs);
	}

}
