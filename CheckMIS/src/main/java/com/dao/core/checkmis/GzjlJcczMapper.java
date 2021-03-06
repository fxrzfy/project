package com.dao.core.checkmis;

import com.core.model.checkmis.GzjlJccz;
import com.core.model.checkmis.GzjlJcczExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GzjlJcczMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZJL_JCCZ
     *
     * @mbg.generated
     */
    long countByExample(GzjlJcczExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZJL_JCCZ
     *
     * @mbg.generated
     */
    int deleteByExample(GzjlJcczExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZJL_JCCZ
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZJL_JCCZ
     *
     * @mbg.generated
     */
    int insert(GzjlJccz record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZJL_JCCZ
     *
     * @mbg.generated
     */
    int insertSelective(GzjlJccz record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZJL_JCCZ
     *
     * @mbg.generated
     */
    List<GzjlJccz> selectByExample(GzjlJcczExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZJL_JCCZ
     *
     * @mbg.generated
     */
    GzjlJccz selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZJL_JCCZ
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") GzjlJccz record, @Param("example") GzjlJcczExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZJL_JCCZ
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") GzjlJccz record, @Param("example") GzjlJcczExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZJL_JCCZ
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(GzjlJccz record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZJL_JCCZ
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(GzjlJccz record);
}