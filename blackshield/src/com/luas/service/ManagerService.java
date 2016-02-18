package com.luas.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dao.impl.ManagerDAO;
import com.luas.dbhelper.ConnectionManager;
import com.luas.model.Manager;

/**
 * ManagerService.java 管理员业务服务类
 * 
 * @author 老牟
 * @see blackshield->com.luas.service->ManagerService.java
 * @see 2015年12月14日 上午9:53:09
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ManagerService {
	// 日志记录
	private Logger log = Logger.getLogger(this.getClass());
	// 声明并常见会员数据访问对象
	private IDAO<Manager> dao = new ManagerDAO();
	// 声明保存管理员数据的结合和变量
	private List<Manager> list;
	private Manager manager;
	// 声明数据连接
	private Connection conn;

	/**
	 * 查询所有的管理员
	 * 
	 * @return
	 */
	public List<Manager> findAll() {
		log.info("查询所有的管理员数据");
		try {
			conn = ConnectionManager.getConnection();
			list = dao.findAll(conn);
			log.info("查询完成，共查询到:" + list.size() + "条数据...");
		} catch (SQLException e) {
			log.info("查询失败...");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return list;
	}

	/**
	 * 完善管理员个人资料
	 * 
	 * @param manager
	 */
	public void perfect(Manager manager) {
		log.info("开始完善管理员个人资料...");
		try {
			conn = ConnectionManager.getConnection();
			dao.update(conn, manager);
			log.info("管理员信息保存完成。");
		} catch (SQLException e) {
			log.warn("管理员信息完善失败！");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
	}
}
