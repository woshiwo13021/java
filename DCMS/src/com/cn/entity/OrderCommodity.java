package com.cn.entity;
/**
 * 订单里的商品
 * @author Administrator
 *
 */
public class OrderCommodity {
	private int f_id;//订单编号
	private String f_name;//商品名称
	private int f_num;//商品数量
	private int f_price;//商品价钱
	private String f_description;//商品描述
	private String f_img;//商品图片路径
	
	public OrderCommodity() {
		super();
	}
	public OrderCommodity(int f_id, String f_name, int f_num, int f_price,
			String f_description, String f_img) {
		super();
		this.f_id = f_id;
		this.f_name = f_name;
		this.f_num = f_num;
		this.f_price = f_price;
		this.f_description = f_description;
		this.f_img = f_img;
	}
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public int getF_num() {
		return f_num;
	}
	public void setF_num(int f_num) {
		this.f_num = f_num;
	}
	public int getF_price() {
		return f_price;
	}
	public void setF_price(int f_price) {
		this.f_price = f_price;
	}
	public String getF_description() {
		return f_description;
	}
	public void setF_description(String f_description) {
		this.f_description = f_description;
	}
	public String getF_img() {
		return f_img;
	}
	public void setF_img(String f_img) {
		this.f_img = f_img;
	}
	
}
