package com.dzmsoft.oim.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.oim.base.pojo.OimAdPosition;
import com.dzmsoft.oim.base.pojo.OimAdPositionExample;
import com.dzmsoft.oim.base.dao.OimAdPositionMapper;
import com.dzmsoft.oim.base.service.OimAdPositionService;
/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author dzmsoft
 * @date 2016-04-26 14:26:38
 *
 * @version 1.0
 */
@Service
@Transactional(readOnly = true)
public class OimAdPositionServiceImpl implements OimAdPositionService{

	@Autowired
	private OimAdPositionMapper oimAdPositionMapper;
	
	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 2016-04-26 14:26:38
     */
    @Override
	public int countByExample(OimAdPositionExample example){
		return oimAdPositionMapper.countByExample(example);
	}

	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 2016-04-26 14:26:38
     */
    @Transactional(readOnly = false)
    @Override
	public int insertSelective(OimAdPosition record){
		return oimAdPositionMapper.insertSelective(record);
	}
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 2016-04-26 14:26:38
     */
    @Override
	public OimAdPosition selectByPrimaryKey(String id){
		return oimAdPositionMapper.selectByPrimaryKey(id);
	}
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 2016-04-26 14:26:38
     */
    @Override
	public PageList<OimAdPosition> selectByExample(OimAdPositionExample example,PageBounds pageBounds){
		return oimAdPositionMapper.selectByExample(example, pageBounds);
	}
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 2016-04-26 14:26:38
     */
    @Override
	public List<OimAdPosition> selectByExample(OimAdPositionExample example){
		return oimAdPositionMapper.selectByExample(example);
	}
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 2016-04-26 14:26:38
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByPrimaryKeySelective(OimAdPosition record){
		return oimAdPositionMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 2016-04-26 14:26:38
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByExampleSelective(OimAdPosition record,
			OimAdPositionExample example){
		return oimAdPositionMapper.updateByExampleSelective(record, example);
	}
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 2016-04-26 14:26:38
     */
    @Transactional(readOnly = false)
    @Override
	public int deleteByPrimaryKey(String id){
		return oimAdPositionMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 2016-04-26 14:26:38
	 * @param example
	 * @return
	 */
	@Transactional(readOnly = false)
	@Override
	public int deleteByExample(OimAdPositionExample example){
		return oimAdPositionMapper.deleteByExample(example);
	}
}