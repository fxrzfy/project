package com.core.model.checkmis;

import java.math.BigDecimal;
import java.util.Date;

public class Unit {
    /**
     * 数据库:CHECKMIS.SYS_UNIT.ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 数据库:CHECKMIS.SYS_UNIT.PARENT_ID
     *
     * @mbg.generated
     */
    private BigDecimal parentId;

    /**
     * 数据库:CHECKMIS.SYS_UNIT.CODE
     *
     * @mbg.generated
     */
    private String code;

    /**
     * 数据库:CHECKMIS.SYS_UNIT.NAME
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 数据库:CHECKMIS.SYS_UNIT.UNIT_ADDR
     *
     * @mbg.generated
     */
    private String unitAddr;

    /**
     * 数据库:CHECKMIS.SYS_UNIT.SERIAL
     *
     * @mbg.generated
     */
    private BigDecimal serial;

    /**
     * 数据库:CHECKMIS.SYS_UNIT.UNIT_PHONE
     *
     * @mbg.generated
     */
    private String unitPhone;

    /**
     * 数据库:CHECKMIS.SYS_UNIT.UNIT_FAX
     *
     * @mbg.generated
     */
    private String unitFax;

    /**
     * 数据库:CHECKMIS.SYS_UNIT.POST_CODE
     *
     * @mbg.generated
     */
    private String postCode;

    /**
     * 数据库:CHECKMIS.SYS_UNIT.UNIT_CONTACT
     *
     * @mbg.generated
     */
    private String unitContact;

    /**
     * 数据库:CHECKMIS.SYS_UNIT.UNIT_MOBILE
     *
     * @mbg.generated
     */
    private String unitMobile;

    /**
     * 数据库:CHECKMIS.SYS_UNIT.CREATEDATE
     *
     * @mbg.generated
     */
    private Date createdate;

    /**
     * 数据库:CHECKMIS.SYS_UNIT.MODIFYDATE
     *
     * @mbg.generated
     */
    private Date modifydate;

    /**
     * 数据库:CHECKMIS.SYS_UNIT.CREATEUSER
     *
     * @mbg.generated
     */
    private String createuser;

    /**
     * 数据库:CHECKMIS.SYS_UNIT.MODIFYUSER
     *
     * @mbg.generated
     */
    private String modifyuser;

    /**
     *
     * @mbg.generated
     * 单位id
     * @return ID 
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @mbg.generated
     * 单位id
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @mbg.generated
     * 父id
     * @return PARENT_ID 
     */
    public BigDecimal getParentId() {
        return parentId;
    }

    /**
     *
     * @mbg.generated
     * 父id
     * @param parentId 
     */
    public void setParentId(BigDecimal parentId) {
        this.parentId = parentId;
    }

    /**
     *
     * @mbg.generated
     * 单位编号
     * @return CODE 
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @mbg.generated
     * 单位编号
     * @param code 
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     *
     * @mbg.generated
     * 单位名称
     * @return NAME 
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @mbg.generated
     * 单位名称
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     *
     * @mbg.generated
     * 单位地址
     * @return UNIT_ADDR 
     */
    public String getUnitAddr() {
        return unitAddr;
    }

    /**
     *
     * @mbg.generated
     * 单位地址
     * @param unitAddr 
     */
    public void setUnitAddr(String unitAddr) {
        this.unitAddr = unitAddr == null ? null : unitAddr.trim();
    }

    /**
     *
     * @mbg.generated
     * null
     * @return SERIAL 
     */
    public BigDecimal getSerial() {
        return serial;
    }

    /**
     *
     * @mbg.generated
     * null
     * @param serial 
     */
    public void setSerial(BigDecimal serial) {
        this.serial = serial;
    }

    /**
     *
     * @mbg.generated
     * null
     * @return UNIT_PHONE 
     */
    public String getUnitPhone() {
        return unitPhone;
    }

    /**
     *
     * @mbg.generated
     * null
     * @param unitPhone 
     */
    public void setUnitPhone(String unitPhone) {
        this.unitPhone = unitPhone == null ? null : unitPhone.trim();
    }

    /**
     *
     * @mbg.generated
     * null
     * @return UNIT_FAX 
     */
    public String getUnitFax() {
        return unitFax;
    }

    /**
     *
     * @mbg.generated
     * null
     * @param unitFax 
     */
    public void setUnitFax(String unitFax) {
        this.unitFax = unitFax == null ? null : unitFax.trim();
    }

    /**
     *
     * @mbg.generated
     * null
     * @return POST_CODE 
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     *
     * @mbg.generated
     * null
     * @param postCode 
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    /**
     *
     * @mbg.generated
     * null
     * @return UNIT_CONTACT 
     */
    public String getUnitContact() {
        return unitContact;
    }

    /**
     *
     * @mbg.generated
     * null
     * @param unitContact 
     */
    public void setUnitContact(String unitContact) {
        this.unitContact = unitContact == null ? null : unitContact.trim();
    }

    /**
     *
     * @mbg.generated
     * null
     * @return UNIT_MOBILE 
     */
    public String getUnitMobile() {
        return unitMobile;
    }

    /**
     *
     * @mbg.generated
     * null
     * @param unitMobile 
     */
    public void setUnitMobile(String unitMobile) {
        this.unitMobile = unitMobile == null ? null : unitMobile.trim();
    }

    /**
     *
     * @mbg.generated
     * 创建日期
     * @return CREATEDATE 
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     *
     * @mbg.generated
     * 创建日期
     * @param createdate 
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     *
     * @mbg.generated
     * 修改日期
     * @return MODIFYDATE 
     */
    public Date getModifydate() {
        return modifydate;
    }

    /**
     *
     * @mbg.generated
     * 修改日期
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