package com.luas.model;

/**
 * CourseType.java �γ�����
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.model->CourseType.java
 * @see 2015��12��7�� ����10:20:34
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class CourseType implements Comparable<CourseType>{
	private int ctId;// ���ͱ��
	private String ctName;// ��������

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
