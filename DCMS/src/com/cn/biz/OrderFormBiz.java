package com.cn.biz;

import java.util.List;

import com.cn.entity.OrderForm;

public interface OrderFormBiz {
	/**
	 * 查询数据库
	 * @param sql
	 * @return
	 */
	public List<OrderForm> select();
	/**
	 * 向数据库存入订单
	 * @param orderForm
	 * @return
	 */
	public int addOrderForm(OrderForm orderForm);
	/**
	 * 根据会员id查询订单信息
	 * @return
	 */
	public List<OrderForm> getOrderFormByVid(int vid);
	
	/**
	 * 获取数据中刚刚插入的订单编号
	 * @return
	 */
	public int getMaxOrderFormId();
	
	/**
	 * 根据订单编号删除订单
	 * @param orderId
	 * @return
	 */
	public int deleteOrderFormById(int orderId);
}
