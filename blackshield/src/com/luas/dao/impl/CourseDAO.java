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
 * CourseDAO.java �γ����ݷ��ʶ�������
 * @author ��Ĳ
 * @see blackshield->com.luas.dao.impl->CourseDAO.java
 * @see 2015��12��13�� ����5:37:22 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class CourseDAO implements IDAO<Course> {
	// ��־��¼
	private static Logger log = Logger.getLogger(CourseDAO.class);
	
	private DBHelper<Course> dh = new DBHelper<Course>();
	private List<Course> list;
	private Course course;
	private IMapper<Course> mapper = new CourseMapper();
	private String sql;
	private int index;

	@Override
	public int add(Connection conn, Course t) throws SQLException {
		log.debug("��ʼ����γ����ݵ����ݿ�...");
		sql = "insert into course(managerid, ctid, courseimg, courseName, courseDesc, publishtime, path) values(?,?,?,?,?,?,?)";
		index =  dh.executeInsert(conn, sql, t.getManager().getId(),t.getCt().getCtId(),
											t.getCourseImg(),t.getCourseName(),t.getCdesc(),
											t.getPublishTime(),t.getPath());
		log.debug("����γ���ɡ�����ID��" + index);
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
		log.debug("���ݿγ̱�Ų�ѯһ���γ̶�������,�γ̱�š�" + id);
		sql = "select * from course where courseid = ?";
		list = dh.executeQuery(conn, sql, mapper, id);
		if (list != null && list.size() > 0) {
			log.debug("��ѯ�γ���ɣ���ѯ���γ�" + list.get(0).getCourseName());
			return list.get(0);
		}
		log.debug("��ѯ�γ���ɣ�û�в�ѯ���γ�");
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
			log.debug("���ݿγ����Ϳ�ʼ��ѯ������Ƶ�γ�..COURSE_COURSETYPE.");
			return this.findByCourseType(conn,obj);
		}
		return null;
	}
	
	/**
	 * �������Ͳ�ѯ�γ���Ƶ
	 * @param conn ���ݿ�����
	 * @param type �γ�����
	 * @param obj �����б�
	 * @return ���ز�ѯ���Ŀγ̼���
	 * @throws SQLException
	 */
	private List<Course> findByCourseType(Connection conn, Object... obj) throws SQLException {
		log.debug("���ݿγ����Ϳ�ʼ��ѯ������Ƶ�γ�...");
		sql = "select * from course where ctid = ?";
		list =  dh.executeQuery(conn, sql, mapper, obj);
		log.debug("���ݿγ����Ͳ�ѯ�γ���ɣ�����ѯ���γ�" + list.size() + "�ſγ�");
		return list;
	}

}
