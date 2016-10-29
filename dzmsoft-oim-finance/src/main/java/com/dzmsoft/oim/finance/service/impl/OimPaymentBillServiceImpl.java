package com.dzmsoft.oim.finance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.dzmsoft.oim.finance.pojo.OimPaymentBill;
import com.dzmsoft.oim.finance.pojo.OimPaymentBillExample;
import com.dzmsoft.oim.finance.dao.OimPaymentBillMapper;
import com.dzmsoft.oim.finance.service.OimPaymentBillService;
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
public class OimPaymentBillServiceImpl implements OimPaymentBillService{

	@Autowired
	private OimPaymentBillMapper oimPaymentBillMapper;
	
		
	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 
     */
    @Override
	public int countByExample(OimPaymentBillExample example){
		return oimPaymentBillMapper.countByExample(example);
	}

	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int insertSelective(OimPaymentBill record){
				record.setId(StringUtil.getUuidString());
				return oimPaymentBillMapper.insertSelective(record);
	}
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public OimPaymentBill selectByPrimaryKey(String id){
		return oimPaymentBillMapper.selectByPrimaryKey(id);
	}
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public PageList<OimPaymentBill> selectByExample(OimPaymentBillExample example,PageBounds pageBounds){
		return oimPaymentBillMapper.selectByExample(example, pageBounds);
	}
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 
     */
    @Override
	public List<OimPaymentBill> selectByExample(OimPaymentBillExample example){
		return oimPaymentBillMapper.selectByExample(example);
	}
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByPrimaryKeySelective(OimPaymentBill record){
		return oimPaymentBillMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByExampleSelective(OimPaymentBill record,
			OimPaymentBillExample example){
		return oimPaymentBillMapper.updateByExampleSelective(record, example);
	}
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 
     */
    @Transactional(readOnly = false)
    @Override
	public int deleteByPrimaryKey(String id){
		return oimPaymentBillMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 
	 * @param example
	 * @return
	 */
	@Transactional(readOnly = false)
	@Override
	public int deleteByExample(OimPaymentBillExample example){
		return oimPaymentBillMapper.deleteByExample(example);
	}
	
	}