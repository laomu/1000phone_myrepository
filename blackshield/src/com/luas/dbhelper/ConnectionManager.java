package com.luas.dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * ConnectionManager.java 数据库连接管理类
 * 
 * @author 老牟
 * @see blackshield->com.luas.dbhelper->ConnectionManager.java
 * @see 2015年12月7日 上午10:36:47
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ConnectionManager {

	// 日志记录
	private static Logger log = Logger.getLogger(ConnectionManager.class);

	// 1. 注册驱动
	static {
		try {
			log.debug("开始加载数据库驱动程序...");
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			log.error("数据库驱动加载失败");
		}
	}

	/**
	 * 获取连接的方法
	 * 
	 * @return 返回一个新打开的连接
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		log.debug("开始获取数据库连接...");
		Connection conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/blackshield", "root", "root");
		log.debug("获取数据库连接完成");
		return conn;
	}

	/**
	 * 关闭数据库连接的方法
	 * 
	 * @param conn
	 *            要关闭的数据库连接
	 */
	public static void free(Connection conn) {
		log.debug("开始关闭使用的数据库连接...");
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
				conn = null;
				log.debug("关闭数据库连接完成-->" + conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
