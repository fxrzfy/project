package com.biz.controller;

import com.biz.dto.leave.QjsqDto;
import com.biz.service.LeaveService;
import com.common.constant.Constant;
import com.core.pageModel.DataPage;
import com.core.pageModel.Json;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;
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
@RequestMapping("leave")
public class LeaveController {
	@Autowired
	private LeaveService leaveService;

	@RequestMapping("/list")
	@ResponseBody
	public ResultDto<DataPage<QjsqDto>> dataGrid(QjsqDto role, PageHelper pageHelper) {
		SessionInfo info=SessionUtil.getSessionInfo();
		if(!info.hasRole(Constant.ROLE_QJ)){
			role.setWorkNumber(info.getWorkNumber());
		}
		return AppUtil.returnSuccess(leaveService.dataGrid(role,pageHelper));
	}

	@RequestMapping("/get")
	@ResponseBody
	public ResultDto<QjsqDto> get(Long id) {
		return AppUtil.returnSuccess(this.leaveService.get(id));
	}

	@RequestMapping("/addEdit")
	@ResponseBody
	public ResultDto<String> addEdit(HttpServletRequest request, QjsqDto qjsqDto) {
		SessionInfo info= SessionUtil.getSessionInfo();
		this.leaveService.saveUpdate(qjsqDto,info);
		return AppUtil.returnSuccess();
	}

	@RequestMapping("/del")
	@ResponseBody
	public ResultDto<String> del(HttpSession session,Long id) {
		leaveService.del(id);
		return AppUtil.returnSuccess();
	}

	@RequestMapping("/apply")
	@ResponseBody
	public ResultDto<String> apply(HttpSession session,Long id) {
		leaveService.apply(id,SessionUtil.getSessionInfo());
		return AppUtil.returnSuccess();
	}

	@RequestMapping("/check")
	@ResponseBody
	public ResultDto<String> check(HttpSession session,QjsqDto qjsqDto) {
		leaveService.check(qjsqDto,SessionUtil.getSessionInfo());
		return AppUtil.returnSuccess();
	}

}
