package com.dzmsoft.oim.rest.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dzmsoft.framework.base.web.mvc.view.GenericResponse;
import com.dzmsoft.oim.base.pojo.OimAdArticle;
import com.dzmsoft.oim.base.service.OimAdArticleService;

@RestController
@RequestMapping("rest/common")
public class OimRestCommonController {
    @Autowired
    private OimAdArticleService oimAdArticleService;

    /**
     * 根据位置获取单条文章
     * @return
     */
    @RequestMapping(value = "common01/{position}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public GenericResponse<OimAdArticle> getOimAdArticle(@PathVariable String position){
        OimAdArticle oimAdArticle = oimAdArticleService.selectOimAdArticle(position);
        GenericResponse<OimAdArticle> genericResponse = new GenericResponse<OimAdArticle>(true);
        genericResponse.setData(oimAdArticle);
        return genericResponse;
    }
    
    /**
     * 根据位置获取多条文章
     * @return
     */
    @RequestMapping(value = "common02/{position}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public GenericResponse<List<OimAdArticle>> getOimAdArticles(@PathVariable String position){
        List<OimAdArticle> oimAdArticles = oimAdArticleService.selectOimAdArticles(position);
        GenericResponse<List<OimAdArticle>> genericResponse = new GenericResponse<List<OimAdArticle>>(true);
        genericResponse.setData(oimAdArticles);
        return genericResponse;
    }
}
