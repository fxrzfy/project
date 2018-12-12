package com.core.model.checkmis;

public class CodeList {
    /**
     * 数据库:CHECKMIS.SYS_CODELIST.ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 数据库:CHECKMIS.SYS_CODELIST.NAME
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 数据库:CHECKMIS.SYS_CODELIST.CODE
     *
     * @mbg.generated
     */
    private String code;

    /**
     *
     * @mbg.generated
     * null
     * @return ID 
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @mbg.generated
     * null
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @mbg.generated
     * null
     * @return NAME 
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @mbg.generated
     * null
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     *
     * @mbg.generated
     * null
     * @return CODE 
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @mbg.generated
     * null
     * @param code 
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
}