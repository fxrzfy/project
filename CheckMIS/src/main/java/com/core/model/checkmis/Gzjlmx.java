package com.core.model.checkmis;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Gzjlmx {
    /**
     * 数据库:CHECKMIS.ST_GZJLMX.ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 数据库:CHECKMIS.ST_GZJLMX.GZJL_ID
     *
     * @mbg.generated
     */
    private Long gzjlId;

    /**
     * 数据库:CHECKMIS.ST_GZJLMX.JHKSSJ
     *
     * @mbg.generated
     */
    @JSONField(format="yyyy-MM-dd")
    private Date jhkssj;

    /**
     * 数据库:CHECKMIS.ST_GZJLMX.JHJSSJ
     *
     * @mbg.generated
     */
    @JSONField(format="yyyy-MM-dd")
    private Date jhjssj;

    /**
     * 数据库:CHECKMIS.ST_GZJLMX.JHLX
     *
     * @mbg.generated
     */
    private Short jhlx;

    /**
     * 数据库:CHECKMIS.ST_GZJLMX.CREATEDATE
     *
     * @mbg.generated
     */
    private Date createdate;

    /**
     * 数据库:CHECKMIS.ST_GZJLMX.MODIFYDATE
     *
     * @mbg.generated
     */
    private Date modifydate;

    /**
     * 数据库:CHECKMIS.ST_GZJLMX.CREATEUSER
     *
     * @mbg.generated
     */
    private String createuser;

    /**
     * 数据库:CHECKMIS.ST_GZJLMX.MODIFYUSER
     *
     * @mbg.generated
     */
    private String modifyuser;

    /**
     * 数据库:CHECKMIS.ST_GZJLMX.BZ
     *
     * @mbg.generated
     */
    private String bz;

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
     * ST_GZJL表
     * @return GZJL_ID 
     */
    public Long getGzjlId() {
        return gzjlId;
    }

    /**
     *
     * @mbg.generated
     * ST_GZJL表
     * @param gzjlId 
     */
    public void setGzjlId(Long gzjlId) {
        this.gzjlId = gzjlId;
    }

    /**
     *
     * @mbg.generated
     * 计划开始时间
     * @return JHKSSJ 
     */
    public Date getJhkssj() {
        return jhkssj;
    }

    /**
     *
     * @mbg.generated
     * 计划开始时间
     * @param jhkssj 
     */
    public void setJhkssj(Date jhkssj) {
        this.jhkssj = jhkssj;
    }

    /**
     *
     * @mbg.generated
     * 计划结束时间
     * @return JHJSSJ 
     */
    public Date getJhjssj() {
        return jhjssj;
    }

    /**
     *
     * @mbg.generated
     * 计划结束时间
     * @param jhjssj 
     */
    public void setJhjssj(Date jhjssj) {
        this.jhjssj = jhjssj;
    }

    /**
     *
     * @mbg.generated
     * 计划类型0-工作计划，1-休息，2-其他
     * @return JHLX 
     */
    public Short getJhlx() {
        return jhlx;
    }

    /**
     *
     * @mbg.generated
     * 计划类型0-工作计划，1-休息，2-其他
     * @param jhlx 
     */
    public void setJhlx(Short jhlx) {
        this.jhlx = jhlx;
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
     * 填写休息或其他的文字描述
     * @return BZ 
     */
    public String getBz() {
        return bz;
    }

    /**
     *
     * @mbg.generated
     * 填写休息或其他的文字描述
     * @param bz 
     */
    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }
}