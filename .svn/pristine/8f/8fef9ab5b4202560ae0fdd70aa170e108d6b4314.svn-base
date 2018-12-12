package com.biz.service.impl;

import com.biz.dto.leave.QjsqDto;
import com.biz.service.LeaveService;
import com.core.model.checkmis.Dept;
import com.core.model.checkmis.Qjsq;
import com.core.model.checkmis.QjsqExample;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;
import com.dao.core.checkmis.DeptMapper;
import com.dao.core.checkmis.QjsqMapper;
import com.util.BaseException;
import com.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    private QjsqMapper qjsqMapper;

    @Autowired
    private DeptMapper deptMapper;
    @Override
    public QjsqDto get(Long id) {
        Qjsq qjsq= qjsqMapper.selectByPrimaryKey(id);
        QjsqDto qjsqDto=new QjsqDto();
        Dept dept=this.deptMapper.selectByPrimaryKey(qjsq.getDeptId());
        BeanUtils.copyProperties(qjsq,qjsqDto);
        qjsqDto.setDeptName(dept.getName());
        return qjsqDto;
    }

    @Override
    public Long saveUpdate(QjsqDto r, SessionInfo info) {
        if(r.getId()==null){
            r.setSqsj(new Date());
            r.setCreatedate(new Date());
            r.setCreateuser(info.getName());
             this.qjsqMapper.insert(r);
        }else{
            r.setModifydate(new Date());
            r.setModifyuser(info.getName());
             this.qjsqMapper.updateByPrimaryKeySelective(r);
        }
        return r.getId();

    }
    @Override
    public void del(Long id) {
        Qjsq db=this.qjsqMapper.selectByPrimaryKey(id);
        if(db.getZt()==null||db.getZt()!=2){
            throw  new BaseException("状态不正确，不能删除");
        }
        this.qjsqMapper.deleteByPrimaryKey(id);
    }

    @Override
    public DataPage<QjsqDto> dataGrid(QjsqDto role, PageHelper pageHelper) {
        DataPage<QjsqDto> dataPage=pageHelper.initPageBean();
        QjsqExample qjsqExample=new QjsqExample();
        BeanUtils.copyProperties(pageHelper,qjsqExample);
        QjsqExample.Criteria criteria=qjsqExample.createCriteria();
        if(!StringUtil.isEmpty(role.getWorkNumber())){
            criteria.andWorkNumberEqualTo(role.getWorkNumber());
        }
        if(!StringUtil.isEmpty(role.getName())){
            criteria.andNameLike("%"+role.getName()+"%");
        }
        List<Qjsq> data=this.qjsqMapper.selectByExample(qjsqExample);
        List<QjsqDto> d=new ArrayList<>();
        for(Qjsq q:data){
            QjsqDto qjsqDto=new QjsqDto();
            BeanUtils.copyProperties(q,qjsqDto);
            if(null!=q.getDeptId()){
                qjsqDto.setDeptName(this.deptMapper.selectByPrimaryKey(q.getDeptId()).getName());
            }
            d.add(qjsqDto);
        }
        dataPage.setData(d);
        dataPage.setTotal(qjsqExample.getTotal());
        return dataPage;
    }

    @Override
    public void check(QjsqDto qjsq, SessionInfo info) {
        Qjsq db=this.qjsqMapper.selectByPrimaryKey(qjsq.getId());
        if(db.getZt()==null||db.getZt()!=0){
            throw  new BaseException("状态不正确，不能提交");
        }

        qjsq.setModifydate(new Date());
        qjsq.setModifyuser(info.getName());
        this.qjsqMapper.updateByPrimaryKeySelective(qjsq);
    }

    @Override
    public void apply(Long  id, SessionInfo info) {
        Qjsq db=this.qjsqMapper.selectByPrimaryKey(id);
        if(db.getZt()!=null && db.getZt()!=2){
            throw  new BaseException("状态不正确，不能提交");
        }
        Qjsq qjsq=new Qjsq();
        qjsq.setId(id);
        qjsq.setModifydate(new Date());
        qjsq.setModifyuser(info.getName());
        qjsq.setZt(Short.valueOf("0"));
        this.qjsqMapper.updateByPrimaryKeySelective(qjsq);
    }
}
