package com.luas.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dao.impl.QuestionsDAO;
import com.luas.dbhelper.ConnectionManager;
import com.luas.model.Questions;

/**
 * QuestionsService.java 用户发送联系我们信息业务处理类
 * @author 老牟
 * @see blackshield->com.luas.service->QuestionsService.java
 * @see 2015年12月23日 下午1:05:38 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class QuestionsService {

	private static Logger log = Logger.getLogger(QuestionsService.class);
	
	private Connection conn;
	
	private IDAO<Questions> dao = new QuestionsDAO();
	
	private List<Questions> list;
	
	private Questions questions;
	/**
	 * 保存用户信息
	 * @param questions
	 */
	public void saveQuestions(Questions questions) {
		log.info("开始保存用户发送的建议问题...");
		try {
			conn = ConnectionManager.getConnection();
			dao.add(conn, questions);
			log.info("用户发送的建议问题保存完成...");
		} catch (SQLException e) {
			log.warn("用户发送建议问题保存错误，出现异常。");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
	}
	
	/**
	 * 查询用户发送的所有建议问题
	 * @return
	 */
	public List<Questions> findAll() {
		log.info("开始查询所有的用户发送的建议问题");
		try {
			conn = ConnectionManager.getConnection();
			list = dao.findAll(conn);
			log.info("查询完成，共查询到" + list.size() + "条记录");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return list;
	}
	
	/**
	 * 标记解决问题
	 * @param id 要解决问题的id编号
	 */
	public void dealQuestions(String id) {
		log.info("开始标记解决问题，标记编号:" + id);
		try {
			conn = ConnectionManager.getConnection();
			// 查询编号对应的问题
			questions = dao.findById(conn, Integer.parseInt(id));
			// 修改解决状态
			questions.setQtDeal(true);
			// 更新到数据库
			dao.update(conn, questions);
			log.info("标记完成，问题解决。");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
	}
	
	/**
	 * 删除问题数据记录
	 * @param id
	 */
	public void deleteQuestions(String id) {
		log.info("开始删除问题，删除的问题编号:" + id);
		try {
			conn = ConnectionManager.getConnection();
			// 删除编号对应的问题
			dao.delete(conn, Integer.parseInt(id));
			log.info("删除完成");
		} catch (SQLException e) {
			log.warn("删除失败，出现异常...");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
	}
}
