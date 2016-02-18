package com.luas.service;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dao.impl.DocDAO;
import com.luas.dbhelper.ConnectionManager;
import com.luas.model.Doc;
import com.luas.model.DocType;
import com.luas.utils.SystemParam;

/**
 * DocService.java �ĵ���������
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.service->DocService.java
 * @see 2015��12��10�� ����3:03:24
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class DocService {

	// ��־��¼
	private Logger log = Logger.getLogger(this.getClass());

	private IDAO<Doc> docDAO = new DocDAO();
	private Connection conn;
	private List<Doc> list;
	private Doc doc;

	/**
	 * ����һ���ĵ������ҵ������
	 * 
	 * @param doc
	 */
	public void save(Doc doc) {
		try {
			conn = ConnectionManager.getConnection();
			docDAO.add(conn, doc);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
	}

	/**
	 * �����ĵ����ͣ���ѯ�����������е��ĵ�
	 * 
	 * @param type
	 *            �ĵ�����
	 * @return ���ز�ѯ�����ĵ�����
	 */
	public List<Doc> findByType(DocType type) {
		try {
			conn = ConnectionManager.getConnection();

			return docDAO.findByCondition(conn, SystemParam.DOC_DOCTYPE, type.getDtId());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return null;
	}
	
	/**
	 * ���ݱ��ɾ��һ���ĵ�����
	 * @param id Ҫɾ�����ĵ����ϱ��
	 */
	public Doc deleteDoc(String id) {
		log.info("��ʼɾ���ĵ����ϣ��ĵ����:" + id);
		try {
			conn = ConnectionManager.getConnection();
			
			// ��ѯҪɾ�����ĵ�
			doc = docDAO.findById(conn, Integer.parseInt(id));
			if(doc == null) {
				log.info("Ҫɾ�����ĵ����ϲ�����");
				return null;
			}
			
			// ɾ�����ݿ��еļ�¼
			docDAO.delete(conn, Integer.parseInt(id));
			
			log.info("�ĵ�����ɾ�����");
		} catch (SQLException e) {
			log.warn("�ĵ�����ɾ��ʧ�ܣ������쳣...");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return doc;
	}
}
