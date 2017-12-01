package com.cn.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.comm.BaseDao;
import com.cn.dao.CommodityDao;
import com.cn.entity.Commodity;

public class CommodityDaoImpl extends BaseDao implements CommodityDao{

	/**
	 * 查询数据库
	 * @param sql
	 * @return
	 */
	public List<Commodity> select(){
		String sql = "select * from commodity";
		//创建Commodity集合保存查询结果
		List<Commodity> list = new ArrayList<Commodity>();	
		try {
			rls = this.select(sql, null);
			while(rls.next()){
				//循环创建商品对象，并将商品加入集合中
				Commodity commodity = new Commodity(rls.getInt(1),rls.getString(2),rls.getInt(3),rls.getInt(4),rls.getString(5),rls.getString(6),rls.getInt(7));
				list.add(commodity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return list;
	}
	//增加商品
	public int addCommodity(Commodity commodity){
		if(commodity!=null){
			String sql = "insert into commodity values(se_com.nextval,?,?,?,?,?,?)";
			List<Object> list = new ArrayList<Object>();
			list.add(commodity.getName());
			list.add(commodity.getOldPrice());
			list.add(commodity.getNewPrice());
			list.add(commodity.getDescription());
			list.add(commodity.getImgURL());
			list.add(commodity.getNum());
			return this.alter(sql, list);
		}
		return -1;
	}
	//根据id得到商品信息
	@Override
	public Commodity getCommodityById(int commodityId) {
		String sql = "select * from commodity where c_id=" + commodityId;
		Commodity commodity = null;
		rls = this.select(sql, null);
		try {
			if(rls.next()){
				commodity = new Commodity(rls.getInt(1),rls.getString(2),rls.getInt(3),
						rls.getInt(4),rls.getString(5),rls.getString(6),rls.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return commodity;
	}
	@Override
	public void updateCommodity(Commodity commodity) {
		String sql = "update commodity set c_name=?,c_old_price=?," +
				"c_new_price=?,c_description=?,c_img=?,c_num=? where c_id=?";
		List<Object> list = new ArrayList<Object>();
		list.add(commodity.getName());
		list.add(commodity.getOldPrice());
		list.add(commodity.getNewPrice());
		list.add(commodity.getDescription());
		list.add(commodity.getImgURL());
		list.add(commodity.getNum());
		list.add(commodity.getId());
		this.alter(sql, list);
	}
	@Override
	public void deleteCommodity(int commodityId) {
		String sql = "delete from commodity where c_id=" + commodityId;
		this.alter(sql, null);
	}
}
