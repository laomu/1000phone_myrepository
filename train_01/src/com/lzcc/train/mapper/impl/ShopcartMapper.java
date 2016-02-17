package com.lzcc.train.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dao.impl.UserDAO;
import com.lzcc.train.mapper.IMapper;
import com.lzcc.train.model.Shopcart;
import com.lzcc.train.model.User;
import com.lzcc.train.service.GoodsService;

/**
 * ShopcartMapper.java ���ﳵʵ����ӳ���ϵ��
 * @author ��Ĳ
 * @see train_01->com.lzcc.train.mapper.impl->ShopcartMapper.java
 * @see 2016��1��26�� ����10:55:57 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ShopcartMapper implements IMapper<Shopcart> {
	private IDAO<User> userDAO = new UserDAO();
	// private IDAO<Goods> goodsDAO = new GoodsDAO();
	private GoodsService goodsService = new GoodsService();

	@Override
	public Shopcart mapper(Connection conn, ResultSet rs) throws SQLException {
		Shopcart shopcart = new Shopcart();
		shopcart.setScId(rs.getInt("scid"));
		shopcart.setUser(userDAO.findById(conn, rs.getInt("uid")));
		shopcart.setGoods(goodsService.findById(String.valueOf(rs.getInt("gid"))));
		shopcart.setAddTime(rs.getDate("addtime")); 
		shopcart.setShoppingCount(rs.getInt("shoppingcount"));
		shopcart.setSubTotal(rs.getDouble("subtotal"));
		return shopcart;
	}

}
