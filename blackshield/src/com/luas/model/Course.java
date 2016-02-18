package com.luas.model;

import java.util.Date;

/**
 * Course.java �γ�
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.model->Course.java
 * @see 2015��12��7�� ����10:20:47
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class Course {
	private int courseId;// �γ̱��
	private Manager manager;// �ϴ���
	private CourseType ct;// �γ�����
	private String courseImg;// ����ͼƬ
	private String courseName;// �γ�����
	private String cdesc;// �γ�����
	private int studyCount;// ѧϰ����
	private Date publishTime;// ����ʱ��
	private String path;// �γ�·��

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
