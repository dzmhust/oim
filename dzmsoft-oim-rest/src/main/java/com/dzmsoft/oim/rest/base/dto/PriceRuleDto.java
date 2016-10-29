package com.dzmsoft.oim.rest.base.dto;

import java.math.BigDecimal;

/**
 * 计价规则
 * @author dzm
 */
public class PriceRuleDto {
    private String id;
    private String name;
    private BigDecimal price;
    
    public PriceRuleDto(){
        
    }
    
    public PriceRuleDto(String id, String name, BigDecimal price){
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
