package com.biz.controller;

import com.biz.service.LqsknrService;
import com.biz.service.WentiService;
import com.core.model.checkmis.LqsknrflDmb;
import com.core.model.checkmis.LqsknrxdDmb;
import com.core.model.checkmis.WtflDmb;
import com.core.model.checkmis.WtxdDmb;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;
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
@RequestMapping("lqsk")
public class LqsknrController {
    @Autowired
    private LqsknrService wentiService;
    @RequestMapping("/tree")
    @ResponseBody
    public ResultDto<List<LqsknrflDmb>> tree(HttpSession session, String type) {
        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
        return AppUtil.returnSuccess(wentiService.tree(type));
    }

    @RequestMapping("/list")
    @ResponseBody
    public ResultDto<DataPage<LqsknrxdDmb>> wtxList(HttpSession session, LqsknrxdDmb wtxdDmb, PageHelper pageHelper) {
        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
        return AppUtil.returnSuccess(wentiService.wtxList(wtxdDmb,pageHelper));
    }

    @RequestMapping("/addFl")
    @ResponseBody
    public ResultDto<String> addWtFl(LqsknrflDmb wtflDmb) {
        wentiService.addWtfl(wtflDmb,SessionUtil.getSessionInfo());
        return AppUtil.returnSuccess();
    }

    @RequestMapping("/addXD")
    @ResponseBody
    public ResultDto<String> addWtXD(LqsknrxdDmb wtxdDmb) {
        wentiService.addWtXd(wtxdDmb,SessionUtil.getSessionInfo());
        return AppUtil.returnSuccess();
    }
    @RequestMapping("/delFl")
    @ResponseBody
    public ResultDto<String> addWtFl(Long id) {
        wentiService.delWtFl(id);
        return AppUtil.returnSuccess();
    }

    @RequestMapping("/delXD")
    @ResponseBody
    public ResultDto<String> addWtXD(String ids) {
        for(String s:ids.split(",")){
            wentiService.delWtxd(Long.parseLong(s));
        }
        return AppUtil.returnSuccess();
    }


}
