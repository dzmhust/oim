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

import com.dzmsoft.framework.base.exception.FileException;
import com.dzmsoft.framework.base.web.mvc.controller.BaseController;
import com.dzmsoft.framework.base.web.mvc.dao.MybatisExample;
import com.dzmsoft.framework.base.web.mvc.pojo.EasyUIPage;
import com.dzmsoft.framework.base.web.mvc.view.BaseResponse;
import com.dzmsoft.framework.base.web.mvc.view.Condition;
import com.dzmsoft.framework.file.util.FileUtil;
import com.dzmsoft.oim.base.common.OimBaseConstant;
import com.dzmsoft.oim.base.pojo.OimSupplier;
import com.dzmsoft.oim.base.pojo.OimSupplierExample;
import com.dzmsoft.oim.base.service.OimSupplierService;
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
@RequestMapping("oimSupplier")
public class OimSupplierController extends BaseController{
	@Autowired
	private OimSupplierService oimSupplierService;
	@Value("${upload.path}")
    private String uploadPath;
    @Value("${image.maxsize}")
    private int image_maxsize;
    @Value("${img_ratio}")
    private Double img_ratio;

	/**
	 * 显示主列表页面
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @return
	 */
	@RequiresPermissions("oimSupplier:find")
	@RequestMapping(value = "show", method = RequestMethod.GET)
	public String show(){
		return "modules/base/oimSupplierList";
	}
	
	/**
	 * 主列表中查询
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @return
	 */
	@RequiresPermissions("oimSupplier:find")
	@RequestMapping(value = "find", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> find(HttpServletRequest request){
		List<Condition> conditions = Condition.buildFromHttpRequest(request);
		EasyUIPage easyUIPage = new EasyUIPage(request);
		MybatisExample mybatisExample = MybatisExample.getInstance();
		OimSupplierExample example = (OimSupplierExample)mybatisExample.buildExampleByCondition(conditions, easyUIPage, OimSupplierExample.class.getName());
		PageList<OimSupplier> oimSuppliers = oimSupplierService.selectByExample(example, new PageBounds(easyUIPage.getPage(),
                easyUIPage.getRows()));
		return getEasyUIGrid(oimSuppliers);
	}
	
	/**
	 * 跳转到新增页面
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @return
	 */
	@RequiresPermissions("oimSupplier:add")
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addForm(Model model){
		model.addAttribute("oimSupplier", new OimSupplier());
		model.addAttribute("action", "add");
		return "modules/base/oimSupplierForm";
	}
	
	/**
	 * 新增记录
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @return
	 */
	@RequiresPermissions("oimSupplier:add")
	@RequestMapping(value = "add", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse add(OimSupplier oimSupplier, MultipartFile logoPicName){
	    try {
            saveFile(oimSupplier, logoPicName);
        } catch (FileException e) {
            return new BaseResponse(false, e.getMessage());
        }
//        oimSupplier.setUcsId(registerUserDto.getUcsId());
        oimSupplier.setStatus(OimBaseConstant.PartnerStatus.JOIN);
        int flag = oimSupplierService.insertSelective(oimSupplier);
        BaseResponse baseResponse = flag>0?new BaseResponse(true,"新增成功"):new BaseResponse(false, "新增失败");
        return baseResponse;
	 // 通过手机号向UCS发起注册账号请求
//        RegisterUserDto registerUserDto = ucsService.commonRegister(
//                oimSupplier.getChiefPhone(),
//                oimSupplier.getSupplierType(),
//                oimSupplier.getName(),
//                oimSupplier.getChiefPhone());
//        if (registerUserDto.isSuccess()){
//            try {
//                saveFile(oimSupplier, logoPicName);
//            } catch (FileException e) {
//                return new BaseResponse(false, e.getMessage());
//            }
//            oimSupplier.setUcsId(registerUserDto.getUcsId());
//            oimSupplier.setStatus(OimBaseConstant.PartnerStatus.JOIN);
//            int flag = oimSupplierService.insertSelective(oimSupplier);
//            BaseResponse baseResponse = flag>0?new BaseResponse(true,"新增成功"):new BaseResponse(false, "新增失败");
//            return baseResponse;
//        } else{
//            return new BaseResponse(false, registerUserDto.getMsg());
//        }
		
	}
	
	private void saveFile(OimSupplier oimSupplier, MultipartFile logoPicName) throws FileException {
        if (logoPicName != null && logoPicName.getSize() > 0) {
            String picName = logoPicName.getOriginalFilename();
            String fileName = FileUtil.spliceFileName(picName, true, true);
            FileUtil.uploadImage(logoPicName, uploadPath, fileName, image_maxsize,
                    img_ratio);
            oimSupplier.setLogoPic(fileName);
        }
    }
	
	/**
	 * 跳转到编辑页面
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @return
	 */
	@RequiresPermissions("oimSupplier:edit")
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable("id") String id,Model model){
		OimSupplier oimSupplier = oimSupplierService.selectByPrimaryKey(id);
		model.addAttribute("oimSupplier", oimSupplier);
		model.addAttribute("action", "edit");
		return "modules/base/oimSupplierForm";
	}
	
	/**
	 * 跳转到查看页面
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @return
	 */
	@RequiresPermissions("oimSupplier:view")
	@RequestMapping(value = "view/{id}", method = RequestMethod.GET)
	public String viewForm(@PathVariable("id") String id,Model model){
		OimSupplier oimSupplier = oimSupplierService.selectByPrimaryKey(id);
		model.addAttribute("oimSupplier", oimSupplier);
		model.addAttribute("action", "view");
		return "modules/base/oimSupplierForm";
	}
	
	/**
	 * 编辑记录
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @return
	 */
	@RequiresPermissions("oimSupplier:edit")
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	@ResponseBody
	public BaseResponse edit(OimSupplier oimSupplier, MultipartFile logoPicName){
	    try {
            saveFile(oimSupplier, logoPicName);
        } catch (FileException e) {
            return new BaseResponse(false, e.getMessage());
        }
		int flag = oimSupplierService.updateByPrimaryKeySelective(oimSupplier);
		BaseResponse baseResponse = flag>0?new BaseResponse(true,"编辑成功"):new BaseResponse(false, "编辑失败");
		return baseResponse;
	}
	
	/**
	 * 删除记录
	 * @dzmsoftgenerated 2016-04-26 14:23:38
	 * @return
	 */
	@RequiresPermissions("oimSupplier:remove")
	@RequestMapping(value = "remove/{id}", method = RequestMethod.GET)
	@ResponseBody
	public BaseResponse remove(@PathVariable("id") String id){
		int flag = oimSupplierService.deleteByPrimaryKey(id);
		BaseResponse baseResponse = flag>=0?new BaseResponse(true,"删除成功"):new BaseResponse(false, "删除失败");
		return baseResponse;
	}
	
	/**
	 * 加盟
	 * @param id
	 * @return
	 */
	@RequiresPermissions("oimSupplier:join")
    @RequestMapping(value = "join/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public BaseResponse join(@PathVariable String id){
        int flag = oimSupplierService.join(id);
        BaseResponse baseResponse = flag>0?new BaseResponse(true,"加盟成功"):new BaseResponse(false, "加盟失败");
        return baseResponse;
    }
	
	/**
	 * 解约
	 * @param id
	 * @return
	 */
	@RequiresPermissions("oimSupplier:release")
    @RequestMapping(value = "release/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public BaseResponse release(@PathVariable String id){
        int flag = oimSupplierService.release(id);
        BaseResponse baseResponse = flag>0?new BaseResponse(true,"解约成功"):new BaseResponse(false, "解约失败");
        return baseResponse;
    }
}
