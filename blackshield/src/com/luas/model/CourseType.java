package com.luas.model;

/**
 * CourseType.java 课程类型
 * 
 * @author 老牟
 * @see blackshield->com.luas.model->CourseType.java
 * @see 2015年12月7日 上午10:20:34
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class CourseType implements Comparable<CourseType>{
	private int ctId;// 类型编号
	private String ctName;// 类型名称

	public int getCtId() {
		return ctId;
	}

	public void setCtId(int ctId) {
		this.ctId = ctId;
	}

	public String getCtName() {
		return ctName;
	}

	public void setCtName(String ctName) {
		this.ctName = ctName;
	}

	@Override
	public int compareTo(CourseType o) {
		if (o.getCtId() > this.getCtId()) {
			return -1;
		} else if(o.getCtId() < this.getCtId()) {
			return 1;
		}
		return 0;
	}

}
