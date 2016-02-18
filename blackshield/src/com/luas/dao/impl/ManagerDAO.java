package com.luas.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dbhelper.DBHelper;
import com.luas.mapper.IMapper;
import com.luas.mapper.impl.ManagerMapper;
import com.luas.model.Manager;
import com.luas.utils.SystemParam;

/**
 * ManagerDAO.java 管理员数据访问类
 * 
 * @author 老牟
 * @see blackshield->com.luas.dao.impl->ManagerDAO.java
 * @see 2015年12月7日 上午10:41:05
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ManagerDAO implements IDAO<Manager> {

	// 日志记录
	private static Logger log = Logger.getLogger(ManagerDAO.class);

	private DBHelper<Manager> dh = new DBHelper<Manager>();
	private IMapper<Manager> mapper = new ManagerMapper();
	private List<Manager> managerList;
	private Manager manager;
	private String sql;
	private int index;

	@Override
	public int add(Connection conn, Manager t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, Manager t) throws SQLException {
		log.debug("开始修改管理员数据到数据库.要修改的管理员." + t.getId());
		sql = "update manager set username = ?,".concat("password = ?,").concat("realName = ?,").concat("phone = ?,")
				.concat("headerImg = ?,").concat("email = ?,").concat("registTime = ? ").concat(" where managerId = ?");
		index =  dh.executeSQL(conn, sql, t.getUsername(), t.getPassword(), t.getRealName(), t.getPhone(),
				t.getHeaderImg(), t.getEmail(), t.getRegistTime(), t.getId());
		log.debug("修改管理员数据完成。");
		return index;
	}

	@Override
	public Manager findById(Connection conn, int id) throws SQLException {
		log.debug("开始根据管理员编号查询管理员对象数据，编号:" + id);
		sql = "select * from manager where managerid = ?";
		managerList = dh.executeQuery(conn, sql, mapper, id);
		if (managerList != null && managerList.size() > 0) {
			log.debug("查询完成，查询到的管理员:" + managerList.get(0).getRealName());
			return managerList.get(0);
		}
		log.debug("没有查询到对应的管理员数据");
		return null;
	}

	@Override
	public List<Manager> findAll(Connection conn) throws SQLException {
		log.debug("查询所有的管理员数据");
		sql = "select * from manager";
		managerList = dh.executeQuery(conn, sql, mapper);
		log.debug("查询完成，共查询到" + managerList.size()+ "条管理员数据");
		return managerList;
	}

	@Override
	public List<Manager> findByCondition(Connection conn, int type, Object... obj) throws SQLException {
		if (type == SystemParam.MANAGER_USERNAME_PASSWORD) {
			log.debug("根据账号+密码查询管理员数据");
			return this.findByUsernameAndPassword(conn, obj);
		}
		return null;
	}

	private List<Manager> findByUsernameAndPassword(Connection conn, Object... obj) throws SQLException {
		log.debug("开始根据账号和密码两个条件查询对应的管理员");
		sql = "select * from manager where username = ? and password = ?";
		managerList =  dh.executeQuery(conn, sql, mapper, obj);
		log.debug("查询的到的管理员" + managerList.size()+ "条数据...");
		return managerList;
	}

}
