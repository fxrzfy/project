package com.biz.service.impl;

import com.biz.dto.gzjl.*;
import com.biz.service.BhService;
import com.biz.service.GzjlService;
import com.biz.service.GzrwService;
import com.common.constant.Constant;
import com.common.dto.FileDto;
import com.core.model.checkmis.*;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;
import com.dao.core.checkmis.*;
import com.util.BaseException;
import com.util.DateUtil;
import com.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GzjlServiceImpl implements GzjlService {
    @Autowired
    private GzjlMapper gzjlMapper;

    @Autowired
    private GzjlmxMapper gzjlmxMapper;

    @Autowired
    private GzrwMapper gzrwMapper;

    @Autowired
    private GzrwxzMapper gzrwxzMapper;

    @Autowired
    private GzrwxzcyMapper gzrwxzcyMapper;

    @Autowired
    private BhService bhService;

    @Autowired
    private GzjljclcMapper gzjljclcMapper;

    @Autowired
    private GzjlJcczMapper gzjlJcczMapper;
    @Autowired
    private GzrwService gzrwService;


    @Override
    public GzjlDto getById(Long id, Long gzrwId, Long gzrwxzId, SessionInfo info) {
        GzjlDto gzjlDto = new GzjlDto();
        Gzrw g = null;
        if (null != id && id > 0) {
            Gzjl gzjl = gzjlMapper.selectByPrimaryKey(id);
            gzrwId = gzjl.getGzrwId();
            BeanUtils.copyProperties(gzjl, gzjlDto);
            gzjlDto.setCopytarget(0l);
            List<GzjlDto> gl = this.gzjlMapper.selectGzJlListByGzrw(gzjl.getGzrwId());
            for (GzjlDto ggg : gl) {
                if (info.getPerson().getWorkNumber().equals(ggg.getWorkNumber())) {
                    gzjlDto.setCopytarget(ggg.getXzid());
                    break;
                }
            }

        } else {
            GzjlExample example = new GzjlExample();
            example.createCriteria().andXzidEqualTo(gzrwxzId).andGzrwIdEqualTo(gzrwId);
            List<Gzjl> gl = this.gzjlMapper.selectByExample(example);
            if (gl.size() > 0) {
                Gzjl gzjl = gl.get(0);
                BeanUtils.copyProperties(gzjl, gzjlDto);
            } else {
                Gzrwxz gzrwxz = gzrwxzMapper.selectByPrimaryKey(gzrwxzId);
                g = this.gzrwMapper.selectByPrimaryKey(gzrwId);
                gzjlDto.setZm(gzrwxz.getName());
                gzjlDto.setXzid(gzrwxz.getId());
                gzjlDto.setJhmc(gzrwxz.getName() + g.getRwmc());
                gzjlDto.setGzrwId(gzrwId);
            }
        }
        if (null == g) {
            g = this.gzrwMapper.selectByPrimaryKey(gzjlDto.getGzrwId());
        }
        gzjlDto.setRwmc(g.getRwmc());
        return gzjlDto;
    }

    @Override
    public void addEditGzjl(GzjlDto gzjl, SessionInfo info) {
        GzjlExample example = new GzjlExample();
        example.createCriteria().andGzrwIdEqualTo(gzjl.getGzrwId()).andXzidEqualTo(gzjl.getXzid());
        List<Gzjl> gl = this.gzjlMapper.selectByExample(example);
        if (gl.size() > 0) {
            if (gzjl.getId() == null) {
                throw new BaseException("工作交路已经存在");
            }
            for (Gzjl g : gl) {
                if (!g.getId().equals(gzjl.getId())) {
                    throw new BaseException("工作交路已经存在");
                }
            }
        }
        if (null == gzjl.getId()) {
            gzjl.setShzt(Short.valueOf("0"));
            gzjl.setJhbh(bhService.getGzjlBhNextCode(Constant.DMB_GZJL, Constant.DMB_GZJL_GDZ, gzjl.getWorkNumber()));
            gzjl.setCreatedate(new Date());
            gzjl.setCreateuser(info.getName());
            this.gzjlMapper.insert(gzjl);
        } else {
            Gzjl g=this.gzjlMapper.selectByPrimaryKey(gzjl.getId());
            checkGzjl(g);
            gzjl.setModifydate(new Date());
            gzjl.setModifyuser(info.getName());
            this.gzjlMapper.updateByPrimaryKeySelective(gzjl);
        }
    }

    @Override
    public void deleteGzjl(Long id, SessionInfo info) {
        Gzjl gzjl = this.gzjlMapper.selectByPrimaryKey(id);
        if (gzjl.getShzt() != 0 || gzjl.getShzt() != 3) {
            throw new BaseException("状态不对不能删除");
        }
        this.gzjlMapper.deleteByPrimaryKey(id);
    }

    @Override
    public DataPage<GzjhDto> selectGzjlmx(GzjlmxDto gzjlmxDto) {
        GzjlmxExample gzjlmxExample = new GzjlmxExample();
        gzjlmxExample.setRows(1000);
        gzjlmxExample.createCriteria().andGzjlIdEqualTo(gzjlmxDto.getGzjlId());
        DataPage<GzjhDto> dataPage = new DataPage<>();
        gzjlmxExample.setOrderByClause("JHKSSJ");
        List<Gzjlmx> data = this.gzjlmxMapper.selectByExample(gzjlmxExample);
        List<GzjhDto> larr = new ArrayList<>();
        GzjhDto pre=null;
        for (Gzjlmx gzjlmx : data) {//
            GzjhDto gzjhDto = new GzjhDto();
            gzjhDto.setGzjlId(gzjlmx.getId());
            gzjhDto.setJhlx(gzjlmx.getJhlx().toString());
            if (gzjlmx.getJhkssj().compareTo(gzjlmx.getJhjssj()) == 0) {
                gzjhDto.setRq(DateUtil.getMonthDay(gzjlmx.getJhkssj()));
            } else {
                gzjhDto.setRq(DateUtil.getMonthDay(gzjlmx.getJhkssj()) + "-" + DateUtil.getMonthDay(gzjlmx.getJhjssj()));
            }
            gzjhDto.setBz(gzjlmx.getBz());
            if (gzjlmx.getJhlx() == 0) {
                if(pre!=null){
                    larr.add(pre);
                    pre=null;
                }
                GzjlJcczExample jcczExample = new GzjlJcczExample();
                jcczExample.setOrderByClause("JCCZ_KSSJ");
                jcczExample.createCriteria().andGzjlmxIdEqualTo(gzjlmx.getId());
                List<GzjlJccz> czList=new ArrayList<>();
                if(!"cz".equals(gzjlmxDto.getType())){
                    czList = this.gzjlJcczMapper.selectByExample(jcczExample);
                }
                GzjljclcExample gzjljclcExample = new GzjljclcExample();
                gzjljclcExample.setOrderByClause("JCLC_KSSJ");
                gzjljclcExample.createCriteria().andGzjlmxIdEqualTo(gzjlmx.getId());
                List<Gzjljclc> lcList=new ArrayList<>();
                if(!"lc".equals(gzjlmxDto.getType())){
                    lcList= this.gzjljclcMapper.selectByExample(gzjljclcExample);
                }
                int czl = czList.size();
                int lcl = lcList.size();
                int bigl = lcl > czl ? lcl : czl;
                for (int i = 0; i < bigl; i++) {
                    GzjhDto g = new GzjhDto();
                    BeanUtils.copyProperties(gzjhDto, g);
                    if (i < czl) {
                        GzjlJccz c = czList.get(i);
                        g.setBz(null);
                        g.setCz(c.getJccz());
                        g.setSj(c.getJcczKssj() + "-" + c.getJcczJssj());
                        g.setJczd(c.getJczd());

                        g.setStart(DateUtil.getDayTime(gzjlmx.getJhkssj(), c.getJcczKssj()));
                        g.setEnd(DateUtil.getDayTime(gzjlmx.getJhjssj(), c.getJcczJssj()));
                    }
                    if (i < lcl) {
                        Gzjljclc l = lcList.get(i);
                        g.setBz(l.getBz());
                        g.setCc(l.getJccc());
                        g.setDdd(l.getDdd());
                        g.setQd(l.getQd());
                        g.setJcsj(l.getJclcKssj() + "-" + l.getJclcJssj());
                        g.setStart(DateUtil.getDayTime(gzjlmx.getJhkssj(), l.getJclcKssj()));
                        g.setEnd(DateUtil.getDayTime(gzjlmx.getJhjssj(), l.getJclcJssj()));
                    }
                    g.setType(gzjlmx.getJhlx().toString());
                    larr.add(g);
                }
            } else {
                gzjhDto.setStart(gzjlmx.getJhkssj());
                gzjhDto.setEnd(DateUtil.getDayEndOfDay(gzjlmx.getJhjssj()));
                gzjhDto.setType(gzjlmx.getJhlx().toString());
                if(pre==null){
                    pre=gzjhDto;
                    continue;
                }
                if(check(pre,gzjhDto,gzjlmxDto.getEdit())){//同一类
                    if(pre.getRq().indexOf("-")==-1){
                        pre.setRq(pre.getRq()+"-"+gzjhDto.getRq());
                    }else{
                        pre.setRq(pre.getRq().split("-")[0]+"-"+gzjhDto.getRq());
                    }
                    continue;
                }else{
                    larr.add(pre);
                    pre=gzjhDto;
                    //continue;
                }
            }
        }
        if(pre!=null){
            larr.add(pre);
        }
        dataPage.setPage(1);
        dataPage.setRows(larr.size());
        dataPage.setData(larr);
        dataPage.setTotal(larr.size());
        return dataPage;
    }
    private boolean check(GzjhDto pre,GzjhDto curr,String edit){
        if(!StringUtil.isEmpty(edit)){
            return false;
        }
        if(!pre.getType().equals(curr.getType())){
            return false;
        }
        if(pre.getBz()!=null &&  !pre.getBz().equals(curr.getBz())){
            return false;
        }
        return true;
    }

    @Override
    public void addGzjlmx(GzjlmxDto gzjlmx, SessionInfo info) {
        Gzjl gzjl = this.gzjlMapper.selectByPrimaryKey(gzjlmx.getGzjlId());
        checkGzjl(gzjl);
        if (gzjlmx.getJhkssj().getTime() > gzjlmx.getJhjssj().getTime()) {
            throw new BaseException("开始时间不能大于结束时间");
        }
        DataPage<GzjhDto> dataPage = this.selectGzjlmx(gzjlmx);
        List<GzjhDto> checkMapList = new ArrayList<>();
        for (GzjhDto d : dataPage.getData()) {
            if (gzjlmx.getId() != null && gzjlmx.getId() > 0) {
                if (d.getGzjlId().equals(gzjlmx.getId())) {//排除自身
                    continue;
                }
            }
            checkMapList.add(d);
        }
        if (gzjlmx.getJhlx() == 1 || gzjlmx.getJhlx() == 2) {//一天为单位
            Date d1 = gzjlmx.getJhkssj();
            Date d2 = DateUtil.getDayEndOfDay(gzjlmx.getJhjssj());
            DateUtil.dateInRange(d1, d2, checkMapList);
        }
        if (gzjlmx.getJhlx() == 0 || gzjlmx.getJhlx() == 2) {
            if (gzjlmx.getId() == null || gzjlmx.getId() < 0) {
                gzjlmxMapper.insert(gzjlmx);
            } else {
                gzjlmxMapper.updateByPrimaryKeySelective(gzjlmx);
            }
            if (gzjlmx.getJhlx() == 2) {
                return;
            }
            boolean czempty = true;
            boolean lcempty = true;
            List<Map> lc = gzjlmx.getDatalc();
            List<Map> cz = gzjlmx.getDatacz();
            if (lc != null && lc.size() > 0) {
                lcempty = false;
            }
            if (cz != null && cz.size() > 0) {
                czempty = false;
            }
            if (lcempty && czempty) {
                throw new BaseException("数据错误,检查列车和检查车站必须要选择一个");
            }
            if (gzjlmx.getId() != null) {
                GzjljclcExample example = new GzjljclcExample();
                example.createCriteria().andGzjlmxIdEqualTo(gzjlmx.getId());
                this.gzjljclcMapper.deleteByExample(example);
                GzjlJcczExample gzjlJcczExample = new GzjlJcczExample();
                gzjlJcczExample.createCriteria().andGzjlmxIdEqualTo(gzjlmx.getId());
                this.gzjlJcczMapper.deleteByExample(gzjlJcczExample);
            }
            if (!lcempty) {
                for (Object o : lc) {
                    Gzjljclc gzjljclc = new Gzjljclc();
                    Map<String, String> m = (Map<String, String>) o;
                    String daterange = m.get("jcsj");
                    gzjljclc.setJclcKssj(daterange.split("-")[0]);
                    gzjljclc.setJclcJssj(daterange.split("-")[1]);
                    gzjljclc.setGzjlmxId(gzjlmx.getId());
                    gzjljclc.setBz(m.get("bz"));
                    gzjljclc.setCreateuser(info.getName());
                    gzjljclc.setCreatedate(new Date());
                    gzjljclc.setJccc(m.get("jccc"));
                    gzjljclc.setDdd(m.get("ddd"));
                    gzjljclc.setQd(m.get("qd"));
                    gzjljclc.setCreatedate(new Date());

                    this.gzjljclcMapper.insert(gzjljclc);
                }
            }
            if (!czempty) {
                for (Object o : cz) {
                    GzjlJccz gzjlJccz = new GzjlJccz();
                    Map<String, String> m = (Map<String, String>) o;
                    String daterange = m.get("daterange");
                    gzjlJccz.setJcczKssj(daterange.split("-")[0]);
                    gzjlJccz.setJcczJssj(daterange.split("-")[1]);
                    gzjlJccz.setGzjlmxId(gzjlmx.getId());
                    gzjlJccz.setJccz(m.get("jccz"));
                    gzjlJccz.setJczd(m.get("jczd"));
                    gzjlJccz.setCreatedate(new Date());
                    gzjlJccz.setCreateuser(info.getName());
                    Date d1 = DateUtil.getDayTime(gzjlmx.getJhkssj(), gzjlJccz.getJcczKssj());
                    Date d2 = DateUtil.getDayTime(gzjlmx.getJhjssj(), gzjlJccz.getJcczJssj());
                    DateUtil.dateInRange(d1, d2, checkMapList);
                    GzjhDto gzjhDto = new GzjhDto();
                    gzjhDto.setStart(d1);
                    gzjhDto.setEnd(d2);
                    gzjhDto.setJhlx("0");
                    checkMapList.add(gzjhDto);
                    this.gzjlJcczMapper.insert(gzjlJccz);
                }
            }
        } else if (gzjlmx.getJhlx() == 1) {//休息
            List<Date> dl = DateUtil.datesListInRange(gzjlmx.getJhkssj(), gzjlmx.getJhjssj());
            if (gzjlmx.getId() != null && gzjlmx.getId() > 0) {
                this.gzjlmxMapper.deleteByPrimaryKey(gzjlmx.getId());
            }
            for (Date d : dl) {
                gzjlmx.setJhkssj(d);
                gzjlmx.setJhjssj(d);
                gzjlmxMapper.insert(gzjlmx);
            }
        }
    }

    @Override
    public DataPage<GzjlJcczDto> selectJccz(GzjlmxDto gzjlJccz, PageHelper pageHelper) {
        GzjlJcczExample example = new GzjlJcczExample();
        example.setOrderByClause("JCCZ_KSSJ");
        example.createCriteria().andGzjlmxIdEqualTo(gzjlJccz.getId());
        DataPage<GzjlJcczDto> data = pageHelper.initPageBean();
        List<GzjlJccz> d = this.gzjlJcczMapper.selectByExample(example);
        List<GzjlJcczDto> dl = new ArrayList<>();
        for (GzjlJccz cz : d) {
            GzjlJcczDto g = new GzjlJcczDto();
            BeanUtils.copyProperties(cz, g);
            g.setDaterange(cz.getJcczKssj() + "-" + cz.getJcczJssj());
            dl.add(g);
        }
        data.setTotal(example.getTotal());
        data.setData(dl);
        return data;
    }

    @Override
    public DataPage<GzjlJclcDto> selectJclc(GzjlmxDto gzjlJclc, PageHelper pageHelper) {
        GzjljclcExample example = new GzjljclcExample();
        example.setOrderByClause("JCLC_KSSJ");
        example.createCriteria().andGzjlmxIdEqualTo(gzjlJclc.getId());
        DataPage<GzjlJclcDto> data = pageHelper.initPageBean();
        List<Gzjljclc> d = this.gzjljclcMapper.selectByExample(example);
        List<GzjlJclcDto> dl = new ArrayList<>();
        for (Gzjljclc lc : d) {
            GzjlJclcDto g = new GzjlJclcDto();
            BeanUtils.copyProperties(lc, g);
            g.setJcsj(lc.getJclcKssj() + "-" + lc.getJclcJssj());
            dl.add(g);
        }
        data.setTotal(example.getTotal());
        data.setData(dl);
        return data;
    }

    @Override
    public Gzjlmx getGzmxById(Long id) {
        return gzjlmxMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteGzjlMx(Long id) {
        gzjlmxMapper.deleteByPrimaryKey(id);
        GzjljclcExample example = new GzjljclcExample();
        example.createCriteria().andGzjlmxIdEqualTo(id);
        this.gzjljclcMapper.deleteByExample(example);
        GzjlJcczExample gzjlJccz = new GzjlJcczExample();
        gzjlJccz.createCriteria().andGzjlmxIdEqualTo(id);
        this.gzjlJcczMapper.deleteByExample(gzjlJccz);

    }

    private void checkGzjl(Gzjl gzjl) {
        if (gzjl.getShzt() != 0 && gzjl.getShzt() != 3) {
           // throw new BaseException("工作交路状态不正确，不能编辑");
        }
    }

    @Override
    public void copy(Long id, Long toxzId, SessionInfo info) {
        Gzjl gzjl = this.gzjlMapper.selectByPrimaryKey(id);
        Gzjl to = new GzjlDto();
        GzjlExample example = new GzjlExample();
        example.createCriteria().andGzrwIdEqualTo(gzjl.getGzrwId()).andXzidEqualTo(toxzId);
        List<Gzjl> gl = this.gzjlMapper.selectByExample(example);
        if (gl.size() > 0) {
            to = gl.get(0);
            checkGzjl(to);
        } else {
            Gzrw gzrw = this.gzrwMapper.selectByPrimaryKey(gzjl.getGzrwId());
            gzjl.setJhbh(bhService.getGzjlBhNextCode(Constant.DMB_GZJL, Constant.DMB_GZJL_GDZ, info.getPerson().getWorkNumber()));
            gzjl.setShzt(Short.valueOf("0"));
            gzjl.setXzid(toxzId);
            this.gzjlMapper.insert(gzjl);
            to = gzjl;
        }
        GzjlmxExample gzjlmxExample = new GzjlmxExample();
        gzjlmxExample.createCriteria().andGzjlIdEqualTo(gzjl.getId());
        List<Gzjlmx> mxl = this.gzjlmxMapper.selectByExample(gzjlmxExample);
        if (mxl.size() > 0) {
            for (Gzjlmx mx : mxl) {
                Long oid = mx.getId();
                mx.setGzjlId(to.getId());
                this.gzjlmxMapper.insert(mx);
                if (mx.getJhlx() == 0) {
                    GzjlJcczExample jcczExample = new GzjlJcczExample();
                    jcczExample.createCriteria().andGzjlmxIdEqualTo(oid);
                    List<GzjlJccz> czl = this.gzjlJcczMapper.selectByExample(jcczExample);
                    for (GzjlJccz c : czl) {
                        c.setGzjlmxId(mx.getId());
                        this.gzjlJcczMapper.insert(c);
                    }
                    GzjljclcExample gzjljclcExample = new GzjljclcExample();
                    gzjljclcExample.createCriteria().andGzjlmxIdEqualTo(oid);
                    List<Gzjljclc> cll = this.gzjljclcMapper.selectByExample(gzjljclcExample);
                    for (Gzjljclc c : cll) {
                        c.setGzjlmxId(mx.getId());
                        this.gzjljclcMapper.insert(c);
                    }
                }


            }
        }


    }

    @Override
    public void apply(Long id, SessionInfo info) {
        GzjlmxDto gzjlmx = new GzjlmxDto();
        gzjlmx.setGzjlId(id);
        DataPage<GzjhDto> dataPage = this.selectGzjlmx(gzjlmx);
        List<GzjhDto> checkMapList = new ArrayList<>();

        for (GzjhDto gzjhDto : dataPage.getData()) {
            DateUtil.dateInRange(gzjhDto.getStart(), gzjhDto.getEnd(), checkMapList);
            checkMapList.add(gzjhDto);
        }
        Gzjl g = this.gzjlMapper.selectByPrimaryKey(id);
        if (g.getShzt() == 0) {
            g.setModifydate(new Date());
            g.setModifyuser(info.getName());
            g.setShzt(Short.valueOf("1"));
            this.gzjlMapper.updateByPrimaryKeySelective(g);
            return;
        }
        throw new BaseException("状态不正确，不能提交审核");
    }

    @Override
    public GzjlCheckDto getCheckData(String ids, SessionInfo info) {
        GzjlCheckDto gzjlCheckDto=new GzjlCheckDto();
        if (StringUtil.isEmpty(ids)) {
            throw new BaseException("参数错误，ids不能为空");
        }
        List<GzjlDto> gl = new ArrayList<>();
        Long gzrwid = -1l;
        StringBuilder sb = new StringBuilder();

        for (String s : ids.split(",")) {
            Gzjl gzjl = this.gzjlMapper.selectByPrimaryKey(Long.parseLong(s));
            GzjlDto gzjlDto=new GzjlDto();
            BeanUtils.copyProperties(gzjl,gzjlDto);
            if (gzrwid > 0 && gzrwid != gzjl.getGzrwId()) {
                throw new BaseException("只能选择同一个工作任务下面的数据来处理");
            } else {
                gzrwid = gzjl.getGzrwId();
            }
            if (sb.length() > 0) {
                sb.delete(0, sb.length());
            }
            List<Gzrwxzcy> cl = gzrwService.selectXzcy(gzjl.getXzid());
            for(Gzrwxzcy c:cl){
                if(sb.length()>0){
                    sb.append(",");
                    sb.append(c.getName());
                }else{
                    sb.append(c.getName());
                }
            }
            gzjlDto.setPersionStr(sb.toString());
            gl.add(gzjlDto);
        }
        Gzrw gzrw=this.gzrwMapper.selectByPrimaryKey(gzrwid);
        gzjlCheckDto.setGzjlList(gl);
        gzjlCheckDto.setGzrwId(gzrw.getId());
        gzjlCheckDto.setRwmc(gzrw.getRwmc());
        gzjlCheckDto.setRwjh(gzrw.getRwbh());

        return gzjlCheckDto;
    }

    @Override
    public void check(BatchGzjl batchGzjl, SessionInfo info) {
        for(Gzjl g:batchGzjl.getData()){
            Gzjl gzjl=new Gzjl();
            gzjl.setId(g.getId());
            gzjl.setShzt(g.getShzt());
            gzjl.setShbz(g.getShbz());
            gzjl.setModifydate(new Date());
            gzjl.setModifyuser(info.getName());
            this.gzjlMapper.updateByPrimaryKeySelective(gzjl);
        }
    }

    @Override
    public FileDto getDownPdfData(GzjlmxDto   gzjlDto) {
        DataPage<GzjhDto> jhdata=selectGzjlmx(gzjlDto);
        Gzjl gzjl=this.gzjlMapper.selectByPrimaryKey(gzjlDto.getGzjlId());
        FileDto fileDto =new FileDto();
        fileDto.setFileName(gzjl.getJhmc()+".pdf");
        fileDto.setJhList(jhdata.getData());
        return fileDto;
    }
}
