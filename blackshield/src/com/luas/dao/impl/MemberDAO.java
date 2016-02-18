package com.luas.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dbhelper.DBHelper;
import com.luas.mapper.IMapper;
import com.luas.mapper.impl.MemberMapper;
import com.luas.model.Member;
import com.luas.utils.SystemParam;

/**
 * MemberDAO.java 会员数据访问类
 * 
 * @author 老牟
 * @see blackshield->com.luas.dao.impl->MemberDAO.java
 * @see 2015年12月7日 上午10:41:14
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class MemberDAO implements IDAO<Member> {

	// 日志记录
	private static Logger log = Logger.getLogger(MemberDAO.class);

	private DBHelper<Member> dh = new DBHelper<Member>();
	private IMapper<Member> mapper = new MemberMapper();
	private String sql;
	private List<Member> list;
	private Member member;

	private int index;

	@Override
	public int add(Connection conn, Member t) throws SQLException {
		log.debug("开始增加会员数据到数据库");
		sql = "insert into member(username, password, realName, registTime, islock) values(?,?,?,?,?)";
		index =  dh.executeInsert(conn, sql, t.getUsername(), t.getPassword(), t.getRealName(), new Date(), false);
		log.debug("增加会员成功，会员编号：" + index);
		return index;
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		log.debug("根据会员编号删除会员。要删除的会员编号:" + id);
		sql = "delete from member where memberid = ?";
		index = dh.executeSQL(conn, sql, id);
		log.debug("删除完成，删除的数目：" + index + "条");
		return index;
	}

	@Override
	public int update(Connection conn, Member t) throws SQLException {
		log.debug("修改会员数据到数据库");
		log.debug("会员数据:" +"--username-"+t.getUsername()+"--realName-"+t.getRealName()+"--phone-"+t.getPhone()+
				"--headerImg-"+t.getHeaderImg()+"--email-"+ t.getEmail()+"--registtime-"+ t.getRegistTime() +"--islock-"+t.isLock() + "--id-" +t.getId());
		sql = "update member set username = ?,".concat("password = ?,").concat("realName = ?,").concat("phone = ?,")
				.concat("headerImg = ?,").concat("email = ?,").concat("registTime = ?,").concat("isLock = ? ")
				.concat(" where memberId = ?");
		index =  dh.executeSQL(conn, sql, t.getUsername(), t.getPassword(), t.getRealName(), t.getPhone(),
				t.getHeaderImg(), t.getEmail(), t.getRegistTime(), t.isLock(), t.getId());
		log.debug("修改会员数据完成，修改的数目：" + index + "条");
		return index;
	}

	@Override
	public Member findById(Connection conn, int id) throws SQLException {
		log.debug("根据会员编号查询会员，编号:" + id);
		sql = "select * from member where memberid =?";
		list = dh.executeQuery(conn, sql, mapper, id);
		if (list != null && list.size() > 0) {
			log.debug("查询到会员数据：" + list.get(0).getRealName());
			return list.get(0);
		}
		log.debug("没有查询到对应编号的会员数据");
		return null;
	}

	@Override
	public List<Member> findAll(Connection conn) throws SQLException {
		log.debug("查询所有的会员数据");
		sql = "select * from member";
		list =  dh.executeQuery(conn, sql, mapper);
		log.debug("查询完成，查询到" + list.size() + "条数据...");
		return list;
	}

	@Override
	public List<Member> findByCondition(Connection conn, int type, Object... obj) throws SQLException {
		if (type == SystemParam.MEMBER_USERNAME_PASSWORD) {
			log.debug("根据账号+ 密码两个条件查询会员");
			return this.findByUsernameAndPassword(conn, obj);
		} else if (type == SystemParam.MEMBER_USERNAME) {
			log.debug("根据账号查询会员");
			return this.findByUsername(conn, obj);
		}
		return null;
	}

	private List<Member> findByUsernameAndPassword(Connection conn, Object... obj) throws SQLException {
		log.debug("开始根据账号+密码两个条件查询会员");
		sql = "select * from member where username = ? and password = ?";
		list =  dh.executeQuery(conn, sql, mapper, obj);
		log.debug("查询完成，查询到" + list.size() + "条数据");
		return list;
	}

	private List<Member> findByUsername(Connection conn, Object... obj) throws SQLException {
		log.debug("开始根据账号查询会员数据..");
		sql = "select * from member where username = ?";
		list = dh.executeQuery(conn, sql, mapper, obj);
		log.debug("查询完成，查询到" + list.size() + "条数据");
		return list;
	}

}
