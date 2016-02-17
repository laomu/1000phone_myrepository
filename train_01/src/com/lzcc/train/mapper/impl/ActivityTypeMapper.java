package com.lzcc.train.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lzcc.train.mapper.IMapper;
import com.lzcc.train.model.ActivityType;

/**
 * ActivityTypeMapper.java �����ʵ��ӳ���ϵ��
 * @author ��Ĳ
 * @see train_01->com.lzcc.train.mapper.impl->ActivityTypeMapper.java
 * @see 2016��1��26�� ����10:52:01 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ActivityTypeMapper implements IMapper<ActivityType> {

	@Override
	public ActivityType mapper(Connection conn, ResultSet rs) throws SQLException {
		ActivityType at = new ActivityType();
		at.setAtId(rs.getInt("atid"));
		at.setAtName(rs.getString("atname"));
		return at;
	}

}
