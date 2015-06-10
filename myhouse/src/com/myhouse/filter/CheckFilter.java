package com.myhouse.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myhouse.entity.User;
/**
 * CheckFilter过滤器是判断用户是否已登录，若无，则调到登录页面。
 * @author zqy
 *
 */
public class CheckFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		Object object = session.getAttribute("loginuser");
		String path = req.getRequestURI();
		//对于login页面，css页面，js页面以及images里的东西不用过滤，否则，会出问题。
		if (path.indexOf("login") == -1&&path.indexOf("Login")==-1&&path.indexOf("css")==-1&&path.indexOf("js")==-1&&path.indexOf("images")==-1&&path.indexOf("gister")==-1) {
			if (object == null) {
				//req.getRequestDispatcher("login.jsp").forward(req, res);
				res.sendRedirect(req.getContextPath()+"/login.jsp");
			} else {
				User us = (User) object;
				chain.doFilter(req, res);
			}
		}else{
			chain.doFilter(req, res);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
