package com.luas.model;

import java.util.Date;

/**
 * CourseNeed.java ��γ�
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.model->CourseNeed.java
 * @see 2015��12��7�� ����10:21:43
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class CourseNeed {
	private int cnId;// ���
	private String cnUsername;// �������˺�
	private String cnEmail;// ����
	private String cnDesc;// ����
	private boolean cnDeal;// �Ƿ���
	private Date needTime;// ����ʱ��

	public int getCnId() {
		return cnId;
	}

	public void setCnId(int cnId) {
		this.cnId = cnId;
	}

	public String getCnUsername() {
		return cnUsername;
	}

	public void setCnUsername(String cnUsername) {
		this.cnUsername = cnUsername;
	}

	public String getCnEmail() {
		return cnEmail;
	}

	public void setCnEmail(String cnEmail) {
		this.cnEmail = cnEmail;
	}

	public String getCnDesc() {
		return cnDesc;
	}

	public void setCnDesc(String cnDesc) {
		this.cnDesc = cnDesc;
	}

	public boolean isCnDeal() {
		return cnDeal;
	}

	public void setCnDeal(boolean cnDeal) {
		this.cnDeal = cnDeal;
	}

	public Date getNeedTime() {
		return needTime;
	}

	public void setNeedTime(Date needTime) {
		this.needTime = needTime;
	}

}
