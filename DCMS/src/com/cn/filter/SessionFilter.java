package com.cn.filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

import com.cn.biz.CommodityBiz;
import com.cn.biz.impl.CommodityBizImpl;
import com.cn.entity.Commodity;
import com.cn.util.Util;

public class SessionFilter implements Filter {
	private String[] loginPages;
	private String[] protectPages;
	private String errPath;
	private String sucPath;
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(response);
		HttpSession session  = request.getSession();
		String minfo = (String)session.getAttribute("minfo");
		if(minfo==null){//非已经登录
			if(Util.hasStr(request.getRequestURI(), loginPages)){
				if(request.getRequestURI().contains(sucPath)){
					CommodityBiz cb = new CommodityBizImpl();
					List<Commodity> list = cb.select();
					session.setAttribute("commodityList", list);
				}
				chain.doFilter(request, response);
				return;
			}
			if(!Util.hasStr(request.getRequestURI(), protectPages)){
				chain.doFilter(request, response);
				return;
			}
			wrapper.sendRedirect(errPath);
		}else{//登录状态
			if(Util.hasStr(request.getRequestURI(), loginPages)){
				if(request.getRequestURI().contains(sucPath)){
					CommodityBiz cb = new CommodityBizImpl();
					List<Commodity> list = cb.select();
					session.setAttribute("commodityList", list);
				}else{
					wrapper.sendRedirect(sucPath);
				}
			}
			chain.doFilter(request, response);
		}
		
	}

	@Override//获取处置化参数
	public void init(FilterConfig conf) throws ServletException {
		loginPages = conf.getInitParameter("loginPage").split(";");
		protectPages = conf.getInitParameter("protectPage").split(";");
		errPath = conf.getInitParameter("errPath");
		sucPath = conf.getInitParameter("sucPath");
	}

}
