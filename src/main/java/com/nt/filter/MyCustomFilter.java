package com.nt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyCustomFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		// Initialization logic (optional)
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		String url = req.getRequestURI();
		System.out.println(url);
		if (url.equals("/Account_00/") || url.equals("/Account_00/login-form")
				|| url.equals("/Account_00/login")) {
			chain.doFilter(request, response);
		} else {
			if (session != null) {
				String uname = (String) session.getAttribute("user");
				if (uname != null) {
					chain.doFilter(request, response);
				} else {
					req.setAttribute("errorMsg", "Please Login");
					RequestDispatcher rd = req.getRequestDispatcher("login-form");
					rd.forward(req, res);
				}
			} else {
				req.setAttribute("errorMsg", "Please Login");
				RequestDispatcher rd = req.getRequestDispatcher("login-form");
				rd.forward(req, res);
			}
		}

	}

	public void destroy() {
		// Cleanup logic (optional)
	}
}
