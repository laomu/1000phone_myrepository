package com.luas.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.luas.mapper.IMapper;
import com.luas.model.ToolsType;

public class ToolsTypeMapper implements IMapper<ToolsType> {

	// 日志记录
	private static Logger log = Logger.getLogger(ToolsTypeMapper.class);

	@Override
	public ToolsType rowMapper(Connection conn, ResultSet rs) throws SQLException {
		log.debug("开始将软件工具类型数据封装成软件工具类型对象");
		ToolsType toolsType = new ToolsType();
		toolsType.setTtId(rs.getInt("ttid"));
		toolsType.setTtName(rs.getString("ttname"));
		log.debug("封装完成");
		return toolsType;
	}

}
