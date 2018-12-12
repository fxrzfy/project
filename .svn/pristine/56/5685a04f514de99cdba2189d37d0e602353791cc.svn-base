package com.core.service;


import com.core.model.checkmis.Dept;
import com.core.model.checkmis.Unit;
import com.core.pageModel.DataGrid;
import com.core.pageModel.PageHelper;
import com.core.pageModel.Tree;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * <p>Description: 部门信息 service类</p>
 * Created on 
 * @author
 * @version 1.0
 */
public interface DeptService {

	public Dept queryById(Long id);

	public void update(Dept dept) throws Exception;

	public void updateBySelect(Dept dept) throws Exception;

	public void delete(Long id) throws Exception;
	
	public void deleteBatch(String ids) throws Exception;

	public DataGrid queryList(Dept dept, PageHelper page);

    public List<Tree> tree(String type);

    public Dept get(Long id);

    public Long save(Dept dept);
    
   public List<Long> getDeptList(String deptStr);
   
	public List<Dept> findUserDept(Set<Unit> au);

	List<Dept> selectAllDeptByParam(String qid);

    Object list(BigDecimal type);
}
