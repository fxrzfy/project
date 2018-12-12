package com.core.service;

import com.core.model.checkmis.Role;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;
import com.core.pageModel.Tree;

import java.util.List;

public interface RoleService {
	public List<Tree> tree(SessionInfo sessionInfo,String type);
	
	Role get(Long id);
	
	Long saveUpdate(Role r,SessionInfo info);
	
	void del(String ids);

	DataPage<Role> dataGrid(Role role, PageHelper pageHelper);
	
	void grant(String roleId,String ids);
}
