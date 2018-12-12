package com.biz.controller;

import com.alibaba.fastjson.JSON;
import com.biz.dto.gzjl.*;
import com.biz.dto.gzrw.GzrwDto;
import com.biz.dto.gzrw.GzrwXzDto;
import com.biz.service.GzjlService;
import com.biz.service.GzrwService;
import com.core.dto.PersonDto;
import com.core.model.checkmis.*;
import com.core.pageModel.DataPage;
import com.core.pageModel.Json;
import com.core.pageModel.PageHelper;
import com.core.service.UserService;
import com.hzz.api.dto.ResultDto;
import com.util.AppUtil;
import com.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RequestMapping("gzjl")
@Controller
public class GzjlController {

    @Autowired
    private GzrwService gzrwService;
    @Autowired
    private UserService userService;
    @Autowired
    private GzjlService gzjlService;

    @RequestMapping("getById")
    @ResponseBody
    public ResultDto<GzjlDto> getById(Long id,Long gzrwId,Long gzrwxzId){
        return AppUtil.returnSuccess(gzjlService.getById(id,gzrwId,gzrwxzId,SessionUtil.getSessionInfo()));
    }

    @RequestMapping("addEditGzjl")
    @ResponseBody
    public ResultDto<String> addEditGzjl(GzjlDto gzjl){
        this.gzjlService.addEditGzjl(gzjl,SessionUtil.getSessionInfo());
        return AppUtil.returnSuccess(gzjl);
    }

    @RequestMapping("addGzjlMx")
    @ResponseBody
    public ResultDto<String> addGzjlMx(GzjlmxDto gzjlmxDto){
        System.out.println(JSON.toJSONString(gzjlmxDto));
        this.gzjlService.addGzjlmx(gzjlmxDto,SessionUtil.getSessionInfo());
        return AppUtil.returnSuccess();
    }



    @RequestMapping("deleteGzjl")
    @ResponseBody
    public ResultDto<String> deleteGzjl(Long id){
        this.gzjlService.deleteGzjl(id,SessionUtil.getSessionInfo());
        return AppUtil.returnSuccess();
    }

    @RequestMapping("deleteGzjlMx")
    @ResponseBody
    public ResultDto<String> deleteGzjlMx(Long id){
        this.gzjlService.deleteGzjlMx(id);
        return AppUtil.returnSuccess();
    }

    @RequestMapping("getGzmxById")
    @ResponseBody
    public ResultDto<Gzjlmx> getGzmxById(Long id ){
        return AppUtil.returnSuccess(gzjlService.getGzmxById(id));
    }

    @RequestMapping("gzjlmxList")
    @ResponseBody
    public ResultDto<DataPage<GzjhDto>> ryList(GzjlmxDto gzjlmxDto){
        if(gzjlmxDto.getId()==null){
            return  AppUtil.returnSuccess(new DataPage<>());
        }
        gzjlmxDto.setGzjlId(gzjlmxDto.getId());
        gzjlmxDto.setId(null);
        return AppUtil.returnSuccess(gzjlService.selectGzjlmx(gzjlmxDto));
    }

    @RequestMapping("selectJccz")
    @ResponseBody
    public ResultDto<DataPage<GzjlJccz>> selectJccz(GzjlmxDto gzjlmxDto){
         if(gzjlmxDto.getId()==null){
             return  AppUtil.returnSuccess(new DataPage<>());
         }
        return AppUtil.returnSuccess(gzjlService.selectJccz(gzjlmxDto,new PageHelper()));
    }


    @RequestMapping("selectJclc")
    @ResponseBody
    public ResultDto<DataPage<Gzjljclc>> selectJclc(GzjlmxDto gzjlmxDto){
        if(gzjlmxDto.getId()==null){
            return  AppUtil.returnSuccess(new DataPage<>());
        }
        return AppUtil.returnSuccess(this.gzjlService.selectJclc(gzjlmxDto,new PageHelper()));
    }

    @RequestMapping("apply")
    @ResponseBody
    public ResultDto<String> apply(Long id){
        this.gzjlService.apply(id,SessionUtil.getSessionInfo());
        return AppUtil.returnSuccess();
    }

    @RequestMapping("copy")
    @ResponseBody
    public ResultDto<String> copy(Long id,Long xzid){
        this.gzjlService.copy(id,xzid,SessionUtil.getSessionInfo());
        return AppUtil.returnSuccess();
    }

    @RequestMapping("getCheckData")
    @ResponseBody
    public ResultDto<GzjlCheckDto> getCheckData(String ids){
        return AppUtil.returnSuccess( this.gzjlService.getCheckData(ids,SessionUtil.getSessionInfo()));
    }
    @RequestMapping("check")
    @ResponseBody
    public ResultDto<GzjlCheckDto> getCheckData(@RequestBody BatchGzjl batchGzjl){
        gzjlService.check(batchGzjl,SessionUtil.getSessionInfo());
        return AppUtil.returnSuccess();
    }


}
