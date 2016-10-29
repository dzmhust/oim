package com.dzmsoft.oim.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzmsoft.framework.base.common.BaseConstant;
import com.dzmsoft.framework.base.web.mvc.controller.BaseController;
import com.dzmsoft.framework.base.web.mvc.dao.MybatisExample;
import com.dzmsoft.framework.base.web.mvc.view.BaseResponse;
import com.dzmsoft.framework.base.web.mvc.view.Condition;
import com.dzmsoft.oim.base.pojo.OimAdPosition;
import com.dzmsoft.oim.base.pojo.OimAdPositionExample;
import com.dzmsoft.oim.base.service.OimAdPositionService;

/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author dzmsoft
 * @dzmsoftgenerated 2016-04-26 14:26:38
 *
 * @version 1.0
 */
@Controller
@RequestMapping("oimAdPosition")
public class OimAdPositionController extends BaseController{
	@Autowired
	private OimAdPositionService oimAdPositionService;

	/**
	 * 显示主列表页面
	 * @dzmsoftgenerated 2016-04-26 14:26:38
	 * @return
	 */
	@RequiresPermissions("oimAdPosition:find")
	@RequestMapping(value = "show", method = RequestMethod.GET)
	public String show(){
		return "modules/base/oimAdPositionList";
	}
	
	/**
	 * 主列表中查询
	 * @dzmsoftgenerated 2016-04-26 14:26:38
	 * @return
	 */
	@RequiresPermissions("oimAdPosition:find")
	@RequestMapping(value = "find")
	@ResponseBody
	public List<OimAdPosition> findList(HttpServletRequest request){
		List<Condition> conditions = Condition.buildFromHttpRequest(request);
		MybatisExample mybatisExample = MybatisExample.getInstance();
		OimAdPositionExample example = (OimAdPositionExample)mybatisExample.buildExampleByCondition(conditions, OimAdPositionExample.class.getName());
		List<OimAdPosition> oimAdPositions = oimAdPositionService.selectByExample(example);
		return oimAdPositions;
	}
	
	/**
	 * 跳转到新增页面
	 * @dzmsoftgenerated 2016-04-26 14:26:38
	 * @return
	 */
	@RequiresPermissions("oimAdPosition:add")
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addForm(Model model){
		model.addAttribute("oimAdPosition", new OimAdPosition());
		model.addAttribute("action", "add");
		return "modules/base/oimAdPositionForm";
	}
	
	/**
	 * 新增记录
	 * @dzmsoftgenerated 2016-04-26 14:26:38
	 * @return
	 */
	@RequiresPermissions("oimAdPosition:add")
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(OimAdPosition oimAdPosition){
	    oimAdPosition.setStatus(BaseConstant.Status.ENABLE);
		int flag = oimAdPositionService.insertSelective(oimAdPosition);
		BaseResponse baseResponse = flag>0?new BaseResponse(true,"新增成功"):new BaseResponse(false, "新增失败");
		return baseResponse;
	}
	
	/**
	 * 跳转到编辑页面
	 * @dzmsoftgenerated 2016-04-26 14:26:38
	 * @return
	 */
	@RequiresPermissions("oimAdPosition:edit")
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") String id,Model model){
		OimAdPosition oimAdPosition = oimAdPositionService.selectByPrimaryKey(id);
		model.addAttribute("oimAdPosition", oimAdPosition);
		model.addAttribute("action", "edit");
		return "modules/base/oimAdPositionForm";
	}
	
	/**
	 * 编辑记录
	 * @dzmsoftgenerated 2016-04-26 14:26:38
	 * @return
	 */
	@RequiresPermissions("oimAdPosition:edit")
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse edit(OimAdPosition oimAdPosition){
		int flag = oimAdPositionService.updateByPrimaryKeySelective(oimAdPosition);
		BaseResponse baseResponse = flag>0?new BaseResponse(true,"编辑成功"):new BaseResponse(false, "编辑失败");
		return baseResponse;
	}
	
	/**
	 * 删除记录
	 * @dzmsoftgenerated 2016-04-26 14:26:38
	 * @return
	 */
	@RequiresPermissions("oimAdPosition:remove")
	@RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse remove(@PathVariable("id") String id){
		int flag = oimAdPositionService.deleteByPrimaryKey(id);
		BaseResponse baseResponse = flag>=0?new BaseResponse(true,"删除成功"):new BaseResponse(false, "删除失败");
		return baseResponse;
	}
}
