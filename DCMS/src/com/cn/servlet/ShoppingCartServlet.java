package com.cn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cn.biz.CommodityBiz;
import com.cn.biz.impl.CommodityBizImpl;
import com.cn.cart.ShoppingCart;
import com.cn.entity.Commodity;
import com.cn.entity.Member;

public class ShoppingCartServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6431517008146231585L;

	/**
	 * Constructor of the object.
	 */
	public ShoppingCartServlet() {
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
		//从session中取出购物车
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		//从session中获取会员信息
		Member member = (Member) session.getAttribute("member");
		if(member==null){
			response.sendRedirect("login.jsp");
			return;
		}
		//如果session中不存在购物车则新建购物车
		if (cart == null){
			cart = new ShoppingCart(member.getV_id());
		}
		//创建商品biz
		CommodityBiz cb = new CommodityBizImpl();
		String op = request.getParameter("op");
		if("clear".equals(op)){
			cart.clearShoppingCart();
			response.sendRedirect("shoppingcart.jsp");
			return;
		} 
		//得到商品id
		int commodityId = Integer.parseInt(request.getParameter("commodityId"));
		if ("delete".equals(op)){
			cart.deleteCommodity(commodityId);
			response.sendRedirect("shoppingcart.jsp");
			return;
		}
		//得到商品数量
		int commodityQutity = Integer.parseInt(request.getParameter("commodityQutity"));
		if("add".equals(op)){
			Commodity commodity = null;
			if(cart.hasCommodity(commodityId)){
				commodity = new Commodity(commodityId);
			}else{
				//根据商品id得到商品
				commodity = cb.getCommodityById(commodityId);
				//设置商品的数量
				commodity.setNum(commodityQutity);
			}
			//将商品加入 
			cart.addCommodity(commodity);
		} else if ("update".equals(op)){
			cart.updateCommodityQutity(commodityId, commodityQutity);
		} 
		session.setAttribute("cart", cart);
		response.sendRedirect("shoppingcart.jsp");
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
