package com.luas.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dbhelper.DBHelper;
import com.luas.mapper.IMapper;
import com.luas.mapper.impl.DocTypeMapper;
import com.luas.model.DocType;

/**
 * DocTypeDAO.java �ĵ�����DAO
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.dao.impl->DocTypeDAO.java
 * @see 2015��12��10�� ����11:32:40
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class DocTypeDAO implements IDAO<DocType> {

	// ��־��¼
	private static Logger log = Logger.getLogger(DocTypeDAO.class);

	private DBHelper<DocType> dh = new DBHelper<DocType>();
	private IMapper<DocType> docTypeMapper = new DocTypeMapper();
	private List<DocType> list;
	private DocType docType;
	private String sql;

	@Override
	public int add(Connection conn, DocType t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, DocType t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DocType findById(Connection conn, int id) throws SQLException {
		log.debug("�����ĵ��������ͱ�Ų�ѯ�ĵ��������ݿ�ʼ�� ���" + id);
		sql = "select * from doctype where dtid = ?";
		list = dh.executeQuery(conn, sql, docTypeMapper, id);
		if (list != null && list.size() > 0) {
			log.debug("��ѯ���ĵ��������ͣ�����:" + list.get(0).getDeName());
			return list.get(0);
		}
		log.debug("û�в�ѯ����Ӧ��ŵ�����....");
		return null;
	}

	@Override
	public List<DocType> findAll(Connection conn) throws SQLException {
		log.debug("��ѯ���е��ĵ�������������");
		sql = "select * from doctype";
		list = dh.executeQuery(conn, sql, docTypeMapper);
		log.debug("��ѯ��ɣ�����ѯ���ĵ���������" + list.size() +"������");
		return list;
	}

	@Override
	public List<DocType> findByCondition(Connection conn, int type, Object... obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
