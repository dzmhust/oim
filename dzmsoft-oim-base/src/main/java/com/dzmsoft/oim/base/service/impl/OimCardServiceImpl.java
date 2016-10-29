package com.dzmsoft.oim.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.oim.base.pojo.OimCard;
import com.dzmsoft.oim.base.pojo.OimCardExample;
import com.dzmsoft.oim.base.dao.OimCardMapper;
import com.dzmsoft.oim.base.service.OimCardService;
import com.dzmsoft.framework.base.util.StringUtil;
/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author 
 * @date 
 *
 * @version 
 */
@Service
@Transactional(readOnly = true)
public class OimCardServiceImpl implements OimCardService{

	@Autowired
	private OimCardMapper oimCardMapper;
	
	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 
     */
    @Override
	public int countByExample(OimCardExample example){
		return oimCardMapper.countByExample(example);
	}

	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int insertSelective(OimCard record){
				record.setId(StringUtil.getUuidString());
				return oimCardMapper.insertSelective(record);
	}
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 
     */
    @Cacheable(value="oimCardCache", key = "#id")
    @Override
	public OimCard selectByPrimaryKey(String id){
		return oimCardMapper.selectByPrimaryKey(id);
	}
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public PageList<OimCard> selectByExample(OimCardExample example,PageBounds pageBounds){
		return oimCardMapper.selectByExample(example, pageBounds);
	}
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public List<OimCard> selectByExample(OimCardExample example){
		return oimCardMapper.selectByExample(example);
	}
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @CacheEvict(value="oimCardCache",key="#record.getId()")
    @Override
	public int updateByPrimaryKeySelective(OimCard record){
		return oimCardMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @CacheEvict(value="oimCardCache",allEntries=true)
    @Override
	public int updateByExampleSelective(OimCard record,
			OimCardExample example){
		return oimCardMapper.updateByExampleSelective(record, example);
	}
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @CacheEvict(value="oimCardCache",key="#record.getId()")
    @Override
	public int deleteByPrimaryKey(String id){
		return oimCardMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 
	 * @param example
	 * @return
	 */
	@Transactional(readOnly = false)
	@CacheEvict(value="oimCardCache",allEntries=true)
	@Override
	public int deleteByExample(OimCardExample example){
		return oimCardMapper.deleteByExample(example);
	}
	
	}