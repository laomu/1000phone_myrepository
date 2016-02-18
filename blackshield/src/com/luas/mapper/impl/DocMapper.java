package com.luas.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dao.impl.DocTypeDAO;
import com.luas.dao.impl.ManagerDAO;
import com.luas.mapper.IMapper;
import com.luas.model.Doc;
import com.luas.model.DocType;
import com.luas.model.Manager;

public class DocMapper implements IMapper<Doc> {

	// 日志记录
	private static Logger log = Logger.getLogger(DocMapper.class);

	private IDAO<Manager> managerDAO = new ManagerDAO();
	private IDAO<DocType> docTypeDAO = new DocTypeDAO();

	@Override
	public Doc rowMapper(Connection conn, ResultSet rs) throws SQLException {
		log.debug("开始将文档数据封装成文档对象");
		Doc doc = new Doc();
		doc.setDocId(rs.getInt("docId"));
		doc.setManager(managerDAO.findById(conn, rs.getInt("managerid")));
		doc.setDocType(docTypeDAO.findById(conn, rs.getInt("dtid")));
		doc.setDname(rs.getString("dname"));
		doc.setDdesc(rs.getString("ddesc"));
		doc.setPath(rs.getString("path"));
		doc.setPublishTime(rs.getDate("publishTime"));
		log.debug("封装完成");
		return doc;
	}

}
