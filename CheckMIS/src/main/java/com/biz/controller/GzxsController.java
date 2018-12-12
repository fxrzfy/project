package com.biz.controller;

import com.biz.dto.gzxs.GzxsDto;
import com.core.model.checkmis.Gzxs;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.biz.service.GzxsService;
import com.hzz.api.dto.ResultDto;
import com.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("gzxs")
@Controller
public class GzxsController {

    @Autowired
    GzxsService gzxsService;

    @RequestMapping("list")
    @ResponseBody
    public ResultDto<DataPage<Gzxs>> gzxsList(Gzxs gzxs, PageHelper pageHelper){
        return AppUtil.returnSuccess(gzxsService.dataGrid(gzxs,pageHelper));
    }

    @RequestMapping("add")
    @ResponseBody
    public ResultDto add(@RequestBody  GzxsDto gzxsDto){
        gzxsService.add(gzxsDto);
        return AppUtil.returnSuccess();
    }

    @RequestMapping("get")
    @ResponseBody
    public ResultDto<GzxsDto> get(Long id){
        return AppUtil.returnSuccess(gzxsService.get(id));
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResultDto delete(String ids){
        if(!StringUtils.isEmpty(ids)){
            for(String id:ids.split(",")){
                gzxsService.delete(Long.valueOf(id));
            }
        }
        return AppUtil.returnSuccess();
    }
}
