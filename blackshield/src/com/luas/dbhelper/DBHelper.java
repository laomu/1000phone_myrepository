package com.luas.dbhelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.mapper.IMapper;

/**
 * DHelper.java ����ִ����
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.dbhelper->DHelper.java
 * @see 2015��12��7�� ����10:36:58
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class DBHelper<T> {

	// ��־��¼
	private static Logger log = Logger.getLogger(DBHelper.class);

	private T t;// ӳ�䷵�ص�Java����
	private List<T> list;// �������ݵļ���
	private PreparedStatement pstat;// Ԥ�������
	private ResultSet rs;// ��ѯ�Ľ����

	/**
	 * ִ��Insert�ķ���
	 * 
	 * @param conn
	 *            ���ݿ�����
	 * @param sql
	 *            Ҫִ�е�sql���
	 * @param obj
	 *            �����б�
	 * @return ���������ɵ�IDֵ
	 * @throws SQLException
	 */
	public int executeInsert(Connection conn, String sql, Object... obj) throws SQLException {
		log.debug("��ʼִ��Insert�������ݵ����ݿ����");
		log.debug("SQL��" + sql);
		pstat = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);// ʹ�����Ӷ��󴴽�Ԥ�������
		log.debug("��ʼ��ֵ...");
		this.setParam(obj);// ��������ֵ
		log.debug("��ֵ���,��ʼִ�з���SQL");
		pstat.executeUpdate();// ִ�в����ؽ��
		log.debug("ִ����ɣ���ȡ����");
		rs = pstat.getGeneratedKeys();// ��ȡ���ɵ������б�
		if (rs.next()) {
			log.debug("��ȡ������-->" + rs.getInt(1));
			return rs.getInt(1);// ��ȡ���ɵ�����ֵ
		}
		log.debug("ִ��ʧ�ܣ�����û�����ӳɹ�.");
		return -1;
	}

	/**
	 * ִ���޸ġ�ɾ���ķ���
	 * 
	 * @param conn
	 *            ���ݿ�����
	 * @param sql
	 *            Ҫִ�е�sql
	 * @param obj
	 *            �����б�
	 * @return ����ִ�е�����
	 * @throws SQLException
	 */
	public int executeSQL(Connection conn, String sql, Object... obj) throws SQLException {
		log.debug("��ʼִ��update/delete����");
		log.debug("sql:" + sql);
		pstat = conn.prepareStatement(sql);// ʹ�����Ӷ��󴴽�Ԥ�������
		log.debug("��ʼ��ֵ...");
		this.setParam(obj);// ��������ֵ
		log.debug("��ֵ��ɣ���ʼִ��...");
		log.debug("ִ�����");
		return pstat.executeUpdate();// ִ�в����ؽ��
	}

	/**
	 * ִ�в�ѯ���ز�ѯ���ݶ�Ӧ�����б�ķ���
	 * 
	 * @param conn
	 *            ���ݿ�����
	 * @param sql
	 *            Ҫִ�е�sql���
	 * @param mapper
	 *            ӳ���ϵ
	 * @param obj
	 *            �����б�
	 * @return ���ز�ѯ�������ݼ���
	 * @throws SQLException
	 */
	public List<T> executeQuery(Connection conn, String sql, IMapper<T> mapper, Object... obj) throws SQLException {
		log.debug("��ʼִ��select����");
		log.debug("sql:" + sql);
		pstat = conn.prepareStatement(sql);
		log.debug("��ʼ��ֵ....");
		this.setParam(obj);
		log.debug("��ֵ��ɣ���ʼִ��...");
		rs = pstat.executeQuery();
		list = new ArrayList<T>();
		while (rs.next()) {
			log.debug("��ѯ�����ݣ�ӳ���װ����Java����");
			t = mapper.rowMapper(conn, rs);
			list.add(t);
		}
		log.debug("ִ����ɣ���������" + list.size() + "����");
		return list;
	}

	/*
	 * ���ò�������Ϊ�������ֻ�����ڵ�ǰ����ʹ�ã�����ʹ��private����
	 */
	private void setParam(Object... obj) throws SQLException {
		if (obj != null && obj.length > 0) {
			for (int i = 0; i < obj.length; i++) {
				log.debug("sql��ֵ����-->" + obj[i]);
				pstat.setObject(i + 1, obj[i]);
			}
		}
	}
}
