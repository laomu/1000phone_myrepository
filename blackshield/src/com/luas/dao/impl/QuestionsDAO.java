package com.luas.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dbhelper.DBHelper;
import com.luas.mapper.IMapper;
import com.luas.mapper.impl.QuestionsMapper;
import com.luas.model.Questions;
/**
 * QuestionsDAO.java �û������������ݷ��ʶ�����
 * @author ��Ĳ
 * @see blackshield->com.luas.dao->QuestionsDAO.java
 * @see 2015��12��23�� ����1:07:55 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class QuestionsDAO implements IDAO<Questions> {

	private static Logger log = Logger.getLogger(QuestionsDAO.class);
	private String sql;
	private List<Questions> list;
	private Questions questions;
	private DBHelper<Questions> dh = new DBHelper<Questions>();
	private int index; 
	private IMapper<Questions> mapper = new QuestionsMapper();
	
	@Override
	public int add(Connection conn, Questions t) throws SQLException {
		log.debug("��ʼ���潨���������ݵ����ݿ�");
		sql = "insert into questions(qtUsername, quEmail, qtDesc, qtDeal,qtTime) values(?,?,?,?,?)";
		index = dh.executeInsert(conn, sql, t.getQtUsername(),t.getQtEmail(), t.getQtDesc(), false, t.getQtTime());
		log.debug("�����������ݱ�����ɣ����������ţ�" + index);
		return index;
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		sql = "delete from questions where qtid = ?";
		return dh.executeSQL(conn, sql, id);
	}

	@Override
	public int update(Connection conn, Questions t) throws SQLException {
		sql = "update questions set qtusername = ?,"
				+ "quEmail = ?,"
				+ "qtDesc = ?,"
				+ "qtDeal = ?,"
				+ "qttime = ? where qtId = ?";
		return dh.executeSQL(conn, sql, t.getQtUsername(),
				t.getQtEmail(),t.getQtDesc(), t.isQtDeal(), t.getQtTime(),
				t.getQtId());
	}

	@Override
	public Questions findById(Connection conn, int id) throws SQLException {
		log.debug("��ʼ���ݱ�Ų�ѯ�����¼�����:" + id);
		sql = "select * from questions where qtid = ?";
		list = dh.executeQuery(conn, sql, mapper, id);
		if (list != null && list.size() > 0) {
			log.debug("��ѯ��ɣ���ѯ���ļ�¼��" + list.get(0));
			return list.get(0);
		}
		log.debug("û�в�ѯ����¼...");
		return null;
	}

	@Override
	public List<Questions> findAll(Connection conn) throws SQLException {
		log.debug("��ʼ��ѯ�����е������б�");
		sql = "select * from questions";
		list = dh.executeQuery(conn, sql, mapper);
		log.debug("��ѯ��ɣ���ѯ��" + list.size() + "����¼");
		return list;
	}

	@Override
	public List<Questions> findByCondition(Connection conn, int type, Object... obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
