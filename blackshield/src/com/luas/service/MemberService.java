package com.luas.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dao.impl.MemberDAO;
import com.luas.dbhelper.ConnectionManager;
import com.luas.model.Member;

/**
 * MemberService.java 会员业务处理类
 * 
 * @author 老牟
 * @see blackshield->com.luas.service->MemberService.java
 * @see 2015年12月14日 上午10:24:55
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class MemberService {

	// 日志记录
	private Logger log = Logger.getLogger(this.getClass());
	private IDAO<Member> memberDAO = new MemberDAO();
	private List<Member> list;
	private Member member;
	private Connection conn;

	/**
	 * 查询所有的会员数据
	 * 
	 * @return
	 */
	public List<Member> findAll() {
		log.info("开始查询所有的会员数据");
		try {
			conn = ConnectionManager.getConnection();
			list = memberDAO.findAll(conn);
			log.info("查询完成，共查询到" + list.size() + "条数据...");
		} catch (SQLException e) {
			log.warn("查询失败..");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return list;
	}

	/**
	 * 根据会员编号删除一个会员数据
	 * 
	 * @param mid
	 */
	public void deleteById(String mid) {
		log.info("根据会员编号删除一个会员");
		try {
			conn = ConnectionManager.getConnection();
			// 调用了MemberDAO对象里面的delete方法，对编号对应的Member进行删除
			memberDAO.delete(conn, Integer.parseInt(mid));
			log.info("删除完成");
		} catch (SQLException e) {
			log.warn("删除失败");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}

	}

	/**
	 * 根据编号查询一个会员
	 * 
	 * @param mid
	 * @return
	 */
	public Member findById(String mid) {
		log.info("根据会员编号查询会员数据");
		try {
			conn = ConnectionManager.getConnection();

			member = memberDAO.findById(conn, Integer.parseInt(mid));
			log.info("查询完成，查询到会员：" + member.getUsername());
		} catch (SQLException e) {
			log.warn("查询失败");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return member;
	}

	/**
	 * 锁定指定编号的会员
	 * 
	 * @param mid
	 */
	public void lockMember(String mid, boolean isLock) {
		log.info("根据会员编号锁定一个会员");
		try {
			conn = ConnectionManager.getConnection();

			// 查询对应编号的会员
			member = memberDAO.findById(conn, Integer.parseInt(mid));

			// 设置锁定
			member.setLock(isLock);

			// 更改到数据库
			memberDAO.update(conn, member);
			
			log.info("会员账号锁定完成，被锁定会员：" + member.getUsername());
		} catch (SQLException e) {
			log.warn("会员锁定失败...");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
	}

	/**
	 * 完善个人资料页面
	 * 
	 * @param member
	 */
	public void perfectInfo(Member member) {
		log.info("完善会员个人资料...");
		try {
			conn = ConnectionManager.getConnection();

			memberDAO.update(conn, member);
			log.info("个人资料完善完成。");
		} catch (SQLException e) {
			log.warn("完善资料失败！");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
	}
}
