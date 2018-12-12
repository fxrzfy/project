package com.biz.service.impl;

import com.biz.service.LqsknrService;
import com.core.model.checkmis.LqsknrflDmb;
import com.core.model.checkmis.LqsknrflDmbExample;
import com.core.model.checkmis.LqsknrxdDmb;
import com.core.model.checkmis.LqsknrxdDmbExample;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;
import com.dao.core.checkmis.LqsknrflDmbMapper;
import com.dao.core.checkmis.LqsknrxdDmbMapper;
import com.util.BaseException;
import com.util.PinyinUtil;
import com.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("lqsknrService")
public class LqsknrServiceImpl implements LqsknrService {
    @Autowired
    private LqsknrflDmbMapper lqsknrflDmbMapper;

    @Autowired
    private LqsknrxdDmbMapper lqsknrxdDmbMapper;

    @Override
    public List<LqsknrflDmb> tree(String type) {
        LqsknrflDmbExample example=new LqsknrflDmbExample();
        example.setOrderByClause("id");
        return lqsknrflDmbMapper.selectByExample(example);
    }

    @Override
    public DataPage<LqsknrxdDmb> wtxList(LqsknrxdDmb wtxdDmb, PageHelper pageHelper) {
        if(wtxdDmb.getLqsknrflId()==null){
            return pageHelper.initPageBean();
        }
        LqsknrxdDmbExample wtxdDmbExample=new LqsknrxdDmbExample();
        wtxdDmbExample.setOrderByClause("code");
        if(wtxdDmb.getLqsknrflId()!=0) {
            wtxdDmbExample.createCriteria().andLqsknrflIdEqualTo(wtxdDmb.getLqsknrflId());
        }
        DataPage<LqsknrxdDmb>dataPage=pageHelper.initPageBean();
        List<LqsknrxdDmb>wl=this.lqsknrxdDmbMapper.selectByExample(wtxdDmbExample);
        dataPage.setTotal(wtxdDmbExample.getTotal());
        dataPage.setData(wl);
        return dataPage;
    }

    @Override
    public void addWtfl(LqsknrflDmb wtflDmb, SessionInfo info) {
        if(StringUtil.isEmpty(wtflDmb.getName())){
            throw  new BaseException("问题描述不能为空");
        }
        LqsknrflDmbExample example=new LqsknrflDmbExample();
        example.createCriteria().andNameEqualTo(wtflDmb.getName());
        List<LqsknrflDmb> wl=this.lqsknrflDmbMapper.selectByExample(example);
        for(LqsknrflDmb w:wl){
            if(wtflDmb.getId()==null){
                throw  new BaseException("该分类已经存在");
            }
            if(!w.getId().equals(wtflDmb.getId())){
                throw  new BaseException("该分类已经存在");
            }
        }
        if(wtflDmb.getId()==null){
            wtflDmb.setCreatedate(new Date());
            wtflDmb.setCreateuser(info.getName());
            lqsknrflDmbMapper.insert(wtflDmb);
        }else{
            wtflDmb.setModifydate(new Date());
            wtflDmb.setModifyuser(info.getName());
            lqsknrflDmbMapper.updateByPrimaryKeySelective(wtflDmb);
        }

    }

    @Override
    public void addWtXd(LqsknrxdDmb wtxdDmb, SessionInfo info) {
        if(StringUtil.isEmpty(wtxdDmb.getName())){
            throw new BaseException("问题说明不能为空");
        }
        if(wtxdDmb.getId()==null){
            wtxdDmb.setId(-1l);
        }
        LqsknrxdDmbExample example=new LqsknrxdDmbExample();
        example.createCriteria().andLqsknrflIdEqualTo(wtxdDmb.getLqsknrflId()).andNameEqualTo(wtxdDmb.getName()).andIdNotEqualTo(wtxdDmb.getId());
        List<LqsknrxdDmb>xl=this.lqsknrxdDmbMapper.selectByExample(example);
        if(xl.size()>0){
            throw new BaseException("问题不能重复");
        }
        if(StringUtil.isEmpty(wtxdDmb.getCode())){
            wtxdDmb.setCode(PinyinUtil.getFirstSpell(wtxdDmb.getName()));
        }
        if(wtxdDmb.getId()<1){
            lqsknrxdDmbMapper.insert(wtxdDmb);
        }else{
            lqsknrxdDmbMapper.updateByPrimaryKeySelective(wtxdDmb);
        }
    }

    @Override
    public void delWtFl(Long id) {
        LqsknrxdDmbExample wtxdDmbExample=new LqsknrxdDmbExample();
        wtxdDmbExample.createCriteria().andLqsknrflIdEqualTo(id);
        this.lqsknrxdDmbMapper.deleteByExample(wtxdDmbExample);
        this.lqsknrflDmbMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void delWtxd(Long id) {
        lqsknrxdDmbMapper.deleteByPrimaryKey(id);
    }
}
