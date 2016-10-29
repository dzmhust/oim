package com.dzmsoft.oim.base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzmsoft.acs.inner.service.UcsService;
import com.dzmsoft.oim.base.common.OimBaseConstant;
import com.dzmsoft.oim.base.dao.OimEmployeeMapper;
import com.dzmsoft.oim.base.pojo.OimEmployee;
import com.dzmsoft.oim.base.pojo.OimEmployeeExample;
import com.dzmsoft.oim.base.service.OimEmployeeService;
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
public class OimEmployeeServiceImpl implements OimEmployeeService{

	@Autowired
	private OimEmployeeMapper oimEmployeeMapper;
	@Autowired
    private UcsService ucsService;
	
	@Override
	public String selectTopIndex() {
	    OimEmployeeExample example = new OimEmployeeExample();
	    return oimEmployeeMapper.selectTopIndex(example);
	}
	
	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
    @Override
	public int countByExample(OimEmployeeExample example){
		return oimEmployeeMapper.countByExample(example);
	}

	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
    @Transactional(readOnly = false)
    @Override
	public int insertSelective(OimEmployee record){
        String id = selectTopIndex() ;
        record.setId(id);
        record.setStatus(OimBaseConstant.EmployeeStatus.IN_JOB);
		return oimEmployeeMapper.insertSelective(record);
	}
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
    @Override
	public OimEmployee selectByPrimaryKey(String id){
		return oimEmployeeMapper.selectByPrimaryKey(id);
	}
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
    @Override
	public PageList<OimEmployee> selectByExample(OimEmployeeExample example,PageBounds pageBounds){
		return oimEmployeeMapper.selectByExample(example, pageBounds);
	}
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
    @Override
	public List<OimEmployee> selectByExample(OimEmployeeExample example){
		return oimEmployeeMapper.selectByExample(example);
	}
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByPrimaryKeySelective(OimEmployee record){
        if (!record.getUserType().equals(record.getUserType())){
            // 改变用户类型时，需要修改用户中心中的角色、权限
            ucsService.changeUserType(record.getMobile(), record.getUserType(), record.getUserType());
        }
		return oimEmployeeMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByExampleSelective(OimEmployee record,
			OimEmployeeExample example){
		return oimEmployeeMapper.updateByExampleSelective(record, example);
	}
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
    @Transactional(readOnly = false)
    @Override
	public int deleteByPrimaryKey(String id){
		return oimEmployeeMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @param example
	 * @return
	 */
	@Transactional(readOnly = false)
	@Override
	public int deleteByExample(OimEmployeeExample example){
		return oimEmployeeMapper.deleteByExample(example);
	}
}