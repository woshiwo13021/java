package com.cn.biz;

import java.util.List;

import com.cn.entity.Commodity;

public interface CommodityBiz{

	/**
	 * 查询所有商品
	 * @param sql
	 * @return
	 */
	List<Commodity> select();
	/**
	 * 增加商品
	 * @param commodity
	 * @return
	 */
	int addCommodity(Commodity commodity);
	/**
	 * 根据id得到商品
	 * @param commodityId
	 * @return
	 */
	Commodity getCommodityById(int commodityId);
	/**
	 * 修改商品信息
	 * @param commodity
	 */
	void updateCommodity(Commodity commodity);
	/**
	 * 根据id删除商品
	 * @param commodityId
	 */
	void deleteCommodity(int commodityId);
}
