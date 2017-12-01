package com.cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cn.biz.CommodityBiz;
import com.cn.biz.impl.CommodityBizImpl;
import com.cn.entity.Commodity;

public class CommodityServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public CommodityServlet() {
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
		CommodityBiz cb = new CommodityBizImpl();
		String op = request.getParameter("op");
		if("showone".equals(op)){
			int commodityid = Integer.parseInt(request.getParameter("commodityid"));
			Commodity commodity = cb.getCommodityById(commodityid);
			session.setAttribute("commodity", commodity);
			response.sendRedirect("details.jsp");
		} else if("all".equals(op)){
			List<Commodity> list = cb.select();
			session.setAttribute("list", list);
			response.sendRedirect("showcommodity.jsp");
		} else if("add".equals(op)){
			String c_name = request.getParameter("c_name");
			int c_o_price = Integer.parseInt(request.getParameter("c_o_price"));
			int c_n_price = Integer.parseInt(request.getParameter("c_n_price"));
			String c_des = request.getParameter("c_des");
			String c_img = request.getParameter("c_img");
			int c_num = Integer.parseInt(request.getParameter("c_num"));
			Commodity commodity = new Commodity(c_name,c_o_price,c_n_price,c_des,c_img,c_num);
			cb.addCommodity(commodity);
			response.sendRedirect("CommodityServlet?op=all");
		} else if("preupdate".equals(op)){
			int commodityid = Integer.parseInt(request.getParameter("commodityid"));
			Commodity commodity = cb.getCommodityById(commodityid);
			session.setAttribute("cdy", commodity);
			response.sendRedirect("updatecommodity.jsp");
		} else if("update".equals(op)){
			int commodityid = Integer.parseInt(request.getParameter("commodityid"));
			String c_name = request.getParameter("c_name");
			int c_o_price = Integer.parseInt(request.getParameter("c_o_price"));
			int c_n_price = Integer.parseInt(request.getParameter("c_n_price"));
			String c_des = request.getParameter("c_des");
			String c_img = request.getParameter("c_img");
			int c_num = Integer.parseInt(request.getParameter("c_num"));
			Commodity commodity = new Commodity(commodityid,c_name,c_o_price,
					c_n_price,c_des,c_img,c_num);
			cb.updateCommodity(commodity);
			response.sendRedirect("CommodityServlet?op=all");
		} else if("delete".equals(op)){
			int commodityid = Integer.parseInt(request.getParameter("commodityid"));
			cb.deleteCommodity(commodityid);
			response.sendRedirect("CommodityServlet?op=all");
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
