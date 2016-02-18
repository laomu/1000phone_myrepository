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
 * MemberDAO.java ��Ա���ݷ�����
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.dao.impl->MemberDAO.java
 * @see 2015��12��7�� ����10:41:14
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class MemberDAO implements IDAO<Member> {

	// ��־��¼
	private static Logger log = Logger.getLogger(MemberDAO.class);

	private DBHelper<Member> dh = new DBHelper<Member>();
	private IMapper<Member> mapper = new MemberMapper();
	private String sql;
	private List<Member> list;
	private Member member;

	private int index;

	@Override
	public int add(Connection conn, Member t) throws SQLException {
		log.debug("��ʼ���ӻ�Ա���ݵ����ݿ�");
		sql = "insert into member(username, password, realName, registTime, islock) values(?,?,?,?,?)";
		index =  dh.executeInsert(conn, sql, t.getUsername(), t.getPassword(), t.getRealName(), new Date(), false);
		log.debug("���ӻ�Ա�ɹ�����Ա��ţ�" + index);
		return index;
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		log.debug("���ݻ�Ա���ɾ����Ա��Ҫɾ���Ļ�Ա���:" + id);
		sql = "delete from member where memberid = ?";
		index = dh.executeSQL(conn, sql, id);
		log.debug("ɾ����ɣ�ɾ������Ŀ��" + index + "��");
		return index;
	}

	@Override
	public int update(Connection conn, Member t) throws SQLException {
		log.debug("�޸Ļ�Ա���ݵ����ݿ�");
		log.debug("��Ա����:" +"--username-"+t.getUsername()+"--realName-"+t.getRealName()+"--phone-"+t.getPhone()+
				"--headerImg-"+t.getHeaderImg()+"--email-"+ t.getEmail()+"--registtime-"+ t.getRegistTime() +"--islock-"+t.isLock() + "--id-" +t.getId());
		sql = "update member set username = ?,".concat("password = ?,").concat("realName = ?,").concat("phone = ?,")
				.concat("headerImg = ?,").concat("email = ?,").concat("registTime = ?,").concat("isLock = ? ")
				.concat(" where memberId = ?");
		index =  dh.executeSQL(conn, sql, t.getUsername(), t.getPassword(), t.getRealName(), t.getPhone(),
				t.getHeaderImg(), t.getEmail(), t.getRegistTime(), t.isLock(), t.getId());
		log.debug("�޸Ļ�Ա������ɣ��޸ĵ���Ŀ��" + index + "��");
		return index;
	}

	@Override
	public Member findById(Connection conn, int id) throws SQLException {
		log.debug("���ݻ�Ա��Ų�ѯ��Ա�����:" + id);
		sql = "select * from member where memberid =?";
		list = dh.executeQuery(conn, sql, mapper, id);
		if (list != null && list.size() > 0) {
			log.debug("��ѯ����Ա���ݣ�" + list.get(0).getRealName());
			return list.get(0);
		}
		log.debug("û�в�ѯ����Ӧ��ŵĻ�Ա����");
		return null;
	}

	@Override
	public List<Member> findAll(Connection conn) throws SQLException {
		log.debug("��ѯ���еĻ�Ա����");
		sql = "select * from member";
		list =  dh.executeQuery(conn, sql, mapper);
		log.debug("��ѯ��ɣ���ѯ��" + list.size() + "������...");
		return list;
	}

	@Override
	public List<Member> findByCondition(Connection conn, int type, Object... obj) throws SQLException {
		if (type == SystemParam.MEMBER_USERNAME_PASSWORD) {
			log.debug("�����˺�+ ��������������ѯ��Ա");
			return this.findByUsernameAndPassword(conn, obj);
		} else if (type == SystemParam.MEMBER_USERNAME) {
			log.debug("�����˺Ų�ѯ��Ա");
			return this.findByUsername(conn, obj);
		}
		return null;
	}

	private List<Member> findByUsernameAndPassword(Connection conn, Object... obj) throws SQLException {
		log.debug("��ʼ�����˺�+��������������ѯ��Ա");
		sql = "select * from member where username = ? and password = ?";
		list =  dh.executeQuery(conn, sql, mapper, obj);
		log.debug("��ѯ��ɣ���ѯ��" + list.size() + "������");
		return list;
	}

	private List<Member> findByUsername(Connection conn, Object... obj) throws SQLException {
		log.debug("��ʼ�����˺Ų�ѯ��Ա����..");
		sql = "select * from member where username = ?";
		list = dh.executeQuery(conn, sql, mapper, obj);
		log.debug("��ѯ��ɣ���ѯ��" + list.size() + "������");
		return list;
	}

}
