package com.lzcc.train.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dao.impl.ShopDAO;
import com.lzcc.train.dbhelper.ConnectionManager;
import com.lzcc.train.model.Goods;
import com.lzcc.train.model.Shop;
import com.lzcc.train.model.User;
import com.lzcc.train.utils.FindType;

/**
 * ShopService.java �̵����ҵ������
 * @author ��Ĳ
 * @see train_01->com.lzcc.train.service->ShopService.java
 * @see 2016��1��27�� ����4:03:15 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ShopService {
	private Shop shop;
	private List<Shop> slist;
	private IDAO<Shop> shopDAO = new ShopDAO();
	private Connection conn;
	private GoodsService goodsService = new GoodsService();
	
	
	/**
	 * ��ѯ��ǰ�û������̵�ķ���
	 * @param user
	 * @return
	 */
	public List<Shop> findByUser(User user) {
		try {
			conn = ConnectionManager.getConnection();
			
			slist = shopDAO.findByConndition(conn, FindType.SHOP_USER, user.getUid());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return slist;
	}

	/**
	 * ����
	 */
	public void openShop(Shop shop) {
		try {
			conn = ConnectionManager.getConnection();
			
			shopDAO.add(conn, shop);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
	}
	/**
	 * ���ݱ�Ų�ѯ�̵����
	 * @param sid
	 * @return
	 */
	public Shop findById(String sid) {
		try {
			conn = ConnectionManager.getConnection();
			
			shop = shopDAO.findById(conn, Integer.parseInt(sid));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return shop;
	}
	
	/**
	 * ɾ���̵�ķ���
	 * @param sid
	 */
	public void shopDelete(String sid) {
		try {
			conn = ConnectionManager.getConnection();
			
			// ɾ���̵��е�������Ʒ
			List<Goods> list = goodsService.findByShop(sid);
			
			if (list != null && list.size() > 0) {
				for (int i = 0; i < list.size(); i++) {
					goodsService.goodsDelete(String.valueOf(list.get(i).getGid()));
				}
			}
			
			// ɾ���̵�
			shopDAO.delete(conn, Integer.parseInt(sid));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
	}
}
