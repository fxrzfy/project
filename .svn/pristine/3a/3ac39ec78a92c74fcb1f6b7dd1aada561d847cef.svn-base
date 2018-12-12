package com.core.interceptors;

import com.util.StringUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

public class OpofficeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ServletRequest requestWrapper = null;

        if(request instanceof HttpServletRequest) {
            HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            String uri=httpServletRequest.getRequestURI();
            boolean flag=false;
            System.out.println(uri);
            if(!StringUtil.isEmpty(uri) && uri.indexOf("gzzd/addEdit")!=-1){
                flag=true;
            }
            if("POST".equals(httpServletRequest.getMethod().toUpperCase())&& flag){
                System.out.println("=====================change=====================");
                requestWrapper = new BodyReaderHttpServletRequestWrapper((HttpServletRequest) request);
            }
        }
        if(requestWrapper == null) {
            chain.doFilter(request, response);
        } else {
            response=new HttpServletResponseWrapper((HttpServletResponse) response);
            chain.doFilter(requestWrapper, response);    //替换！
        }
    }

    @Override
    public void destroy() {

    }
}
