package com.luas.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.luas.mapper.IMapper;
import com.luas.model.CourseType;

/**
 * CourseTypeMapper.java 课程类型数据记录和对象映射关系类
 * 
 * @author 老牟
 * @see blackshield->com.luas.mapper.impl->CourseTypeMapper.java
 * @see 2015年12月13日 下午5:25:58
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class CourseTypeMapper implements IMapper<CourseType> {

	// 日志记录
	private static Logger log = Logger.getLogger(CourseTypeMapper.class);

	@Override
	public CourseType rowMapper(Connection conn, ResultSet rs) throws SQLException {
		log.debug("开始将课程类型数据封装成课程类型对象");
		CourseType courseType = new CourseType();
		courseType.setCtId(rs.getInt("ctId"));
		courseType.setCtName(rs.getString("ctName"));
		log.debug("封装完成");
		return courseType;
	}

}
