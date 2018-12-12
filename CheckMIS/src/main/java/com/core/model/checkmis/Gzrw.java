package com.core.model.checkmis;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Gzrw {
    /**
     * 数据库:CHECKMIS.ST_GZRW.ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 数据库:CHECKMIS.ST_GZRW.RWBH
     *
     * @mbg.generated
     */
    private String rwbh;

    /**
     * 数据库:CHECKMIS.ST_GZRW.RWMC
     *
     * @mbg.generated
     */
    private String rwmc;

    /**
     * 数据库:CHECKMIS.ST_GZRW.RWKSSJ
     *
     * @mbg.generated
     */
    @JSONField(format="yyyy-MM-dd")
    private Date rwkssj;

    /**
     * 数据库:CHECKMIS.ST_GZRW.RWJSSJ
     *
     * @mbg.generated
     */
    @JSONField(format="yyyy-MM-dd")
    private Date rwjssj;

    /**
     * 数据库:CHECKMIS.ST_GZRW.ZFSJ
     *
     * @mbg.generated
     */
    @JSONField(format="yyyy-MM-dd")
    private Date zfsj;

    /**
     * 数据库:CHECKMIS.ST_GZRW.RWZT
     *
     * @mbg.generated
     */
    private Short rwzt;

    /**
     * 数据库:CHECKMIS.ST_GZRW.GZYQ
     *
     * @mbg.generated
     */
    private String gzyq;

    /**
     * 数据库:CHECKMIS.ST_GZRW.CREATEDATE
     *
     * @mbg.generated
     */
    private Date createdate;

    /**
     * 数据库:CHECKMIS.ST_GZRW.MODIFYDATE
     *
     * @mbg.generated
     */
    private Date modifydate;

    /**
     * 数据库:CHECKMIS.ST_GZRW.CREATEUSER
     *
     * @mbg.generated
     */
    private String createuser;

    /**
     * 数据库:CHECKMIS.ST_GZRW.MODIFYUSER
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
     * 任务编号
     * @return RWBH 
     */
    public String getRwbh() {
        return rwbh;
    }

    /**
     *
     * @mbg.generated
     * 任务编号
     * @param rwbh 
     */
    public void setRwbh(String rwbh) {
        this.rwbh = rwbh == null ? null : rwbh.trim();
    }

    /**
     *
     * @mbg.generated
     * 任务名称
     * @return RWMC 
     */
    public String getRwmc() {
        return rwmc;
    }

    /**
     *
     * @mbg.generated
     * 任务名称
     * @param rwmc 
     */
    public void setRwmc(String rwmc) {
        this.rwmc = rwmc == null ? null : rwmc.trim();
    }

    /**
     *
     * @mbg.generated
     * 任务开始时间
     * @return RWKSSJ 
     */
    public Date getRwkssj() {
        return rwkssj;
    }

    /**
     *
     * @mbg.generated
     * 任务开始时间
     * @param rwkssj 
     */
    public void setRwkssj(Date rwkssj) {
        this.rwkssj = rwkssj;
    }

    /**
     *
     * @mbg.generated
     * 任务结束时间
     * @return RWJSSJ 
     */
    public Date getRwjssj() {
        return rwjssj;
    }

    /**
     *
     * @mbg.generated
     * 任务结束时间
     * @param rwjssj 
     */
    public void setRwjssj(Date rwjssj) {
        this.rwjssj = rwjssj;
    }

    /**
     *
     * @mbg.generated
     * 作废时间
     * @return ZFSJ 
     */
    public Date getZfsj() {
        return zfsj;
    }

    /**
     *
     * @mbg.generated
     * 作废时间
     * @param zfsj 
     */
    public void setZfsj(Date zfsj) {
        this.zfsj = zfsj;
    }

    /**
     *
     * @mbg.generated
     * 任务状态0-已保存，1-保存已推送，2-签收中，3-签收完成
     * @return RWZT 
     */
    public Short getRwzt() {
        return rwzt;
    }

    /**
     *
     * @mbg.generated
     * 任务状态0-已保存，1-保存已推送，2-签收中，3-签收完成
     * @param rwzt 
     */
    public void setRwzt(Short rwzt) {
        this.rwzt = rwzt;
    }

    /**
     *
     * @mbg.generated
     * 工作要求
     * @return GZYQ 
     */
    public String getGzyq() {
        return gzyq;
    }

    /**
     *
     * @mbg.generated
     * 工作要求
     * @param gzyq 
     */
    public void setGzyq(String gzyq) {
        this.gzyq = gzyq == null ? null : gzyq.trim();
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