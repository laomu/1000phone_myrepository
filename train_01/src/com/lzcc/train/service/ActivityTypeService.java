package com.lzcc.train.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dao.impl.ActivityTypeDAO;
import com.lzcc.train.dbhelper.ConnectionManager;
import com.lzcc.train.model.ActivityType;

/**
 * ActivityTypeService.java 活动类型业务处理类 
 * @author 老牟
 * @see train_01->com.lzcc.train.service->ActivityTypeService.java
 * @see 2016年1月28日 下午4:05:00 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ActivityTypeService {
	private ActivityType at;
	private List<ActivityType> atlist;
	private IDAO<ActivityType> dao = new ActivityTypeDAO();
	private Connection conn;

	/**
	 * 根据活动类型编号查询一个活动
	 * @param aid
	 * @return
	 */
	public ActivityType findById(String aid) {
		try {
			conn = ConnectionManager.getConnection();
			
			at = dao.findById(conn, Integer.parseInt(aid));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return at;
	}
}
