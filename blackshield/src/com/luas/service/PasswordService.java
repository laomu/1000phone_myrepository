package com.luas.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dao.impl.ManagerDAO;
import com.luas.dao.impl.MemberDAO;
import com.luas.dbhelper.ConnectionManager;
import com.luas.model.Manager;
import com.luas.model.Member;
import com.luas.model.Users;

/**
 * PasswordService.java �û��������������
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.service->PasswordService.java
 * @see 2015��12��14�� ����3:18:53
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class PasswordService {

	// ��־��¼
	private Logger log = Logger.getLogger(this.getClass());
	private IDAO<Manager> managerDAO = new ManagerDAO();
	private IDAO<Member> memberDAO = new MemberDAO();
	private Connection conn;

	/**
	 * �޸�����ķ���
	 * 
	 * @param users
	 * @return
	 */
	public boolean chgPasswd(Users users) {
		log.info("��ʼ��������");
		try {
			conn = ConnectionManager.getConnection();
			if (users instanceof Member) {
				log.info("��ʼ�޸Ļ�Ա����");
				memberDAO.update(conn, (Member) users);
			} else if (users instanceof Manager) {
				log.info("��ʼ�޸Ĺ���Ա����");
				managerDAO.update(conn, (Manager) users);
			}
			return true;
		} catch (SQLException e) {
			log.warn("�޸�ʧ�ܡ�����");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}

		return false;
	}
}
