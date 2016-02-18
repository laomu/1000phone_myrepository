package com.luas.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.luas.mapper.IMapper;
import com.luas.model.Manager;

/**
 * ManagerMapper.java ����Ա���ݼ�¼��Java����ӳ���ϵʵ����
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.mapper.impl->ManagerMapper.java
 * @see 2015��12��8�� ����5:18:53
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ManagerMapper implements IMapper<Manager> {

	// ��־��¼
	private static Logger log = Logger.getLogger(ManagerMapper.class);

	@Override
	public Manager rowMapper(Connection conn, ResultSet rs) throws SQLException {
		log.debug("��ʼ������Ա���ݷ�װ�ɹ���Ա����");
		Manager manager = new Manager();
		manager.setId(rs.getInt("managerid"));
		manager.setUsername(rs.getString("username"));
		manager.setPassword(rs.getString("password"));
		manager.setRealName(rs.getString("realName"));
		manager.setPhone(rs.getString("phone"));
		manager.setHeaderImg(rs.getString("headerImg"));
		manager.setEmail(rs.getString("email"));
		manager.setRegistTime(rs.getDate("registTime"));
		log.debug("��װ���");
		return manager;
	}

}
