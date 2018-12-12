package com.core.controller;

import com.alibaba.fastjson.JSON;
import com.core.model.checkmis.CodeList;
import com.core.model.checkmis.CodeListDetail;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.Tree;
import com.core.service.CodelistService;
import com.hzz.api.dto.ResultDto;
import com.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("codeList")
@Controller
public class CodeListController {
    private static Map<String,CodeList>staticmap=new HashMap<>();
    static{//初始化的数据
        CodeList c=new CodeList();
        c.setCode("individual_team");
        c.setName("组别字典");
        staticmap.put(c.getCode(),c);
    }
    @Autowired
    private CodelistService codelistService;

    @RequestMapping("singleList")
    @ResponseBody
    public ResultDto<DataPage<CodeListDetail>> singleList(CodeListDetail codeListDetail, String pcode,PageHelper pageHelper){
        if(StringUtil.isEmpty(pcode)){//
            throw  new BaseException("pcode不能为空");
        }
        CodeList cl=this.codelistService.queryByCode(pcode);
        if(null==cl){
            codeListDetail.setMasterid(-1l);
        }else{
            codeListDetail.setMasterid(cl.getId());
        }
        return AppUtil.returnSuccess(this.codelistService.queryList(codeListDetail,pageHelper));
    }

    @RequestMapping("updateField")
    @ResponseBody
    public ResultDto updateField(Long pk,String name,String value){
        try {
            CodeListDetail detail=new CodeListDetail();
            detail.setId(pk);
            Field field=ReflectionUtils.findField(CodeListDetail.class,name);
            ReflectionUtils.makeAccessible(field);
            if("sort".equals(name)){
                Short v=Short.valueOf(value);
                ReflectionUtils.setField(field,detail,v);
            }else{
                ReflectionUtils.setField(field,detail,value);
            }
            codelistService.updateDetailSelectiveByPk(detail);
            return AppUtil.returnSuccess();
        } catch (Exception e) {
            SessionUtil.SetFailStatus();
            return AppUtil.returnFail(e.getMessage());
        }
    }
    @RequestMapping("addDetail")
    @ResponseBody
    public ResultDto<String> addDetail(CodeListDetail codeListDetail,String pcode){
        if(StringUtil.isEmpty(pcode)){//
            throw  new BaseException("pcode不能为空");
        }
        CodeList cl=this.codelistService.queryByCode(pcode);
        if(cl==null){
            cl=staticmap.get(pcode);
            if(null==cl){
                throw new BaseException("系统错误，没有找到"+pcode+"对应的类型");
            }
            codelistService.add(cl);
        }
        codeListDetail.setMasterid(cl.getId());

        codelistService.addCodeListDetail(codeListDetail);
        return AppUtil.returnSuccess();
    }
    @RequestMapping("deltails")
    @ResponseBody
    public ResultDto<String> del(String ids){
        codelistService.deleteDetailBatch(ids);
        return AppUtil.returnSuccess();
    }
    @RequestMapping("tree")
    @ResponseBody
    public ResultDto<List<Tree>> tree(String ids){
        return AppUtil.returnSuccess(codelistService.tree());
    }
    @RequestMapping("get")
    @ResponseBody
    public ResultDto<CodeList> get(String code){
        return AppUtil.returnSuccess(codelistService.queryByCode(code));
    }
    @RequestMapping("del")
    @ResponseBody
    public ResultDto<String> delcl(String code){
        CodeList c=this.codelistService.queryByCode(code);
        codelistService.del(c.getId());
        return AppUtil.returnSuccess();
    }
    @RequestMapping("clear")
    @ResponseBody
    public ResultDto<String> clear(String code){
        SessionConstantUtil.clear();
        return AppUtil.returnSuccess();
    }
    @RequestMapping("add")
    @ResponseBody
    public ResultDto<String> add(CodeList codeList){
        codelistService.add(codeList);
        return AppUtil.returnSuccess();
    }

}
