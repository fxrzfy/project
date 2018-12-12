package com.dao.core.checkmis;

import com.core.model.checkmis.GzDmb;
import com.core.model.checkmis.GzDmbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GzDmbMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZ_DMB
     *
     * @mbg.generated
     */
    long countByExample(GzDmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZ_DMB
     *
     * @mbg.generated
     */
    int deleteByExample(GzDmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZ_DMB
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZ_DMB
     *
     * @mbg.generated
     */
    int insert(GzDmb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZ_DMB
     *
     * @mbg.generated
     */
    int insertSelective(GzDmb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZ_DMB
     *
     * @mbg.generated
     */
    List<GzDmb> selectByExample(GzDmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZ_DMB
     *
     * @mbg.generated
     */
    GzDmb selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZ_DMB
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") GzDmb record, @Param("example") GzDmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZ_DMB
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") GzDmb record, @Param("example") GzDmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZ_DMB
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(GzDmb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_GZ_DMB
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(GzDmb record);
}