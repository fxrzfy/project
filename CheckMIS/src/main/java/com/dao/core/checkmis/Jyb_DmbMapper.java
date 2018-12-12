package com.dao.core.checkmis;

import com.core.model.checkmis.Jyb_Dmb;
import com.core.model.checkmis.Jyb_DmbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Jyb_DmbMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_JYB_DMB
     *
     * @mbg.generated
     */
    long countByExample(Jyb_DmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_JYB_DMB
     *
     * @mbg.generated
     */
    int deleteByExample(Jyb_DmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_JYB_DMB
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_JYB_DMB
     *
     * @mbg.generated
     */
    int insert(Jyb_Dmb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_JYB_DMB
     *
     * @mbg.generated
     */
    int insertSelective(Jyb_Dmb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_JYB_DMB
     *
     * @mbg.generated
     */
    List<Jyb_Dmb> selectByExample(Jyb_DmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_JYB_DMB
     *
     * @mbg.generated
     */
    Jyb_Dmb selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_JYB_DMB
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Jyb_Dmb record, @Param("example") Jyb_DmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_JYB_DMB
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Jyb_Dmb record, @Param("example") Jyb_DmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_JYB_DMB
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Jyb_Dmb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_JYB_DMB
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Jyb_Dmb record);
}