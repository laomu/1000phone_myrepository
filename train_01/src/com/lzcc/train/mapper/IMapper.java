package com.lzcc.train.mapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 
 * @ClassName: IMapper 
 * @Description: 数据记录对象映射接口 
 * @author Ervin
 * @date 2016年1月19日 下午11:19:25 
 * @version V1.00
 *
 * @contact qq:164428088 
 * @tel 18294403990
 * @copyright 版权所有
 * @param <T>
 */
public interface IMapper<T> {
	/**
	 * 将数据记录转换成java对象的方法
	 * @param conn
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	T mapper(Connection conn,ResultSet rs)throws SQLException;
}
