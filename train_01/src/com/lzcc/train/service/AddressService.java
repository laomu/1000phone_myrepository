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
 * AddressService.java ��ַҵ������
 * @author ��Ĳ
 * @see train_01->com.lzcc.train.service->AddressService.java
 * @see 2016��1��26�� ����11:02:51 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class AddressService {
	private Address address;
	private List<Address> list;
	private IDAO<Address> dao = new AddressDAO();
	private Connection conn;
	
	/**
	 * ��ѯ��ǰ�û����е�ַ��Ϣ
	 * @param user Ҫ��ѯ��ַ���û�
	 * @return ���ز�ѯ�������е�ַ����
	 */
	public List<Address> findAllByUser(User user) {
		try {
			// ��ȡ���ݿ�����
			conn = ConnectionManager.getConnection();
			// �����û���Ų�ѯ����������ַ
			list = dao.findByConndition(conn, FindType.ADDRESS_USER, user.getUid());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ر����ݿ�����
			ConnectionManager.free(conn);
		}
		return list;
	}
	
	/**
	 * ��ӵ�ַ
	 * @param address
	 */
	public void saveAddress(Address address) {
		try {
			// ��ȡ���ݿ�����
			conn = ConnectionManager.getConnection();
			
			// �ж��Ƿ���ӵ���Ĭ���ջ���ַ
			updateToUnDefault(address);
			// ����û���ַ�����ݿ�
			dao.add(conn, address);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ر����ݿ�����
			ConnectionManager.free(conn);
		}
	}
	/*
	 * �޸ĵ�ַΪ��Ĭ��
	 */
	private void updateToUnDefault(Address address) {
		try {
			// �ж��Ƿ�Ĭ���ջ���ַ�������Ĭ�ϣ������ݿ���ԭ�е�Ĭ�ϵ�ַȡ��Ĭ��
			if(address.isStatus()) {
				// ��ѯ���ݿ��е�Ĭ���ջ���ַ
				list = dao.findByConndition(conn, FindType.ADDRESS_DEFAULT, true);
				// �������������ж���ȡ��Ĭ���ջ���ַ
				for (int i = 0; i < list.size(); i++) {
					// ��ȡ��ǰ������ַ����
					Address addr = list.get(i);
					// �޸�Ϊ��Ĭ��
					addr.setStatus(false);
					// ������Ϣ�����ݿ�
					dao.update(conn, addr);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ���ݱ��ɾ��һ����ַ
	 * @param address
	 */
	public void deleteAddr (String aid) {
		try {
			// ��ȡ���ݿ�����
			conn = ConnectionManager.getConnection();
			// ɾ����Ӧ�ĵ�ַ
			dao.delete(conn, Integer.parseInt(aid));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ر����ݿ�����
			ConnectionManager.free(conn);
		}
	}
	
	/**
	 * ���ݱ�Ų�ѯһ����ַ����
	 * @param aid
	 * @return
	 */
	public Address findById(String aid) {
		try {
			// ��ȡ���ݿ�����
			conn = ConnectionManager.getConnection();
			// ���ݱ�Ų�ѯһ����ַ����
			address = dao.findById(conn, Integer.parseInt(aid));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ر����ݿ�����
			ConnectionManager.free(conn);
		}
		return address;
	}
	
	/**
	 * �޸ĵ�ַ��Ϣ
	 * @param addr
	 */
	public void updateAddr(Address addr) {
		try {
			// ��ȡ���ݿ�����
			conn = ConnectionManager.getConnection();
			
			// �ж��Ƿ���ӵ���Ĭ���ջ���ַ
			updateToUnDefault(address);
			// ����û���ַ�����ݿ�
			dao.update(conn, address);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// �ر����ݿ�����
			ConnectionManager.free(conn);
		}
	}
}
