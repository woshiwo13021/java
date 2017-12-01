package com.cn.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.comm.BaseDao;
import com.cn.dao.OrderCommodityDao;
import com.cn.entity.Commodity;
import com.cn.entity.OrderCommodity;

public class OrderCommodityDaoImpl extends BaseDao implements OrderCommodityDao{
	/**
	 * 根据订单编号查询订单商品信息
	 * @param sql
	 * @return
	 */
	public List<OrderCommodity> select(int fid){
		String sql = "select * from orderCommodity where f_id=" + fid;
		//创建OrderCommodity集合保存查询结果
		List<OrderCommodity> list = new ArrayList<OrderCommodity>();	
		try {
			rls = this.select(sql, null);
			while(rls.next()){
				//循环创建订单商品对象，并将对象加入集合中
				OrderCommodity oc = new OrderCommodity(rls.getInt(1),rls.getString(2),rls.getInt(3),rls.getInt(4),rls.getString(5),rls.getString(6));
				list.add(oc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return list;
	}

	@Override
	public int insertOrderCommodity(List<Commodity> commodityList, int orderId) {
		String sql = "insert into ordercommodity values(?,?,?,?,?,?)";
		for (int i = 0; i < commodityList.size(); i++) {
			Commodity commodity = commodityList.get(i);
			List<Object> obj = new ArrayList<Object>();
			obj.add(orderId);
			obj.add(commodity.getName());
			obj.add(commodity.getNum());
			obj.add(commodity.getNewPrice());
			obj.add(commodity.getDescription());
			obj.add(commodity.getImgURL());
			this.alter(sql, obj);
		}
		return 1;
	}

	@Override
	public int deleteCommodityByOrderId(int orderId) {
		String sql = "delete from ordercommodity where f_id=" + orderId;
		return this.alter(sql, null);
	}
}
