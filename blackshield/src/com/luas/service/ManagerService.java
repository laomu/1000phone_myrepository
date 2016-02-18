package com.luas.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dao.impl.ManagerDAO;
import com.luas.dbhelper.ConnectionManager;
import com.luas.model.Manager;

/**
 * ManagerService.java ����Աҵ�������
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.service->ManagerService.java
 * @see 2015��12��14�� ����9:53:09
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ManagerService {
	// ��־��¼
	private Logger log = Logger.getLogger(this.getClass());
	// ������������Ա���ݷ��ʶ���
	private IDAO<Manager> dao = new ManagerDAO();
	// �����������Ա���ݵĽ�Ϻͱ���
	private List<Manager> list;
	private Manager manager;
	// ������������
	private Connection conn;

	/**
	 * ��ѯ���еĹ���Ա
	 * 
	 * @return
	 */
	public List<Manager> findAll() {
		log.info("��ѯ���еĹ���Ա����");
		try {
			conn = ConnectionManager.getConnection();
			list = dao.findAll(conn);
			log.info("��ѯ��ɣ�����ѯ��:" + list.size() + "������...");
		} catch (SQLException e) {
			log.info("��ѯʧ��...");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return list;
	}

	/**
	 * ���ƹ���Ա��������
	 * 
	 * @param manager
	 */
	public void perfect(Manager manager) {
		log.info("��ʼ���ƹ���Ա��������...");
		try {
			conn = ConnectionManager.getConnection();
			dao.update(conn, manager);
			log.info("����Ա��Ϣ������ɡ�");
		} catch (SQLException e) {
			log.warn("����Ա��Ϣ����ʧ�ܣ�");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
	}
}
