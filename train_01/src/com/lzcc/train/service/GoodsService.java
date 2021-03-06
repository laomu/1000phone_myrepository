package com.lzcc.train.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dao.impl.ActivityTypeDAO;
import com.lzcc.train.dao.impl.GoodsDAO;
import com.lzcc.train.dao.impl.GoodsImageDAO;
import com.lzcc.train.dao.impl.GoodsTypeDAO;
import com.lzcc.train.dbhelper.ConnectionManager;
import com.lzcc.train.model.ActivityType;
import com.lzcc.train.model.Goods;
import com.lzcc.train.model.GoodsImage;
import com.lzcc.train.model.GoodsType;
import com.lzcc.train.utils.DeleteType;
import com.lzcc.train.utils.FindType;

/**
 * GoodsService.java 商品业务处理类
 * @author 老牟
 * @see train_01->com.lzcc.train.service->GoodsService.java
 * @see 2016年1月28日 下午2:51:43 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class GoodsService {
	
	private Goods goods;
	private List<Goods> goodsList;
	private Connection conn;
	private IDAO<Goods> goodsDAO = new GoodsDAO();
	private IDAO<GoodsType> gtDAO = new GoodsTypeDAO();
	private IDAO<ActivityType> atDAO  = new ActivityTypeDAO();
	private IDAO<GoodsImage> giDAO = new GoodsImageDAO();
	private List<GoodsImage> gilist;
	private GoodsImageService giService = new GoodsImageService();
	
	/**
	 * 根据商店查询所有的商品
	 * @param sid 商店编号
	 * @return
	 */
	public List<Goods> findByShop(String sid) {
		try {
			conn = ConnectionManager.getConnection();
			
			goodsList = goodsDAO.findByConndition(conn, FindType.GOODS_SHOP, Integer.parseInt(sid));
			
			// 查询商品中的图片
			for(int i = 0; i < goodsList.size(); i++) {
				goods = goodsList.get(i);
				gilist = giDAO.findByConndition(conn, FindType.GOODSIMAGE_GOODS, goods.getGid());
				goods.setGiList(gilist);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return goodsList;
	}
	
	/**
	 * 查询所有的商品的商品类型
	 * @return
	 */
	public List<GoodsType> findGoodsType() {
		try {
			conn = ConnectionManager.getConnection();
			
			List<GoodsType> list =  gtDAO.findAll(conn);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return null;
	}
	
	/**
	 * 查询所有的商品活动类型
	 * @return
	 */
	public List<ActivityType> findActivityType() {
		try {
			conn = ConnectionManager.getConnection();
			
			return atDAO.findAll(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return null;
	}
	/**
	 * 保存商品
	 * @param goods
	 * @return
	 */
	public int saveGoods(Goods goods) {
		try {
			conn = ConnectionManager.getConnection();
			
			return goodsDAO.add(conn, goods);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return -1;
	}
	
	/**
	 * 根据商品编号查询商品
	 * @param gid
	 * @return
	 */
	public Goods findById(String gid) {
		try {
			conn = ConnectionManager.getConnection();
			
			goods = goodsDAO.findById(conn, Integer.parseInt(gid));
			
			gilist = giDAO.findByConndition(conn, FindType.GOODSIMAGE_GOODS, goods.getGid());
			
			goods.setGiList(gilist);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return goods;
	}
	
	/**
	 * 根据编号删除商品
	 * @param gid
	 */
	public void goodsDelete(String gid) {
		try {
			goods = this.findById(gid);

			conn = ConnectionManager.getConnection();
			// 删除购物车中所有商品的引用对象
			new ShopcartService().deleteByGoods(String.valueOf(gid));
			
			
			List<GoodsImage> giList = goods.getGiList();
			
			if (giList !=null && giList.size() > 0) {			
				// 删除商品的图片
				for (int i = 0; i < giList.size(); i++) {
					giService.goodsImageDelete(String.valueOf(giList.get(i).getGiid()));
				}
			}
			
			goodsDAO.delete(conn, goods.getGid());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
	}
	
	/**
	 * 根据商店编号，删除商店中的所有商品
	 * @param sid
	 */
	@SuppressWarnings("rawtypes")
	public void deleteByShop(String sid) {
		// 删除购物对象和商品图片
		goodsList = this.findByShop(sid);
		for (int i = 0; i < goodsList.size(); i++) {
			String goodsId = String.valueOf(goodsList.get(i).getGid());
			new ShopcartService().deleteByGoods(goodsId);// 删除购物对象
			giService.goodsImageDelete(goodsId);// 删除商品图片
		}
		
		// 删除商品
		new BaseService(){

			@Override
			public Object service(Connection conn) throws SQLException {
				goodsDAO.deleteByCondition(conn, DeleteType.GOODS_SHOP, Integer.parseInt(sid));
				return null; 
			}}.doService();
	}
	
	/**
	 * 搜索商品
	 * @param keyword 搜索关键字
	 * @return
	 */
	public List<Goods> searchGoods(String keyword) {
		return new BaseService<List<Goods>>(){

			@Override
			public List<Goods> service(Connection conn) throws SQLException {
				
				goodsList = goodsDAO.findByConndition(conn, FindType.GOODS_SEARCH, keyword);
				
				return goodsList;
			}}.doService();
	}
	
}
 