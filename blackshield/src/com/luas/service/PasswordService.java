package com.luas.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dao.impl.ManagerDAO;
import com.luas.dao.impl.MemberDAO;
import com.luas.dbhelper.ConnectionManager;
import com.luas.model.Manager;
import com.luas.model.Member;
import com.luas.model.Users;

/**
 * PasswordService.java 用户密码操作服务类
 * 
 * @author 老牟
 * @see blackshield->com.luas.service->PasswordService.java
 * @see 2015年12月14日 下午3:18:53
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class PasswordService {

	// 日志记录
	private Logger log = Logger.getLogger(this.getClass());
	private IDAO<Manager> managerDAO = new ManagerDAO();
	private IDAO<Member> memberDAO = new MemberDAO();
	private Connection conn;

	/**
	 * 修改密码的方法
	 * 
	 * @param users
	 * @return
	 */
	public boolean chgPasswd(Users users) {
		log.info("开始更新密码");
		try {
			conn = ConnectionManager.getConnection();
			if (users instanceof Member) {
				log.info("开始修改会员密码");
				memberDAO.update(conn, (Member) users);
			} else if (users instanceof Manager) {
				log.info("开始修改管理员密码");
				managerDAO.update(conn, (Manager) users);
			}
			return true;
		} catch (SQLException e) {
			log.warn("修改失败。。。");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}

		return false;
	}
}
