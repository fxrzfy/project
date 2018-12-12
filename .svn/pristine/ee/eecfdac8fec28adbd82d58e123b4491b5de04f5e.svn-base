package com.core.controller;

import com.core.model.checkmis.Dept;
import com.core.service.DeptService;
import com.hzz.api.dto.ResultDto;
import com.util.AppUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

/**
 * <p>Description: 部门信息 Controller类</p>
 * Created on 
 * @author
 * @version 1.0
 */
@Controller
@RequestMapping("/deptController")
public class DeptController  {
	private static final Logger logger = Logger.getLogger(DeptController.class);

	@Autowired
	private DeptService deptService;

	/**
	 * <p>Discription:页面跳转部门信息信息</p>
	 * @return String
	 * @author:
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	@RequestMapping("/manager")
	public String manager() {
		return "/pages/hzz/admin/dept/index";
	}

    @RequestMapping("/tree")
    @ResponseBody
    public ResultDto tree(){
        return AppUtil.returnSuccess(deptService.tree(null));
    }

	@RequestMapping("/list")
	@ResponseBody
	public ResultDto list(BigDecimal type){
		return AppUtil.returnSuccess(deptService.list(type));
	}

	@RequestMapping("/get")
    @ResponseBody
    public ResultDto get(Long id){
        return AppUtil.returnSuccess(deptService.get(id));
    }

	/**
	 * <p>Discription:添加部门信息</p>
	 * @param dept,request
	 * @return Json
	 * @author:
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	@RequestMapping("/save")
	@ResponseBody
	public ResultDto add(Dept dept) {
		try {
			deptService.save(dept);
		} catch (Exception e) {
			return AppUtil.returnFail(e.getMessage());
		}
		return AppUtil.returnSuccess(dept);
	}


	/**
	 * <p>Discription:删除部门信息</p>
	 * @param id,session
	 * @return Json
	 * @author:
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public ResultDto delete(Long id) {
		try {
			if (id != null) {
				deptService.delete(id);
			}
		} catch (Exception e) {
			return AppUtil.returnFail(e.getMessage());
		}
		return AppUtil.returnSuccess();
	}



}
