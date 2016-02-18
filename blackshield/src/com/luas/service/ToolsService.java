package com.luas.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dao.impl.ToolsDAO;
import com.luas.dbhelper.ConnectionManager;
import com.luas.model.Tools;
import com.luas.model.ToolsType;
import com.luas.utils.SystemParam;

/**
 * ToolsService.java �������ҵ������
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
public class ToolsService {

	// ��־��¼
	private Logger log = Logger.getLogger(this.getClass());
	private IDAO<Tools> dao = new ToolsDAO();
	private Connection conn;
	private List<Tools> list;
	private Tools tools;

	/**
	 * ��������������Ͳ�ѯ���������е����
	 * 
	 * @param tt
	 *            �������
	 * @return ���ص�ǰ�����������
	 */
	public List<Tools> findByType(ToolsType tt) {
		log.info("��ʼ��������������Ͳ�ѯ�������������");
		try {
			conn = ConnectionManager.getConnection();
			list = dao.findByCondition(conn, SystemParam.TOOLS_TOOSTYPE, tt.getTtId());
			log.info("��ѯ��ɣ�����ѯ��" + list.size()+"�����ݡ�����");
		} catch (SQLException e) {
			log.warn("��ѯʧ�ܣ������쳣");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}

		return list;
	}

	/**
	 * ���湤�ߵķ���
	 * 
	 * @param tools
	 */
	public void save(Tools tools) {
		log.info("��ʼ����һ������������ݵ����ݿ�");
		try {
			conn = ConnectionManager.getConnection();
			int index = dao.add(conn, tools);
			log.info("�������,����������߱�ţ�" + index);
		} catch (SQLException e) {
			log.warn("����ʧ�ܣ������쳣");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
	}

}
