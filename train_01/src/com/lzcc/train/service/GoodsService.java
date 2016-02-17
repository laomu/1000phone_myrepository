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
import com.lzcc.train.utils.FindType;

/**
 * GoodsService.java ��Ʒҵ������
 * @author ��Ĳ
 * @see train_01->com.lzcc.train.service->GoodsService.java
 * @see 2016��1��28�� ����2:51:43 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see �ֻ���15294157465
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
	 * �����̵��ѯ���е���Ʒ
	 * @param sid �̵���
	 * @return
	 */
	public List<Goods> findByShop(String sid) {
		try {
			conn = ConnectionManager.getConnection();
			
			goodsList = goodsDAO.findByConndition(conn, FindType.GOODS_SHOP, Integer.parseInt(sid));
			
			// ��ѯ��Ʒ�е�ͼƬ
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
	 * ��ѯ���е���Ʒ����Ʒ����
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
	 * ��ѯ���е���Ʒ�����
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
	 * ������Ʒ
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
	 * ������Ʒ��Ų�ѯ��Ʒ
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
	 * ���ݱ��ɾ����Ʒ
	 * @param gid
	 */
	public void goodsDelete(String gid) {
		try {
			conn = ConnectionManager.getConnection();
			// ɾ�����ﳵ��������Ʒ�����ö���
			new ShopcartService().deleteByGoods(String.valueOf(gid));
			
			goods = this.findById(gid);
			
			List<GoodsImage> giList = goods.getGiList();
			
			if (giList !=null && giList.size() > 0) {			
				// ɾ����Ʒ��ͼƬ
				for (int i = 0; i < giList.size(); i++) {
					giService.goodsImageDelete(String.valueOf(giList.get(i).getGiid()));
				}
			}
			
			//ɾ����Ʒ// ����152�е��õ�ǰ��ķ��������ݿ����ӱ��ر��ˣ��������»�ȡһ��
			conn = ConnectionManager.getConnection();
			goodsDAO.delete(conn, goods.getGid());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
	}
	
}
 