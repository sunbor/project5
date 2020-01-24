package com.revature.util;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {

	//private final Logger logger = LogManager.getLogger(getClass());

	@Override
	public void init(FilterConfig filterConfig) throws ServletException{
	}
	
	@Override
	public void destroy(){		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("is called");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		//logger.info(httpRequest.getMethod() + " request going to " + httpRequest.getRequestURI());
		Enumeration<String> headers = httpRequest.getHeaderNames();
		while (headers.hasMoreElements()) {
			String header = headers.nextElement();
		//	logger.info("{}: {}", header, httpRequest.getHeader(header));
		}

		httpResponse.addHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		
		httpResponse.addHeader("Access-Control-Allow-Methods", "GET, PUT, POST, DELETE, OPTIONS");
		httpResponse.addHeader("Access-Control-Allow-Credentials", "true");
		httpResponse.addHeader("Access-Control-Request-Headers",
				"Access-Control-Allow-Origin, Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, Authorization, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, Access-Control-Allow-Credentials");
		httpResponse.addHeader("Access-Control-Allow-Headers",
				"Access-Control-Allow-Origin, Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, Authorization, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, Access-Control-Allow-Credentials");

		if (httpRequest.getMethod().equalsIgnoreCase("OPTIONS")) {
			httpResponse.setStatus(HttpServletResponse.SC_OK);
			return;
		}
		chain.doFilter(httpRequest, httpResponse);
	}
}