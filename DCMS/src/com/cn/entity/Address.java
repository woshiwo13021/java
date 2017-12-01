package com.cn.entity;
/**
 * 配送地址
 * @author Administrator
 *
 */
public class Address {
	private int a_id;//地址编号
	private int v_id;//关联会员id
	private String v_name;//收货人姓名
	private String a_address;//配送地址
	private String a_phone;//联系电话
	private int a_isdefault;//标示是否是默认收货地址
	
	public Address(int a_id, int v_id, String v_name, String a_address,
			String a_phone, int a_isdefault) {
		super();
		this.a_id = a_id;
		this.v_id = v_id;
		this.v_name = v_name;
		this.a_address = a_address;
		this.a_phone = a_phone;
		this.a_isdefault = a_isdefault;
	}

	public int getA_isdefault() {
		return a_isdefault;
	}

	public void setA_isdefault(int a_isdefault) {
		this.a_isdefault = a_isdefault;
	}

	public Address() {
		super();
	}
	
	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	
	
	
	public Address(int v_id, String v_name, String a_address, String a_phone) {
		super();
		this.v_id = v_id;
		this.v_name = v_name;
		this.a_address = a_address;
		this.a_phone = a_phone;
	}

	public Address(int a_id, int v_id, String v_name, String a_address,
			String a_phone) {
		super();
		this.a_id = a_id;
		this.v_id = v_id;
		this.v_name = v_name;
		this.a_address = a_address;
		this.a_phone = a_phone;
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
	public String getA_address() {
		return a_address;
	}
	public void setA_address(String a_address) {
		this.a_address = a_address;
	}
	public String getA_phone() {
		return a_phone;
	}
	public void setA_phone(String a_phone) {
		this.a_phone = a_phone;
	}
	
}
