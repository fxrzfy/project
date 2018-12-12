package com.biz.controller;

import com.biz.dto.gzjlsc.GzxsGroupDetailDto;
import com.biz.dto.gzjlsc.GzxsGroupDto;
import com.biz.service.GzjlscService;
import com.core.model.checkmis.Gzjlsc;
import com.core.model.checkmis.Gzxs;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.biz.service.GzxsService;
import com.hzz.api.dto.ResultDto;
import com.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("gzjlsc")
@Controller
public class GzjlscController {

    @Autowired
    GzjlscService gzjlscService;

    @Autowired
    GzxsService gzxsService;

    @RequestMapping("dataGrid")
    @ResponseBody
    public ResultDto<DataPage<Gzjlsc>> dataGrid(Gzjlsc gzjlsc, PageHelper pageHelper){
        return AppUtil.returnSuccess(gzjlscService.dataGrid(gzjlsc,pageHelper));
    }

    @RequestMapping("grouplist")
    @ResponseBody
    public ResultDto<DataPage<GzxsGroupDto>> groupList(Gzxs gzxs, PageHelper pageHelper){
        return AppUtil.returnSuccess(gzxsService.groupList(gzxs, pageHelper));
    }

    @RequestMapping("groupDetail")
    @ResponseBody
    public ResultDto<GzxsGroupDetailDto> groupDetail(String ids){
        return AppUtil.returnSuccess(gzxsService.groupDetail(ids));
    }
}
