package com.core.pageModel;

import com.core.dto.PersonDto;
import com.core.model.checkmis.Person;
import com.util.ConfigUtil;

import java.util.List;
import java.util.Map;

/**
 * session信息模型
 * 
 * @author 孙宇
 * 
 */
public class SessionInfo {
	private static final long serialVersionUID = 1L;
	
	private Long id;// 用户ID
	private String name;// 用户登录名
    private String userPhone;
	
	private String appName;

	private PersonDto person;

	private Long deptId;

	private String deptName;
	
	private Long unitId;//部门所属单位
	
	private String roleIds;

	private List<String> resourceList;// 用户可以访问的资源地址列表
	
	private boolean isAPP;

	private String workNumber;

	private Map<String,String>roleMap;

	private String sessionId;

	public boolean hasRole(String roleCode){
		return roleMap==null?false:roleMap.get(roleCode)!=null;
	}



	public List<String> getResourceList() {
		return resourceList;
	}

	public void setResourceList(List<String> resourceList) {
		this.resourceList = resourceList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the deptId
	 */
	public Long getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return this.name;
	}


	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}
	

	public boolean isManager(){
		String str[]=ConfigUtil.get("managerroleid").split(",");
		if(roleIds==null){
			return false;
		}
		for(int i=0;i<str.length;i++){
			if(roles().indexOf(","+str[i]+",")>-1){
				return true;
			}
		}
		return false;
	}
	private String roles(){
		return ","+roleIds+",";
	}
	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public Long getUnitId() {
		return unitId;
	}

	public void setUnitId(Long unitId) {
		this.unitId = unitId;
	}

	public boolean isAPP() {
		return isAPP;
	}

	public void setAPP(boolean isAPP) {
		this.isAPP = isAPP;
	}

	public PersonDto getPerson() {
		return person;
	}

	public void setPerson(PersonDto person) {
		this.person = person;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getWorkNumber() {
		return workNumber;
	}

	public void setWorkNumber(String workNumber) {
		this.workNumber = workNumber;
	}

	public Map<String, String> getRoleMap() {
		return roleMap;
	}

	public void setRoleMap(Map<String, String> roleMap) {
		this.roleMap = roleMap;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
