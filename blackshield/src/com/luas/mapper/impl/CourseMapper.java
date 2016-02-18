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
 * CourseMapper.java �γ����ݶ�������ݼ�¼ӳ���ϵ��
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.mapper.impl->CourseMapper.java
 * @see 2015��12��13�� ����5:48:35
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class CourseMapper implements IMapper<Course> {

	// ��־��¼
	private static Logger log = Logger.getLogger(CourseMapper.class);

	private IDAO<Manager> managerDAO = new ManagerDAO();
	private IDAO<CourseType> courseTypeDAO = new CourseTypeDAO();

	@Override
	public Course rowMapper(Connection conn, ResultSet rs) throws SQLException {
		log.debug("��ʼ���γ����ݷ�װ�ɿγ̶���");
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
		log.debug("��װ���");
		return course;
	}

}
