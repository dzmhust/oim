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
import com.dzmsoft.oim.base.dto.OperateCityDto;
import com.dzmsoft.oim.base.pojo.OimCard;
import com.dzmsoft.oim.base.pojo.OimCleanBag;
import com.dzmsoft.oim.base.pojo.OimCleanBagLine;
import com.dzmsoft.oim.base.pojo.OimHouseholdPriceRule;
import com.dzmsoft.oim.base.pojo.OimNewhomePriceRule;
import com.dzmsoft.oim.base.pojo.OimPersonRequire;
import com.dzmsoft.oim.base.pojo.OimPersonRequireLine;
import com.dzmsoft.oim.base.service.OimAdminRegionService;
import com.dzmsoft.oim.base.service.OimCardService;
import com.dzmsoft.oim.base.service.OimCleanBagLineService;
import com.dzmsoft.oim.base.service.OimCleanBagService;
import com.dzmsoft.oim.base.service.OimHouseholdPriceRuleService;
import com.dzmsoft.oim.base.service.OimNewhomePriceRuleService;
import com.dzmsoft.oim.base.service.OimPersonRequireLineService;
import com.dzmsoft.oim.base.service.OimPersonRequireService;
import com.dzmsoft.oim.rest.base.dto.PriceRuleDto;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@RestController
@RequestMapping("rest/clean")
public class OimRestCleanController {
    @Autowired
    private OimCardService oimCardService;
    @Autowired
    private OimAdminRegionService oimAdminRegionService;
    @Autowired
    private OimPersonRequireService oimPersonRequireService;
    @Autowired
    private OimPersonRequireLineService oimPersonRequireLineService;
    @Autowired
    private OimCleanBagService oimCleanBagService;
    @Autowired
    private OimCleanBagLineService oimCleanBagLineService;
    @Autowired
    private OimHouseholdPriceRuleService oimHouseholdPriceRuleService;
    @Autowired
    private OimNewhomePriceRuleService oimNewhomePriceRuleService;
    
    
    /**
     * 获取计次卡清单
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "clean01", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ValidateGroup(
            fileds ={
                    @ValidateField(index=0 ,notNull=true ),
                    @ValidateField(index=1 ,notNull=true )
            }
    )
    public GenericResponse<PageList<OimCard>> getOimCards(Integer page, Integer rows){
        PageList<OimCard> oimCards = oimCardService.selectByExample(null, new PageBounds(page, rows));
        GenericResponse<PageList<OimCard>> genericResponse = new GenericResponse<PageList<OimCard>>(true);
        genericResponse.setData(oimCards);
        return genericResponse;
    }
    
    /**
     * 获取计次卡详情
     * @param id
     * @return
     */
    @RequestMapping(value = "clean02/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public GenericResponse<OimCard> getOimCardDetail(@PathVariable String id){
        OimCard oimCard = oimCardService.selectByPrimaryKey(id);
        GenericResponse<OimCard> genericResponse = new GenericResponse<OimCard>(true);
        genericResponse.setData(oimCard);
        return genericResponse;
    }
    
    /**
     * 根据id，获取家庭保洁计价规则
     * @param city
     * @return
     */
    @RequestMapping(value = "clean03/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public GenericResponse<OimHouseholdPriceRule> getOimHouseholdPriceRuleDetail(@PathVariable("id") String id){
        OimHouseholdPriceRule oimHouseholdPriceRule = oimHouseholdPriceRuleService.selectByPrimaryKey(id);
        GenericResponse<OimHouseholdPriceRule> genericResponse = new GenericResponse<OimHouseholdPriceRule>(true);
        genericResponse.setData(oimHouseholdPriceRule);
        return genericResponse;
    }
    
    /**
     * 根据城市，获取新居开荒计价规则
     * @param city
     * @return
     */
    @RequestMapping(value = "clean04/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public GenericResponse<OimNewhomePriceRule> getOimNewhomePriceRuleDetail(@PathVariable("id") String id){
        OimNewhomePriceRule oimNewhomePriceRule = oimNewhomePriceRuleService.selectByPrimaryKey(id);
        GenericResponse<OimNewhomePriceRule> genericResponse = new GenericResponse<OimNewhomePriceRule>(true);
        genericResponse.setData(oimNewhomePriceRule);
        return genericResponse;
    }
    
