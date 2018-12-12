package com.core.model.checkmis;

import java.math.BigDecimal;

public class ZzdwZdMap {
    /**
     * 数据库:CHECKMIS.ST_ZZDW_ZD_MAP.DEPT_ID
     *
     * @mbg.generated
     */
    private Long deptId;

    /**
     * 数据库:CHECKMIS.ST_ZZDW_ZD_MAP.ZD_ID
     *
     * @mbg.generated
     */
    private Long zdId;

    /**
     * 数据库:CHECKMIS.ST_ZZDW_ZD_MAP.TYPE
     *
     * @mbg.generated
     */
    private Short type;

    /**
     *
     * @mbg.generated
     * SYS_DEPT表ID
     * @return DEPT_ID 
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     *
     * @mbg.generated
     * SYS_DEPT表ID
     * @param deptId 
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     *
     * @mbg.generated
     * ST_ZD_DMB表ID
     * @return ZD_ID 
     */
    public Long getZdId() {
        return zdId;
    }

    /**
     *
     * @mbg.generated
     * ST_ZD_DMB表ID
     * @param zdId 
     */
    public void setZdId(Long zdId) {
        this.zdId = zdId;
    }

    /**
     *
     * @mbg.generated
     * 类型1-直属站，2-车务段
     * @return TYPE 
     */
    public Short getType() {
        return type;
    }

    /**
     *
     * @mbg.generated
     * 类型1-直属站，2-车务段
     * @param type 
     */
    public void setType(Short type) {
        this.type = type;
    }
}