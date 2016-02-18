package com.luas.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dao.impl.DocTypeDAO;
import com.luas.dbhelper.ConnectionManager;
import com.luas.model.DocType;

/**
 * DocTypeService.java 文档类型服务类
 * 
 * @author 老牟
 * @see blackshield->com.luas.service->DocTypeService.java
 * @see 2015年12月10日 上午11:31:28
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class DocTypeService {

	// 日志记录
	private Logger log = Logger.getLogger(this.getClass());

	private IDAO<DocType> docTypeDAO = new DocTypeDAO();
	private List<DocType> list;
	private DocType docType;
	private Connection conn;

	/**
	 * 查询所有的文档类型
	 * 
	 * @return
	 */
	public List<DocType> findAll() {
		log.info("查询所有的文档类型数据");
		try {
			conn = ConnectionManager.getConnection();

			list = docTypeDAO.findAll(conn);
			log.info("查询完成，共查询到" + list.size() + "条数据。");
		} catch (SQLException e) {
			log.info("查询失败。");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return list;
	}

	/**
	 * 根据文档编号查询文档类型
	 * 
	 * @param typeId
	 * @return
	 */
	public DocType findById(String typeId) {
		log.info("根据文档类型编号查询具体的文档类型.");
		try {
			int tid = Integer.parseInt(typeId);// 将字符串的id转换成整数的id
			conn = ConnectionManager.getConnection();// 获取连接

			docType = docTypeDAO.findById(conn, tid);
			log.info("查询完成，查询到数据：" + docType.getDeName());
		} catch (NumberFormatException e) {
			log.warn("输入的ID编号有误，查询失败");
			e.printStackTrace();
		} catch (SQLException e) {
			log.warn("查询失败");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return docType;
	}
}
