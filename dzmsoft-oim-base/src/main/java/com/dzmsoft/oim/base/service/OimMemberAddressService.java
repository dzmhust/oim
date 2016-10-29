package com.dzmsoft.oim.base.service;

import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.oim.base.pojo.OimMemberAddress;
import com.dzmsoft.oim.base.pojo.OimMemberAddressExample;

/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author dzmsoft
 * @date 2016-04-26 16:01:22
 *
 * @version 1.0
 */
public interface OimMemberAddressService {
    /**
     * 获取会员的服务地址
     * @param ucsId
     * @return
     */
    List<OimMemberAddress> selectOimMemberAddresses(String ucsId);

	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 2016-04-26 16:01:22
     */
	int countByExample(OimMemberAddressExample example);
	
	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 2016-04-26 16:01:22
     */
	int insertSelective(OimMemberAddress record);
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 2016-04-26 16:01:22
     */
	OimMemberAddress selectByPrimaryKey(String id);
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 2016-04-26 16:01:22
     */
	PageList<OimMemberAddress> selectByExample(OimMemberAddressExample example,PageBounds pageBounds);
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 2016-04-26 16:01:22
     */
	List<OimMemberAddress> selectByExample(OimMemberAddressExample example);
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 2016-04-26 16:01:22
     */
	int updateByPrimaryKeySelective(OimMemberAddress record);
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 2016-04-26 16:01:22
     */
	int updateByExampleSelective(OimMemberAddress record,
			OimMemberAddressExample example);
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 2016-04-26 16:01:22
     */
	int deleteByPrimaryKey(String id);
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 2016-04-26 16:01:22
	 * @param example
	 * @return
	 */
	int deleteByExample(OimMemberAddressExample example);
	
	
}