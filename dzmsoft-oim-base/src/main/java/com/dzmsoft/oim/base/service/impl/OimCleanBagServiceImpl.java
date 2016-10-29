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
import com.dzmsoft.oim.base.dao.OimCleanBagMapper;
import com.dzmsoft.oim.base.dto.OperateCityDto;
import com.dzmsoft.oim.base.pojo.OimCleanBag;
import com.dzmsoft.oim.base.pojo.OimCleanBagExample;
import com.dzmsoft.oim.base.pojo.OimCleanBagLine;
import com.dzmsoft.oim.base.service.OimCleanBagLineService;
import com.dzmsoft.oim.base.service.OimCleanBagService;
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
public class OimCleanBagServiceImpl implements OimCleanBagService {

    @Autowired
    private OimCleanBagMapper oimCleanBagMapper;

    @Autowired
    private OimCleanBagLineService oimCleanBagLineService;
    
    @Transactional(readOnly = false)
    @Override
    public int setRegions(String id, List<OperateCityDto> operateCityDtos) {
        OimCleanBag oimCleanBag = selectByPrimaryKey(id);
        OimCleanBag record = new OimCleanBag();
        record.setId(id);
        StringBuilder operateRegion  = new StringBuilder(oimCleanBag.getOperateRegion()==null?"":oimCleanBag.getOperateRegion());
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
    public OimCleanBag selectByCityName(String cityName) {
        OimCleanBagExample example = new OimCleanBagExample();
        OimCleanBagExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(BaseConstant.Status.ENABLE);
        criteria.andOperateRegionLike(StringUtil.genLikeWhere(cityName));
        List<OimCleanBag> records = selectByExample(example);
        return CheckEmptyUtil.isEmpty(records)?null:records.get(0); 
    }

    /**
     * 根据条件插入包含明细数据
     * 
     * @dzmsoftgenerated
     */
    @Transactional(readOnly = false)
    @Override
    public int insertContainDetails(OimCleanBag record, List<OimCleanBagLine> oimCleanBagLine) {
        int flag = -1;
        // 保存头部信息
        flag = insertSelective(record);
        // 保存明细信息
        saveOimCleanBagLine(record, oimCleanBagLine);
        return flag;
    }

    private void saveOimCleanBagLine(OimCleanBag record, List<OimCleanBagLine> oimCleanBagLine) {
        if (!CheckEmptyUtil.isEmpty(oimCleanBagLine)) {
            // 保存方案明细
            for (OimCleanBagLine detail : oimCleanBagLine) {
                detail.setCleanBagId(record.getId());
                oimCleanBagLineService.insertSelective(detail);
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
    public int updateContainDetails(OimCleanBag record, List<OimCleanBagLine> oimCleanBagLine) {

        // 先删掉明细数据
        oimCleanBagLineService.deleteByMain(record.getId());
        // 保存明细信息
        saveOimCleanBagLine(record, oimCleanBagLine);
        // 保存头部信息
        return updateByPrimaryKeySelective(record);
    }

    /**
     * 查询符合条件的记录数量
     * 
     * @dzmsoftgenerated
     */
    @Override
    public int countByExample(OimCleanBagExample example) {
        return oimCleanBagMapper.countByExample(example);
    }

    /**
     * 根据条件插入记录
     * 
     * @dzmsoftgenerated
     */
    @Transactional(readOnly = false)
    @Override
    public int insertSelective(OimCleanBag record) {
        record.setId(StringUtil.getUuidString());
        ShiroUser shiroUser = UserUtil.getCurrentShiroUser();
        record.setCreator(shiroUser.getId());
        record.setCreateTime(new Date());
        record.setStatus(BaseConstant.Status.DISABLED);
        return oimCleanBagMapper.insertSelective(record);
    }

    /**
     * 根据主键查询记录
     * 
     * @dzmsoftgenerated
     */
    @Override
    public OimCleanBag selectByPrimaryKey(String id) {
        return oimCleanBagMapper.selectByPrimaryKey(id);
    }

    /**
     * 分页查询记录
     * 
     * @dzmsoftgenerated
     */
    @Override
    public PageList<OimCleanBag> selectByExample(OimCleanBagExample example, PageBounds pageBounds) {
        return oimCleanBagMapper.selectByExample(example, pageBounds);
    }

    /**
     * 根据条件查询记录
     * 
     * @dzmsoftgenerated
     */
    @Override
    public List<OimCleanBag> selectByExample(OimCleanBagExample example) {
        return oimCleanBagMapper.selectByExample(example);
    }

    /**
     * 根据主键更新记录
     * 
     * @dzmsoftgenerated
     */
    @Transactional(readOnly = false)
    @Override
    public int updateByPrimaryKeySelective(OimCleanBag record) {
        return oimCleanBagMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 根据查询条件更新记录
     * 
     * @dzmsoftgenerated
     */
    @Transactional(readOnly = false)
    @Override
    public int updateByExampleSelective(OimCleanBag record, OimCleanBagExample example) {
        return oimCleanBagMapper.updateByExampleSelective(record, example);
    }

    /**
     * 根据主键生成记录
     * 
     * @dzmsoftgenerated
     */
    @Transactional(readOnly = false)
    @Override
    public int deleteByPrimaryKey(String id) {
        return oimCleanBagMapper.deleteByPrimaryKey(id);
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
    public int deleteByExample(OimCleanBagExample example) {
        return oimCleanBagMapper.deleteByExample(example);
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
        OimCleanBag record = new OimCleanBag();
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
        OimCleanBag record = new OimCleanBag();
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
    public List<OimCleanBag> selectEnables() {
        OimCleanBagExample example = new OimCleanBagExample();
        OimCleanBagExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(BaseConstant.Status.ENABLE);
        return selectByExample(example);
    }

    public OimCleanBag selectEnableOne() {
        List<OimCleanBag> records = selectEnables();
        return CheckEmptyUtil.isEmpty(records) ? null : records.get(0);
    }
}