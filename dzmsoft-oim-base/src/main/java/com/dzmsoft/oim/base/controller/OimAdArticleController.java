package com.dzmsoft.oim.base.controller;

import java.util.List;
import java.util.Map;

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

import com.dzmsoft.framework.base.common.BaseConstant;
import com.dzmsoft.framework.base.exception.FileException;
import com.dzmsoft.framework.base.util.StringUtil;
import com.dzmsoft.framework.base.web.mvc.controller.BaseController;
import com.dzmsoft.framework.base.web.mvc.dao.MybatisExample;
import com.dzmsoft.framework.base.web.mvc.pojo.EasyUIPage;
import com.dzmsoft.framework.base.web.mvc.view.BaseResponse;
import com.dzmsoft.framework.base.web.mvc.view.Condition;
import com.dzmsoft.framework.base.web.mvc.view.GenericResponse;
import com.dzmsoft.framework.file.util.FileUtil;
import com.dzmsoft.oim.base.pojo.OimAdArticle;
import com.dzmsoft.oim.base.pojo.OimAdArticleExample;
import com.dzmsoft.oim.base.service.OimAdArticleService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

/**
 * Copyright (C), dzmsoft Co., Ltd
 * @author dzmsoft
 * @dzmsoftgenerated 2016-04-26 14:23:38
 *
 * @version 1.0
 */
@Controller
@RequestMapping("oimAdArticle")
public class OimAdArticleController extends BaseController{
	@Autowired
	private OimAdArticleService oimAdArticleService;
	@Value("${upload.path}")
    private String uploadPath;
    @Value("${image.maxsize}")
    private int image_maxsize;
    @Value("${img.ratio.three}")
    private double img_ratio_three;

	/**
	 * 显示主列表页面
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @return
	 */
	@RequiresPermissions("oimAdArticle:find")
	@RequestMapping(value = "show", method = RequestMethod.GET)
	public String show(){
		return "modules/base/oimAdArticleList";
	}
	
	/**
	 * 主列表中查询
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @return
	 */
	@RequiresPermissions("oimAdArticle:find")
	@RequestMapping(value = "find", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> find(HttpServletRequest request){
		List<Condition> conditions = Condition.buildFromHttpRequest(request);
		EasyUIPage easyUIPage = new EasyUIPage(request);
		MybatisExample mybatisExample = MybatisExample.getInstance();
		OimAdArticleExample example = (OimAdArticleExample)mybatisExample.buildExampleByCondition(conditions, easyUIPage, OimAdArticleExample.class.getName());
		PageList<OimAdArticle> oimAdArticles = oimAdArticleService.selectByExample(example, new PageBounds(easyUIPage.getPage(),
                easyUIPage.getRows()));
		return getEasyUIGrid(oimAdArticles);
	}
	
	/**
	 * 跳转到新增页面
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @return
	 */
	@RequiresPermissions("oimAdArticle:add")
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addForm(Model model){
	    OimAdArticle oimAdArticle =  new OimAdArticle();
	    oimAdArticle.setId(StringUtil.getUuidString());
		model.addAttribute("oimAdArticle",oimAdArticle);
		model.addAttribute("action", "add");
		return "modules/base/oimAdArticleForm";
	}
	
	/**
	 * 新增记录
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @return
	 */
	@RequiresPermissions("oimAdArticle:add")
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse<String> add(OimAdArticle oimAdArticle,MultipartFile pcTitlePicName,MultipartFile appTitlePicName){
	    try{
            saveFile(oimAdArticle, pcTitlePicName,appTitlePicName);
        }catch(FileException e){
            return new GenericResponse<String>(false,e.getMessage());
        }
	    oimAdArticle.setStatus(BaseConstant.Status.DISABLED);
	    oimAdArticle.setContext(StringUtil.unescapeHtml(oimAdArticle.getContext()));
		int flag = oimAdArticleService.insertSelective(oimAdArticle);
		GenericResponse<String> genericResponse = null;
		if (flag > 0){
		    genericResponse = new GenericResponse<String>(true,"新增成功");
		    genericResponse.setData("edit");
		} else{
		    genericResponse = new GenericResponse<String>(true,"新增失败");
		}
		return genericResponse;
	}
	
	private void saveFile(OimAdArticle oimAdArticle,MultipartFile pcpcTitlePicName, MultipartFile appTitlePicName) throws FileException {
        if (pcpcTitlePicName != null && pcpcTitlePicName.getSize() > 0) {
            String picName = pcpcTitlePicName.getOriginalFilename();
            String fileName = FileUtil.spliceFileName(picName, true, true);
            FileUtil.uploadImage(pcpcTitlePicName, uploadPath, fileName, image_maxsize,
                    img_ratio_three);
            oimAdArticle.setPcTitlePic(fileName);
        }
        if (appTitlePicName != null && appTitlePicName.getSize() > 0) {
            String picName = appTitlePicName.getOriginalFilename();
            String fileName = FileUtil.spliceFileName(picName, true, true);
            FileUtil.uploadImage(appTitlePicName, uploadPath, fileName, image_maxsize,
                    img_ratio_three);
            oimAdArticle.setAppTitlePic(fileName);
        }
    }
	
	/**
	 * 跳转到编辑页面
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @return
	 */
	@RequiresPermissions("oimAdArticle:edit")
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") String id,Model model){
		OimAdArticle oimAdArticle = oimAdArticleService.selectByPrimaryKey(id);
		oimAdArticle.setContext(StringUtil.escapeHtml(oimAdArticle.getContext()));
		model.addAttribute("oimAdArticle", oimAdArticle);
		model.addAttribute("action", "edit");
		return "modules/base/oimAdArticleForm";
	}
	
