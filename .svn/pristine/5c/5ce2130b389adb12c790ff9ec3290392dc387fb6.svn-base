package com.core.controller;

import com.common.constant.Constant;
import com.core.dto.SysMenu;
import com.core.model.checkmis.Resources;
import com.core.pageModel.SessionInfo;
import com.core.pageModel.Tree;
import com.core.service.ResourcesService;
import com.hzz.api.dto.ResultDto;
import com.util.AppUtil;
import com.util.ConfigUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("resourcesController")
public class ResourcesController {
	@Autowired
	private ResourcesService resourcesService ;

	@RequestMapping("/tree")
	@ResponseBody
	public ResultDto<List<Tree>> tree(HttpSession session,String roleId) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
		return AppUtil.returnSuccess(resourcesService.tree(sessionInfo,roleId));
	}

	@RequestMapping("/loanMenu")
	@ResponseBody
	public ResultDto<List<SysMenu>> loanMenu(HttpSession session, String type) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
		ResultDto<List<SysMenu>> r=new ResultDto<List<SysMenu>>();
		r.setCode(10000);
		r.setData(resourcesService.loadTree(sessionInfo, Constant.RESOURCES_MENU));
		return r;
	}


	@RequestMapping("/get")
	@ResponseBody
	public ResultDto<Resources> get(HttpSession session, Long id) {
		return AppUtil.returnSuccess(resourcesService.get(id));
	}

	@RequestMapping("/add")
	@ResponseBody
	public ResultDto<Resources> add(HttpSession session, Resources resources) {
		resourcesService.saveOrUpdate(resources);
		return AppUtil.returnSuccess("");
	}

	@RequestMapping("/update")
	@ResponseBody
	public ResultDto<Resources> update(HttpSession session, Resources resources) {
		resourcesService.saveOrUpdate(resources);
		return AppUtil.returnSuccess("");
	}

	@RequestMapping("/del")
	@ResponseBody
	public ResultDto<Resources> del(HttpSession session, Long id) {
		resourcesService.del(id);
		return AppUtil.returnSuccess("");
	}

}
