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
 * @Description: ����ִ����
 * @author Ervin
 * @date 2016��1��19�� ����10:00:44 
 * @version V1.00
 *
 * @contact qq:164428088 
 * @tel 18294403990
 * @copyright ��Ȩ����
 */
public class DBHelper<T> {
	private PreparedStatement ps;
	private ResultSet rs;
	private T t;
	private List<T> list;
	private int rows=-1;
	
	/*
	 * ���ò����ķ���
	 */
	private void setParams(Object...objs) throws SQLException{
		if(objs !=null&& objs.length>0){
			for(int i=0;i<objs.length;i++){
				ps.setObject(i+1, objs[i]);
			}
		}
	}
	/**
	 * ִ��ɾ�ĵķ���
	 * @param conn
	 * @param sql
	 * @param objs
	 * @return
	 * @throws SQLException
	 */
	public int executeSQL(Connection conn, String sql,Object...objs) throws SQLException{
		ps= conn.prepareStatement(sql);
		setParams(objs);//��ֵ����
		rows=ps.executeUpdate();
		return rows;
	}
	/**
	 * ִ���������ݵķ���
	 * @param conn
	 * @param sql
	 * @param objs
	 * @return
	 * @throws SQLException
	 */
	public int executeInsert(Connection conn,String sql,Object...objs) throws SQLException{
		//��ȡһ�����Է���IDֵ��PS����
		ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		setParams(objs);//��ֵ����
		ps.executeUpdate();
		rs =ps.getGeneratedKeys();//��ȡ���ɵ�����ֵ
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
