package com.core.service;


import com.core.model.checkmis.Unit;
import com.core.pageModel.DataGrid;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;
import com.core.pageModel.Tree;

import java.util.List;

/**
 * <p>Description: 单位信息 service类</p>
 * Created on 
 * @author
 * @version 1.0
 */
public interface UnitService {

	public Unit queryById(Object id);

	public void updateBySelect(Unit unit) throws Exception;

	public void delete(Long id) throws Exception;
	
	public void deleteBatch(String ids) throws Exception;

	public DataGrid queryList(Unit unit, PageHelper page);

    List<Tree> tree(SessionInfo sessionInfo, String type);

    Long save(Unit unit);

    Object get(Long id);
}
