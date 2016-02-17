package com.lzcc.train.model;

/**
 * Address.java �û���ַ����
 * 
 * @author ��Ĳ
 * @see train_01->com.lzcc.train.model->Address.java
 * @see 2016��1��25�� ����5:06:37
 * @version V1.00
 *
 * @see qq:1007821300
 * @see �ֻ���15294157465
 * @see http://blog.csdn.net/muwenbin_flex
 */
public class Address {
	private int aid;// ���
	private User user;// �����û�
	private String anation;// ����
	private String province;// ʡ
	private String city;// ����
	private String country;// ����
	private String street;// �ֵ�
	private String adesc;// ����
	private boolean status;// �Ƿ�Ĭ��
	private String contact;// �ջ���
	private String phone;// ��ϵ��ʽ

	public Address() {
	}

	public Address(User user, String anation, String province, String city, String country, String street, String adesc,
			boolean status, String contact, String phone) {
		super();
		this.user = user;
		this.anation = anation;
		this.province = province;
		this.city = city;
		this.country = country;
		this.street = street;
		this.adesc = adesc;
		this.status = status;
		this.contact = contact;
		this.phone = phone;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAnation() {
		return anation;
	}

	public void setAnation(String anation) {
		this.anation = anation;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getAdesc() {
		return adesc;
	}

	public void setAdesc(String adesc) {
		this.adesc = adesc;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return this.anation.concat(this.province.concat(this.city.concat(this.country.concat(
				this.street.concat(this.adesc.concat("\t".concat(this.contact.concat("\t".concat(this.phone)))))))));
	}

}
