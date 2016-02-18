package com.luas.dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * ConnectionManager.java ���ݿ����ӹ�����
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.dbhelper->ConnectionManager.java
 * @see 2015��12��7�� ����10:36:47
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ConnectionManager {

	// ��־��¼
	private static Logger log = Logger.getLogger(ConnectionManager.class);

	// 1. ע������
	static {
		try {
			log.debug("��ʼ�������ݿ���������...");
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			log.error("���ݿ���������ʧ��");
		}
	}

	/**
	 * ��ȡ���ӵķ���
	 * 
	 * @return ����һ���´򿪵�����
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		log.debug("��ʼ��ȡ���ݿ�����...");
		Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/blackshield", "root", "root");
		log.debug("��ȡ���ݿ��������");
		return conn;
	}

	/**
	 * �ر����ݿ����ӵķ���
	 * 
	 * @param conn
	 *            Ҫ�رյ����ݿ�����
	 */
	public static void free(Connection conn) {
		log.debug("��ʼ�ر�ʹ�õ����ݿ�����...");
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
				conn = null;
				log.debug("�ر����ݿ��������-->" + conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
