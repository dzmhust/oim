package com.dzmsoft.oim.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.oim.base.pojo.OimCleanBagLine;
import com.dzmsoft.oim.base.pojo.OimCleanBagLineExample;
import com.dzmsoft.oim.base.dao.OimCleanBagLineMapper;
import com.dzmsoft.oim.base.service.OimCleanBagLineService;
import com.dzmsoft.framework.base.util.StringUtil;
import com.dzmsoft.framework.base.common.BaseConstant;
/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author 
 * @date 
 *
 * @version 
 */
@Service
@Transactional(readOnly = true)
public class OimCleanBagLineServiceImpl implements OimCleanBagLineService{

	@Autowired
	private OimCleanBagLineMapper oimCleanBagLineMapper;
	
		/**
     * 根据订单头id，删除订单明细
     * @dzmsoftgenerated 
     */
	@Override
	public List<OimCleanBagLine> selectByMain(String mainId) {
	    OimCleanBagLineExample example = new OimCleanBagLineExample();
	    OimCleanBagLineExample.Criteria criteria = example.createCriteria();
	    	    criteria.andCleanBagIdEqualTo(mainId);
	    return selectByExample(example);
	}
	
	/**
     * 根据订单头id，删除订单明细
     * @dzmsoftgenerated 
     */
	@Override
	public int deleteByMain(String mainId) {
	    OimCleanBagLineExample example = new OimCleanBagLineExample();
	    OimCleanBagLineExample.Criteria criteria = example.createCriteria();
	    	    criteria.andCleanBagIdEqualTo(mainId);
	    return deleteByExample(example);
	}
		
	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 
     */
    @Override
	public int countByExample(OimCleanBagLineExample example){
		return oimCleanBagLineMapper.countByExample(example);
	}

	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int insertSelective(OimCleanBagLine record){
				record.setId(StringUtil.getUuidString());
				return oimCleanBagLineMapper.insertSelective(record);
	}
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public OimCleanBagLine selectByPrimaryKey(String id){
		return oimCleanBagLineMapper.selectByPrimaryKey(id);
	}
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public PageList<OimCleanBagLine> selectByExample(OimCleanBagLineExample example,PageBounds pageBounds){
		return oimCleanBagLineMapper.selectByExample(example, pageBounds);
	}
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public List<OimCleanBagLine> selectByExample(OimCleanBagLineExample example){
		return oimCleanBagLineMapper.selectByExample(example);
	}
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByPrimaryKeySelective(OimCleanBagLine record){
		return oimCleanBagLineMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByExampleSelective(OimCleanBagLine record,
			OimCleanBagLineExample example){
		return oimCleanBagLineMapper.updateByExampleSelective(record, example);
	}
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int deleteByPrimaryKey(String id){
		return oimCleanBagLineMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 
	 * @param example
	 * @return
	 */
	@Transactional(readOnly = false)
	@Override
	public int deleteByExample(OimCleanBagLineExample example){
		return oimCleanBagLineMapper.deleteByExample(example);
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
        OimCleanBagLine record = new OimCleanBagLine();
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