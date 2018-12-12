package com.biz.controller;

import com.biz.service.WentiService;
import com.core.model.checkmis.WtflDmb;
import com.core.model.checkmis.WtxdDmb;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;
import com.core.pageModel.Tree;
import com.hzz.api.dto.ResultDto;
import com.util.AppUtil;
import com.util.ConfigUtil;
import com.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("wenti")
public class WentiController {
    @Autowired
    private WentiService wentiService;
    @RequestMapping("/tree")
    @ResponseBody
    public ResultDto<List<WtflDmb>> tree(HttpSession session, String type) {
        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
        return AppUtil.returnSuccess(wentiService.tree(type));
    }

    @RequestMapping("/wtxList")
    @ResponseBody
    public ResultDto<DataPage<WtflDmb>> wtxList(HttpSession session, WtxdDmb wtxdDmb, PageHelper pageHelper) {
        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
        return AppUtil.returnSuccess(wentiService.wtxList(wtxdDmb,pageHelper));
    }

    @RequestMapping("/addWtFl")
    @ResponseBody
    public ResultDto<String> addWtFl(WtflDmb wtflDmb) {
        wentiService.addWtfl(wtflDmb,SessionUtil.getSessionInfo());
        return AppUtil.returnSuccess();
    }

    @RequestMapping("/addWtXD")
    @ResponseBody
    public ResultDto<String> addWtXD(WtxdDmb wtxdDmb) {
        wentiService.addWtXd(wtxdDmb,SessionUtil.getSessionInfo());
        return AppUtil.returnSuccess();
    }
    @RequestMapping("/delWtFl")
    @ResponseBody
    public ResultDto<String> addWtFl(Long id) {
        wentiService.delWtFl(id);
        return AppUtil.returnSuccess();
    }

    @RequestMapping("/delWtXD")
    @ResponseBody
    public ResultDto<String> addWtXD(String ids) {
        for(String s:ids.split(",")){
            wentiService.delWtxd(Long.parseLong(s));
        }
        return AppUtil.returnSuccess();
    }


}
