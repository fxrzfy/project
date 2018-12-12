package com.core.interceptors;

import com.alibaba.fastjson.JSON;
import com.core.model.checkmis.Person;
import com.core.pageModel.SessionInfo;
import com.core.service.CodelistDetailService;
import com.hzz.api.dto.ResultDto;
import com.util.ConfigUtil;
import com.util.SessionUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 权限拦截器
 * 
 * @author 孙宇
 * 
 */
public class SecurityInterceptor implements HandlerInterceptor {
	private static final Logger logger = Logger.getLogger(SecurityInterceptor.class);

	private List<String> excludeUrls;// 不需要拦截的资源
	
	private List<String> exclude;// 不需要拦截的资源
//	@Autowired
//	private ResourceServiceI resourceServiceI;
	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}
	
	public List<String> getExclude() {
		return exclude;
	}

	public void setExclude(List<String> exclude) {
		this.exclude = exclude;
	}

	@Autowired
	private CodelistDetailService codelistDetailService;
	/**
	 * 完成页面的render后调用
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) throws Exception {

	}

	/**
	 * 在调用controller具体方法后拦截
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 在调用controller具体方法前拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		if("/".equals(url)){
			return true;
		}
		for(String urls:exclude){
			if(url.indexOf(urls)>-1){
				return true;
			}
		}
		if (url.indexOf("/baseController/") > -1 || excludeUrls.contains(url)) {// 如果要访问的资源是不需要验证的
			return true;
		}
		if(url!=null){
			url=url.trim();
		}
		SessionInfo sessionInfo = SessionUtil.getSessionInfo();
		if(sessionInfo==null){
			ResultDto r=new ResultDto();
			r.setCode(30000);
			r.setMsg("请重新登陆");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(JSON.toJSONString(r));
			return false;

		}
		return true;
	}
}
