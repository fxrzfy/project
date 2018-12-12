package com.biz.controller;

import com.biz.dto.gzrw.GzrwDto;
import com.biz.dto.gzrw.GzrwXzDto;
import com.biz.service.GzrwService;
import com.core.dto.PersonDto;
import com.core.model.checkmis.Gzrw;
import com.core.model.checkmis.Gzrwxz;
import com.core.model.checkmis.Gzrwxzcy;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RequestMapping("gzrw")
@Controller
public class GzrwController {

    @Autowired
    private GzrwService gzrwService;
    @Autowired
    private UserService userService;

    @RequestMapping("list")
    @ResponseBody
    public ResultDto<DataPage<GzrwDto>> gzrwList(GzrwDto gzrwDto, PageHelper pageHelper){
        return AppUtil.returnSuccess(gzrwService.list(gzrwDto,pageHelper));
    }

    @RequestMapping("getById")
    @ResponseBody
    public ResultDto<GzrwDto> getById(Long id){
        return AppUtil.returnSuccess(gzrwService.getById(id));
    }

    @RequestMapping("xzList")
    @ResponseBody
    public ResultDto<DataPage<GzrwXzDto>> xzList(GzrwDto gzrwDto, PageHelper pageHelper){
        DataPage<GzrwXzDto> dtoDataPage=new DataPage<>();
        List<GzrwXzDto>gzdl=new ArrayList<>();
        if(null!=gzrwDto.getId()){
            gzdl=this.gzrwService.getGzrwXzByRwId(gzrwDto.getId());
        }else{
            gzdl=this.gzrwService.getInitGzrwXz();
        }
        dtoDataPage.setTotal(gzdl.size());
        dtoDataPage.setData(gzdl);
        return AppUtil.returnSuccess(dtoDataPage);
    }

    @RequestMapping("ryList")
    @ResponseBody
    public ResultDto<DataPage<PersonDto>> ryList(GzrwXzDto gzrwXzDto, PageHelper pageHelper,HttpServletRequest request){
        if(gzrwXzDto.getId()==null){
            return  AppUtil.returnSuccess(new DataPage<>());
        }
        PersonDto personDto=new PersonDto();
        personDto.setXzId(gzrwXzDto.getId());
        personDto.setIsSelectEd(gzrwXzDto.getIsSelectEd());
        personDto.setGzrwId(gzrwXzDto.getGzrwId());
        return AppUtil.returnSuccess(userService.getUserForGzrw(personDto));
    }
    @RequestMapping("addGzrw")
    @ResponseBody
    public ResultDto<String> addGzrw(Gzrw gzrw){
        Gzrw add= this.gzrwService.addEditGzrw(gzrw, SessionUtil.getSessionInfo());
        return AppUtil.returnSuccess(add);
    }
    @RequestMapping("zfGzrw")
    @ResponseBody
    public ResultDto<String> zfGzrw(Gzrw gzrw){
        Gzrw add= this.gzrwService.addEditGzrw(gzrw, SessionUtil.getSessionInfo());
        return AppUtil.returnSuccess(add);
    }

    @RequestMapping("delGzxz")
    @ResponseBody
    public ResultDto<String> delGzxz(String ids){
        for(String strid:ids.split(","))
        this.gzrwService.delGzxz(Long.parseLong(strid));
        return AppUtil.returnSuccess();
    }
    @RequestMapping("updateGzxz")
    @ResponseBody
    public ResultDto updateGzxz(Long pk,String name,String value){
        try{
            gzrwService.updateTeam(pk,name,value,SessionUtil.getSessionInfo());
        }catch (Exception e){
            SessionUtil.SetFailStatus();
            return AppUtil.returnFail(e.getMessage());
        }
        return AppUtil.returnSuccess();
    }
    @RequestMapping("addXzcy")
    @ResponseBody
    public ResultDto<String> addXzcy(Gzrwxzcy gzrwxzcy){
       this.gzrwService.addXzcy(gzrwxzcy,SessionUtil.getSessionInfo());
        return AppUtil.returnSuccess();
    }
    @RequestMapping("freeXzcy")
    @ResponseBody
    public ResultDto<String> freeXzcy(Long id){
        this.gzrwService.freeXzcy(id);
        return AppUtil.returnSuccess();
    }
    @RequestMapping("updateCyRole")
    @ResponseBody
    public ResultDto<String> updateCyRole(Long id){
        this.gzrwService.updateCyRole(id,SessionUtil.getSessionInfo());
        return AppUtil.returnSuccess();
    }
    @RequestMapping("dismissXz")
    @ResponseBody
    public ResultDto<String> dismissXz(String ids,String type){
        for(String strid:ids.split(","))
            this.gzrwService.dimissXz(ids,type,SessionUtil.getSessionInfo());
        return AppUtil.returnSuccess();
    }
    @RequestMapping("delGzrw")
    @ResponseBody
    public ResultDto<String> delGzrw(String ids){
        for(String strid:ids.split(","))
            this.gzrwService.delGzrw(Long.parseLong(strid));
        return AppUtil.returnSuccess();
    }

    @RequestMapping("getSignstatus")
    @ResponseBody
    public ResultDto<Map<String,List<Gzrwxzcy>>> getSignstatus(Long id){
        return AppUtil.returnSuccess(this.gzrwService.getSignstatus(id));
    }

    @RequestMapping("addTemp")
    @ResponseBody
    public ResultDto<String> addTemp(Gzrwxzcy gzrwxzcy){
        this.gzrwService.addTempCy(gzrwxzcy,SessionUtil.getSessionInfo());
        return AppUtil.returnSuccess();
    }



}
