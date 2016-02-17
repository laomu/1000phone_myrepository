package com.lzcc.train.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dao.impl.ActivityTypeDAO;
import com.lzcc.train.dbhelper.ConnectionManager;
import com.lzcc.train.model.ActivityType;

/**
 * ActivityTypeService.java �����ҵ������ 
 * @author ��Ĳ
 * @see train_01->com.lzcc.train.service->ActivityTypeService.java
 * @see 2016��1��28�� ����4:05:00 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ActivityTypeService {
	private ActivityType at;
	private List<ActivityType> atlist;
	private IDAO<ActivityType> dao = new ActivityTypeDAO();
	private Connection conn;

	/**
	 * ���ݻ���ͱ�Ų�ѯһ���
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
