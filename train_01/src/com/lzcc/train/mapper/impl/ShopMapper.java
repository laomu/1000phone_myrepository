package com.lzcc.train.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dao.impl.UserDAO;
import com.lzcc.train.mapper.IMapper;
import com.lzcc.train.model.Shop;
import com.lzcc.train.model.User;

/**
 * ShopMapper.java 商店实体类映射关系类
 * @author 老牟
 * @see train_01->com.lzcc.train.mapper.impl->ShopMapper.java
 * @see 2016年1月26日 上午10:55:29 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ShopMapper implements IMapper<Shop> {
	private IDAO<User> userDAO = new UserDAO();
	@Override
	public Shop mapper(Connection conn, ResultSet rs) throws SQLException {
		Shop shop = new Shop(); 
		shop.setSid(rs.getInt("sid"));
		shop.setUser(userDAO.findById(conn, rs.getInt("uid")));
		shop.setSname(rs.getString("sname"));
		shop.setCreateTime(rs.getDate("createtime"));
		shop.setSdesc(rs.getString("sdesc"));
		shop.setShopImg(rs.getString("shopImg"));
		shop.setScore(rs.getInt("score"));
		return shop;
	}

}
