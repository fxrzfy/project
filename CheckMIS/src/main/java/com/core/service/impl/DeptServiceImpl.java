package com.core.service.impl;

import com.core.model.checkmis.Dept;
import com.core.model.checkmis.*;
import com.core.model.checkmis.DeptExample;
import com.core.model.checkmis.UnitExample;
import com.core.pageModel.DataGrid;
import com.core.pageModel.PageHelper;
import com.core.pageModel.Tree;
import com.core.service.DeptService;
import com.dao.core.checkmis.DeptMapper;
import com.dao.core.checkmis.UnitMapper;
import com.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * <p>Description: 部门信息 service类</p>
 * Created on
 *
 * @author
 * @version 1.0
 */
@Service("deptService")
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private UnitMapper unitMapper;

//    @Autowired
//    private PositionMapper positionMapper;

    @Override
    public Dept queryById(Long id) {
        // TODO Auto-generated method stub
        //return deptDao.queryById(id);
        return deptMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Dept dept) throws Exception {
        // TODO Auto-generated method stub
        //dept.setModifyDateTime(new Date());
        //deptDao.update(dept);
    }

    @Override
    public void updateBySelect(Dept dept) throws Exception {
        // TODO Auto-generated method stub
        //deptDao.updateBySelect(dept);
    }

    @Override
    public void delete(Long id) throws Exception {
        // TODO Auto-generated method stub
        deptMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteBatch(String ids) throws Exception {
        // TODO Auto-generated method stub
        for (String id : ids.split(",")) {
            if (id != null) {
                //deptDao.delete(id);
            }
        }
    }

    @Override
    public DataGrid queryList(Dept dept, PageHelper page) {
        // TODO Auto-generated method stub
        DataGrid dg = new DataGrid();
        //Long total = deptDao.queryCount(dept);
        //List<Dept> rows = deptDao.queryList(dept, page);
        //dg.setTotal(total);
        //dg.setRows(rows);
        return dg;
    }

    @Override
    public List<Tree> tree(String type) {
        List<Tree> tl = new ArrayList<Tree>();
        DeptExample deptExample = new DeptExample();
        deptExample.setOrderByClause("serial");
        List<Dept> deptList = deptMapper.selectByExample(deptExample);
        for (Dept dept : deptList) {
            Tree tree = new Tree();
            tree.setId("D" + dept.getId());
            tree.setText(dept.getName());
            if (dept.getParentId() == null) {
                tree.setPid("U" + dept.getUnitId());
            } else {
                tree.setPid("D" + dept.getParentId());
            }
            tree.setIconCls("group");
            tl.add(tree);
        }

        UnitExample unitExample = new UnitExample();
        unitExample.setOrderByClause("serial");
        List<Unit> unitList = unitMapper.selectByExample(unitExample);
        for (Unit unit : unitList) {
            Tree tree = new Tree();
            tree.setId("U" + unit.getId());
            tree.setText(unit.getName());
            tree.setPid("U" + unit.getParentId());
            if ("0".equals(unit.getParentId().toString())) {
                tree.setIconCls("company");
            } else {
                tree.setIconCls("house");
            }
            tl.add(tree);
        }
//        if("position".equals(type)){
//        	//这种情况是显示岗位树
//        	PositionExample example=new PositionExample();
//        	List<Position> pl=this.positionMapper.selectByExample(example);
//        	for(Position p:pl){
//        		Tree tree = new Tree();
//                tree.setId("P" + p.getPositionId());
//                tree.setText(p.getPositionName());
//                tree.setPid("D" + p.getDeptId());
//                tree.setIconCls("brick");
//                Map<String, Object> attr = new HashMap<String, Object>();
//				attr.put("type", "1");
//				tree.setAttributes(attr);
//                tl.add(tree);
//        	}
//        }
//        if(null!=type){
//        	// 将岗位树进行相应的转换
//        	Map<String, List<Tree>> map=new HashMap<String, List<Tree>>();
//        	for(Tree t:tl){
//        		List<Tree> tem=map.get(t.getPid());
//        		if(tem==null){
//        			tem=new ArrayList<Tree>();
//        		}
//        		tem.add(t);
//        		map.put(t.getPid(), tem);
//        	}
//        	tl = new ArrayList<Tree>();
//        	if(map.get("U0")==null){
//        		return tl;
//        	}
//        	Tree t=map.get("U0").get(0);
//        	init(t,map);
//        	tl.add(t);
//        }
        return tl;
    }

    private void init(Tree t, Map<String, List<Tree>> map) {
        List<Tree> temp = map.get(t.getId());
        t.setChildren(temp);
        if (null == temp) {
            return;
        }
        for (Tree t1 : temp) {
            init(t1, map);
        }
    }

    @Override
    public Dept get(Long id) {
        return deptMapper.selectByPrimaryKey(id);
    }

    @Override
    public Long save(Dept dept) {
        if (dept.getId() == null) {
            if (dept.getSerial() == null) {
                //dept.setSerial(100L);
            }
            deptMapper.insert(dept);
        } else {
            deptMapper.updateByPrimaryKey(dept);
        }
        return dept.getId();
    }

    @Override
    public List<Long> getDeptList(String deptStr) {
        List<Long> deptIds = new ArrayList<Long>();
        if (deptStr != null && !"".equals(deptStr.trim())) {
            if (deptStr.indexOf("unit") == -1) {
                deptIds.add(Long.parseLong(deptStr));
            } else {
                Set<Unit> au = new HashSet<Unit>();
                Unit u = new Unit();
                System.out.println(deptStr);
                //u.setUnitId(Long.parseLong(deptStr.replaceAll("unit","")));
                au.add(u);
                List<Dept> ud = this.findUserDept(au);
                for (Dept d : ud) {
                    //	deptIds.add(d.getDeptId());
                }
            }
        }
        return deptIds;
    }

    @Override
    public List<Dept> findUserDept(Set<Unit> au) {
        List<Long> uids = new ArrayList<Long>();
        for (Unit u : au) {
            //	uids.add(u.getUnitId());
        }
//		List<Dept>dl=this.deptMapper.findctDeptByUnitIds(uids);
//		return dl;
        return null;
    }

    @Override
    public List<Dept> selectAllDeptByParam(String qid) {
        if (StringUtil.isEmpty(qid)) {
            return new ArrayList<>();
        }
        List<Long> uids = new ArrayList<>();
        List<Long> dids = new ArrayList<>();
        List<Dept> r=new ArrayList<>();
        if (qid.startsWith("U")) {
            Long uid = Long.parseLong(qid.substring(1));
            uids.add(uid);
            List<Unit> u = null;
            while (true) {
                List<Long> q = new ArrayList<>();
                UnitExample ue = new UnitExample();
                if (u == null) {
                    q.add(uid);
                } else {
                    if (u.size() == 0) {
                        break;
                    }
                    for (Unit uu : u) {
                        q.add(uu.getId());
                        uids.add(uu.getId());
                    }
                }
                ue.createCriteria().andParentIdIn(q);
                u = this.unitMapper.selectByExample(ue);
            }
        }else if(qid.startsWith("D")){
            dids.add(Long.parseLong(qid.substring(1)));
            Dept d=new Dept();
            d.setId(Long.parseLong(qid.substring(1)));
            r.add(d);
        }
        if(uids.size()>0){
            DeptExample example=new DeptExample();
            example.createCriteria().andUnitIdIn(uids);
            List<Dept> dl=this.deptMapper.selectByExample(example);
            for(Dept d:dl){
                r.add(d);
                dids.add(d.getId());
            }
        }

        List<Dept> ddl=null;
        while (true){
            List<Long> t=new ArrayList<>();
            if(ddl==null){
                t.addAll(dids);
            }else{
                if(ddl.size()==0){
                   break;
                }else{
                    for(Dept d:ddl){
                        r.add(d);
                        t.add(d.getId());
                    }
                }
            }
            if(t.size()==0){
                break;
            }
            DeptExample de=new DeptExample();
            de.createCriteria().andParentIdIn(t);
            ddl=this.deptMapper.selectByExample(de);
        }
        return r;
    }

    @Override
    public List<Dept> list(BigDecimal type) {
        DeptExample de=new DeptExample();
        de.createCriteria().andTypeEqualTo(type);
        return this.deptMapper.selectByExample(de);
    }
}
