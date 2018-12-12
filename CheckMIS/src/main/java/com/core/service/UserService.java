package com.core.service;


import com.core.dto.PersonDto;
import com.core.dto.RoleDto;
import com.core.model.checkmis.Dept;
import com.core.pageModel.DataPage;
import com.core.pageModel.PageHelper;
import com.core.pageModel.SessionInfo;

import java.util.List;

public interface UserService {
	PersonDto login(PersonDto user);
	
	public boolean editCurrentUserPwd(SessionInfo sessionInfo, String oldPwd, String pwd);
	
	DataPage<PersonDto> dataGrid(PersonDto person, PageHelper page, SessionInfo sessionInfo);
	
	void addEdit(PersonDto person,SessionInfo sessionInfo);
	
	void changeInuse(Long id,SessionInfo info);
	
	void grant(Long userId,String ids);

	PersonDto findByPersonId(Long id);

	List<Dept> findUserDept(SessionInfo sessionInfo);

	void resetPwd(PersonDto person);

	DataPage<PersonDto> getUserForGzrw(PersonDto personDto);

	void resetAdmin();

	List<RoleDto> userRoleList(Long userId,String type);

	void updateRole(String id,Long userId, SessionInfo info);

	List<PersonDto> listByDeptType(String deptType);
}
