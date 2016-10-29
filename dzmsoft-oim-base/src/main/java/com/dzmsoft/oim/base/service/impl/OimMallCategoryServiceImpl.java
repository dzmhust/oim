package com.dzmsoft.oim.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.oim.base.pojo.OimMallCategory;
import com.dzmsoft.oim.base.pojo.OimMallCategoryExample;
import com.dzmsoft.oim.base.dao.OimMallCategoryMapper;
import com.dzmsoft.oim.base.service.OimMallCategoryService;
/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author dzmsoft
 * @date 2016-04-26 14:26:38
 *
 * @version 1.0
 */
@Service
@Transactional(readOnly = true)
public class OimMallCategoryServiceImpl implements OimMallCategoryService{

	@Autowired
	private OimMallCategoryMapper oimMallCategoryMapper;
	
	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 2016-04-26 14:26:38
     */
    @Override
	public int countByExample(OimMallCategoryExample example){
		return oimMallCategoryMapper.countByExample(example);
	}

	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 2016-04-26 14:26:38
     */
    @Transactional(readOnly = false)
    @Override
	public int insertSelective(OimMallCategory record){
		return oimMallCategoryMapper.insertSelective(record);
	}
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 2016-04-26 14:26:38
     */
    @Override
	public OimMallCategory selectByPrimaryKey(String id){
		return oimMallCategoryMapper.selectByPrimaryKey(id);
	}
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 2016-04-26 14:26:38
     */
    @Override
	public PageList<OimMallCategory> selectByExample(OimMallCategoryExample example,PageBounds pageBounds){
		return oimMallCategoryMapper.selectByExample(example, pageBounds);
	}
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 2016-04-26 14:26:38
     */
    @Override
	public List<OimMallCategory> selectByExample(OimMallCategoryExample example){
		return oimMallCategoryMapper.selectByExample(example);
	}
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 2016-04-26 14:26:38
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByPrimaryKeySelective(OimMallCategory record){
		return oimMallCategoryMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 2016-04-26 14:26:38
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByExampleSelective(OimMallCategory record,
			OimMallCategoryExample example){
		return oimMallCategoryMapper.updateByExampleSelective(record, example);
	}
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 2016-04-26 14:26:38
     */
    @Transactional(readOnly = false)
    @Override
	public int deleteByPrimaryKey(String id){
		return oimMallCategoryMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 2016-04-26 14:26:38
	 * @param example
	 * @return
	 */
	@Transactional(readOnly = false)
	@Override
	public int deleteByExample(OimMallCategoryExample example){
		return oimMallCategoryMapper.deleteByExample(example);
	}
}