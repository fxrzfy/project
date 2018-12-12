package com.core.model.checkmis;

public class RoleResources {
    /**
     * 数据库:CHECKMIS.SYS_ROLE_RESOURCES.ROLE_ID
     *
     * @mbg.generated
     */
    private Long roleId;

    /**
     * 数据库:CHECKMIS.SYS_ROLE_RESOURCES.NODE_ID
     *
     * @mbg.generated
     */
    private Long nodeId;

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

    /**
     *
     * @mbg.generated
     * 界面ID,sys_node
     * @return NODE_ID 
     */
    public Long getNodeId() {
        return nodeId;
    }

    /**
     *
     * @mbg.generated
     * 界面ID,sys_node
     * @param nodeId 
     */
    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }
}