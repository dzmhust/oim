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

import com.dzmsoft.acs.inner.dto.RegisterUserDto;
import com.dzmsoft.acs.inner.service.UcsService;
import com.dzmsoft.framework.base.exception.FileException;
import com.dzmsoft.framework.base.web.mvc.controller.BaseController;
import com.dzmsoft.framework.base.web.mvc.dao.MybatisExample;
import com.dzmsoft.framework.base.web.mvc.pojo.EasyUIPage;
import com.dzmsoft.framework.base.web.mvc.view.BaseResponse;
import com.dzmsoft.framework.base.web.mvc.view.Condition;
import com.dzmsoft.framework.file.util.FileUtil;
import com.dzmsoft.oim.base.pojo.OimEmployee;
import com.dzmsoft.oim.base.pojo.OimEmployeeExample;
import com.dzmsoft.oim.base.service.OimEmployeeService;
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
@RequestMapping("oimEmployee")
public class OimEmployeeController extends BaseController{
    @Value("${upload.path}")
    private String uploadPath;

    @Value("${image.maxsize}")
    private int image_maxsize;
	@Autowired
	private OimEmployeeService oimEmployeeService;
	@Autowired
	private UcsService ucsService;
	@Value("${img.ratio.three}")
    private double img_ratio_three;
	

	/**
	 * 显示主列表页面
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @return
	 */
	@RequiresPermissions("oimEmployee:find")
	@RequestMapping(value = "show", method = RequestMethod.GET)
	public String show(){
		return "modules/base/oimEmployeeList";
	}
	
	/**
	 * 主列表中查询
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @return
	 */
	@RequiresPermissions("oimEmployee:find")
	@RequestMapping(value = "find", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> find(HttpServletRequest request){
		List<Condition> conditions = Condition.buildFromHttpRequest(request);
		EasyUIPage easyUIPage = new EasyUIPage(request);
		MybatisExample mybatisExample = MybatisExample.getInstance();
		OimEmployeeExample example = (OimEmployeeExample)mybatisExample.buildExampleByCondition(conditions, easyUIPage, OimEmployeeExample.class.getName());
		PageList<OimEmployee> oimEmployees = oimEmployeeService.selectByExample(example, new PageBounds(easyUIPage.getPage(),
                easyUIPage.getRows()));
		return getEasyUIGrid(oimEmployees);
	}
	
	/**
	 * 跳转到新增页面
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @return
	 */
	@RequiresPermissions("oimEmployee:add")
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addForm(Model model){
		model.addAttribute("oimEmployee", new OimEmployee());
		model.addAttribute("action", "add");
		return "modules/base/oimEmployeeForm";
	}
	
	/**
	 * 新增记录
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @return
	 */
	@RequiresPermissions("oimEmployee:add")
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(OimEmployee oimEmployee , MultipartFile headPortrailPicName){
	 // 通过手机号向UCS发起注册账号请求
        RegisterUserDto registerUserDto = ucsService.commonRegister(
                oimEmployee.getMobile(),
                oimEmployee.getUserType(),
                oimEmployee.getName(),
                oimEmployee.getMobile());
        if (registerUserDto.isSuccess()){
            try {
                saveFile(oimEmployee, headPortrailPicName);
            } catch (FileException e) {
                return new BaseResponse(false, e.getMessage());
            }
            oimEmployee.setId(registerUserDto.getUcsId());
            int flag = oimEmployeeService.insertSelective(oimEmployee);
            return flag>0?new BaseResponse(true,"新增成功"):new BaseResponse(false, "新增失败");
        } else{
            return new BaseResponse(false, registerUserDto.getMsg());
        }
	}
	
	/**
     * 保存图片
     * 
     * @param @param oimEmployee
     * @param @param picFile
     * @param @throws FileException
     * @return void
     * @throws
     */
    private void saveFile(OimEmployee oimEmployee , MultipartFile headPortrailPicName) throws FileException {
        if (headPortrailPicName != null && headPortrailPicName.getSize() > 0) {
            String picName = headPortrailPicName.getOriginalFilename();
            String fileName = FileUtil.spliceFileName(picName, true, true);
            FileUtil.uploadImage(headPortrailPicName, uploadPath, fileName, image_maxsize,img_ratio_three);
            oimEmployee.setHeadPortrailPic(fileName);
        }
    }
	
	/**
	 * 跳转到编辑页面
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @return
	 */
	@RequiresPermissions("oimEmployee:edit")
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") String id,Model model){
		OimEmployee oimEmployee = oimEmployeeService.selectByPrimaryKey(id);
		model.addAttribute("oimEmployee", oimEmployee);
		model.addAttribute("action", "edit");
		return "modules/base/oimEmployeeForm";
	}
	
	/**
	 * 跳转到查看页面
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @return
	 */
	@RequiresPermissions("oimEmployee:view")
	@RequestMapping(value = "view/{id}", method = RequestMethod.GET)
	public String viewForm(@PathVariable("id") String id,Model model){
		OimEmployee oimEmployee = oimEmployeeService.selectByPrimaryKey(id);
		model.addAttribute("oimEmployee", oimEmployee);
		model.addAttribute("action", "view");
		return "modules/base/oimEmployeeForm";
	}
	
	/**
	 * 编辑记录
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @return
	 */
	@RequiresPermissions("oimEmployee:edit")
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse edit(OimEmployee oimEmployee , MultipartFile headPortrailPicName){
	    try {
            saveFile(oimEmployee, headPortrailPicName);
        } catch (FileException e) {
            return new BaseResponse(false, e.getMessage());
        }
		int flag = oimEmployeeService.updateByPrimaryKeySelective(oimEmployee);
		BaseResponse baseResponse = flag>0?new BaseResponse(true,"编辑成功"):new BaseResponse(false, "编辑失败");
		return baseResponse;
	}
	
	/**
	 * 删除记录
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @return
	 */
	@RequiresPermissions("oimEmployee:remove")
	@RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse remove(@PathVariable("id") String id){
		int flag = oimEmployeeService.deleteByPrimaryKey(id);
		BaseResponse baseResponse = flag>=0?new BaseResponse(true,"删除成功"):new BaseResponse(false, "删除失败");
		return baseResponse;
	}
}
