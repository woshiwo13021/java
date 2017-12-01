package com.cn.cart;

import java.util.ArrayList;
import java.util.List;

import com.cn.entity.Commodity;
/**
 * 购物车类
 * @author Administrator
 *
 */
public class ShoppingCart {
	//购物车商品集合
	private volatile List<Commodity> shoppingList;	
	//购物车总价钱
	private Integer totleMoney;
	//会员id，标记该购物车属于哪个会员
	private Integer vipId;
	
	public Integer getVipId() {
		return vipId;
	}
	public void setVipId(Integer vipId) {
		this.vipId = vipId;
	}
	public ShoppingCart() {
		super();
	}
	public ShoppingCart(Integer vipId){
		this.init();
		this.vipId = vipId;
	}
	//初值化方法
	private void init(){
		this.shoppingList = new ArrayList<Commodity>();
		this.totleMoney = 0;
	}
	/**
	 * 向购物车增加商品
	 * @param commodity
	 */
	public void addCommodity(Commodity commodity){
		int commodityId = commodity.getId();
		if(hasCommodity(commodityId)){
			for (Commodity c : this.shoppingList) {
				if(c.getId()==commodityId){
					c.setNum(c.getNum() + 1);
					break;
				}
			}
		}else {
			this.shoppingList.add(commodity);
		}
	}
	/**
	 * 根据商品id判断购物车中是否包含一个商品
	 * @param commodityId 要检测的商品id
	 * @return
	 */
	public boolean hasCommodity(int commodityId){
		boolean f = false;
		for (Commodity c : this.shoppingList) {
			if(c.getId()==commodityId){
				f = true;
				break;
			}
		}
		return f;
	}
	/**
	 * 根据id删除购物车商品
	 * @param id 商品id
	 */
	public void deleteCommodity(int id){
		if (this.shoppingList.size() > 0){
			for (Commodity c : this.shoppingList) {
				if (c.getId() == id){
					this.shoppingList.remove(c);
				}
			}
		}else{
			throw new RuntimeException("购物车商品为空");
		}
	}
	/**
	 * 根据商品id和最新数量更新购物车中和id相同的商品
	 * @param id 商品id
	 * @param qutity 最新数量
	 */
	public void updateCommodityQutity(int id, int qutity){
		if (this.shoppingList.size() > 0){
			for (Commodity c : this.shoppingList) {
				if (c.getId() == id){
					c.setNum(qutity);
				}
			}
		}else{
			throw new RuntimeException("购物车商品为空");
		}
	}
	
	//清空购物车
	public void clearShoppingCart(){
		this.shoppingList.clear();
	}
	
	/**
	 * 计算购物车总金额
	 * @return
	 */
	public Integer getTotleMoney() {
		if (this.shoppingList.size() > 0){
			for (Commodity c : this.shoppingList) {
				this.totleMoney = this.totleMoney + c.getNewPrice() * c.getNum();
			}
		}else{
			throw new RuntimeException("购物车商品为空");
		}
		
		return this.totleMoney;
	}
	public void setTotleMoney(Integer totleMoney) {
		this.totleMoney = totleMoney;
	}
	
	public List<Commodity> getShoppingList() {
		return shoppingList;
	}
	
	
}
