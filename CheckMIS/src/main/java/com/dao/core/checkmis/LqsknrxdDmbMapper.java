package com.dao.core.checkmis;

import com.core.model.checkmis.LqsknrxdDmb;
import com.core.model.checkmis.LqsknrxdDmbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LqsknrxdDmbMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_LQSKNRXD_DMB
     *
     * @mbg.generated
     */
    long countByExample(LqsknrxdDmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_LQSKNRXD_DMB
     *
     * @mbg.generated
     */
    int deleteByExample(LqsknrxdDmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_LQSKNRXD_DMB
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_LQSKNRXD_DMB
     *
     * @mbg.generated
     */
    int insert(LqsknrxdDmb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_LQSKNRXD_DMB
     *
     * @mbg.generated
     */
    int insertSelective(LqsknrxdDmb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_LQSKNRXD_DMB
     *
     * @mbg.generated
     */
    List<LqsknrxdDmb> selectByExample(LqsknrxdDmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_LQSKNRXD_DMB
     *
     * @mbg.generated
     */
    LqsknrxdDmb selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_LQSKNRXD_DMB
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LqsknrxdDmb record, @Param("example") LqsknrxdDmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_LQSKNRXD_DMB
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LqsknrxdDmb record, @Param("example") LqsknrxdDmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_LQSKNRXD_DMB
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LqsknrxdDmb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_LQSKNRXD_DMB
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LqsknrxdDmb record);
}