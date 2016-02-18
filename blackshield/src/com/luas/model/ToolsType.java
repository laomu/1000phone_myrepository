package com.luas.model;

/**
 * ToolsType.java ��������
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.model->ToolsType.java
 * @see 2015��12��7�� ����10:21:16
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class ToolsType implements Comparable<ToolsType>{
	private int ttId;// ���ͱ��
	private String ttName;// ��������

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
