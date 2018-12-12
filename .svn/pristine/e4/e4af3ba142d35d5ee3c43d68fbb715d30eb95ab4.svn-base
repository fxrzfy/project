package com.biz.service.impl;

import com.biz.service.WentiService;
import com.core.model.checkmis.WtflDmb;
import com.core.model.checkmis.WtflDmbExample;
import com.core.model.checkmis.WtxdDmb;
import com.core.model.checkmis.WtxdDmbExample;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;
import com.dao.core.checkmis.WtflDmbMapper;
import com.dao.core.checkmis.WtxdDmbMapper;
import com.util.BaseException;
import com.util.PinyinUtil;
import com.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service("wentiService")
public class WentiServiceImpl implements WentiService {
    @Autowired
    private WtflDmbMapper wtflDmbMapper;
    @Autowired
    private WtxdDmbMapper wtxdDmbMapper;
    @Override
    public List<WtflDmb> tree(String type) {
        WtflDmbExample example=new WtflDmbExample();
        example.setOrderByClause("code");
        example.createCriteria().andTypeEqualTo(type);
        return wtflDmbMapper.selectByExample(example);
    }

    @Override
    public DataPage<WtxdDmb> wtxList(WtxdDmb wtxdDmb, PageHelper pageHelper) {
        if(wtxdDmb.getWtflId()==null){
            return pageHelper.initPageBean();
        }
        WtxdDmbExample wtxdDmbExample=new WtxdDmbExample();
        wtxdDmbExample.setOrderByClause("code");
        if(wtxdDmb.getWtflId() != 0) {
            wtxdDmbExample.createCriteria().andWtflIdEqualTo(wtxdDmb.getWtflId());
        }
        DataPage<WtxdDmb>dataPage=pageHelper.initPageBean();
        List<WtxdDmb>wl=this.wtxdDmbMapper.selectByExample(wtxdDmbExample);
        dataPage.setTotal(wtxdDmbExample.getTotal());
        dataPage.setData(wl);
        return dataPage;
    }

    @Override
    public void addWtfl(WtflDmb wtflDmb, SessionInfo info) {
        if(StringUtil.isEmpty(wtflDmb.getWtms())){
            throw  new BaseException("问题描述不能为空");
        }

        wtflDmb.setCode(PinyinUtil.getFirstSpell(wtflDmb.getWtms()));
        WtflDmbExample example=new WtflDmbExample();
        example.createCriteria().andWtmsEqualTo(wtflDmb.getWtms()).andTypeEqualTo(wtflDmb.getType());
        List<WtflDmb> wl=this.wtflDmbMapper.selectByExample(example);
        for(WtflDmb w:wl){
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
            wtflDmbMapper.insert(wtflDmb);
        }else{
            wtflDmb.setModifydate(new Date());
            wtflDmb.setModifyuser(info.getName());
            wtflDmbMapper.updateByPrimaryKeySelective(wtflDmb);
        }

    }

    @Override
    public void addWtXd(WtxdDmb wtxdDmb, SessionInfo info) {
        if(StringUtil.isEmpty(wtxdDmb.getWtxsm())){
            throw new BaseException("问题说明不能为空");
        }
        if(wtxdDmb.getId()==null){
            wtxdDmb.setId(-1l);
        }
        WtxdDmbExample example=new WtxdDmbExample();
        example.createCriteria().andWtflIdEqualTo(wtxdDmb.getWtflId()).andWtxsmEqualTo(wtxdDmb.getWtxsm()).andIdNotEqualTo(wtxdDmb.getId());
        List<WtxdDmb>xl=this.wtxdDmbMapper.selectByExample(example);
        if(xl.size()>0){
            throw new BaseException("问题说明不能重复");
        }
        if(StringUtil.isEmpty(wtxdDmb.getCode())){
            wtxdDmb.setCode(PinyinUtil.getFirstSpell(wtxdDmb.getWtxsm()));
        }
        if(wtxdDmb.getCode()!=null && wtxdDmb.getCode().length()>30){
            wtxdDmb.setCode(wtxdDmb.getCode().substring(0,30));
        }
        if(wtxdDmb.getId()<1){
            wtxdDmbMapper.insert(wtxdDmb);
        }else{
            wtxdDmbMapper.updateByPrimaryKeySelective(wtxdDmb);
        }
    }

    @Override
    public void delWtFl(Long id) {
        WtxdDmbExample wtxdDmbExample=new WtxdDmbExample();
        wtxdDmbExample.createCriteria().andWtflIdEqualTo(id);
        this.wtxdDmbMapper.deleteByExample(wtxdDmbExample);
        this.wtflDmbMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void delWtxd(Long id) {
        wtxdDmbMapper.deleteByPrimaryKey(id);
    }
}
