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
import com.dzmsoft.oim.base.pojo.OimAdminRegion;
import com.dzmsoft.oim.base.pojo.OimAdminRegionExample;
import com.dzmsoft.oim.base.service.OimAdminRegionService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author 
 * @dzmsoftgenerated 
 *
 * @version 
 */
@Controller
@RequestMapping("oimAdminRegion")
public class OimAdminRegionController extends BaseController{
	@Autowired
	private OimAdminRegionService oimAdminRegionService;

	/**
	 * 显示主列表页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimAdminRegion:find")
	@RequestMapping(value = "show", method = RequestMethod.GET)
	public String show(){
		return "modules/base/oimAdminRegionList";
	}
	
	/**
	 * 主列表中查询
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimAdminRegion:find")
	@RequestMapping(value = "find", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> find(HttpServletRequest request){
		List<Condition> conditions = Condition.buildFromHttpRequest(request);
		EasyUIPage easyUIPage = new EasyUIPage(request);
		MybatisExample mybatisExample = MybatisExample.getInstance();
		OimAdminRegionExample example = (OimAdminRegionExample)mybatisExample.buildExampleByCondition(conditions, easyUIPage, OimAdminRegionExample.class.getName());
		PageList<OimAdminRegion> oimAdminRegions = oimAdminRegionService.selectByExample(example, new PageBounds(easyUIPage.getPage(),
                easyUIPage.getRows()));
		return getEasyUIGrid(oimAdminRegions);
	}
	
	@RequestMapping(value = "getOperateCitys", method = RequestMethod.POST)
    @ResponseBody
	public Map<String, Object> getOperateCitys(HttpServletRequest request){
	    EasyUIPage easyUIPage = new EasyUIPage(request);
	    PageList<OperateCityDto> operateCityDtos = oimAdminRegionService.selectOperateCityDto(new PageBounds(easyUIPage.getPage(), easyUIPage.getRows()));
	    return getEasyUIGrid(operateCityDtos);
	}
	
	/**
	 * 跳转到新增页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimAdminRegion:add")
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addForm(Model model){
		OimAdminRegion oimAdminRegion = new OimAdminRegion();
				model.addAttribute("oimAdminRegion", oimAdminRegion);
		model.addAttribute("action", "add");
		return "modules/base/oimAdminRegionForm";
	}
	
		/**
	 * 新增记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimAdminRegion:add")
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(OimAdminRegion oimAdminRegion){
		int flag = oimAdminRegionService.insertSelective(oimAdminRegion);
		BaseResponse baseResponse = flag>0?new BaseResponse(true,"新增成功"):new BaseResponse(false, "新增失败");
		return baseResponse;
	}
		
	/**
	 * 跳转到编辑页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimAdminRegion:edit")
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") String id,Model model){
		OimAdminRegion oimAdminRegion = oimAdminRegionService.selectByPrimaryKey(id);
		model.addAttribute("oimAdminRegion", oimAdminRegion);
		model.addAttribute("action", "edit");
		return "modules/base/oimAdminRegionForm";
	}
	
	/**
	 * 跳转到查看页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimAdminRegion:view")
	@RequestMapping(value = "view/{id}", method = RequestMethod.GET)
	public String viewForm(@PathVariable("id") String id,Model model){
		OimAdminRegion oimAdminRegion = oimAdminRegionService.selectByPrimaryKey(id);
		model.addAttribute("oimAdminRegion", oimAdminRegion);
		model.addAttribute("action", "view");
		return "modules/base/oimAdminRegionForm";
	}
	
		/**
	 * 编辑记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimAdminRegion:edit")
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse edit(OimAdminRegion oimAdminRegion){
		int flag = oimAdminRegionService.updateByPrimaryKeySelective(oimAdminRegion);
		BaseResponse baseResponse = flag>0?new BaseResponse(true,"编辑成功"):new BaseResponse(false, "编辑失败");
		return baseResponse;
	}
		
	/**
	 * 删除记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimAdminRegion:remove")
	@RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse remove(@PathVariable("id") String id){
		int flag = oimAdminRegionService.deleteByPrimaryKey(id);
		BaseResponse baseResponse = flag>=0?new BaseResponse(true,"删除成功"):new BaseResponse(false, "删除失败");
		return baseResponse;
	}
	
	}
