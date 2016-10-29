package com.dzmsoft.oim.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzmsoft.framework.base.util.CheckEmptyUtil;
import com.dzmsoft.oim.base.common.OimBaseConstant;
import com.dzmsoft.oim.base.dao.OimSupplierMapper;
import com.dzmsoft.oim.base.pojo.OimSupplier;
import com.dzmsoft.oim.base.pojo.OimSupplierExample;
import com.dzmsoft.oim.base.service.OimSupplierService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author dzmsoft
 * @date 2016-04-26 14:23:38
 *
 * @version 1.0
 */
@Service
@Transactional(readOnly = true)
public class OimSupplierServiceImpl implements OimSupplierService{

    @Autowired
	private OimSupplierMapper oimSupplierMapper;
	
    @Transactional(readOnly = false)
    @Override
    @CacheEvict(value="oimSupplierCache",allEntries=true)
	public int release(String id) {
        return setStatus(id, OimBaseConstant.PartnerStatus.RELEASE);
	}
	
    @Transactional(readOnly = false)
    @Override
    @CacheEvict(value="oimSupplierCache",allEntries=true)
	public int join(String id) {
	    return setStatus(id, OimBaseConstant.PartnerStatus.JOIN);
	}
    
    private int setStatus(String id ,String status){
        OimSupplier oimSupplier = new OimSupplier();
        oimSupplier.setId(id);
        oimSupplier.setStatus(status);
        return updateByPrimaryKeySelective(oimSupplier);
    }
    
    
	
	@Override
	public String selectTopIndex() {
	    OimSupplierExample example = new OimSupplierExample();
	    return oimSupplierMapper.selectTopIndex(example);
	}
	
	@Cacheable(value="oimSupplierCache", key = "#ucsId")
	@Override
	public OimSupplier selectOimSupplier(String ucsId) {
	    OimSupplierExample example = new OimSupplierExample();
	    OimSupplierExample.Criteria criteria = example.createCriteria();
	    criteria.andUcsIdEqualTo(ucsId);
	    List<OimSupplier> oimSuppliers = selectByExample(example);
	    return CheckEmptyUtil.isEmpty(oimSuppliers)?null:oimSuppliers.get(0);
	}
	
	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
    @Override
	public int countByExample(OimSupplierExample example){
		return oimSupplierMapper.countByExample(example);
	}

	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
    @Transactional(readOnly = false)
    @Override
    @CacheEvict(value="oimSupplierCache",allEntries=true)
	public int insertSelective(OimSupplier record){
        String id = selectTopIndex();
        record.setId(id);
		return oimSupplierMapper.insertSelective(record);
	}
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
    @Override
	public OimSupplier selectByPrimaryKey(String id){
		return oimSupplierMapper.selectByPrimaryKey(id);
	}
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
    @Override
	public PageList<OimSupplier> selectByExample(OimSupplierExample example,PageBounds pageBounds){
		return oimSupplierMapper.selectByExample(example, pageBounds);
	}
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
    @Override
	public List<OimSupplier> selectByExample(OimSupplierExample example){
		return oimSupplierMapper.selectByExample(example);
	}
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
    @Transactional(readOnly = false)
    @Override
    @CacheEvict(value="oimSupplierCache",allEntries=true)
	public int updateByPrimaryKeySelective(OimSupplier record){
		return oimSupplierMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
    @Transactional(readOnly = false)
    @Override
    @CacheEvict(value="oimSupplierCache",allEntries=true)
	public int updateByExampleSelective(OimSupplier record,
			OimSupplierExample example){
		return oimSupplierMapper.updateByExampleSelective(record, example);
	}
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
    @Transactional(readOnly = false)
    @Override
    @CacheEvict(value="oimSupplierCache",allEntries=true)
	public int deleteByPrimaryKey(String id){
		return oimSupplierMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @param example
	 * @return
	 */
	@Transactional(readOnly = false)
	@Override
	@CacheEvict(value="oimSupplierCache",allEntries=true)
	public int deleteByExample(OimSupplierExample example){
		return oimSupplierMapper.deleteByExample(example);
	}
}