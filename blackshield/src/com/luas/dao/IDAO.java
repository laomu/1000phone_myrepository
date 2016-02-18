package com.luas.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * IDAO.java 数据访问类超级接口
 * @author 老牟
 * @see blackshield->com.luas.dao->IDAO.java
 * @see 2015年12月7日 上午10:37:22 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
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