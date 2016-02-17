package com.lzcc.train.dbhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * @ClassName: ConnectionManager 
 * @Description: ���ݿ�������
 * @author Ervin
 * @date 2016��1��19�� ����9:44:12 
 * @version V1.00
 *
 * @contact qq:164428088 
 * @tel 18294403990
 * @copyright ��Ȩ����
 */
public class ConnectionManager {
	private static final String URL="jdbc:mysql://localhost:3306/train_01";
	private static final String USER="root";
	private static final String PASSWORD="root";
	//ע������
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
