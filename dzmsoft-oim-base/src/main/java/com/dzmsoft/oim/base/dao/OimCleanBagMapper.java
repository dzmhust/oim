package com.dzmsoft.oim.base.dao;

import com.dzmsoft.oim.base.pojo.OimCleanBag;
import com.dzmsoft.oim.base.pojo.OimCleanBagExample;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OimCleanBagMapper {
    public PageList<OimCleanBag> selectByExample(OimCleanBagExample example,PageBounds pageBounds);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_clean_bag
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int countByExample(OimCleanBagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_clean_bag
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int deleteByExample(OimCleanBagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_clean_bag
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_clean_bag
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int insert(OimCleanBag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_clean_bag
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int insertSelective(OimCleanBag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_clean_bag
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    List<OimCleanBag> selectByExample(OimCleanBagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_clean_bag
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    OimCleanBag selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_clean_bag
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int updateByExampleSelective(@Param("record") OimCleanBag record, @Param("example") OimCleanBagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_clean_bag
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int updateByExample(@Param("record") OimCleanBag record, @Param("example") OimCleanBagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_clean_bag
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int updateByPrimaryKeySelective(OimCleanBag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_clean_bag
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int updateByPrimaryKey(OimCleanBag record);
}