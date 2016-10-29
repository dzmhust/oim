package com.dzmsoft.oim.base.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.oim.base.dto.OperateCityDto;
import com.dzmsoft.oim.base.pojo.OimAdminRegion;
import com.dzmsoft.oim.base.pojo.OimAdminRegionExample;

/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author 
 * @date 
 *
 * @version 
 */
public interface OimAdminRegionService {
    
    /**
     * 根据供应商，获取运营城市
     * @return
     */
    List<OperateCityDto> selectOperateCityDto();
    /**
     * 分页查询运营城市
     * @param pageBounds
     * @return
     */
    PageList<OperateCityDto> selectOperateCityDto(PageBounds pageBounds);

	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 
     */
	int countByExample(OimAdminRegionExample example);
	
	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 
     */
	int insertSelective(OimAdminRegion record);
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 
     */
	OimAdminRegion selectByPrimaryKey(String id);
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 
     */
	PageList<OimAdminRegion> selectByExample(OimAdminRegionExample example,PageBounds pageBounds);
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 
     */
	List<OimAdminRegion> selectByExample(OimAdminRegionExample example);
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 
     */
	int updateByPrimaryKeySelective(OimAdminRegion record);
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 
     */
	int updateByExampleSelective(OimAdminRegion record,
			OimAdminRegionExample example);
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 
     */
	int deleteByPrimaryKey(String id);
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 
	 * @param example
	 * @return
	 */
	int deleteByExample(OimAdminRegionExample example);
	
		
	
}