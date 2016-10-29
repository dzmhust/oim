package com.dzmsoft.oim.base.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.oim.base.dto.OperateCityDto;
import com.dzmsoft.oim.base.pojo.OimCleanBag;
import com.dzmsoft.oim.base.pojo.OimCleanBagExample;
import com.dzmsoft.oim.base.pojo.OimCleanBagLine;

/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author 
 * @date 
 *
 * @version 
 */
public interface OimCleanBagService {
    /**
     * 设置运营区域
     * @param id
     * @param operateCityDtos
     * @return
     */
    int setRegions(String id, List<OperateCityDto> operateCityDtos);
    /**
     * 根据城市名称，定位清洁包
     * @param cityName
     * @return
     */
	OimCleanBag selectByCityName(String cityName);

	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 
     */
	int countByExample(OimCleanBagExample example);
	
	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 
     */
	int insertSelective(OimCleanBag record);
	
	/**
     * 根据条件插入包含明细数据
     * @dzmsoftgenerated 
     */
	int insertContainDetails(OimCleanBag record
			,List<OimCleanBagLine> oimCleanBagLine
		);
	
	/**
     * 根据条件更新包含明细数据
     * @dzmsoftgenerated 
     */
	int updateContainDetails(OimCleanBag record
			,List<OimCleanBagLine> oimCleanBagLine
		);
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 
     */
	OimCleanBag selectByPrimaryKey(String id);
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 
     */
	PageList<OimCleanBag> selectByExample(OimCleanBagExample example,PageBounds pageBounds);
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 
     */
	List<OimCleanBag> selectByExample(OimCleanBagExample example);
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 
     */
	int updateByPrimaryKeySelective(OimCleanBag record);
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 
     */
	int updateByExampleSelective(OimCleanBag record,
			OimCleanBagExample example);
	
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
	int deleteByExample(OimCleanBagExample example);
	
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
	List<OimCleanBag> selectEnables();
	
	/**
	 * 获取一个启用数据
	 * @dzmsoftgenerated 
	 * @return
	 */
	OimCleanBag selectEnableOne();
	}