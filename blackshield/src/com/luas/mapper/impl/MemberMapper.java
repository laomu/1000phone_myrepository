package com.luas.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.luas.mapper.IMapper;
import com.luas.model.Member;

/**
 * MemberMapper.java ��Ա��ϵӳ����
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.mapper.impl->MemberMapper.java
 * @see 2015��12��8�� ����8:50:53
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class MemberMapper implements IMapper<Member> {

	// ��־��¼
	private static Logger log = Logger.getLogger(MemberMapper.class);

	@Override
	public Member rowMapper(Connection conn, ResultSet rs) throws SQLException {
		log.debug("��ʼ����Ա���ݷ�װ�ɻ�Ա����");
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
		log.debug("��װ���");
		return member;
	}

}
