package com.core.controller;

import com.common.exception.BizException;
import com.core.dto.PersonDto;
import com.core.model.checkmis.Person;
import com.core.model.checkmis.Role;
import com.core.pageModel.Json;
import com.core.pageModel.SessionInfo;
import com.core.service.DeptService;
import com.core.service.UserService;
import com.hzz.api.dto.ResultDto;
import com.util.AppUtil;
import com.util.ConfigUtil;
import com.util.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
	private Logger logger=Logger.getLogger(UserController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private DeptService deptService;
	@ResponseBody
	@RequestMapping("/login")
	public ResultDto<Person> login(PersonDto user, HttpSession session, String apptype,HttpServletRequest request, HttpServletResponse response) throws BizException {
		try {
			PersonDto u = userService.login(user);
			u.setPassword(null);
			SessionInfo info = new SessionInfo();
			info.setName(u.getName());
			info.setWorkNumber(u.getWorkNumber());
			info.setPerson(u);
			if (u.getDeptId() != null) {
				info.setDeptId(u.getDeptId());
				info.setDeptName(deptService.get(u.getDeptId()).getName());
			}
			Map<String, String> map = new HashMap<>();
			if(null!=u.getRoles()){
				for(Role r:u.getRoles()){
					map.put(r.getRoleCode(), r.getRoleName());
				}
			}
			info.setRoleMap(map);
			info.setId(u.getId());
			info.setSessionId(session.getId());
			request.getSession().setAttribute(ConfigUtil.getSessionInfoName(), info);
			if (StringUtil.isEmpty(apptype)) {
				return AppUtil.returnSuccess(info);
			} else {
				info.setSessionId(request.getSession().getId());
				return AppUtil.returnAppSuccess(info);
			}
		}catch(Exception e){
			if(StringUtil.isEmpty(apptype)){
				throw  e;
			}
			return AppUtil.returnAppFail(e.getMessage());
		}
	}

	/**
	 * 注销用户
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/logout")
	public ResultDto<String> logout(HttpSession session) {
		session.invalidate();
		return AppUtil.returnSuccess();
	}

	/**
	 * 注销用户
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/resetAdmin")
	public ResultDto<String> resetAdmin(HttpSession session) {
		this.userService.resetAdmin();
		return AppUtil.returnSuccess();
	}
	
	/**
	 * 首页调整到修改登录用户密码
	 * 
	 * @return
	 */
	@RequestMapping("/editCurrentUserPwdPage")
	public String editCurrentUserPwdPage() {
		return "/user/userEditPwd";
	}

	/**
	 * 修改自己的密码
	 * 
	 * @param session
	 * @param pwd
	 * @return
	 */
	@RequestMapping("/editCurrentUserPwd")
	@ResponseBody
	public Json editCurrentUserPwd(HttpSession session, String oldPwd, String pwd) {
		Json j = new Json();
		if (session != null) {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
			if (sessionInfo != null) {
				if (userService.editCurrentUserPwd(sessionInfo, oldPwd, pwd)) {
					j.setSuccess(true);
					j.setMsg("编辑密码成功，下次登录生效！");
				} else {
					j.setMsg("原密码错误！");
				}
			} else {
				j.setMsg("登录超时，请重新登录！");
			}
		} else {
			j.setMsg("登录超时，请重新登录！");
		}
		return j;
	}
	@RequestMapping("/")
	public String index(){
		return "redirect:view/index.html";
	}
}
