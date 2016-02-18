package com.luas.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dao.impl.MemberDAO;
import com.luas.dbhelper.ConnectionManager;
import com.luas.model.Member;

/**
 * MemberService.java ��Աҵ������
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.service->MemberService.java
 * @see 2015��12��14�� ����10:24:55
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class MemberService {

	// ��־��¼
	private Logger log = Logger.getLogger(this.getClass());
	private IDAO<Member> memberDAO = new MemberDAO();
	private List<Member> list;
	private Member member;
	private Connection conn;

	/**
	 * ��ѯ���еĻ�Ա����
	 * 
	 * @return
	 */
	public List<Member> findAll() {
		log.info("��ʼ��ѯ���еĻ�Ա����");
		try {
			conn = ConnectionManager.getConnection();
			list = memberDAO.findAll(conn);
			log.info("��ѯ��ɣ�����ѯ��" + list.size() + "������...");
		} catch (SQLException e) {
			log.warn("��ѯʧ��..");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return list;
	}

	/**
	 * ���ݻ�Ա���ɾ��һ����Ա����
	 * 
	 * @param mid
	 */
	public void deleteById(String mid) {
		log.info("���ݻ�Ա���ɾ��һ����Ա");
		try {
			conn = ConnectionManager.getConnection();
			// ������MemberDAO���������delete�������Ա�Ŷ�Ӧ��Member����ɾ��
			memberDAO.delete(conn, Integer.parseInt(mid));
			log.info("ɾ�����");
		} catch (SQLException e) {
			log.warn("ɾ��ʧ��");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}

	}

	/**
	 * ���ݱ�Ų�ѯһ����Ա
	 * 
	 * @param mid
	 * @return
	 */
	public Member findById(String mid) {
		log.info("���ݻ�Ա��Ų�ѯ��Ա����");
		try {
			conn = ConnectionManager.getConnection();

			member = memberDAO.findById(conn, Integer.parseInt(mid));
			log.info("��ѯ��ɣ���ѯ����Ա��" + member.getUsername());
		} catch (SQLException e) {
			log.warn("��ѯʧ��");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return member;
	}

	/**
	 * ����ָ����ŵĻ�Ա
	 * 
	 * @param mid
	 */
	public void lockMember(String mid, boolean isLock) {
		log.info("���ݻ�Ա�������һ����Ա");
		try {
			conn = ConnectionManager.getConnection();

			// ��ѯ��Ӧ��ŵĻ�Ա
			member = memberDAO.findById(conn, Integer.parseInt(mid));

			// ��������
			member.setLock(isLock);

			// ���ĵ����ݿ�
			memberDAO.update(conn, member);
			
			log.info("��Ա�˺�������ɣ���������Ա��" + member.getUsername());
		} catch (SQLException e) {
			log.warn("��Ա����ʧ��...");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
	}

	/**
	 * ���Ƹ�������ҳ��
	 * 
	 * @param member
	 */
	public void perfectInfo(Member member) {
		log.info("���ƻ�Ա��������...");
		try {
			conn = ConnectionManager.getConnection();

			memberDAO.update(conn, member);
			log.info("��������������ɡ�");
		} catch (SQLException e) {
			log.warn("��������ʧ�ܣ�");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
	}
}
