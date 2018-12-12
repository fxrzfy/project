package com.biz.service.impl;

import com.biz.dto.gzrw.ZdDmbDto;
import com.biz.service.ZszService;
import com.core.model.checkmis.*;
import com.core.pageModel.*;
import com.dao.core.checkmis.DeptMapper;
import com.dao.core.checkmis.ZdDmbMapper;
import com.dao.core.checkmis.ZzdwDmbMapper;
import com.dao.core.checkmis.ZzdwZdMapMapper;
import com.util.BaseException;
import com.util.PinyinUtil;
import com.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ZszServiceImpl implements ZszService {
    @Autowired
    private ZzdwDmbMapper zzdwDmbMapper;
    @Autowired
    private ZdDmbMapper zdDmbMapper;
    @Autowired
    private ZzdwZdMapMapper zzdwZdMapMapper;
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Tree> tree(SessionInfo sessionInfo,String type) {
        if(StringUtil.isEmpty(type)){
            return new ArrayList<>();
        }
        List<Tree> lt = new ArrayList<Tree>();
        List<Tree> ltToal = new ArrayList<Tree>();
        Tree total = new Tree();
        total.setPid("-10");
        total.setId("0");
        total.setText("分类");
        total.setChildren(lt);


        Tree zsz = new Tree();
        zsz.setPid("-9");
        zsz.setId("-1");
        zsz.setType("1");
        zsz.setText("直属站");

        Tree cwd = new Tree();
        cwd.setPid("-9");
        cwd.setId("-2");
        cwd.setType("2");
        cwd.setText("车务段");

        Tree hyzx = new Tree();
        hyzx.setPid("-9");
        hyzx.setId("-3");
        hyzx.setType("3");
        hyzx.setText("货运中心");

        Tree kyd = new Tree();
        kyd.setPid("-9");
        kyd.setId("-4");
        kyd.setType("4");
        kyd.setText("客运段");
        if("x".equals(type)){//直属站车务段
            ltToal.add(total);
            lt.add(zsz);
            lt.add(cwd);
        }else if("y".equals(type)){//货运中心
            ltToal.add(hyzx);
            //hyzx.setChildren(lt);
            lt.add(hyzx);

        }else if("z".equals(type)){//客运段
            ltToal.add(kyd);
            //kyd.setChildren(lt);
            lt.add(kyd);
        }

        Map<String,Tree>m=new HashMap<>();
        Map<String,Tree>subm=new HashMap<>();
        for(Tree tr:lt){
            m.put(tr.getType(),tr);
        }
        List<String>tl=new ArrayList<>();
        tl.addAll(m.keySet());
        ZzdwDmbExample example=new ZzdwDmbExample();
        example.createCriteria().andTypeIn(tl);
        example.setOrderByClause("pid");
        List<ZzdwDmb> data=this.zzdwDmbMapper.selectByExample(example);
        if(data.size()>0){
            for(ZzdwDmb d:data){
                Tree x=new Tree();
                x.setType(d.getType());
                x.setText(d.getName());
                x.setId(d.getId()+"");
                if(d.getPid()==null||d.getPid()==0){
                    Tree t=m.get(d.getType());
                    if(null!=t){
                        x.setPid(t.getId());
                        t.addChild(x);
                    }
                    subm.put(d.getId().toString(),x);
                }else{
                    Tree t=subm.get(d.getPid().toString());
                    if(null!=t){
                        x.setPid(t.getId());
                        x.setAttributes("1");
                        t.addChild(x);
                    }
                }
            }
        }
        return ltToal;
    }

    @Override
    public void addEdit(ZzdwDmb zzdwDmb, SessionInfo info) {
        ZzdwDmbExample example=new ZzdwDmbExample();
        ZzdwDmbExample.Criteria c=example.createCriteria();
        if(zzdwDmb.getId()!=null){
            c.andIdNotEqualTo(zzdwDmb.getId());
        }
        c.andCodeEqualTo(zzdwDmb.getCode()).andTypeEqualTo(zzdwDmb.getType());
        if(zzdwDmbMapper.countByExample(example)>0){
            throw  new BaseException("代码"+zzdwDmb.getCode()+"已经存在");
        }
        example.clear();
        c=example.createCriteria();
        if(zzdwDmb.getId()!=null){
            c.andIdNotEqualTo(zzdwDmb.getId());
        }
        c.andTypeEqualTo(zzdwDmb.getType()).andNameEqualTo(zzdwDmb.getName());
        if(zzdwDmbMapper.countByExample(example)>0){
            throw  new BaseException("名称"+zzdwDmb.getName()+"已经存在");
        }
        if(null!=zzdwDmb.getId()){

            zzdwDmb.setModifydate(new Date());
            zzdwDmb.setModifyuser(info.getName());
            this.zzdwDmbMapper.updateByPrimaryKeySelective(zzdwDmb);
        }else{
            if(zzdwDmb.getPid()==null||zzdwDmb.getPid()<0){
                zzdwDmb.setPid(0l);
            }
            zzdwDmb.setCreatedate(new Date());
            zzdwDmb.setCreateuser(info.getName());
            this.zzdwDmbMapper.insert(zzdwDmb);
        }
    }

    @Override
    public ZzdwDmb getById(Long id) {
        return this.zzdwDmbMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delZszById(Long id) {
        ZzdwZdMapExample zzdwZdMap=new ZzdwZdMapExample();
        zzdwZdMap.createCriteria().andDeptIdEqualTo(id);
        zzdwZdMapMapper.deleteByExample(zzdwZdMap);
        zzdwDmbMapper.deleteByPrimaryKey(id);
    }

    @Override
    public DataPage<ZdDmb> datatGrid(ZdDmbDto zdDmb, PageHelper pageHelper) {
        DataPage<ZdDmb> dataPage=pageHelper.initPageBean();
        ZdDmbExample example=new ZdDmbExample();
        BeanUtils.copyProperties(pageHelper,example);
        example.createCriteria().andDeptIdEqualTo(zdDmb.getZszId(),zdDmb.getType());
        List<ZdDmb>data=this.zdDmbMapper.selectByExample(example);
        dataPage.setData(data);
        dataPage.setTotal(example.getTotal());
        return dataPage;
    }

    @Override
    public ZdDmb getZdDmById(Long id) {
        return zdDmbMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delZDmById(String ids,Long deptId) {

        for(String sid:ids.split(",")){
            ZzdwZdMapExample example=new ZzdwZdMapExample();
            example.createCriteria().andDeptIdEqualTo(deptId).andZdIdEqualTo(Long.parseLong(sid));
            zzdwZdMapMapper.deleteByExample(example);
        }
        }


    private void generateCode(ZdDmb zdDmb){
        if(null==zdDmb.getName()){
            return ;
        }
        String code=PinyinUtil.getFirstSpell(zdDmb.getName());
        if(zdDmb.getCode() !=null && zdDmb.getCode().startsWith(code)){
            return ;
        }
        ZdDmbExample zdDmbExample =new ZdDmbExample();
        int i=0;
        boolean brankWhile=false;
        while (true){
            String tmp=code;
            if(i>0){
                tmp=tmp+"_"+i;
            }
            zdDmbExample.createCriteria().andCodeEqualTo(tmp);
            List<ZdDmb> zl=this.zdDmbMapper.selectByExample(zdDmbExample);
            if(zl.size()>0){
                for(ZdDmb z:zl){
                    if(zdDmb.getId()==null){
                        break;
                    }
                    if(!zdDmb.getId().equals(z.getId())){
                        break;
                    }

                    brankWhile=true;
                }
            }else{
                brankWhile=true;
            }
            if(brankWhile){
                code=tmp;
                break;
            }else{
                zdDmbExample.clear();
                i++;
            }

        }
        zdDmb.setCode(code);
    }

    private void generateZzdwCode(ZzdwDmb zzdwDmb){
        if(null==zzdwDmb.getName()){
            return ;
        }
        String code=PinyinUtil.getFirstSpell(zzdwDmb.getName());
        if(zzdwDmb.getCode() !=null && zzdwDmb.getCode().startsWith(code)){
            return ;
        }
        ZzdwDmbExample zdDmbExample =new ZzdwDmbExample();
        int i=0;
        boolean brankWhile=false;
        while (true){
            String tmp=code;
            if(i>0){
                tmp=tmp+"_"+i;
            }
            zdDmbExample.createCriteria().andCodeEqualTo(tmp);
            List<ZzdwDmb> zl=this.zzdwDmbMapper.selectByExample(zdDmbExample);
            if(zl.size()<1){
                brankWhile=true;
            }
            if(brankWhile){
                code=tmp;
                break;
            }else{
                zdDmbExample.clear();
                i++;
            }

        }
        zzdwDmb.setCode(code);
    }

    @Override
    public void addEditZdSelecttive(ZdDmb zdDmb, SessionInfo info) {
        if(!StringUtil.isEmpty(zdDmb.getCode())){
            ZdDmbExample example=new ZdDmbExample();
            example.createCriteria().andCodeEqualTo(zdDmb.getCode());
            List<ZdDmb>zl=this.zdDmbMapper.selectByExample(example);
            if(zl.size()>0){
                if(!zl.get(0).getId().equals(zdDmb.getId())){
                    throw  new BaseException(zdDmb.getCode()+"已经存在");
                }
            }
            zdDmbMapper.updateByPrimaryKeySelective(zdDmb);
        }

        if(!StringUtil.isEmpty(zdDmb.getName())){
            ZdDmbExample example=new ZdDmbExample();
            example.createCriteria().andNameEqualTo(zdDmb.getName());
            List<ZdDmb>zl=this.zdDmbMapper.selectByExample(example);
            ZdDmb db=new ZdDmb();
            if(zl.size()>0){
                db=zl.get(0);
            }
            if(zdDmb.getId()<0){
                Long deptId=-zdDmb.getId();
                ZzdwDmb zzdwDmb=this.zzdwDmbMapper.selectByPrimaryKey(deptId);
                if(db.getId()==null){
                    generateCode(zdDmb);
                    zdDmbMapper.insert(zdDmb);
                }else{
                    zdDmb.setId(db.getId());
                }
                ZzdwZdMap zzdwZdMap=new ZzdwZdMap();
                zzdwZdMap.setDeptId(deptId);
                zzdwZdMap.setZdId(zdDmb.getId());
                zzdwZdMap.setType(Short.valueOf(zzdwDmb.getType()));
                this.zzdwZdMapMapper.insert(zzdwZdMap);
            }else{
                ZdDmb old=this.zdDmbMapper.selectByPrimaryKey(zdDmb.getId());
                if(db.getId()!=null && !zdDmb.getId().equals(db.getId())){//存在把一个名称改成一个已经存在的
                    throw  new BaseException("不能把"+db.getName()+"修改成"+zdDmb.getName()+",请先删除"+old.getName()+"再添加");
                }
                generateCode(zdDmb);
                zdDmbMapper.updateByPrimaryKeySelective(zdDmb);
            }
        }

    }

    @Override
    public List<SuggestBean> suggest(String type, String name) {
        if(name==null||name.trim().length()<2){
            return new ArrayList<>();
        }
        List<SuggestBean>sl=new ArrayList<>();
        ZzdwDmbExample zzdwDmbExample=new ZzdwDmbExample();
        if("cdzdcz".equals(type)){
            type="1";
            zzdwDmbExample.createCriteria().andTypeEqualTo(type).andCodeLike(name+"%");
            List<ZzdwDmb>zl=this.zzdwDmbMapper.selectByExample(zzdwDmbExample);

            for(ZzdwDmb zzdwDmb:zl){
                SuggestBean sb=new SuggestBean(zzdwDmb.getCode(),zzdwDmb.getName());
                sl.add(sb);
            }
            ZdDmbExample zdDmbExample=new ZdDmbExample();

            zdDmbExample.createCriteria().andTypeEqualTo("1,2,3").andCodeLike(name+"%");
            List<ZdDmb>zdl=this.zdDmbMapper.selectByExample(zdDmbExample);
            for(ZdDmb zd:zdl){
                SuggestBean sb=new SuggestBean(zd.getCode(),zd.getName());
                sl.add(sb);
            }
        }
        if("zd".equals(type)||"上海局".equals(type)){
            List<String>types=new ArrayList<>();
            types.add("1");
            types.add("2");
            types.add("3");
            zzdwDmbExample.createCriteria().andTypeIn(types).andCodeLike(name+"%");
            List<ZzdwDmb>zl=this.zzdwDmbMapper.selectByExample(zzdwDmbExample);
            for(ZzdwDmb zzdwDmb:zl){
                SuggestBean sb=new SuggestBean(zzdwDmb.getCode(),zzdwDmb.getName());
                sl.add(sb);
            }
        }
        return sl;
    }

    @Override
    public String  sync(String type) {
        DeptExample deptExample=new DeptExample();
        deptExample.createCriteria().andParentIdIsNull().andTypeIn(Arrays.asList(type.split(",")));
        List<Dept> pl=this.deptMapper.selectByExample(deptExample);
        List<Long>pidl=new ArrayList<>();
        for(Dept d:pl){
            pidl.add(d.getId());
        }
        deptExample.clear();
        deptExample.createCriteria().andParentIdIn(pidl);
        pl=this.deptMapper.selectByExample(deptExample);
        if(pl.size()<1){
            return "没有需要同步的数据";
        }
        Map<String,Dept>s=new HashMap();
        for(Dept d:pl){
            s.put(d.getType().toString()+"_"+d.getName(),d);
        }
        ZzdwDmbExample zzdwDmbExample=new ZzdwDmbExample();
        zzdwDmbExample.createCriteria().andTypeIn(Arrays.asList(type.split(","))).andPidEqualTo(0l);
        List<ZzdwDmb> dl=this.zzdwDmbMapper.selectByExample(zzdwDmbExample);
        StringBuilder sb=new StringBuilder();
        for(ZzdwDmb z:dl){
            String key=z.getType()+"_"+z.getName();
            Dept dept=s.get(key);
            if(dept==null){//准备删除
                boolean del=true;
                if("1".equals(z.getType()) ||"2".equals(z.getType())){
                    ZzdwZdMapExample zzdwZdMapExample=new ZzdwZdMapExample();
                    zzdwZdMapExample.createCriteria().andDeptIdEqualTo(z.getId());
                    List<ZzdwZdMap> zl=this.zzdwZdMapMapper.selectByExample(zzdwZdMapExample);
                    if(zl.size()>0){
                        sb.append(z.getName()+"存在运营站，同步时不会被删除");
                        del=false;
                    }
                }else{
                    ZzdwDmbExample ze=new ZzdwDmbExample();
                    ze.createCriteria().andPidEqualTo(z.getId());
                    List<ZzdwDmb> ddl=zzdwDmbMapper.selectByExample(ze);
                    if(ddl.size()>0){
                        sb.append(z.getName()+"存在子集合，同步时不会被删除");
                        del=false;
                    }
                }
                if(del){
                    zzdwDmbMapper.deleteByPrimaryKey(z.getId());
                }
            }else{
                s.remove(key);
            }
        }
        for(String str:s.keySet()){
            Dept dept=s.get(str);
            ZzdwDmb zzdwDmb=new ZzdwDmb();
            zzdwDmb.setType(dept.getType().toString());
            zzdwDmb.setName(dept.getName());
            generateZzdwCode(zzdwDmb);
            zzdwDmb.setPid(0l);
            this.zzdwDmbMapper.insert(zzdwDmb);
        }
        String result=sb.toString();
        return StringUtil.isEmpty(result)?"同步成功":result;
    }

    @Override
    public Map listAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("zd", zdDmbMapper.selectByExample(new ZdDmbExample()));
        map.put("zzdw", zzdwDmbMapper.selectByExample(new ZzdwDmbExample()));
        return map;
    }
}
