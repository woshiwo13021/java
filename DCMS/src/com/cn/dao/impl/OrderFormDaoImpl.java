package com.cn.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.comm.BaseDao;
import com.cn.dao.OrderFormDao;
import com.cn.entity.OrderForm;

public class OrderFormDaoImpl extends BaseDao implements OrderFormDao{
	/**
	 * 查询所有订单
	 * @param sql
	 * @return
	 */
	public List<OrderForm> select(){
		String sql = "select * from orderForm";
		//创建OrderForm集合保存查询结果
		List<OrderForm> list = new ArrayList<OrderForm>();	
		try {
			rls = this.select(sql, null);
			while(rls.next()){
				//循环创建订单对象，并将对象加入集合中
				OrderForm of = new OrderForm(rls.getInt(1),rls.getInt(2),rls.getString(3),rls.getString(4),rls.getInt(5),rls.getString(6),rls.getString(7),rls.getString(8),rls.getString(9),rls.getString(10),rls.getString(11),rls.getString(12));
				list.add(of);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return list;
	}

	@Override
	public int addOrderForm(OrderForm orderForm) {
		String sql = "insert into orderForm values(se_of.nextval,?,?,?,?,?,?,?,?,?,?,?)";
		List<Object> list = new ArrayList<Object>();
		list.add(orderForm.getV_id());
		list.add(orderForm.getO_name());
		list.add(orderForm.getO_address());
		list.add(orderForm.getO_money());
		list.add(orderForm.getO_phone());
		list.add(orderForm.getO_mobilePhone());
		list.add(orderForm.getO_email());
		list.add(orderForm.getO_mode());
		list.add(orderForm.getO_pay());
		list.add(orderForm.getO_remarks());
		list.add(orderForm.getO_status());
		
		return this.alter(sql, list);
	}

	@Override
	public List<OrderForm> getOrderFormByVid(int vid) {
		String sql = "select * from orderForm where v_id=" + vid;
		rls = this.select(sql, null);
		List<OrderForm> list = new ArrayList<OrderForm>();
		try {
			while(rls.next()){
				OrderForm orderForm = new OrderForm();
				orderForm.setO_id(rls.getInt(1));
				orderForm.setV_id(rls.getInt(2));
				orderForm.setO_name(rls.getString(3));
				orderForm.setO_address(rls.getString(4));
				orderForm.setO_money(rls.getInt(5));
				orderForm.setO_phone(rls.getString(6));
				orderForm.setO_mobilePhone(rls.getString(7));
				orderForm.setO_email(rls.getString(8));
				orderForm.setO_mode(rls.getString(9));
				orderForm.setO_pay(rls.getString(10));
				orderForm.setO_remarks(rls.getString(11));
				orderForm.setO_status(rls.getString(12));
				list.add(orderForm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			this.closeAll();
		}
		return list;
	}

	@Override
	public int getMaxOrderFormId() {
		String sql = "select max(o_id) from orderform";
		rls = this.select(sql, null);
		int r  = 0;
		try {
			if(rls.next()){
				r = rls.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			this.closeAll();
		}
		return r;
	}

	@Override
	public int deleteOrderFormById(int orderId) {
		String sql = "delete from orderform where o_id=" + orderId;
		return this.alter(sql, null);
	}

}
