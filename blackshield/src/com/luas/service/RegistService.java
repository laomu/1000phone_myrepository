package com.luas.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dao.impl.MemberDAO;
import com.luas.dbhelper.ConnectionManager;
import com.luas.model.Member;
import com.luas.model.Users;
import com.luas.utils.SystemParam;

/**
 * RegistService.java 系统注册业务服务类
 * 
 * @author 老牟
 * @see blackshield->com.luas.service->RegistService.java
 * @see 2015年12月7日 上午10:40:19
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class RegistService {

	// 日志记录
	private Logger log = Logger.getLogger(this.getClass());
	private IDAO<Member> memberDAO = new MemberDAO();
	private Connection conn;
	private Member member;
	private List<Member> list;

	/**
	 * 用户注册的方法 限制. 用户账号已经存在不允许注册
	 * 
	 * @param user
	 * @return
	 */
	public boolean regist(Users user) {
		log.info("开始注册新会员.....");
		try {
			conn = ConnectionManager.getConnection();// 获取连接
			list = memberDAO.findByCondition(conn, SystemParam.MEMBER_USERNAME, user.getUsername());
			if (list != null && list.size() > 0) {
				log.info("注册失败，注册的账号已经存在...");
				return false;
			}

			memberDAO.add(conn, (Member) user);
			log.info("会员注册成功！");
			return true;
		} catch (SQLException e) {
			log.warn("注册失败，出现异常");
			e.printStackTrace();
		} finally {// 不论是否发成异常，都必须会执行的代码
			ConnectionManager.free(conn);// 关闭连接，释放资源
		}
		return false;
	}
}
