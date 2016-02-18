package com.luas.mapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * IMapper.java ���ݿ����ݼ�¼--Java����ӳ�䳬���ӿ�
 * @author ��Ĳ
 * @see blackshield->com.luas.mapper->IMapper.java
 * @see 2015��12��7�� ����10:37:58 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public interface IMapper<T> {
	
	/**
	 * �����ݼ�¼RSת����java����T�ķ���
	 * @param rs ���ݿ��в�ѯ���ļ�¼
	 * @return ����ת���Ժ�Ķ���
	 * @throws SQLException
	 */
	T rowMapper(Connection conn, ResultSet rs) throws SQLException;
}
