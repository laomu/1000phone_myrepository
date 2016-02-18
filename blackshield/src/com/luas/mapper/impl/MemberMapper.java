package com.luas.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.luas.mapper.IMapper;
import com.luas.model.Member;

/**
 * MemberMapper.java 会员关系映射类
 * 
 * @author 老牟
 * @see blackshield->com.luas.mapper.impl->MemberMapper.java
 * @see 2015年12月8日 上午8:50:53
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class MemberMapper implements IMapper<Member> {

	// 日志记录
	private static Logger log = Logger.getLogger(MemberMapper.class);

	@Override
	public Member rowMapper(Connection conn, ResultSet rs) throws SQLException {
		log.debug("开始将会员数据封装成会员对象");
		Member member = new Member();
		member.setId(rs.getInt("memberid"));
		member.setUsername(rs.getString("username"));
		member.setPassword(rs.getString("password"));
		member.setRealName(rs.getString("realName"));
		member.setPhone(rs.getString("phone"));
		member.setHeaderImg(rs.getString("headerImg"));
		member.setEmail(rs.getString("email"));
		member.setRegistTime(rs.getDate("registTime"));
		member.setLock(rs.getBoolean("islock"));
		log.debug("封装完成");
		return member;
	}

}
