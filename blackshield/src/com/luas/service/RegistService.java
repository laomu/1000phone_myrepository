package com.luas.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dao.impl.MemberDAO;
import com.luas.dbhelper.ConnectionManager;
import com.luas.model.Member;
import com.luas.model.Users;
import com.luas.utils.SystemParam;

/**
 * RegistService.java ϵͳע��ҵ�������
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.service->RegistService.java
 * @see 2015��12��7�� ����10:40:19
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class RegistService {

	// ��־��¼
	private Logger log = Logger.getLogger(this.getClass());
	private IDAO<Member> memberDAO = new MemberDAO();
	private Connection conn;
	private Member member;
	private List<Member> list;

	/**
	 * �û�ע��ķ��� ����. �û��˺��Ѿ����ڲ�����ע��
	 * 
	 * @param user
	 * @return
	 */
	public boolean regist(Users user) {
		log.info("��ʼע���»�Ա.....");
		try {
			conn = ConnectionManager.getConnection();// ��ȡ����
			list = memberDAO.findByCondition(conn, SystemParam.MEMBER_USERNAME, user.getUsername());
			if (list != null && list.size() > 0) {
				log.info("ע��ʧ�ܣ�ע����˺��Ѿ�����...");
				return false;
			}

			memberDAO.add(conn, (Member) user);
			log.info("��Աע��ɹ���");
			return true;
		} catch (SQLException e) {
			log.warn("ע��ʧ�ܣ������쳣");
			e.printStackTrace();
		} finally {// �����Ƿ񷢳��쳣���������ִ�еĴ���
			ConnectionManager.free(conn);// �ر����ӣ��ͷ���Դ
		}
		return false;
	}
}
