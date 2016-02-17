package com.lzcc.train.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dbhelper.DBHelper;
import com.lzcc.train.mapper.IMapper;
import com.lzcc.train.mapper.impl.ActivityTypeMapper;
import com.lzcc.train.model.ActivityType;
import com.lzcc.train.utils.DeleteType;
import com.lzcc.train.utils.FindType;

/**
 * ActivityTypeDAO.java 活动类型数据访问对象
 * @author 老牟
 * @see train_01->com.lzcc.train.dao.impl->ActivityTypeDAO.java
 * @see 2016年1月26日 上午10:57:01 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ActivityTypeDAO implements IDAO<ActivityType> {
	private String sql;
	private ActivityType at;
	private List<ActivityType> atList;
	private IMapper<ActivityType> mapper = new ActivityTypeMapper();
	private DBHelper<ActivityType> dh = new DBHelper<ActivityType>();

	@Override
	public int add(Connection conn, ActivityType t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, ActivityType t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ActivityType findById(Connection conn, int id) throws SQLException {
		sql = "select * from activitytype where atid = ?";
		atList = dh.executeQuery(conn, mapper, sql, id);
		if (atList != null && atList.size() > 0) {
			return atList.get(0);
		}
		return null;
	}

	@Override
	public List<ActivityType> findAll(Connection conn) throws SQLException {
		sql = "select * from activitytype";
		return dh.executeQuery(conn, mapper, sql);
	}

	@Override
	public List<ActivityType> findByConndition(Connection conn, FindType type, Object... objs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByCondition(Connection conn, DeleteType type, Object... objs) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
