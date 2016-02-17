package com.lzcc.train.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dao.impl.UserDAO;
import com.lzcc.train.dbhelper.ConnectionManager;
import com.lzcc.train.model.User;
import com.lzcc.train.utils.FindType;
import com.lzcc.train.utils.MD5;

/**
 * UserService.java 用户业务处理类
 * @author 老牟
 * @see train_01->com.lzcc.train.service->UserService.java
 * @see 2016年1月26日 上午11:02:38 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class UserService {

	private User user;
	private List<User> list;
	private IDAO<User> dao = new UserDAO();
	private Connection conn;
	private int res;
	
	/**
	 * 用户登陆的业务
	 * @param loginUser 要登录的用户
	 * @return
	 */
	/*public User login(User loginUser) {
		try {
			// 获取数据库连接
			conn = ConnectionManager.getConnection();
			// 根据用户账号密码查询用户
			list = dao.findByConndition(conn, FindType.USER_USERNAME_PASSWORD, 
														loginUser.getUsername(), 
														loginUser.getPassword());
			// 如果查询到用户，将用户获取出来
			if(list != null && list.size() > 0) {
				user = list.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//关闭链接，释放资源
			ConnectionManager.free(conn);
		}
		return user;
	}*/
	
	public User login(User loginUser) {
		return new BaseService<User>(){
			@Override
			public User service(Connection conn) throws SQLException {
				// 根据用户账号密码查询用户
				list = dao.findByConndition(conn, FindType.USER_USERNAME_PASSWORD, 
															loginUser.getUsername(), 
															MD5.GetMD5Code(loginUser.getPassword()));
				// 如果查询到用户，将用户获取出来
				if(list != null && list.size() > 0) {
					user = list.get(0); 
				}
				return user;
			}
		}.doService();
	}
	
	/**
	 * 
	 * @param registUser
	 * @return
	 */
	/*public int regist(User registUser) {
		try {
			// 1. 获取数据库连接
			conn = ConnectionManager.getConnection();
			// 2. 查询账号是否已经被注册
			list = dao.findByConndition(conn, FindType.USER_USERNAME, registUser.getUsername());
			if (list != null && list.size() > 0) {
				// 3.账号已经被注册，返回-2错误码
				res = -2;
			} else {
				// 4. 没有注册向数据库添加用户注册信息
				res = dao.add(conn, registUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// last.关闭数据库连接
			ConnectionManager.free(conn);
		}
		return res;
	}*/
	
	public int regist(User registUser) { 
		return new BaseService<Integer>(){

			@Override
			public Integer service(Connection conn) throws SQLException {
				// 2. 查询账号是否已经被注册
				list = dao.findByConndition(conn, FindType.USER_USERNAME, registUser.getUsername());
				if (list != null && list.size() > 0) {
					// 3.账号已经被注册，返回-2错误码
					return -2;
				} else {
					// 4. 没有注册向数据库添加用户注册信息
					registUser.setPassword(MD5.GetMD5Code(registUser.getPassword()));
					return dao.add(conn, registUser);
				}
			}
		}.doService();
	}
	/**
	 * 修改用户登录密码
	 * @param user
	 */
	@SuppressWarnings("rawtypes")
	public void chgPasswd(User user) {
		new BaseService() {

			@Override
			public Object service(Connection conn) throws SQLException {
				user.setPassword(MD5.GetMD5Code(user.getPassword()));// 加密用户密码
				dao.update(conn, user);
				return null;
			}}.doService();
	}
	
	/**
	 * 完善个人资料
	 * @param user
	 */
	@SuppressWarnings("rawtypes")
	public void perfectInfo(User user) {
		new BaseService() {

			@Override
			public Object service(Connection conn) throws SQLException {
				dao.update(conn, user);
				return null;
			}}.doService();
	}
}
