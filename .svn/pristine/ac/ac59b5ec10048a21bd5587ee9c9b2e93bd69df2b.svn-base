package com.biz.service.impl;

import com.biz.service.GzjlscService;
import com.core.model.checkmis.Gzjlsc;
import com.core.model.checkmis.GzjlscExample;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.dao.core.checkmis.GzjlscMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("gzjlscService")
public class GzjlscServiceImpl implements GzjlscService {

    @Autowired
    GzjlscMapper gzjlscMapper;

    @Override
    public DataPage<Gzjlsc> dataGrid(Gzjlsc gzjlsc, PageHelper pageHelper) {
        GzjlscExample ge = new GzjlscExample();
        BeanUtils.copyProperties(pageHelper,ge);
        GzjlscExample.Criteria criteria = ge.createCriteria();
        if(gzjlsc.getJllx() != null){
            criteria.andJllxEqualTo(gzjlsc.getJllx());
        }
        DataPage<Gzjlsc> dataPage = pageHelper.initPageBean();
        dataPage.setData(gzjlscMapper.selectByExample(ge));
        dataPage.setTotal(pageHelper.getTotal());
        return dataPage;
    }


}
