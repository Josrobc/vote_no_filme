package br.com.bluesoft.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class FilterPage implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object controller) throws Exception {
		// TODO Auto-generated method stub
		
		Long parametro;
		Long parametro2;

		try{
			parametro  = Long.parseLong(request.getParameter("selectfilmes"));
		} catch (NumberFormatException e){
			parametro  = (long) 0;
		}
		try{
			parametro2 = Long.parseLong(request.getParameter("id"));
		} catch (NumberFormatException e){
			parametro2 = (long) 0;
		}
		
		if (request.getRequestURI().endsWith("/") 
				|| parametro < 99999998 && parametro > 0
				|| parametro2 == 1){
			return true;
		}

		response.sendRedirect(".");
		return false;
	}
}
