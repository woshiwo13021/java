package com.cn.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cn.comm.BaseDao;
import com.cn.dao.MemberDao;
import com.cn.entity.Member;

public class MemberDaoImpl extends BaseDao implements MemberDao{
	/**
	 * 查询数据库
	 * 
	 * @param sql
	 * @return
	 */
	public List<Member> select() {
		String sql = "select * from vips";
		// 创建Member集合保存查询结果
		List<Member> list = new ArrayList<Member>();
		try {
			rls = this.select(sql, null);
			while (rls.next()) {
				// 循环创建会员对象，并将对象加入集合中
				Member member = new Member(rls.getInt(1), rls.getString(2),
						rls.getString(3), rls.getString(4),rls.getString(5));
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return list;
	}

	// 会员注册
	public int addMember(Member member) {
		if (member != null) {
			String sql = "insert into vips values(se_vip.nextval,?,?,?,?,0)";
			List<Object> list = new ArrayList<Object>();
			list.add(member.getV_name());
			list.add(member.getV_pass());
			list.add(member.getV_phone());
			list.add(member.getV_email());
			return this.alter(sql, list);
		}
		return -1;
	}
	//会员登录
	public boolean login(Member member){
		String sql = "select v_pass from vips where v_name=?";
		List<Object> list = new ArrayList<Object>();
		list.add(member.getV_name());
		rls = this.select(sql, list);
			try {
				if(rls.next()){
					String v_pass = rls.getString(1);
					if(member.getV_pass().equals(v_pass)){
						return true;
					}else{
						return false;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				this.closeAll();
			}
		return false;
	}
	
	//判断是否有相同用户
	public boolean hasUser(String name){
		String sql = "select * from vips where v_name=?";
		List<Object> list = new ArrayList<Object>();
		list.add(name);
		rls = this.select(sql, list);
		try {
			if(rls.next()){
				this.closeAll();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			this.closeAll();
		}
		return false;
	}
	//根据用户名查询用户信息
	public Member getMemberByName(String name){
		String sql = "select * from vips where v_name=?";
		List<Object> list = new ArrayList<Object>();
		list.add(name);
		rls = this.select(sql, list);
		Member member = null;
		if(rls!=null){
			try {
				while(rls.next()){
					member = new Member(rls.getInt(1),rls.getString(2),rls.getString(3),rls.getString(4),rls.getString(5),rls.getInt(6));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				this.closeAll();
			}
		} 
		return member;
	}
	//修改密码
	public int updateUpassByName(String name,String pass){
		String sql = "update vips set v_pass=?where v_name=?";
		List<Object> list = new ArrayList<Object>();
		list.add(pass);
		list.add(name);
		return this.alter(sql, list);
	}
	//根据用户名查询密码
	public String getPassByName(String name){
		String sql = "select v_pass from vips where v_name=?";	
		List<Object> list = new ArrayList<Object>();
		list.add(name.toUpperCase());
		rls = this.select(sql, list);
		String pass = null;
		try {
			while(rls.next()){
				pass = rls.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeAll();
		}
		return pass;
	}
	
	//根据用户名修改密码
	public int repass(String name,String pass){
		String sql = "update vips set v_pass=? where v_name=?";
		List<Object> list = new ArrayList<Object>();
		list.add(pass.toUpperCase());
		list.add(name.toUpperCase());
		return this.alter(sql, list);
	}

	@Override//根据用户id修改用户默认收货地址
	public void setDefultAddress(Member member) {
		String sql = "update vips set v_addressid=? where v_id=?";	
		List<Object> list = new ArrayList<Object>();
		list.add(member.getAddressId());
		list.add(member.getV_id());
		this.alter(sql, list);
	}
	
}
