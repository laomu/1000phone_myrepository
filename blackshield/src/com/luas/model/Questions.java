package com.luas.model;

import java.util.Date;

/**
 * Questions.java �����б�
 * 
 * @author ��Ĳ
 * @see blackshield->com.luas.model->Questions.java
 * @see 2015��12��7�� ����10:21:52
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class Questions {

	private int qtId;// ������
	private String qtUsername;// �������˺�
	private String qtEmail;// ����
	private String qtDesc;// ����
	private boolean qtDeal;// �Ƿ���
	private Date qtTime;// ����ʱ��

	public Questions(String qtUsername, String qtEmail, String qtDesc, boolean qtDeal, Date qtTime) {
		super();
		this.qtUsername = qtUsername;
		this.qtEmail = qtEmail;
		this.qtDesc = qtDesc;
		this.qtDeal = qtDeal;
		this.qtTime = qtTime;
	}

	public Questions(int qtId, String qtUsername, String qtEmail, String qtDesc, boolean qtDeal, Date qtTime) {
		super();
		this.qtId = qtId;
		this.qtUsername = qtUsername;
		this.qtEmail = qtEmail;
		this.qtDesc = qtDesc;
		this.qtDeal = qtDeal;
		this.qtTime = qtTime;
	}

	public Questions() {
		super();
	}

	public int getQtId() {
		return qtId;
	}

	public void setQtId(int qtId) {
		this.qtId = qtId;
	}

	public String getQtUsername() {
		return qtUsername;
	}

	public void setQtUsername(String qtUsername) {
		this.qtUsername = qtUsername;
	}

	public String getQtEmail() {
		return qtEmail;
	}

	public void setQtEmail(String qtEmail) {
		this.qtEmail = qtEmail;
	}

	public String getQtDesc() {
		return qtDesc;
	}

	public void setQtDesc(String qtDesc) {
		this.qtDesc = qtDesc;
	}

	public boolean isQtDeal() {
		return qtDeal;
	}

	public void setQtDeal(boolean qtDeal) {
		this.qtDeal = qtDeal;
	}

	public Date getQtTime() {
		return qtTime;
	}

	public void setQtTime(Date qtTime) {
		this.qtTime = qtTime;
	}

}
