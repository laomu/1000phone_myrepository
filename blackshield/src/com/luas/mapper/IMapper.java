package com.luas.mapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * IMapper.java 数据库数据记录--Java对象映射超级接口
 * @author 老牟
 * @see blackshield->com.luas.mapper->IMapper.java
 * @see 2015年12月7日 上午10:37:58 
 * @version V1.00
 *
 * @see qq:1007821300 
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public interface IMapper<T> {
	
	/**
	 * 将数据记录RS转换成java对象T的方法
	 * @param rs 数据库中查询到的记录
	 * @return 返回转换以后的对象
	 * @throws SQLException
	 */
	T rowMapper(Connection conn, ResultSet rs) throws SQLException;
}
