package com.luas.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.luas.mapper.IMapper;
import com.luas.model.CourseType;

/**
 * CourseTypeMapper.java �γ��������ݼ�¼�Ͷ���ӳ���ϵ��
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.mapper.impl->CourseTypeMapper.java
 * @see 2015��12��13�� ����5:25:58
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class CourseTypeMapper implements IMapper<CourseType> {

	// ��־��¼
	private static Logger log = Logger.getLogger(CourseTypeMapper.class);

	@Override
	public CourseType rowMapper(Connection conn, ResultSet rs) throws SQLException {
		log.debug("��ʼ���γ��������ݷ�װ�ɿγ����Ͷ���");
		CourseType courseType = new CourseType();
		courseType.setCtId(rs.getInt("ctId"));
		courseType.setCtName(rs.getString("ctName"));
		log.debug("��װ���");
		return courseType;
	}

}
