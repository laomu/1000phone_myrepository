package com.lzcc.train.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dbhelper.DBHelper;
import com.lzcc.train.mapper.IMapper;
import com.lzcc.train.mapper.impl.UserMapper;
import com.lzcc.train.model.User;
import com.lzcc.train.utils.DeleteType;
import com.lzcc.train.utils.FindType;

/**
 * UserDAO.java 用户数据访问对象
 * @author 老牟
 * @see train_01->com.lzcc.train.dao.impl->UserDAO.java
 * @see 2016年1月26日 上午11:01:22 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class UserDAO implements IDAO<User> {
	private String sql;
	private List<User> list;
	private User user;
	private int index;
	private DBHelper<User> dh = new DBHelper<User>();
	private IMapper<User> mapper = new UserMapper();

	@Override
	public int add(Connection conn, User t) throws SQLException {
		// 增加数据到数据库，部分字段使用指定的默认值
		sql = "insert into user(username, password, nickname, registtime, score, status, age, gender)"
				+ "values(?,?,?,?,?,?,?,?)";
		return dh.executeInsert(conn, sql, t.getUsername(),
										t.getPassword(),
										t.getNickName(),
										new Date(),
										0,true,0,"待完善");
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, User t) throws SQLException {
		sql = "update user set username = ?,"
								+ "password = ?,"
								+ "nickname = ?,"
								+ "registtime = ?,"
								+ "regno = ?,"
								+ "score = ?,"
								+ "status = ?,"
								+ "age = ?,"
								+ "gender = ?,"
								+ "email = ?,"
								+ "phone = ? where uid = ?";
		return dh.executeSQL(conn, sql, t.getUsername(),
										t.getPassword(),
										t.getNickName(),
										t.getRegistTime(),
										t.getRegNo(),
										t.getScore(),
										t.isStatus(),
										t.getAge(),
										t.getGender(),
										t.getEmail(),
										t.getPhone(),t.getUid());
	}

	@Override
	public User findById(Connection conn, int id) throws SQLException {
		sql = "select * from user where uid = ?";
		list = dh.executeQuery(conn, mapper, sql, id);
		if (list != null && list.size() > 0) {
			user = list.get(0);
		}
		return user;
	}

	@Override
	public List<User> findAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findByConndition(Connection conn, FindType type, Object... objs) throws SQLException {
		if (type == FindType.USER_USERNAME_PASSWORD) {// 根据账号密码查询用户
			return this.findByUsernameAndPassword(conn, objs);
		} else if(type == FindType.USER_USERNAME) {
			return this.findByUsername(conn, objs);
		}
		return null;
	}
	
	/*
	 * 根据账号密码查询用户
	 */
	private List<User> findByUsernameAndPassword(Connection conn, Object... objs) throws SQLException {
		sql = "select * from user where username = ? and password = ?";//定义sql语句
		return dh.executeQuery(conn, mapper, sql, objs);// 调用底层方法执行查询
	}
	
	/*
	 * 根据账号查询用户
	 */
	private List<User> findByUsername(Connection conn, Object... objs) throws SQLException {
		sql = "select * from user where username = ?";//定义sql语句
		return dh.executeQuery(conn, mapper, sql, objs);// 调用底层方法执行查询
	}

	@Override
	public int deleteByCondition(Connection conn, DeleteType type, Object... objs) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
