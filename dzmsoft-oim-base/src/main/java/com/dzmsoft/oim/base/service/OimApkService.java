package com.dzmsoft.oim.base.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.oim.base.pojo.OimApk;
import com.dzmsoft.oim.base.pojo.OimApkExample;

/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author dzmsoft
 * @date 2016-05-04 13:23:49
 *
 * @version 1.0
 */
public interface OimApkService {
    /**
     * 设置状态
     * @param id
     * @param status
     * @return
     */
    public int setStatus(String id, String status) ;
    /**
     * 对应用进行上线
     * @param id
     * @return
     */
    int online(String id, String packageName);

	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 2016-05-04 13:23:49
     */
	int countByExample(OimApkExample example);
	
	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 2016-05-04 13:23:49
     */
	int insertSelective(OimApk record);
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 2016-05-04 13:23:49
     */
	OimApk selectByPrimaryKey(String id);
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 2016-05-04 13:23:49
     */
	PageList<OimApk> selectByExample(OimApkExample example,PageBounds pageBounds);
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 2016-05-04 13:23:49
     */
	List<OimApk> selectByExample(OimApkExample example);
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 2016-05-04 13:23:49
     */
	int updateByPrimaryKeySelective(OimApk record);
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 2016-05-04 13:23:49
     */
	int updateByExampleSelective(OimApk record,
			OimApkExample example);
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 2016-05-04 13:23:49
     */
	int deleteByPrimaryKey(String id);
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 2016-05-04 13:23:49
	 * @param example
	 * @return
	 */
	int deleteByExample(OimApkExample example);
	
	
}