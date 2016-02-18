package com.luas.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dbhelper.DBHelper;
import com.luas.mapper.IMapper;
import com.luas.mapper.impl.QuestionsMapper;
import com.luas.model.Questions;
/**
 * QuestionsDAO.java 用户建议问题数据访问对象类
 * @author 老牟
 * @see blackshield->com.luas.dao->QuestionsDAO.java
 * @see 2015年12月23日 下午1:07:55 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class QuestionsDAO implements IDAO<Questions> {

	private static Logger log = Logger.getLogger(QuestionsDAO.class);
	private String sql;
	private List<Questions> list;
	private Questions questions;
	private DBHelper<Questions> dh = new DBHelper<Questions>();
	private int index; 
	private IMapper<Questions> mapper = new QuestionsMapper();
	
	@Override
	public int add(Connection conn, Questions t) throws SQLException {
		log.debug("开始保存建议问题数据到数据库");
		sql = "insert into questions(qtUsername, quEmail, qtDesc, qtDeal,qtTime) values(?,?,?,?,?)";
		index = dh.executeInsert(conn, sql, t.getQtUsername(),t.getQtEmail(), t.getQtDesc(), false, t.getQtTime());
		log.debug("建议问题数据保存完成，新增问题编号：" + index);
		return index;
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		sql = "delete from questions where qtid = ?";
		return dh.executeSQL(conn, sql, id);
	}

	@Override
	public int update(Connection conn, Questions t) throws SQLException {
		sql = "update questions set qtusername = ?,"
				+ "quEmail = ?,"
				+ "qtDesc = ?,"
				+ "qtDeal = ?,"
				+ "qttime = ? where qtId = ?";
		return dh.executeSQL(conn, sql, t.getQtUsername(),
				t.getQtEmail(),t.getQtDesc(), t.isQtDeal(), t.getQtTime(),
				t.getQtId());
	}

	@Override
	public Questions findById(Connection conn, int id) throws SQLException {
		log.debug("开始根据编号查询问题记录，编号:" + id);
		sql = "select * from questions where qtid = ?";
		list = dh.executeQuery(conn, sql, mapper, id);
		if (list != null && list.size() > 0) {
			log.debug("查询完成，查询到的记录：" + list.get(0));
			return list.get(0);
		}
		log.debug("没有查询到记录...");
		return null;
	}

	@Override
	public List<Questions> findAll(Connection conn) throws SQLException {
		log.debug("开始查询的所有的问题列表");
		sql = "select * from questions";
		list = dh.executeQuery(conn, sql, mapper);
		log.debug("查询完成，查询到" + list.size() + "条记录");
		return list;
	}

	@Override
	public List<Questions> findByCondition(Connection conn, int type, Object... obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
