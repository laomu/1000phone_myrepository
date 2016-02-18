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

	// 日志记录
	private static Logger log = Logger.getLogger(DocDAO.class);

	private DBHelper<Doc> dh = new DBHelper<Doc>();
	private IMapper<Doc> mapper = new DocMapper();
	private String sql;
	private List<Doc> list;
	private Doc doc;
	private int index;

	@Override
	public int add(Connection conn, Doc t) throws SQLException {
		log.debug("开始增加一条文档资料数据到数据库...");
		sql = "insert into doc(managerid,dtid,dname,publishtime,ddesc,path) values(?,?,?,?,?,?)";
		index =  dh.executeInsert(conn, sql, t.getManager().getId(), t.getDocType().getDtId(), t.getDname(),
				t.getPublishTime(), t.getDdesc(), t.getPath());
		log.debug("增加文档数据到数据库完成。新增文档资料编号：" + index);
		return index;
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		log.debug("开始根据编号删除一个文档资料，编号：" + id);
		sql = "delete from doc where docid = ?";
		index = dh.executeSQL(conn, sql, id);
		log.debug("删除完成，删除掉:" + index +"条记录");
		return index;
	}

	@Override
	public int update(Connection conn, Doc t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Doc findById(Connection conn, int id) throws SQLException {
		log.debug("开始根据文档资料编号查询文档数据，编号：" + id);
		sql = "select * from doc where docid = ?";
		list = dh.executeQuery(conn, sql, mapper, id);
		if (list != null && list.size() > 0) {
			log.debug("查询完成，查询到结果：" + list.get(0).getDname());
			return list.get(0);
		}
		log.debug("查询完成，没有查询到结果");
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
			log.debug("根据文档类型查询所有的文档数据——DOC_DOCTYPE");
			return this.findByType(conn, obj);
		}
		return null;
	}

	private List<Doc> findByType(Connection conn, Object... obj) throws SQLException {
		log.debug("开始根据文档类型查询所有文档数据 :" +obj[0]);
		sql = "select * from doc where dtid = ? order by publishtime desc";
		list = dh.executeQuery(conn, sql, mapper, obj);
		log.debug("查询文档数据完成，共查询到文档资料" + list.size() + "条数据");
		return list;
	}
}
