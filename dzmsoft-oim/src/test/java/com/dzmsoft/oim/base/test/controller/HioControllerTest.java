package com.dzmsoft.oim.base.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.dzmsoft.framework.base.util.HttpUtil;

public class HioControllerTest {
    @Test
    public void getLatestApp(){
        String uri = "http://192.168.4.187:8096/hio/rest/hio01";
        Map<String,String> params = new HashMap<String,String>();
        params.put("packageName", "com.dzmsoft.hh.walle.client");
        String result = HttpUtil.doGet(uri, params, 10000);
        System.out.println(result);
    }
}
