package com.husen.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 登陆权限过滤器
 * 
 */
public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		Object obj = req.getSession().getAttribute("user");
		System.out.println(obj);
		if(obj==null){
			String path = req.getContextPath();
			String basePath = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+path+"/";
			resp.sendRedirect(basePath+"login.jsp");
			/*	resp.sendRedirect("login.jsp");
			String path = req.getRequestURI();
			System.out.println(path);
			path = path.substring(path.lastIndexOf("/")+1);
			System.out.println(path);
			if(!("book?op=login".equals(path)||"book".equals(path)||"login.jsp".equals(path))){
				return;
			}*/
		}
		//如果是以上的两个路径或者obj不为空
		chain.doFilter(req, resp);
	}

	@Override
	public void destroy() {
		
	}

}
