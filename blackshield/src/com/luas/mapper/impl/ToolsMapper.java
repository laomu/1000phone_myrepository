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
 * ToolsMapper.java 软件工具数据记录和java对象映射类
 * 
 * @author 老牟
 * @see blackshield->com.luas.mapper.impl->ToolsMapper.java
 * @see 2015年12月12日 下午4:03:00
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ToolsMapper implements IMapper<Tools> {

	// 日志记录
	private static Logger log = Logger.getLogger(ToolsMapper.class);
	private IDAO<Manager> managerDAO = new ManagerDAO();
	private IDAO<ToolsType> toolsTypeDAO = new ToolsTypeDAO();

	@Override
	public Tools rowMapper(Connection conn, ResultSet rs) throws SQLException {
		log.debug("开始将软件工具数据封装成软件工具对象");
		Tools tools = new Tools();
		tools.setToolsId(rs.getInt("toolsid"));
		tools.setManager(managerDAO.findById(conn, rs.getInt("managerid")));
		tools.setToolsType(toolsTypeDAO.findById(conn, rs.getInt("ttid")));
		tools.setTname(rs.getString("tname"));
		tools.setTdesc(rs.getString("tdesc"));
		tools.setPublishTime(rs.getDate("publishTime"));
		tools.setToolsImg(rs.getString("toolsimg"));
		tools.setPath(rs.getString("path"));
		log.debug("封装完成");
		return tools;
	}

}
