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
 * ToolsService.java 软件工具类型业务处理类
 * 
 * @author 老牟
 * @see blackshield->com.luas.service->ToolsService.java
 * @see 2015年12月12日 下午3:27:07
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ToolsTypeService {

	// 日志记录
	private Logger log = Logger.getLogger(this.getClass());

	private IDAO<ToolsType> dao = new ToolsTypeDAO();
	private List<ToolsType> list;
	private ToolsType toolsType;
	private Connection conn;

	/**
	 * 查询所有软件工具类型的方法
	 * 
	 * @return
	 */
	public List<ToolsType> findAll() {
		log.info("查询所有的软件工具类型");
		try {
			conn = ConnectionManager.getConnection();
			list =  dao.findAll(conn);
			log.info("查询完成，共查询到" + list.size() +"条数据...");
		} catch (SQLException e) {
			log.warn("查询失败");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}

		return list;
	}

	/**
	 * 根据类型编号查询类型
	 * 
	 * @param tid
	 * @return
	 */
	public ToolsType findById(String tid) {
		log.info("开始根据软件工具类型编号查询对应的类型");
		try {
			conn = ConnectionManager.getConnection();

			toolsType = dao.findById(conn, Integer.parseInt(tid));
			log.info("查询完成，查询到的类型数据：" + toolsType.getTtId());
		} catch (SQLException e) {
			log.info("查询失败...");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return toolsType;
	}
}
