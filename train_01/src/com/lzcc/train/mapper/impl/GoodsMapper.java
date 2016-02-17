package com.lzcc.train.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dao.impl.ActivityTypeDAO;
import com.lzcc.train.dao.impl.GoodsTypeDAO;
import com.lzcc.train.dao.impl.ShopDAO;
import com.lzcc.train.mapper.IMapper;
import com.lzcc.train.model.ActivityType;
import com.lzcc.train.model.Goods;
import com.lzcc.train.model.GoodsType;
import com.lzcc.train.model.Shop;

/**
 * GoodsMapper.java 商品实体类映射关系类
 * @author 老牟
 * @see train_01->com.lzcc.train.mapper.impl->GoodsMapper.java
 * @see 2016年1月26日 上午10:53:09 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class GoodsMapper implements IMapper<Goods> {
	private IDAO<GoodsType> gtDAO = new GoodsTypeDAO();
	private IDAO<ActivityType> atDAO = new ActivityTypeDAO();
	private IDAO<Shop> shopDAO = new ShopDAO();

	@Override
	public Goods mapper(Connection conn, ResultSet rs) throws SQLException {
		Goods goods = new Goods();
		goods.setGid(rs.getInt("gid"));
		goods.setGoodsType(gtDAO.findById(conn, rs.getInt("gtid")));
		goods.setActivityType(atDAO.findById(conn, rs.getInt("atid")));
		goods.setShop(shopDAO.findById(conn, rs.getInt("sid")));
		goods.setGname(rs.getString("gname"));
		goods.setOriginalCost(rs.getDouble("originalcost"));
		goods.setPrice(rs.getDouble("price"));
		goods.setStock(rs.getInt("stock"));
		goods.setGdesc(rs.getString("gdesc"));
		return goods;
	}

}
