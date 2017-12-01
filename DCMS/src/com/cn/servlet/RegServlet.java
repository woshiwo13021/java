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

public class RegServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public RegServlet() {
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
		HttpSession session = request.getSession();
		MemberBiz mb = new MemberBizImpl();
		String uname = request.getParameter("uname");
		if(mb.hasUser(uname)){
			session.setAttribute("meg", "err");
			response.sendRedirect("register.jsp");
			return;
		}
		String upass = request.getParameter("upass");
		String uphone = request.getParameter("uphone");
		String uemail = request.getParameter("uemail");
		Member member = new Member(uname,upass,uphone,uemail);
		
		int r = mb.addMember(member);
		if(r>0){
			session.setAttribute("meg", "suc");
			response.sendRedirect("login.jsp");
		}else{
			session.setAttribute("meg", "err");
			response.sendRedirect("register.jsp");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		
	}

}
