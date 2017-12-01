package com.cn.biz.impl;

import java.util.List;

import com.cn.biz.CommodityBiz;
import com.cn.dao.impl.CommodityDaoImpl;
import com.cn.entity.Commodity;

public class CommodityBizImpl implements CommodityBiz {
	private CommodityDaoImpl cd = new CommodityDaoImpl();
	@Override
	public List<Commodity> select() {
		return cd.select();
	}

	@Override
	public int addCommodity(Commodity commodity) {
		return cd.addCommodity(commodity);
	}

	@Override
	public Commodity getCommodityById(int commodityId) {
		return cd.getCommodityById(commodityId);
	}

	@Override
	public void updateCommodity(Commodity commodity) {
		cd.updateCommodity(commodity);
		
	}

	@Override
	public void deleteCommodity(int commodityId) {
		cd.deleteCommodity(commodityId);
		
	}

}
