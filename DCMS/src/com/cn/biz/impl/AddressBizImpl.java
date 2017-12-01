package com.cn.biz.impl;

import java.util.List;

import com.cn.biz.AddressBiz;
import com.cn.dao.impl.AddressDaoImpl;
import com.cn.entity.Address;

public class AddressBizImpl implements AddressBiz {
	private AddressDaoImpl ad = new AddressDaoImpl();
	@Override
	public List<Address> select(int vid) {
		return ad.select(vid);
	}
	@Override
	public Address getAddressById(int aid) {
		return ad.getAddressById(aid);
	}
	@Override
	public int addAddress(Address address) {
		return ad.addAddress(address);
	}
	@Override
	public void defaultAddress(int vid,int addressid) {
		ad.defaultAddress(vid,addressid);
	}
	@Override
	public void deleteAddressById(int addressid) {
		ad.deleteAddressById(addressid);
	}
	@Override
	public void updateAddressById(Address address) {
		ad.updateAddressById(address);
		
	}

}
