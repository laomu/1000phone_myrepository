package com.luas.model;

import java.util.Date;

/**
 * Course.java 课程
 * 
 * @author 老牟
 * @see blackshield->com.luas.model->Course.java
 * @see 2015年12月7日 上午10:20:47
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class Course {
	private int courseId;// 课程编号
	private Manager manager;// 上传人
	private CourseType ct;// 课程类型
	private String courseImg;// 封面图片
	private String courseName;// 课程名称
	private String cdesc;// 课程描述
	private int studyCount;// 学习人数
	private Date publishTime;// 发布时间
	private String path;// 课程路径

	public Course(Manager manager, CourseType ct, String courseImg, String courseName, String cdesc, int studyCount,
			Date publishTime, String path) {
		super();
		this.manager = manager;
		this.ct = ct;
		this.courseImg = courseImg;
		this.courseName = courseName;
		this.cdesc = cdesc;
		this.studyCount = studyCount;
		this.publishTime = publishTime;
		this.path = path;
	}

	public Course(int courseId, Manager manager, CourseType ct, String courseImg, String courseName, String cdesc,
			int studyCount, Date publishTime) {
		super();
		this.courseId = courseId;
		this.manager = manager;
		this.ct = ct;
		this.courseImg = courseImg;
		this.courseName = courseName;
		this.cdesc = cdesc;
		this.studyCount = studyCount;
		this.publishTime = publishTime;
	}

	public Course() {
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public CourseType getCt() {
		return ct;
	}

	public void setCt(CourseType ct) {
		this.ct = ct;
	}

	public String getCourseImg() {
		return courseImg;
	}

	public void setCourseImg(String courseImg) {
		this.courseImg = courseImg;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCdesc() {
		return cdesc;
	}

	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}

	public int getStudyCount() {
		return studyCount;
	}

	public void setStudyCount(int studyCount) {
		this.studyCount = studyCount;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
