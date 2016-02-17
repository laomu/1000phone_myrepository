package com.lzcc.train.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lzcc.train.mapper.IMapper;
import com.lzcc.train.model.ActivityType;

/**
 * ActivityTypeMapper.java 活动类型实体映射关系类
 * @author 老牟
 * @see train_01->com.lzcc.train.mapper.impl->ActivityTypeMapper.java
 * @see 2016年1月26日 上午10:52:01 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
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
