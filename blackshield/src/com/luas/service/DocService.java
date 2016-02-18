package com.luas.service;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dao.impl.DocDAO;
import com.luas.dbhelper.ConnectionManager;
import com.luas.model.Doc;
import com.luas.model.DocType;
import com.luas.utils.SystemParam;

/**
 * DocService.java 文档对象处理类
 * 
 * @author 老牟
 * @see blackshield->com.luas.service->DocService.java
 * @see 2015年12月10日 下午3:03:24
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class DocService {

	// 日志记录
	private Logger log = Logger.getLogger(this.getClass());

	private IDAO<Doc> docDAO = new DocDAO();
	private Connection conn;
	private List<Doc> list;
	private Doc doc;

	/**
	 * 保存一个文档对象的业务处理类
	 * 
	 * @param doc
	 */
	public void save(Doc doc) {
		try {
			conn = ConnectionManager.getConnection();
			docDAO.add(conn, doc);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
	}

	/**
	 * 根据文档类型，查询该类型下所有的文档
	 * 
	 * @param type
	 *            文档类型
	 * @return 返回查询到的文档集合
	 */
	public List<Doc> findByType(DocType type) {
		try {
			conn = ConnectionManager.getConnection();

			return docDAO.findByCondition(conn, SystemParam.DOC_DOCTYPE, type.getDtId());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return null;
	}
	
	/**
	 * 根据编号删除一个文档资料
	 * @param id 要删除的文档资料编号
	 */
	public Doc deleteDoc(String id) {
		log.info("开始删除文档资料，文档编号:" + id);
		try {
			conn = ConnectionManager.getConnection();
			
			// 查询要删除的文档
			doc = docDAO.findById(conn, Integer.parseInt(id));
			if(doc == null) {
				log.info("要删除的文档资料不存在");
				return null;
			}
			
			// 删除数据库中的记录
			docDAO.delete(conn, Integer.parseInt(id));
			
			log.info("文档资料删除完成");
		} catch (SQLException e) {
			log.warn("文档资料删除失败，出现异常...");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return doc;
	}
}
