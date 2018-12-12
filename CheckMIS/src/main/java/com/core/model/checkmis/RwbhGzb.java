package com.core.model.checkmis;

import java.util.Date;

public class RwbhGzb {
    /**
     * 数据库:CHECKMIS.ST_RWBH_GZB.ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 数据库:CHECKMIS.ST_RWBH_GZB.TYPE
     *
     * @mbg.generated
     */
    private String type;

    /**
     * 数据库:CHECKMIS.ST_RWBH_GZB.NAME
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 数据库:CHECKMIS.ST_RWBH_GZB.NYR
     *
     * @mbg.generated
     */
    private String nyr;

    /**
     * 数据库:CHECKMIS.ST_RWBH_GZB.LJZ
     *
     * @mbg.generated
     */
    private Long ljz;

    /**
     * 数据库:CHECKMIS.ST_RWBH_GZB.CREATEDATE
     *
     * @mbg.generated
     */
    private Date createdate;

    /**
     * 数据库:CHECKMIS.ST_RWBH_GZB.MODIFYDATE
     *
     * @mbg.generated
     */
    private Date modifydate;

    /**
     * 数据库:CHECKMIS.ST_RWBH_GZB.CREATEUSER
     *
     * @mbg.generated
     */
    private String createuser;

    /**
     * 数据库:CHECKMIS.ST_RWBH_GZB.MODIFYUSER
     *
     * @mbg.generated
     */
    private String modifyuser;

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
     * 类型
     * @return TYPE 
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @mbg.generated
     * 类型
     * @param type 
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     *
     * @mbg.generated
     * 固定值
     * @return NAME 
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @mbg.generated
     * 固定值
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     *
     * @mbg.generated
     * 年月日
     * @return NYR 
     */
    public String getNyr() {
        return nyr;
    }

    /**
     *
     * @mbg.generated
     * 年月日
     * @param nyr 
     */
    public void setNyr(String nyr) {
        this.nyr = nyr == null ? null : nyr.trim();
    }

    /**
     *
     * @mbg.generated
     * 累计值
     * @return LJZ 
     */
    public Long getLjz() {
        return ljz;
    }

    /**
     *
     * @mbg.generated
     * 累计值
     * @param ljz 
     */
    public void setLjz(Long ljz) {
        this.ljz = ljz;
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