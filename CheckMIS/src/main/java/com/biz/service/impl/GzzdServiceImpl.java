package com.biz.service.impl;

import com.biz.dto.GzzdDto;
import com.biz.dto.leave.QjsqDto;
import com.biz.service.GzzdService;
import com.biz.service.LeaveService;
import com.core.model.checkmis.*;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;
import com.dao.core.checkmis.DeptMapper;
import com.dao.core.checkmis.GzzdMapper;
import com.dao.core.checkmis.QjsqMapper;
import com.util.BaseException;
import com.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("gzzdService")
public class GzzdServiceImpl implements GzzdService {
    @Autowired
    private GzzdMapper gzzdMapper;

    @Override
    public Gzzd get(Long id) {
        Gzzd gzzd= gzzdMapper.selectByPrimaryKey(id);
        return gzzd;
    }

    @Override
    public Long saveUpdate(GzzdDto gzzd, SessionInfo info) {
        if(!StringUtil.isEmpty(gzzd.getJl())){
            Gzzd g=new Gzzd();
            g.setFbnr(gzzd.getFbnr());
            if("1".equals(gzzd.getJl())){
                g.setZt(Short.valueOf("1"));
            }else{
                g.setZt(Short.valueOf("2"));
            }
            g.setId(gzzd.getId());
            g.setModifydate(new Date());
            g.setModifyuser(info.getName());
            this.gzzdMapper.updateByPrimaryKeySelective(g);
            return g.getId();
        }
        if(gzzd.getId()==null){
            gzzd.setCreatedate(new Date());
            gzzd.setCreateuser(info.getName());
            this.gzzdMapper.insert(gzzd);
        }else{
            gzzd.setModifydate(new Date());
            gzzd.setModifyuser(info.getName());
             this.gzzdMapper.updateByPrimaryKeySelective(gzzd);
        }
        return gzzd.getId();

    }
    @Override
    public void del(Long id) {
//        Qjsq db=this.gzzdMapper.selectByPrimaryKey(id);
//        if(db.getZt()==null||db.getZt()!=2){
//            throw  new BaseException("状态不正确，不能删除");
//        }
        this.gzzdMapper.deleteByPrimaryKey(id);
    }

    @Override
    public DataPage<Gzzd> dataGrid(GzzdDto gzzdDto, PageHelper pageHelper) {
        DataPage<Gzzd> dataPage=pageHelper.initPageBean();
        GzzdExample qjsqExample=new GzzdExample();
        BeanUtils.copyProperties(pageHelper,qjsqExample);
       // GzzdExample.Criteria criteria=qjsqExample.createCriteria();
        if(!StringUtil.isEmpty(gzzdDto.getKey())){
            qjsqExample.or().andBtLike("%"+gzzdDto.getKey()+"%");
            qjsqExample.or().andWhLike("%"+gzzdDto.getKey()+"%");
        }
        List<Gzzd> data=this.gzzdMapper.selectByExample(qjsqExample);
        dataPage.setData(data);
        dataPage.setTotal(qjsqExample.getTotal());
        return dataPage;
    }

    @Override
    public void check(Gzzd gzzd, SessionInfo info) {
        Gzzd db=this.gzzdMapper.selectByPrimaryKey(gzzd.getId());
        if(db.getZt()==null||db.getZt()!=0){
            throw  new BaseException("状态不正确，不能提交");
        }
        gzzd.setModifydate(new Date());
        gzzd.setModifyuser(info.getName());
        this.gzzdMapper.updateByPrimaryKeySelective(gzzd);
    }

    @Override
    public void apply(Long  id, SessionInfo info) {
        Gzzd db=this.gzzdMapper.selectByPrimaryKey(id);
        if(db.getZt()!=null && db.getZt()!=2){
            throw  new BaseException("状态不正确，不能提交");
        }
        Gzzd qjsq=new Gzzd();
        qjsq.setId(id);
        qjsq.setModifydate(new Date());
        qjsq.setModifyuser(info.getName());
        qjsq.setZt(Short.valueOf("0"));
        this.gzzdMapper.updateByPrimaryKeySelective(qjsq);
    }

    @Override
    public void valiadate(Gzzd gzzd) {
        GzzdExample example=new GzzdExample();
        GzzdExample.Criteria criteria=example.createCriteria();
        if(null!=gzzd.getId()){
            criteria.andIdNotEqualTo(gzzd.getId());
        }
        criteria.andWhEqualTo(gzzd.getWh());
        List<Gzzd>gl=this.gzzdMapper.selectByExample(example);
        if(gl.size()>0){
            throw new BaseException("文号已经存在，不能新增");
        }
    }
}
