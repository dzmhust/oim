package com.dzmsoft.oim.base.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzmsoft.oim.base.dao.OimMemberMapper;
import com.dzmsoft.oim.base.pojo.OimMember;
import com.dzmsoft.oim.base.pojo.OimMemberExample;
import com.dzmsoft.oim.base.service.OimMemberService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author dzmsoft
 * @date 2016-04-26 14:42:31
 *
 * @version 1.0
 */
@Service
@Transactional(readOnly = true)
public class OimMemberServiceImpl implements OimMemberService{

	@Autowired
	private OimMemberMapper oimMemberMapper;
	
	@Transactional(readOnly = false)
	@Override
	public int updateHeaderPic(String id, String headerPic) {
	    OimMember record = new OimMember();
	    record.setId(id);
	    record.setHeaderPic(headerPic);
	    return updateByPrimaryKeySelective(record);
	}
	
	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 2016-04-26 14:42:31
     */
    @Override
	public int countByExample(OimMemberExample example){
		return oimMemberMapper.countByExample(example);
	}

	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 2016-04-26 14:42:31
     */
    @Transactional(readOnly = false)
    @Override
	public int insertSelective(OimMember record){
        record.setId(record.getUcsId());
        record.setCreateTime(new Date());
		return oimMemberMapper.insertSelective(record);
	}
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 2016-04-26 14:42:31
     */
    @Override
	public OimMember selectByPrimaryKey(String id){
		return oimMemberMapper.selectByPrimaryKey(id);
	}
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 2016-04-26 14:42:31
     */
    @Override
	public PageList<OimMember> selectByExample(OimMemberExample example,PageBounds pageBounds){
		return oimMemberMapper.selectByExample(example, pageBounds);
	}
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 2016-04-26 14:42:31
     */
    @Override
	public List<OimMember> selectByExample(OimMemberExample example){
		return oimMemberMapper.selectByExample(example);
	}
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 2016-04-26 14:42:31
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByPrimaryKeySelective(OimMember record){
		return oimMemberMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 2016-04-26 14:42:31
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByExampleSelective(OimMember record,
			OimMemberExample example){
		return oimMemberMapper.updateByExampleSelective(record, example);
	}
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 2016-04-26 14:42:31
     */
    @Transactional(readOnly = false)
    @Override
	public int deleteByPrimaryKey(String id){
		return oimMemberMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 2016-04-26 14:42:31
	 * @param example
	 * @return
	 */
	@Transactional(readOnly = false)
	@Override
	public int deleteByExample(OimMemberExample example){
		return oimMemberMapper.deleteByExample(example);
	}
}