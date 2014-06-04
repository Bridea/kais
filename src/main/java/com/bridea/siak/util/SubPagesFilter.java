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

public class SubPagesFilter implements Filter {
	FilterConfig config = null;
	ServletContext servletContext = null;

	public SubPagesFilter() {
		System.out.println("Masuk SubPagesFilter Admin");
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		config = filterConfig;
		servletContext = config.getServletContext();
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("Masuk doFilter");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		System.out.println("Lempar Link Ke admin Home");
		httpResponse.sendRedirect(httpRequest.getContextPath()
				+ Path.ADMIN_PAGE);

	}

	public void destroy() {

	}

}
