package com.lzcc.train.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dao.impl.UserDAO;
import com.lzcc.train.mapper.IMapper;
import com.lzcc.train.model.Address;
import com.lzcc.train.model.User;

/**
 * AddressMapper.java 地址实体类映射关系类
 * @author 老牟
 * @see train_01->com.lzcc.train.mapper.impl->AddressMapper.java
 * @see 2016年1月26日 上午10:52:36 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class AddressMapper implements IMapper<Address>{
	private IDAO<User> userDAO = new UserDAO();

	@Override
	public Address mapper(Connection conn, ResultSet rs) throws SQLException {
		Address address = new Address();
		address.setAid(rs.getInt("aid"));
		address.setUser(userDAO.findById(conn, rs.getInt("uid")));
		address.setAnation(rs.getString("anation"));
		address.setProvince(rs.getString("province"));
		address.setCity(rs.getString("city"));
		address.setCountry(rs.getString("country"));
		address.setStreet(rs.getString("street"));
		address.setAdesc(rs.getString("adesc"));
		address.setStatus(rs.getBoolean("status"));
		address.setContact(rs.getString("contact"));
		address.setPhone(rs.getString("phone"));
		return address;
	}

}
