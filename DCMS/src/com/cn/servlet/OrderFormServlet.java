package com.cn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cn.biz.OrderCommodityBiz;
import com.cn.biz.OrderFormBiz;
import com.cn.biz.impl.OrderCommodityBizImpl;
import com.cn.biz.impl.OrderFormBizImpl;
import com.cn.cart.ShoppingCart;
import com.cn.entity.Address;
import com.cn.entity.Member;
import com.cn.entity.OrderForm;

public class OrderFormServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public OrderFormServlet() {
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
		OrderFormBiz of = new OrderFormBizImpl();
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		if(member==null){
			response.sendRedirect("login.jsp");
			return;
		}else if(cart==null || cart.getShoppingList().size()<=0) {
			response.sendRedirect("index.jsp");
			return;
		}
		//配送方式
		String mode = request.getParameter("mode");
		//付款方式
		String pay = request.getParameter("pay");
		//留言
		String remarks = request.getParameter("remarks");
		//订单状态
		String status = request.getParameter("status");
		Address address = (Address) session.getAttribute("address");
		if(address==null){
			session.setAttribute("meg", "addmiss");
			response.sendRedirect("sub.jsp");
			return;
		}
		OrderForm orderForm = new OrderForm(member.getV_id(),address.getV_name(),
				address.getA_address(),cart.getTotleMoney(),address.getA_phone(),
				member.getV_phone(),member.getV_email(),mode,pay,remarks,status);
		of.addOrderForm(orderForm);
		int maxId = of.getMaxOrderFormId();//获取刚刚生成的订单信息
		orderForm.setO_id(maxId);//将订单id赋给订单
		OrderCommodityBiz ocd = new OrderCommodityBizImpl();
		//将订单存入session中
		session.setAttribute("orderForm", orderForm);
		int r = ocd.insertOrderCommodity(cart.getShoppingList(), maxId);
		if(r>0){
			cart.clearShoppingCart();
			session.setAttribute("cart", cart);
			response.sendRedirect("orderform.jsp");
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
