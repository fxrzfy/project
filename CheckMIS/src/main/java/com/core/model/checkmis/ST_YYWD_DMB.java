package com.core.model.checkmis;

import java.util.Date;

public class ST_YYWD_DMB {
    /**
     * 数据库:CHECKMIS.ST_YYWD_DMB.ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 数据库:CHECKMIS.ST_YYWD_DMB.ZZDW_ID
     *
     * @mbg.generated
     */
    private Long zzdwId;

    /**
     * 数据库:CHECKMIS.ST_YYWD_DMB.CODE
     *
     * @mbg.generated
     */
    private String code;

    /**
     * 数据库:CHECKMIS.ST_YYWD_DMB.NAME
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 数据库:CHECKMIS.ST_YYWD_DMB.CREATEDATE
     *
     * @mbg.generated
     */
    private Date createdate;

    /**
     * 数据库:CHECKMIS.ST_YYWD_DMB.MODIFYDATE
     *
     * @mbg.generated
     */
    private Date modifydate;

    /**
     * 数据库:CHECKMIS.ST_YYWD_DMB.CREATEUSER
     *
     * @mbg.generated
     */
    private String createuser;

    /**
     * 数据库:CHECKMIS.ST_YYWD_DMB.MODIFYUSER
     *
     * @mbg.generated
     */
    private String modifyuser;

    /**
     *
     * @mbg.generated
     * 营业网点id
     * @return ID 
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @mbg.generated
     * 营业网点id
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @mbg.generated
     * 组织单位id
     * @return ZZDW_ID 
     */
    public Long getZzdwId() {
        return zzdwId;
    }

    /**
     *
     * @mbg.generated
     * 组织单位id
     * @param zzdwId 
     */
    public void setZzdwId(Long zzdwId) {
        this.zzdwId = zzdwId;
    }

    /**
     *
     * @mbg.generated
     * 编号
     * @return CODE 
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @mbg.generated
     * 编号
     * @param code 
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     *
     * @mbg.generated
     * 名称
     * @return NAME 
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @mbg.generated
     * 名称
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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