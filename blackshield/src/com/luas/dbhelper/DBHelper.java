package com.luas.dbhelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.mapper.IMapper;

/**
 * DHelper.java 数据执行类
 * 
 * @author 老牟
 * @see blackshield->com.luas.dbhelper->DHelper.java
 * @see 2015年12月7日 上午10:36:58
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class DBHelper<T> {

	// 日志记录
	private static Logger log = Logger.getLogger(DBHelper.class);

	private T t;// 映射返回的Java对象
	private List<T> list;// 保存数据的集合
	private PreparedStatement pstat;// 预编译对象
	private ResultSet rs;// 查询的结果集

	/**
	 * 执行Insert的方法
	 * 
	 * @param conn
	 *            数据库连接
	 * @param sql
	 *            要执行的sql语句
	 * @param obj
	 *            参数列表
	 * @return 返回新生成的ID值
	 * @throws SQLException
	 */
	public int executeInsert(Connection conn, String sql, Object... obj) throws SQLException {
		log.debug("开始执行Insert增加数据到数据库操作");
		log.debug("SQL：" + sql);
		pstat = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);// 使用连接对象创建预编译对象
		log.debug("开始赋值...");
		this.setParam(obj);// 给参数赋值
		log.debug("赋值完成,开始执行发送SQL");
		pstat.executeUpdate();// 执行并返回结果
		log.debug("执行完成，获取主键");
		rs = pstat.getGeneratedKeys();// 获取生成的主键列表
		if (rs.next()) {
			log.debug("获取到主键-->" + rs.getInt(1));
			return rs.getInt(1);// 获取生成的主键值
		}
		log.debug("执行失败，数据没有增加成功.");
		return -1;
	}

	/**
	 * 执行修改、删除的方法
	 * 
	 * @param conn
	 *            数据库连接
	 * @param sql
	 *            要执行的sql
	 * @param obj
	 *            参数列表
	 * @return 返回执行的行数
	 * @throws SQLException
	 */
	public int executeSQL(Connection conn, String sql, Object... obj) throws SQLException {
		log.debug("开始执行update/delete操作");
		log.debug("sql:" + sql);
		pstat = conn.prepareStatement(sql);// 使用连接对象创建预编译对象
		log.debug("开始赋值...");
		this.setParam(obj);// 给参数赋值
		log.debug("赋值完成，开始执行...");
		log.debug("执行完成");
		return pstat.executeUpdate();// 执行并返回结果
	}

	/**
	 * 执行查询返回查询数据对应对象列表的方法
	 * 
	 * @param conn
	 *            数据库连接
	 * @param sql
	 *            要执行的sql语句
	 * @param mapper
	 *            映射关系
	 * @param obj
	 *            参数列表
	 * @return 返回查询到的数据集合
	 * @throws SQLException
	 */
	public List<T> executeQuery(Connection conn, String sql, IMapper<T> mapper, Object... obj) throws SQLException {
		log.debug("开始执行select操作");
		log.debug("sql:" + sql);
		pstat = conn.prepareStatement(sql);
		log.debug("开始赋值....");
		this.setParam(obj);
		log.debug("赋值完成，开始执行...");
		rs = pstat.executeQuery();
		list = new ArrayList<T>();
		while (rs.next()) {
			log.debug("查询到数据，映射封装生成Java对象");
			t = mapper.rowMapper(conn, rs);
			list.add(t);
		}
		log.debug("执行完成，返回数据" + list.size() + "条。");
		return list;
	}

	/*
	 * 设置参数，因为这个方法只允许在当前类中使用，所以使用private修饰
	 */
	private void setParam(Object... obj) throws SQLException {
		if (obj != null && obj.length > 0) {
			for (int i = 0; i < obj.length; i++) {
				log.debug("sql赋值参数-->" + obj[i]);
				pstat.setObject(i + 1, obj[i]);
			}
		}
	}
}
