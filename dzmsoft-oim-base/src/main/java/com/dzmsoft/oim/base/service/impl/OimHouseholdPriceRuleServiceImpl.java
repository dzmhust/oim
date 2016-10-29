package com.dzmsoft.oim.base.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dzmsoft.framework.base.common.BaseConstant;
import com.dzmsoft.framework.base.util.CheckEmptyUtil;
import com.dzmsoft.framework.base.util.StringUtil;
import com.dzmsoft.framework.base.web.mvc.pojo.ShiroUser;
import com.dzmsoft.framework.base.web.mvc.shiro.UserUtil;
import com.dzmsoft.oim.base.dao.OimHouseholdPriceRuleMapper;
import com.dzmsoft.oim.base.dto.OperateCityDto;
import com.dzmsoft.oim.base.pojo.OimHouseholdPriceRule;
import com.dzmsoft.oim.base.pojo.OimHouseholdPriceRuleExample;
import com.dzmsoft.oim.base.service.OimHouseholdPriceRuleService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * Copyright (C), dzmsoft Co., Ltd
 * 
 * @author
 * @date
 * @version
 */
@Service
@Transactional(readOnly = true)
public class OimHouseholdPriceRuleServiceImpl implements OimHouseholdPriceRuleService {

    @Autowired
    private OimHouseholdPriceRuleMapper oimHouseholdPriceRuleMapper;

    @Transactional(readOnly = false)
    @Override
    public int setRegions(String id, List<OperateCityDto> operateCityDtos) {
        OimHouseholdPriceRule oimHouseholdPriceRule = selectByPrimaryKey(id);
        OimHouseholdPriceRule record = new OimHouseholdPriceRule();
        record.setId(id);
        StringBuilder operateRegion = new StringBuilder(
                oimHouseholdPriceRule.getOperateRegion() == null ? "" : oimHouseholdPriceRule
                        .getOperateRegion());
        if (!CheckEmptyUtil.isEmpty(operateCityDtos)) {
            OperateCityDto operateCityDto = null;
            for (int i = 0; i < operateCityDtos.size(); i++) {
                operateCityDto = operateCityDtos.get(i);
                if (operateRegion != null
                        && operateRegion.indexOf(operateCityDto.getCityName()) >= 0) {
                    continue;
                }
                if (i < operateCityDtos.size() - 1) {
                    operateRegion.append(operateCityDto.getCityName()).append(
                            BaseConstant.Separate.COMMA);
                } else {
                    operateRegion.append(operateCityDto.getCityName());
                }
            }
        }
        record.setOperateRegion(operateRegion.toString());
        return updateByPrimaryKeySelective(record);
    }

    @Override
    public OimHouseholdPriceRule selectByCityName(String cityName) {
        OimHouseholdPriceRuleExample example = new OimHouseholdPriceRuleExample();
        OimHouseholdPriceRuleExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(BaseConstant.Status.ENABLE);
        criteria.andOperateRegionLike(StringUtil.genLikeWhere(cityName));
        List<OimHouseholdPriceRule> records = selectByExample(example);
        return CheckEmptyUtil.isEmpty(records) ? null : records.get(0);
    }

    /**
     * 查询符合条件的记录数量
     * 
     * @dzmsoftgenerated
     */
    @Override
    public int countByExample(OimHouseholdPriceRuleExample example) {
        return oimHouseholdPriceRuleMapper.countByExample(example);
    }

    /**
     * 根据条件插入记录
     * 
     * @dzmsoftgenerated
     */
    @Transactional(readOnly = false)
    @Override
    public int insertSelective(OimHouseholdPriceRule record) {
        ShiroUser shiroUser = UserUtil.getCurrentShiroUser();
        record.setCreator(shiroUser.getId());
        record.setCreateTime(new Date());
        record.setStatus(BaseConstant.Status.INIT);
        return oimHouseholdPriceRuleMapper.insertSelective(record);
    }

    /**
     * 根据主键查询记录
     * 
     * @dzmsoftgenerated
     */
    @Override
    public OimHouseholdPriceRule selectByPrimaryKey(String id) {
        return oimHouseholdPriceRuleMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询记录
     * 
     * @dzmsoftgenerated
     */
    @Override
    public PageList<OimHouseholdPriceRule> selectByExample(OimHouseholdPriceRuleExample example,
            PageBounds pageBounds) {
        return oimHouseholdPriceRuleMapper.selectByExample(example, pageBounds);
    }

    /**
     * 根据条件查询记录
     * 
     * @dzmsoftgenerated
     */
    @Override
    public List<OimHouseholdPriceRule> selectByExample(OimHouseholdPriceRuleExample example) {
        return oimHouseholdPriceRuleMapper.selectByExample(example);
    }

    /**
     * 根据主键更新记录
     * 
     * @dzmsoftgenerated
     */
    @Transactional(readOnly = false)
    @Override
    public int updateByPrimaryKeySelective(OimHouseholdPriceRule record) {
        return oimHouseholdPriceRuleMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据查询条件更新记录
     * 
     * @dzmsoftgenerated
     */
    @Transactional(readOnly = false)
    @Override
    public int updateByExampleSelective(OimHouseholdPriceRule record,
            OimHouseholdPriceRuleExample example) {
        return oimHouseholdPriceRuleMapper.updateByExampleSelective(record, example);
    }

    /**
     * 根据主键生成记录
     * 
     * @dzmsoftgenerated
     */
    @Transactional(readOnly = false)
    @Override
    public int deleteByPrimaryKey(String id) {
        return oimHouseholdPriceRuleMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据条件删除字段信息
     * 
     * @dzmsoftgenerated
     * @param example
     * @return
     */
    @Transactional(readOnly = false)
    @Override
    public int deleteByExample(OimHouseholdPriceRuleExample example) {
        return oimHouseholdPriceRuleMapper.deleteByExample(example);
    }

    /**
     * 启用
     * 
     * @dzmsoftgenerated
     * @param id
     * @return
     */
    @Transactional(readOnly = false)
    @Override
    public int enable(String id) {
        return _setStatus(id, BaseConstant.Status.ENABLE);
    }

    /**
     * 设置单据状态
     * 
     * @param id
     * @param status
     * @return
     */
    private int _setStatus(String id, String status) {
        OimHouseholdPriceRule record = new OimHouseholdPriceRule();
        record.setId(id);
        record.setStatus(status);
        return updateByPrimaryKeySelective(record);
    }

    /**
     * 启用
     * 
     * @dzmsoftgenerated
     * @param id
     * @return
     */
    @Transactional(readOnly = false)
    @Override
    public int disable(String id) {
        return _setStatus(id, BaseConstant.Status.DISABLED);
    }
}