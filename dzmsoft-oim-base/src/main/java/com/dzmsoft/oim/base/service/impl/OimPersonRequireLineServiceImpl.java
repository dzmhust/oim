package com.dzmsoft.oim.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzmsoft.framework.base.common.BaseConstant;
import com.dzmsoft.framework.base.util.StringUtil;
import com.dzmsoft.oim.base.dao.OimPersonRequireLineMapper;
import com.dzmsoft.oim.base.pojo.OimPersonRequireLine;
import com.dzmsoft.oim.base.pojo.OimPersonRequireLineExample;
import com.dzmsoft.oim.base.service.OimPersonRequireLineService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author 
 * @date 
 *
 * @version 
 */
@Service
@Transactional(readOnly = true)
public class OimPersonRequireLineServiceImpl implements OimPersonRequireLineService{

	@Autowired
	private OimPersonRequireLineMapper oimPersonRequireLineMapper;
	
		/**
     * 根据订单头id，删除订单明细
     * @dzmsoftgenerated 
     */
	@Override
	public List<OimPersonRequireLine> selectByMain(String mainId) {
	    OimPersonRequireLineExample example = new OimPersonRequireLineExample();
	    OimPersonRequireLineExample.Criteria criteria = example.createCriteria();
	    	    criteria.andRequireIdEqualTo(mainId);
	    return selectByExample(example);
	}
	
	/**
     * 根据订单头id，删除订单明细
     * @dzmsoftgenerated 
     */
	@Override
	public int deleteByMain(String mainId) {
	    OimPersonRequireLineExample example = new OimPersonRequireLineExample();
	    OimPersonRequireLineExample.Criteria criteria = example.createCriteria();
	    	    criteria.andRequireIdEqualTo(mainId);
	    return deleteByExample(example);
	}
		
	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 
     */
    @Override
	public int countByExample(OimPersonRequireLineExample example){
		return oimPersonRequireLineMapper.countByExample(example);
	}

	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int insertSelective(OimPersonRequireLine record){
				record.setId(StringUtil.getUuidString());
				return oimPersonRequireLineMapper.insertSelective(record);
	}
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public OimPersonRequireLine selectByPrimaryKey(String id){
		return oimPersonRequireLineMapper.selectByPrimaryKey(id);
	}
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public PageList<OimPersonRequireLine> selectByExample(OimPersonRequireLineExample example,PageBounds pageBounds){
		return oimPersonRequireLineMapper.selectByExample(example, pageBounds);
	}
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public List<OimPersonRequireLine> selectByExample(OimPersonRequireLineExample example){
		return oimPersonRequireLineMapper.selectByExample(example);
	}
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByPrimaryKeySelective(OimPersonRequireLine record){
		return oimPersonRequireLineMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByExampleSelective(OimPersonRequireLine record,
			OimPersonRequireLineExample example){
		return oimPersonRequireLineMapper.updateByExampleSelective(record, example);
	}
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int deleteByPrimaryKey(String id){
		return oimPersonRequireLineMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 
	 * @param example
	 * @return
	 */
	@Transactional(readOnly = false)
	@Override
	public int deleteByExample(OimPersonRequireLineExample example){
		return oimPersonRequireLineMapper.deleteByExample(example);
	}
	
		/**
	 * 启用
	 * @dzmsoftgenerated 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = false)
	@Override
	public int enable(String id){
		return _setStatus(id, BaseConstant.Status.ENABLE);
	}
	
	 /**
     * 设置单据状态
     * @param id
     * @param status
     * @return
     */
    private int _setStatus(String id, String status){
        OimPersonRequireLine record = new OimPersonRequireLine();
        record.setId(id);
        return updateByPrimaryKeySelective(record);
    }
	
	/**
	 * 启用
	 * @dzmsoftgenerated 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = false)
	@Override
	public int disable(String id){
		return _setStatus(id, BaseConstant.Status.DISABLED);
	}
	}