package com.biz.service.impl;

import com.biz.service.BhService;
import com.core.model.checkmis.GzjldbhDmb;
import com.core.model.checkmis.GzjldbhDmbExample;
import com.core.model.checkmis.RwbhGzb;
import com.core.model.checkmis.RwbhGzbExample;
import com.dao.core.checkmis.GzjldbhDmbMapper;
import com.dao.core.checkmis.RwbhGzbMapper;
import com.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BhServiceImpl implements BhService {
    @Autowired
    private RwbhGzbMapper rwbhGzbMapper;

    @Autowired
    private GzjldbhDmbMapper gzjldbhDmbMapper;

    @Override
    public String getRwBhNextCode(String type,String name) {
        String nyr= DateUtil.formateDatesdf8(new Date());
        RwbhGzbExample example=new RwbhGzbExample();
        example.setOrderByClause("id desc");
        example.setRows(1);
        example.setPage(1);
        example.createCriteria().andTypeEqualTo(type).andNyrEqualTo(nyr);
        List<RwbhGzb> gl=this.rwbhGzbMapper.selectByExample(example);
        RwbhGzb curr=null;
        if(gl.size()>0){
            curr=gl.get(0);
        }
        if(curr==null){
            curr=new RwbhGzb();
            curr.setType(type);
            curr.setName(name);
            curr.setCreatedate(new Date());
            curr.setNyr(nyr);
            curr.setLjz(0l);
        }else{
            curr.setModifydate(new Date());
        }
        curr.setLjz(curr.getLjz()+1);
        if(curr.getId()==null){
            this.rwbhGzbMapper.insert(curr);
        }else{
            this.rwbhGzbMapper.updateByPrimaryKey(curr);
        }
        return curr.getName()+curr.getNyr()+String.format("%05d",curr.getLjz());
    }

    @Override
    public String  getGzjlBhNextCode(String type, String name,String zzgh) {
        GzjldbhDmbExample example =new GzjldbhDmbExample();
        String year=DateUtil.getYear();
        String month=DateUtil.getMonth();
        example.createCriteria().andTypeEqualTo(type).andGdzEqualTo(name).andZzghEqualTo(zzgh).andYearEqualTo(year).andMonthEqualTo(month);
        List<GzjldbhDmb>gl=this.gzjldbhDmbMapper.selectByExample(example);
        GzjldbhDmb gzjldbhDmb=null;
        if(gl.size()>0){
            gzjldbhDmb=gl.get(0);
        }
        if(gzjldbhDmb==null){
            gzjldbhDmb=new GzjldbhDmb();
            gzjldbhDmb.setType(type);
            gzjldbhDmb.setCreatedate(new Date());
            gzjldbhDmb.setGdz(name);
            gzjldbhDmb.setMonth(month);
            gzjldbhDmb.setYear(year);
            gzjldbhDmb.setZzgh(zzgh);
            gzjldbhDmb.setSws(0);
        }else{
            gzjldbhDmb.setModifydate(new Date());
        }
        gzjldbhDmb.setSws(gzjldbhDmb.getSws()+1);
        if(null==gzjldbhDmb.getId()){
            this.gzjldbhDmbMapper.insert(gzjldbhDmb);
        }else{
            this.gzjldbhDmbMapper.updateByPrimayKey(gzjldbhDmb);
        }
        return name+"["+year+"]"+type+month+zzgh+String.format("%03d",gzjldbhDmb.getSws());
    }
}
