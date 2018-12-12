package com.api.controller;

import com.api.dto.ApiGzrwDto;
import com.biz.dto.gzrw.GzrwXzDto;
import com.biz.service.GzrwService;
import com.core.dto.PersonDto;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.service.UserService;
import com.hzz.api.dto.ResultDto;
import com.util.AppUtil;
import com.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("api/gzrw")
public class GzrwApiController {
    @Autowired
    private GzrwService gzrwService;
    @Autowired
    private UserService userService;

    @RequestMapping("currentList")
    @ResponseBody
    public ResultDto<DataPage<ApiGzrwDto>> currentList(String workNumber, PageHelper pageHelper){
        pageHelper.initApi();
        return AppUtil.returnAppSuccess(gzrwService.currentList(workNumber,"true",pageHelper));
    }
    @RequestMapping("history")
    @ResponseBody
    public ResultDto<DataPage<ApiGzrwDto>> history(String workNumber, PageHelper pageHelper){
        pageHelper.initApi();
        return AppUtil.returnAppSuccess(gzrwService.currentList(workNumber,null,pageHelper));
    }
    @RequestMapping("sign")
    @ResponseBody
    public ResultDto<String> sign(Long id, PageHelper pageHelper){
        gzrwService.sign(id, SessionUtil.getSessionInfo());
        return AppUtil.returnAppSuccess("");
    }
    @RequestMapping("freeList")
    @ResponseBody
    public ResultDto<DataPage<PersonDto>> ryList( PersonDto personDto, PageHelper pageHelper, HttpServletRequest request){
        pageHelper.initApi();
        //personDto.setXzId(gzrwXzDto.getId());
        personDto.setIsSelectEd(0);
       // personDto.setGzrwId(gzrwXzDto.getGzrwId());
        return AppUtil.returnAppSuccess(userService.getUserForGzrw(personDto));
    }
    @RequestMapping("releaseXzcy")
    @ResponseBody
    public ResultDto<String> freeXzcy(Long id){
        this.gzrwService.freeXzcy(id);
        return AppUtil.returnAppSuccess("");
    }
    @RequestMapping("addXzcys")
    @ResponseBody
    public ResultDto<String> addXzcys(String ids,Long xzId){
        this.gzrwService.addGzrwxzcys(ids,xzId,SessionUtil.getSessionInfo());
        return AppUtil.returnAppSuccess("");
    }

}
