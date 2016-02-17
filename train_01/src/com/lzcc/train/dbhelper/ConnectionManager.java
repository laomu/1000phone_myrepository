package com.lzcc.train.dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @ClassName: ConnectionManager 
 * @Description: 数据库连接类
 * @author Ervin
 * @date 2016年1月19日 下午9:44:12 
 * @version V1.00
 *
 * @contact qq:164428088 
 * @tel 18294403990
 * @copyright 版权所有
 */
public class ConnectionManager {
	private static final String URL="jdbc:mysql://localhost:3306/train_01";
	private static final String USER="root";
	private static final String PASSWORD="root";
	//注册驱动
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL,USER,PASSWORD);
		
	}
	public static void free(Connection conn){
		try {
			if(conn !=null&&!conn.isClosed()){
				conn.close();
				conn=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
