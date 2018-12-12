package com.biz.controller;

import com.biz.service.JcflService;
import com.core.model.checkmis.JcflDmb;
import com.core.model.checkmis.Jcxdsx;
import com.core.pageModel.PageHelper;
import com.hzz.api.dto.ResultDto;
import com.util.AppUtil;
import org.apache.cxf.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("jcfl")
@Controller
public class JcflController {

    @Autowired
    JcflService jcflService;

    @RequestMapping("list")
    @ResponseBody
    public ResultDto<List<JcflDmb>> list(String type){
        return AppUtil.returnAppSuccess(jcflService.list(type));
    }

    @RequestMapping("add")
    @ResponseBody
    public ResultDto add(JcflDmb jcflDmb){
        jcflService.add(jcflDmb);
        return AppUtil.returnSuccess();
    }

    @RequestMapping("delete")
    @ResponseBody
    public ResultDto delete(Long id){
        jcflService.delete(id);
        return AppUtil.returnSuccess();
    }

    @RequestMapping("get")
    @ResponseBody
    public ResultDto get(Long id){
        return AppUtil.returnSuccess(jcflService.get(id));
    }

    @RequestMapping("detail")
    @ResponseBody
    public ResultDto detail(Long jcflId, PageHelper pageHelper){
        return AppUtil.returnSuccess(jcflService.detail(jcflId, pageHelper));
    }

    @RequestMapping("addDetail")
    @ResponseBody
    public ResultDto addDetail(Jcxdsx jcxdsx){
        jcflService.addDetail(jcxdsx);
        return AppUtil.returnSuccess();
    }

    @RequestMapping("deleteDetail")
    @ResponseBody
    public ResultDto deleteDetail(String ids){
        if(!StringUtils.isEmpty(ids)){
            String[] idArray = ids.split(",");
            for(String id : idArray){
                jcflService.deleteDetail(Long.valueOf(id));
            }
        }
        return AppUtil.returnSuccess();
    }
}
