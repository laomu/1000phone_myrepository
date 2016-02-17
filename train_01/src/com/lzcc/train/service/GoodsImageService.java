package com.lzcc.train.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dao.impl.GoodsImageDAO;
import com.lzcc.train.dbhelper.ConnectionManager;
import com.lzcc.train.model.GoodsImage;

/**
 * GoodsImageService.java 商品图片业务处理类
 * @author 老牟
 * @see train_01->com.lzcc.train.service->GoodsImageService.java
 * @see 2016年1月28日 下午4:54:41 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class GoodsImageService {
	private GoodsImage gi;
	private List<GoodsImage> gilist;
	private Connection conn;
	private IDAO<GoodsImage> dao = new GoodsImageDAO();
	
	
	public void saveGoodsImage(GoodsImage gi) {
		try {
			conn = ConnectionManager.getConnection();
			
			dao.add(conn, gi);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
	}
	/**
	 * 根据编号删除图片
	 * @param giid
	 */
	public void goodsImageDelete(String giid) {
		try {
			conn = ConnectionManager.getConnection();
			
			//删除商品图片
			dao.delete(conn, Integer.parseInt(giid));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
	}

}
