package com.dzmsoft.oim.base.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzmsoft.framework.base.util.StringUtil;
import com.dzmsoft.framework.base.web.mvc.pojo.ShiroUser;
import com.dzmsoft.framework.base.web.mvc.shiro.UserUtil;
import com.dzmsoft.oim.base.common.OimBaseConstant;
import com.dzmsoft.oim.base.dao.OimApkMapper;
import com.dzmsoft.oim.base.pojo.OimApk;
import com.dzmsoft.oim.base.pojo.OimApkExample;
import com.dzmsoft.oim.base.service.OimApkService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author dzmsoft
 * @date 2016-05-04 13:23:49
 *
 * @version 1.0
 */
@Service
@Transactional(readOnly = true)
public class OimApkServiceImpl implements OimApkService{

	@Autowired
	private OimApkMapper oimApkMapper;
	
	@Transactional(readOnly = false)
	@Override
	public int online(String id, String packageName) {
        // 将其他数据做下线处理
        OimApkExample example = new OimApkExample();
        OimApkExample.Criteria criteria = example.createCriteria();
        criteria.andIdNotEqualTo(id);
        criteria.andPackageNameEqualTo(packageName);
        criteria.andStatusEqualTo(OimBaseConstant.ApkStatus.ONLINE);
        OimApk record = new OimApk();
        record.setStatus(OimBaseConstant.ApkStatus.OFFLINE);
        updateByExampleSelective(record, example);
        // 将当前数据做上线处理
        return setStatus(id, OimBaseConstant.ApkStatus.ONLINE);
	}
	
	@Transactional(readOnly = false)
	@Override
	public int setStatus(String id, String status) {
	    OimApk record = new OimApk();
	    record.setId(id);
	    record.setStatus(status);
	    return updateByPrimaryKeySelective(record);
	}
	
	/**
     * 查询符合条件的记录数量
     * @dzmsoftgenerated 2016-05-04 13:23:49
     */
    @Override
	public int countByExample(OimApkExample example){
		return oimApkMapper.countByExample(example);
	}

	/**
     * 根据条件插入记录
     * @dzmsoftgenerated 2016-05-04 13:23:49
     */
    @Transactional(readOnly = false)
    @Override
	public int insertSelective(OimApk record){
        record.setId(StringUtil.getUuidString());
        record.setStatus(OimBaseConstant.ApkStatus.INIT);
        ShiroUser shiroUser = UserUtil.getCurrentShiroUser();
        record.setCreateTime(new Date());
        record.setCreator(shiroUser.getId());
        record.setUpdateTime(new Date());
        record.setUpdator(shiroUser.getId());
		return oimApkMapper.insertSelective(record);
	}
	
	/**
     * 根据主键查询记录
     * @dzmsoftgenerated 2016-05-04 13:23:49
     */
    @Override
	public OimApk selectByPrimaryKey(String id){
		return oimApkMapper.selectByPrimaryKey(id);
	}
	
	/**
     * 分页查询记录
     * @dzmsoftgenerated 2016-05-04 13:23:49
     */
    @Override
	public PageList<OimApk> selectByExample(OimApkExample example,PageBounds pageBounds){
		return oimApkMapper.selectByExample(example, pageBounds);
	}
	
	/**
     * 根据条件查询记录
     * @dzmsoftgenerated 2016-05-04 13:23:49
     */
    @Override
	public List<OimApk> selectByExample(OimApkExample example){
		return oimApkMapper.selectByExample(example);
	}
	
	/**
     * 根据主键更新记录
     * @dzmsoftgenerated 2016-05-04 13:23:49
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByPrimaryKeySelective(OimApk record){
        ShiroUser shiroUser = UserUtil.getCurrentShiroUser();
        record.setUpdateTime(new Date());
        record.setUpdator(shiroUser.getId());
		return oimApkMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
     * 根据查询条件更新记录
     * @dzmsoftgenerated 2016-05-04 13:23:49
     */
    @Transactional(readOnly = false)
    @Override
	public int updateByExampleSelective(OimApk record,
			OimApkExample example){
		return oimApkMapper.updateByExampleSelective(record, example);
	}
	
	/**
     * 根据主键生成记录
     * @dzmsoftgenerated 2016-05-04 13:23:49
     */
    @Transactional(readOnly = false)
    @Override
	public int deleteByPrimaryKey(String id){
		return oimApkMapper.deleteByPrimaryKey(id);
	}
	
	/**
	 * 根据条件删除字段信息
	 * @dzmsoftgenerated 2016-05-04 13:23:49
	 * @param example
	 * @return
	 */
	@Transactional(readOnly = false)
	@Override
	public int deleteByExample(OimApkExample example){
		return oimApkMapper.deleteByExample(example);
	}
}