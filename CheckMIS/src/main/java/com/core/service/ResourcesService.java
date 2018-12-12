package com.core.service;

import com.core.dto.SysMenu;
import com.core.model.checkmis.Resources;
import com.core.pageModel.SessionInfo;
import com.core.pageModel.Tree;

import java.util.List;

public interface ResourcesService {
	public List<Tree> tree(SessionInfo sessionInfo,String roleId);

	public List<SysMenu> loadTree(SessionInfo sessionInfo,String type);
	
	Resources get(Long id);
	
	Long saveOrUpdate(Resources resources);
	
	void del(Long id);
}
