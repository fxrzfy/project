package com.biz.service.impl;

import com.biz.service.JcflService;
import com.core.model.checkmis.JcflDmb;
import com.core.model.checkmis.JcflDmbExample;
import com.core.model.checkmis.Jcxdsx;
import com.core.model.checkmis.JcxdsxExample;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.dao.core.checkmis.JcflDmbMapper;
import com.dao.core.checkmis.JcxdsxMapper;
import org.apache.cxf.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JcflServiceImpl implements JcflService {
    @Autowired
    JcflDmbMapper jcflDmbMapper;

    @Autowired
    JcxdsxMapper jcxdsxMapper;

    @Override
    public List<JcflDmb> list(String type) {
        JcflDmbExample example = new JcflDmbExample();
        JcflDmbExample.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(type)){
            criteria.andTypeEqualTo(type);
        }
        return jcflDmbMapper.selectByExample(example);
    }

    @Override
    public void add(JcflDmb jcflDmb) {
        if(jcflDmb.getId() == null) {
            jcflDmbMapper.insert(jcflDmb);
        }else{
            jcflDmbMapper.updateByPrimaryKey(jcflDmb);
        }
    }

    @Override
    public void delete(Long id) {
        jcflDmbMapper.deleteByPrimaryKey(id);
    }

    @Override
    public JcflDmb get(Long id) {
        return jcflDmbMapper.selectByPrimaryKey(id);
    }

    @Override
    public DataPage<Jcxdsx> detail(Long id, PageHelper pageHelper) {
        if(id == null){
            return pageHelper.initPageBean();
        }
        JcxdsxExample e = new JcxdsxExample();
        DataPage<Jcxdsx> dataPage=pageHelper.initPageBean();
        e.createCriteria().andJcflIdEqualTo(id);
        List<Jcxdsx> list = jcxdsxMapper.selectByExample(e);
        dataPage.setTotal(e.getTotal());
        dataPage.setData(list);
        return dataPage;
    }

    @Override
    public void addDetail(Jcxdsx jcxdsx) {
        if(jcxdsx.getId() == null) {
            jcxdsxMapper.insert(jcxdsx);
        }else{
            jcxdsxMapper.updateByPrimaryKey(jcxdsx);
        }
    }

    @Override
    public void deleteDetail(Long id) {
        jcxdsxMapper.deleteByPrimaryKey(id);
    }


}
