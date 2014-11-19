package com.certifier.rest.filter;

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

public class SessionFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	/*
	 * If user is already authenticated, or redirect the request to the Home.jsp
	 */
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		String user = null;

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession(false);
		String servletPath = request.getServletPath();
		if (session != null) {
			user = (String) session.getAttribute("user");
		}
		// System.out.println("Remore User: " + request.getRemoteUser());
		// System.out.println("Remore User: " + request.isUserInRole("guest"));

		System.out.println("User  is  already logged in: " + user);
		System.out.println("Servlet Path is : " + servletPath);
		String redirectUrl = request.getParameter("redirect");
		if ("/admin.jsp".equalsIgnoreCase(servletPath)) {
			response.sendRedirect(request.getContextPath() + "/error.jsp");
		} else if (user != null && "/login.jsp".equalsIgnoreCase(servletPath)) {
			response.sendRedirect(request.getContextPath() + "/home.jsp");
		} else {
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
