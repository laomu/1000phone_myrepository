package com.lzcc.train.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.lzcc.train.utils.DeleteType;
import com.lzcc.train.utils.FindType;

/**
 * ���ݷ��ʶ���ӿ�
 * @ClassName: IDAO 
 * @Description: TODO(������һ�仰��������������) 
 * @author Ervin
 * @date 2016��1��19�� ����10:41:46 
 * @version V1.00
 *
 * @contact qq:164428088 
 * @tel 18294403990
 * @copyright ��Ȩ����
 * @param <T>
 */
public interface IDAO<T> {
	/**
	 * ����һ������
	 * @param conn
	 * @param t
	 * @return
	 * @throws SQLException
	 */
	int add (Connection conn,T t)throws SQLException;
	/**
	 * ���ݱ��ɾ������
	 * @param conn
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	int delete(Connection conn, int id)throws SQLException;
	/**
	 * �޸Ķ���
	 * @param conn
	 * @param t
	 * @return
	 * @throws SQLException
	 */
	int update(Connection conn , T t)throws SQLException;
	/**
	 * ���ݱ�Ų�ѯһ������
	 * @param conn
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	T findById(Connection conn, int id)throws SQLException;
	/**
	 * ��ѯ��������
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	List<T> findAll(Connection conn)throws SQLException;
	/**
	 * ����������ѯ
	 * @param conn
	 * @param type
	 * @param objs
	 * @return
	 * @throws SQLException
	 */
	List<T> findByConndition(Connection conn, FindType type,Object...objs)throws SQLException;
	
	/**
	 * ��������ɾ������
	 * @param conn
	 * @param type
	 * @param objs
	 * @return
	 * @throws SQLException
	 */
	int deleteByCondition(Connection conn, DeleteType type,Object...objs)throws SQLException;
}
