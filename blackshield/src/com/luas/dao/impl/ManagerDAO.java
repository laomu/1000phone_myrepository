package com.luas.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dbhelper.DBHelper;
import com.luas.mapper.IMapper;
import com.luas.mapper.impl.ManagerMapper;
import com.luas.model.Manager;
import com.luas.utils.SystemParam;

/**
 * ManagerDAO.java ����Ա���ݷ�����
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.dao.impl->ManagerDAO.java
 * @see 2015��12��7�� ����10:41:05
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ManagerDAO implements IDAO<Manager> {

	// ��־��¼
	private static Logger log = Logger.getLogger(ManagerDAO.class);

	private DBHelper<Manager> dh = new DBHelper<Manager>();
	private IMapper<Manager> mapper = new ManagerMapper();
	private List<Manager> managerList;
	private Manager manager;
	private String sql;
	private int index;

	@Override
	public int add(Connection conn, Manager t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, Manager t) throws SQLException {
		log.debug("��ʼ�޸Ĺ���Ա���ݵ����ݿ�.Ҫ�޸ĵĹ���Ա." + t.getId());
		sql = "update manager set username = ?,".concat("password = ?,").concat("realName = ?,").concat("phone = ?,")
				.concat("headerImg = ?,").concat("email = ?,").concat("registTime = ? ").concat(" where managerId = ?");
		index =  dh.executeSQL(conn, sql, t.getUsername(), t.getPassword(), t.getRealName(), t.getPhone(),
				t.getHeaderImg(), t.getEmail(), t.getRegistTime(), t.getId());
		log.debug("�޸Ĺ���Ա������ɡ�");
		return index;
	}

	@Override
	public Manager findById(Connection conn, int id) throws SQLException {
		log.debug("��ʼ���ݹ���Ա��Ų�ѯ����Ա�������ݣ����:" + id);
		sql = "select * from manager where managerid = ?";
		managerList = dh.executeQuery(conn, sql, mapper, id);
		if (managerList != null && managerList.size() > 0) {
			log.debug("��ѯ��ɣ���ѯ���Ĺ���Ա:" + managerList.get(0).getRealName());
			return managerList.get(0);
		}
		log.debug("û�в�ѯ����Ӧ�Ĺ���Ա����");
		return null;
	}

	@Override
	public List<Manager> findAll(Connection conn) throws SQLException {
		log.debug("��ѯ���еĹ���Ա����");
		sql = "select * from manager";
		managerList = dh.executeQuery(conn, sql, mapper);
		log.debug("��ѯ��ɣ�����ѯ��" + managerList.size()+ "������Ա����");
		return managerList;
	}

	@Override
	public List<Manager> findByCondition(Connection conn, int type, Object... obj) throws SQLException {
		if (type == SystemParam.MANAGER_USERNAME_PASSWORD) {
			log.debug("�����˺�+�����ѯ����Ա����");
			return this.findByUsernameAndPassword(conn, obj);
		}
		return null;
	}

	private List<Manager> findByUsernameAndPassword(Connection conn, Object... obj) throws SQLException {
		log.debug("��ʼ�����˺ź���������������ѯ��Ӧ�Ĺ���Ա");
		sql = "select * from manager where username = ? and password = ?";
		managerList =  dh.executeQuery(conn, sql, mapper, obj);
		log.debug("��ѯ�ĵ��Ĺ���Ա" + managerList.size()+ "������...");
		return managerList;
	}

}
