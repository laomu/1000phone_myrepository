package com.luas.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dao.impl.CourseDAO;
import com.luas.dbhelper.ConnectionManager;
import com.luas.model.Course;
import com.luas.model.CourseType;
import com.luas.utils.SystemParam;

/**
 * CourseService.java 视频课程业务处理类
 * 
 * @author 老牟
 * @see blackshield->com.luas.service->CourseService.java
 * @see 2015年12月13日 下午5:33:55
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class CourseService {

	// 日志记录
	private Logger log = Logger.getLogger(this.getClass());

	private IDAO<Course> dao = new CourseDAO();
	private List<Course> list;
	private Course course;
	private Connection conn;

	/**
	 * 根据课程类型查询所有的课程
	 * 
	 * @param courseType
	 *            要查询课程的类型
	 * @return 返回这个类型下所有的课程
	 */
	public List<Course> findByType(CourseType courseType) {
		try {
			log.info("获取数据库连接");
			conn = ConnectionManager.getConnection();
			log.info("开始根据课程类型查询所属课程数据");
			list = dao.findByCondition(conn, SystemParam.COURSE_COURSETYPE, courseType.getCtId());
			log.info("查询完成，查询到课程数目:" + list.size() + "条。");
		} catch (SQLException e) {
			log.warn("查询失败....");
			e.printStackTrace();
		} finally {
			log.info("关闭数据库连接");
			ConnectionManager.free(conn);
		}
		return list;
	}

	/**
	 * 保存课程信息到数据库的方法
	 */
	public void save(Course course) {
		try {
			conn = ConnectionManager.getConnection();
			log.info("保存视频课程数据");
			dao.add(conn, course);
			log.info("保存视频课程完成");
		} catch (SQLException e) {
			log.warn("保存失败....");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
	}

	/**
	 * 根据课程编号查询一个课程
	 * 
	 * @param cid
	 *            要查询的课程的编号
	 * @return
	 */
	public Course findById(String cid) {
		try {
			log.info("根据课程编号查询课程数据，编号" + cid);
			conn = ConnectionManager.getConnection();
			course = dao.findById(conn, Integer.parseInt(cid));
			log.info("根据课程编号查询课程数据完成：" + course.getCourseName());
		} catch (SQLException e) {
			log.warn("查询失败....");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}

		return course;
	}
}
