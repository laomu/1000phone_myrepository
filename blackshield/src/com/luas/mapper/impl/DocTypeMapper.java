package com.luas.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.luas.mapper.IMapper;
import com.luas.model.DocType;

public class DocTypeMapper implements IMapper<DocType> {

	// ��־��¼
	private static Logger log = Logger.getLogger(DocTypeMapper.class);

	@Override
	public DocType rowMapper(Connection conn, ResultSet rs) throws SQLException {
		log.debug("��ʼ���ĵ��������ݷ�װ���ĵ����Ͷ���");
		DocType docType = new DocType();
		docType.setDtId(rs.getInt("dtid"));
		docType.setDeName(rs.getString("dtname"));
		log.debug("��װ���");
		return docType;
	}

}
