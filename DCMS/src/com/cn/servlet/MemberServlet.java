package com.cn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cn.biz.MemberBiz;
import com.cn.biz.impl.MemberBizImpl;
import com.cn.entity.Member;

public class MemberServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public MemberServlet() {
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
		MemberBiz mb = new MemberBizImpl();
		if("repass".equals(op)){
			//获取用户输入的旧密码
			String oupass = request.getParameter("oupass");
			//判断旧密码是否输入正确
			if(!oupass.equals(member.getV_pass())){
				session.setAttribute("meg", "err");
				response.sendRedirect("repass.jsp");
				return;
			}
			//获取新密码
			String renpass = request.getParameter("renpass");
			mb.updateUpassByName(member.getV_name(), renpass);
			member.setV_pass(renpass);
			session.setAttribute("member", member);
			session.setAttribute("meg", "suc");
			response.sendRedirect("repass.jsp");
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
