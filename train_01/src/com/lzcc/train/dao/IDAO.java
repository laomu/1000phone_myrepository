package com.lzcc.train.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.lzcc.train.utils.DeleteType;
import com.lzcc.train.utils.FindType;

/**
 * 数据访问对象接口
 * @ClassName: IDAO 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Ervin
 * @date 2016年1月19日 下午10:41:46 
 * @version V1.00
 *
 * @contact qq:164428088 
 * @tel 18294403990
 * @copyright 版权所有
 * @param <T>
 */
public interface IDAO<T> {
	/**
	 * 增加一个对象
	 * @param conn
	 * @param t
	 * @return
	 * @throws SQLException
	 */
	int add (Connection conn,T t)throws SQLException;
	/**
	 * 根据编号删除对象
	 * @param conn
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	int delete(Connection conn, int id)throws SQLException;
	/**
	 * 修改对象
	 * @param conn
	 * @param t
	 * @return
	 * @throws SQLException
	 */
	int update(Connection conn , T t)throws SQLException;
	/**
	 * 根据编号查询一个对象
	 * @param conn
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	T findById(Connection conn, int id)throws SQLException;
	/**
	 * 查询所有数据
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	List<T> findAll(Connection conn)throws SQLException;
	/**
	 * 根据条件查询
	 * @param conn
	 * @param type
	 * @param objs
	 * @return
	 * @throws SQLException
	 */
	List<T> findByConndition(Connection conn, FindType type,Object...objs)throws SQLException;
	
	/**
	 * 根据条件删除数据
	 * @param conn
	 * @param type
	 * @param objs
	 * @return
	 * @throws SQLException
	 */
	int deleteByCondition(Connection conn, DeleteType type,Object...objs)throws SQLException;
}
