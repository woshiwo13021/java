package com.cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cn.biz.AddressBiz;
import com.cn.biz.OrderCommodityBiz;
import com.cn.biz.OrderFormBiz;
import com.cn.biz.impl.AddressBizImpl;
import com.cn.biz.impl.OrderCommodityBizImpl;
import com.cn.biz.impl.OrderFormBizImpl;
import com.cn.entity.Address;
import com.cn.entity.Member;
import com.cn.entity.OrderForm;

public class PersonServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 697645276010124078L;

	/**
	 * Constructor of the object.
	 */
	public PersonServlet() {
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
		String op = request.getParameter("op");
		HttpSession session  = request.getSession();
		Member member = (Member) session.getAttribute("member");
		if(member==null){
			response.sendRedirect("login.jsp");
			return;
		}
		OrderFormBiz ofb = new OrderFormBizImpl();
		if("getallorder".equals(op)){
			//根据会员id获取该会员的所有订单
			List<OrderForm> orderList = ofb.getOrderFormByVid(member.getV_id());
			session.setAttribute("orderList", orderList);
			response.sendRedirect("pshoping.jsp");
		}else if("deleteorder".equals(op)){
			OrderCommodityBiz ocb = new OrderCommodityBizImpl();
			int orderId = Integer.parseInt(request.getParameter("orderid"));
			//根据订单编号删除订单
			ofb.deleteOrderFormById(orderId);
			//根据订单编号删除订单商品
			ocb.deleteCommodityByOrderId(orderId);
			response.sendRedirect("PersonServlet?op=getallorder");
		} else if("getalladdress".equals(op)){
			AddressBiz ab = new AddressBizImpl();
			List<Address> addressList = ab.select(member.getV_id());
			session.setAttribute("addressList", addressList);
			response.sendRedirect("address.jsp");
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
