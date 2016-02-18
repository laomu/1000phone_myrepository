package com.luas.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dao.impl.DocTypeDAO;
import com.luas.dbhelper.ConnectionManager;
import com.luas.model.DocType;

/**
 * DocTypeService.java �ĵ����ͷ�����
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.service->DocTypeService.java
 * @see 2015��12��10�� ����11:31:28
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class DocTypeService {

	// ��־��¼
	private Logger log = Logger.getLogger(this.getClass());

	private IDAO<DocType> docTypeDAO = new DocTypeDAO();
	private List<DocType> list;
	private DocType docType;
	private Connection conn;

	/**
	 * ��ѯ���е��ĵ�����
	 * 
	 * @return
	 */
	public List<DocType> findAll() {
		log.info("��ѯ���е��ĵ���������");
		try {
			conn = ConnectionManager.getConnection();

			list = docTypeDAO.findAll(conn);
			log.info("��ѯ��ɣ�����ѯ��" + list.size() + "�����ݡ�");
		} catch (SQLException e) {
			log.info("��ѯʧ�ܡ�");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return list;
	}

	/**
	 * �����ĵ���Ų�ѯ�ĵ�����
	 * 
	 * @param typeId
	 * @return
	 */
	public DocType findById(String typeId) {
		log.info("�����ĵ����ͱ�Ų�ѯ������ĵ�����.");
		try {
			int tid = Integer.parseInt(typeId);// ���ַ�����idת����������id
			conn = ConnectionManager.getConnection();// ��ȡ����

			docType = docTypeDAO.findById(conn, tid);
			log.info("��ѯ��ɣ���ѯ�����ݣ�" + docType.getDeName());
		} catch (NumberFormatException e) {
			log.warn("�����ID������󣬲�ѯʧ��");
			e.printStackTrace();
		} catch (SQLException e) {
			log.warn("��ѯʧ��");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return docType;
	}
}
