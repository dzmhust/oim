package com.dzmsoft.oim.rest.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dzmsoft.framework.base.web.mvc.controller.validate.ValidateField;
import com.dzmsoft.framework.base.web.mvc.controller.validate.ValidateGroup;
import com.dzmsoft.framework.base.web.mvc.view.GenericResponse;
import com.dzmsoft.framework.file.util.ImageUtil;
import com.dzmsoft.oim.base.pojo.OimAdArticle;
import com.dzmsoft.oim.base.pojo.OimMember;
import com.dzmsoft.oim.base.pojo.OimMemberAddress;
import com.dzmsoft.oim.base.pojo.OimSupplier;
import com.dzmsoft.oim.base.service.OimAdArticleService;
import com.dzmsoft.oim.base.service.OimMemberAddressService;
import com.dzmsoft.oim.base.service.OimMemberService;
import com.dzmsoft.oim.base.service.OimSupplierService;
import com.google.gson.Gson;

@RestController
@RequestMapping("rest/base")
public class OimRestBaseController {
    @Autowired
    Gson gson = new Gson();
    @Autowired
    private OimMemberService oimMemberService;
    @Autowired
    private OimMemberAddressService oimMemberAddressService;
    @Autowired
    private OimAdArticleService oimAdArticleService;
    @Autowired
    private OimSupplierService oimSupplierService;
    
