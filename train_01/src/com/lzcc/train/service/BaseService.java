package com.lzcc.train.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.lzcc.train.dbhelper.ConnectionManager;

/**
 * BaseService.java 业务处理模板类
 * @author 老牟
 * @see train_01->com.lzcc.train.service->BaseService.java
 * @see 2016年2月15日 上午9:43:38 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public abstract class BaseService<T> {
	private Connection conn;
	private T t;
	// 业务方法
	public abstract T service(Connection conn) throws SQLException;
	
	// 业务处理模板方法
	public T doService() {
		try {
			// 打开连接
			conn = ConnectionManager.getConnection();
			
			t = service(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭连接
			ConnectionManager.free(conn);
		}
		return t;
	}
}
