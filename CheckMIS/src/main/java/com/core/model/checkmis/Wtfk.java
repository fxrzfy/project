package com.core.model.checkmis;

import java.util.Date;

public class Wtfk {
    /**
     * 数据库:CHECKMIS.ST_WTFK.ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 数据库:CHECKMIS.ST_WTFK.DEPT_ID
     *
     * @mbg.generated
     */
    private Long deptId;

    /**
     * 数据库:CHECKMIS.ST_WTFK.FKQK
     *
     * @mbg.generated
     */
    private String fkqk;

    /**
     * 数据库:CHECKMIS.ST_WTFK.FKR
     *
     * @mbg.generated
     */
    private String fkr;

    /**
     * 数据库:CHECKMIS.ST_WTFK.FKSJ
     *
     * @mbg.generated
     */
    private Date fksj;

    /**
     * 数据库:CHECKMIS.ST_WTFK.CREATEDATE
     *
     * @mbg.generated
     */
    private Date createdate;

    /**
     * 数据库:CHECKMIS.ST_WTFK.MODIFYDATE
     *
     * @mbg.generated
     */
    private Date modifydate;

    /**
     * 数据库:CHECKMIS.ST_WTFK.CREATEUSER
     *
     * @mbg.generated
     */
    private String createuser;

    /**
     * 数据库:CHECKMIS.ST_WTFK.MODIFYUSER
     *
     * @mbg.generated
     */
    private String modifyuser;

    /**
     *
     * @mbg.generated
     * ID
     * @return ID 
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @mbg.generated
     * ID
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @mbg.generated
     * DEPT_ID
     * @return DEPT_ID 
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     *
     * @mbg.generated
     * DEPT_ID
     * @param deptId 
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     *
     * @mbg.generated
     * 反馈情况
     * @return FKQK 
     */
    public String getFkqk() {
        return fkqk;
    }

    /**
     *
     * @mbg.generated
     * 反馈情况
     * @param fkqk 
     */
    public void setFkqk(String fkqk) {
        this.fkqk = fkqk == null ? null : fkqk.trim();
    }

    /**
     *
     * @mbg.generated
     * 反馈人
     * @return FKR 
     */
    public String getFkr() {
        return fkr;
    }

    /**
     *
     * @mbg.generated
     * 反馈人
     * @param fkr 
     */
    public void setFkr(String fkr) {
        this.fkr = fkr == null ? null : fkr.trim();
    }

    /**
     *
     * @mbg.generated
     * 反馈时间
     * @return FKSJ 
     */
    public Date getFksj() {
        return fksj;
    }

    /**
     *
     * @mbg.generated
     * 反馈时间
     * @param fksj 
     */
    public void setFksj(Date fksj) {
        this.fksj = fksj;
    }

    /**
     *
     * @mbg.generated
     * 创建时间
     * @return CREATEDATE 
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     *
     * @mbg.generated
     * 创建时间
     * @param createdate 
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     *
     * @mbg.generated
     * 修改时间
     * @return MODIFYDATE 
     */
    public Date getModifydate() {
        return modifydate;
    }

    /**
     *
     * @mbg.generated
     * 修改时间
     * @param modifydate 
     */
    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    /**
     *
     * @mbg.generated
     * 创建人
     * @return CREATEUSER 
     */
    public String getCreateuser() {
        return createuser;
    }

    /**
     *
     * @mbg.generated
     * 创建人
     * @param createuser 
     */
    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    /**
     *
     * @mbg.generated
     * 修改人
     * @return MODIFYUSER 
     */
    public String getModifyuser() {
        return modifyuser;
    }

    /**
     *
     * @mbg.generated
     * 修改人
     * @param modifyuser 
     */
    public void setModifyuser(String modifyuser) {
        this.modifyuser = modifyuser == null ? null : modifyuser.trim();
    }
}