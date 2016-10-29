package com.dzmsoft.oim.base.service;

import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.oim.base.pojo.OimAdArticle;
import com.dzmsoft.oim.base.pojo.OimAdArticleExample;

/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author dzmsoft
 * @date 2016-04-26 14:23:38
 *
 * @version 1.0
 */
public interface OimAdArticleService {
    /**
     * 发布
     * @param id
     * @return
     */
    int deploy(String id);
    /**
     * 设置广告状态
     * @param id
     * @param status
     * @return
     */
    int setStatus(String id ,String status);
    /**
     * 根据位置选择广告
     * @param position
     * @return
     */
    OimAdArticle selectOimAdArticle(String position);
    /**
     * 根据位置获取广告
     * @param position
     * @return
     */
    List<OimAdArticle> selectOimAdArticles(String position);

	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
	int countByExample(OimAdArticleExample example);
	
	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
	int insertSelective(OimAdArticle record);
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
	OimAdArticle selectByPrimaryKey(String id);
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
	PageList<OimAdArticle> selectByExample(OimAdArticleExample example,PageBounds pageBounds);
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
	List<OimAdArticle> selectByExample(OimAdArticleExample example);
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
	int updateByPrimaryKeySelective(OimAdArticle record);
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
	int updateByExampleSelective(OimAdArticle record,
			OimAdArticleExample example);
	
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
	int deleteByExample(OimAdArticleExample example);
	
	
}