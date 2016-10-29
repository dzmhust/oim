package com.dzmsoft.oim.base.service;

import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.oim.base.pojo.OimSupplier;
import com.dzmsoft.oim.base.pojo.OimSupplierExample;

/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author dzmsoft
 * @date 2016-04-26 14:23:38
 *
 * @version 1.0
 */
public interface OimSupplierService {
    /**
     * 解约
     * @param id
     * @return
     */
    int release(String id);
    /**
     * 加盟
     * @param id
     * @return
     */
    int join(String id);
    /**
     * 生成编号
     * @return
     */
    String selectTopIndex();
    /**
     * 根据用户id获取供应商
     * @param ucsId
     * @return
     */
    OimSupplier selectOimSupplier(String ucsId);

	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
	int countByExample(OimSupplierExample example);
	
	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
	int insertSelective(OimSupplier record);
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
	OimSupplier selectByPrimaryKey(String id);
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
	PageList<OimSupplier> selectByExample(OimSupplierExample example,PageBounds pageBounds);
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
	List<OimSupplier> selectByExample(OimSupplierExample example);
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
	int updateByPrimaryKeySelective(OimSupplier record);
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
	int updateByExampleSelective(OimSupplier record,
			OimSupplierExample example);
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
	int deleteByPrimaryKey(String id);
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @param example
	 * @return
	 */
	int deleteByExample(OimSupplierExample example);
	
	
}