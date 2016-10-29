package com.dzmsoft.oim.base.service;

import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.oim.base.pojo.OimMallCategory;
import com.dzmsoft.oim.base.pojo.OimMallCategoryExample;

/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author dzmsoft
 * @date 2016-04-26 14:26:38
 *
 * @version 1.0
 */
public interface OimMallCategoryService {

	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 2016-04-26 14:26:38
     */
	int countByExample(OimMallCategoryExample example);
	
	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 2016-04-26 14:26:38
     */
	int insertSelective(OimMallCategory record);
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 2016-04-26 14:26:38
     */
	OimMallCategory selectByPrimaryKey(String id);
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 2016-04-26 14:26:38
     */
	PageList<OimMallCategory> selectByExample(OimMallCategoryExample example,PageBounds pageBounds);
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 2016-04-26 14:26:38
     */
	List<OimMallCategory> selectByExample(OimMallCategoryExample example);
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 2016-04-26 14:26:38
     */
	int updateByPrimaryKeySelective(OimMallCategory record);
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 2016-04-26 14:26:38
     */
	int updateByExampleSelective(OimMallCategory record,
			OimMallCategoryExample example);
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 2016-04-26 14:26:38
     */
	int deleteByPrimaryKey(String id);
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 2016-04-26 14:26:38
	 * @param example
	 * @return
	 */
	int deleteByExample(OimMallCategoryExample example);
	
	
}