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
 * ToolsDAO.java 软件工具数据访问对象类
 * 
 * @author 老牟
 * @see blackshield->com.luas.dao.impl->ToolsDAO.java
 * @see 2015年12月12日 下午4:00:54
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ToolsDAO implements IDAO<Tools> {

	// 日志记录
	private static Logger log = Logger.getLogger(ToolsDAO.class);
	
	private DBHelper<Tools> dh = new DBHelper<Tools>();
	private IMapper<Tools> mapper = new ToolsMapper();
	private String sql;
	private List<Tools> list;
	private Tools tools;

	private int index;

	@Override
	public int add(Connection conn, Tools t) throws SQLException {
		log.debug("开始增加一个软件工具对象数据到数据库");
		sql = "insert into tools(managerid, ttid, tname, publishtime, tdesc, toolsimg, path) values(?,?,?,?,?,?,?)";
		index =  dh.executeInsert(conn, sql, t.getManager().getId(), t.getToolsType().getTtId(), t.getTname(),
				t.getPublishTime(), t.getTdesc(), t.getToolsImg(), t.getPath());
		log.debug("增加数据完成，新怎软件工具对象的编号:" + index);
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
			log.debug("根据软件工具类型查询一个软件工具");
			return this.findByToolsType(conn, obj);
		}
		return null;
	}

	/**
	 * 根据软件类型查询软件
	 * 
	 * @param conn
	 * @param obj
	 * @return
	 * @throws SQLException
	 */
	private List<Tools> findByToolsType(Connection conn, Object... obj) throws SQLException {
		log.debug("根据软件工具类型查询工具，软件工具类型编号:" + obj[0]);
		sql = "select * from tools where ttid = ?";
		list = dh.executeQuery(conn, sql, mapper, obj);
		log.debug("查询完成，共查询到" + list.size() + "条数据");
		return list;
	}

}
