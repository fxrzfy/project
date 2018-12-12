package com.core.model.checkmis;

public class PersonRole {
    /**
     * 数据库:CHECKMIS.SYS_PERSON_ROLE.PERSON_ID
     *
     * @mbg.generated
     */
    private Long personId;

    /**
     * 数据库:CHECKMIS.SYS_PERSON_ROLE.ROLE_ID
     *
     * @mbg.generated
     */
    private Long roleId;

    /**
     *
     * @mbg.generated
     * 人员id，sys_person
     * @return PERSON_ID 
     */
    public Long getPersonId() {
        return personId;
    }

    /**
     *
     * @mbg.generated
     * 人员id，sys_person
     * @param personId 
     */
    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    /**
     *
     * @mbg.generated
     * 角色id,sys_role
     * @return ROLE_ID 
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     *
     * @mbg.generated
     * 角色id,sys_role
     * @param roleId 
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}