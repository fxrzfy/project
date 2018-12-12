package com.dao.core.checkmis;

import com.core.model.checkmis.Wtfk;
import com.core.model.checkmis.WtfkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WtfkMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTFK
     *
     * @mbg.generated
     */
    long countByExample(WtfkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTFK
     *
     * @mbg.generated
     */
    int deleteByExample(WtfkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTFK
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTFK
     *
     * @mbg.generated
     */
    int insert(Wtfk record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTFK
     *
     * @mbg.generated
     */
    int insertSelective(Wtfk record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTFK
     *
     * @mbg.generated
     */
    List<Wtfk> selectByExample(WtfkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTFK
     *
     * @mbg.generated
     */
    Wtfk selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTFK
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Wtfk record, @Param("example") WtfkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTFK
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Wtfk record, @Param("example") WtfkExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTFK
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Wtfk record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTFK
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Wtfk record);
}