package com.dzmsoft.oim.base.service;

import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.oim.base.pojo.OimCleanBagLine;
import com.dzmsoft.oim.base.pojo.OimCleanBagLineExample;

/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author 
 * @date 
 *
 * @version 
 */
public interface OimCleanBagLineService {
		/**
     * 根据订单头id，查询订单明细
     * @dzmsoftgenerated 
     */
	List<OimCleanBagLine> selectByMain(String mainId);
	
	/**
     * 根据订单头id，删除订单明细
     * @dzmsoftgenerated 
     */
	int deleteByMain(String mainId);
	
	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 
     */
	int countByExample(OimCleanBagLineExample example);
	
	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 
     */
	int insertSelective(OimCleanBagLine record);
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 
     */
	OimCleanBagLine selectByPrimaryKey(String id);
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 
     */
	PageList<OimCleanBagLine> selectByExample(OimCleanBagLineExample example,PageBounds pageBounds);
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 
     */
	List<OimCleanBagLine> selectByExample(OimCleanBagLineExample example);
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 
     */
	int updateByPrimaryKeySelective(OimCleanBagLine record);
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 
     */
	int updateByExampleSelective(OimCleanBagLine record,
			OimCleanBagLineExample example);
	
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
	int deleteByExample(OimCleanBagLineExample example);
	
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
		
	
}