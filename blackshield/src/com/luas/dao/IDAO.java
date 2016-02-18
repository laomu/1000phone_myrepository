package com.luas.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * IDAO.java ���ݷ����೬���ӿ�
 * @author ��Ĳ
 * @see blackshield->com.luas.dao->IDAO.java
 * @see 2015��12��7�� ����10:37:22 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public interface IDAO<T> {
	int add(Connection conn, T t) throws SQLException;
	
	int delete(Connection conn, int id) throws SQLException;
	
	int update(Connection conn, T t) throws SQLException;
	
	T findById(Connection conn, int id) throws SQLException;
	
	List<T> findAll(Connection conn) throws SQLException;
	
	List<T> findByCondition(Connection conn,int type, Object ... obj) throws SQLException;
}