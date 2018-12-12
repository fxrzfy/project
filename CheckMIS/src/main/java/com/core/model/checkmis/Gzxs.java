package com.core.model.checkmis;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Gzxs {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CHECKMIS.ST_GZXS.ID
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CHECKMIS.ST_GZXS.JCFL
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    private String jcfl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CHECKMIS.ST_GZXS.JCKSSJ
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    @JSONField(format = "yyyy-MM-dd")
    private Date jckssj;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CHECKMIS.ST_GZXS.JCJSSJ
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    @JSONField(format = "yyyy-MM-dd")
    private Date jcjssj;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CHECKMIS.ST_GZXS.JCRY
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    private String jcry;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CHECKMIS.ST_GZXS.PTRY
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    private String ptry;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CHECKMIS.ST_GZXS.QTRY
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    private String qtry;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CHECKMIS.ST_GZXS.JCZLSJD
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    private String jczlsjd;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CHECKMIS.ST_GZXS.TY1
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    private String ty1;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CHECKMIS.ST_GZXS.TY2
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    private String ty2;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CHECKMIS.ST_GZXS.TY3
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    private String ty3;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CHECKMIS.ST_GZXS.LCLX
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    private String lclx;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CHECKMIS.ST_GZXS.BCCC
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    private String bccc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CHECKMIS.ST_GZXS.JCKSQJ
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    private String jcksqj;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CHECKMIS.ST_GZXS.JCJSQJ
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    private String jcjsqj;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CHECKMIS.ST_GZXS.CREATEDATE
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    private Date createdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CHECKMIS.ST_GZXS.MODIFYDATE
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    private Date modifydate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CHECKMIS.ST_GZXS.CREATEUSER
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    private String createuser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CHECKMIS.ST_GZXS.MODIFYUSER
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    private String modifyuser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column CHECKMIS.ST_GZXS.LX
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    private Short lx;

    private String workNumber;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHECKMIS.ST_GZXS.ID
     *
     * @return the value of CHECKMIS.ST_GZXS.ID
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHECKMIS.ST_GZXS.ID
     *
     * @param id the value for CHECKMIS.ST_GZXS.ID
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHECKMIS.ST_GZXS.JCFL
     *
     * @return the value of CHECKMIS.ST_GZXS.JCFL
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public String getJcfl() {
        return jcfl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHECKMIS.ST_GZXS.JCFL
     *
     * @param jcfl the value for CHECKMIS.ST_GZXS.JCFL
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public void setJcfl(String jcfl) {
        this.jcfl = jcfl == null ? null : jcfl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHECKMIS.ST_GZXS.JCKSSJ
     *
     * @return the value of CHECKMIS.ST_GZXS.JCKSSJ
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public Date getJckssj() {
        return jckssj;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHECKMIS.ST_GZXS.JCKSSJ
     *
     * @param jckssj the value for CHECKMIS.ST_GZXS.JCKSSJ
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public void setJckssj(Date jckssj) {
        this.jckssj = jckssj;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHECKMIS.ST_GZXS.JCJSSJ
     *
     * @return the value of CHECKMIS.ST_GZXS.JCJSSJ
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public Date getJcjssj() {
        return jcjssj;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHECKMIS.ST_GZXS.JCJSSJ
     *
     * @param jcjssj the value for CHECKMIS.ST_GZXS.JCJSSJ
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public void setJcjssj(Date jcjssj) {
        this.jcjssj = jcjssj;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHECKMIS.ST_GZXS.JCRY
     *
     * @return the value of CHECKMIS.ST_GZXS.JCRY
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public String getJcry() {
        return jcry;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHECKMIS.ST_GZXS.JCRY
     *
     * @param jcry the value for CHECKMIS.ST_GZXS.JCRY
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public void setJcry(String jcry) {
        this.jcry = jcry == null ? null : jcry.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHECKMIS.ST_GZXS.PTRY
     *
     * @return the value of CHECKMIS.ST_GZXS.PTRY
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public String getPtry() {
        return ptry;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHECKMIS.ST_GZXS.PTRY
     *
     * @param ptry the value for CHECKMIS.ST_GZXS.PTRY
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public void setPtry(String ptry) {
        this.ptry = ptry == null ? null : ptry.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHECKMIS.ST_GZXS.QTRY
     *
     * @return the value of CHECKMIS.ST_GZXS.QTRY
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public String getQtry() {
        return qtry;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHECKMIS.ST_GZXS.QTRY
     *
     * @param qtry the value for CHECKMIS.ST_GZXS.QTRY
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public void setQtry(String qtry) {
        this.qtry = qtry == null ? null : qtry.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHECKMIS.ST_GZXS.JCZLSJD
     *
     * @return the value of CHECKMIS.ST_GZXS.JCZLSJD
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public String getJczlsjd() {
        return jczlsjd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHECKMIS.ST_GZXS.JCZLSJD
     *
     * @param jczlsjd the value for CHECKMIS.ST_GZXS.JCZLSJD
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public void setJczlsjd(String jczlsjd) {
        this.jczlsjd = jczlsjd == null ? null : jczlsjd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHECKMIS.ST_GZXS.TY1
     *
     * @return the value of CHECKMIS.ST_GZXS.TY1
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public String getTy1() {
        return ty1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHECKMIS.ST_GZXS.TY1
     *
     * @param ty1 the value for CHECKMIS.ST_GZXS.TY1
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public void setTy1(String ty1) {
        this.ty1 = ty1 == null ? null : ty1.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHECKMIS.ST_GZXS.TY2
     *
     * @return the value of CHECKMIS.ST_GZXS.TY2
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public String getTy2() {
        return ty2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHECKMIS.ST_GZXS.TY2
     *
     * @param ty2 the value for CHECKMIS.ST_GZXS.TY2
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public void setTy2(String ty2) {
        this.ty2 = ty2 == null ? null : ty2.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHECKMIS.ST_GZXS.TY3
     *
     * @return the value of CHECKMIS.ST_GZXS.TY3
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public String getTy3() {
        return ty3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHECKMIS.ST_GZXS.TY3
     *
     * @param ty3 the value for CHECKMIS.ST_GZXS.TY3
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public void setTy3(String ty3) {
        this.ty3 = ty3 == null ? null : ty3.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHECKMIS.ST_GZXS.LCLX
     *
     * @return the value of CHECKMIS.ST_GZXS.LCLX
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public String getLclx() {
        return lclx;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHECKMIS.ST_GZXS.LCLX
     *
     * @param lclx the value for CHECKMIS.ST_GZXS.LCLX
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public void setLclx(String lclx) {
        this.lclx = lclx == null ? null : lclx.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHECKMIS.ST_GZXS.BCCC
     *
     * @return the value of CHECKMIS.ST_GZXS.BCCC
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public String getBccc() {
        return bccc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHECKMIS.ST_GZXS.BCCC
     *
     * @param bccc the value for CHECKMIS.ST_GZXS.BCCC
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public void setBccc(String bccc) {
        this.bccc = bccc == null ? null : bccc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHECKMIS.ST_GZXS.JCKSQJ
     *
     * @return the value of CHECKMIS.ST_GZXS.JCKSQJ
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public String getJcksqj() {
        return jcksqj;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHECKMIS.ST_GZXS.JCKSQJ
     *
     * @param jcksqj the value for CHECKMIS.ST_GZXS.JCKSQJ
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public void setJcksqj(String jcksqj) {
        this.jcksqj = jcksqj == null ? null : jcksqj.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHECKMIS.ST_GZXS.JCJSQJ
     *
     * @return the value of CHECKMIS.ST_GZXS.JCJSQJ
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public String getJcjsqj() {
        return jcjsqj;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHECKMIS.ST_GZXS.JCJSQJ
     *
     * @param jcjsqj the value for CHECKMIS.ST_GZXS.JCJSQJ
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public void setJcjsqj(String jcjsqj) {
        this.jcjsqj = jcjsqj == null ? null : jcjsqj.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHECKMIS.ST_GZXS.CREATEDATE
     *
     * @return the value of CHECKMIS.ST_GZXS.CREATEDATE
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHECKMIS.ST_GZXS.CREATEDATE
     *
     * @param createdate the value for CHECKMIS.ST_GZXS.CREATEDATE
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHECKMIS.ST_GZXS.MODIFYDATE
     *
     * @return the value of CHECKMIS.ST_GZXS.MODIFYDATE
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public Date getModifydate() {
        return modifydate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHECKMIS.ST_GZXS.MODIFYDATE
     *
     * @param modifydate the value for CHECKMIS.ST_GZXS.MODIFYDATE
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHECKMIS.ST_GZXS.CREATEUSER
     *
     * @return the value of CHECKMIS.ST_GZXS.CREATEUSER
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public String getCreateuser() {
        return createuser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHECKMIS.ST_GZXS.CREATEUSER
     *
     * @param createuser the value for CHECKMIS.ST_GZXS.CREATEUSER
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHECKMIS.ST_GZXS.MODIFYUSER
     *
     * @return the value of CHECKMIS.ST_GZXS.MODIFYUSER
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public String getModifyuser() {
        return modifyuser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHECKMIS.ST_GZXS.MODIFYUSER
     *
     * @param modifyuser the value for CHECKMIS.ST_GZXS.MODIFYUSER
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public void setModifyuser(String modifyuser) {
        this.modifyuser = modifyuser == null ? null : modifyuser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column CHECKMIS.ST_GZXS.LX
     *
     * @return the value of CHECKMIS.ST_GZXS.LX
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public Short getLx() {
        return lx;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column CHECKMIS.ST_GZXS.LX
     *
     * @param lx the value for CHECKMIS.ST_GZXS.LX
     *
     * @mbggenerated Sun Oct 07 17:16:39 CST 2018
     */
    public void setLx(Short lx) {
        this.lx = lx;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber;
    }
}