package com.biz.service.impl;

import com.biz.dto.gzrw.GzrwDto;
import com.biz.dto.gzrw.GzrwXzDto;
import com.biz.dto.gzrw.GzrwxzcyDto;
import com.biz.service.AppMessageService;
import com.biz.service.GzrwService;
import com.common.constant.Constant;
import com.core.model.checkmis.*;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;
import com.dao.core.checkmis.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AppMessageServiceImpl implements AppMessageService {
    @Autowired
    private GzrwMapper gzrwMapper;
    @Autowired
    private GzjlMapper gzjlMapper;
    @Autowired
    private AppMessageMapper appMessageMapper;
    @Autowired
    private ViewTimeMapper viewTimeMapper;
    @Autowired
    private QjsqMapper qjsqMapper;
    @Autowired
    private GzrwService gzrwService;
    @Autowired
    private GzrwxzcyMapper gzrwxzcyMapper;
    @Autowired
    private GzrwxzMapper gzrwxzMapper;

    @Override
    public void addRwMessage(Gzrw gzrw) {

    }

    @Override
    public void addQjRwMessage(Qjsq qjsq) {

    }

    @Override
    public void addJlMessage(Gzjl gzjl) {

    }
    @Override
    public void readMsgAll(String type, SessionInfo info) {
        AppMessageExample example =new AppMessageExample();
        example.createCriteria().andMsgTypeEqualTo(Short.valueOf(type)).andWorkNumberEqualTo(info.getWorkNumber());
        AppMessage appMessage=new AppMessage();
        appMessage.setStatus(Short.valueOf("1"));
        this.appMessageMapper.updateByExample(appMessage,example);
    }

    @Override
    public DataPage<AppMessage> selectMessage(String type, PageHelper pageHelper, SessionInfo info) {
        DataPage<AppMessage> dataPage=pageHelper.initPageBean();
        AppMessageExample example=new AppMessageExample();
        BeanUtils.copyProperties(pageHelper,example);
        example.setOrderByClause("STATUS CREATETIME DESC");
        example.createCriteria().andMsgTypeEqualTo(Short.valueOf(type)).andWorkNumberEqualTo(info.getWorkNumber());
        List<AppMessage>data=this.appMessageMapper.selectByExample(example);
        dataPage.setData(data);
        dataPage.setTotal(example.getTotal());
        return dataPage;
    }

    @Override
    public Map<String, Integer> messageCount(SessionInfo info) {
        Map<String, Integer> r=new HashMap<>();
        ViewTimeExample viewTimeExample=new ViewTimeExample();
        viewTimeExample.createCriteria().andWorkNumberEqualTo(info.getWorkNumber());
        List<ViewTime>vl=this.viewTimeMapper.selectByExample(viewTimeExample);
        ViewTime vt=new ViewTime();
        if(vl.size()>0){
            vt=vl.get(0);
        }
        GzrwDto gzrwDto=new GzrwDto();
        gzrwDto.setValid("true");
        gzrwDto.setQszt("xxx");
        gzrwDto.setWorkNumber(info.getWorkNumber());
        gzrwDto.setStartDate(vt.getRwsj());
        List<Gzrw> gl=this.gzrwMapper.selectValidRwList(gzrwDto,new PageHelper());
        r.put("rw",gl.size());

        GzjlExample gzjlExample=new GzjlExample();
        if(null!=vt.getJlsj())
            gzjlExample.createCriteria().andModifydateGreaterThan(vt.getJlsj());
        List<Gzjl>jl=this.gzjlMapper.selectByExample(gzjlExample);
        r.put("jl",gl.size());

        QjsqExample qjsqExample=new QjsqExample();
        QjsqExample.Criteria  c=qjsqExample.createCriteria();
        if(!info.hasRole(Constant.ROLE_QJ)){
            c.andWorkNumberEqualTo(info.getWorkNumber());
        }
        if(vt.getQjst()!=null){
            c.andModifydateGreaterThanOrEqualTo(vt.getQjst());
        }
        List<Qjsq>ql=this.qjsqMapper.selectByExample(qjsqExample);
        r.put("qj",ql.size());
        return r;
    }

    @Override
    public void readAll(String type, SessionInfo info) {
        ViewTimeExample viewTimeExample=new ViewTimeExample();
        viewTimeExample.createCriteria().andWorkNumberEqualTo(info.getWorkNumber());
        List<ViewTime>vl=this.viewTimeMapper.selectByExample(viewTimeExample);
        ViewTime vt=new ViewTime();
        if(vl.size()>0){
            vt=vl.get(0);
        }
        if("rw".equals(type)){
            vt.setRwsj(new Date());
        }
        if("jl".equals(type)){
            vt.setJlsj(new Date());
        }
        if("qj".equals(type)){
            vt.setQjst(new Date());
        }
        if(vt.getId()==null){
            this.viewTimeMapper.insert(vt);
        }else{
            this.viewTimeMapper.updateByPrimaryKeySelective(vt);
        }
    }

    @Override
    public DataPage<Qjsq> selectQjMessage(PageHelper pageHelper, SessionInfo info) {
        DataPage<Qjsq> dataPage=pageHelper.initPageBean();
        QjsqExample qjsqExample=new QjsqExample();
        QjsqExample.Criteria  c=qjsqExample.createCriteria();
        if(!info.hasRole(Constant.ROLE_QJ)){
            c.andWorkNumberEqualTo(info.getWorkNumber());
        }
        List<Qjsq>ql=this.qjsqMapper.selectByExample(qjsqExample);
        dataPage.setTotal(ql.size());
        dataPage.setData(ql);
        return dataPage;
    }

    @Override
    public DataPage<GzrwxzcyDto> selectRWMessage(PageHelper pageHelper, SessionInfo info) {
        DataPage<GzrwxzcyDto> dataPage=pageHelper.initPageBean();
        GzrwxzcyDto gzrwxzcyDto=new GzrwxzcyDto();
        gzrwxzcyDto.setWorkNumber(info.getWorkNumber());
        List<GzrwxzcyDto> dl=this.gzrwxzcyMapper.selectAppRwList(gzrwxzcyDto);
        dataPage.setData(dl);
        dataPage.setTotal(dl.size());
        return dataPage;
    }

    @Override
    public DataPage<Gzjl> selectJlMessage(PageHelper pageHelper, SessionInfo info) {
        DataPage<Gzjl>data=pageHelper.initPageBean();
        GzjlExample gzjlExample=new GzjlExample();
        List<Gzjl>jl=this.gzjlMapper.selectByExample(gzjlExample);
        data.setData(jl);
        data.setTotal(jl.size());
        return data;
    }

    @Override
    public GzrwxzcyDto selectRwDteail(Long id) {
        GzrwxzcyDto gzrwxzcyDto=new GzrwxzcyDto();
        Gzrwxzcy gzrwxzcy=this.gzrwxzcyMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(gzrwxzcy,gzrwxzcyDto);
        Gzrwxz z=this.gzrwxzMapper.selectByPrimaryKey(gzrwxzcy.getGzrwxzId());
        GzrwXzDto d=this.gzrwService.selectXzInfo(z);
        gzrwxzcyDto.setGzrwXzDto(d);
        Gzrw gzrw=this.gzrwMapper.selectByPrimaryKey(z.getGzrwId());
        gzrwxzcyDto.setGzrw(gzrw);
        return gzrwxzcyDto;
    }
}
