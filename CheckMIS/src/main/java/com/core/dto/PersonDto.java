package com.core.dto;

import com.core.model.checkmis.Person;
import com.core.model.checkmis.Role;
import com.util.BaseException;
import com.util.MD5Util;
import com.util.StringUtil;

import java.util.List;

public class PersonDto extends Person {
    private String deptName;

    private String teamName;

    private String unitName;

    private Long teamId;

    private String teamCode;

    private Integer isSelectEd;

    private Long xzId;

    private Long gzrwId;

    private Long roleType;

    private String qid;

    private List<Long> deptIds;

    private List<Role> roles;

    private String key;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void encodePwd(){
        if(StringUtil.isEmpty(this.getUserName())){
            throw new BaseException("用户名不能为空");
        }
        if(StringUtil.isEmpty(this.getPassword())){
            throw new BaseException("密码不能为空");
        }
        this.setPassword( MD5Util.md5(this.getUserName()+this.getPassword()));
    }

    public Integer getIsSelectEd() {
        return isSelectEd;
    }

    public void setIsSelectEd(Integer isSelectEd) {
        this.isSelectEd = isSelectEd;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(String teamCode) {
        this.teamCode = teamCode;
    }

    public Long getXzId() {
        return xzId;
    }

    public void setXzId(Long xzId) {
        this.xzId = xzId;
    }

    public Long getGzrwId() {
        return gzrwId;
    }

    public void setGzrwId(Long gzrwId) {
        this.gzrwId = gzrwId;
    }

    public Long getRoleType() {
        return roleType;
    }

    public void setRoleType(Long roleType) {
        this.roleType = roleType;
    }

    public String getQid() {
        return qid;
    }

    public void setQid(String qid) {
        this.qid = qid;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public List<Long> getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(List<Long> deptIds) {
        this.deptIds = deptIds;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
