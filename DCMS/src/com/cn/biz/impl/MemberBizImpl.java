package com.cn.biz.impl;

import java.util.List;

import com.cn.biz.MemberBiz;
import com.cn.dao.MemberDao;
import com.cn.dao.impl.MemberDaoImpl;
import com.cn.entity.Member;

public class MemberBizImpl implements MemberBiz {
	private MemberDao md = new MemberDaoImpl();
	@Override
	public List<Member> select() {
		return md.select();
	}

	@Override
	public int addMember(Member member) {
		return md.addMember(member);
	}

	@Override
	public boolean login(Member member) {
		return md.login(member);
	}

	@Override
	public boolean hasUser(String name) {
		return md.hasUser(name);
	}

	@Override
	public Member getMemberByName(String name) {
		return md.getMemberByName(name);
	}

	@Override
	public int updateUpassByName(String name, String pass) {
		return md.updateUpassByName(name, pass);
	}

	@Override
	public String getPassByName(String name) {
		return md.getPassByName(name);
	}

	@Override
	public int repass(String name, String pass) {
		return md.repass(name, pass);
	}

	@Override
	public void setDefultAddress(Member member) {
		md.setDefultAddress(member);
		
	}

}
