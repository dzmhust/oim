package com.dzmsoft.oim.base.dao;

import com.dzmsoft.oim.base.pojo.OimCleanBagLine;
import com.dzmsoft.oim.base.pojo.OimCleanBagLineExample;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OimCleanBagLineMapper {
    public PageList<OimCleanBagLine> selectByExample(OimCleanBagLineExample example,PageBounds pageBounds);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_clean_bag_line
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int countByExample(OimCleanBagLineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_clean_bag_line
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int deleteByExample(OimCleanBagLineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_clean_bag_line
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_clean_bag_line
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int insert(OimCleanBagLine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_clean_bag_line
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int insertSelective(OimCleanBagLine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_clean_bag_line
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    List<OimCleanBagLine> selectByExample(OimCleanBagLineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_clean_bag_line
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    OimCleanBagLine selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_clean_bag_line
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int updateByExampleSelective(@Param("record") OimCleanBagLine record, @Param("example") OimCleanBagLineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_clean_bag_line
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int updateByExample(@Param("record") OimCleanBagLine record, @Param("example") OimCleanBagLineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_clean_bag_line
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int updateByPrimaryKeySelective(OimCleanBagLine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oim_clean_bag_line
     *
     * @mbggenerated Tue Jun 28 13:16:00 CST 2016
     */
    int updateByPrimaryKey(OimCleanBagLine record);
}