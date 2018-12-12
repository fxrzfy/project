package com.biz.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.biz.dto.GzzdDto;
import com.biz.dto.leave.QjsqDto;
import com.biz.service.GzzdService;
import com.biz.service.LeaveService;
import com.common.constant.Constant;
import com.core.model.checkmis.Gzzd;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;
import com.google.gson.JsonObject;
import com.hzz.api.dto.ResultDto;
import com.util.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;

@Controller
@RequestMapping("gzzd")
public class GzzdController {
    private Logger logger=Logger.getLogger(GzzdController.class);
    @Autowired
    private GzzdService gzzdService;

    @RequestMapping("/list")
    @ResponseBody
    public ResultDto<DataPage<QjsqDto>> dataGrid(GzzdDto role, PageHelper pageHelper) {
        SessionInfo info = SessionUtil.getSessionInfo();
        return AppUtil.returnSuccess(gzzdService.dataGrid(role, pageHelper));
    }

    @RequestMapping("/get")
    @ResponseBody
    public ResultDto<Gzzd> get(Long id) {
        return AppUtil.returnSuccess(this.gzzdService.get(id));
    }

    @RequestMapping("/addEdit")
    public void addEdit(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }

    @RequestMapping("/del")
    @ResponseBody
    public ResultDto<String> del(HttpSession session, Long id) {
        gzzdService.del(id);
        return AppUtil.returnSuccess();
    }

    @RequestMapping("/apply")
    @ResponseBody
    public ResultDto<String> apply(HttpSession session, Long id) {
        gzzdService.apply(id, SessionUtil.getSessionInfo());
        return AppUtil.returnSuccess();
    }

    @RequestMapping("/check")
    @ResponseBody
    public ResultDto<String> check(HttpSession session, Gzzd gzzd) {
        gzzdService.check(gzzd, SessionUtil.getSessionInfo());
        return AppUtil.returnSuccess();
    }

}
