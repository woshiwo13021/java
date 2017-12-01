package com.cn.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class OnLineCountListener implements HttpSessionListener {
	private int count;
	
	private void setContext(HttpSessionEvent se){
		se.getSession().getServletContext().setAttribute("online", count);
	}
	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		count++;
		setContext(sessionEvent);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		count--;
		setContext(sessionEvent);
	}
	
}
