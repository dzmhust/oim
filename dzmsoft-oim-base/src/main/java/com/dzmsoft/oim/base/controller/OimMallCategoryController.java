package com.dzmsoft.oim.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.dzmsoft.framework.base.exception.FileException;
import com.dzmsoft.framework.base.web.mvc.controller.BaseController;
import com.dzmsoft.framework.base.web.mvc.dao.MybatisExample;
import com.dzmsoft.framework.base.web.mvc.view.BaseResponse;
import com.dzmsoft.framework.base.web.mvc.view.Condition;
import com.dzmsoft.framework.file.util.FileUtil;
import com.dzmsoft.oim.base.pojo.OimMallCategory;
import com.dzmsoft.oim.base.pojo.OimMallCategoryExample;
import com.dzmsoft.oim.base.service.OimMallCategoryService;

/**
 * Copyright (C), dzmsoft Co., Ltd
 * 
 * @author dzmsoft
 * @dzmsoftgenerated 2016-04-26 14:26:38
 * @version 1.0
 */
@Controller
@RequestMapping("oimMallCategory")
public class OimMallCategoryController extends BaseController {
    @Autowired
    private OimMallCategoryService oimMallCategoryService;

    @Value("${img.ratio.three}")
    private double img_ratio_three;

    @Value("${upload.path}")
    private String uploadPath;

    @Value("${image.maxsize}")
    private int image_maxsize;

    /**
     * 显示主列表页面
     * 
     * @dzmsoftgenerated 2016-04-26 14:26:38
     * @return
     */
    @RequiresPermissions("oimMallCategory:find")
    @RequestMapping(value = "show", method = RequestMethod.GET)
    public String show() {
        return "modules/base/oimMallCategoryList";
    }

    /**
     * 主列表中查询
     * 
     * @dzmsoftgenerated 2016-04-26 14:26:38
     * @return
     */
    @RequiresPermissions("oimMallCategory:find")
    @RequestMapping(value = "find")
    @ResponseBody
    public List<OimMallCategory> findList(HttpServletRequest request) {
        List<Condition> conditions = Condition.buildFromHttpRequest(request);
        MybatisExample mybatisExample = MybatisExample.getInstance();
        OimMallCategoryExample example = (OimMallCategoryExample) mybatisExample
                .buildExampleByCondition(conditions, OimMallCategoryExample.class.getName());
        List<OimMallCategory> oimMallCategorys = oimMallCategoryService.selectByExample(example);
        return oimMallCategorys;
    }

    /**
     * 跳转到新增页面
     * 
     * @dzmsoftgenerated 2016-04-26 14:26:38
     * @return
     */
    @RequiresPermissions("oimMallCategory:add")
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addForm(Model model) {
        model.addAttribute("oimMallCategory", new OimMallCategory());
        model.addAttribute("action", "add");
        return "modules/base/oimMallCategoryForm";
    }

    /**
     * 新增记录
     * 
     * @dzmsoftgenerated 2016-04-26 14:26:38
     * @return
     */
    @RequiresPermissions("oimMallCategory:add")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse add(OimMallCategory oimMallCategory,MultipartFile siteResourcePathName,MultipartFile phoneResourcePathName) {
        try {
            saveFile(oimMallCategory, siteResourcePathName,phoneResourcePathName );
        } catch (FileException e) {
            return new BaseResponse(false, e.getMessage());
        }
        int flag = oimMallCategoryService.insertSelective(oimMallCategory);
        BaseResponse baseResponse = flag > 0 ? new BaseResponse(true, "新增成功") : new BaseResponse(
                false, "新增失败");
        return baseResponse;
    }

    private void saveFile(OimMallCategory oimMallCategory, MultipartFile siteResourcePathName,
            MultipartFile phoneResourcePathName) throws FileException {
        if (siteResourcePathName != null && siteResourcePathName.getSize() > 0) {
            String picName = siteResourcePathName.getOriginalFilename();
            String fileName = FileUtil.spliceFileName(picName, true, true);
            FileUtil.uploadImage(
                    siteResourcePathName,
                    uploadPath,
                    fileName,
                    image_maxsize,
                    img_ratio_three);
            oimMallCategory.setSiteResourcePath(fileName);
        }
        if (phoneResourcePathName != null && phoneResourcePathName.getSize() > 0) {
            String picName = phoneResourcePathName.getOriginalFilename();
            String fileName = FileUtil.spliceFileName(picName, true, true);
            FileUtil.uploadImage(
                    phoneResourcePathName,
                    uploadPath,
                    fileName,
                    image_maxsize,
                    img_ratio_three);
            oimMallCategory.setPhoneResourcePath(fileName);
        }
    }

    /**
     * 跳转到编辑页面
     * 
     * @dzmsoftgenerated 2016-04-26 14:26:38
     * @return
     */
    @RequiresPermissions("oimMallCategory:edit")
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String editForm(@PathVariable("id") String id, Model model) {
        OimMallCategory oimMallCategory = oimMallCategoryService.selectByPrimaryKey(id);
        model.addAttribute("oimMallCategory", oimMallCategory);
        model.addAttribute("action", "edit");
        return "modules/base/oimMallCategoryForm";
    }

    /**
     * 编辑记录
     * 
     * @dzmsoftgenerated 2016-04-26 14:26:38
     * @return
     */
    @RequiresPermissions("oimMallCategory:edit")
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse edit(OimMallCategory oimMallCategory,MultipartFile siteResourcePathName,MultipartFile phoneResourcePathName) {
        try {
            saveFile(oimMallCategory, siteResourcePathName,phoneResourcePathName );
        } catch (FileException e) {
            return new BaseResponse(false, e.getMessage());
        }
        int flag = oimMallCategoryService.updateByPrimaryKeySelective(oimMallCategory);
        BaseResponse baseResponse = flag > 0 ? new BaseResponse(true, "编辑成功") : new BaseResponse(
                false, "编辑失败");
        return baseResponse;
    }

    /**
     * 删除记录
     * 
     * @dzmsoftgenerated 2016-04-26 14:26:38
     * @return
     */
    @RequiresPermissions("oimMallCategory:remove")
    @RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse remove(@PathVariable("id") String id) {
        int flag = oimMallCategoryService.deleteByPrimaryKey(id);
        BaseResponse baseResponse = flag >= 0 ? new BaseResponse(true, "删除成功") : new BaseResponse(
                false, "删除失败");
        return baseResponse;
    }
}
