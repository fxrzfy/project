package com.core.controller;

import com.core.model.checkmis.Role;
import com.core.pageModel.DataPage;
import com.core.pageModel.Json;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;
import com.core.service.RoleService;
import com.hzz.api.dto.ResultDto;
import com.util.AppUtil;
import com.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("roleController")
public class RoleController {
	@Autowired
	private RoleService roleService ;

	@RequestMapping("/dataGrid")
	@ResponseBody
	public ResultDto<DataPage<Role>> dataGrid(Role role, PageHelper pageHelper) {
		return AppUtil.returnSuccess(roleService.dataGrid(role,pageHelper));
	}
	@RequestMapping("/get")
	@ResponseBody
	public ResultDto<Role> get(Long id) {
		return AppUtil.returnSuccess(this.roleService.get(id));
	}
	@RequestMapping("/saveUpdate")
	@ResponseBody
	public ResultDto<String> saveUpdate(HttpServletRequest request, Role role) {
		SessionInfo info= SessionUtil.getSessionInfo();
		this.roleService.saveUpdate(role,info);
		return AppUtil.returnSuccess();
	}
	@RequestMapping("/del")
	@ResponseBody
	public  ResultDto<String> del(HttpSession session,String ids) {
		roleService.del(ids);
		return AppUtil.returnAppSuccess("");
	}
	@RequestMapping("/grant")
	@ResponseBody
	public Json grant(HttpSession session,String  roleId,String ids) {
		Json j=new Json(true);
		roleService.grant(roleId, ids);
		j.setMsg("保存成功");
		return j;
	}
}
