package com.dzmsoft.oim.base.service;

import java.util.List;

import com.dzmsoft.oim.base.dto.OperateCityDto;
import com.dzmsoft.oim.base.pojo.OimPersonRequire;
import com.dzmsoft.oim.base.pojo.OimPersonRequireExample;
import com.dzmsoft.oim.base.pojo.OimPersonRequireLine;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author 
 * @date 
 *
 * @version 
 */
public interface OimPersonRequireService {
    /**
     * 设置运营区域
     * @param id
     * @param operateCityDtos
     * @return
     */
    int setRegions(String id, List<OperateCityDto> operateCityDtos);

    /**
     * 根据城市名称获取规则
     * @param cityName
     * @return
     */
    OimPersonRequire selectByCityName(String cityName);

	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 
     */
	int countByExample(OimPersonRequireExample example);
	
	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 
     */
	int insertSelective(OimPersonRequire record);
	
	/**
     * 根据条件插入包含明细数据
     * @dzmsoftgenerated 
     */
	int insertContainDetails(OimPersonRequire record
			,List<OimPersonRequireLine> oimPersonRequireLine
		);
	
	/**
     * 根据条件更新包含明细数据
     * @dzmsoftgenerated 
     */
	int updateContainDetails(OimPersonRequire record
			,List<OimPersonRequireLine> oimPersonRequireLine
		);
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 
     */
	OimPersonRequire selectByPrimaryKey(String id);
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 
     */
	PageList<OimPersonRequire> selectByExample(OimPersonRequireExample example,PageBounds pageBounds);
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 
     */
	List<OimPersonRequire> selectByExample(OimPersonRequireExample example);
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 
     */
	int updateByPrimaryKeySelective(OimPersonRequire record);
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 
     */
	int updateByExampleSelective(OimPersonRequire record,
			OimPersonRequireExample example);
	
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
	int deleteByExample(OimPersonRequireExample example);
	
		/**
	 * 启用
	 * @dzmsoftgenerated 
	 * @param id
	 * @return
	 */
	int enable(String id);
	
	/**
	 * 启用
	 * @dzmsoftgenerated 
	 * @param id
	 * @return
	 */
	int disable(String id);
	
	/**
	 * 获取所有的启用数据
	 * @dzmsoftgenerated 
	 * @return
	 */
	List<OimPersonRequire> selectEnables();
	
	/**
	 * 获取一个启用数据
	 * @dzmsoftgenerated 
	 * @return
	 */
	OimPersonRequire selectEnableOne();
	}