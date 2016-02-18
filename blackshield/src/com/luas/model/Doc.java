package com.luas.model;

import java.util.Date;

/**
 * Doc.java �ĵ�
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.model->Doc.java
 * @see 2015��12��7�� ����10:21:07
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class Doc {
	private int docId;// �ĵ����
	private Manager manager;// �ϴ���
	private DocType docType;// �ĵ�����
	private String dname;// �ĵ�����
	private String ddesc;// �ĵ�����
	private String path;// �ļ�·��
	private Date publishTime;// ����ʱ��

	public Doc(Manager manager, DocType docType, String dname, String ddesc, String path, Date publishTime) {
		super();
		this.manager = manager;
		this.docType = docType;
		this.dname = dname;
		this.path = path;
		this.ddesc = ddesc;
		this.publishTime = publishTime;
	}

	public Doc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doc(int docId, Manager manager, DocType docType, String dname, String ddesc, Date publishTime) {
		super();
		this.docId = docId;
		this.manager = manager;
		this.docType = docType;
		this.dname = dname;
		this.ddesc = ddesc;
		this.publishTime = publishTime;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public DocType getDocType() {
		return docType;
	}

	public void setDocType(DocType docType) {
		this.docType = docType;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDdesc() {
		return ddesc;
	}

	public void setDdesc(String ddesc) {
		this.ddesc = ddesc;
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

	@Override
	public String toString() {
		return "Doc [docId=" + docId + ", manager=" + manager + ", docType=" + docType + ", dname=" + dname + ", ddesc="
				+ ddesc + ", path=" + path + ", publishTime=" + publishTime + "]";
	}

}
