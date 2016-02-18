package com.luas.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Logger;

import com.luas.mapper.IMapper;
import com.luas.model.Questions;
/**
 * QuestionsMapper.java ��ϵ���ǽ�������ӳ���ϵ�� 
 * @author ��Ĳ
 * @see blackshield->com.luas.mapper.impl->QuestionsMapper.java
 * @see 2015��12��23�� ����7:55:41 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class QuestionsMapper implements IMapper<Questions> {

	private static Logger log = Logger.getLogger(QuestionsMapper.class);
	
	@Override
	public Questions rowMapper(Connection conn, ResultSet rs) throws SQLException {
		log.debug("��ʼ��װ����");
		Questions questions = new Questions();
		questions.setQtId(rs.getInt("qtid"));
		questions.setQtUsername(rs.getString("qtUsername"));
		questions.setQtEmail(rs.getString("quEmail"));
		questions.setQtDesc(rs.getString("qtDesc"));
		questions.setQtDeal(rs.getBoolean("qtDeal"));
		questions.setQtTime(rs.getDate("qtTime"));
		log.debug("��װ�������--" + questions.getQtId());
		return questions;
	}

}
