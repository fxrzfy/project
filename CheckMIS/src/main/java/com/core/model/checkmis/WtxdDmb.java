package com.core.model.checkmis;

import java.util.Date;

public class WtxdDmb {
    /**
     * 数据库:CHECKMIS.ST_WTXD_DMB.ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 数据库:CHECKMIS.ST_WTXD_DMB.WTFL_ID
     *
     * @mbg.generated
     */
    private Long wtflId;

    /**
     * 数据库:CHECKMIS.ST_WTXD_DMB.WTXSM
     *
     * @mbg.generated
     */
    private String wtxsm;

    /**
     * 数据库:CHECKMIS.ST_WTXD_DMB.CREATEDATE
     *
     * @mbg.generated
     */
    private Date createdate;

    /**
     * 数据库:CHECKMIS.ST_WTXD_DMB.MODIFYDATE
     *
     * @mbg.generated
     */
    private Date modifydate;

    /**
     * 数据库:CHECKMIS.ST_WTXD_DMB.CREATEUSER
     *
     * @mbg.generated
     */
    private String createuser;

    /**
     * 数据库:CHECKMIS.ST_WTXD_DMB.MODIFYUSER
     *
     * @mbg.generated
     */
    private String modifyuser;

    /**
     * 数据库:CHECKMIS.ST_WTXD_DMB.CODE
     *
     * @mbg.generated
     */
    private String code;

    /**
     *
     * @mbg.generated
     * id
     * @return ID 
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @mbg.generated
     * id
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @mbg.generated
     * 问题分类表id，st_wtfl_dmb
     * @return WTFL_ID 
     */
    public Long getWtflId() {
        return wtflId;
    }

    /**
     *
     * @mbg.generated
     * 问题分类表id，st_wtfl_dmb
     * @param wtflId 
     */
    public void setWtflId(Long wtflId) {
        this.wtflId = wtflId;
    }

    /**
     *
     * @mbg.generated
     * 问题项说明
     * @return WTXSM 
     */
    public String getWtxsm() {
        return wtxsm;
    }

    /**
     *
     * @mbg.generated
     * 问题项说明
     * @param wtxsm 
     */
    public void setWtxsm(String wtxsm) {
        this.wtxsm = wtxsm == null ? null : wtxsm.trim();
    }

    /**
     *
     * @mbg.generated
     * null
     * @return CREATEDATE 
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     *
     * @mbg.generated
     * null
     * @param createdate 
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     *
     * @mbg.generated
     * null
     * @return MODIFYDATE 
     */
    public Date getModifydate() {
        return modifydate;
    }

    /**
     *
     * @mbg.generated
     * null
     * @param modifydate 
     */
    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    /**
     *
     * @mbg.generated
     * null
     * @return CREATEUSER 
     */
    public String getCreateuser() {
        return createuser;
    }

    /**
     *
     * @mbg.generated
     * null
     * @param createuser 
     */
    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    /**
     *
     * @mbg.generated
     * null
     * @return MODIFYUSER 
     */
    public String getModifyuser() {
        return modifyuser;
    }

    /**
     *
     * @mbg.generated
     * null
     * @param modifyuser 
     */
    public void setModifyuser(String modifyuser) {
        this.modifyuser = modifyuser == null ? null : modifyuser.trim();
    }

    /**
     *
     * @mbg.generated
     * null
     * @return CODE 
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @mbg.generated
     * null
     * @param code 
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
}