package com.lzcc.train.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dao.impl.GoodsTypeDAO;
import com.lzcc.train.dbhelper.ConnectionManager;
import com.lzcc.train.model.GoodsType;

/**
 * GoodsTypeService.java ��Ʒ����ҵ������
 * @author ��Ĳ
 * @see train_01->com.lzcc.train.service->GoodsTypeService.java
 * @see 2016��1��28�� ����4:05:35 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class GoodsTypeService {
	private GoodsType gt;
	private List<GoodsType> gtlist;
	private IDAO<GoodsType> dao = new GoodsTypeDAO();
	private Connection conn;

	/**
	 * ���ݱ�Ų�ѯ��Ʒ���Ͷ���
	 * @param gid
	 * @return
	 */
	public GoodsType findById(String gid) {
		try {
			conn = ConnectionManager.getConnection();
			
			gt = dao.findById(conn, Integer.parseInt(gid));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return gt;
	}
}
