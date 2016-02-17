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
 * ShopcartService.java 购物车服务处理类
 * @author 老牟
 * @see train_01->com.lzcc.train.service->ShopcartService.java
 * @see 2016年2月16日 下午2:51:58 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ShopcartService {
	private IDAO<Shopcart> dao = new ShopcartDAO();
	private List<Shopcart> sclist;
	private Shopcart sc;
	/**
	 * 添加购物对象到购物车中
	 * @param shopcart
	 */
	@SuppressWarnings("rawtypes")
	public void addToCart(Shopcart shopcart) {
		new BaseService(){

			@Override
			public Object service(Connection conn) throws SQLException {
				// 1.查询当前购物对象是否已经存在
				sclist = dao.findByConndition(conn, FindType.SHOPCART_USER_GOODS, shopcart.getUser().getUid(),shopcart.getGoods().getGid());
				// 2.判断是否存在
				if (sclist != null && sclist.size() > 0) {
					// 2.1.如果存在，更新添加时间、购买数量、小计价格,更新到数据库
					sc = sclist.get(0);
					sc.setAddTime(new Date());
					sc.setShoppingCount(sc.getShoppingCount() + shopcart.getShoppingCount());
					sc.setSubTotal(sc.getSubTotal() + (shopcart.getGoods().getPrice() * shopcart.getShoppingCount()));
					dao.update(conn, sc);
				} else {
					// 2.2.如果不存在，添加购物对象到购物车中
					dao.add(conn, shopcart);
				}
				return null;
			}}.doService();
	}
	
	
	/**
	 * 查询当前用户所有的购物对象
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
	 * 根据商品编号，删除一个购物对象
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
