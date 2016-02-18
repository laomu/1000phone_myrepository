package com.luas.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Logger;

import com.luas.mapper.IMapper;
import com.luas.model.Questions;
/**
 * QuestionsMapper.java 联系我们建议问题映射关系类 
 * @author 老牟
 * @see blackshield->com.luas.mapper.impl->QuestionsMapper.java
 * @see 2015年12月23日 下午7:55:41 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class QuestionsMapper implements IMapper<Questions> {

	private static Logger log = Logger.getLogger(QuestionsMapper.class);
	
	@Override
	public Questions rowMapper(Connection conn, ResultSet rs) throws SQLException {
		log.debug("开始封装对象");
		Questions questions = new Questions();
		questions.setQtId(rs.getInt("qtid"));
		questions.setQtUsername(rs.getString("qtUsername"));
		questions.setQtEmail(rs.getString("quEmail"));
		questions.setQtDesc(rs.getString("qtDesc"));
		questions.setQtDeal(rs.getBoolean("qtDeal"));
		questions.setQtTime(rs.getDate("qtTime"));
		log.debug("封装对象完成--" + questions.getQtId());
		return questions;
	}

}