	/**
	 * 跳转到查看页面
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @return
	 */
	@RequiresPermissions("oimAdArticle:view")
	@RequestMapping(value = "view/{id}", method = RequestMethod.GET)
	public String viewForm(@PathVariable("id") String id,Model model){
		OimAdArticle oimAdArticle = oimAdArticleService.selectByPrimaryKey(id);
		oimAdArticle.setContext(StringUtil.escapeHtml(oimAdArticle.getContext()));
		model.addAttribute("oimAdArticle", oimAdArticle);
		model.addAttribute("action", "view");
		return "modules/base/oimAdArticleForm";
	}
	
	/**
	 * 编辑记录
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @return
	 */
	@RequiresPermissions("oimAdArticle:edit")
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@ResponseBody
	public GenericResponse<String> edit(OimAdArticle oimAdArticle,MultipartFile pcTitlePicName, MultipartFile appTitlePicName){
	    try{
            saveFile(oimAdArticle, pcTitlePicName,appTitlePicName);
        }catch(FileException e){
            return new GenericResponse<String>(false,e.getMessage());
        }
	    oimAdArticle.setContext(StringUtil.unescapeHtml(oimAdArticle.getContext()));
		int flag = oimAdArticleService.updateByPrimaryKeySelective(oimAdArticle);
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
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @return
	 */
	@RequiresPermissions("oimAdArticle:remove")
	@RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse remove(@PathVariable("id") String id){
		int flag = oimAdArticleService.deleteByPrimaryKey(id);
		BaseResponse baseResponse = flag>=0?new BaseResponse(true,"删除成功"):new BaseResponse(false, "删除失败");
		return baseResponse;
	}
	
	@RequiresPermissions("oimAdArticle:deploy")
    @RequestMapping(value = "deploy/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public BaseResponse deploy(@PathVariable("id") String id){
        int flag = oimAdArticleService.deploy(id);
        BaseResponse baseResponse = flag>=0?new BaseResponse(true,"发布成功"):new BaseResponse(false, "发布失败");
        return baseResponse;
    }
	
	@RequiresPermissions("oimAdArticle:disable")
    @RequestMapping(value = "disable/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public BaseResponse disable(@PathVariable("id") String id){
        int flag = oimAdArticleService.setStatus(id, BaseConstant.Status.DISABLED);
        BaseResponse baseResponse = flag>=0?new BaseResponse(true,"禁用成功"):new BaseResponse(false, "禁用失败");
        return baseResponse;
    }
	
}
