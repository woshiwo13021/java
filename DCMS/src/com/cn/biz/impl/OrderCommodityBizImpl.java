package com.cn.biz.impl;

import java.util.List;

import com.cn.biz.OrderCommodityBiz;
import com.cn.dao.OrderCommodityDao;
import com.cn.dao.impl.OrderCommodityDaoImpl;
import com.cn.entity.Commodity;
import com.cn.entity.OrderCommodity;

public class OrderCommodityBizImpl implements OrderCommodityBiz {
	private OrderCommodityDao ocd = null;
	
	public OrderCommodityBizImpl(){
		ocd = new OrderCommodityDaoImpl();
	}
	@Override
	public List<OrderCommodity> select(int fid) {
		return ocd.select(fid);
	}
	@Override
	public int insertOrderCommodity(List<Commodity> list, int orderId) {
		return ocd.insertOrderCommodity(list, orderId);
	}
	@Override
	public int deleteCommodityByOrderId(int orderId) {
		return ocd.deleteCommodityByOrderId(orderId);
	}

}
