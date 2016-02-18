package com.luas.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.luas.mapper.IMapper;
import com.luas.model.DocType;

public class DocTypeMapper implements IMapper<DocType> {

	// 日志记录
	private static Logger log = Logger.getLogger(DocTypeMapper.class);

	@Override
	public DocType rowMapper(Connection conn, ResultSet rs) throws SQLException {
		log.debug("开始将文档类型数据封装成文档类型对象");
		DocType docType = new DocType();
		docType.setDtId(rs.getInt("dtid"));
		docType.setDeName(rs.getString("dtname"));
		log.debug("封装完成");
		return docType;
	}

}
