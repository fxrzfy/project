package com.api.controller;

import com.api.dto.ApiGzjlDto;
import com.biz.dto.gzjl.GzjhDto;
import com.biz.dto.gzjl.GzjlDto;
import com.biz.dto.gzjl.GzjlmxDto;
import com.biz.service.GzjlService;
import com.biz.service.GzrwService;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.hzz.api.dto.ResultDto;
import com.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("api/gzjl")
public class GzjlApiController {
    @Autowired
    private GzrwService gzrwService;
    @Autowired
    private GzjlService gzjlService;

    @RequestMapping("gzjlList")
    @ResponseBody
    public ResultDto<List<ApiGzjlDto>>gzjlList(){
        return AppUtil.returnAppSuccess(gzrwService.selectAppGzjlList());
    }
    @RequestMapping("lcjh")
    @ResponseBody
    public ResultDto<DataPage<GzjhDto>> lcjh(Long gzjlId,PageHelper pageHelper){
        GzjlmxDto gzjlmxDto=new GzjlmxDto();
        gzjlmxDto.setGzjlId(gzjlId);
        gzjlmxDto.setType("cz");
        return AppUtil.returnAppSuccess(gzjlService.selectGzjlmx(gzjlmxDto));
    }
    @RequestMapping("czjh")
    @ResponseBody
    public ResultDto<DataPage<GzjhDto>> czjh(Long gzjlId,PageHelper pageHelper){
        GzjlmxDto gzjlmxDto=new GzjlmxDto();
        gzjlmxDto.setGzjlId(gzjlId);
        gzjlmxDto.setType("lc");
        return AppUtil.returnAppSuccess(gzjlService.selectGzjlmx(gzjlmxDto));
    }
    @RequestMapping("mxList")
    @ResponseBody
    public ResultDto<DataPage<GzjhDto>> ryList(Long gzjlId){
        GzjlmxDto gzjlmxDto=new GzjlmxDto();
        gzjlmxDto.setGzjlId(gzjlId);
        return AppUtil.returnAppSuccess(gzjlService.selectGzjlmx(gzjlmxDto));
    }

}
