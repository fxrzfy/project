package com.core.model.checkmis;

import java.util.Date;

public class Person {
    /**
     * 数据库:CHECKMIS.SYS_PERSON.ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 数据库:CHECKMIS.SYS_PERSON.DEPT_ID
     *
     * @mbg.generated
     */
    private Long deptId;

    /**
     * 数据库:CHECKMIS.SYS_PERSON.USER_PHONE
     *
     * @mbg.generated
     */
    private String userPhone;

    /**
     * 数据库:CHECKMIS.SYS_PERSON.WORK_NUMBER
     *
     * @mbg.generated
     */
    private String workNumber;

    /**
     * 数据库:CHECKMIS.SYS_PERSON.NAME
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 数据库:CHECKMIS.SYS_PERSON.PASSWORD
     *
     * @mbg.generated
     */
    private String password;

    /**
     * 数据库:CHECKMIS.SYS_PERSON.YXBZ
     *
     * @mbg.generated
     */
    private Short yxbz;

    /**
     * 数据库:CHECKMIS.SYS_PERSON.MEMO
     *
     * @mbg.generated
     */
    private String memo;

    /**
     * 数据库:CHECKMIS.SYS_PERSON.CREATEDATE
     *
     * @mbg.generated
     */
    private Date createdate;

    /**
     * 数据库:CHECKMIS.SYS_PERSON.MODIFYDATE
     *
     * @mbg.generated
     */
    private Date modifydate;

    /**
     * 数据库:CHECKMIS.SYS_PERSON.CREATEUSER
     *
     * @mbg.generated
     */
    private String createuser;

    /**
     * 数据库:CHECKMIS.SYS_PERSON.MODIFYUSER
     *
     * @mbg.generated
     */
    private String modifyuser;

    /**
     * 数据库:CHECKMIS.SYS_PERSON.USER_NAME
     *
     * @mbg.generated
     */
    private String userName;

    /**
     * 数据库:CHECKMIS.SYS_PERSON.CSRQ
     *
     * @mbg.generated
     */
    private Date csrq;

    /**
     * 数据库:CHECKMIS.SYS_PERSON.SFZH
     *
     * @mbg.generated
     */
    private String sfzh;

    /**
     * 数据库:CHECKMIS.SYS_PERSON.XB
     *
     * @mbg.generated
     */
    private Short xb;

    /**
     * 数据库:CHECKMIS.SYS_PERSON.NZYH
     *
     * @mbg.generated
     */
    private Short nzyh;

    /**
     * 数据库:CHECKMIS.SYS_PERSON.ZW
     *
     * @mbg.generated
     */
    private String zw;

    /**
     * 数据库:CHECKMIS.SYS_PERSON.LD
     *
     * @mbg.generated
     */
    private String ld;

    /**
     * 数据库:CHECKMIS.SYS_PERSON.QRZXL
     *
     * @mbg.generated
     */
    private String qrzxl;

    /**
     * 数据库:CHECKMIS.SYS_PERSON.ZGXL
     *
     * @mbg.generated
     */
    private String zgxl;

    /**
     * 数据库:CHECKMIS.SYS_PERSON.CYJCZ
     *
     * @mbg.generated
     */
    private Short cyjcz;

    /**
     * 数据库:CHECKMIS.SYS_PERSON.EMAIL
     *
     * @mbg.generated
     */
    private String email;

    /**
     * 数据库:CHECKMIS.SYS_PERSON.JTDZ
     *
     * @mbg.generated
     */
    private String jtdz;

    /**
     *
     * @mbg.generated
     * 人员id
     * @return ID 
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @mbg.generated
     * 人员id
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @mbg.generated
     * 部门id，sys_dept表
     * @return DEPT_ID 
     */
    public Long getDeptId() {
        return deptId;
    }

    /**
     *
     * @mbg.generated
     * 部门id，sys_dept表
     * @param deptId 
     */
    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    /**
     *
     * @mbg.generated
     * 手机号
     * @return USER_PHONE 
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     *
     * @mbg.generated
     * 手机号
     * @param userPhone 
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    /**
     *
     * @mbg.generated
     * 工号
     * @return WORK_NUMBER 
     */
    public String getWorkNumber() {
        return workNumber;
    }

    /**
     *
     * @mbg.generated
     * 工号
     * @param workNumber 
     */
    public void setWorkNumber(String workNumber) {
        this.workNumber = workNumber == null ? null : workNumber.trim();
    }

