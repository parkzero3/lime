package com.lime.util;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoggerInterceptor implements  HandlerInterceptor{

	private static final Logger logger = Logger.getLogger(LoggerInterceptor.class);


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 로그인 여부를 확인-> 로그인 된 경우 계속 실행, 로그인 안 된 경우 컨트롤러 실행을 중지한다.
		HttpSession session = request.getSession();
		Object user = session.getAttribute("user");
		// 로그인이 안 된 경우 로그인 폼으로 보냄. 현재 진행을 중단 시킴
		if (user == null ) {
			response.sendRedirect(request.getContextPath()+"/");
			return false;
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		logger.debug("======================================          START         ======================================");
    	logger.debug(" Request URI \t:  " + request.getRequestURI());


	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		logger.debug("======================================           END          ======================================\n");



	}

}
