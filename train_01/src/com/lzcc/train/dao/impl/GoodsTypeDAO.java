package com.lzcc.train.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dbhelper.DBHelper;
import com.lzcc.train.mapper.IMapper;
import com.lzcc.train.mapper.impl.GoodsTypeMapper;
import com.lzcc.train.model.GoodsType;
import com.lzcc.train.utils.DeleteType;
import com.lzcc.train.utils.FindType;

/**
 * GoodsTypeDAO.java 商品类型数据访问对象
 * @author 老牟
 * @see train_01->com.lzcc.train.dao.impl->GoodsTypeDAO.java
 * @see 2016年1月26日 上午10:59:01 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class GoodsTypeDAO implements IDAO<GoodsType> {
	private String sql;
	private DBHelper<GoodsType> dh = new DBHelper<GoodsType>();
	private GoodsType goodsType;
	private List<GoodsType> glist;
	private IMapper<GoodsType> mapper = new GoodsTypeMapper();

	@Override
	public int add(Connection conn, GoodsType t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, GoodsType t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public GoodsType findById(Connection conn, int id) throws SQLException {
		sql = "select * from goodstype where gtid = ?";
		glist = dh.executeQuery(conn, mapper, sql, id);
		if (glist != null && glist.size() > 0) {
			return glist.get(0);
		}
		return null;
	}

	@Override
	public List<GoodsType> findAll(Connection conn) throws SQLException {
		sql = "select * from goodstype";
		return dh.executeQuery(conn, mapper, sql);
	}

	@Override
	public List<GoodsType> findByConndition(Connection conn, FindType type, Object... objs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByCondition(Connection conn, DeleteType type, Object... objs) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
