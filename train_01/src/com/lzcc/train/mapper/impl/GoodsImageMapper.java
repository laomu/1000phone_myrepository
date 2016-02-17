package com.lzcc.train.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dao.impl.GoodsDAO;
import com.lzcc.train.mapper.IMapper;
import com.lzcc.train.model.Goods;
import com.lzcc.train.model.GoodsImage;

/**
 * GoodsImageMapper.java ��ƷͼƬʵ����ӳ���ϵ��
 * @author ��Ĳ
 * @see train_01->com.lzcc.train.mapper.impl->GoodsImageMapper.java
 * @see 2016��1��26�� ����10:53:39 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class GoodsImageMapper implements IMapper<GoodsImage>{
	private IDAO<Goods> goodsDAO  = new GoodsDAO();
	
	@Override
	public GoodsImage mapper(Connection conn, ResultSet rs) throws SQLException {
		GoodsImage gi = new GoodsImage();
		gi.setGiid(rs.getInt("giid"));
		gi.setGoods(goodsDAO.findById(conn, rs.getInt("gid")));
		gi.setPath(rs.getString("path"));
		return gi;
	}

}
