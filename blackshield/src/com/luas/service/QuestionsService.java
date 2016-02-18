package com.luas.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dao.impl.QuestionsDAO;
import com.luas.dbhelper.ConnectionManager;
import com.luas.model.Questions;

/**
 * QuestionsService.java �û�������ϵ������Ϣҵ������
 * @author ��Ĳ
 * @see blackshield->com.luas.service->QuestionsService.java
 * @see 2015��12��23�� ����1:05:38 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class QuestionsService {

	private static Logger log = Logger.getLogger(QuestionsService.class);
	
	private Connection conn;
	
	private IDAO<Questions> dao = new QuestionsDAO();
	
	private List<Questions> list;
	
	private Questions questions;
	/**
	 * �����û���Ϣ
	 * @param questions
	 */
	public void saveQuestions(Questions questions) {
		log.info("��ʼ�����û����͵Ľ�������...");
		try {
			conn = ConnectionManager.getConnection();
			dao.add(conn, questions);
			log.info("�û����͵Ľ������Ᵽ�����...");
		} catch (SQLException e) {
			log.warn("�û����ͽ������Ᵽ����󣬳����쳣��");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
	}
	
	/**
	 * ��ѯ�û����͵����н�������
	 * @return
	 */
	public List<Questions> findAll() {
		log.info("��ʼ��ѯ���е��û����͵Ľ�������");
		try {
			conn = ConnectionManager.getConnection();
			list = dao.findAll(conn);
			log.info("��ѯ��ɣ�����ѯ��" + list.size() + "����¼");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return list;
	}
	
	/**
	 * ��ǽ������
	 * @param id Ҫ��������id���
	 */
	public void dealQuestions(String id) {
		log.info("��ʼ��ǽ�����⣬��Ǳ��:" + id);
		try {
			conn = ConnectionManager.getConnection();
			// ��ѯ��Ŷ�Ӧ������
			questions = dao.findById(conn, Integer.parseInt(id));
			// �޸Ľ��״̬
			questions.setQtDeal(true);
			// ���µ����ݿ�
			dao.update(conn, questions);
			log.info("�����ɣ���������");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
	}
	
	/**
	 * ɾ���������ݼ�¼
	 * @param id
	 */
	public void deleteQuestions(String id) {
		log.info("��ʼɾ�����⣬ɾ����������:" + id);
		try {
			conn = ConnectionManager.getConnection();
			// ɾ����Ŷ�Ӧ������
			dao.delete(conn, Integer.parseInt(id));
			log.info("ɾ�����");
		} catch (SQLException e) {
			log.warn("ɾ��ʧ�ܣ������쳣...");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
	}
}
