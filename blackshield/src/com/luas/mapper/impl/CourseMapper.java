package com.luas.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dao.impl.CourseTypeDAO;
import com.luas.dao.impl.ManagerDAO;
import com.luas.mapper.IMapper;
import com.luas.model.Course;
import com.luas.model.CourseType;
import com.luas.model.Manager;

/**
 * CourseMapper.java 课程数据对象和数据记录映射关系类
 * 
 * @author 老牟
 * @see blackshield->com.luas.mapper.impl->CourseMapper.java
 * @see 2015年12月13日 下午5:48:35
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class CourseMapper implements IMapper<Course> {

	// 日志记录
	private static Logger log = Logger.getLogger(CourseMapper.class);

	private IDAO<Manager> managerDAO = new ManagerDAO();
	private IDAO<CourseType> courseTypeDAO = new CourseTypeDAO();

	@Override
	public Course rowMapper(Connection conn, ResultSet rs) throws SQLException {
		log.debug("开始将课程数据封装成课程对象");
		Course course = new Course();
		course.setCourseId(rs.getInt("courseId"));
		course.setManager(managerDAO.findById(conn, rs.getInt("managerId")));
		course.setCt(courseTypeDAO.findById(conn, rs.getInt("ctId")));
		course.setCourseImg(rs.getString("courseImg"));
		course.setCourseName(rs.getString("courseName"));
		course.setCdesc(rs.getString("courseDesc"));
		course.setPublishTime(rs.getDate("publishTime"));
		course.setStudyCount(rs.getInt("studyCount"));
		course.setPath(rs.getString("path"));
		log.debug("封装完成");
		return course;
	}

}
