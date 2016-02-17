package com.lzcc.train.mapper.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lzcc.train.mapper.IMapper;
import com.lzcc.train.model.GoodsType;

/**
 * GoodsTypeMapper.java 商品类型实体类映射关系类
 * @author 老牟
 * @see train_01->com.lzcc.train.mapper.impl->GoodsTypeMapper.java
 * @see 2016年1月26日 上午10:54:14 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class GoodsTypeMapper implements IMapper<GoodsType>{

	@Override
	public GoodsType mapper(Connection conn, ResultSet rs) throws SQLException {
		GoodsType gt = new GoodsType();
		gt.setGtId(rs.getInt("gtid"));
		gt.setGtName(rs.getString("gtname"));
		return gt;
	}

}
