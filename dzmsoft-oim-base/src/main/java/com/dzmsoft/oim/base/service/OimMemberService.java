package com.dzmsoft.oim.base.service;

import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.oim.base.pojo.OimMember;
import com.dzmsoft.oim.base.pojo.OimMemberExample;

/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author dzmsoft
 * @date 2016-04-26 14:42:31
 *
 * @version 1.0
 */
public interface OimMemberService {
    /**
     * 更新会员头像
     * @param id
     * @return
     */
    int updateHeaderPic(String id ,String headerPic);

	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 2016-04-26 14:42:31
     */
	int countByExample(OimMemberExample example);
	
	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 2016-04-26 14:42:31
     */
	int insertSelective(OimMember record);
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 2016-04-26 14:42:31
     */
	OimMember selectByPrimaryKey(String id);
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 2016-04-26 14:42:31
     */
	PageList<OimMember> selectByExample(OimMemberExample example,PageBounds pageBounds);
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 2016-04-26 14:42:31
     */
	List<OimMember> selectByExample(OimMemberExample example);
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 2016-04-26 14:42:31
     */
	int updateByPrimaryKeySelective(OimMember record);
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 2016-04-26 14:42:31
     */
	int updateByExampleSelective(OimMember record,
			OimMemberExample example);
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 2016-04-26 14:42:31
     */
	int deleteByPrimaryKey(String id);
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 2016-04-26 14:42:31
	 * @param example
	 * @return
	 */
	int deleteByExample(OimMemberExample example);
	
	
}