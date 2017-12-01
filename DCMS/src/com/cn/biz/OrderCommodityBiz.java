package com.cn.biz;

import java.util.List;

import com.cn.entity.Commodity;
import com.cn.entity.OrderCommodity;

public interface OrderCommodityBiz{
	/**
	 * 查询数据库
	 * @param sql
	 * @return
	 */
	public List<OrderCommodity> select(int fid);
	
	/**
	 * 将订单中的商品集合加入到数据库OrderCommodity中
	 * @param list 订单中的商品集合
	 * @return 
	 */
	public int insertOrderCommodity(List<Commodity> list, int orderId);
	
	/**
	 * 根据订单编号删除该订单下所有商品
	 * @param orderId
	 * @return
	 */
	public int deleteCommodityByOrderId(int orderId);
}
