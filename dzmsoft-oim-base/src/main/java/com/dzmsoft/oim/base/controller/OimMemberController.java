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
import com.dzmsoft.oim.base.pojo.OimMember;
import com.dzmsoft.oim.base.pojo.OimMemberExample;
import com.dzmsoft.oim.base.service.OimMemberService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author dzmsoft
 * @dzmsoftgenerated 2016-04-26 14:42:31
 *
 * @version 1.0
 */
@Controller
@RequestMapping("oimMember")
public class OimMemberController extends BaseController{
	@Autowired
	private OimMemberService oimMemberService;

	/**
	 * 显示主列表页面
	 * @dzmsoftgenerated 2016-04-26 14:42:31
	 * @return
	 */
	@RequiresPermissions("oimMember:find")
	@RequestMapping(value = "show", method = RequestMethod.GET)
	public String show(){
		return "modules/base/oimMemberList";
	}
	
	/**
	 * 主列表中查询
	 * @dzmsoftgenerated 2016-04-26 14:42:31
	 * @return
	 */
	@RequiresPermissions("oimMember:find")
	@RequestMapping(value = "find", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> find(HttpServletRequest request){
		List<Condition> conditions = Condition.buildFromHttpRequest(request);
		EasyUIPage easyUIPage = new EasyUIPage(request);
		MybatisExample mybatisExample = MybatisExample.getInstance();
		OimMemberExample example = (OimMemberExample)mybatisExample.buildExampleByCondition(conditions, easyUIPage, OimMemberExample.class.getName());
		PageList<OimMember> oimMembers = oimMemberService.selectByExample(example, new PageBounds(easyUIPage.getPage(),
                easyUIPage.getRows()));
		return getEasyUIGrid(oimMembers);
	}
	
	/**
	 * 跳转到新增页面
	 * @dzmsoftgenerated 2016-04-26 14:42:31
	 * @return
	 */
	@RequiresPermissions("oimMember:add")
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addForm(Model model){
		model.addAttribute("oimMember", new OimMember());
		model.addAttribute("action", "add");
		return "modules/base/oimMemberForm";
	}
	
	/**
	 * 新增记录
	 * @dzmsoftgenerated 2016-04-26 14:42:31
	 * @return
	 */
	@RequiresPermissions("oimMember:add")
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(OimMember oimMember){
		int flag = oimMemberService.insertSelective(oimMember);
		BaseResponse baseResponse = flag>0?new BaseResponse(true,"新增成功"):new BaseResponse(false, "新增失败");
		return baseResponse;
	}
	
	/**
	 * 跳转到编辑页面
	 * @dzmsoftgenerated 2016-04-26 14:42:31
	 * @return
	 */
	@RequiresPermissions("oimMember:edit")
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") String id,Model model){
		OimMember oimMember = oimMemberService.selectByPrimaryKey(id);
		model.addAttribute("oimMember", oimMember);
		model.addAttribute("action", "edit");
		return "modules/base/oimMemberForm";
	}
	
	/**
	 * 跳转到查看页面
	 * @dzmsoftgenerated 2016-04-26 14:42:31
	 * @return
	 */
	@RequiresPermissions("oimMember:view")
	@RequestMapping(value = "view/{id}", method = RequestMethod.GET)
	public String viewForm(@PathVariable("id") String id,Model model){
		OimMember oimMember = oimMemberService.selectByPrimaryKey(id);
		model.addAttribute("oimMember", oimMember);
		model.addAttribute("action", "view");
		return "modules/base/oimMemberForm";
	}
	
	/**
	 * 编辑记录
	 * @dzmsoftgenerated 2016-04-26 14:42:31
	 * @return
	 */
	@RequiresPermissions("oimMember:edit")
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse edit(OimMember oimMember){
		int flag = oimMemberService.updateByPrimaryKeySelective(oimMember);
		BaseResponse baseResponse = flag>0?new BaseResponse(true,"编辑成功"):new BaseResponse(false, "编辑失败");
		return baseResponse;
	}
	
	/**
	 * 删除记录
	 * @dzmsoftgenerated 2016-04-26 14:42:31
	 * @return
	 */
	@RequiresPermissions("oimMember:remove")
	@RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse remove(@PathVariable("id") String id){
		int flag = oimMemberService.deleteByPrimaryKey(id);
		BaseResponse baseResponse = flag>=0?new BaseResponse(true,"删除成功"):new BaseResponse(false, "删除失败");
		return baseResponse;
	}
}
