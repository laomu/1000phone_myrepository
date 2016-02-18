package com.luas.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dbhelper.DBHelper;
import com.luas.mapper.IMapper;
import com.luas.mapper.impl.CourseTypeMapper;
import com.luas.model.CourseType;

/**
 * CourseTypeDAO.java 课程类型数据访问对象类
 * 
 * @author 老牟
 * @see blackshield->com.luas.dao.impl->CourseTypeDAO.java
 * @see 2015年12月13日 下午5:22:32
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class CourseTypeDAO implements IDAO<CourseType> {

	// 日志记录
	private static Logger log = Logger.getLogger(CourseTypeDAO.class);

	private DBHelper<CourseType> dh = new DBHelper<CourseType>();
	private IMapper<CourseType> mapper = new CourseTypeMapper();
	private List<CourseType> list;
	private CourseType ct;
	private String sql;

	@Override
	public int add(Connection conn, CourseType t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, CourseType t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CourseType findById(Connection conn, int id) throws SQLException {
		log.debug("开始根据ID编号查询对应的视频课程类型的对象数据——编号：" + id);
		sql = "select * from coursetype where ctid = ?";
		list = dh.executeQuery(conn, sql, mapper, id);
		if (list != null && list.size() > 0) {
			log.debug("查询到课程类型" + list.get(0).getCtName());
			return list.get(0);
		}
		log.debug("没有查询到课程类型");
		return null;
	}

	@Override
	public List<CourseType> findAll(Connection conn) throws SQLException {
		log.debug("开始查询所有的视频课程类型数据");
		sql = "select * from coursetype";
		list =  dh.executeQuery(conn, sql, mapper);
		log.debug("查询完成，共查询到" + list.size() + "条课程类型数据");
		return list;
	}

	@Override
	public List<CourseType> findByCondition(Connection conn, int type, Object... obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
