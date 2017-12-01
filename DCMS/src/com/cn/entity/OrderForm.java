package com.cn.entity;

/**
 * 订单类
 * @author Administrator
 *
 */
public class OrderForm {
	private int o_id;//订单编号
	private int v_id;//会员id
	private String o_name;//收货人名字
	private String o_address;//送货地址
	private int o_money;//订单总金额
	private String o_phone;//联系电话
	private String o_mobilePhone;//移动电话
	private String o_email;//邮箱
	private String o_mode;//配送方式
	private String o_pay;//支付方式
	private String o_remarks;//附言
	private String o_status;//订单状态
	
	public OrderForm() {
		super();
	}
	

	public OrderForm(int v_id, String o_name, String o_address, int o_money,
			String o_phone, String o_mobilePhone, String o_email,
			String o_mode, String o_pay, String o_remarks, String o_status) {
		super();
		this.v_id = v_id;
		this.o_name = o_name;
		this.o_address = o_address;
		this.o_money = o_money;
		this.o_phone = o_phone;
		this.o_mobilePhone = o_mobilePhone;
		this.o_email = o_email;
		this.o_mode = o_mode;
		this.o_pay = o_pay;
		this.o_remarks = o_remarks;
		this.o_status = o_status;
	}


	public OrderForm(int o_id, int v_id, String o_name, String o_address,
			int o_money, String o_phone, String o_mobilePhone, String o_email,
			String o_mode, String o_pay, String o_remarks, String o_status) {
		super();
		this.o_id = o_id;
		this.v_id = v_id;
		this.o_name = o_name;
		this.o_address = o_address;
		this.o_money = o_money;
		this.o_phone = o_phone;
		this.o_mobilePhone = o_mobilePhone;
		this.o_email = o_email;
		this.o_mode = o_mode;
		this.o_pay = o_pay;
		this.o_remarks = o_remarks;
		this.o_status = o_status;
	}

	public void setO_id(int o_id) {
		this.o_id = o_id;
	}

	public void setV_id(int v_id) {
		this.v_id = v_id;
	}

	public void setO_name(String o_name) {
		this.o_name = o_name;
	}

	public void setO_address(String o_address) {
		this.o_address = o_address;
	}

	public void setO_money(int o_money) {
		this.o_money = o_money;
	}

	public void setO_phone(String o_phone) {
		this.o_phone = o_phone;
	}

	public void setO_mobilePhone(String o_mobilePhone) {
		this.o_mobilePhone = o_mobilePhone;
	}

	public void setO_email(String o_email) {
		this.o_email = o_email;
	}

	public void setO_mode(String o_mode) {
		this.o_mode = o_mode;
	}

	public void setO_pay(String o_pay) {
		this.o_pay = o_pay;
	}

	public void setO_remarks(String o_remarks) {
		this.o_remarks = o_remarks;
	}

	public void setO_status(String o_status) {
		this.o_status = o_status;
	}

	public int getO_id() {
		return o_id;
	}

	public int getV_id() {
		return v_id;
	}

	public String getO_name() {
		return o_name;
	}

	public String getO_address() {
		return o_address;
	}

	public int getO_money() {
		return o_money;
	}

	public String getO_phone() {
		return o_phone;
	}

	public String getO_mobilePhone() {
		return o_mobilePhone;
	}

	public String getO_email() {
		return o_email;
	}

	public String getO_mode() {
		return o_mode;
	}

	public String getO_pay() {
		return o_pay;
	}

	public String getO_remarks() {
		return o_remarks;
	}

	public String getO_status() {
		return o_status;
	}


}
