package com.core.controller;

import com.common.constant.Constant;
import com.core.dto.DropDownDto;
import com.hzz.api.dto.ResultDto;
import com.core.service.CodelistService;
import com.util.AppUtil;
import com.util.SessionConstantUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/dropDown")
public class DropDownController {
	private static final Logger logger = Logger.getLogger(DropDownController.class);

	@Autowired
	private CodelistService codelistService;


	@RequestMapping("/allMap")
	@ResponseBody
	public ResultDto<Map<String,List<DropDownDto>>> manager() {
	    if(SessionConstantUtil.isInit()){
            List<DropDownDto> dpList=this.codelistService.queryAll();
            Map<String,Map<String,String>>map=new HashMap<>();
            for(DropDownDto dp:dpList){
                SessionConstantUtil.addData(dp.getCode(),dp);
            }
            SessionConstantUtil.initDone();
        }
		return AppUtil.returnSuccess(SessionConstantUtil.allDropDown);
	}
}
