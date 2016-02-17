package com.lzcc.train.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dao.impl.ShopcartDAO;
import com.lzcc.train.model.Shopcart;
import com.lzcc.train.model.User;
import com.lzcc.train.utils.DeleteType;
import com.lzcc.train.utils.FindType;

/**
 * ShopcartService.java ���ﳵ��������
 * @author ��Ĳ
 * @see train_01->com.lzcc.train.service->ShopcartService.java
 * @see 2016��2��16�� ����2:51:58 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ShopcartService {
	private IDAO<Shopcart> dao = new ShopcartDAO();
	private List<Shopcart> sclist;
	private Shopcart sc;
	/**
	 * ��ӹ�����󵽹��ﳵ��
	 * @param shopcart
	 */
	@SuppressWarnings("rawtypes")
	public void addToCart(Shopcart shopcart) {
		new BaseService(){

			@Override
			public Object service(Connection conn) throws SQLException {
				// 1.��ѯ��ǰ��������Ƿ��Ѿ�����
				sclist = dao.findByConndition(conn, FindType.SHOPCART_USER_GOODS, shopcart.getUser().getUid(),shopcart.getGoods().getGid());
				// 2.�ж��Ƿ����
				if (sclist != null && sclist.size() > 0) {
					// 2.1.������ڣ��������ʱ�䡢����������С�Ƽ۸�,���µ����ݿ�
					sc = sclist.get(0);
					sc.setAddTime(new Date());
					sc.setShoppingCount(sc.getShoppingCount() + shopcart.getShoppingCount());
					sc.setSubTotal(sc.getSubTotal() + (shopcart.getGoods().getPrice() * shopcart.getShoppingCount()));
					dao.update(conn, sc);
				} else {
					// 2.2.��������ڣ���ӹ�����󵽹��ﳵ��
					dao.add(conn, shopcart);
				}
				return null;
			}}.doService();
	}
	
	
	/**
	 * ��ѯ��ǰ�û����еĹ������
	 * @param user
	 * @return
	 */
	public List<Shopcart> findAllByUser(User user) {
		return new BaseService<List<Shopcart>>() {

			@Override
			public List<Shopcart> service(Connection conn) throws SQLException {
				return dao.findByConndition(conn, FindType.SHOPCART_USER,user.getUid());
			}}.doService();
	}
	
	/**
	 * ������Ʒ��ţ�ɾ��һ���������
	 * @param gid
	 */
	@SuppressWarnings("rawtypes")
	public void deleteByGoods(String gid) {
		new BaseService(){

			@Override
			public Object service(Connection conn) throws SQLException {
				dao.deleteByCondition(conn, DeleteType.SHOPCART_GOODS, Integer.parseInt(gid));
				return null;
			}}.doService();
	}
}
