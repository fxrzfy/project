package com.core.model.checkmis;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Gzzd {
    /**
     * 数据库:CHECKMIS.ST_GZZD.ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 数据库:CHECKMIS.ST_GZZD.BT
     *
     * @mbg.generated
     */
    private String bt;

    /**
     * 数据库:CHECKMIS.ST_GZZD.WH
     *
     * @mbg.generated
     */
    private String wh;

    /**
     * 数据库:CHECKMIS.ST_GZZD.FBSJ
     *
     * @mbg.generated
     */
    @JSONField(format="yyyy-MM-dd")
    private Date fbsj;

    /**
     * 数据库:CHECKMIS.ST_GZZD.ZT
     *
     * @mbg.generated
     */
    private Short zt;

    /**
     * 数据库:CHECKMIS.ST_GZZD.CREATEDATE
     *
     * @mbg.generated
     */
    private Date createdate;

    /**
     * 数据库:CHECKMIS.ST_GZZD.MODIFYDATE
     *
     * @mbg.generated
     */
    private Date modifydate;

    /**
     * 数据库:CHECKMIS.ST_GZZD.CREATEUSER
     *
     * @mbg.generated
     */
    private String createuser;

    /**
     * 数据库:CHECKMIS.ST_GZZD.MODIFYUSER
     *
     * @mbg.generated
     */
    private String modifyuser;

    /**
     * 数据库:CHECKMIS.ST_GZZD.FBNR
     *
     * @mbg.generated
     */
    private String fbnr;

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
     * 标题
     * @return BT 
     */
    public String getBt() {
        return bt;
    }

    /**
     *
     * @mbg.generated
     * 标题
     * @param bt 
     */
    public void setBt(String bt) {
        this.bt = bt == null ? null : bt.trim();
    }

    /**
     *
     * @mbg.generated
     * 文号
     * @return WH 
     */
    public String getWh() {
        return wh;
    }

    /**
     *
     * @mbg.generated
     * 文号
     * @param wh 
     */
    public void setWh(String wh) {
        this.wh = wh == null ? null : wh.trim();
    }

    /**
     *
     * @mbg.generated
     * 发布时间
     * @return FBSJ 
     */
    public Date getFbsj() {
        return fbsj;
    }

    /**
     *
     * @mbg.generated
     * 发布时间
     * @param fbsj 
     */
    public void setFbsj(Date fbsj) {
        this.fbsj = fbsj;
    }

    /**
     *
     * @mbg.generated
     * 状态0-未发布，1-已发布
     * @return ZT 
     */
    public Short getZt() {
        return zt;
    }

    /**
     *
     * @mbg.generated
     * 状态0-未发布，1-已发布
     * @param zt 
     */
    public void setZt(Short zt) {
        this.zt = zt;
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

    /**
     *
     * @mbg.generated
     * 发布内容
     * @return FBNR 
     */
    public String getFbnr() {
        return fbnr;
    }

    /**
     *
     * @mbg.generated
     * 发布内容
     * @param fbnr 
     */
    public void setFbnr(String fbnr) {
        this.fbnr = fbnr == null ? null : fbnr.trim();
    }
}