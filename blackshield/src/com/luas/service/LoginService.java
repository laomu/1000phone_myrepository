package com.luas.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dao.impl.ManagerDAO;
import com.luas.dao.impl.MemberDAO;
import com.luas.dbhelper.ConnectionManager;
import com.luas.model.Manager;
import com.luas.model.Member;
import com.luas.model.Users;
import com.luas.utils.SystemParam;

/**
 * LoginService.java 系统登录业务服务类
 * 
 * @author 老牟
 * @see blackshield->com.luas.service->LoginService.java
 * @see 2015年12月7日 上午10:40:02
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class LoginService {

	// 日志记录
	private Logger log = Logger.getLogger(this.getClass());
	private IDAO<Member> memberDAO = new MemberDAO();
	private IDAO<Manager> managerDAO = new ManagerDAO();
	private List<? extends Users> list;
	private Member member;
	private Connection conn;

	/**
	 * 登录的方法
	 * 
	 * @return 返回Users对象，如果对象为空，表示登录失败
	 */
	public Users login(Users users) {
		log.info("开始执行登录验证");
		try {
			conn = ConnectionManager.getConnection();// 获取连接
			if (users instanceof Member) {
				// 根据条件查询进行登录操作
				log.info("会员登录操作");
				list = memberDAO.findByCondition(conn, SystemParam.MEMBER_USERNAME_PASSWORD, users.getUsername(),
						users.getPassword());
			} else if (users instanceof Manager) {
				log.info("管理员登录操作");
				list = managerDAO.findByCondition(conn, SystemParam.MANAGER_USERNAME_PASSWORD, users.getUsername(),
						users.getPassword());
			} else {
				return null;
			}

			if (list != null && list.size() > 0) {
				log.info("登录成功，登录用户：" + list.get(0).getUsername());
				return list.get(0);
			}
		} catch (SQLException e) {
			log.warn("登录出现问题。");
			e.printStackTrace();
		}
		return null;
	}
}
