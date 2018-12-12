package com.dao.core.checkmis;

import com.core.model.checkmis.CdDmb;
import com.core.model.checkmis.CdDmbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CdDmbMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_CD_DMB
     *
     * @mbg.generated
     */
    long countByExample(CdDmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_CD_DMB
     *
     * @mbg.generated
     */
    int deleteByExample(CdDmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_CD_DMB
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_CD_DMB
     *
     * @mbg.generated
     */
    int insert(CdDmb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_CD_DMB
     *
     * @mbg.generated
     */
    int insertSelective(CdDmb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_CD_DMB
     *
     * @mbg.generated
     */
    List<CdDmb> selectByExample(CdDmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_CD_DMB
     *
     * @mbg.generated
     */
    CdDmb selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_CD_DMB
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CdDmb record, @Param("example") CdDmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_CD_DMB
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CdDmb record, @Param("example") CdDmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_CD_DMB
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CdDmb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_CD_DMB
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(CdDmb record);
}