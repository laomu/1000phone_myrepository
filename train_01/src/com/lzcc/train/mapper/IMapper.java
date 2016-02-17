package com.lzcc.train.mapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 
 * @ClassName: IMapper 
 * @Description: ���ݼ�¼����ӳ��ӿ� 
 * @author Ervin
 * @date 2016��1��19�� ����11:19:25 
 * @version V1.00
 *
 * @contact qq:164428088 
 * @tel 18294403990
 * @copyright ��Ȩ����
 * @param <T>
 */
public interface IMapper<T> {
	/**
	 * �����ݼ�¼ת����java����ķ���
	 * @param conn
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	T mapper(Connection conn,ResultSet rs)throws SQLException;
}
