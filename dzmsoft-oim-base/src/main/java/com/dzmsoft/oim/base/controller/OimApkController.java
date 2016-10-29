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
import com.dzmsoft.oim.base.common.OimBaseConstant;
import com.dzmsoft.oim.base.pojo.OimApk;
import com.dzmsoft.oim.base.pojo.OimApkExample;
import com.dzmsoft.oim.base.service.OimApkService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author dzmsoft
 * @dzmsoftgenerated 2016-05-04 13:23:49
 *
 * @version 1.0
 */
@Controller
@RequestMapping("oimApk")
public class OimApkController extends BaseController{
	@Autowired
	private OimApkService oimApkService;

	/**
	 * 显示主列表页面
	 * @dzmsoftgenerated 2016-05-04 13:23:49
	 * @return
	 */
	@RequiresPermissions("oimApk:find")
	@RequestMapping(value = "show", method = RequestMethod.GET)
	public String show(){
		return "modules/base/oimApkList";
	}
	
	/**
	 * 主列表中查询
	 * @dzmsoftgenerated 2016-05-04 13:23:49
	 * @return
	 */
	@RequiresPermissions("oimApk:find")
	@RequestMapping(value = "find", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> find(HttpServletRequest request){
		List<Condition> conditions = Condition.buildFromHttpRequest(request);
		EasyUIPage easyUIPage = new EasyUIPage(request);
		MybatisExample mybatisExample = MybatisExample.getInstance();
		OimApkExample example = (OimApkExample)mybatisExample.buildExampleByCondition(conditions, easyUIPage, OimApkExample.class.getName());
		PageList<OimApk> oimApks = oimApkService.selectByExample(example, new PageBounds(easyUIPage.getPage(),
                easyUIPage.getRows()));
		return getEasyUIGrid(oimApks);
	}
	
	/**
	 * 跳转到新增页面
	 * @dzmsoftgenerated 2016-05-04 13:23:49
	 * @return
	 */
	@RequiresPermissions("oimApk:add")
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addForm(Model model){
		model.addAttribute("oimApk", new OimApk());
		model.addAttribute("action", "add");
		return "modules/base/oimApkForm";
	}
	
	/**
	 * 新增记录
	 * @dzmsoftgenerated 2016-05-04 13:23:49
	 * @return
	 */
	@RequiresPermissions("oimApk:add")
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(OimApk oimApk){
		int flag = oimApkService.insertSelective(oimApk);
		BaseResponse baseResponse = flag>0?new BaseResponse(true,"新增成功"):new BaseResponse(false, "新增失败");
		return baseResponse;
	}
	
	/**
	 * 跳转到编辑页面
	 * @dzmsoftgenerated 2016-05-04 13:23:49
	 * @return
	 */
	@RequiresPermissions("oimApk:edit")
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") String id,Model model){
		OimApk oimApk = oimApkService.selectByPrimaryKey(id);
		model.addAttribute("oimApk", oimApk);
		model.addAttribute("action", "edit");
		return "modules/base/oimApkForm";
	}
	
	/**
	 * 跳转到查看页面
	 * @dzmsoftgenerated 2016-05-04 13:23:49
	 * @return
	 */
	@RequiresPermissions("oimApk:view")
	@RequestMapping(value = "view/{id}", method = RequestMethod.GET)
	public String viewForm(@PathVariable("id") String id,Model model){
		OimApk oimApk = oimApkService.selectByPrimaryKey(id);
		model.addAttribute("oimApk", oimApk);
		model.addAttribute("action", "view");
		return "modules/base/oimApkForm";
	}
	
	/**
	 * 编辑记录
	 * @dzmsoftgenerated 2016-05-04 13:23:49
	 * @return
	 */
	@RequiresPermissions("oimApk:edit")
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse edit(OimApk oimApk){
		int flag = oimApkService.updateByPrimaryKeySelective(oimApk);
		BaseResponse baseResponse = flag>0?new BaseResponse(true,"编辑成功"):new BaseResponse(false, "编辑失败");
		return baseResponse;
	}
	
	/**
	 * 删除记录
	 * @dzmsoftgenerated 2016-05-04 13:23:49
	 * @return
	 */
	@RequiresPermissions("oimApk:remove")
	@RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse remove(@PathVariable("id") String id){
		int flag = oimApkService.deleteByPrimaryKey(id);
		BaseResponse baseResponse = flag>=0?new BaseResponse(true,"删除成功"):new BaseResponse(false, "删除失败");
		return baseResponse;
	}
	
	/**
	 * 上线
	 * @param id
	 * @return
	 */
	@RequiresPermissions("oimApk:online")
    @RequestMapping(value = "online/{id}/{packageName}", method = RequestMethod.PUT)
    @ResponseBody
    public BaseResponse online(@PathVariable("id") String id, @PathVariable String packageName){
        int flag = oimApkService.online(id, packageName);
        BaseResponse baseResponse = flag>=0?new BaseResponse(true,"上线成功"):new BaseResponse(false, "上线失败");
        return baseResponse;
    }
	
	/**
	 * 下线
	 * @param id
	 * @return
	 */
	@RequiresPermissions("oimApk:offline")
    @RequestMapping(value = "offline/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public BaseResponse offline(@PathVariable("id") String id){
        int flag = oimApkService.setStatus(id, OimBaseConstant.ApkStatus.OFFLINE);
        BaseResponse baseResponse = flag>=0?new BaseResponse(true,"下线成功"):new BaseResponse(false, "下线失败");
        return baseResponse;
    }
}
