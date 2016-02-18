package com.luas.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dbhelper.DBHelper;
import com.luas.mapper.IMapper;
import com.luas.mapper.impl.DocMapper;
import com.luas.model.Doc;
import com.luas.utils.SystemParam;

public class DocDAO implements IDAO<Doc> {

	// ��־��¼
	private static Logger log = Logger.getLogger(DocDAO.class);

	private DBHelper<Doc> dh = new DBHelper<Doc>();
	private IMapper<Doc> mapper = new DocMapper();
	private String sql;
	private List<Doc> list;
	private Doc doc;
	private int index;

	@Override
	public int add(Connection conn, Doc t) throws SQLException {
		log.debug("��ʼ����һ���ĵ��������ݵ����ݿ�...");
		sql = "insert into doc(managerid,dtid,dname,publishtime,ddesc,path) values(?,?,?,?,?,?)";
		index =  dh.executeInsert(conn, sql, t.getManager().getId(), t.getDocType().getDtId(), t.getDname(),
				t.getPublishTime(), t.getDdesc(), t.getPath());
		log.debug("�����ĵ����ݵ����ݿ���ɡ������ĵ����ϱ�ţ�" + index);
		return index;
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		log.debug("��ʼ���ݱ��ɾ��һ���ĵ����ϣ���ţ�" + id);
		sql = "delete from doc where docid = ?";
		index = dh.executeSQL(conn, sql, id);
		log.debug("ɾ����ɣ�ɾ����:" + index +"����¼");
		return index;
	}

	@Override
	public int update(Connection conn, Doc t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Doc findById(Connection conn, int id) throws SQLException {
		log.debug("��ʼ�����ĵ����ϱ�Ų�ѯ�ĵ����ݣ���ţ�" + id);
		sql = "select * from doc where docid = ?";
		list = dh.executeQuery(conn, sql, mapper, id);
		if (list != null && list.size() > 0) {
			log.debug("��ѯ��ɣ���ѯ�������" + list.get(0).getDname());
			return list.get(0);
		}
		log.debug("��ѯ��ɣ�û�в�ѯ�����");
		return null;
	}

	@Override
	public List<Doc> findAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Doc> findByCondition(Connection conn, int type, Object... obj) throws SQLException {
		if (type == SystemParam.DOC_DOCTYPE) {
			log.debug("�����ĵ����Ͳ�ѯ���е��ĵ����ݡ���DOC_DOCTYPE");
			return this.findByType(conn, obj);
		}
		return null;
	}

	private List<Doc> findByType(Connection conn, Object... obj) throws SQLException {
		log.debug("��ʼ�����ĵ����Ͳ�ѯ�����ĵ����� :" +obj[0]);
		sql = "select * from doc where dtid = ? order by publishtime desc";
		list = dh.executeQuery(conn, sql, mapper, obj);
		log.debug("��ѯ�ĵ�������ɣ�����ѯ���ĵ�����" + list.size() + "������");
		return list;
	}
}
