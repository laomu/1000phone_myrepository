package com.lzcc.train.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.lzcc.train.dao.IDAO;
import com.lzcc.train.dbhelper.DBHelper;
import com.lzcc.train.mapper.IMapper;
import com.lzcc.train.mapper.impl.AddressMapper;
import com.lzcc.train.model.Address;
import com.lzcc.train.utils.DeleteType;
import com.lzcc.train.utils.FindType;

/**
 * AddressDAO.java 地址数据访问对象类
 * @author 老牟
 * @see train_01->com.lzcc.train.dao.impl->AddressDAO.java
 * @see 2016年1月26日 上午10:57:30 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class AddressDAO implements IDAO<Address> { 
	private String sql;
	private Address address;
	private List<Address> list;
	private DBHelper<Address> dh = new DBHelper<Address>();
	private IMapper<Address> mapper = new AddressMapper();

	@Override
	public int add(Connection conn, Address t) throws SQLException {
		sql = "insert into address(uid, anation, province, city, country, street, adesc, status, contact, phone)"
				+ "values(?,?,?,?,?,?,?,?,?,?)";
		return dh.executeInsert(conn, sql, t.getUser().getUid(),
											t.getAnation(),
											t.getProvince(),
											t.getCity(),
											t.getCountry(),
											t.getStreet(),
											t.getAdesc(),
											t.isStatus(),
											t.getContact(),
											t.getPhone());
	}

	@Override
	public int delete(Connection conn, int id) throws SQLException {
		sql = "delete from address where aid = ?";
		return dh.executeSQL(conn, sql, id);
	}

	@Override
	public int update(Connection conn, Address t) throws SQLException {
		sql = "update address set uid = ?,"
				+ "anation = ?,"
				+ "province = ?,"
				+ "city = ?,"
				+ "country = ?,"
				+ "street = ?,"
				+ "adesc = ?,"
				+ "status = ?,"
				+ "contact = ?,"
				+ "phone = ? where aid = ?";
		return dh.executeSQL(conn, sql, t.getUser().getUid(),
										t.getAnation(),
										t.getProvince(),
										t.getCity(),
										t.getCountry(),
										t.getStreet(),
										t.getAdesc(),
										t.isStatus(),
										t.getContact(),
										t.getPhone(),
										t.getAid());
	}

	@Override
	public Address findById(Connection conn, int id) throws SQLException {
		sql = "select * from address where aid = ?";
		list = dh.executeQuery(conn, mapper, sql, id);
		if (list != null && list.size() > 0) {
			address = list.get(0);
		}
		return address;
	}

	@Override
	public List<Address> findAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> findByConndition(Connection conn, FindType type, Object... objs) throws SQLException {
		if (type == FindType.ADDRESS_USER) {
			return this.findByUser(conn, objs);
		} else if (type == FindType.ADDRESS_DEFAULT) {
			return this.findByDefault(conn, objs);
		}
		return null;
	}
	
	/*
	 * 根据用户编号查询所有的收货地址
	 */
	private List<Address> findByUser(Connection conn, Object... objs) throws SQLException {
		sql = "select * from address where uid = ?";
		return dh.executeQuery(conn, mapper, sql, objs);
	}
	/*
	 * 查询默认收货地址
	 */
	private List<Address> findByDefault(Connection conn, Object... objs) throws SQLException {
		sql = "select * from address where status = ?";
		return dh.executeQuery(conn, mapper, sql, objs);
	}

	@Override
	public int deleteByCondition(Connection conn, DeleteType type, Object... objs) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
