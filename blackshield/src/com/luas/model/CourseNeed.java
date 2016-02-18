package com.luas.model;

import java.util.Date;

/**
 * CourseNeed.java 求课程
 * 
 * @author 老牟
 * @see blackshield->com.luas.model->CourseNeed.java
 * @see 2015年12月7日 上午10:21:43
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class CourseNeed {
	private int cnId;// 编号
	private String cnUsername;// 发起人账号
	private String cnEmail;// 邮箱
	private String cnDesc;// 描述
	private boolean cnDeal;// 是否处理
	private Date needTime;// 发起时间

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
