package com.cn.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.comm.BaseDao;
import com.cn.dao.AddressDao;
import com.cn.entity.Address;

public class AddressDaoImpl extends BaseDao implements AddressDao{
	/**
	 * 根据会员id查询该会员的所有配送地址
	 * @param vid 会员id
	 * @return
	 */
	public List<Address> select(int vid){
		String sql = "select * from address where v_id=" + vid;
		//创建Member集合保存查询结果
		List<Address> list = new ArrayList<Address>();	
		try {
			rls = this.select(sql, null);
			while(rls.next()){
				//循环创建地址对象，并将对象加入集合中
				Address address = new Address(rls.getInt(1),rls.getInt(2),
						rls.getString(3),rls.getString(4),rls.getString(5),rls.getInt(6));
				list.add(address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return list;
	}

	@Override
	public Address getAddressById(int aid) {
		String sql = "select * from address where a_id=" + aid;
		rls = this.select(sql, null);
		Address address = null;
		try {
			if(rls.next()){
				address = new Address(rls.getInt(1),rls.getInt(2),
						rls.getString(3),rls.getString(4),rls.getString(5),rls.getInt(6));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			this.closeAll();
		}
		return address;
	}

	@Override
	public int addAddress(Address address) {
		String sql = "insert into address values(se_address.nextval,?,?,?,?,0)";
		List<Object> list = new ArrayList<Object>();
		list.add(address.getV_id());
		list.add(address.getV_name());
		list.add(address.getA_address());
		list.add(address.getA_phone());
		return this.alter(sql, list);
	}

	@Override//标示指定定id的收货地址为默认地址
	public void defaultAddress(int vid, int addressid) {
		String sq = "update address set a_isdefault=0 where v_id=" + vid;
		this.alter(sq, null);
		String sql = "update address set a_isdefault=1 where a_id=" + addressid + "and v_id=" + vid;
		this.alter(sql, null);
	}

	@Override
	public void deleteAddressById(int addressid) {
		String sql = "delete from address where a_id=" + addressid;
		this.alter(sql, null);
	}

	@Override
	public void updateAddressById(Address address) {
		String sql = "update address set v_name=?,a_adress=?,a_phone=? where a_id=?";
		List<Object> list = new ArrayList<Object>();
		list.add(address.getV_name());
		list.add(address.getA_address());
		list.add(address.getA_phone());
		list.add(address.getA_id());
		this.alter(sql, list);
	}
}
