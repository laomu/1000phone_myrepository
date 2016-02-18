package com.luas.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.luas.mapper.IMapper;
import com.luas.model.Manager;

/**
 * ManagerMapper.java 管理员数据记录和Java对象映射关系实现类
 * 
 * @author 老牟
 * @see blackshield->com.luas.mapper.impl->ManagerMapper.java
 * @see 2015年12月8日 下午5:18:53
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ManagerMapper implements IMapper<Manager> {

	// 日志记录
	private static Logger log = Logger.getLogger(ManagerMapper.class);

	@Override
	public Manager rowMapper(Connection conn, ResultSet rs) throws SQLException {
		log.debug("开始将管理员数据封装成管理员对象");
		Manager manager = new Manager();
		manager.setId(rs.getInt("managerid"));
		manager.setUsername(rs.getString("username"));
		manager.setPassword(rs.getString("password"));
		manager.setRealName(rs.getString("realName"));
		manager.setPhone(rs.getString("phone"));
		manager.setHeaderImg(rs.getString("headerImg"));
		manager.setEmail(rs.getString("email"));
		manager.setRegistTime(rs.getDate("registTime"));
		log.debug("封装完成");
		return manager;
	}

}
