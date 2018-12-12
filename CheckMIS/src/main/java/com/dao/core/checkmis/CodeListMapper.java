package com.dao.core.checkmis;

import com.core.model.checkmis.CodeList;
import com.core.model.checkmis.CodeListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CodeListMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.SYS_CODELIST
     *
     * @mbg.generated
     */
    long countByExample(CodeListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.SYS_CODELIST
     *
     * @mbg.generated
     */
    int deleteByExample(CodeListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.SYS_CODELIST
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.SYS_CODELIST
     *
     * @mbg.generated
     */
    int insert(CodeList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.SYS_CODELIST
     *
     * @mbg.generated
     */
    int insertSelective(CodeList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.SYS_CODELIST
     *
     * @mbg.generated
     */
    List<CodeList> selectByExample(CodeListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.SYS_CODELIST
     *
     * @mbg.generated
     */
    CodeList selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.SYS_CODELIST
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CodeList record, @Param("example") CodeListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.SYS_CODELIST
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CodeList record, @Param("example") CodeListExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.SYS_CODELIST
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CodeList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.SYS_CODELIST
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(CodeList record);
}