package com.luas.model;

import java.util.Date;

/**
 * Tools.java ����
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.model->Tools.java
 * @see 2015��12��7�� ����10:21:32
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class Tools {
	private int toolsId;// ���߱��
	private Manager manager;// �ϴ���
	private ToolsType toolsType;// ����
	private String tname;// ����
	private String tdesc;// ����
	private Date publishTime;// ����ʱ��

	private String toolsImg;// ����ͼƬ
	private String path;// ���·��

	public Tools(Manager manager, ToolsType toolsType, String tname, String tdesc, Date publishTime, String toolsImg,
			String path) {
		super();
		this.manager = manager;
		this.toolsType = toolsType;
		this.tname = tname;
		this.tdesc = tdesc;
		this.publishTime = publishTime;
		this.toolsImg = toolsImg;
		this.path = path;
	}

	public Tools() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getToolsId() {
		return toolsId;
	}

	public void setToolsId(int toolsId) {
		this.toolsId = toolsId;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public ToolsType getToolsType() {
		return toolsType;
	}

	public void setToolsType(ToolsType toolsType) {
		this.toolsType = toolsType;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTdesc() {
		return tdesc;
	}

	public void setTdesc(String tdesc) {
		this.tdesc = tdesc;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getToolsImg() {
		return toolsImg;
	}

	public void setToolsImg(String toolsImg) {
		this.toolsImg = toolsImg;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
