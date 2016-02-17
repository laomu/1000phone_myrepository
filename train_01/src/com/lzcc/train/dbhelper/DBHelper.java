package com.lzcc.train.dbhelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lzcc.train.mapper.IMapper;

/**
 * 
 * @ClassName: DBHelper 
 * @Description: 数据执行类
 * @author Ervin
 * @date 2016年1月19日 下午10:00:44 
 * @version V1.00
 *
 * @contact qq:164428088 
 * @tel 18294403990
 * @copyright 版权所有
 */
public class DBHelper<T> {
	private PreparedStatement ps;
	private ResultSet rs;
	private T t;
	private List<T> list;
	private int rows=-1;
	
	/*
	 * 设置参数的方法
	 */
	private void setParams(Object...objs) throws SQLException{
		if(objs !=null&& objs.length>0){
			for(int i=0;i<objs.length;i++){
				ps.setObject(i+1, objs[i]);
			}
		}
	}
	/**
	 * 执行删改的方法
	 * @param conn
	 * @param sql
	 * @param objs
	 * @return
	 * @throws SQLException
	 */
	public int executeSQL(Connection conn, String sql,Object...objs) throws SQLException{
		ps= conn.prepareStatement(sql);
		setParams(objs);//赋值参数
		rows=ps.executeUpdate();
		return rows;
	}
	/**
	 * 执行增加数据的方法
	 * @param conn
	 * @param sql
	 * @param objs
	 * @return
	 * @throws SQLException
	 */
	public int executeInsert(Connection conn,String sql,Object...objs) throws SQLException{
		//获取一个可以返回ID值得PS对象
		ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		setParams(objs);//赋值参数
		ps.executeUpdate();
		rs =ps.getGeneratedKeys();//获取生成的主键值
		if(rs.next()){
			rows =rs.getInt(1);
		}
		return rows;
		
	}
	public List<T> executeQuery(Connection conn,IMapper<T>mapper,String sql,Object...objs) throws SQLException{
		ps = conn.prepareStatement(sql);
		setParams(objs);
		rs = ps.executeQuery();
		list = new ArrayList<T>();
		while(rs.next()){
			t=mapper.mapper(conn,rs);
			list.add(t);
		}
		return list;
		
	}
}
