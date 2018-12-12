package com.core.model.checkmis;

import java.util.Date;

public class GzDmb {
    /**
     * 数据库:CHECKMIS.ST_GZ_DMB.ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 数据库:CHECKMIS.ST_GZ_DMB.TLGSQC
     *
     * @mbg.generated
     */
    private String tlgsqc;

    /**
     * 数据库:CHECKMIS.ST_GZ_DMB.ZZGH
     *
     * @mbg.generated
     */
    private Long zzgh;

    /**
     * 数据库:CHECKMIS.ST_GZ_DMB.SRJC
     *
     * @mbg.generated
     */
    private String srjc;

    /**
     * 数据库:CHECKMIS.ST_GZ_DMB.CREATEDATE
     *
     * @mbg.generated
     */
    private Date createdate;

    /**
     * 数据库:CHECKMIS.ST_GZ_DMB.MODIFYDATE
     *
     * @mbg.generated
     */
    private Date modifydate;

    /**
     * 数据库:CHECKMIS.ST_GZ_DMB.CREATEUSER
     *
     * @mbg.generated
     */
    private String createuser;

    /**
     * 数据库:CHECKMIS.ST_GZ_DMB.MODIFYUSER
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
     * 铁路公司全称
     * @return TLGSQC 
     */
    public String getTlgsqc() {
        return tlgsqc;
    }

    /**
     *
     * @mbg.generated
     * 铁路公司全称
     * @param tlgsqc 
     */
    public void setTlgsqc(String tlgsqc) {
        this.tlgsqc = tlgsqc == null ? null : tlgsqc.trim();
    }

    /**
     *
     * @mbg.generated
     * 组长工号
     * @return ZZGH 
     */
    public Long getZzgh() {
        return zzgh;
    }

    /**
     *
     * @mbg.generated
     * 组长工号
     * @param zzgh 
     */
    public void setZzgh(Long zzgh) {
        this.zzgh = zzgh;
    }

    /**
     *
     * @mbg.generated
     * 收入稽查
     * @return SRJC 
     */
    public String getSrjc() {
        return srjc;
    }

    /**
     *
     * @mbg.generated
     * 收入稽查
     * @param srjc 
     */
    public void setSrjc(String srjc) {
        this.srjc = srjc == null ? null : srjc.trim();
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
}