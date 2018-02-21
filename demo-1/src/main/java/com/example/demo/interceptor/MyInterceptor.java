package com.example.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

	static Logger logger = Logger.getLogger(MyInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		logger.info(request.getMethod());
		logger.info(request.getScheme());
		logger.info("########### preHandle");

		HttpSession httpSession = request.getSession();
		logger.info("email : " + httpSession.getAttribute("email"));

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("########### postHandle");

		HttpSession httpSession = request.getSession();
		logger.info("email : " + httpSession.getAttribute("email"));

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("########### afterCompletion");

		HttpSession httpSession = request.getSession();
		logger.info("email : " + httpSession.getAttribute("email"));

	}

}
