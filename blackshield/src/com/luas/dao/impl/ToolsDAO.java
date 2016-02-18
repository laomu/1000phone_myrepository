package com.luas.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dbhelper.DBHelper;
import com.luas.mapper.IMapper;
import com.luas.mapper.impl.ToolsMapper;
import com.luas.model.Tools;
import com.luas.utils.SystemParam;

/**
 * ToolsDAO.java ����������ݷ��ʶ�����
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.dao.impl->ToolsDAO.java
 * @see 2015��12��12�� ����4:00:54
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ToolsDAO implements IDAO<Tools> {

	// ��־��¼
	private static Logger log = Logger.getLogger(ToolsDAO.class);
	
	private DBHelper<Tools> dh = new DBHelper<Tools>();
	private IMapper<Tools> mapper = new ToolsMapper();
	private String sql;
	private List<Tools> list;
	private Tools tools;

	private int index;

	@Override
	public int add(Connection conn, Tools t) throws SQLException {
		log.debug("��ʼ����һ��������߶������ݵ����ݿ�");
		sql = "insert into tools(managerid, ttid, tname, publishtime, tdesc, toolsimg, path) values(?,?,?,?,?,?,?)";
		index =  dh.executeInsert(conn, sql, t.getManager().getId(), t.getToolsType().getTtId(), t.getTname(),
				t.getPublishTime(), t.getTdesc(), t.getToolsImg(), t.getPath());
		log.debug("����������ɣ�����������߶���ı��:" + index);
		return index;
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, Tools t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Tools findById(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tools> findAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tools> findByCondition(Connection conn, int type, Object... obj) throws SQLException {
		if (type == SystemParam.TOOLS_TOOSTYPE) {
			log.debug("��������������Ͳ�ѯһ���������");
			return this.findByToolsType(conn, obj);
		}
		return null;
	}

	/**
	 * ����������Ͳ�ѯ���
	 * 
	 * @param conn
	 * @param obj
	 * @return
	 * @throws SQLException
	 */
	private List<Tools> findByToolsType(Connection conn, Object... obj) throws SQLException {
		log.debug("��������������Ͳ�ѯ���ߣ�����������ͱ��:" + obj[0]);
		sql = "select * from tools where ttid = ?";
		list = dh.executeQuery(conn, sql, mapper, obj);
		log.debug("��ѯ��ɣ�����ѯ��" + list.size() + "������");
		return list;
	}

}
