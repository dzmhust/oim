package com.dzmsoft.oim.finance.controller;

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
import com.dzmsoft.oim.finance.pojo.OimRecipientBill;
import com.dzmsoft.oim.finance.pojo.OimRecipientBillExample;
import com.dzmsoft.oim.finance.service.OimRecipientBillService;
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
@RequestMapping("oimRecipientBill")
public class OimRecipientBillController extends BaseController{
	@Autowired
	private OimRecipientBillService oimRecipientBillService;

	/**
	 * 显示主列表页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimRecipientBill:find")
	@RequestMapping(value = "show", method = RequestMethod.GET)
	public String show(){
		return "modules/finance/oimRecipientBillList";
	}
	
	/**
	 * 主列表中查询
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimRecipientBill:find")
	@RequestMapping(value = "find", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> find(HttpServletRequest request){
		List<Condition> conditions = Condition.buildFromHttpRequest(request);
		EasyUIPage easyUIPage = new EasyUIPage(request);
		MybatisExample mybatisExample = MybatisExample.getInstance();
		OimRecipientBillExample example = (OimRecipientBillExample)mybatisExample.buildExampleByCondition(conditions, easyUIPage, OimRecipientBillExample.class.getName());
		PageList<OimRecipientBill> oimRecipientBills = oimRecipientBillService.selectByExample(example, new PageBounds(easyUIPage.getPage(),
                easyUIPage.getRows()));
		return getEasyUIGrid(oimRecipientBills);
	}
	
	/**
	 * 跳转到新增页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimRecipientBill:add")
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addForm(Model model){
		OimRecipientBill oimRecipientBill = new OimRecipientBill();
				model.addAttribute("oimRecipientBill", oimRecipientBill);
		model.addAttribute("action", "add");
		return "modules/finance/oimRecipientBillForm";
	}
	
		/**
	 * 新增记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimRecipientBill:add")
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(OimRecipientBill oimRecipientBill){
		int flag = oimRecipientBillService.insertSelective(oimRecipientBill);
		BaseResponse baseResponse = flag>0?new BaseResponse(true,"新增成功"):new BaseResponse(false, "新增失败");
		return baseResponse;
	}
		
	/**
	 * 跳转到编辑页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimRecipientBill:edit")
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") String id,Model model){
		OimRecipientBill oimRecipientBill = oimRecipientBillService.selectByPrimaryKey(id);
		model.addAttribute("oimRecipientBill", oimRecipientBill);
		model.addAttribute("action", "edit");
		return "modules/finance/oimRecipientBillForm";
	}
	
	/**
	 * 跳转到查看页面
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimRecipientBill:view")
	@RequestMapping(value = "view/{id}", method = RequestMethod.GET)
	public String viewForm(@PathVariable("id") String id,Model model){
		OimRecipientBill oimRecipientBill = oimRecipientBillService.selectByPrimaryKey(id);
		model.addAttribute("oimRecipientBill", oimRecipientBill);
		model.addAttribute("action", "view");
		return "modules/finance/oimRecipientBillForm";
	}
	
		/**
	 * 编辑记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimRecipientBill:edit")
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse edit(OimRecipientBill oimRecipientBill){
		int flag = oimRecipientBillService.updateByPrimaryKeySelective(oimRecipientBill);
		BaseResponse baseResponse = flag>0?new BaseResponse(true,"编辑成功"):new BaseResponse(false, "编辑失败");
		return baseResponse;
	}
		
	/**
	 * 删除记录
	 * @dzmsoftgenerated 
	 * @return
	 */
	@RequiresPermissions("oimRecipientBill:remove")
	@RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse remove(@PathVariable("id") String id){
		int flag = oimRecipientBillService.deleteByPrimaryKey(id);
		BaseResponse baseResponse = flag>=0?new BaseResponse(true,"删除成功"):new BaseResponse(false, "删除失败");
		return baseResponse;
	}
	
	}
