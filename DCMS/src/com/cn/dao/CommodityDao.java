package com.cn.dao;

import java.util.List;

import com.cn.entity.Commodity;

public interface CommodityDao{

	/**
	 * 查看所有商品信息
	 * @return
	 */
	List<Commodity> select();
	/**
	 * 增加商品
	 * @param commodity 要增加的商品
	 * @return
	 */
	int addCommodity(Commodity commodity);
	/**
	 * 根据id得到商品
	 * @param commodityId 商品id
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
