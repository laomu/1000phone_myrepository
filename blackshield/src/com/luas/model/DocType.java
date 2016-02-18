package com.luas.model;

/**
 * DocType.java �ĵ�����
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.model->DocType.java
 * @see 2015��12��7�� ����10:20:59
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class DocType implements Comparable<DocType>{
	private int dtId;// ���ͱ��
	private String deName;// ��������

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
