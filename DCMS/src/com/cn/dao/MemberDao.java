package com.cn.dao;

import java.util.List;

import com.cn.entity.Member;

public interface MemberDao {
	/**
	 * 查询数据库
	 * 
	 * @param sql
	 * @return
	 */
	List<Member> select();

	// 会员注册
	int addMember(Member member);
	//会员登录
	boolean login(Member member);
	
	//判断是否有相同用户
	boolean hasUser(String name);
	//根据用户名查询用户信息
	Member getMemberByName(String name);
	//修改密码
	int updateUpassByName(String name,String pass);
	//根据用户名查询密码
	String getPassByName(String name);
	//根据用户名修改密码
	int repass(String name,String pass);
	//根据会员名修改默认配送地址编号
	void setDefultAddress(Member member);
	
}
