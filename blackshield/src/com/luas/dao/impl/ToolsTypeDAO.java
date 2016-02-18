package com.luas.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dbhelper.DBHelper;
import com.luas.mapper.IMapper;
import com.luas.mapper.impl.ToolsTypeMapper;
import com.luas.model.ToolsType;

/**
 * ToolsTypeDAO.java 软件工具类类型数据访问对象
 * 
 * @author 老牟
 * @see blackshield->com.luas.dao.impl->ToolsTypeDAO.java
 * @see 2015年12月12日 下午3:57:52
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ToolsTypeDAO implements IDAO<ToolsType> {

	// 日志记录
	private static Logger log = Logger.getLogger(ToolsTypeDAO.class);
	
	private DBHelper<ToolsType> dh = new DBHelper<ToolsType>();
	private IMapper<ToolsType> mapper = new ToolsTypeMapper();
	private String sql;
	private List<ToolsType> list;
	private ToolsType toolsType;

	@Override
	public int add(Connection conn, ToolsType t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Connection conn, ToolsType t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ToolsType findById(Connection conn, int id) throws SQLException {
		log.debug("根据编号查询对应的软件工具类型，编号：" + id);
		sql = "select * from toolstype where ttid = ?";
		list = dh.executeQuery(conn, sql, mapper, id);
		if (list != null && list.size() > 0) {
			log.debug("查询完成，查询到的类型：" + list.get(0).getTtName());
			return list.get(0);
		}
		log.debug("没有查询到对应编号的软件工具类型");
		return null;
	}

	@Override
	public List<ToolsType> findAll(Connection conn) throws SQLException {
		log.debug("查询系统中给所有的软件工具类型");
		sql = "select * from toolstype";
		list = dh.executeQuery(conn, sql, mapper);
		log.debug("查询完成，查询到" + list.size() + "条软件工具类型数据！");
		return list;
	}

	@Override
	public List<ToolsType> findByCondition(Connection conn, int type, Object... obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
