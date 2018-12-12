package com.dao.core.checkmis;

import com.core.model.checkmis.WtflDmb;
import com.core.model.checkmis.WtflDmbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WtflDmbMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTFL_DMB
     *
     * @mbg.generated
     */
    long countByExample(WtflDmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTFL_DMB
     *
     * @mbg.generated
     */
    int deleteByExample(WtflDmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTFL_DMB
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTFL_DMB
     *
     * @mbg.generated
     */
    int insert(WtflDmb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTFL_DMB
     *
     * @mbg.generated
     */
    int insertSelective(WtflDmb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTFL_DMB
     *
     * @mbg.generated
     */
    List<WtflDmb> selectByExample(WtflDmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTFL_DMB
     *
     * @mbg.generated
     */
    WtflDmb selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTFL_DMB
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") WtflDmb record, @Param("example") WtflDmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTFL_DMB
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") WtflDmb record, @Param("example") WtflDmbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTFL_DMB
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(WtflDmb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_WTFL_DMB
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(WtflDmb record);
}