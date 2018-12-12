package com.api.controller;

import com.api.dto.ApiGzjlDto;
import com.biz.dto.gzrw.GzrwDto;
import com.biz.dto.gzrw.GzrwxzcyDto;
import com.biz.service.AppMessageService;
import com.core.model.checkmis.AppMessage;
import com.core.pageModel.PageHelper;
import com.hzz.api.dto.ResultDto;
import com.util.AppUtil;
import com.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("api/message")
public class MessageApiController {
    @Autowired
    private AppMessageService appMessageService;
    @RequestMapping("msglist")
    @ResponseBody
    public ResultDto<List<AppMessage>> list(String type, PageHelper pageHelper)
    {
        pageHelper.initApi();
        return AppUtil.returnAppSuccess(appMessageService.selectMessage(type,pageHelper, SessionUtil.getSessionInfo()));
    }

    @RequestMapping("readMsgAll")
    @ResponseBody
    public ResultDto<List<ApiGzjlDto>> gzjlList(String type){
        appMessageService.readAll(type,SessionUtil.getSessionInfo());
        return AppUtil.returnAppSuccess("");
    }

    @RequestMapping("msgCount")
    @ResponseBody
    public ResultDto<Map<String,Integer>> msgCount(){
        return AppUtil.returnAppSuccess(appMessageService.messageCount(SessionUtil.getSessionInfo()));
    }
    @RequestMapping("readAll")
    @ResponseBody
    public ResultDto<Map<String,Integer>> readAll(String type){
        appMessageService.readAll(type,SessionUtil.getSessionInfo());
        return AppUtil.returnAppSuccess("");
    }

    @RequestMapping("qjList")
    @ResponseBody
    public ResultDto<Map<String,Integer>> qjList(String type, PageHelper pageHelper){
        pageHelper.initApi();
        return AppUtil.returnAppSuccess(appMessageService.selectQjMessage(pageHelper,SessionUtil.getSessionInfo()));
    }

    @RequestMapping("jlList")
    @ResponseBody
    public ResultDto<Map<String,Integer>> jlList(String type, PageHelper pageHelper){
        pageHelper.initApi();
        return AppUtil.returnAppSuccess(appMessageService.selectJlMessage(pageHelper,SessionUtil.getSessionInfo()));
    }

    @RequestMapping("rwList")
    @ResponseBody
    public ResultDto<Map<String,Integer>> rwList(String type, PageHelper pageHelper){
        pageHelper.initApi();
        return AppUtil.returnAppSuccess(appMessageService.selectRWMessage(pageHelper,SessionUtil.getSessionInfo()));
    }
    @RequestMapping("getRwDetail")
    @ResponseBody
    public ResultDto<GzrwDto> getRwDetail(Long id){
        return AppUtil.returnAppSuccess(appMessageService.selectRwDteail(id));
    }





}
