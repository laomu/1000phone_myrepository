package com.lzcc.train.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.lzcc.train.dbhelper.ConnectionManager;

/**
 * BaseService.java ҵ����ģ����
 * @author ��Ĳ
 * @see train_01->com.lzcc.train.service->BaseService.java
 * @see 2016��2��15�� ����9:43:38 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public abstract class BaseService<T> {
	private Connection conn;
	private T t;
	// ҵ�񷽷�
	public abstract T service(Connection conn) throws SQLException;
	
	// ҵ����ģ�巽��
	public T doService() {
		try {
			// ������
			conn = ConnectionManager.getConnection();
			
			t = service(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر�����
			ConnectionManager.free(conn);
		}
		return t;
	}
}
