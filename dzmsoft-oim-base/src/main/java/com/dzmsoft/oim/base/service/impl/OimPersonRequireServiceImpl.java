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
import com.dzmsoft.oim.base.dao.OimPersonRequireMapper;
import com.dzmsoft.oim.base.dto.OperateCityDto;
import com.dzmsoft.oim.base.pojo.OimPersonRequire;
import com.dzmsoft.oim.base.pojo.OimPersonRequireExample;
import com.dzmsoft.oim.base.pojo.OimPersonRequireLine;
import com.dzmsoft.oim.base.service.OimPersonRequireLineService;
import com.dzmsoft.oim.base.service.OimPersonRequireService;
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
public class OimPersonRequireServiceImpl implements OimPersonRequireService {

    @Autowired
    private OimPersonRequireMapper oimPersonRequireMapper;

    @Autowired
    private OimPersonRequireLineService oimPersonRequireLineService;
    
    @Transactional(readOnly = false)
    @Override
    public int setRegions(String id, List<OperateCityDto> operateCityDtos) {
        OimPersonRequire oimPersonRequire = selectByPrimaryKey(id);
        OimPersonRequire record = new OimPersonRequire();
        record.setId(id);
        StringBuilder operateRegion  = new StringBuilder(oimPersonRequire.getOperateRegion()==null?"":oimPersonRequire.getOperateRegion());
        if (!CheckEmptyUtil.isEmpty(operateCityDtos)){
            OperateCityDto operateCityDto = null;
            for (int i=0; i<operateCityDtos.size(); i++){
                operateCityDto = operateCityDtos.get(i);
                if (operateRegion!=null && operateRegion.indexOf(operateCityDto.getCityName())>=0){
                    continue;
                }
                if (i < operateCityDtos.size()-1){
                    operateRegion.append(operateCityDto.getCityName()).append(BaseConstant.Separate.COMMA);
                } else{
                    operateRegion.append(operateCityDto.getCityName());
                }
            }
        }
        record.setOperateRegion(operateRegion.toString());
        return updateByPrimaryKeySelective(record);
    }
    
    @Override
    public OimPersonRequire selectByCityName(String cityName) {
        OimPersonRequireExample example = new OimPersonRequireExample();
        OimPersonRequireExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(BaseConstant.Status.ENABLE);
        criteria.andOperateRegionLike(StringUtil.genLikeWhere(cityName));
        List<OimPersonRequire> records = selectByExample(example);
        return CheckEmptyUtil.isEmpty(records)?null:records.get(0); 
    }

    /**
     * 根据条件插入包含明细数据
     * 
     * @dzmsoftgenerated
     */
    @Transactional(readOnly = false)
    @Override
    public int insertContainDetails(OimPersonRequire record,
            List<OimPersonRequireLine> oimPersonRequireLine) {
        int flag = -1;
        // 保存头部信息
        flag = insertSelective(record);
        // 保存明细信息
        saveOimPersonRequireLine(record, oimPersonRequireLine);
        return flag;
    }

    private void saveOimPersonRequireLine(OimPersonRequire record,
            List<OimPersonRequireLine> oimPersonRequireLine) {
        if (!CheckEmptyUtil.isEmpty(oimPersonRequireLine)) {
            // 保存方案明细
            for (OimPersonRequireLine detail : oimPersonRequireLine) {
                detail.setRequireId(record.getId());
                oimPersonRequireLineService.insertSelective(detail);
            }
        }
    }

    /**
     * 根据条件更新包含明细数据
     * 
     * @dzmsoftgenerated
     */
    @Transactional(readOnly = false)
    @Override
    public int updateContainDetails(OimPersonRequire record,
            List<OimPersonRequireLine> oimPersonRequireLine) {

        // 先删掉明细数据
        oimPersonRequireLineService.deleteByMain(record.getId());
        // 保存明细信息
        saveOimPersonRequireLine(record, oimPersonRequireLine);
        // 保存头部信息
        return updateByPrimaryKeySelective(record);
    }

    /**
     * 查询符合条件的记录数量
     * 
     * @dzmsoftgenerated
     */
    @Override
    public int countByExample(OimPersonRequireExample example) {
        return oimPersonRequireMapper.countByExample(example);
    }

    /**
     * 根据条件插入记录
     * 
     * @dzmsoftgenerated
     */
    @Transactional(readOnly = false)
    @Override
    public int insertSelective(OimPersonRequire record) {
        record.setId(StringUtil.getUuidString());
        ShiroUser shiroUser = UserUtil.getCurrentShiroUser();
        record.setCreator(shiroUser.getId());
        record.setCreateTime(new Date());
        record.setStatus(BaseConstant.Status.DISABLED);
        return oimPersonRequireMapper.insertSelective(record);
    }

    /**
     * 根据主键查询记录
     * 
     * @dzmsoftgenerated
     */
    @Override
    public OimPersonRequire selectByPrimaryKey(String id) {
        return oimPersonRequireMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询记录
     * 
     * @dzmsoftgenerated
     */
    @Override
    public PageList<OimPersonRequire> selectByExample(OimPersonRequireExample example,
            PageBounds pageBounds) {
        return oimPersonRequireMapper.selectByExample(example, pageBounds);
    }

    /**
     * 根据条件查询记录
     * 
     * @dzmsoftgenerated
     */
    @Override
    public List<OimPersonRequire> selectByExample(OimPersonRequireExample example) {
        return oimPersonRequireMapper.selectByExample(example);
    }

    /**
     * 根据主键更新记录
     * 
     * @dzmsoftgenerated
     */
    @Transactional(readOnly = false)
    @Override
    public int updateByPrimaryKeySelective(OimPersonRequire record) {
        return oimPersonRequireMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据查询条件更新记录
     * 
     * @dzmsoftgenerated
     */
    @Transactional(readOnly = false)
    @Override
    public int updateByExampleSelective(OimPersonRequire record, OimPersonRequireExample example) {
        return oimPersonRequireMapper.updateByExampleSelective(record, example);
    }

    /**
     * 根据主键生成记录
     * 
     * @dzmsoftgenerated
     */
    @Transactional(readOnly = false)
    @Override
    public int deleteByPrimaryKey(String id) {
        return oimPersonRequireMapper.deleteByPrimaryKey(id);
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
    public int deleteByExample(OimPersonRequireExample example) {
        return oimPersonRequireMapper.deleteByExample(example);
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
        OimPersonRequire record = new OimPersonRequire();
        record.setId(id);
        record.setStatus(BaseConstant.Status.ENABLE);
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
        OimPersonRequire record = new OimPersonRequire();
        record.setId(id);
        record.setStatus(BaseConstant.Status.DISABLED);
        return updateByPrimaryKeySelective(record);
    }

    /**
     * 获取所有的启用数据
     * 
     * @dzmsoftgenerated
     * @return
     */
    public List<OimPersonRequire> selectEnables() {
        OimPersonRequireExample example = new OimPersonRequireExample();
        OimPersonRequireExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(BaseConstant.Status.ENABLE);
        return selectByExample(example);
    }

    public OimPersonRequire selectEnableOne() {
        List<OimPersonRequire> records = selectEnables();
        return CheckEmptyUtil.isEmpty(records) ? null : records.get(0);
    }
}