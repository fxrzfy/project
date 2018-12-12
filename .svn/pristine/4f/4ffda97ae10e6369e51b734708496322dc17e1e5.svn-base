package com.biz.service.impl;

import com.api.dto.ApiGzjlDto;
import com.api.dto.ApiGzrwXzDto;
import com.biz.dto.gzjl.GzjlDto;
import com.biz.dto.gzrw.GzrwDto;
import com.biz.dto.gzrw.GzrwXzDto;
import com.biz.service.GzrwService;
import com.biz.service.BhService;
import com.common.constant.Constant;
import com.core.model.checkmis.*;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;
import com.core.service.CodelistService;
import com.dao.core.checkmis.*;
import com.util.BaseException;
import com.util.DateUtil;
import com.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GzrwServiceImpl implements GzrwService {
    @Autowired
    private GzrwxzMapper gzrwxzMapper;
    @Autowired
    private GzrwxzcyMapper gzrwxzcyMapper;
    @Autowired
    private GzrwMapper gzrwMapper;
    @Autowired
    private BhService rwbhService;
    @Autowired
    private CodelistService codelistService;
    @Autowired
    private GzjlMapper gzjlMapper;
    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<GzrwXzDto> getGzrwXzByRwId(Long rwId) {
        GzrwxzExample example = new GzrwxzExample();
        example.createCriteria().andGzrwIdEqualTo(rwId);
        List<Gzrwxz> zl = this.gzrwxzMapper.selectByExample(example);
        List<GzrwXzDto> zdtol = new ArrayList<>();
        for (Gzrwxz z : zl) {
            GzrwXzDto d = selectXzInfo(z);
            zdtol.add(d);
        }
        return zdtol;
    }

    @Override
    public Gzrw addEditGzrw(Gzrw gzrw, SessionInfo info) {
        if (gzrw.getRwkssj() != null && gzrw.getRwjssj() != null) {
            if (gzrw.getRwjssj().getTime() < gzrw.getRwkssj().getTime()) {
                throw new BaseException("结束时间不能大于开始时间");
            }
        }
        GzrwDto gzrwDto = new GzrwDto();
        BeanUtils.copyProperties(gzrw, gzrwDto);
        System.out.println(gzrwDto.getValid());
        List<Gzrw> dataList = this.gzrwMapper.selectValidRwList(gzrwDto, null);
        if (gzrwDto.getZfsj()==null && dataList.size() > 0) {
            throw new BaseException(dataList.get(0).getRwmc() + "与当前工作任务时间重复，请重新选择");
        }
        if (gzrw.getId() == null) {
            gzrw.setRwbh(rwbhService.getRwBhNextCode(Constant.DMB_RMBH, Constant.DMB_RMBH_NAME));
            gzrw.setRwzt(Short.valueOf("0"));
            gzrw.setCreatedate(new Date());
            gzrw.setCreateuser(info.getName());
            gzrwMapper.insert(gzrw);
            List<GzrwXzDto> gzdl = getInitGzrwXz();
            for (GzrwXzDto gxz : gzdl) {
                Gzrwxz xz = new GzrwXzDto();
                BeanUtils.copyProperties(gxz, xz);
                xz.setGzrwId(gzrw.getId());
                xz.setCreatedate(new Date());
                xz.setCreateuser(info.getName());
                gzrwxzMapper.insert(xz);
            }
        } else {
            gzrw.setModifydate(new Date());
            gzrw.setModifyuser(info.getName());
            gzrwMapper.updateByPrimaryKeySelective(gzrw);
        }
        return gzrw;
    }

    @Override
    public List<GzrwXzDto> getInitGzrwXz() {
        List<GzrwXzDto> gzdl = new ArrayList<>();
        List<CodeListDetail> dl = this.codelistService.selectCodeListDetailListByCode(Constant.DP_TEAM);
        int x = 0;
        for (CodeListDetail cld : dl) {
            x++;
            GzrwXzDto gzrwXzDto = new GzrwXzDto();
            gzrwXzDto.setName(cld.getName());
            gzrwXzDto.setCode(cld.getKey());
            gzrwXzDto.setType("0");
            gzdl.add(gzrwXzDto);
            if (x > 5) {
                break;
            }
        }
        return gzdl;
    }

    @Override
    public DataPage<GzrwDto> list(GzrwDto gzrw, PageHelper pageHelper) {
        DataPage<GzrwDto> dataPage = pageHelper.initPageBean();
        GzrwExample example = new GzrwExample();
        BeanUtils.copyProperties(pageHelper, example);
        GzrwExample.Criteria c = example.or();
        GzrwExample.Criteria c1 = example.or();
        if (!StringUtil.isEmpty(gzrw.getQ())) {
            c.andRwmcLike("%" + gzrw.getQ() + "%");
        }
        if (!StringUtil.isEmpty(gzrw.getQ())) {
            c1.andRwbhLike("%" + gzrw.getQ() + "%");
        }
        if(!StringUtil.isEmpty(gzrw.getZfrange())){
            gzrw.setZfs(DateUtil.parseDate10(gzrw.getZfrange().split("----")[0]));
            gzrw.setZfe(DateUtil.parseDate10(gzrw.getZfrange().split("----")[1]));
        }
        if(!StringUtil.isEmpty(gzrw.getKsrange())){
            gzrw.setKss(DateUtil.parseDate10(gzrw.getKsrange().split("----")[0]));
            gzrw.setKse(DateUtil.parseDate10(gzrw.getKsrange().split("----")[1]));
        }
        if (gzrw.getZfs()!=null) {
            c.andZfsjGreaterThan(gzrw.getZfs());
            c1.andZfsjGreaterThan(gzrw.getZfs());
        }
        if (gzrw.getZfe()!=null) {
            c.andZfsjLessThan(gzrw.getZfe());
            c1.andZfsjLessThan(gzrw.getZfe());
        }
        if (gzrw.getKss() != null) {
            c.andRwkssjGreaterThan(gzrw.getKss());
            c1.andRwkssjGreaterThan(gzrw.getKss());
        }
        if (gzrw.getKse() != null) {
            c.andRwkssjLessThan(gzrw.getKse());
            c1.andRwkssjLessThan(gzrw.getKse());
        }
        example.setOrderByClause("id ");
        List<Gzrw> data = this.gzrwMapper.selectByExample(example);
        List<GzrwDto> dataR = new ArrayList<>();
        for (Gzrw g : data) {//
            GzrwDto gg = new GzrwDto();
            BeanUtils.copyProperties(g, gg);
            if ("2".equals(gzrw.getIsgzjl())) {
                List<GzjlDto> jlList = gzjlMapper.selectGzJlListByGzrw(g.getId());
                for (GzjlDto gd : jlList) {
                    if (gd.getId() == null) {
                        gd.setTbzt(Short.valueOf("0"));
                        gd.setId(-1l);
                        gd.setJhmc(gd.getZm() + gd.getRwmc());
                        gd.setShzt(Short.valueOf("0"));
                    } else {
                        gd.setTbzt(Short.valueOf("1"));
                    }
                    List<Gzrwxzcy> cy = this.selectXzcy(gd.getXzid());
                    String str = "";
                    int i = 0;
                    for (Gzrwxzcy cc : cy) {
                        if (i > 0) {
                            str += "," + cc.getName();
                        } else {
                            str += cc.getName();
                        }
                    }
                    gd.setPersionStr(str);

                }
                gg.setGzjlList(jlList);
            }

            if ("1".equals(gzrw.getIsgzjl())) {
                List<GzjlDto> jlList = gzjlMapper.selectGzJlZZListByGzrw(g.getId());
                gg.setGzjlList(jlList);
            }
            dataR.add(gg);
            dataPage.setData(dataR);
        }
        dataPage.setTotal(example.getTotal());
        return dataPage;
    }

    @Override
    public Gzrw getById(Long id) {
        return this.gzrwMapper.selectByPrimaryKey(id);
    }

//    @Override
//    public void zfGzrw(Gzrw gzrw, SessionInfo info) {
//        Gzrw update=new Gzrw();
//        update.setModifyuser(info.getName());
//        update.setModifydate(new Date());
//        update.setZfsj(gzrw.getZfsj());
//         this.gzrwMapper.updateByPrimaryKeySelective(gzrw);
//    }

    @Override
    public void delGzxz(Long id) {
        GzrwxzcyExample gzrwxzcyExample = new GzrwxzcyExample();
        gzrwxzcyExample.createCriteria().andGzrwxzIdEqualTo(id);
        gzrwxzcyMapper.deleteByExample(gzrwxzcyExample);
        gzrwxzMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateTeam(Long id, String name, String value, SessionInfo info) {
        Gzrwxz gzrwxz = new Gzrwxz();
        if (id > 0) {
            gzrwxz = this.gzrwxzMapper.selectByPrimaryKey(id);
            gzrwxz.setCreatedate(new Date());
            gzrwxz.setCreateuser(info.getName());
        } else {
            gzrwxz.setGzrwId(-id);
        }
        if ("name".equals(name)) {
            String teamName = value;
            GzrwxzExample gzrwxzExample = new GzrwxzExample();
            GzrwxzExample.Criteria criteria = gzrwxzExample.createCriteria();
            criteria.andGzrwIdEqualTo(gzrwxz.getGzrwId()).andNameEqualTo(teamName);
            if (id > 0) {//新增组的保存
                criteria.andIdNotEqualTo(id);
            }
            List<Gzrwxz> gl = this.gzrwxzMapper.selectByExample(gzrwxzExample);
            if (gl.size() > 0) {
                throw new BaseException(teamName + "已经存在");
            }
            gzrwxz.setName(teamName);
            if (id > 0) {
                gzrwxz.setModifydate(new Date());
                gzrwxz.setModifyuser(info.getName());
                this.gzrwxzMapper.updateByPrimaryKey(gzrwxz);
            } else {
                List<CodeListDetail> dl = this.codelistService.selectCodeListDetailListByCode(Constant.DP_TEAM);
                gzrwxz.setCreateuser(info.getName());
                gzrwxz.setCreatedate(new Date());
                for (CodeListDetail cd : dl) {
                    if (cd.getName().equals(teamName)) {
                        gzrwxz.setCode(cd.getKey());
                        break;
                    }
                }
                gzrwxz.setType("0");
                gzrwxzMapper.insert(gzrwxz);
            }
        }
        if ("bz".equals(name)) {
            gzrwxz.setBz(value);
            this.gzrwxzMapper.updateByPrimaryKey(gzrwxz);
        }
        if ("lc".equals(name)) {
            gzrwxz.setLc(value);
            this.gzrwxzMapper.updateByPrimaryKey(gzrwxz);
        }
        if ("cdzdcz".equals(name)) {
            gzrwxz.setCdzdcz(value);
            this.gzrwxzMapper.updateByPrimaryKey(gzrwxz);
        }
        if ("zd".equals(name)) {
            gzrwxz.setZd(value);
            this.gzrwxzMapper.updateByPrimaryKey(gzrwxz);
        }
        if ("gzrap".equals(name)) {
            gzrwxz.setGzrap(value);
            this.gzrwxzMapper.updateByPrimaryKey(gzrwxz);
        }


    }

    @Override
    public void addXzcy(Gzrwxzcy gzrwxzcy, SessionInfo info) {
        gzrwxzcy.setType("0");
        gzrwxzcy.setCreatedate(new Date());
        gzrwxzcy.setCreateuser(info.getName());
        gzrwxzcy.setQszt(Short.valueOf("0"));
        this.gzrwxzcyMapper.insert(gzrwxzcy);
        updateGzrwXzSt(null, gzrwxzcy.getGzrwxzId());
    }

    @Override
    public void freeXzcy(Long id) {
        this.gzrwxzcyMapper.deleteByPrimaryKey(id);
    }

    private void updateGzrwXzSt(Gzrwxz gzrwxz, Long xzId) {
        if (null == gzrwxz) {
            gzrwxz = this.gzrwxzMapper.selectByPrimaryKey(xzId);
        }
        GzrwxzcyExample example = new GzrwxzcyExample();
        example.clear();
        example.createCriteria().andGzrwxzIdEqualTo(gzrwxz.getId());
        long count = gzrwxzcyMapper.countByExample(example);
        if (count > 1) {
            gzrwxz.setType("1");
        } else {
            gzrwxz.setType("0");
        }
        gzrwxzMapper.updateByPrimaryKey(gzrwxz);

    }

    @Override
    public void updateCyRole(Long id, SessionInfo info) {
        Gzrwxzcy gzrwxzcy = this.gzrwxzcyMapper.selectByPrimaryKey(id);
        gzrwxzcy.setModifydate(new Date());
        gzrwxzcy.setModifyuser(info.getName());
        Gzrwxz gzrwxz = this.gzrwxzMapper.selectByPrimaryKey(gzrwxzcy.getGzrwxzId());
        gzrwxz.setModifyuser(info.getName());
        gzrwxz.setModifydate(new Date());
        if ("1".equals(gzrwxzcy.getType())) {
            gzrwxzcy.setType("0");
            //组长变成组员，需要把组设置成无组长状态
            gzrwxz.setType("0");
            gzrwxzMapper.updateByPrimaryKey(gzrwxz);
        } else {
            //gzrwxz.setType("1");
            gzrwxzcy.setType("1");
            //组员变成组长，需要把原来的组长变成组员
            GzrwxzcyExample example = new GzrwxzcyExample();
            example.createCriteria().andGzrwxzIdEqualTo(gzrwxzcy.getGzrwxzId()).andTypeEqualTo("1");
            Gzrwxzcy update = new Gzrwxzcy();
            update.setType("0");
            update.setModifydate(new Date());
            update.setModifyuser(info.getName());
            this.gzrwxzcyMapper.updateByExampleSelective(update, example);
            updateGzrwXzSt(gzrwxz, null);

        }
        gzrwxzcyMapper.updateByPrimaryKey(gzrwxzcy);
    }

    @Override
    public void dimissXz(String ids, String type, SessionInfo info) {
        for (String sid : ids.split(",")) {
            if ("1".equals(type)) {
                updateGzrwXzSt(null, Long.parseLong(sid));
            } else {
                Gzrwxz gzrwxz = this.gzrwxzMapper.selectByPrimaryKey(Long.parseLong(sid));
                gzrwxz.setType(type);
                gzrwxz.setModifydate(new Date());
                gzrwxz.setModifyuser(info.getName());
                this.gzrwxzMapper.updateByPrimaryKey(gzrwxz);
            }

        }
    }

    @Override
    public void delGzrw(Long id) {
        GzjlExample example = new GzjlExample();
        example.createCriteria().andGzrwIdEqualTo(id);
        List<Gzjl> gl = this.gzjlMapper.selectByExample(example);
        if (gl.size() > 0) {
            throw new BaseException("已经填写工作交路，不能删除");
        }
        GzrwxzExample gzrwxzExample = new GzrwxzExample();
        gzrwxzExample.createCriteria().andGzrwIdEqualTo(id);
        List<Gzrwxz> xzl = this.gzrwxzMapper.selectByExample(gzrwxzExample);
        for (Gzrwxz g : xzl) {
            GzrwxzcyExample gzrwxzcyExample = new GzrwxzcyExample();
            gzrwxzcyExample.createCriteria().andGzrwxzIdEqualTo(g.getId());
            this.gzrwxzcyMapper.deleteByExample(gzrwxzcyExample);
        }
        gzrwxzMapper.deleteByExample(gzrwxzExample);
        this.gzrwMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Gzrwxzcy> selectXzcy(Long xzId) {
        GzrwxzcyExample gzrwxzcyExample = new GzrwxzcyExample();
        gzrwxzcyExample.createCriteria().andGzrwxzIdEqualTo(xzId);
        gzrwxzcyExample.setOrderByClause("type desc");
        List<Gzrwxzcy> cyList = this.gzrwxzcyMapper.selectByExample(gzrwxzcyExample);
        return cyList;
    }

    @Override
    public Map<String, List<Gzrwxzcy>> getSignstatus(Long gzrwid) {
        Map<String, List<Gzrwxzcy>> data = new TreeMap<>();
        GzrwxzExample gzrwxzExample = new GzrwxzExample();
        gzrwxzExample.createCriteria().andGzrwIdEqualTo(gzrwid).andTypeNotEqualTo("2");
        List<Gzrwxz> xzl = this.gzrwxzMapper.selectByExample(gzrwxzExample);
        List<Long> ids = new ArrayList<>();
        Map<String, Gzrwxz> map = new HashMap<>();
        for (Gzrwxz z : xzl) {
            map.put(z.getId().toString(), z);
            ids.add(z.getId());
        }
        if (ids.size() == 0) {
            return data;
        }
        GzrwxzcyExample gzrwxzcyExample = new GzrwxzcyExample();
        gzrwxzcyExample.createCriteria().andGzrwxzIdIn(ids);
        List<Gzrwxzcy> cl = this.gzrwxzcyMapper.selectByExample(gzrwxzcyExample);

        for (Gzrwxzcy cy : cl) {
            if (cy.getGzrwxzId() == null) {
                continue;
            }
            String key = map.get(cy.getGzrwxzId().toString()).getName();
            List<Gzrwxzcy> temp = data.get(key);
            if (temp == null) {
                temp = new ArrayList<>();
            }
            temp.add(cy);
            data.put(key, temp);
        }
        return data;
    }

    @Override
    public DataPage<GzrwDto> currentList(String workNumber, String valid, PageHelper pageHelper) {
        GzrwDto gzrwDto = new GzrwDto();
        gzrwDto.setValid(valid);
        gzrwDto.setWorkNumber(workNumber);

        List<Gzrw> gl = this.gzrwMapper.selectValidRwList(gzrwDto, pageHelper);
        List<GzrwDto> dl = new ArrayList<>();
        DataPage<GzrwDto> data = new DataPage<>();
        for (Gzrw g : gl) {
            GzrwDto d = new GzrwDto();
            BeanUtils.copyProperties(g, d);
            if (StringUtil.isEmpty(valid)) {
                continue;
            }
            GzrwxzExample gzrwxzExample = new GzrwxzExample();
            gzrwxzExample.createCriteria().andGzrwIdEqualTo(g.getId()).andTypeNotEqualTo("2");
            List<Gzrwxz> xzl = this.gzrwxzMapper.selectByExample(gzrwxzExample);
            List<ApiGzrwXzDto> xdl = new ArrayList<>();
            for (Gzrwxz xz : xzl) {
                ApiGzrwXzDto xd = new ApiGzrwXzDto();
                BeanUtils.copyProperties(xz, xd);
                List<Gzrwxzcy> cl = this.selectXzcy(xz.getId());
                for (Gzrwxzcy c : cl) {
                    if ("1".equals(c.getType())) {
                        xd.setZzName(c.getName());
                        xd.setZzWorkNumber(c.getWorkNumber());
                    }
                }
                xd.setCyList(cl);
                xdl.add(xd);
            }
            d.setXzDtoList(xdl);
            dl.add(d);
        }
        data.setData(dl);
        data.setTotal(pageHelper.getTotal());
        return data;
    }

    @Override
    public void addTempCy(Gzrwxzcy gzrwxzcy, SessionInfo info) {
        gzrwxzcy.setType("0");
        gzrwxzcy.setQszt(Short.valueOf("1"));
        gzrwxzcy.setQssj(new Date());
        gzrwxzcy.setCreateuser(info.getName());
        gzrwxzcy.setCreatedate(new Date());
        this.gzrwxzcyMapper.insert(gzrwxzcy);
    }

    @Override
    public void sign(Long id, SessionInfo info) {
        Gzrwxzcy gzrwxzcy = this.gzrwxzcyMapper.selectByPrimaryKey(id);
        if (null == gzrwxzcy) {
            throw new BaseException("参数错误，找不到数据");
        }
        gzrwxzcy.setQszt(Short.valueOf("1"));
        gzrwxzcy.setQssj(new Date());
        this.gzrwxzcyMapper.updateByPrimaryKey(gzrwxzcy);
    }

    @Override
    public List<ApiGzjlDto> selectAppGzjlList() {
        List<ApiGzjlDto> data = this.gzrwMapper.selectAppGzjlList();
        for (ApiGzjlDto d : data) {
            List<Gzrwxzcy> clList = this.selectXzcy(d.getXzId());
            d.setCyList(clList);
        }
        return data;
    }

    @Override
    public GzrwXzDto selectXzInfo(Gzrwxz z) {
        GzrwXzDto d = new GzrwXzDto();
        BeanUtils.copyProperties(z, d);
        List<Gzrwxzcy> cyList = selectXzcy(z.getId());
        String persons = "";
        d.setCyList(cyList);
        for (Gzrwxzcy gzrwxzcy : cyList) {
            if (!"".equals(persons)) {
                persons += ",";
            }
            persons += gzrwxzcy.getName();
            if ("1".equals(gzrwxzcy.getType())) {
                persons += "[组长]";
                d.setWorkNumber(gzrwxzcy.getWorkNumber());
            }
        }
        d.setPersonStr(persons);
        return d;
    }

    @Override
    public void addGzrwxzcys(String ids,Long xzId,SessionInfo info) {
        if(StringUtil.isEmpty(ids)){
            throw new BaseException("ids 不能为空");
        }
        if(null==xzId){
            throw new BaseException("xzId 不能为空");
        }
        for(String id:ids.split(",")){
            Person p=this.personMapper.selectByPrimaryKey(Long.parseLong(id));
            Gzrwxzcy gzrwxzcy=new Gzrwxzcy();
            gzrwxzcy.setName(p.getName());
            gzrwxzcy.setWorkNumber(p.getWorkNumber());
            gzrwxzcy.setGzrwxzId(xzId);
            gzrwxzcy.setType("0");
            gzrwxzcy.setCreatedate(new Date());
            gzrwxzcy.setCreateuser(info.getName());
            gzrwxzcy.setQszt(Short.valueOf("0"));
            this.gzrwxzcyMapper.insert(gzrwxzcy);
            updateGzrwXzSt(null, gzrwxzcy.getGzrwxzId());
        }
    }
}
