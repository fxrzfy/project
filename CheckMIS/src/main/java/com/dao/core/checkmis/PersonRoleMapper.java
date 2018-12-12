package com.dao.core.checkmis;

import com.core.model.checkmis.PersonRole;
import com.core.model.checkmis.PersonRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PersonRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.SYS_PERSON_ROLE
     *
     * @mbg.generated
     */
    long countByExample(PersonRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.SYS_PERSON_ROLE
     *
     * @mbg.generated
     */
    int deleteByExample(PersonRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.SYS_PERSON_ROLE
     *
     * @mbg.generated
     */
    int insert(PersonRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.SYS_PERSON_ROLE
     *
     * @mbg.generated
     */
    int insertSelective(PersonRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.SYS_PERSON_ROLE
     *
     * @mbg.generated
     */
    List<PersonRole> selectByExample(PersonRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.SYS_PERSON_ROLE
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") PersonRole record, @Param("example") PersonRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table CHECKMIS.SYS_PERSON_ROLE
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") PersonRole record, @Param("example") PersonRoleExample example);
}