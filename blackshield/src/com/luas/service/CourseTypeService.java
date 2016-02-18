package com.luas.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.luas.dao.IDAO;
import com.luas.dao.impl.CourseTypeDAO;
import com.luas.dbhelper.ConnectionManager;
import com.luas.model.CourseType;

/**
 * CourseTypeService.java 课程类型业务处理类
 * 
 * @author 老牟
 * @see blackshield->com.luas.service->CourseTypeService.java
 * @see 2015年12月13日 下午5:19:26
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class CourseTypeService {

	// 日志记录
	private Logger log = Logger.getLogger(this.getClass());

	private IDAO<CourseType> dao = new CourseTypeDAO();
	private List<CourseType> list;
	private CourseType courseType;
	private Connection conn;

	/**
	 * 查询所有课程类型的方法
	 * 
	 * @return
	 */
	public List<CourseType> findAll() {
		log.info("开始执行查询所有课程类型的方法...");
		try {
			// 获取数据库连接
			conn = ConnectionManager.getConnection();
			// 调用查询所有列表的方法进行查询
			list = dao.findAll(conn);
			log.info("查询完成，供查询到记录数目:" + list.size() + "条数据。");
		} catch (SQLException e) {
			log.warn("查询失败....");
			e.printStackTrace();
		} finally {
			ConnectionManager.free(conn);
		}
		return list;
	}

	/**
	 * 根据id编号查询一个软件类型
	 * 
	 * @param id
	 *            编号
	 * @return 返回查询到的对象
	 */
	public CourseType findById(String ctId) {
		log.info("开始根据课程类型编号查询具体的课程类型数据...");
		try {
			conn = ConnectionManager.getConnection();
			courseType = dao.findById(conn, Integer.parseInt(ctId));
			log.info("查询完成，查询到的数据:" + courseType.getCtName());
		} catch (SQLException e) {
			log.warn("查询失败....");
			e.printStackTrace();
		} finally {

		}
		return courseType;
	}

}