    /**
     * 获取运营区域
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "clean05", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ValidateGroup(
            fileds ={
                    @ValidateField(index=0 ,notNull=true ),
                    @ValidateField(index=1 ,notNull=true )
            }
    )
    public GenericResponse<PageList<OperateCityDto>>  getOperateCitys(Integer page, Integer rows){
        PageList<OperateCityDto> operateCityDtos = oimAdminRegionService.selectOperateCityDto(new PageBounds(page, rows));
        GenericResponse<PageList<OperateCityDto>> genericResponse = new GenericResponse<PageList<OperateCityDto>>(true);
        genericResponse.setData(operateCityDtos);
        return genericResponse;
    }
    
    /**
     * 获取个性需求清单
     * @return
     */
    @RequestMapping(value = "clean06/{cityName}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public GenericResponse<List<OimPersonRequireLine>> getOimPersonRequire(@PathVariable String cityName){
        OimPersonRequire oimPersonRequire = oimPersonRequireService.selectByCityName(cityName);
        if (oimPersonRequire == null)
            return new GenericResponse<List<OimPersonRequireLine>>(false, "无可选的个性需求");
        List<OimPersonRequireLine> oimPersonRequireLines = oimPersonRequireLineService.selectByMain(oimPersonRequire.getId());
        GenericResponse<List<OimPersonRequireLine>> genericResponse = new GenericResponse<List<OimPersonRequireLine>>(true);
        genericResponse.setData(oimPersonRequireLines);
        return genericResponse; 
    }
    
    /**
     * 获取清洁包清单
     * @return
     */
    @RequestMapping(value = "clean07/{cityName}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public GenericResponse<List<OimCleanBagLine>> getOimCleanBagLine(@PathVariable String cityName){
        OimCleanBag oimCleanBag = oimCleanBagService.selectByCityName(cityName);
        if (oimCleanBag == null)
            return new GenericResponse<List<OimCleanBagLine>>(false, "无可选的清洁包");
        List<OimCleanBagLine> oimCleanBagLines = oimCleanBagLineService.selectByMain(oimCleanBag.getId());
        GenericResponse<List<OimCleanBagLine>> genericResponse = new GenericResponse<List<OimCleanBagLine>>(true);
        genericResponse.setData(oimCleanBagLines);
        return genericResponse; 
    }
    
    /**
     * 根据城市获取家庭保洁计价规则标题
     * @param cityName
     * @return
     */
    @RequestMapping(value = "clean08/{cityName}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public GenericResponse<PriceRuleDto> getOimHouseholdPriceRuleTitle(@PathVariable("cityName") String cityName){
        OimHouseholdPriceRule oimHouseholdPriceRule = oimHouseholdPriceRuleService.selectByCityName(cityName);
        GenericResponse<PriceRuleDto> genericResponse = new GenericResponse<PriceRuleDto>(true);
        if (oimHouseholdPriceRule != null){
            PriceRuleDto priceRuleDto = new PriceRuleDto(oimHouseholdPriceRule.getId(), oimHouseholdPriceRule.getName(), oimHouseholdPriceRule.getPrice());
            genericResponse.setData(priceRuleDto);
        }
        return genericResponse;
    }
    
    /**
     * 根据城市，获取新居开荒计价规则标题
     * @param city
     * @return
     */
    @RequestMapping(value = "clean09/{cityName}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public GenericResponse<PriceRuleDto> getOimNewhomePriceRuleTitle(@PathVariable("cityName") String cityName){
        OimNewhomePriceRule oimNewhomePriceRule = oimNewhomePriceRuleService.selectByCityName(cityName);
        GenericResponse<PriceRuleDto> genericResponse = new GenericResponse<PriceRuleDto>(true);
        if (oimNewhomePriceRule != null){
            PriceRuleDto priceRuleDto = new PriceRuleDto(oimNewhomePriceRule.getId(), oimNewhomePriceRule.getName(), oimNewhomePriceRule.getPrice());
            genericResponse.setData(priceRuleDto);
        }
        return genericResponse;
    }
}
