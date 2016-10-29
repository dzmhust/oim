package com.dzmsoft.oim.base.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzmsoft.framework.base.common.BaseConstant;
import com.dzmsoft.framework.base.util.CheckEmptyUtil;
import com.dzmsoft.framework.base.web.mvc.pojo.ShiroUser;
import com.dzmsoft.framework.base.web.mvc.shiro.UserUtil;
import com.dzmsoft.oim.base.dao.OimAdArticleMapper;
import com.dzmsoft.oim.base.pojo.OimAdArticle;
import com.dzmsoft.oim.base.pojo.OimAdArticleExample;
import com.dzmsoft.oim.base.service.OimAdArticleService;
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
public class OimAdArticleServiceImpl implements OimAdArticleService{

	@Autowired
	private OimAdArticleMapper oimAdArticleMapper;
	
	@Transactional(readOnly = false)
    @Override
    @CacheEvict(value="adArticleCache",allEntries=true)
	public int deploy(String id) {
	    OimAdArticle oimAdArticle = new OimAdArticle();
        oimAdArticle.setId(id);
        oimAdArticle.setStatus(BaseConstant.Status.ENABLE);
        oimAdArticle.setDeployTime(new Date());
        return updateByPrimaryKeySelective(oimAdArticle);
	}
	
	@Transactional(readOnly = false)
    @Override
    @CacheEvict(value="adArticleCache",allEntries=true)
	public int setStatus(String id, String status) {
	    OimAdArticle oimAdArticle = new OimAdArticle();
	    oimAdArticle.setId(id);
	    oimAdArticle.setStatus(status);
	    return updateByPrimaryKeySelective(oimAdArticle);
	}
	
	@Cacheable(value="adArticleCache", key = "#position")
	@Override
	public OimAdArticle selectOimAdArticle(String position) {
	    List<OimAdArticle> oimAdArticles = selectOimAdArticles(position);
	    return CheckEmptyUtil.isEmpty(oimAdArticles)?null:oimAdArticles.get(0);
	}
	
	@Cacheable(value="adArticleCache", key = "#position")
	@Override
	public List<OimAdArticle> selectOimAdArticles(String position) {
	    OimAdArticleExample example = new OimAdArticleExample();
	    OimAdArticleExample.Criteria criteria = example.createCriteria();
	    criteria.andPositionEqualTo(position);
	    return selectByExample(example);
	}
	
	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
    @Override
	public int countByExample(OimAdArticleExample example){
		return oimAdArticleMapper.countByExample(example);
	}

	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
    @Transactional(readOnly = false)
    @Override
    @CacheEvict(value="adArticleCache",allEntries=true)
	public int insertSelective(OimAdArticle record){
        ShiroUser shioUser = UserUtil.getCurrentShiroUser();
        record.setCreateTime(new Date());
        record.setCreator(shioUser.getId());
		return oimAdArticleMapper.insertSelective(record);
	}
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
    @Override
	public OimAdArticle selectByPrimaryKey(String id){
		return oimAdArticleMapper.selectByPrimaryKey(id);
	}
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
    @Override
	public PageList<OimAdArticle> selectByExample(OimAdArticleExample example,PageBounds pageBounds){
		return oimAdArticleMapper.selectByExample(example, pageBounds);
	}
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
    @Override
	public List<OimAdArticle> selectByExample(OimAdArticleExample example){
		return oimAdArticleMapper.selectByExample(example);
	}
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
    @Transactional(readOnly = false)
    @Override
    @CacheEvict(value="adArticleCache",allEntries=true)
	public int updateByPrimaryKeySelective(OimAdArticle record){
        ShiroUser shioUser = UserUtil.getCurrentShiroUser();
        record.setUpdateTime(new Date());
        record.setUpdator(shioUser.getId());
		return oimAdArticleMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
    @Transactional(readOnly = false)
    @Override
    @CacheEvict(value="adArticleCache",allEntries=true)
	public int updateByExampleSelective(OimAdArticle record,
			OimAdArticleExample example){
        ShiroUser shioUser = UserUtil.getCurrentShiroUser();
        record.setUpdateTime(new Date());
        record.setUpdator(shioUser.getId());
		return oimAdArticleMapper.updateByExampleSelective(record, example);
	}
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 2016-04-26 14:23:38
     */
    @Transactional(readOnly = false)
    @Override
    @CacheEvict(value="adArticleCache",allEntries=true)
	public int deleteByPrimaryKey(String id){
		return oimAdArticleMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @param example
	 * @return
	 */
	@Transactional(readOnly = false)
	@Override
	@CacheEvict(value="adArticleCache",allEntries=true)
	public int deleteByExample(OimAdArticleExample example){
		return oimAdArticleMapper.deleteByExample(example);
	}
}