package com.cn.biz;

import java.util.List;

import com.cn.entity.Address;

public interface AddressBiz{
	/**
	 * 根据会员id查询配送地址
	 * @param vid 会员id
	 * @return 该会员下的所有配送地址
	 */
	public List<Address> select(int vid);
	
	/**
	 * 根据配送地址id查询配送地址
	 * @param aid 配送地址id
	 * @return 查询到的配送地址
	 */
	public Address getAddressById(int aid);
	
	/**
	 * 新增收货地址
	 * @param address 新的地址
	 * @return
	 */
	public int addAddress(Address address);
	
	/**
	 * 标示为默认地址
	 */
	void defaultAddress(int vid,int addressid);
	
	/**
	 * 根据id删除地址
	 * @param addressid
	 */
	void deleteAddressById(int addressid);
	
	/**
	 * 根据id更新地址信息
	 * @param addressid
	 */
	void updateAddressById(Address address);
}
