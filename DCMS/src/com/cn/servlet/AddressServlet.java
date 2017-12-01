package com.cn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cn.biz.AddressBiz;
import com.cn.biz.MemberBiz;
import com.cn.biz.impl.AddressBizImpl;
import com.cn.biz.impl.MemberBizImpl;
import com.cn.entity.Address;
import com.cn.entity.Member;

public class AddressServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public AddressServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session  = request.getSession();
		Member member = (Member) session.getAttribute("member");
		if(member==null){
			response.sendRedirect("login.jsp");
			return;
		}
		String op = request.getParameter("op");
		AddressBiz ab = new AddressBizImpl();
		MemberBiz mb = new MemberBizImpl();
		if("add".equals(op)){
			//新增收货人姓名
			String addressname = request.getParameter("addressname");
			//新增联系电话
			String aphone = request.getParameter("aphone");
			//新增收货地址
			String a_ddress = request.getParameter("a_ddress");
			Address address = new Address(member.getV_id(),addressname,a_ddress,aphone);
			ab.addAddress(address);
			response.sendRedirect("PersonServlet?op=getalladdress");
		}else if("setadd".equals(op)){
			int addressid = Integer.parseInt(request.getParameter("addressid"));
			member.setAddressId(addressid);
			//将指定编号的地址标识为默认地址
			ab.defaultAddress(member.getV_id(),addressid);
			//为该用户指定默认地址
			mb.setDefultAddress(member);
			session.removeAttribute("meg");
			response.sendRedirect("PersonServlet?op=getalladdress");
		}else if ("choice".equals(op)) {
			int addressid = Integer.parseInt(request.getParameter("addressid"));
			Address address = ab.getAddressById(addressid);
			session.setAttribute("address", address);
			response.sendRedirect("sub.jsp");
		} else if("delete".equals(op)){
			int addressid = Integer.parseInt(request.getParameter("addressid"));
			ab.deleteAddressById(addressid);
			response.sendRedirect("PersonServlet?op=getalladdress");
		} else if ("preupdate".equals(op)){
			int addressid = Integer.parseInt(request.getParameter("addressid"));
			Address address = ab.getAddressById(addressid);
			session.setAttribute("ad", address);
			response.sendRedirect("updateaddress.jsp");
		} else if("update".equals(op)){
			//新增收货人姓名
			String addressname = request.getParameter("addressname");
			//新增联系电话
			String aphone = request.getParameter("aphone");
			//新增收货地址
			String a_ddress = request.getParameter("a_ddress");
			//获取收货地址id
			int addressid = Integer.parseInt(request.getParameter("addressid"));
			Address address = new Address(addressid,member.getV_id(),addressname,a_ddress,aphone);
			ab.updateAddressById(address);
			response.sendRedirect("PersonServlet?op=getalladdress");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
