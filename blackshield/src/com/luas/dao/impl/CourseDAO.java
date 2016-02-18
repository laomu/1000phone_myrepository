package com.luas.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dbhelper.DBHelper;
import com.luas.mapper.IMapper;
import com.luas.mapper.impl.CourseMapper;
import com.luas.model.Course;
import com.luas.utils.SystemParam;
/**
 * CourseDAO.java 课程数据访问对象类型
 * @author 老牟
 * @see blackshield->com.luas.dao.impl->CourseDAO.java
 * @see 2015年12月13日 下午5:37:22 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class CourseDAO implements IDAO<Course> {
	// 日志记录
	private static Logger log = Logger.getLogger(CourseDAO.class);
	
	private DBHelper<Course> dh = new DBHelper<Course>();
	private List<Course> list;
	private Course course;
	private IMapper<Course> mapper = new CourseMapper();
	private String sql;
	private int index;

	@Override
	public int add(Connection conn, Course t) throws SQLException {
		log.debug("开始保存课程数据到数据库...");
		sql = "insert into course(managerid, ctid, courseimg, courseName, courseDesc, publishtime, path) values(?,?,?,?,?,?,?)";
		index =  dh.executeInsert(conn, sql, t.getManager().getId(),t.getCt().getCtId(),
											t.getCourseImg(),t.getCourseName(),t.getCdesc(),
											t.getPublishTime(),t.getPath());
		log.debug("保存课程完成。新增ID：" + index);
		return index;
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, Course t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Course findById(Connection conn, int id) throws SQLException {
		log.debug("根据课程编号查询一个课程对象数据,课程编号—" + id);
		sql = "select * from course where courseid = ?";
		list = dh.executeQuery(conn, sql, mapper, id);
		if (list != null && list.size() > 0) {
			log.debug("查询课程完成，查询到课程" + list.get(0).getCourseName());
			return list.get(0);
		}
		log.debug("查询课程完成，没有查询到课程");
		return null;
	}

	@Override
	public List<Course> findAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findByCondition (Connection conn, int type, Object... obj) throws SQLException {
		if (type == SystemParam.COURSE_COURSETYPE) {
			log.debug("根据课程类型开始查询所有视频课程..COURSE_COURSETYPE.");
			return this.findByCourseType(conn,obj);
		}
		return null;
	}
	
	/**
	 * 根据类型查询课程视频
	 * @param conn 数据库连接
	 * @param type 课程类型
	 * @param obj 参数列表
	 * @return 返回查询到的课程集合
	 * @throws SQLException
	 */
	private List<Course> findByCourseType(Connection conn, Object... obj) throws SQLException {
		log.debug("根据课程类型开始查询所有视频课程...");
		sql = "select * from course where ctid = ?";
		list =  dh.executeQuery(conn, sql, mapper, obj);
		log.debug("根据课程类型查询课程完成，共查询到课程" + list.size() + "门课程");
		return list;
	}

}
