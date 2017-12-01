package com.cn.entity;
/**
 * 会员类
 * @author Administrator
 *
 */
public class Member {
	private int v_id;//会员id
	private String v_name;//会员名称
	private String v_pass;//会员密码
	private String v_phone;//会员电话
	private String v_email;//会员邮箱
	private int addressId;//默认配送地址id
	
	public Member(int v_id, String v_name, String v_pass, String v_phone,
			String v_email, int addressId) {
		super();
		this.v_id = v_id;
		this.v_name = v_name;
		this.v_pass = v_pass;
		this.v_phone = v_phone;
		this.v_email = v_email;
		this.addressId = addressId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public Member() {
		super();
	}
	
	public Member(String v_name, String v_pass) {
		super();
		this.v_name = v_name;
		this.v_pass = v_pass;
	}

	public Member(String v_name, String v_pass, String v_phone, String v_email) {
		super();
		this.v_name = v_name;
		this.v_pass = v_pass;
		this.v_phone = v_phone;
		this.v_email = v_email;
	}

	public Member(int v_id, String v_name, String v_pass, String v_phone,
			String v_email) {
		super();
		this.v_id = v_id;
		this.v_name = v_name;
		this.v_pass = v_pass;
		this.v_phone = v_phone;
		this.v_email = v_email;
	}

	public int getV_id() {
		return v_id;
	}
	public void setV_id(int v_id) {
		this.v_id = v_id;
	}
	public String getV_name() {
		return v_name;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	public String getV_pass() {
		return v_pass;
	}
	public void setV_pass(String v_pass) {
		this.v_pass = v_pass;
	}
	public String getV_phone() {
		return v_phone;
	}
	public void setV_phone(String v_phone) {
		this.v_phone = v_phone;
	}
	public String getV_email() {
		return v_email;
	}
	public void setV_email(String v_email) {
		this.v_email = v_email;
	}
	
}
