package com.luas.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dao.impl.ManagerDAO;
import com.luas.dao.impl.MemberDAO;
import com.luas.dbhelper.ConnectionManager;
import com.luas.model.Manager;
import com.luas.model.Member;
import com.luas.model.Users;
import com.luas.utils.SystemParam;

/**
 * LoginService.java ϵͳ��¼ҵ�������
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.service->LoginService.java
 * @see 2015��12��7�� ����10:40:02
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class LoginService {

	// ��־��¼
	private Logger log = Logger.getLogger(this.getClass());
	private IDAO<Member> memberDAO = new MemberDAO();
	private IDAO<Manager> managerDAO = new ManagerDAO();
	private List<? extends Users> list;
	private Member member;
	private Connection conn;

	/**
	 * ��¼�ķ���
	 * 
	 * @return ����Users�����������Ϊ�գ���ʾ��¼ʧ��
	 */
	public Users login(Users users) {
		log.info("��ʼִ�е�¼��֤");
		try {
			conn = ConnectionManager.getConnection();// ��ȡ����
			if (users instanceof Member) {
				// ����������ѯ���е�¼����
				log.info("��Ա��¼����");
				list = memberDAO.findByCondition(conn, SystemParam.MEMBER_USERNAME_PASSWORD, users.getUsername(),
						users.getPassword());
			} else if (users instanceof Manager) {
				log.info("����Ա��¼����");
				list = managerDAO.findByCondition(conn, SystemParam.MANAGER_USERNAME_PASSWORD, users.getUsername(),
						users.getPassword());
			} else {
				return null;
			}

			if (list != null && list.size() > 0) {
				log.info("��¼�ɹ�����¼�û���" + list.get(0).getUsername());
				return list.get(0);
			}
		} catch (SQLException e) {
			log.warn("��¼�������⡣");
			e.printStackTrace();
		}
		return null;
	}
}
