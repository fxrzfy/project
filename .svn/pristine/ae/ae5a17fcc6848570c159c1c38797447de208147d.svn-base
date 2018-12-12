package com.core.service.impl;


import com.core.model.checkmis.Unit;
import com.core.model.checkmis.UnitExample;
import com.core.pageModel.DataGrid;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;
import com.core.pageModel.Tree;
import com.core.service.UnitService;
import com.dao.core.checkmis.UnitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: 单位信息 service类</p>
 * Created on 
 * @author
 * @version 1.0
 */
@Service("unitService")
public class UnitServiceImpl implements UnitService {

	@Autowired
	private UnitMapper unitMapper;

	@Override
	public Unit queryById(Object id) {
        return null;
	}


	@Override
	public void updateBySelect(Unit unit) throws Exception {
		// TODO Auto-generated method stub
		//unitDao.updateBySelect(unit);
	}

	@Override
	public void delete(Long id) throws Exception {
		// TODO Auto-generated method stub
		unitMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public void deleteBatch(String ids) throws Exception {
		// TODO Auto-generated method stub
		for (String id : ids.split(",")) {
			if (id != null) {
				//unitDao.delete(id);
			}
		}
	}

	@Override
	public DataGrid queryList(Unit unit, PageHelper page) {
		// TODO Auto-generated method stub
		DataGrid dg = new DataGrid();
		//Long total = unitDao.queryCount(unit);
		//List<Unit> rows = unitDao.queryList(unit, page);
		//dg.setTotal(total);
		//dg.setRows(rows);
		return dg;
	}

    @Override
    public List<Tree> tree(SessionInfo sessionInfo, String type) {
        List<Unit> l = null;
        List<Tree> lt = new ArrayList<Tree>();

        //l = unitDao
        UnitExample unitExample = new UnitExample();
        l = unitMapper.selectByExample(unitExample);
        if(l != null) {
            for (Unit unit : l) {
                Tree tree = new Tree();
                tree.setId(unit.getId().toString());
                tree.setPid(unit.getParentId().toString());
                tree.setText(unit.getName());
                if("0".equals(unit.getParentId().toString())){
                    tree.setIconCls("company");
                }else {
                    tree.setIconCls("house");
                }
                lt.add(tree);
            }
        }
        if("1".equals(type)){
            Tree tree = new Tree();
            tree.setId("0");
            tree.setPid("");
            tree.setText("单位管理");
            lt.add(tree);

        }
        return lt;
    }

    @Override
    public Long save(Unit unit) {
        if(unit.getId() == null) {
            if(unit.getSerial() == null){
                //unit.setSerial(100L);
            }
            unitMapper.insert(unit);
        }else{
            unitMapper.updateByPrimaryKey(unit);
        }
        return unit.getId();
    }

    @Override
    public Object get(Long id) {
        return unitMapper.selectByPrimaryKey(id);
    }

}
