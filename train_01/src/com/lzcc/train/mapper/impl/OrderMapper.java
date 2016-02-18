package com.lzcc.train.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dao.impl.AddressDAO;
import com.lzcc.train.dao.impl.UserDAO;
import com.lzcc.train.mapper.IMapper;
import com.lzcc.train.model.Address;
import com.lzcc.train.model.Order;
import com.lzcc.train.model.User;

/**
 * OrderMapper.java 订单实体类映射关系类
 * @author 老牟
 * @see train_01->com.lzcc.train.mapper.impl->OrderMapper.java
 * @see 2016年1月26日 上午10:54:39 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class OrderMapper implements IMapper<Order>{
	private IDAO<User> userDAO = new UserDAO();

	@Override
	public Order mapper(Connection conn, ResultSet rs) throws SQLException {
		Order ordre = new Order();
		ordre.setOid(rs.getInt("oid"));
		ordre.setUser(userDAO.findById(conn, rs.getInt("uid")));
		ordre.setStatus(rs.getString("status"));
		ordre.setOrderTime(rs.getDate("orderTime"));
		ordre.setTotalPrice(rs.getDouble("totalPrice"));
		ordre.setAddress(rs.getString("address"));
		ordre.setContact(rs.getString("contact"));
		ordre.setPhone(rs.getString("phone"));
		return ordre;
	}

}
