package com.luas.model;

/**
 * ToolsType.java 工具类型
 * 
 * @author 老牟
 * @see blackshield->com.luas.model->ToolsType.java
 * @see 2015年12月7日 上午10:21:16
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ToolsType implements Comparable<ToolsType>{
	private int ttId;// 类型编号
	private String ttName;// 类型名称

	public int getTtId() {
		return ttId;
	}

	public void setTtId(int ttId) {
		this.ttId = ttId;
	}

	public String getTtName() {
		return ttName;
	}

	public void setTtName(String ttName) {
		this.ttName = ttName;
	}

	@Override
	public int compareTo(ToolsType o) {
		if (o.getTtId() > this.getTtId()) {
			return -1;
		} else if(o.getTtId() < this.getTtId()) {
			return 1;
		}
		return 0;
	}

}
