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
 * CourseService.java ��Ƶ�γ�ҵ������
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.service->CourseService.java
 * @see 2015��12��13�� ����5:33:55
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class CourseService {

	// ��־��¼
	private Logger log = Logger.getLogger(this.getClass());

	private IDAO<Course> dao = new CourseDAO();
	private List<Course> list;
	private Course course;
	private Connection conn;

	/**
	 * ���ݿγ����Ͳ�ѯ���еĿγ�
	 * 
	 * @param courseType
	 *            Ҫ��ѯ�γ̵�����
	 * @return ����������������еĿγ�
	 */
	public List<Course> findByType(CourseType courseType) {
		try {
			log.info("��ȡ���ݿ�����");
			conn = ConnectionManager.getConnection();
			log.info("��ʼ���ݿγ����Ͳ�ѯ�����γ�����");
			list = dao.findByCondition(conn, SystemParam.COURSE_COURSETYPE, courseType.getCtId());
			log.info("��ѯ��ɣ���ѯ���γ���Ŀ:" + list.size() + "����");
		} catch (SQLException e) {
			log.warn("��ѯʧ��....");
			e.printStackTrace();
		} finally {
			log.info("�ر����ݿ�����");
			ConnectionManager.free(conn);
		}
		return list;
	}

	/**
	 * ����γ���Ϣ�����ݿ�ķ���
	 */
	public void save(Course course) {
		try {
			conn = ConnectionManager.getConnection();
			log.info("������Ƶ�γ�����");
			dao.add(conn, course);
			log.info("������Ƶ�γ����");
		} catch (SQLException e) {
			log.warn("����ʧ��....");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
	}

	/**
	 * ���ݿγ̱�Ų�ѯһ���γ�
	 * 
	 * @param cid
	 *            Ҫ��ѯ�Ŀγ̵ı��
	 * @return
	 */
	public Course findById(String cid) {
		try {
			log.info("���ݿγ̱�Ų�ѯ�γ����ݣ����" + cid);
			conn = ConnectionManager.getConnection();
			course = dao.findById(conn, Integer.parseInt(cid));
			log.info("���ݿγ̱�Ų�ѯ�γ�������ɣ�" + course.getCourseName());
		} catch (SQLException e) {
			log.warn("��ѯʧ��....");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}

		return course;
	}
}
