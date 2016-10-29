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

import com.dzmsoft.framework.base.util.CheckEmptyUtil;
import com.dzmsoft.framework.base.util.StringUtil;
import com.dzmsoft.framework.base.web.mvc.controller.BaseController;
import com.dzmsoft.framework.base.web.mvc.dao.MybatisExample;
import com.dzmsoft.framework.base.web.mvc.pojo.EasyUIPage;
import com.dzmsoft.framework.base.web.mvc.view.BaseResponse;
import com.dzmsoft.framework.base.web.mvc.view.Condition;
import com.dzmsoft.oim.base.dto.OperateCityDto;
import com.dzmsoft.oim.base.pojo.OimPersonRequire;
import com.dzmsoft.oim.base.pojo.OimPersonRequireExample;
import com.dzmsoft.oim.base.pojo.OimPersonRequireLine;
import com.dzmsoft.oim.base.service.OimPersonRequireLineService;
import com.dzmsoft.oim.base.service.OimPersonRequireService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Copyright (C), dzmsoft Co., Ltd
 * 
 * @author
 * @dzmsoftgenerated
 * @version
 */
@Controller
@RequestMapping("oimPersonRequire")
public class OimPersonRequireController extends BaseController {
    @Autowired
    private OimPersonRequireService oimPersonRequireService;

    @Autowired
    private OimPersonRequireLineService oimPersonRequireLineService;
    @Autowired
    private Gson gson;

    /**
     * 显示主列表页面
     * 
     * @dzmsoftgenerated
     * @return
     */
    @RequiresPermissions("oimPersonRequire:find")
    @RequestMapping(value = "show", method = RequestMethod.GET)
    public String show() {
        return "modules/base/oimPersonRequireList";
    }

    @RequiresPermissions("oimCleanBag:setRegion")
    @RequestMapping(value = "showRegionDialog", method = RequestMethod.GET)
    public String showRegionDialog() {
        return "modules/base/operateCityDialog";
    }

