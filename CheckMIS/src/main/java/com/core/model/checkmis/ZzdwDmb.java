package com.core.model.checkmis;

import java.util.Date;

public class ZzdwDmb {
    /**
     * 数据库:CHECKMIS.ST_ZZDW_DMB.ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 数据库:CHECKMIS.ST_ZZDW_DMB.CODE
     *
     * @mbg.generated
     */
    private String code;

    /**
     * 数据库:CHECKMIS.ST_ZZDW_DMB.NAME
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 数据库:CHECKMIS.ST_ZZDW_DMB.TYPE
     *
     * @mbg.generated
     */
    private String type;

    /**
     * 数据库:CHECKMIS.ST_ZZDW_DMB.CREATEDATE
     *
     * @mbg.generated
     */
    private Date createdate;

    /**
     * 数据库:CHECKMIS.ST_ZZDW_DMB.MODIFYDATE
     *
     * @mbg.generated
     */
    private Date modifydate;

    /**
     * 数据库:CHECKMIS.ST_ZZDW_DMB.CREATEUSER
     *
     * @mbg.generated
     */
    private String createuser;

    /**
     * 数据库:CHECKMIS.ST_ZZDW_DMB.MODIFYUSER
     *
     * @mbg.generated
     */
    private String modifyuser;

    /**
     * 数据库:CHECKMIS.ST_ZZDW_DMB.PID
     *
     * @mbg.generated
     */
    private Long pid;

    /**
     *
     * @mbg.generated
     * 组织id
     * @return ID 
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @mbg.generated
     * 组织id
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @mbg.generated
     * 代码值
     * @return CODE 
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @mbg.generated
     * 代码值
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
     * 类型1-直属站、2-车务段、3-货运中心、4-客运段
     * @return TYPE 
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @mbg.generated
     * 类型1-直属站、2-车务段、3-货运中心、4-客运段
     * @param type 
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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

    /**
     *
     * @mbg.generated
     * 父id
     * @return PID 
     */
    public Long getPid() {
        return pid;
    }

    /**
     *
     * @mbg.generated
     * 父id
     * @param pid 
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }
}