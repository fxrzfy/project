package com.api.controller;

import com.api.dto.ApiGzjlDto;
import com.biz.dto.GzzdDto;
import com.biz.dto.gzjl.GzjhDto;
import com.biz.dto.gzjl.GzjlmxDto;
import com.biz.service.GzjlService;
import com.biz.service.GzrwService;
import com.biz.service.GzzdService;
import com.core.model.checkmis.GzzdExample;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.hzz.api.dto.ResultDto;
import com.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("api/gzzd")
public class GzzdApiController {
    @Autowired
    private GzzdService gzzdService;

    @RequestMapping("list")
    @ResponseBody
    public ResultDto<List<GzzdDto>>gzzdList(GzzdDto gzzdDto,PageHelper pageHelper){
        return AppUtil.returnAppSuccess(gzzdService.dataGrid(gzzdDto,pageHelper));
    }

}
