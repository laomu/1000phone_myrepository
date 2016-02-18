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
 * ToolsService.java 软件工具业务处理类
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
public class ToolsService {

	// 日志记录
	private Logger log = Logger.getLogger(this.getClass());
	private IDAO<Tools> dao = new ToolsDAO();
	private Connection conn;
	private List<Tools> list;
	private Tools tools;

	/**
	 * 根据软件工具类型查询类型下所有的软件
	 * 
	 * @param tt
	 *            软件类型
	 * @return 返回当前类型所有软件
	 */
	public List<Tools> findByType(ToolsType tt) {
		log.info("开始根据软件工具类型查询所属的软件工具");
		try {
			conn = ConnectionManager.getConnection();
			list = dao.findByCondition(conn, SystemParam.TOOLS_TOOSTYPE, tt.getTtId());
			log.info("查询完成，共查询到" + list.size()+"条数据。。。");
		} catch (SQLException e) {
			log.warn("查询失败，出现异常");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}

		return list;
	}

	/**
	 * 保存工具的方法
	 * 
	 * @param tools
	 */
	public void save(Tools tools) {
		log.info("开始保存一个软件工具数据到数据库");
		try {
			conn = ConnectionManager.getConnection();
			int index = dao.add(conn, tools);
			log.info("保存完成,新增软件工具编号：" + index);
		} catch (SQLException e) {
			log.warn("保存失败，出现异常");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
	}

}
