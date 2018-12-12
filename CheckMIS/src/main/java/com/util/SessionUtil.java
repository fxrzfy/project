package com.util;

import com.core.pageModel.SessionInfo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionUtil {
    private static ConcurrentHashMap mysession=new ConcurrentHashMap();
    public static void addSession(HttpSession httpSession){
        if(null!=httpSession){
            mysession.put(httpSession.getId(),httpSession);
        }
    }
    public static void removeSession(HttpSession session){
        if(null!=session){
            mysession.remove(session.getId());
        }
    }
    public static HttpSession getSession(String sessionId){
        HttpSession session= sessionId==null?null:(HttpSession)mysession.get(sessionId);
        if(session!=null){
            session.setAttribute("test","test");
        }else{
            session=getRequest().getSession();
        }
        return session;
    }
    public static SessionInfo getSessionInfo(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String sessionId=request.getParameter("sessionId");
        HttpSession session=getSession(sessionId);
        if(session==null){
            return null;
        }
        return (SessionInfo)session.getAttribute(ConfigUtil.getSessionInfoName());
    }
    public static void setSessionInfo(SessionInfo sessionInfo){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String sessionId=request.getParameter("sessionId");
        HttpSession session=getSession(sessionId);
        if(session==null){
            return;
        }
        session.setAttribute(ConfigUtil.getSessionInfoName(),sessionInfo);
    }
    public static HttpServletRequest getRequest(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }
    public static void SetFailStatus(){
        ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse().setStatus(560);
    }
}
