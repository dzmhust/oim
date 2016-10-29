package com.dzmsoft.oim.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.oim.base.pojo.OimAdminRegion;
import com.dzmsoft.oim.base.pojo.OimAdminRegionExample;
import com.dzmsoft.oim.base.dao.OimAdminRegionMapper;
import com.dzmsoft.oim.base.dto.OperateCityDto;
import com.dzmsoft.oim.base.service.OimAdminRegionService;
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
public class OimAdminRegionServiceImpl implements OimAdminRegionService{

	@Autowired
	private OimAdminRegionMapper oimAdminRegionMapper;
	
	@Override
	public List<OperateCityDto> selectOperateCityDto() {
	    return oimAdminRegionMapper.selectOperateCityDto();
	}
	
	@Override
	public PageList<OperateCityDto> selectOperateCityDto(PageBounds pageBounds) {
	    return oimAdminRegionMapper.selectOperateCityDto(pageBounds);
	}
	
	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 
     */
    @Override
	public int countByExample(OimAdminRegionExample example){
		return oimAdminRegionMapper.countByExample(example);
	}

	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int insertSelective(OimAdminRegion record){
				record.setId(StringUtil.getUuidString());
				return oimAdminRegionMapper.insertSelective(record);
	}
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public OimAdminRegion selectByPrimaryKey(String id){
		return oimAdminRegionMapper.selectByPrimaryKey(id);
	}
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public PageList<OimAdminRegion> selectByExample(OimAdminRegionExample example,PageBounds pageBounds){
		return oimAdminRegionMapper.selectByExample(example, pageBounds);
	}
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public List<OimAdminRegion> selectByExample(OimAdminRegionExample example){
		return oimAdminRegionMapper.selectByExample(example);
	}
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByPrimaryKeySelective(OimAdminRegion record){
		return oimAdminRegionMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByExampleSelective(OimAdminRegion record,
			OimAdminRegionExample example){
		return oimAdminRegionMapper.updateByExampleSelective(record, example);
	}
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int deleteByPrimaryKey(String id){
		return oimAdminRegionMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 
	 * @param example
	 * @return
	 */
	@Transactional(readOnly = false)
	@Override
	public int deleteByExample(OimAdminRegionExample example){
		return oimAdminRegionMapper.deleteByExample(example);
	}
	
	}