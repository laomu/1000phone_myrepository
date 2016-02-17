package com.lzcc.train.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.lzcc.train.mapper.IMapper;
import com.lzcc.train.model.User;

/**
 * UserMapper.java �û�ʵ����ӳ���ϵ��
 * @author ��Ĳ
 * @see train_01->com.lzcc.train.mapper.impl->UserMapper.java
 * @see 2016��1��26�� ����10:56:26 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class UserMapper implements IMapper<User> {

	@Override
	public User mapper(Connection conn, ResultSet rs) throws SQLException {
		//���������ҹ������ݿ��в�ѯ��������
		User user = new User();
		user.setUid(rs.getInt("uid"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setNickName(rs.getString("nickname"));
		user.setRegistTime(rs.getTimestamp("registtime"));
		user.setRegNo(rs.getString("regno"));
		user.setAge(rs.getInt("age"));
		user.setGender(rs.getString("gender"));
		user.setScore(rs.getInt("score"));
		user.setStatus(rs.getBoolean("status"));
		user.setEmail(rs.getString("email"));
		user.setPhone(rs.getString("phone"));
		
		return user;
	}

}
