package com.dao.core.checkmis;

import com.core.model.checkmis.WtxdDmb;
import com.core.model.checkmis.WtxdDmbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WtxdDmbMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTXD_DMB
     *
     * @mbg.generated
     */
    long countByExample(WtxdDmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTXD_DMB
     *
     * @mbg.generated
     */
    int deleteByExample(WtxdDmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTXD_DMB
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTXD_DMB
     *
     * @mbg.generated
     */
    int insert(WtxdDmb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTXD_DMB
     *
     * @mbg.generated
     */
    int insertSelective(WtxdDmb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTXD_DMB
     *
     * @mbg.generated
     */
    List<WtxdDmb> selectByExample(WtxdDmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTXD_DMB
     *
     * @mbg.generated
     */
    WtxdDmb selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTXD_DMB
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") WtxdDmb record, @Param("example") WtxdDmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTXD_DMB
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") WtxdDmb record, @Param("example") WtxdDmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTXD_DMB
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(WtxdDmb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTXD_DMB
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(WtxdDmb record);
}