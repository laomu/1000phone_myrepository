package com.luas.model;

/**
 * DocType.java 文档类型
 * 
 * @author 老牟
 * @see blackshield->com.luas.model->DocType.java
 * @see 2015年12月7日 上午10:20:59
 * @version V1.00
 *
 * @see qq:1007821300
 * @see 手机：15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class DocType implements Comparable<DocType>{
	private int dtId;// 类型编号
	private String deName;// 类型名称

	public int getDtId() {
		return dtId;
	}

	public void setDtId(int dtId) {
		this.dtId = dtId;
	}

	public String getDeName() {
		return deName;
	}

	public void setDeName(String deName) {
		this.deName = deName;
	}

	@Override
	public String toString() {
		return "DocType [dtId=" + dtId + ", deName=" + deName + "]";
	}

	@Override
	public int compareTo(DocType o) {
		if (this.getDtId() > o.getDtId()) {
			return 1;
		} else if(this.getDtId() < o.getDtId()) {
			return -1;
		} else {
			return 0;
		}
	}

}
