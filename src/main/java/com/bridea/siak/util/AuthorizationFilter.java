package com.bridea.siak.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorizationFilter implements Filter {
	FilterConfig config = null;
	ServletContext servletContext = null;

	public AuthorizationFilter() {
		System.out.println("Masuk AuthorizationFilter");
		System.out.println("Filter URL");
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		config = filterConfig;
		servletContext = config.getServletContext();
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("Masuk Do doFilter");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();

		Visit visit = (Visit) session.getAttribute("visit");
		System.out.println("session ==> " + session.getAttribute("visit"));
		System.out.println("Visit filter ==> " + visit);
		if (visit == null) {
			System.out.println("Visit == null");
			System.out.println("Lempar Ke Error Link");
			httpResponse.sendRedirect(httpRequest.getContextPath()
					+ Path.ERROR_PAGE);
		} else {
			System.out.println("Visit == NOT NUll");
			chain.doFilter(request, response);
		}
	}

	public void destroy() {

	}

}
