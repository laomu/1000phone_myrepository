package com.luas.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dao.impl.ManagerDAO;
import com.luas.dao.impl.ToolsTypeDAO;
import com.luas.mapper.IMapper;
import com.luas.model.Manager;
import com.luas.model.Tools;
import com.luas.model.ToolsType;

/**
 * ToolsMapper.java ����������ݼ�¼��java����ӳ����
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.mapper.impl->ToolsMapper.java
 * @see 2015��12��12�� ����4:03:00
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ToolsMapper implements IMapper<Tools> {

	// ��־��¼
	private static Logger log = Logger.getLogger(ToolsMapper.class);
	private IDAO<Manager> managerDAO = new ManagerDAO();
	private IDAO<ToolsType> toolsTypeDAO = new ToolsTypeDAO();

	@Override
	public Tools rowMapper(Connection conn, ResultSet rs) throws SQLException {
		log.debug("��ʼ������������ݷ�װ��������߶���");
		Tools tools = new Tools();
		tools.setToolsId(rs.getInt("toolsid"));
		tools.setManager(managerDAO.findById(conn, rs.getInt("managerid")));
		tools.setToolsType(toolsTypeDAO.findById(conn, rs.getInt("ttid")));
		tools.setTname(rs.getString("tname"));
		tools.setTdesc(rs.getString("tdesc"));
		tools.setPublishTime(rs.getDate("publishTime"));
		tools.setToolsImg(rs.getString("toolsimg"));
		tools.setPath(rs.getString("path"));
		log.debug("��װ���");
		return tools;
	}

}
