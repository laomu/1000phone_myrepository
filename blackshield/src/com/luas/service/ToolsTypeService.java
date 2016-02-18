package com.luas.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dao.impl.ToolsTypeDAO;
import com.luas.dbhelper.ConnectionManager;
import com.luas.model.ToolsType;

/**
 * ToolsService.java �����������ҵ������
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.service->ToolsService.java
 * @see 2015��12��12�� ����3:27:07
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ToolsTypeService {

	// ��־��¼
	private Logger log = Logger.getLogger(this.getClass());

	private IDAO<ToolsType> dao = new ToolsTypeDAO();
	private List<ToolsType> list;
	private ToolsType toolsType;
	private Connection conn;

	/**
	 * ��ѯ��������������͵ķ���
	 * 
	 * @return
	 */
	public List<ToolsType> findAll() {
		log.info("��ѯ���е������������");
		try {
			conn = ConnectionManager.getConnection();
			list =  dao.findAll(conn);
			log.info("��ѯ��ɣ�����ѯ��" + list.size() +"������...");
		} catch (SQLException e) {
			log.warn("��ѯʧ��");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}

		return list;
	}

	/**
	 * �������ͱ�Ų�ѯ����
	 * 
	 * @param tid
	 * @return
	 */
	public ToolsType findById(String tid) {
		log.info("��ʼ��������������ͱ�Ų�ѯ��Ӧ������");
		try {
			conn = ConnectionManager.getConnection();

			toolsType = dao.findById(conn, Integer.parseInt(tid));
			log.info("��ѯ��ɣ���ѯ�����������ݣ�" + toolsType.getTtId());
		} catch (SQLException e) {
			log.info("��ѯʧ��...");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return toolsType;
	}
}
