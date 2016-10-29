package com.dzmsoft.oim.base.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzmsoft.framework.base.web.mvc.controller.BaseController;
import com.dzmsoft.framework.base.web.mvc.dao.MybatisExample;
import com.dzmsoft.framework.base.web.mvc.view.BaseResponse;
import com.dzmsoft.framework.base.web.mvc.view.Condition;
import com.dzmsoft.framework.base.web.mvc.pojo.EasyUIPage;
import com.dzmsoft.oim.base.dto.OperateCityDto;
import com.dzmsoft.oim.base.pojo.OimHouseholdPriceRule;
import com.dzmsoft.oim.base.pojo.OimHouseholdPriceRuleExample;
import com.dzmsoft.oim.base.service.OimHouseholdPriceRuleService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.dzmsoft.framework.base.web.mvc.view.GenericResponse;
import com.dzmsoft.framework.base.util.StringUtil;

/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author 
 * @dzmsoftgenerated 
 *
 * @version 
 */
@Controller
@RequestMapping("oimHouseholdPriceRule")
public class OimHouseholdPriceRuleController extends BaseController{
	@Autowired
	private OimHouseholdPriceRuleService oimHouseholdPriceRuleService;
	@Autowired
	private Gson gson;

	/**
	 * 显示主列表页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimHouseholdPriceRule:find")
	@RequestMapping(value = "show", method = RequestMethod.GET)
	public String show(){
		return "modules/base/oimHouseholdPriceRuleList";
	}
	
	@RequiresPermissions("oimHouseholdPriceRule:setRegion")
    @RequestMapping(value = "showRegionDialog", method = RequestMethod.GET)
    public String showRegionDialog(){
        return "modules/base/operateCityDialog";
    }
	
	/**
     * 设置区域
     * @param id
     * @param operateCity
     * @return
     */
    @RequiresPermissions("oimHouseholdPriceRule:setRegion")
    @RequestMapping(value = "setRegions", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse setRegions(String id, String operateCity){
        operateCity = StringUtil.unescapeHtml(operateCity);
        List<OperateCityDto> operateCityDtos = gson.fromJson(operateCity, new TypeToken<List<OperateCityDto>>() {}.getType());
        int flag = oimHouseholdPriceRuleService.setRegions(id, operateCityDtos);
        BaseResponse baseResponse = flag > 0 ? new BaseResponse(true, "设置区域成功") : new BaseResponse(false, "设置区域失败");
        return baseResponse;
    }
	
	/**
	 * 主列表中查询
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimHouseholdPriceRule:find")
	@RequestMapping(value = "find", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> find(HttpServletRequest request){
		List<Condition> conditions = Condition.buildFromHttpRequest(request);
		EasyUIPage easyUIPage = new EasyUIPage(request);
		MybatisExample mybatisExample = MybatisExample.getInstance();
		OimHouseholdPriceRuleExample example = (OimHouseholdPriceRuleExample)mybatisExample.buildExampleByCondition(conditions, easyUIPage, OimHouseholdPriceRuleExample.class.getName());
		PageList<OimHouseholdPriceRule> oimHouseholdPriceRules = oimHouseholdPriceRuleService.selectByExample(example, new PageBounds(easyUIPage.getPage(),
                easyUIPage.getRows()));
		return getEasyUIGrid(oimHouseholdPriceRules);
	}
	
	/**
	 * 跳转到新增页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimHouseholdPriceRule:add")
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addForm(Model model){
		OimHouseholdPriceRule oimHouseholdPriceRule = new OimHouseholdPriceRule();
				oimHouseholdPriceRule.setId(StringUtil.getUuidString());
				model.addAttribute("oimHouseholdPriceRule", oimHouseholdPriceRule);
		model.addAttribute("action", "add");
		return "modules/base/oimHouseholdPriceRuleForm";
	}
	
		/**
	 * 新增记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimHouseholdPriceRule:add")
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse<String> add(OimHouseholdPriceRule oimHouseholdPriceRule){
	    oimHouseholdPriceRule.setDetail(StringUtil.unescapeHtml(oimHouseholdPriceRule.getDetail()));
		int flag = oimHouseholdPriceRuleService.insertSelective(oimHouseholdPriceRule);
		GenericResponse<String> genericResponse = null;
		if (flag > 0){
		    genericResponse = new GenericResponse<String>(true,"新增成功");
		    genericResponse.setData("edit");
		} else{
		    genericResponse = new GenericResponse<String>(true,"新增失败");
		}
		return genericResponse;
	}
		
	/**
	 * 跳转到编辑页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimHouseholdPriceRule:edit")
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") String id,Model model){
		OimHouseholdPriceRule oimHouseholdPriceRule = oimHouseholdPriceRuleService.selectByPrimaryKey(id);
		oimHouseholdPriceRule.setDetail(StringUtil.escapeHtml(oimHouseholdPriceRule.getDetail()));
		model.addAttribute("oimHouseholdPriceRule", oimHouseholdPriceRule);
		model.addAttribute("action", "edit");
		return "modules/base/oimHouseholdPriceRuleForm";
	}
	
	/**
	 * 跳转到查看页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimHouseholdPriceRule:view")
	@RequestMapping(value = "view/{id}", method = RequestMethod.GET)
	public String viewForm(@PathVariable("id") String id,Model model){
		OimHouseholdPriceRule oimHouseholdPriceRule = oimHouseholdPriceRuleService.selectByPrimaryKey(id);
		oimHouseholdPriceRule.setDetail(StringUtil.escapeHtml(oimHouseholdPriceRule.getDetail()));
		model.addAttribute("oimHouseholdPriceRule", oimHouseholdPriceRule);
		model.addAttribute("action", "view");
		return "modules/base/oimHouseholdPriceRuleForm";
	}
	
		/**
	 * 编辑记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimHouseholdPriceRule:edit")
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse<String> edit(OimHouseholdPriceRule oimHouseholdPriceRule){
	    oimHouseholdPriceRule.setDetail(StringUtil.unescapeHtml(oimHouseholdPriceRule.getDetail()));
		int flag = oimHouseholdPriceRuleService.updateByPrimaryKeySelective(oimHouseholdPriceRule);
		GenericResponse<String> genericResponse = null;
		if (flag > 0){
            genericResponse = new GenericResponse<String>(true,"编辑成功");
            genericResponse.setData("edit");
        } else{
            genericResponse = new GenericResponse<String>(true,"编辑失败");
        }
		return genericResponse;
	}
		
	/**
	 * 删除记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimHouseholdPriceRule:remove")
	@RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse remove(@PathVariable("id") String id){
		int flag = oimHouseholdPriceRuleService.deleteByPrimaryKey(id);
		BaseResponse baseResponse = flag>=0?new BaseResponse(true,"删除成功"):new BaseResponse(false, "删除失败");
		return baseResponse;
	}
	
		@RequiresPermissions("oimHouseholdPriceRule:enable")
	@RequestMapping(value = "enable/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public BaseResponse enable(@PathVariable("id") String id){
		int flag = oimHouseholdPriceRuleService.enable(id);
		BaseResponse baseResponse = flag>=0?new BaseResponse(true,"启用成功"):new BaseResponse(false, "启用失败");
		return baseResponse;
	}
	
	@RequiresPermissions("oimHouseholdPriceRule:disable")
	@RequestMapping(value = "disable/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public BaseResponse disable(@PathVariable("id") String id){
		int flag = oimHouseholdPriceRuleService.disable(id);
		BaseResponse baseResponse = flag>=0?new BaseResponse(true,"禁用成功"):new BaseResponse(false, "禁用失败");
		return baseResponse;
	}
	}
