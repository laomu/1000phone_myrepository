package com.luas.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.luas.mapper.IMapper;
import com.luas.model.ToolsType;

public class ToolsTypeMapper implements IMapper<ToolsType> {

	// ��־��¼
	private static Logger log = Logger.getLogger(ToolsTypeMapper.class);

	@Override
	public ToolsType rowMapper(Connection conn, ResultSet rs) throws SQLException {
		log.debug("��ʼ����������������ݷ�װ������������Ͷ���");
		ToolsType toolsType = new ToolsType();
		toolsType.setTtId(rs.getInt("ttid"));
		toolsType.setTtName(rs.getString("ttname"));
		log.debug("��װ���");
		return toolsType;
	}

}