    /**
     *
     * @mbg.generated
     * 姓名
     * @return NAME 
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @mbg.generated
     * 姓名
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     *
     * @mbg.generated
     * 密码
     * @return PASSWORD 
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @mbg.generated
     * 密码
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     *
     * @mbg.generated
     * 有效标志0-删除，1-有效
     * @return YXBZ 
     */
    public Short getYxbz() {
        return yxbz;
    }

    /**
     *
     * @mbg.generated
     * 有效标志0-删除，1-有效
     * @param yxbz 
     */
    public void setYxbz(Short yxbz) {
        this.yxbz = yxbz;
    }

    /**
     *
     * @mbg.generated
     * 描述
     * @return MEMO 
     */
    public String getMemo() {
        return memo;
    }

    /**
     *
     * @mbg.generated
     * 描述
     * @param memo 
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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
     * 用户名
     * @return USER_NAME 
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @mbg.generated
     * 用户名
     * @param userName 
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     *
     * @mbg.generated
     * 出生日期
     * @return CSRQ 
     */
    public Date getCsrq() {
        return csrq;
    }

    /**
     *
     * @mbg.generated
     * 出生日期
     * @param csrq 
     */
    public void setCsrq(Date csrq) {
        this.csrq = csrq;
    }

    /**
     *
     * @mbg.generated
     * 省份证号
     * @return SFZH 
     */
    public String getSfzh() {
        return sfzh;
    }

    /**
     *
     * @mbg.generated
     * 省份证号
     * @param sfzh 
     */
    public void setSfzh(String sfzh) {
        this.sfzh = sfzh == null ? null : sfzh.trim();
    }

    /**
     *
     * @mbg.generated
     * 性别0-男，1-女
     * @return XB 
     */
    public Short getXb() {
        return xb;
    }

    /**
     *
     * @mbg.generated
     * 性别0-男，1-女
     * @param xb 
     */
    public void setXb(Short xb) {
        this.xb = xb;
    }

    /**
     *
     * @mbg.generated
     * 内置用户1-是，0-否
     * @return NZYH 
     */
    public Short getNzyh() {
        return nzyh;
    }

    /**
     *
     * @mbg.generated
     * 内置用户1-是，0-否
     * @param nzyh 
     */
    public void setNzyh(Short nzyh) {
        this.nzyh = nzyh;
    }

    /**
     *
     * @mbg.generated
     * 职务
     * @return ZW 
     */
    public String getZw() {
        return zw;
    }

    /**
     *
     * @mbg.generated
     * 职务
     * @param zw 
     */
    public void setZw(String zw) {
        this.zw = zw == null ? null : zw.trim();
    }

    /**
     *
     * @mbg.generated
     * 路电
     * @return LD 
     */
    public String getLd() {
        return ld;
    }

    /**
     *
     * @mbg.generated
     * 路电
     * @param ld 
     */
    public void setLd(String ld) {
        this.ld = ld == null ? null : ld.trim();
    }

    /**
     *
     * @mbg.generated
     * 全日制学历
     * @return QRZXL 
     */
    public String getQrzxl() {
        return qrzxl;
    }

    /**
     *
     * @mbg.generated
     * 全日制学历
     * @param qrzxl 
     */
    public void setQrzxl(String qrzxl) {
        this.qrzxl = qrzxl == null ? null : qrzxl.trim();
    }

    /**
     *
     * @mbg.generated
     * 最高学历
     * @return ZGXL 
     */
    public String getZgxl() {
        return zgxl;
    }

    /**
     *
     * @mbg.generated
     * 最高学历
     * @param zgxl 
     */
    public void setZgxl(String zgxl) {
        this.zgxl = zgxl == null ? null : zgxl.trim();
    }

    /**
     *
     * @mbg.generated
     * 持有稽查证1-是，0-否
     * @return CYJCZ 
     */
    public Short getCyjcz() {
        return cyjcz;
    }

    /**
     *
     * @mbg.generated
     * 持有稽查证1-是，0-否
     * @param cyjcz 
     */
    public void setCyjcz(Short cyjcz) {
        this.cyjcz = cyjcz;
    }

    /**
     *
     * @mbg.generated
     * 邮箱
     * @return EMAIL 
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @mbg.generated
     * 邮箱
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     *
     * @mbg.generated
     * 家庭地址
     * @return JTDZ 
     */
    public String getJtdz() {
        return jtdz;
    }

    /**
     *
     * @mbg.generated
     * 家庭地址
     * @param jtdz 
     */
    public void setJtdz(String jtdz) {
        this.jtdz = jtdz == null ? null : jtdz.trim();
    }
}