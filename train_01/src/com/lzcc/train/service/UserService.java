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
 * UserService.java �û�ҵ������
 * @author ��Ĳ
 * @see train_01->com.lzcc.train.service->UserService.java
 * @see 2016��1��26�� ����11:02:38 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class UserService {

	private User user;
	private List<User> list;
	private IDAO<User> dao = new UserDAO();
	private Connection conn;
	private int res;
	
	/**
	 * �û���½��ҵ��
	 * @param loginUser Ҫ��¼���û�
	 * @return
	 */
	/*public User login(User loginUser) {
		try {
			// ��ȡ���ݿ�����
			conn = ConnectionManager.getConnection();
			// �����û��˺������ѯ�û�
			list = dao.findByConndition(conn, FindType.USER_USERNAME_PASSWORD, 
														loginUser.getUsername(), 
														loginUser.getPassword());
			// �����ѯ���û������û���ȡ����
			if(list != null && list.size() > 0) {
				user = list.get(0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//�ر����ӣ��ͷ���Դ
			ConnectionManager.free(conn);
		}
		return user;
	}*/
	
	public User login(User loginUser) {
		return new BaseService<User>(){
			@Override
			public User service(Connection conn) throws SQLException {
				// �����û��˺������ѯ�û�
				list = dao.findByConndition(conn, FindType.USER_USERNAME_PASSWORD, 
															loginUser.getUsername(), 
															MD5.GetMD5Code(loginUser.getPassword()));
				// �����ѯ���û������û���ȡ����
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
			// 1. ��ȡ���ݿ�����
			conn = ConnectionManager.getConnection();
			// 2. ��ѯ�˺��Ƿ��Ѿ���ע��
			list = dao.findByConndition(conn, FindType.USER_USERNAME, registUser.getUsername());
			if (list != null && list.size() > 0) {
				// 3.�˺��Ѿ���ע�ᣬ����-2������
				res = -2;
			} else {
				// 4. û��ע�������ݿ�����û�ע����Ϣ
				res = dao.add(conn, registUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// last.�ر����ݿ�����
			ConnectionManager.free(conn);
		}
		return res;
	}*/
	
	public int regist(User registUser) { 
		return new BaseService<Integer>(){

			@Override
			public Integer service(Connection conn) throws SQLException {
				// 2. ��ѯ�˺��Ƿ��Ѿ���ע��
				list = dao.findByConndition(conn, FindType.USER_USERNAME, registUser.getUsername());
				if (list != null && list.size() > 0) {
					// 3.�˺��Ѿ���ע�ᣬ����-2������
					return -2;
				} else {
					// 4. û��ע�������ݿ�����û�ע����Ϣ
					registUser.setPassword(MD5.GetMD5Code(registUser.getPassword()));
					return dao.add(conn, registUser);
				}
			}
		}.doService();
	}
	/**
	 * �޸��û���¼����
	 * @param user
	 */
	@SuppressWarnings("rawtypes")
	public void chgPasswd(User user) {
		new BaseService() {

			@Override
			public Object service(Connection conn) throws SQLException {
				user.setPassword(MD5.GetMD5Code(user.getPassword()));// �����û�����
				dao.update(conn, user);
				return null;
			}}.doService();
	}
	
	/**
	 * ���Ƹ�������
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
