package com.core.model.checkmis;

import java.util.Date;

public class GzjlJccz {
    /**
     * 数据库:CHECKMIS.ST_GZJL_JCCZ.ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 数据库:CHECKMIS.ST_GZJL_JCCZ.GZJLMX_ID
     *
     * @mbg.generated
     */
    private Long gzjlmxId;

    /**
     * 数据库:CHECKMIS.ST_GZJL_JCCZ.JCCZ
     *
     * @mbg.generated
     */
    private String jccz;

    /**
     * 数据库:CHECKMIS.ST_GZJL_JCCZ.JCCZ_KSSJ
     *
     * @mbg.generated
     */
    private String jcczKssj;

    /**
     * 数据库:CHECKMIS.ST_GZJL_JCCZ.JCCZ_JSSJ
     *
     * @mbg.generated
     */
    private String jcczJssj;

    /**
     * 数据库:CHECKMIS.ST_GZJL_JCCZ.JCZD
     *
     * @mbg.generated
     */
    private String jczd;

    /**
     * 数据库:CHECKMIS.ST_GZJL_JCCZ.CREATEDATE
     *
     * @mbg.generated
     */
    private Date createdate;

    /**
     * 数据库:CHECKMIS.ST_GZJL_JCCZ.MODIFYDATE
     *
     * @mbg.generated
     */
    private Date modifydate;

    /**
     * 数据库:CHECKMIS.ST_GZJL_JCCZ.CREATEUSER
     *
     * @mbg.generated
     */
    private String createuser;

    /**
     * 数据库:CHECKMIS.ST_GZJL_JCCZ.MODIFYUSER
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
     * 工作交路id，st_gzjlmx
     * @return GZJLMX_ID 
     */
    public Long getGzjlmxId() {
        return gzjlmxId;
    }

    /**
     *
     * @mbg.generated
     * 工作交路id，st_gzjlmx
     * @param gzjlmxId 
     */
    public void setGzjlmxId(Long gzjlmxId) {
        this.gzjlmxId = gzjlmxId;
    }

    /**
     *
     * @mbg.generated
     * 检查车站
     * @return JCCZ 
     */
    public String getJccz() {
        return jccz;
    }

    /**
     *
     * @mbg.generated
     * 检查车站
     * @param jccz 
     */
    public void setJccz(String jccz) {
        this.jccz = jccz == null ? null : jccz.trim();
    }

    /**
     *
     * @mbg.generated
     * 检查车站开始时间
     * @return JCCZ_KSSJ 
     */
    public String getJcczKssj() {
        return jcczKssj;
    }

    /**
     *
     * @mbg.generated
     * 检查车站开始时间
     * @param jcczKssj 
     */
    public void setJcczKssj(String jcczKssj) {
        this.jcczKssj = jcczKssj;
    }

    /**
     *
     * @mbg.generated
     * 检查车站结束时间
     * @return JCCZ_JSSJ 
     */
    public String getJcczJssj() {
        return jcczJssj;
    }

    /**
     *
     * @mbg.generated
     * 检查车站结束时间
     * @param jcczJssj 
     */
    public void setJcczJssj(String jcczJssj) {
        this.jcczJssj = jcczJssj;
    }

    /**
     *
     * @mbg.generated
     * 检查重点
     * @return JCZD 
     */
    public String getJczd() {
        return jczd;
    }

    /**
     *
     * @mbg.generated
     * 检查重点
     * @param jczd 
     */
    public void setJczd(String jczd) {
        this.jczd = jczd == null ? null : jczd.trim();
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