    /**
     * 设置区域
     * 
     * @param id
     * @param operateCity
     * @return
     */
    @RequiresPermissions("oimCleanBag:setRegion")
    @RequestMapping(value = "setRegions", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse setRegions(String id, String operateCity) {
        operateCity = StringUtil.unescapeHtml(operateCity);
        List<OperateCityDto> operateCityDtos = gson.fromJson(
                operateCity,
                new TypeToken<List<OperateCityDto>>() {
                }.getType());
        int flag = oimPersonRequireService.setRegions(id, operateCityDtos);
        BaseResponse baseResponse = flag > 0 ? new BaseResponse(true, "设置区域成功") : new BaseResponse(
                false, "设置区域失败");
        return baseResponse;
    }

    /**
     * 主列表中查询
     * 
     * @dzmsoftgenerated
     * @return
     */
    @RequiresPermissions("oimPersonRequire:find")
    @RequestMapping(value = "find", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> find(HttpServletRequest request) {
        List<Condition> conditions = Condition.buildFromHttpRequest(request);
        EasyUIPage easyUIPage = new EasyUIPage(request);
        MybatisExample mybatisExample = MybatisExample.getInstance();
        OimPersonRequireExample example = (OimPersonRequireExample) mybatisExample
                .buildExampleByCondition(
                        conditions,
                        easyUIPage,
                        OimPersonRequireExample.class.getName());
        PageList<OimPersonRequire> oimPersonRequires = oimPersonRequireService.selectByExample(
                example,
                new PageBounds(easyUIPage.getPage(), easyUIPage.getRows()));
        return getEasyUIGrid(oimPersonRequires);
    }

    /**
     * 跳转到新增页面
     * 
     * @dzmsoftgenerated
     * @return
     */
    @RequiresPermissions("oimPersonRequire:add")
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addForm(Model model) {
        model.addAttribute("oimPersonRequire", new OimPersonRequire());
        model.addAttribute("action", "add");
        return "modules/base/oimPersonRequireForm";
    }

    /**
     * 新增记录
     * 
     * @dzmsoftgenerated
     * @return
     */
    @RequiresPermissions("oimPersonRequire:add")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse add(OimPersonRequire oimPersonRequire, String datasOimPersonRequireLine) {
        Gson gson = new Gson();
        datasOimPersonRequireLine = StringUtil.unescapeHtml(datasOimPersonRequireLine);
        List<OimPersonRequireLine> itemsOimPersonRequireLine = gson.fromJson(
                datasOimPersonRequireLine,
                new TypeToken<List<OimPersonRequireLine>>() {
                }.getType());
        int flag = oimPersonRequireService.insertContainDetails(
                oimPersonRequire,
                itemsOimPersonRequireLine);
        BaseResponse baseResponse = flag > 0 ? new BaseResponse(true, "新增成功") : new BaseResponse(
                false, "新增失败");
        return baseResponse;
    }

    /**
     * 跳转到编辑页面
     * 
     * @dzmsoftgenerated
     * @return
     */
    @RequiresPermissions("oimPersonRequire:edit")
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String editForm(@PathVariable("id") String id, Model model) {
        OimPersonRequire oimPersonRequire = oimPersonRequireService.selectByPrimaryKey(id);
        model.addAttribute("oimPersonRequire", oimPersonRequire);
        model.addAttribute("action", "edit");
        List<OimPersonRequireLine> oimPersonRequireLine = oimPersonRequireLineService.selectByMain(id);
        if (!CheckEmptyUtil.isEmpty(oimPersonRequireLine)) {
            Gson gson = new Gson();
            String datasOimPersonRequireLine = gson.toJson(oimPersonRequireLine);
            model.addAttribute(
                    "datasOimPersonRequireLine",
                    StringUtil.escapeHtml(datasOimPersonRequireLine));
        }
        return "modules/base/oimPersonRequireForm";
    }

    /**
     * 跳转到查看页面
     * 
     * @dzmsoftgenerated
     * @return
     */
    @RequiresPermissions("oimPersonRequire:view")
    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public String viewForm(@PathVariable("id") String id, Model model) {
        OimPersonRequire oimPersonRequire = oimPersonRequireService.selectByPrimaryKey(id);
        model.addAttribute("oimPersonRequire", oimPersonRequire);
        model.addAttribute("action", "view");
        List<OimPersonRequireLine> oimPersonRequireLine = null;
        if (!CheckEmptyUtil.isEmpty(oimPersonRequireLine)) {
            Gson gson = new Gson();
            String datasOimPersonRequireLine = gson.toJson(oimPersonRequireLine);
            model.addAttribute(
                    "datasOimPersonRequireLine",
                    StringUtil.escapeHtml(datasOimPersonRequireLine));
        }
        return "modules/base/oimPersonRequireForm";
    }

    /**
     * 编辑记录
     * 
     * @dzmsoftgenerated
     * @return
     */
    @RequiresPermissions("oimPersonRequire:edit")
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse edit(OimPersonRequire oimPersonRequire, String datasOimPersonRequireLine) {
        Gson gson = new Gson();
        datasOimPersonRequireLine = StringUtil.unescapeHtml(datasOimPersonRequireLine);
        List<OimPersonRequireLine> itemsOimPersonRequireLine = gson.fromJson(
                datasOimPersonRequireLine,
                new TypeToken<List<OimPersonRequireLine>>() {
                }.getType());
        int flag = oimPersonRequireService.updateContainDetails(
                oimPersonRequire,
                itemsOimPersonRequireLine);
        BaseResponse baseResponse = flag > 0 ? new BaseResponse(true, "编辑成功") : new BaseResponse(
                false, "编辑失败");
        return baseResponse;
    }

    /**
     * 删除记录
     * 
     * @dzmsoftgenerated
     * @return
     */
    @RequiresPermissions("oimPersonRequire:remove")
    @RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse remove(@PathVariable("id") String id) {
        int flag = oimPersonRequireService.deleteByPrimaryKey(id);
        BaseResponse baseResponse = flag >= 0 ? new BaseResponse(true, "删除成功") : new BaseResponse(
                false, "删除失败");
        return baseResponse;
    }

    @RequiresPermissions("oimPersonRequire:enable")
    @RequestMapping(value = "enable/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public BaseResponse enable(@PathVariable("id") String id) {
        int flag = oimPersonRequireService.enable(id);
        BaseResponse baseResponse = flag >= 0 ? new BaseResponse(true, "启用成功") : new BaseResponse(
                false, "启用失败");
        return baseResponse;
    }

    @RequiresPermissions("oimPersonRequire:disable")
    @RequestMapping(value = "disable/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public BaseResponse disable(@PathVariable("id") String id) {
        int flag = oimPersonRequireService.disable(id);
        BaseResponse baseResponse = flag >= 0 ? new BaseResponse(true, "禁用成功") : new BaseResponse(
                false, "禁用失败");
        return baseResponse;
    }
}
