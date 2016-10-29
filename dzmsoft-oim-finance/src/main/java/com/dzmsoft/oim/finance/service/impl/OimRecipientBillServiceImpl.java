package com.dzmsoft.oim.finance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.oim.finance.pojo.OimRecipientBill;
import com.dzmsoft.oim.finance.pojo.OimRecipientBillExample;
import com.dzmsoft.oim.finance.dao.OimRecipientBillMapper;
import com.dzmsoft.oim.finance.service.OimRecipientBillService;
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
public class OimRecipientBillServiceImpl implements OimRecipientBillService{

	@Autowired
	private OimRecipientBillMapper oimRecipientBillMapper;
	
		
	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 
     */
    @Override
	public int countByExample(OimRecipientBillExample example){
		return oimRecipientBillMapper.countByExample(example);
	}

	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int insertSelective(OimRecipientBill record){
				record.setId(StringUtil.getUuidString());
				return oimRecipientBillMapper.insertSelective(record);
	}
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public OimRecipientBill selectByPrimaryKey(String id){
		return oimRecipientBillMapper.selectByPrimaryKey(id);
	}
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public PageList<OimRecipientBill> selectByExample(OimRecipientBillExample example,PageBounds pageBounds){
		return oimRecipientBillMapper.selectByExample(example, pageBounds);
	}
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public List<OimRecipientBill> selectByExample(OimRecipientBillExample example){
		return oimRecipientBillMapper.selectByExample(example);
	}
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByPrimaryKeySelective(OimRecipientBill record){
		return oimRecipientBillMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByExampleSelective(OimRecipientBill record,
			OimRecipientBillExample example){
		return oimRecipientBillMapper.updateByExampleSelective(record, example);
	}
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int deleteByPrimaryKey(String id){
		return oimRecipientBillMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 
	 * @param example
	 * @return
	 */
	@Transactional(readOnly = false)
	@Override
	public int deleteByExample(OimRecipientBillExample example){
		return oimRecipientBillMapper.deleteByExample(example);
	}
	
	}