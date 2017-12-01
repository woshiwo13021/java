package com.cn.biz.impl;

import java.util.List;

import com.cn.biz.OrderFormBiz;
import com.cn.dao.OrderFormDao;
import com.cn.dao.impl.OrderFormDaoImpl;
import com.cn.entity.OrderForm;

public class OrderFormBizImpl implements OrderFormBiz {
	private OrderFormDao ofd = null;
	
	public OrderFormBizImpl(){
		ofd = new OrderFormDaoImpl();
	}
	@Override
	public List<OrderForm> select() {
		return ofd.select();
	}
	@Override
	public int addOrderForm(OrderForm orderForm) {
		System.out.println("ad");
		return ofd.addOrderForm(orderForm);
	}
	@Override
	public List<OrderForm> getOrderFormByVid(int vid) {
		return ofd.getOrderFormByVid(vid);
	}
	@Override
	public int getMaxOrderFormId() {
		return ofd.getMaxOrderFormId();
	}
	@Override
	public int deleteOrderFormById(int orderId) {
		return ofd.deleteOrderFormById(orderId);
	}

}
