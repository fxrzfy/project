package com.biz.service.impl;

import com.biz.dto.gzjlsc.GzxsGroupDetailDto;
import com.biz.dto.gzjlsc.GzxsGroupDto;
import com.biz.dto.gzxs.GzxsDto;
import com.biz.dto.gzxs.GzxsJcqkbDto;
import com.biz.dto.gzxs.GzxsJcqkbMxDto;
import com.biz.dto.gzxs.GzxsRqktzsDto;
import com.biz.service.GzxsService;
import com.core.model.checkmis.*;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.dao.core.checkmis.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class GzxsServiceImpl implements GzxsService {

    @Autowired
    GzxsMapper gzxsMapper;

    @Autowired
    GzxsJcqkbMapper gzxsJcqkbMapper;

    @Autowired
    GzxsJtwtMapper gzxsJtwtMapper;

    @Autowired
    GzxsRqktzsMapper gzxsRqktzsMapper;

    @Autowired
    JcxdsxMapper jcxdsxMapper;

    @Autowired
    GzxsJcqkbMxMapper gzxsJcqkbMxMapper;

    @Override
    public DataPage<Gzxs> dataGrid(Gzxs gzxs, PageHelper pageHelper) {
        GzxsExample gzxsExample = new GzxsExample();
        BeanUtils.copyProperties(pageHelper,gzxsExample);
        GzxsExample.Criteria criteria = gzxsExample.createCriteria();
        if(!StringUtils.isEmpty(gzxs.getJcfl())){
            criteria.andJcflEqualTo(gzxs.getJcfl());
        }
        if(gzxs.getLx() != null){
            criteria.andLxEqualTo(gzxs.getLx());
        }
        if(gzxs.getJckssj() != null){
            criteria.andJckssjGreaterThanOrEqualTo(gzxs.getJckssj());
        }
        if(gzxs.getJcjssj() != null){
            criteria.andJcjssjLessThanOrEqualTo(gzxs.getJcjssj());
        }
        List<Gzxs> gzxsList =  gzxsMapper.selectByExample(gzxsExample);

        DataPage<Gzxs> dataPage=pageHelper.initPageBean();
        dataPage.setData(gzxsList);
        dataPage.setTotal(gzxsExample.getTotal());
        return dataPage;
    }

    @Override
    public GzxsDto get(Long id){
        GzxsDto gzxsDto = new GzxsDto();
        Gzxs gzxs = gzxsMapper.selectByPrimaryKey(id);
        gzxsDto.setGzxs(gzxs);

        GzxsJcqkbExample gzxsJcqkbExample = new GzxsJcqkbExample();
        gzxsJcqkbExample.createCriteria().andGzxsIdEqualTo(id);
        List<GzxsJcqkb> gzxsJcqkbList = gzxsJcqkbMapper.selectByExample(gzxsJcqkbExample);
        List<GzxsJcqkbDto> gzxsJcqkbDtoList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(gzxsJcqkbList)){
            for(GzxsJcqkb gzxsJcqkb : gzxsJcqkbList){
                GzxsJcqkbDto gzxsJcqkbDto = new GzxsJcqkbDto();
                BeanUtils.copyProperties(gzxsJcqkb, gzxsJcqkbDto);

                List<GzxsJcqkbMxDto> gzxsJcqkbMxDtoList = gzxsJcqkbMxMapper.selectDetail(gzxsJcqkb.getId());
                for(GzxsJcqkbMxDto gzxsJcqkbMxDto : gzxsJcqkbMxDtoList){
                    switch (gzxsJcqkbMxDto.getOrders()){
                        case 1:
                            gzxsJcqkbDto.setField1(gzxsJcqkbMxDto.getJcxdsj());
                            break;
                        case 2:
                            gzxsJcqkbDto.setField2(gzxsJcqkbMxDto.getJcxdsj());
                            break;
                        case 3:
                            gzxsJcqkbDto.setField3(gzxsJcqkbMxDto.getJcxdsj());
                            break;
                        case 4:
                            gzxsJcqkbDto.setField4(gzxsJcqkbMxDto.getJcxdsj());
                            break;
                        case 5:
                            gzxsJcqkbDto.setField5(gzxsJcqkbMxDto.getJcxdsj());
                            break;
                    }
                }
                gzxsJcqkbDtoList.add(gzxsJcqkbDto);
            }
        }
        gzxsDto.setGzxsJcqkbList(gzxsJcqkbDtoList);

        GzxsJtwtExample gzxsJtwtExample = new GzxsJtwtExample();
        gzxsJtwtExample.createCriteria().andGzxsIdEqualTo(id);
        List<GzxsJtwt> gzxsJtwtList = gzxsJtwtMapper.selectByExample(gzxsJtwtExample);
        gzxsDto.setGzxsJtwtList(gzxsJtwtList);

        GzxsRqktzsExample gzxsRqktzsExample = new GzxsRqktzsExample();
        gzxsRqktzsExample.createCriteria().andGzxsIdEqualTo(id);
        List<GzxsRqktzs> gzxsRqktzsList = gzxsRqktzsMapper.selectByExample(gzxsRqktzsExample);
        gzxsDto.setGzxsRqktzsList(gzxsRqktzsList);

        return gzxsDto;
    }

    @Override
    public void add(GzxsDto gzxsDto) {
        Gzxs gzxs = gzxsDto.getGzxs();
        gzxsMapper.insert(gzxs);

        if(!CollectionUtils.isEmpty(gzxsDto.getGzxsJcqkbList())) {
            for (GzxsJcqkbDto gzxsJcqkbDto : gzxsDto.getGzxsJcqkbList()){
                GzxsJcqkb gzxsJcqkb = new GzxsJcqkb();
                BeanUtils.copyProperties(gzxsJcqkbDto, gzxsJcqkb);
                gzxsJcqkb.setGzxsId(gzxs.getId());
                gzxsJcqkb.setZt(0);
                gzxsJcqkbMapper.insert(gzxsJcqkb);

                JcxdsxExample e = new JcxdsxExample();
                e.createCriteria().andJcflIdEqualTo(gzxsJcqkbDto.getJcflId());
                List<Jcxdsx> list = jcxdsxMapper.selectByExample(e);
                if(!CollectionUtils.isEmpty(list)){
                    for(Jcxdsx jcxdsx : list){
                        GzxsJcqkbMx gzxsJcqkbMx = new GzxsJcqkbMx();
                        gzxsJcqkbMx.setJcqkbId(gzxsJcqkb.getId());
                        gzxsJcqkbMx.setJcxdsxId(jcxdsx.getId());
                        switch(jcxdsx.getOrders()){
                            case 1:
                                gzxsJcqkbMx.setJcxdsj(gzxsJcqkbDto.getField1());
                                break;
                            case 2:
                                gzxsJcqkbMx.setJcxdsj(gzxsJcqkbDto.getField2());
                                break;
                            case 3:
                                gzxsJcqkbMx.setJcxdsj(gzxsJcqkbDto.getField3());
                                break;
                            case 4:
                                gzxsJcqkbMx.setJcxdsj(gzxsJcqkbDto.getField4());
                                break;
                            case 5:
                                gzxsJcqkbMx.setJcxdsj(gzxsJcqkbDto.getField5());
                                break;
                        }
                        gzxsJcqkbMxMapper.insert(gzxsJcqkbMx);
                    }
                }
            }
        }

        if(!CollectionUtils.isEmpty(gzxsDto.getGzxsJtwtList())) {
            for (GzxsJtwt gzxsJtwt : gzxsDto.getGzxsJtwtList()){
                gzxsJtwt.setGzxsId(gzxs.getId());
                gzxsJtwtMapper.insert(gzxsJtwt);
            }
        }

        if(!CollectionUtils.isEmpty(gzxsDto.getGzxsRqktzsList())) {
            for (GzxsRqktzs gzxsRqktzs : gzxsDto.getGzxsRqktzsList()){
                gzxsRqktzs.setGzxsId(gzxs.getId());
                gzxsRqktzsMapper.insert(gzxsRqktzs);
            }
        }

    }

    @Override
    public void delete(Long id) {
        gzxsMapper.deleteByPrimaryKey(id);

        GzxsJcqkbExample gzxsJcqkbExample = new GzxsJcqkbExample();
        gzxsJcqkbExample.createCriteria().andGzxsIdEqualTo(id);
        gzxsJcqkbMapper.deleteByExample(gzxsJcqkbExample);

        GzxsJtwtExample gzxsJtwtExample = new GzxsJtwtExample();
        gzxsJtwtExample.createCriteria().andGzxsIdEqualTo(id);
        gzxsJtwtMapper.deleteByExample(gzxsJtwtExample);

        GzxsRqktzsExample gzxsRqktzsExample = new GzxsRqktzsExample();
        gzxsRqktzsExample.createCriteria().andGzxsIdEqualTo(id);
        gzxsRqktzsMapper.deleteByExample(gzxsRqktzsExample);
    }

    @Override
    public void update(GzxsDto gzxsDto) {

    }

    @Override
    public DataPage<GzxsGroupDto> groupList(Gzxs gzxs, PageHelper pageHelper) {

        GzxsExample gzxsExample = new GzxsExample();
        BeanUtils.copyProperties(pageHelper,gzxsExample);
        GzxsExample.Criteria criteria = gzxsExample.createCriteria();
        if(!StringUtils.isEmpty(gzxs.getLx())){
            criteria.andLxEqualTo(gzxs.getLx());
        }
        List<GzxsGroupDto> list = gzxsMapper.groupList(gzxsExample);

        DataPage<GzxsGroupDto> dataPage = pageHelper.initPageBean();
        dataPage.setData(list);
        dataPage.setTotal(list.size());
        return dataPage;
    }

    @Override
    public GzxsGroupDetailDto groupDetail(String ids) {
        GzxsGroupDetailDto gzxsGroupDetailDto = new GzxsGroupDetailDto();
        gzxsGroupDetailDto.setGzxsList(new ArrayList<>());
        gzxsGroupDetailDto.setGzxsJcqkbList(new ArrayList<>());
        gzxsGroupDetailDto.setGzxsJtwtList(new ArrayList<>());
        gzxsGroupDetailDto.setGzxsRqktzsList(new ArrayList<>());
        if(!StringUtils.isEmpty(ids)){
            for(String idStr : ids.split(",")){
                Long id = Long.valueOf(idStr);

                Gzxs gzxs = gzxsMapper.selectByPrimaryKey(id);
                gzxsGroupDetailDto.getGzxsList().add(gzxs);

                GzxsJcqkbExample gzxsJcqkbExample = new GzxsJcqkbExample();
                gzxsJcqkbExample.createCriteria().andGzxsIdEqualTo(id);
                List<GzxsJcqkb> gzxsJcqkbList = gzxsJcqkbMapper.selectByExample(gzxsJcqkbExample);
                List<GzxsJcqkbDto> gzxsJcqkbDtoList = new ArrayList<>();
                for(GzxsJcqkb gzxsJcqkb : gzxsJcqkbList) {
                    GzxsJcqkbDto gzxsJcqkbDto = new GzxsJcqkbDto();
                    BeanUtils.copyProperties(gzxsJcqkb, gzxsJcqkbDto);

                    List<GzxsJcqkbMxDto> gzxsJcqkbMxDtoList = gzxsJcqkbMxMapper.selectDetail(gzxsJcqkb.getId());
                    for(GzxsJcqkbMxDto gzxsJcqkbMxDto : gzxsJcqkbMxDtoList){
                        if(StringUtils.isEmpty(gzxsJcqkbMxDto.getJcxdsj())){
                            continue;
                        }
                        String value = gzxsJcqkbMxDto.getJcxdsx() + gzxsJcqkbMxDto.getJcxdsj() + (gzxsJcqkbMxDto.getJcxdsxdw() == null?"":gzxsJcqkbMxDto.getJcxdsxdw());
                        switch (gzxsJcqkbMxDto.getOrders()){
                            case 1:
                                gzxsJcqkbDto.setField1(value);
                                break;
                            case 2:
                                gzxsJcqkbDto.setField2(value);
                                break;
                            case 3:
                                gzxsJcqkbDto.setField3(value);
                                break;
                            case 4:
                                gzxsJcqkbDto.setField4(value);
                                break;
                            case 5:
                                gzxsJcqkbDto.setField5(value);
                                break;
                        }
                    }

                    gzxsJcqkbDtoList.add(gzxsJcqkbDto);
                }
                gzxsGroupDetailDto.getGzxsJcqkbList().addAll(gzxsJcqkbDtoList);

                GzxsJtwtExample gzxsJtwtExample = new GzxsJtwtExample();
                gzxsJtwtExample.createCriteria().andGzxsIdEqualTo(id);
                List<GzxsJtwt> gzxsJtwtList = gzxsJtwtMapper.selectByExample(gzxsJtwtExample);
                gzxsGroupDetailDto.getGzxsJtwtList().addAll(gzxsJtwtList);

                GzxsRqktzsExample gzxsRqktzsExample = new GzxsRqktzsExample();
                gzxsRqktzsExample.createCriteria().andGzxsIdEqualTo(id);
                List<GzxsRqktzsDto> gzxsRqktzsList = gzxsRqktzsMapper.selectDetailByExample(gzxsRqktzsExample);
                gzxsGroupDetailDto.getGzxsRqktzsList().addAll(gzxsRqktzsList);
            }
        }

        return gzxsGroupDetailDto;
    }




}
