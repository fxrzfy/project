package com.biz.controller;

import com.biz.dto.gzrw.ZdDmbDto;
import com.biz.service.ZszService;
import com.core.model.checkmis.ZdDmb;
import com.core.model.checkmis.ZzdwDmb;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;
import com.core.pageModel.Tree;
import com.hzz.api.dto.ResultDto;
import com.util.AppUtil;
import com.util.BaseException;
import com.util.ConfigUtil;
import com.util.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;


@RequestMapping("zsz")
@Controller
public class ZszCwdController {
    private Logger logger= LoggerFactory.getLogger(ZszCwdController.class);
    @Autowired
    private ZszService zszService;
    @RequestMapping("/tree")
    @ResponseBody
    public ResultDto<List<Tree>> tree(HttpSession session,String typestr) {
        SessionInfo sessionInfo = (SessionInfo) session.getAttribute(ConfigUtil.getSessionInfoName());
        return AppUtil.returnSuccess(zszService.tree(sessionInfo,typestr));
    }

    @RequestMapping("/addEdit")
    @ResponseBody
    public ResultDto<String> addEdit(ZzdwDmb zzdwDmb) {
        zszService.addEdit(zzdwDmb, SessionUtil.getSessionInfo());
        return AppUtil.returnSuccess();
    }

    @RequestMapping("/get")
    @ResponseBody
    public ResultDto<ZzdwDmb> get(Long id) {
        return AppUtil.returnSuccess(this.zszService.getById(id));
    }

    @RequestMapping("/del")
    @ResponseBody
    public ResultDto<String> del(Long id) {
        zszService.delZszById(id);
        return AppUtil.returnSuccess();
    }

    @RequestMapping("updateZd")
    @ResponseBody
    public ResultDto updateField(Long pk,String name,String value){
        try{
            ZdDmb zdDmb=new ZdDmb();
            Field f=ReflectionUtils.findField(ZdDmb.class,name);
            ReflectionUtils.makeAccessible(f);
            ReflectionUtils.setField(f,zdDmb,value);
            zdDmb.setId(pk);
            this.zszService.addEditZdSelecttive(zdDmb,SessionUtil.getSessionInfo());
            return AppUtil.returnSuccess();
        }catch (Exception e){
            if(!(e instanceof BaseException)){
                logger.error("保存失败",e);
            }
           // SessionUtil.SetFailStatus();
            return AppUtil.returnFail(e.getMessage());
        }

    }
    @RequestMapping("/getZd")
    @ResponseBody
    public ResultDto<ZzdwDmb> getZd(Long id) {
        return AppUtil.returnSuccess(this.zszService.getZdDmById(id));
    }

    @RequestMapping("/delZd")
    @ResponseBody
    public ResultDto<String> delZd(String ids,Long deptId) {
        zszService.delZDmById(ids,deptId);
        return AppUtil.returnSuccess();
    }
    @RequestMapping("/zdList")
    @ResponseBody
    public ResultDto<DataPage<ZdDmbDto>> delZd(ZdDmbDto zdDmb, PageHelper pageHelper) {
        return AppUtil.returnSuccess(zszService.datatGrid(zdDmb,pageHelper));
    }
    @RequestMapping("/suggestList")
    @ResponseBody
    public ResultDto<DataPage<ZdDmbDto>> delZd(String type,String name) {
        return AppUtil.returnSuccess(zszService.suggest(type,name));
    }
    @RequestMapping("/sync")
    @ResponseBody
    public ResultDto<String> sync(String type) {
        return AppUtil.returnSuccess(zszService.sync(type));
    }

    @RequestMapping("/listAll")
    @ResponseBody
    public ResultDto<Map> listAll(){
        return AppUtil.returnSuccess(zszService.listAll());
    }



}
