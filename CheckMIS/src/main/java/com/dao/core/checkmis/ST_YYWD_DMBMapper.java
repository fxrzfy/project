package com.dao.core.checkmis;

import com.core.model.checkmis.ST_YYWD_DMB;
import com.core.model.checkmis.ST_YYWD_DMBExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ST_YYWD_DMBMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_YYWD_DMB
     *
     * @mbg.generated
     */
    long countByExample(ST_YYWD_DMBExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_YYWD_DMB
     *
     * @mbg.generated
     */
    int deleteByExample(ST_YYWD_DMBExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_YYWD_DMB
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_YYWD_DMB
     *
     * @mbg.generated
     */
    int insert(ST_YYWD_DMB record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_YYWD_DMB
     *
     * @mbg.generated
     */
    int insertSelective(ST_YYWD_DMB record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_YYWD_DMB
     *
     * @mbg.generated
     */
    List<ST_YYWD_DMB> selectByExample(ST_YYWD_DMBExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_YYWD_DMB
     *
     * @mbg.generated
     */
    ST_YYWD_DMB selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_YYWD_DMB
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") ST_YYWD_DMB record, @Param("example") ST_YYWD_DMBExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_YYWD_DMB
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") ST_YYWD_DMB record, @Param("example") ST_YYWD_DMBExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_YYWD_DMB
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ST_YYWD_DMB record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_YYWD_DMB
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ST_YYWD_DMB record);
}