package com.dao.core.checkmis;

import com.core.model.checkmis.RwbhGzb;
import com.core.model.checkmis.RwbhGzbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RwbhGzbMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_RWBH_GZB
     *
     * @mbg.generated
     */
    long countByExample(RwbhGzbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_RWBH_GZB
     *
     * @mbg.generated
     */
    int deleteByExample(RwbhGzbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_RWBH_GZB
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_RWBH_GZB
     *
     * @mbg.generated
     */
    int insert(RwbhGzb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_RWBH_GZB
     *
     * @mbg.generated
     */
    int insertSelective(RwbhGzb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_RWBH_GZB
     *
     * @mbg.generated
     */
    List<RwbhGzb> selectByExample(RwbhGzbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_RWBH_GZB
     *
     * @mbg.generated
     */
    RwbhGzb selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_RWBH_GZB
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") RwbhGzb record, @Param("example") RwbhGzbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_RWBH_GZB
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") RwbhGzb record, @Param("example") RwbhGzbExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_RWBH_GZB
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(RwbhGzb record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.ST_RWBH_GZB
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(RwbhGzb record);
}