    /**
     * 新增会员
     * @param oimMember
     * @return
     */
    @RequestMapping(value = "base01", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ValidateGroup(fileds = { @ValidateField(index = 0, notNull = true),
            @ValidateField(index = 0, notNull = true, fieldName = "mobile"),
            @ValidateField(index = 0, notNull = true, fieldName = "ucsId") })
    public String addOimMember(OimMember oimMember) {
        int flag = oimMemberService.insertSelective(oimMember);
        GenericResponse<String> genericResponse = null;
        if (flag > 0) {
            genericResponse  = new GenericResponse<String>(true, "新增成功");
        } else{
            genericResponse  = new GenericResponse<String>(true, "新增失败");
        }
        return gson.toJson(genericResponse);
    }
    
    /**
     * 修改会员
     * @param oimMember
     * @return
     */
    @RequestMapping(value = "base02", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ValidateGroup(fileds = { @ValidateField(index = 0, notNull = true),
            @ValidateField(index = 0, notNull = true, fieldName = "id") })
    public String editOimMember(OimMember oimMember) {
        int flag = oimMemberService.updateByPrimaryKeySelective(oimMember);
        GenericResponse<String> genericResponse = null;
        if (flag > 0) {
            genericResponse  = new GenericResponse<String>(true, "修改成功");
        } else{
            genericResponse  = new GenericResponse<String>(true, "修改失败");
        }
        return gson.toJson(genericResponse);
    }
    
    @RequestMapping(value = "base03/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getOimMember(@PathVariable String id){
        OimMember oimMember = oimMemberService.selectByPrimaryKey(id);
        GenericResponse<OimMember> genericResponse = new GenericResponse<OimMember>(true);
        genericResponse.setData(oimMember);
        return gson.toJson(genericResponse);
    }
    
    /**
     * 新增服务地址
     * @param oimMemberAddress
     * @return
     */
    @RequestMapping(value = "base04", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ValidateGroup(fileds = { @ValidateField(index = 0, notNull = true),
            @ValidateField(index = 0, notNull = true, fieldName = "shortAddress"),
            @ValidateField(index = 0, notNull = true, fieldName = "ucsId") })
    public String addOimMemberAddress(OimMemberAddress oimMemberAddress){
        int flag = oimMemberAddressService.insertSelective(oimMemberAddress);
        GenericResponse<String> genericResponse = null;
        if (flag > 0) {
            genericResponse  = new GenericResponse<String>(true, "新增成功");
        } else{
            genericResponse  = new GenericResponse<String>(true, "新增失败");
        }
        return gson.toJson(genericResponse);
    }
    
    
    /**
     * 修改会员
     * @param oimMember
     * @return
     */
    @RequestMapping(value = "base05", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ValidateGroup(fileds = { @ValidateField(index = 0, notNull = true),
            @ValidateField(index = 0, notNull = true, fieldName = "id") })
    public String editOimMemberAddress(OimMemberAddress oimMemberAddress) {
        int flag = oimMemberAddressService.updateByPrimaryKeySelective(oimMemberAddress);
        GenericResponse<String> genericResponse = null;
        if (flag > 0) {
            genericResponse  = new GenericResponse<String>(true, "修改成功");
        } else{
            genericResponse  = new GenericResponse<String>(true, "修改失败");
        }
        return gson.toJson(genericResponse);
    }
    
    /**
     * 删除服务地址
     * @param oimMember
     * @return
     */
    @RequestMapping(value = "base06/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public String removeOimMemberAddress(@PathVariable String id) {
        int flag = oimMemberAddressService.deleteByPrimaryKey(id);
        GenericResponse<String> genericResponse = null;
        if (flag > 0) {
            genericResponse  = new GenericResponse<String>(true, "删除成功");
        } else{
            genericResponse  = new GenericResponse<String>(true, "删除失败");
        }
        return gson.toJson(genericResponse);
    }
    
    /**
     * 获取服务地址清单
     * @param oimMember
     * @return
     */
    @RequestMapping(value = "base07/{ucsId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getOimMemberAddress(@PathVariable String ucsId) { 
        List<OimMemberAddress> oimMemberAddresses = oimMemberAddressService.selectOimMemberAddresses(ucsId);
        GenericResponse<List<OimMemberAddress>> genericResponse = new GenericResponse<List<OimMemberAddress>>(true);
        genericResponse.setData(oimMemberAddresses);
        return gson.toJson(genericResponse);
    }
    
    /**
     * 根据位置获取单条文章
     * @return
     */
    @RequestMapping(value = "base08/{position}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getOimAdArticle(@PathVariable String position){
        OimAdArticle oimAdArticle = oimAdArticleService.selectOimAdArticle(position);
        GenericResponse<OimAdArticle> genericResponse = new GenericResponse<OimAdArticle>(true);
        genericResponse.setData(oimAdArticle);
        return gson.toJson(genericResponse);
    }
    
    /**
     * 根据位置获取多条文章
     * @return
     */
    @RequestMapping(value = "base09/{position}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getOimAdArticles(@PathVariable String position){
        List<OimAdArticle> oimAdArticles = oimAdArticleService.selectOimAdArticles(position);
        GenericResponse<List<OimAdArticle>> genericResponse = new GenericResponse<List<OimAdArticle>>(true);
        genericResponse.setData(oimAdArticles);
        return gson.toJson(genericResponse);
    }
    
    /**
     * 根据ucsId获取供应商信息
     * @param ucsId
     * @return
     */
    @RequestMapping(value = "base10/{ucsId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getOimSupplier(@PathVariable String ucsId){
        OimSupplier oimSupplier = oimSupplierService.selectOimSupplier(ucsId);
        GenericResponse<OimSupplier> genericResponse = new GenericResponse<OimSupplier>(true);
        genericResponse.setData(oimSupplier);
        return gson.toJson(genericResponse);
    }
    
    /**
     * 更改会员头像
     * @param ucsId
     * @param headerPic
     * @return
     */
    @RequestMapping(value = "base11/{ucsId}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ValidateGroup(fileds = { @ValidateField(index = 1, notNull = true) })
    public String updateMemberPic(@PathVariable String ucsId, String headerPic){
        String imagepath="";
        ImageUtil.GenerateImage(headerPic, imagepath);
        int flag = oimMemberService.updateHeaderPic(ucsId, imagepath);
        GenericResponse<String> genericResponse = flag>0?new GenericResponse<String>(true):new GenericResponse<String>(false, "更新沟通下那个失败");
        return gson.toJson(genericResponse);
    }
}
