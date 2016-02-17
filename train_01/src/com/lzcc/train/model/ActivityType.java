package com.lzcc.train.model;

/**
 * ActivityType.java 活动类型实体类
 * 
 * @author 老牟
 * @see train_01->com.lzcc.train.model->ActivityType.java
 * @see 2016年1月25日 下午5:07:35
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ActivityType {
	private int atId;// 编号
	private String atName;// 类型名称

	public int getAtId() {
		return atId;
	}

	public void setAtId(int atId) {
		this.atId = atId;
	}

	public String getAtName() {
		return atName;
	}

	public void setAtName(String atName) {
		this.atName = atName;
	}

}
