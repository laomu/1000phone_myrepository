package com.luas.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dao.impl.CourseTypeDAO;
import com.luas.dbhelper.ConnectionManager;
import com.luas.model.CourseType;

/**
 * CourseTypeService.java �γ�����ҵ������
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.service->CourseTypeService.java
 * @see 2015��12��13�� ����5:19:26
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class CourseTypeService {

	// ��־��¼
	private Logger log = Logger.getLogger(this.getClass());

	private IDAO<CourseType> dao = new CourseTypeDAO();
	private List<CourseType> list;
	private CourseType courseType;
	private Connection conn;

	/**
	 * ��ѯ���пγ����͵ķ���
	 * 
	 * @return
	 */
	public List<CourseType> findAll() {
		log.info("��ʼִ�в�ѯ���пγ����͵ķ���...");
		try {
			// ��ȡ���ݿ�����
			conn = ConnectionManager.getConnection();
			// ���ò�ѯ�����б�ķ������в�ѯ
			list = dao.findAll(conn);
			log.info("��ѯ��ɣ�����ѯ����¼��Ŀ:" + list.size() + "�����ݡ�");
		} catch (SQLException e) {
			log.warn("��ѯʧ��....");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return list;
	}

	/**
	 * ����id��Ų�ѯһ���������
	 * 
	 * @param id
	 *            ���
	 * @return ���ز�ѯ���Ķ���
	 */
	public CourseType findById(String ctId) {
		log.info("��ʼ���ݿγ����ͱ�Ų�ѯ����Ŀγ���������...");
		try {
			conn = ConnectionManager.getConnection();
			courseType = dao.findById(conn, Integer.parseInt(ctId));
			log.info("��ѯ��ɣ���ѯ��������:" + courseType.getCtName());
		} catch (SQLException e) {
			log.warn("��ѯʧ��....");
			e.printStackTrace();
		} finally {

		}
		return courseType;
	}

}
