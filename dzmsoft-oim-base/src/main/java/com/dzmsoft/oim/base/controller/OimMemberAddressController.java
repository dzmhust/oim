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
import com.dzmsoft.oim.base.pojo.OimMemberAddress;
import com.dzmsoft.oim.base.pojo.OimMemberAddressExample;
import com.dzmsoft.oim.base.service.OimMemberAddressService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author dzmsoft
 * @dzmsoftgenerated 2016-04-26 16:01:23
 *
 * @version 1.0
 */
@Controller
@RequestMapping("oimMemberAddress")
public class OimMemberAddressController extends BaseController{
	@Autowired
	private OimMemberAddressService oimMemberAddressService;

	/**
	 * 显示主列表页面
	 * @dzmsoftgenerated 2016-04-26 16:01:23
	 * @return
	 */
	@RequiresPermissions("oimMemberAddress:find")
	@RequestMapping(value = "show", method = RequestMethod.GET)
	public String show(){
		return "modules/base/oimMemberAddressList";
	}
	
	/**
	 * 主列表中查询
	 * @dzmsoftgenerated 2016-04-26 16:01:23
	 * @return
	 */
	@RequiresPermissions("oimMemberAddress:find")
	@RequestMapping(value = "find", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> find(HttpServletRequest request){
		List<Condition> conditions = Condition.buildFromHttpRequest(request);
		EasyUIPage easyUIPage = new EasyUIPage(request);
		MybatisExample mybatisExample = MybatisExample.getInstance();
		OimMemberAddressExample example = (OimMemberAddressExample)mybatisExample.buildExampleByCondition(conditions, easyUIPage, OimMemberAddressExample.class.getName());
		PageList<OimMemberAddress> oimMemberAddresss = oimMemberAddressService.selectByExample(example, new PageBounds(easyUIPage.getPage(),
                easyUIPage.getRows()));
		return getEasyUIGrid(oimMemberAddresss);
	}
	
	/**
	 * 跳转到新增页面
	 * @dzmsoftgenerated 2016-04-26 16:01:23
	 * @return
	 */
	@RequiresPermissions("oimMemberAddress:add")
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addForm(Model model){
		model.addAttribute("oimMemberAddress", new OimMemberAddress());
		model.addAttribute("action", "add");
		return "modules/base/oimMemberAddressForm";
	}
	
	/**
	 * 新增记录
	 * @dzmsoftgenerated 2016-04-26 16:01:23
	 * @return
	 */
	@RequiresPermissions("oimMemberAddress:add")
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(OimMemberAddress oimMemberAddress){
		int flag = oimMemberAddressService.insertSelective(oimMemberAddress);
		BaseResponse baseResponse = flag>0?new BaseResponse(true,"新增成功"):new BaseResponse(false, "新增失败");
		return baseResponse;
	}
	
	/**
	 * 跳转到编辑页面
	 * @dzmsoftgenerated 2016-04-26 16:01:23
	 * @return
	 */
	@RequiresPermissions("oimMemberAddress:edit")
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") String id,Model model){
		OimMemberAddress oimMemberAddress = oimMemberAddressService.selectByPrimaryKey(id);
		model.addAttribute("oimMemberAddress", oimMemberAddress);
		model.addAttribute("action", "edit");
		return "modules/base/oimMemberAddressForm";
	}
	
	/**
	 * 跳转到查看页面
	 * @dzmsoftgenerated 2016-04-26 16:01:23
	 * @return
	 */
	@RequiresPermissions("oimMemberAddress:view")
	@RequestMapping(value = "view/{id}", method = RequestMethod.GET)
	public String viewForm(@PathVariable("id") String id,Model model){
		OimMemberAddress oimMemberAddress = oimMemberAddressService.selectByPrimaryKey(id);
		model.addAttribute("oimMemberAddress", oimMemberAddress);
		model.addAttribute("action", "view");
		return "modules/base/oimMemberAddressForm";
	}
	
	/**
	 * 编辑记录
	 * @dzmsoftgenerated 2016-04-26 16:01:23
	 * @return
	 */
	@RequiresPermissions("oimMemberAddress:edit")
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse edit(OimMemberAddress oimMemberAddress){
		int flag = oimMemberAddressService.updateByPrimaryKeySelective(oimMemberAddress);
		BaseResponse baseResponse = flag>0?new BaseResponse(true,"编辑成功"):new BaseResponse(false, "编辑失败");
		return baseResponse;
	}
	
	/**
	 * 删除记录
	 * @dzmsoftgenerated 2016-04-26 16:01:23
	 * @return
	 */
	@RequiresPermissions("oimMemberAddress:remove")
	@RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse remove(@PathVariable("id") String id){
		int flag = oimMemberAddressService.deleteByPrimaryKey(id);
		BaseResponse baseResponse = flag>=0?new BaseResponse(true,"删除成功"):new BaseResponse(false, "删除失败");
		return baseResponse;
	}
}
