package com.lzcc.train.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dbhelper.DBHelper;
import com.lzcc.train.mapper.IMapper;
import com.lzcc.train.mapper.impl.GoodsMapper;
import com.lzcc.train.model.Goods;
import com.lzcc.train.utils.DeleteType;
import com.lzcc.train.utils.FindType;

/**
 * GoodsDAO.java 商品数据访问对象
 * 
 * @author 老牟
 * @see train_01->com.lzcc.train.dao.impl->GoodsDAO.java
 * @see 2016年1月26日 上午10:58:31
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class GoodsDAO implements IDAO<Goods> {
	private String sql;
	private DBHelper<Goods> dh = new DBHelper<Goods>();
	private Goods goods;
	private List<Goods> goodsList;
	private IMapper<Goods> mapper= new GoodsMapper();

	@Override
	public int add(Connection conn, Goods t) throws SQLException {
		sql = "insert into goods(gtid, atid, sid, originalcost,price,stock,gdesc, gname ) values(?,?,?,?,?,?,?,?)";
		return dh.executeInsert(conn, sql, t.getGoodsType().getGtId(),
											t.getActivityType().getAtId(),
											t.getShop().getSid(),
											t.getOriginalCost(),
											t.getPrice(),
											t.getStock(),
											t.getGdesc(),
											t.getGname());
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		sql = "delete from goods where gid = ?";
		return dh.executeSQL(conn, sql, id);
	}

	@Override
	public int update(Connection conn, Goods t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Goods findById(Connection conn, int id) throws SQLException {
		sql = "select * from goods where gid = ?";
		goodsList = dh.executeQuery(conn, mapper, sql, id);
		if (goodsList != null && goodsList.size() > 0) {
			return goodsList.get(0);
		}
		return null;
	}

	@Override
	public List<Goods> findAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Goods> findByConndition(Connection conn, FindType type, Object... objs) throws SQLException {
		if (type == FindType.GOODS_SHOP) {
			return this.findByShop(conn, objs);
		} else if (type == FindType.GOODS_SEARCH) {
			return this.findBySearch(conn, objs);
		}
		return null;
	}
	/*
	 * 根据商店查询商店中的所有商品
	 */
	private List<Goods> findByShop(Connection conn, Object... objs) throws SQLException {
		sql = "select * from goods where sid = ?";
		return dh.executeQuery(conn, mapper, sql, objs);
	}
	
	/*
	 * 根据商店搜索商店中的所有商品
	 */
	private List<Goods> findBySearch(Connection conn, Object... objs) throws SQLException {
		sql = "select * from goods where gname like ?";
		return dh.executeQuery(conn, mapper, sql, "%".concat((String)objs[0]).concat("%"));
	}

	@Override
	public int deleteByCondition(Connection conn, DeleteType type, Object... objs) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
