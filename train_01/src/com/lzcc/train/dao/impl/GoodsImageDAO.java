package com.lzcc.train.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dbhelper.DBHelper;
import com.lzcc.train.mapper.IMapper;
import com.lzcc.train.mapper.impl.GoodsImageMapper;
import com.lzcc.train.model.GoodsImage;
import com.lzcc.train.utils.DeleteType;
import com.lzcc.train.utils.FindType;

/**
 * GoodsImageDAO.java 商品图片数据访问对象
 * @author 老牟
 * @see train_01->com.lzcc.train.dao.impl->GoodsImageDAO.java
 * @see 2016年1月26日 上午10:58:04 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class GoodsImageDAO implements IDAO<GoodsImage> {
	private String sql;
	private GoodsImage gi;
	private List<GoodsImage> gilist;
	private DBHelper<GoodsImage> dh = new DBHelper<GoodsImage>();
	private IMapper<GoodsImage> mapper = new GoodsImageMapper();

	@Override
	public int add(Connection conn, GoodsImage t) throws SQLException {
		sql = "insert into goodsimage(gid, path) values(?,?)";
		return dh.executeInsert(conn, sql, t.getGoods().getGid(), t.getPath());
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		sql = "delete from goodsimage where giid = ?";
		return dh.executeSQL(conn, sql, id);
	}

	@Override
	public int update(Connection conn, GoodsImage t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public GoodsImage findById(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoodsImage> findAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoodsImage> findByConndition(Connection conn, FindType type, Object... objs) throws SQLException {
		if (type == FindType.GOODSIMAGE_GOODS) {
			return this.findByGoods(conn, objs);
		}
		return null;
	}
	
	private List<GoodsImage> findByGoods(Connection conn, Object... objs) throws SQLException {
		sql = "select * from goodsimage where gid = ?";
		return dh.executeQuery(conn, mapper, sql, objs);
	}

	@Override
	public int deleteByCondition(Connection conn, DeleteType type, Object... objs) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
