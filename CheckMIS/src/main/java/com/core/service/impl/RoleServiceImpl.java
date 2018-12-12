package com.core.service.impl;

import com.core.model.checkmis.*;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;
import com.core.pageModel.Tree;
import com.core.service.RoleService;

import com.dao.core.checkmis.PersonRoleMapper;
import com.dao.core.checkmis.RoleMapper;
import com.dao.core.checkmis.RoleResourcesMapper;
import com.util.BaseException;
import com.util.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class RoleServiceImpl  implements RoleService{
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private PersonRoleMapper personRoleMapper;
	@Autowired
	private RoleResourcesMapper roleResourcesMapper;

	@Override
	public List<Tree> tree(SessionInfo sessionInfo, String type) {
		return null;
	}

	@Override
	public Role get(Long id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public Long saveUpdate(Role r,SessionInfo info) {
		RoleExample example=new RoleExample();
		RoleExample.Criteria c= example.createCriteria();
		c.andRoleNameEqualTo(r.getRoleName());
		List<Role> rl=this.roleMapper.selectByExample(example);
		if(rl.size()>0 &&!rl.get(0).getId().equals(r.getId())){
			throw  new BaseException("角色名称已经存在");
		}
		example.clear();
		c= example.createCriteria();
		c.andRoleCodeEqualTo(r.getRoleCode());
		rl=this.roleMapper.selectByExample(example);
		if(rl.size()>0 &&!rl.get(0).getId().equals(r.getId())){
			throw  new BaseException("角色编码已经存在");
		}
		if(r.getId()!=null){
			r.setModifydate(new Date());
			r.setModifyuser(info.getName());
			this.roleMapper.updateByPrimaryKeySelective(r);
		}else{
			r.setCreatedate(new Date());
			r.setCreateuser(info.getName());
			this.roleMapper.insert(r);
		}
		return r.getId();
	}

	@Override
	public void del(String ids) {
		for(String str:ids.split(",")){
			Long id=Long.parseLong(str);
			PersonRoleExample personRoleExample =new PersonRoleExample();
			personRoleExample.createCriteria().andRoleIdEqualTo(id);
			personRoleMapper.deleteByExample(personRoleExample);
			RoleResourcesExample resourcesExample=new RoleResourcesExample();
			resourcesExample.createCriteria().andRoleIdEqualTo(id);
			this.roleResourcesMapper.deleteByExample(resourcesExample);
			this.roleMapper.deleteByPrimaryKey(id);
		}
	}

	@Override
	public DataPage<Role> dataGrid(Role role, PageHelper pageHelper) {
		DataPage<Role>dataPage=pageHelper.initPageBean();
		RoleExample example=new RoleExample();
		BeanUtils.copyProperties(pageHelper,example);
		if(!StringUtil.isEmpty(role.getRoleName())){
			example.createCriteria().andRoleNameLike("%"+role.getRoleName()+"%");
		}
		List<Role> rl= this.roleMapper.selectByExample(example);
		dataPage.setData(rl);
		dataPage.setTotal(example.getTotal());
		return dataPage;
	}

	@Override
	public void grant(String roleId, String ids) {
		RoleResourcesExample roleResourcesExample=new RoleResourcesExample();
		roleResourcesExample.createCriteria().andRoleIdEqualTo(Long.parseLong(roleId));
		roleResourcesMapper.deleteByExample(roleResourcesExample);
		if(StringUtil.isEmpty(ids)){
			return;
		}
		for(String id:ids.split(",")){
			RoleResources r=new RoleResources();
			r.setRoleId(Long.parseLong(roleId));
			r.setNodeId(Long.parseLong(id));
			this.roleResourcesMapper.insert(r);
		}
	}
}
