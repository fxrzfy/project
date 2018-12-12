package com.core.controller;

import com.core.model.checkmis.Unit;
import com.core.pageModel.DataGrid;
import com.core.pageModel.Json;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;
import com.core.service.UnitService;
import com.hzz.api.dto.ResultDto;
import com.util.AppUtil;
import com.util.ConfigUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * <p>Description: 单位信息 Controller类</p>
 * Created on 
 * @author
 * @version 1.0
 */
@Controller
@RequestMapping("/unitController")
public class UnitController  {
	private static final Logger logger = Logger.getLogger(UnitController.class);

	@Autowired
	private UnitService unitService;

	/**
	 * <p>Discription:页面跳转单位信息信息</p>
	 * @return String
	 * @author:
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	@RequestMapping("/manager")
	public String manager() {
		return "/pages/hzz/admin/unit/index";
	}

    @RequestMapping("/tree")
    @ResponseBody
    public ResultDto tree(HttpSession session, String type) {
        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
        return AppUtil.returnSuccess(unitService.tree(sessionInfo, type));
    }

    /**
	 * <p>Discription:分页查询单位信息</p>
	 * @param unit,page
	 * @return DataGrid
	 * @author:
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	@RequestMapping("/dataGrid")
	@ResponseBody
	public DataGrid dataGrid(Unit unit, PageHelper page) {
		return unitService.queryList(unit, page);
	}

    @RequestMapping("/get")
    @ResponseBody
    public ResultDto get(HttpSession session,Long id) {
		return AppUtil.returnSuccess(unitService.get(id));
    }

	/**
	 * <p>Discription:添加单位信息</p>
	 * @param unit,request
	 * @return Json
	 * @author:
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	@RequestMapping("/save")
	@ResponseBody
	public ResultDto save(Unit unit) {
		try {
            unitService.save(unit);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return AppUtil.returnFail(e.getMessage());
		}
		return AppUtil.returnSuccess(unit);
	}



	/**
	 * <p>Discription:删除单位信息</p>
	 * @param id,session
	 * @return Json
	 * @author:
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public ResultDto delete(Long id, HttpSession session) {
		try {
			if (id != null) {
				unitService.delete(id);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			AppUtil.returnFail(e.getMessage());
		}
		return AppUtil.returnSuccess();
	}

	/**
	 * <p>Discription:批量删除单位信息</p>
	 * @param ids('0','1','2'),session
	 * @return Json
	 * @author:
	 * @update:[日期YYYY-MM-DD] [更改人姓名][变更描述]
	 */
	@RequestMapping("/batchDelete")
	@ResponseBody
	public Json batchDelete(String ids, HttpSession session) {
		Json j = new Json();
		if (ids != null && ids.length() > 0) {
			try {
				unitService.deleteBatch(ids);
				j.setMsg("批量删除成功！");
				j.setSuccess(true);
			} catch (Exception e) {
				j.setMsg(e.getMessage());
				logger.error(e.getMessage());
			}
		}
		return j;
	}

}
