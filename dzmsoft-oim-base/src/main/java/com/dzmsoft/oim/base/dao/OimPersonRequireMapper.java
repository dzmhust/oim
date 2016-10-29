package com.dzmsoft.oim.base.dao;

import com.dzmsoft.oim.base.pojo.OimPersonRequire;
import com.dzmsoft.oim.base.pojo.OimPersonRequireExample;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OimPersonRequireMapper {
    public PageList<OimPersonRequire> selectByExample(OimPersonRequireExample example,PageBounds pageBounds);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_person_require
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int countByExample(OimPersonRequireExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_person_require
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int deleteByExample(OimPersonRequireExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_person_require
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_person_require
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int insert(OimPersonRequire record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_person_require
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int insertSelective(OimPersonRequire record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_person_require
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    List<OimPersonRequire> selectByExample(OimPersonRequireExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_person_require
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    OimPersonRequire selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_person_require
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int updateByExampleSelective(@Param("record") OimPersonRequire record, @Param("example") OimPersonRequireExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_person_require
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int updateByExample(@Param("record") OimPersonRequire record, @Param("example") OimPersonRequireExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_person_require
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int updateByPrimaryKeySelective(OimPersonRequire record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_person_require
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int updateByPrimaryKey(OimPersonRequire record);
}