package com.cn.biz;

import java.util.List;

import com.cn.entity.Member;

public interface MemberBiz {
	/**
	 * 查询所有会员信息
	 * 
	 * @return
	 */
	List<Member> select();

	/**
	 * 会员注册
	 * @param member
	 * @return
	 */
	int addMember(Member member);
	/**
	 * 会员登录
	 * @param member
	 * @return
	 */
	boolean login(Member member);
	
	/**
	 * 判断是否有相同用户
	 * @param name
	 * @return
	 */
	boolean hasUser(String name);
	/**
	 * 根据用户名查询用户信息
	 * @param name
	 * @return
	 */
	Member getMemberByName(String name);
	/**
	 * 修改密码
	 * @param name
	 * @param pass
	 * @return
	 */
	int updateUpassByName(String name,String pass);
	/**
	 * 根据用户名查询密码
	 * @param name
	 * @return
	 */
	String getPassByName(String name);
	/**
	 * 根据用户名修改密码
	 * @param name
	 * @param pass
	 * @return
	 */
	int repass(String name,String pass);
	
	/**
	 * 根据会员名修改默认配送地址编号
	 * @param member
	 */
	void setDefultAddress(Member member);
	
}
