package com.core;

import com.alibaba.fastjson.JSON;
import com.util.AppUtil;
import com.util.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


@Component
public class SystemExceptionHandler implements HandlerExceptionResolver {
	private Logger logger= LoggerFactory.getLogger(SystemExceptionHandler.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
        try {

			response.setCharacterEncoding("utf-8");
			if( !(ex instanceof BaseException)){
				logger.error("系统异常:"+handler.getClass(),ex);
			}
			boolean isApp=false;
			HandlerMethod hm=(HandlerMethod)handler;
			if(null!=hm){
				Method m=hm.getMethod();
				if(m.getDeclaringClass().getName().startsWith("com.api.controller")){
					isApp=true;
				}
			}
			if(isApp){
				response.getWriter().write(JSON.toJSONString(AppUtil.returnAppFail(ex.getMessage())));
			}else{
				response.getWriter().write(JSON.toJSONString(AppUtil.returnFail(ex.getMessage())));
			}
			response.getWriter().flush();
			response.getWriter().close();
		} catch (Exception e) {
			logger.error("异常处理时,出现异常", e);
		}
        return null;
	}

}
