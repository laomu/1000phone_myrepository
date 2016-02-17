package com.lzcc.train.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dao.impl.AddressDAO;
import com.lzcc.train.dbhelper.ConnectionManager;
import com.lzcc.train.model.Address;
import com.lzcc.train.model.User;
import com.lzcc.train.utils.FindType;

/**
 * AddressService.java 地址业务处理类
 * @author 老牟
 * @see train_01->com.lzcc.train.service->AddressService.java
 * @see 2016年1月26日 上午11:02:51 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class AddressService {
	private Address address;
	private List<Address> list;
	private IDAO<Address> dao = new AddressDAO();
	private Connection conn;
	
	/**
	 * 查询当前用户所有地址信息
	 * @param user 要查询地址的用户
	 * @return 返回查询到的所有地址集合
	 */
	public List<Address> findAllByUser(User user) {
		try {
			// 获取数据库连接
			conn = ConnectionManager.getConnection();
			// 根据用户编号查询所有所属地址
			list = dao.findByConndition(conn, FindType.ADDRESS_USER, user.getUid());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库连接
			ConnectionManager.free(conn);
		}
		return list;
	}
	
	/**
	 * 添加地址
	 * @param address
	 */
	public void saveAddress(Address address) {
		try {
			// 获取数据库连接
			conn = ConnectionManager.getConnection();
			
			// 判断是否添加的是默认收货地址
			updateToUnDefault(address);
			// 添加用户地址到数据库
			dao.add(conn, address);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库连接
			ConnectionManager.free(conn);
		}
	}
	/*
	 * 修改地址为非默认
	 */
	private void updateToUnDefault(Address address) {
		try {
			// 判断是否默认收货地址，如果是默认，将数据库中原有的默认地址取消默认
			if(address.isStatus()) {
				// 查询数据库中的默认收货地址
				list = dao.findByConndition(conn, FindType.ADDRESS_DEFAULT, true);
				// 遍历集合中所有对象，取消默认收货地址
				for (int i = 0; i < list.size(); i++) {
					// 获取当前遍历地址对象
					Address addr = list.get(i);
					// 修改为非默认
					addr.setStatus(false);
					// 更新信息到数据库
					dao.update(conn, addr);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据编号删除一个地址
	 * @param address
	 */
	public void deleteAddr (String aid) {
		try {
			// 获取数据库连接
			conn = ConnectionManager.getConnection();
			// 删除对应的地址
			dao.delete(conn, Integer.parseInt(aid));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库连接
			ConnectionManager.free(conn);
		}
	}
	
	/**
	 * 根据编号查询一个地址对象
	 * @param aid
	 * @return
	 */
	public Address findById(String aid) {
		try {
			// 获取数据库连接
			conn = ConnectionManager.getConnection();
			// 根据编号查询一个地址对象
			address = dao.findById(conn, Integer.parseInt(aid));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库连接
			ConnectionManager.free(conn);
		}
		return address;
	}
	
	/**
	 * 修改地址信息
	 * @param addr
	 */
	public void updateAddr(Address addr) {
		try {
			// 获取数据库连接
			conn = ConnectionManager.getConnection();
			
			// 判断是否添加的是默认收货地址
			updateToUnDefault(address);
			// 添加用户地址到数据库
			dao.update(conn, address);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库连接
			ConnectionManager.free(conn);
		}
	}
}
