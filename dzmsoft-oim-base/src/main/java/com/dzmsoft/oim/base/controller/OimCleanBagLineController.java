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
import com.dzmsoft.oim.base.pojo.OimCleanBagLine;
import com.dzmsoft.oim.base.pojo.OimCleanBagLineExample;
import com.dzmsoft.oim.base.service.OimCleanBagLineService;
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
@RequestMapping("oimCleanBagLine")
public class OimCleanBagLineController extends BaseController{
	@Autowired
	private OimCleanBagLineService oimCleanBagLineService;

	/**
	 * 显示主列表页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimCleanBagLine:find")
	@RequestMapping(value = "show", method = RequestMethod.GET)
	public String show(){
		return "modules/base/oimCleanBagLineList";
	}
	
	/**
	 * 主列表中查询
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimCleanBagLine:find")
	@RequestMapping(value = "find", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> find(HttpServletRequest request){
		List<Condition> conditions = Condition.buildFromHttpRequest(request);
		EasyUIPage easyUIPage = new EasyUIPage(request);
		MybatisExample mybatisExample = MybatisExample.getInstance();
		OimCleanBagLineExample example = (OimCleanBagLineExample)mybatisExample.buildExampleByCondition(conditions, easyUIPage, OimCleanBagLineExample.class.getName());
		PageList<OimCleanBagLine> oimCleanBagLines = oimCleanBagLineService.selectByExample(example, new PageBounds(easyUIPage.getPage(),
                easyUIPage.getRows()));
		return getEasyUIGrid(oimCleanBagLines);
	}
	
	/**
	 * 跳转到新增页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimCleanBagLine:add")
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addForm(Model model){
		OimCleanBagLine oimCleanBagLine = new OimCleanBagLine();
				model.addAttribute("oimCleanBagLine", oimCleanBagLine);
		model.addAttribute("action", "add");
		return "modules/base/oimCleanBagLineForm";
	}
	
		/**
	 * 新增记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimCleanBagLine:add")
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(OimCleanBagLine oimCleanBagLine){
		int flag = oimCleanBagLineService.insertSelective(oimCleanBagLine);
		BaseResponse baseResponse = flag>0?new BaseResponse(true,"新增成功"):new BaseResponse(false, "新增失败");
		return baseResponse;
	}
		
	/**
	 * 跳转到编辑页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimCleanBagLine:edit")
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") String id,Model model){
		OimCleanBagLine oimCleanBagLine = oimCleanBagLineService.selectByPrimaryKey(id);
		model.addAttribute("oimCleanBagLine", oimCleanBagLine);
		model.addAttribute("action", "edit");
		return "modules/base/oimCleanBagLineForm";
	}
	
	/**
	 * 跳转到查看页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimCleanBagLine:view")
	@RequestMapping(value = "view/{id}", method = RequestMethod.GET)
	public String viewForm(@PathVariable("id") String id,Model model){
		OimCleanBagLine oimCleanBagLine = oimCleanBagLineService.selectByPrimaryKey(id);
		model.addAttribute("oimCleanBagLine", oimCleanBagLine);
		model.addAttribute("action", "view");
		return "modules/base/oimCleanBagLineForm";
	}
	
		/**
	 * 编辑记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimCleanBagLine:edit")
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse edit(OimCleanBagLine oimCleanBagLine){
		int flag = oimCleanBagLineService.updateByPrimaryKeySelective(oimCleanBagLine);
		BaseResponse baseResponse = flag>0?new BaseResponse(true,"编辑成功"):new BaseResponse(false, "编辑失败");
		return baseResponse;
	}
		
	/**
	 * 删除记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimCleanBagLine:remove")
	@RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse remove(@PathVariable("id") String id){
		int flag = oimCleanBagLineService.deleteByPrimaryKey(id);
		BaseResponse baseResponse = flag>=0?new BaseResponse(true,"删除成功"):new BaseResponse(false, "删除失败");
		return baseResponse;
	}
	
		@RequiresPermissions("oimCleanBagLine:enable")
	@RequestMapping(value = "enable/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public BaseResponse enable(@PathVariable("id") String id){
		int flag = oimCleanBagLineService.enable(id);
		BaseResponse baseResponse = flag>=0?new BaseResponse(true,"启用成功"):new BaseResponse(false, "启用失败");
		return baseResponse;
	}
	
	@RequiresPermissions("oimCleanBagLine:disable")
	@RequestMapping(value = "disable/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public BaseResponse disable(@PathVariable("id") String id){
		int flag = oimCleanBagLineService.disable(id);
		BaseResponse baseResponse = flag>=0?new BaseResponse(true,"禁用成功"):new BaseResponse(false, "禁用失败");
		return baseResponse;
	}
	}
