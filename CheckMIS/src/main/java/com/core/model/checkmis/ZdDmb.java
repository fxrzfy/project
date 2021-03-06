package com.core.model.checkmis;

import java.util.Date;

public class ZdDmb {
    /**
     * 数据库:CHECKMIS.ST_ZD_DMB.ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 数据库:CHECKMIS.ST_ZD_DMB.CODE
     *
     * @mbg.generated
     */
    private String code;

    /**
     * 数据库:CHECKMIS.ST_ZD_DMB.NAME
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 数据库:CHECKMIS.ST_ZD_DMB.CREATEDATE
     *
     * @mbg.generated
     */
    private Date createdate;

    /**
     * 数据库:CHECKMIS.ST_ZD_DMB.MODIFYDATE
     *
     * @mbg.generated
     */
    private Date modifydate;

    /**
     * 数据库:CHECKMIS.ST_ZD_DMB.CREATEUSER
     *
     * @mbg.generated
     */
    private String createuser;

    /**
     * 数据库:CHECKMIS.ST_ZD_DMB.MODIFYUSER
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
     * 站点编码
     * @return CODE 
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @mbg.generated
     * 站点编码
     * @param code 
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     *
     * @mbg.generated
     * 站点名称
     * @return NAME 
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @mbg.generated
     * 站点名称
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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