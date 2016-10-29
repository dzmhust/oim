package com.dzmsoft.oim.base.dto;

/**
 * 运营区域
 * @author dzm
 */
public class OperateCityDto {
    private String cityCode;
    private String cityName;
    
    public String getCityCode() {
        return cityCode;
    }
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
