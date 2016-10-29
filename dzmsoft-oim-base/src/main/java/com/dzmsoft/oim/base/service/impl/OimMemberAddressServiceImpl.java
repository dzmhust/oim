package com.dzmsoft.oim.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzmsoft.framework.base.util.StringUtil;
import com.dzmsoft.oim.base.dao.OimMemberAddressMapper;
import com.dzmsoft.oim.base.pojo.OimMemberAddress;
import com.dzmsoft.oim.base.pojo.OimMemberAddressExample;
import com.dzmsoft.oim.base.service.OimMemberAddressService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author dzmsoft
 * @date 2016-04-26 16:01:23
 *
 * @version 1.0
 */
@Service
@Transactional(readOnly = true)
public class OimMemberAddressServiceImpl implements OimMemberAddressService{

	@Autowired
	private OimMemberAddressMapper oimMemberAddressMapper;
	
	@Override
	@Cacheable(value="oimMemberAddressCache", key = "#ucsId")
	public List<OimMemberAddress> selectOimMemberAddresses(String ucsId) {
	    OimMemberAddressExample example = new OimMemberAddressExample();
	    OimMemberAddressExample.Criteria criteria = example.createCriteria();
	    criteria.andUcsIdEqualTo(ucsId);
	    return selectByExample(example);
	}
	
	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 2016-04-26 16:01:23
     */
    @Override
	public int countByExample(OimMemberAddressExample example){
		return oimMemberAddressMapper.countByExample(example);
	}

	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 2016-04-26 16:01:23
     */
    @Transactional(readOnly = false)
    @Override
    @CacheEvict(value="oimMemberAddressCache",allEntries=true)
	public int insertSelective(OimMemberAddress record){
        record.setId(StringUtil.getUuidString());
		return oimMemberAddressMapper.insertSelective(record);
	}
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 2016-04-26 16:01:23
     */
    @Override
	public OimMemberAddress selectByPrimaryKey(String id){
		return oimMemberAddressMapper.selectByPrimaryKey(id);
	}
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 2016-04-26 16:01:23
     */
    @Override
	public PageList<OimMemberAddress> selectByExample(OimMemberAddressExample example,PageBounds pageBounds){
		return oimMemberAddressMapper.selectByExample(example, pageBounds);
	}
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 2016-04-26 16:01:23
     */
    @Override
	public List<OimMemberAddress> selectByExample(OimMemberAddressExample example){
		return oimMemberAddressMapper.selectByExample(example);
	}
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 2016-04-26 16:01:23
     */
    @Transactional(readOnly = false)
    @Override
    @CacheEvict(value="oimMemberAddressCache",allEntries=true)
	public int updateByPrimaryKeySelective(OimMemberAddress record){
		return oimMemberAddressMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 2016-04-26 16:01:23
     */
    @Transactional(readOnly = false)
    @Override
    @CacheEvict(value="oimMemberAddressCache",allEntries=true)
	public int updateByExampleSelective(OimMemberAddress record,
			OimMemberAddressExample example){
		return oimMemberAddressMapper.updateByExampleSelective(record, example);
	}
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 2016-04-26 16:01:23
     */
    @Transactional(readOnly = false)
    @Override
    @CacheEvict(value="oimMemberAddressCache",allEntries=true)
	public int deleteByPrimaryKey(String id){
		return oimMemberAddressMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 2016-04-26 16:01:23
	 * @param example
	 * @return
	 */
	@Transactional(readOnly = false)
	@Override
	@CacheEvict(value="oimMemberAddressCache",allEntries=true)
	public int deleteByExample(OimMemberAddressExample example){
		return oimMemberAddressMapper.deleteByExample(example);
	}
}