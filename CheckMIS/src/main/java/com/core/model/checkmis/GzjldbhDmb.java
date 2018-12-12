package com.core.model.checkmis;

import java.math.BigDecimal;
import java.util.Date;

public class GzjldbhDmb {
    /**
     * 数据库:CHECKMIS.ST_GZJLBH_DMB.ID
     *
     * @mbg.generated
     */
    private BigDecimal id;

    /**
     * 数据库:CHECKMIS.ST_GZJLBH_DMB.GDZ
     *
     * @mbg.generated
     */
    private String gdz;

    /**
     * 数据库:CHECKMIS.ST_GZJLBH_DMB.YEAR
     *
     * @mbg.generated
     */
    private String year;

    /**
     * 数据库:CHECKMIS.ST_GZJLBH_DMB.TYPE
     *
     * @mbg.generated
     */
    private String type;

    /**
     * 数据库:CHECKMIS.ST_GZJLBH_DMB.MONTH
     *
     * @mbg.generated
     */
    private String month;

    /**
     * 数据库:CHECKMIS.ST_GZJLBH_DMB.ZZGH
     *
     * @mbg.generated
     */
    private String zzgh;

    /**
     * 数据库:CHECKMIS.ST_GZJLBH_DMB.SWS
     *
     * @mbg.generated
     */
    private Integer sws;

    /**
     * 数据库:CHECKMIS.ST_GZJLBH_DMB.CREATEDATE
     *
     * @mbg.generated
     */
    private Date createdate;

    /**
     * 数据库:CHECKMIS.ST_GZJLBH_DMB.MODIFYDATE
     *
     * @mbg.generated
     */
    private Date modifydate;

    /**
     * 数据库:CHECKMIS.ST_GZJLBH_DMB.CREATEUSER
     *
     * @mbg.generated
     */
    private String createuser;

    /**
     * 数据库:CHECKMIS.ST_GZJLBH_DMB.MODIFYUSER
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
    public BigDecimal getId() {
        return id;
    }

    /**
     *
     * @mbg.generated
     * ID
     * @param id 
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }

    /**
     *
     * @mbg.generated
     * 固定值
     * @return GDZ 
     */
    public String getGdz() {
        return gdz;
    }

    /**
     *
     * @mbg.generated
     * 固定值
     * @param gdz 
     */
    public void setGdz(String gdz) {
        this.gdz = gdz == null ? null : gdz.trim();
    }

    /**
     *
     * @mbg.generated
     * 年份
     * @return YEAR 
     */
    public String getYear() {
        return year;
    }

    /**
     *
     * @mbg.generated
     * 年份
     * @param year 
     */
    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    /**
     *
     * @mbg.generated
     * 类型ky/hy/kc代表客运、货运、列车
     * @return TYPE 
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @mbg.generated
     * 类型ky/hy/kc代表客运、货运、列车
     * @param type 
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     *
     * @mbg.generated
     * 月份
     * @return MONTH 
     */
    public String getMonth() {
        return month;
    }

    /**
     *
     * @mbg.generated
     * 月份
     * @param month 
     */
    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    /**
     *
     * @mbg.generated
     * 组长工号
     * @return ZZGH 
     */
    public String getZzgh() {
        return zzgh;
    }

    /**
     *
     * @mbg.generated
     * 组长工号
     * @param zzgh 
     */
    public void setZzgh(String zzgh) {
        this.zzgh = zzgh == null ? null : zzgh.trim();
    }

    /**
     *
     * @mbg.generated
     * 顺位数
     * @return SWS 
     */
    public Integer getSws() {
        return sws;
    }

    /**
     *
     * @mbg.generated
     * 顺位数
     * @param sws 
     */
    public void setSws(Integer sws) {
        this.sws = sws;
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